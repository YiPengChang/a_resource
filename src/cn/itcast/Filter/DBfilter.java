package cn.itcast.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import cn.itcast.utils.HibernateUtils;

public class DBfilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain Chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		try{
			HibernateUtils.getSessionFactory().getCurrentSession().beginTransaction();
			Chain.doFilter(request, response);
			
			HibernateUtils.getSessionFactory().getCurrentSession().getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
			HibernateUtils.getSessionFactory().getCurrentSession().getTransaction().rollback();
			System.out.println("»Ø¹öÊÂÎñ");
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
