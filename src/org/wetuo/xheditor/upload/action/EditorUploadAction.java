package org.wetuo.xheditor.upload.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.wetuo.util.Configuration;
import org.wetuo.util.DateUtils;
import org.wetuo.util.StringUtils;
import org.wetuo.util.WebUtils;

import com.opensymphony.xwork2.ActionSupport;

public class EditorUploadAction extends ActionSupport {
	private static final long serialVersionUID = 6439677629245507851L;
	private File filedata;
	private String filedataFileName;
	private String err;
	private String msg;
	private int immediate;
	
	public String upload(){
		String year = DateUtils.getDefaultInstance().formatYear();
		String month = DateUtils.getDefaultInstance().formatMonth();
		String savePath = WebUtils.getDefaultInstance().getRealPath()+"upload/"+year+"/"+month+"/";//构建上传文件真实目录
		String newFileName = StringUtils.getDefaultInstance().getNewFileName(filedataFileName);//生成新的文件名
		String upFileURL = WebUtils.getDefaultInstance().getBasePath()+"upload/"+year+"/"+month+"/"+newFileName;//生成上传文件URL路径
		File savefile = new File(new File(savePath),newFileName);
		if(!savefile.getParentFile().exists()) savefile.getParentFile().mkdirs();
		if(this.immediate == 1){
			String upExt = Configuration.getInstance().getValue("upImgExt");
			if(StringUtils.getDefaultInstance().checkUpExtName(filedataFileName, upExt)){
				if(this.filedata!=null){
					try {
						FileUtils.copyFile(filedata,savefile);
						this.err="";
						this.msg=upFileURL;//URL路径前加上!表示立即上传模式
					} catch (IOException e) {
						this.err="文件上传失败！";
						this.msg="";
						e.printStackTrace();
					}
				}else{
					this.err="文件上传失败！";
					this.msg="";
				}
			}else{
				this.err="上传文件类型只能是：" + upExt;
				this.msg="";
			}
		}else if(this.immediate == 2){
			String upExt = Configuration.getInstance().getValue("upFileExt");
			if(StringUtils.getDefaultInstance().checkUpExtName(filedataFileName, upExt)){
				if(this.filedata!=null){
					try {
						FileUtils.copyFile(filedata,savefile);
						this.err="";
						this.msg=upFileURL;//URL路径前加上!表示立即上传模式
					} catch (IOException e) {
						this.err="文件上传失败！";
						this.msg="";
						e.printStackTrace();
					}
				}else{
					this.err="文件上传失败！";
					this.msg="";
				}
			}else{
				this.err="上传文件类型只能是：" + upExt;
				this.msg="";
			}
		}else{
			if(this.filedata!=null){
				try {
					FileUtils.copyFile(filedata,savefile);
					this.err="";
					this.msg=upFileURL;//URL路径前加上!表示立即上传模式
				} catch (IOException e) {
					this.err="文件上传失败！";
					this.msg="";
					e.printStackTrace();
				}
			}else{
				this.err="文件上传失败！";
				this.msg="";
			}
		}
		
		try {
			ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
			PrintWriter out = ServletActionContext.getResponse().getWriter();
			out.write("{\"err\":\"" + this.err + "\",\"msg\":\""  + this.msg + "\"}");
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return NONE;
	}
	
	public File getFiledata() {
		return filedata;
	}
	public void setFiledata(File filedata) {
		this.filedata = filedata;
	}
	public String getFiledataFileName() {
		return filedataFileName;
	}
	public void setFiledataFileName(String filedataFileName) {
		this.filedataFileName = filedataFileName;
	}
	public String getErr() {
		return err;
	}
	public void setErr(String err) {
		this.err = err;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getImmediate() {
		return immediate;
	}
	public void setImmediate(int immediate) {
		this.immediate = immediate;
	}
}
