package cn.itcast.action;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;

import cn.itcast.domain.UpFile;
import cn.itcast.domain.UpFile_User;
import cn.itcast.domain.User;
import cn.itcast.serciceimple.uploadserviceimple;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Delete extends ActionSupport{
	private String id;

	public void setId(String id) {
		this.id = id;
	}

	public String download() throws Exception {
		cn.itcast.utils.Delete.delete(ServletActionContext.getServletContext().getRealPath("/WEB-INF/load"));
		
		uploadserviceimple dao = new uploadserviceimple();
		UpFile file1 = dao.find(id);
		if(file1==null){
			return "getAll";
		}
		UpFile upfile = null;
		User user = (User) ActionContext.getContext().getSession().get("user");
		if(user==null){
			ActionContext.getContext().put("message", "请先登录");
			return "message";
		}
		uploadserviceimple s = new uploadserviceimple();
		List<UpFile_User> list = s.finduser_upfile_user(user);
		
		for(UpFile_User u : list){
			if(u.getUpfile_id().equals(id) && u.getFlag().equals("上传")){
			
				 upfile = dao.find(id);
				String path = upfile.getSavepath()+File.separator+upfile.getUuidname();
				File file = new File(path);
				System.out.println(file.exists());
				System.out.println(file.getName());
				System.out.println(upfile.getUuidname());
				
				file.delete();
				dao.delete(id);
				dao.deleteUpFile_Users(upfile);
				
				
				return "success";
			}
		}
		ActionContext.getContext().put("message", "这不是你的文件，没有删除权限");
		return "message";
	} 
	public String myyunpan() throws Exception {
		cn.itcast.utils.Delete.delete(ServletActionContext.getServletContext().getRealPath("/WEB-INF/load"));
		uploadserviceimple s = new uploadserviceimple();
		User user = (User) ActionContext.getContext().getSession().get("user");
		UpFile upfile = s.find(id);
		if(user!=null&&upfile!=null){
			s.deleteUpFile_User(user, upfile, "收藏");
		}
		
		
		return "myyunpan";
	} 
	public String myuploadfile() throws Exception {
		cn.itcast.utils.Delete.delete(ServletActionContext.getServletContext().getRealPath("/WEB-INF/load"));
		uploadserviceimple dao = new uploadserviceimple();
		UpFile upfile = null;
		User user = (User) ActionContext.getContext().getSession().get("user");
		if(user==null){
			ActionContext.getContext().put("message", "请先登录");
			return "message";
		}
		uploadserviceimple s = new uploadserviceimple();
		List<UpFile_User> list = s.finduser_upfile_user(user);
		
		for(UpFile_User u : list){
			if(u.getUpfile_id().equals(id) && u.getFlag().equals("上传")){
				
				upfile = dao.find(id);
				String path = upfile.getSavepath()+File.separator+upfile.getUuidname();
				File file = new File(path);
				System.out.println(file.exists());
				System.out.println(file.getName());
				System.out.println(upfile.getUuidname());
				
				dao.delete(id);
				dao.deleteUpFile_Users(upfile);
				file.delete();
				
				return "myuploadfile";
			}
		}
		ActionContext.getContext().put("message", "这不是你的文件，没有删除权限");
		return "message";
	} 
	
	
	
}
