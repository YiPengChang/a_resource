package cn.itcast.action;

import cn.itcast.domain.User;
import cn.itcast.serciceimple.uploadserviceimple;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Login extends ActionSupport {
private String username; 
private String password;
public void setUsername(String username) {
	this.username = username;
}
public void setPassword(String password) {
	this.password = password;
}
public  String loginUI(){
	
	return "f";
}
public String login() throws Exception {
	uploadserviceimple s = new uploadserviceimple();
	User user = s.finduserBYusername(username);
	if(user==null){
		ActionContext.getContext().put("message", "用户名或密码错误");
		return "f";
	}
	if(!user.getPassword().equals(password)){
		ActionContext.getContext().put("message", "用户名或密码错误");
		return "f";
	}
	ActionContext.getContext().getSession().put("user", user);
	
	return "index";
} 
public String tuichulogin() throws Exception {
		ActionContext.getContext().getSession().remove("user");
	
	return "index";
} 


}
