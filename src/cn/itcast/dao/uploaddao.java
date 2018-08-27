package cn.itcast.dao;

import java.util.List;

import cn.itcast.domain.UpFile;

public interface uploaddao {

	void add(UpFile upfile);

	void delete(String id);

	void update(UpFile upfile);

	UpFile find(String id);

	List<UpFile> getAll();

	List<UpFile> findlike(String str);

}