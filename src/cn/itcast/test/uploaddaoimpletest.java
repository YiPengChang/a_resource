package cn.itcast.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import cn.itcast.dao.uploaddao;
import cn.itcast.daoimple.uploaddaoimple;
import cn.itcast.domain.UpFile;
import cn.itcast.domain.User;
import cn.itcast.utils.HibernateUtils;

public class uploaddaoimpletest {
@Test
public void add(){
	uploaddao dao = new uploaddaoimple();
	UpFile bean = new UpFile();
	bean.setDescription("Description");
	bean.setId("1");
	bean.setRealname("Realname");
	bean.setSavepath("Savepath");
	bean.setUptime(new Date());
	bean.setUsername("Username");
	bean.setUuidname("Uuidname");
	dao.add(bean);
}
@Test
public void update(){
	uploaddao dao = new uploaddaoimple();
	UpFile bean = new UpFile();
	bean.setDescription("d");
	bean.setId("1");
	bean.setRealname("b");
	bean.setSavepath("c");
	bean.setUptime(new Date());
	bean.setUsername("peng");
	bean.setUuidname("test");
	dao.update(bean);
}




@Test
public void delete(){
	uploaddao dao = new uploaddaoimple();
	UpFile bean = new UpFile();
	
	dao.delete("asdfg");
	System.out.println(bean);
}
@Test
public void find(){
	uploaddao dao = new uploaddaoimple();
	UpFile bean = new UpFile();
	
	bean = dao.find("ba1e502f-e7cd-48d1-9a43-a3d13063f6a9");
	System.out.println(bean.getUsername());
}


@Test
public void getAll(){
	HibernateUtils.getSessionFactory().getCurrentSession().beginTransaction();
	uploaddao dao = new uploaddaoimple();
	
	List<UpFile> list = dao.getAll();
	for(UpFile upfile : list){
		System.out.println("id==="+upfile.getId());
		System.out.println("realname==="+upfile.getRealname());
		System.out.println("username==="+upfile.getUsername());
		System.out.println("uuidname==="+upfile.getUuidname());
		System.out.println("savepath==="+upfile.getSavepath());
		System.out.println("uptime==="+upfile.getUptime());
		System.out.println();
		System.out.println();
		System.out.println();
	}
	HibernateUtils.getSessionFactory().getCurrentSession().getTransaction().commit();
	
}
@Test
public void findlike(){
	uploaddao dao = new uploaddaoimple();
	UpFile bean = new UpFile();
	
	List<UpFile> list = dao.findlike("");
	for(UpFile upfile : list){
		System.out.println("id==="+upfile.getId());
		System.out.println("realname==="+upfile.getRealname());
		System.out.println("username==="+upfile.getUsername());
		System.out.println("uuidname==="+upfile.getUuidname());
		System.out.println("savepath==="+upfile.getSavepath());
		System.out.println("uptime==="+upfile.getUptime());
		System.out.println();
		System.out.println();
		System.out.println();
	}
	
}

public void addupfile_usertest(User user , UpFile upfile , String flag){
	
}
}
