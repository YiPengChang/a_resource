        1���뿪������
        	mysql
        	c3p0
        	dbutils
        	fileupload
        	io
        	jstl
        2������֯��İ�
        	cn.itcast.dao
        	cn.itcast.daoimple
        	cn.itcast.domain
        	cn.itcast.service
        	cn.itcast.serciceimple
        	cn.itcast.servlet
        	cn.itcast.web
        	cn.itcast.utils
        	cn.itcast.test
        	
        3������ͱ�
        create database day18;
        use day18;
        create table fileupload
        (
        	id varchar(40) primary key,
        	uuidname varchar(100) not null unique,
        	realname varchar(100) not null,
        	username varchar(40) not null,
        	uptime datetime not null,
        	description varchar(255),
        	savepath varchar(255) not null
        );
		
		spring boot + spring cloud