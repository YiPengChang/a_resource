package cn.itcast.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLEncoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import cn.itcast.domain.UpFile;
import cn.itcast.serciceimple.uploadserviceimple;

import com.opensymphony.xwork2.ActionSupport;

public class Downfile extends ActionSupport{
	private String id;
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String execute() throws Exception {
		
		uploadserviceimple s = new uploadserviceimple();
		
		UpFile file = s.find(id);
		if(file==null){
			return "getAll";
		}
		String realname = file.getRealname();
		String savepath = file.getSavepath();
		String uuidname = file.getUuidname();
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("content-disposition", "attachment;filename="+URLEncoder.encode(realname, "UTF-8"));
		ServletOutputStream out = response.getOutputStream();
		File f = new File(savepath+File.separator+uuidname);
		
		InputStream in = new FileInputStream(f);
		int len;
		byte[] b = new byte[1024]; 
		while((len=in.read(b))>0){
			out.write(b, 0, len);
		}
		in.close();
	    
		out.close();
		return "download";
	}

	
}
