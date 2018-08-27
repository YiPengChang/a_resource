package cn.itcast.serciceimple;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import cn.itcast.daoimple.uploaddaoimple;
import cn.itcast.domain.UpFile;
import cn.itcast.domain.UpFile_User;
import cn.itcast.domain.User;
import cn.itcast.service.uploadservice;


public class uploadserviceimple implements uploadservice {
	private uploaddaoimple dao = new uploaddaoimple();
	public void add(User user,UpFile upfile,String flag){
		
		upfile.setId(UUID.randomUUID().toString());
		upfile.setUptime(new Date());
		dao.add(upfile);
		addupfile_user(user,upfile,flag);
	}

	public void delete(String id){
		dao.delete(id);
	}

	public void update(UpFile upfile){
		dao.update(upfile);
	}
	public UpFile find(String id){
		
		return dao.find(id);
	}
	public List<UpFile> getAll(){
		return dao.getAll();
	}
	public List findlike(String str){
		return dao.findlike(str);
	}
	public void adduser(User user){
		dao.adduser(user);
	}
	public User finduserBYusername(String username){
		return dao.finduserBYusername(username);
	}
	public User finduserBYid(String id){
		return dao.finduserBYid(id);
	}
	public List<UpFile_User> finduser_upfile_user(User user){
		return dao.finduser_upfile_user(user);
	}
	public void addupfile_user(User user , UpFile upfile , String flag){
		dao.addupfile_user(user, upfile, flag);
	}
	public void deleteUpFile_Users(UpFile upfile ){
		dao.deleteUpFile_Users(upfile);
	}
	public void deleteUpFile_User(User user,UpFile upfile,String flag ){
		dao.deleteUpFile_User(user, upfile, flag);
	}
	public int countupFile_user(UpFile upfile){
		return dao.countupFile_user(upfile);
	}
}
