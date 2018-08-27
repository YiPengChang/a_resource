package cn.itcast.service;

import cn.itcast.domain.UpFile;
import cn.itcast.domain.User;

public interface uploadservice {

	void add(User user,UpFile upfile,String flag);

	void delete(String id);

	void update(UpFile upfile);

	UpFile find(String id);

}