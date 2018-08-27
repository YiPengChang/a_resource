package cn.itcast.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {
	private static ComboPooledDataSource ds ;
	static{
		 ds = new  ComboPooledDataSource();
	}
	public static ComboPooledDataSource getDatasource(){
		
		return ds;
	}
}
