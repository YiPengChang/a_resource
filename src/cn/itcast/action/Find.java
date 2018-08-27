package cn.itcast.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import cn.itcast.domain.UpFile;
import cn.itcast.serciceimple.uploadserviceimple;

public class Find {
	private String str;
	public void setStr(String str) {
		this.str = str;
	}
	public String getAll(){
		uploadserviceimple s = new uploadserviceimple();
		List list = s.getAll();
		ActionContext.getContext().put("list", list);
		return "download";
	}
	public String like(){
		HttpServletRequest request = ServletActionContext.getRequest();
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(str==null || str.trim().equals("")  ){
			return "getAll";
		}
		uploadserviceimple s = new uploadserviceimple();
		List<UpFile> list = s.findlike(str);
		request.setAttribute("list", list);
		request.setAttribute("str", str);
		return "download";
	}
}
