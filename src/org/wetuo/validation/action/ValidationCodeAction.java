package org.wetuo.validation.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import java.util.Random;
import java.awt.*;
import java.awt.image.*;
import java.io.ByteArrayOutputStream;
import org.apache.struts2.interceptor.SessionAware;

public class ValidationCodeAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 8516414539884282786L;
	private Map<String, Object> session;
	/**
	 * 
	 * 验证码对应的Session名
	 */
	private static final String SessionName = "validationCode";

	/**
	 * 
	 * 用于生成随机数的随机数生成器
	 */
	private byte[] bytes = null;
	private String contentType = "image/png";

	public byte[] getImageBytes() {
		return this.bytes;
	}

	public String getContentType() {
		return this.contentType;
	}

	public void setContentType(String value) {
		this.contentType = value;
	}

	public int getContentLength() {
		return bytes.length;
	}

	/**
	 * 生成随机颜色
	 * 
	 * @param fc
	 * @param bc
	 * @return
	 */
	private Color getRandColor(int fc, int bc)
    {
        Random random = new Random();
        if (fc > 255) fc = 255;
        if (bc > 255) bc = 255;
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }


	/**
	 * 
	 * 在内存中生成打印了随机字符串的图片
	 * 
	 * @return 在内存中创建的打印了字符串的图片
	 */
	private BufferedImage createImage() {
		// 设置图片的长宽
		int width = 70, height = 27;
		// 设置备选字符
		String base = "ABCDEFGHJKLMNPQRSTUVWXYZ23456789abcdefghijkmnpqrstuvwxyz";
		// 备选字符的长度
		int length = base.length();
		// 创建内存图像
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		// 获取图形上下文
		Graphics g = image.getGraphics();
		// 创建随机类的实例
		Random random = new Random();
		// 设定图像背景色(因为是做背景，所以偏淡)
		g.setColor(getRandColor(200, 250));
		g.fillRect(0, 0, width, height);
		// 备选字体
		String[] fontTypes = { "\u5b8b\u4f53", "\u65b0\u5b8b\u4f53",
				"\u9ed1\u4f53", "\u6977\u4f53", "\u96b6\u4e66" };
		int fontTypesLength = fontTypes.length;
		g.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		//随机产生155条干扰线
		g.setColor(getRandColor(160, 200));
        for (int i = 0; i < 155; i++)
        {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            g.drawLine(x, y, x + xl, y + yl);
        }
		// 取随机产生的认证码,保存生成的字符串
		String sRand = "";
		for (int i = 0; i < 4; i++) {
			int start = random.nextInt(length);
			String rand = base.substring(start, start + 1);
			sRand += rand;
			// 设置字体的颜色
			g.setColor(getRandColor(10, 150));
			// 设置字体
			g.setFont(new Font(fontTypes[random.nextInt(fontTypesLength)],
					Font.BOLD, 17 + random.nextInt(4)));
			// 将此字符画到图片上
			g.drawString(rand, (12 * i + 8 + random.nextInt(4)),17);
		}
		// 将认证码存入session
		session.put(SessionName, sRand);
		g.dispose();

		return image;
	}

	/**
	 * 
	 * 根据图片创建字节数组
	 * 
	 * @param image
	 * 用于创建字节数组的图片
	 */
	private void generatorImageBytes(BufferedImage image) {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			javax.imageio.ImageIO.write(image, "jpg", bos);
			this.bytes = bos.toByteArray();
		} catch (Exception ex) {
		} finally {
			try {
				bos.close();
			} catch (Exception ex1) {
			}
		}
	}

	/**
	 * 
	 * 被struts2过滤器调用的方法
	 * 
	 * @return 永远返回字符串"image"
	 */

	public String doDefault() {
		BufferedImage image = this.createImage();
		this.generatorImageBytes(image);
		return "image";
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
