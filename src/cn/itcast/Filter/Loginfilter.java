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

import cn.itcast.domain.User;

public class Loginfilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		System.out.println(request.getRequestURI());
		System.out.println(request.getRequestURI());
		User user = (User) request.getSession().getAttribute("user");
		if(!((request.getContextPath()+"/index.jsp").equals(request.getRequestURI())) || ((request.getContextPath()+"/").equals(request.getRequestURI())) || ((request.getContextPath()+"/loginUI.jsp").equals(request.getRequestURI())) || ((request.getContextPath()+"/adduserUI.jsp").equals(request.getRequestURI()))       )
		if(user==null){
			request.setAttribute("message", "ÇëÏÈµÇÂ¼£¡£¡£¡");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		arg2.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
