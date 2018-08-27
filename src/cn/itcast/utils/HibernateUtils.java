package cn.itcast.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
private static SessionFactory sf;
static{
	sf = new Configuration().configure().buildSessionFactory();
}
public static SessionFactory getSessionFactory(){
	return sf;
} 
}
