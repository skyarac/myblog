package org.wetuo.validation.action;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;

public class ImageResult implements Result {
	private static final long serialVersionUID = 2115543537638071458L;

	public void execute(ActionInvocation ai) throws Exception {
       ValidationCodeAction action = (ValidationCodeAction)ai.getAction();
       HttpServletResponse response = ServletActionContext.getResponse();
       response.setHeader("Pragma", "No-cache"); 
       response.setHeader("Cache-Control", "no-cache"); 
       response.setDateHeader("Expires", 0); 
       response.setHeader("Cash", "no cash");
       response.setContentType(action.getContentType());
       response.setContentLength(action.getContentLength());
       response.getOutputStream().write(action.getImageBytes());
       response.getOutputStream().flush();
    }
}


