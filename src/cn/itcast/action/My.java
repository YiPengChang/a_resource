package cn.itcast.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.itcast.domain.UpFile;
import cn.itcast.domain.UpFile_User;
import cn.itcast.domain.User;
import cn.itcast.serciceimple.uploadserviceimple;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class My extends ActionSupport {
	private String id;
	public void setId(String id) {
		this.id = id;
	}
	public String UI() throws Exception {
		return "my";
	}
	public String myuploadfile() throws Exception {
		User user = (User) ActionContext.getContext().getSession().get("user");
		uploadserviceimple s = new uploadserviceimple();
		 List<UpFile_User> list = s.finduser_upfile_user(user);
		 List<UpFile> files = new ArrayList();
		 if(list!=null){
			 for(UpFile_User uf:list){
				 if(uf.getFlag().equals("上传")){
					 files.add(s.find(uf.getUpfile_id()));
					 
				 }
			 }
		 }
		 ActionContext.getContext().put("list", files);
		return "myuploadfile";
	}
	public String baocun() throws Exception {
		uploadserviceimple s = new uploadserviceimple();
		UpFile file = s.find(id);
		if(file==null){
			return "getAll";
		}
		
		User user = (User) ActionContext.getContext().getSession().get("user");
		if(user==null){
			ActionContext.getContext().put("message", "请先登录");
			return "message";
		}
		UpFile upfile = s.find(id);
		if(upfile==null){
			ActionContext.getContext().put("message", "服务器内部错误");
			return "message";
		}
		List<UpFile_User> list =s.finduser_upfile_user(user);
		for(UpFile_User uf : list){
			if(uf.getUpfile_id().equals(id) && uf.getFlag().equals("收藏")){
				return "download";
			}
		}
		s.addupfile_user(user, upfile, "收藏");
		
		return "getAll";
	}
	public String myyunpan() throws Exception {
		User user = (User) ActionContext.getContext().getSession().get("user");
		uploadserviceimple s = new uploadserviceimple();
		 List<UpFile_User> list = s.finduser_upfile_user(user);
		 List<UpFile> files = new ArrayList();
		 if(list!=null){
			 for(UpFile_User uf:list){
				 if(uf.getFlag().equals("收藏")){
					 files.add(s.find(uf.getUpfile_id()));
					 
				 }
			 }
		 }
		 if(files.size()!=0){
			 System.out.println(files.size());
			 ActionContext.getContext().put("list", files);
		 }else{
			 ServletActionContext.getRequest().removeAttribute("list");
		 }
		return "myyunpan";
	}

	
}
