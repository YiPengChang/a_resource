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
			a.put("message", "�û��Ѵ���");
			return "adduserUI";
		}
		User u = new User();
		u.setNickname(nickname);
		u.setPassword(password);
		u.setUsername(username);
		s.adduser(u);
		ActionContext a = ActionContext.getContext();
		a.put("message", "ע��ɹ�");
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
			this.addFieldError("nickname", "�ǳƲ���Ϊ��");
		}
		if( nickname.length()>6 ){
			this.addFieldError("nickname", "�ǳƲ��ܴ���6λ");
		}
		if( nickname.length()<2 ){
			this.addFieldError("nickname", "�ǳƲ���С��2λ");
		}
		if(username==null || username.trim().equals("")){
			this.addFieldError("username", "�û�������Ϊ��");
		}
		if( username.length()>6 ){
			this.addFieldError("username", "�û������ܴ���6λ");
		}
		if( username.length()<3 ){
			this.addFieldError("username", "�û�������С��3λ");
		}
		if(password == null || password.trim().equals("")){
			this.addFieldError("password", "���벻��Ϊ��");
		}
		if( password.length()>6 ){
			this.addFieldError("password", "���벻�ܴ���6λ");
		}
		if( password.length()<3 ){
			this.addFieldError("password", "���벻��С��3λ");
		}
		super.validate();
	}

}
