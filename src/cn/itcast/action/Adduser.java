package cn.itcast.action;

import cn.itcast.domain.User;
import cn.itcast.serciceimple.uploadserviceimple;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Adduser extends ActionSupport {
	private String nickname;
	private String username;
	private String password;
	
	
	
	public String execute() throws Exception {
		uploadserviceimple s = new uploadserviceimple();
		User user = s.finduserBYusername(username);
		if(user!=null){
			ActionContext a = ActionContext.getContext();
			a.put("message", "用户已存在");
			return "adduserUI";
		}
		User u = new User();
		u.setNickname(nickname);
		u.setPassword(password);
		u.setUsername(username);
		s.adduser(u);
		ActionContext a = ActionContext.getContext();
		a.put("message", "注册成功");
		return "message";
	}
	
	
	
	
	
	
	
	
	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	@Override
	public void validate() {
		
		if(nickname==null || nickname.trim().equals("")){
			this.addFieldError("nickname", "昵称不能为空");
		}
		if( nickname.length()>6 ){
			this.addFieldError("nickname", "昵称不能大于6位");
		}
		if( nickname.length()<2 ){
			this.addFieldError("nickname", "昵称不能小于2位");
		}
		if(username==null || username.trim().equals("")){
			this.addFieldError("username", "用户名不能为空");
		}
		if( username.length()>6 ){
			this.addFieldError("username", "用户名不能大于6位");
		}
		if( username.length()<3 ){
			this.addFieldError("username", "用户名不能小于3位");
		}
		if(password == null || password.trim().equals("")){
			this.addFieldError("password", "密码不能为空");
		}
		if( password.length()>6 ){
			this.addFieldError("password", "密码不能大于6位");
		}
		if( password.length()<3 ){
			this.addFieldError("password", "密码不能小于3位");
		}
		super.validate();
	}

}
