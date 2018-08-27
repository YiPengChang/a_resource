package cn.itcast.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import cn.itcast.domain.UpFile;
import cn.itcast.domain.User;
import cn.itcast.serciceimple.uploadserviceimple;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Upload extends ActionSupport {
private String description;
private File[] file;
private String[] fileFileName;

 
@Override
public String execute() throws Exception {
	if(ActionContext.getContext().getSession().get("user")!=null)
	{		
			int filecount =1; 
			int size = 0;
			int allsize = 0;
			
			User user = (User) ActionContext.getContext().getSession().get("user");
			uploadserviceimple s = new uploadserviceimple();
			ServletContext context = ServletActionContext.getServletContext();
			String savepath = null;
			for(int i= 0;i<file.length;i++){
					 savepath = context.getRealPath("/WEB-INF/load")+File.separator+UUID.randomUUID().toString().substring(34)+File.separator+UUID.randomUUID().toString().substring(34)+File.separator+UUID.randomUUID().toString().substring(34);
					
					File dir = new File(savepath);
					if(!dir.exists()){
						dir.mkdirs();
					}
					String uuidname = UUID.randomUUID().toString()+fileFileName[i];
					File f = new File(savepath+File.separator+uuidname);
					InputStream in = new FileInputStream(file[i]);
					OutputStream out = new FileOutputStream(f);
					byte[] b = new byte[1024];
					int len;
					while((len=in.read(b))>0){
						System.out.println("增在上传第"+filecount+"文件         的"+size+"kb"+"    总共上传了"+allsize+"kb");
						out.write(b, 0, len);
						size++;
						allsize++;
					}
					size=0;
					filecount++;
					in.close();
					out.close();
					UpFile upfile = new UpFile();
					upfile.setDescription(description);
					upfile.setId(UUID.randomUUID().toString());
					upfile.setRealname(fileFileName[i]);
					upfile.setSavepath(savepath);
					upfile.setUsername(user.getNickname());
					upfile.setUuidname(uuidname);
					
					s.add(user,upfile,"上传");
			}
	}else{
		ActionContext.getContext().put("message", "请先登录");
		return "message";
	}
	return "index";
}
public String getUI() throws Exception {
	
	if(ActionContext.getContext().getSession().get("user")==null){
		ActionContext.getContext().put("message", "请先登录");
		return "message";
	}
	
	
	return "uploadUI";
}









public void setDescription(String description) {
	this.description = description;
}
public void setFile(File[] file) {
	this.file = file;
}
public void setFileFileName(String[] fileFileName) {
	this.fileFileName = fileFileName;
}








public void validateExecute() {
	
	if(file==null)
	{
		this.addFieldError("file", "上传文件不能为空");
	}
	if(description.length()>15)
	{
		this.addFieldError("description", "描述的长度不能大于15");
	}
	super.validate();
}

}
