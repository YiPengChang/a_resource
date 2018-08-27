package cn.itcast.daoimple;

import java.util.List;

import org.hibernate.Session;
import org.junit.Test;

import cn.itcast.dao.uploaddao;
import cn.itcast.domain.UpFile;
import cn.itcast.domain.UpFile_User;
import cn.itcast.domain.User;
import cn.itcast.utils.HibernateUtils;

public class uploaddaoimple implements uploaddao{
	private Session session = HibernateUtils.getSessionFactory().getCurrentSession();

	public void add(UpFile upfile) {
		session.save(upfile);
		
	
	}

	@Override
	public void delete(String id) {
		String hql = "delete from UpFile where id=?";
		session.createQuery(hql).setParameter(0, id).executeUpdate();
		
	}

	@Override
	public void update(UpFile upfile) {

		session.update(upfile);
	}

	public UpFile find(String id) {
		UpFile upfile = (UpFile) session.get(UpFile.class, id);
		return upfile;
	}

	@Override
	public List<UpFile> getAll() {
		String string = "from UpFile f";
		String hql = string;
		List<UpFile> list = session.createQuery(hql).list();
		return list;
	}

	@Override
	public List<UpFile> findlike(String str) {
		char c[] = str.toCharArray();
		String value = "%";
		for(char w:c){
			value = value+w+"%";
			
		}
		String hql = "from UpFile where realname like ?"; 
		List list = session.createQuery(hql).setParameter(0, value).list();
		return list;
	}
	
	
	//            user

	
	public void adduser(User user){
		session.save(user);
	}
	public User finduserBYusername(String username){
		String hql = "from User where username=?";
		User user = (User) session.createQuery(hql).setParameter(0, username).uniqueResult();
		return user;
	}
	public User finduserBYid(String id){
		User u = (User) session.get(User.class,id);
		return u;
	}
	
	public List<UpFile_User> finduser_upfile_user(User user){
		String hql = "from UpFile_User  where user_id=?";
		List<UpFile_User> list = session.createQuery(hql).setParameter(0, user.getId()).list();
		return list;
	}
	public void addupfile_user(User user , UpFile upfile , String flag){
		UpFile_User a = new UpFile_User();
		a.setUser_id(user.getId());
		a.setUpfile_id(upfile.getId());
		a.setFlag(flag);
		session.save(a);
	}
	
	public void deleteUpFile_User(User user,UpFile upfile,String flag ){
		String hql = "delete from UpFile_User where upfile_id=? and user_id=? and flag=?";
		session.createQuery(hql).setParameter(0, upfile.getId()).setParameter(1, user.getId()).setParameter(2, flag).executeUpdate();
	}
	public void deleteUpFile_Users(UpFile upfile ){
		String hql = "delete from UpFile_User where upfile_id=?";
		session.createQuery(hql).setParameter(0, upfile.getId()).executeUpdate();
	}
	public int countupFile_user(UpFile upfile){
		String hql = "select count(e) from UpFile_User e where upfile_id=?";
		int i = (Integer) session.createQuery(hql).setParameter(0, upfile.getId()).uniqueResult();
		return i;
	}
}
