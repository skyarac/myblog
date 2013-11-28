package org.wetuo.util;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 * <p>页面静态化辅助方法<p>
 * @author LH
 * 
 */
public class CreateStaticHTML {
	public static void createHTML4Mapping(HttpServletRequest request,
			HttpServletResponse response, String jsp_url, String html_url) {
		FileOutputStream fos = null;

		try {

			ServletContext sc = request.getSession().getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher(jsp_url);
			final ByteArrayOutputStream os = new ByteArrayOutputStream();
			final ServletOutputStream stream = new ServletOutputStream() {
				public void write(byte[] data, int offset, int length) {
					os.write(data, offset, length);
				}

				public void write(int b) throws IOException {
					os.write(b);
				}
			};
			final PrintWriter pw = new PrintWriter(new OutputStreamWriter(os));
			HttpServletResponse rep = new HttpServletResponseWrapper(response) {
				public ServletOutputStream getOutputStream() {
					return stream;
				}

				public PrintWriter getWriter() {
					return pw;
				}
			};

			rd.include(request, rep);
			pw.flush();
			fos = new FileOutputStream(html_url);
			os.writeTo(fos);

		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
