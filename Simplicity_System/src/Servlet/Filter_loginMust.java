package Servlet;

import java.io.IOException;

import javax.servlet.FilterChain;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Filter_loginMust extends HttpServlet{

	//Block unauthorized visit of a particular page
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest res = (HttpServletRequest) req;
		HttpServletResponse hresp = (HttpServletResponse)resp;
		if (res.getSession().getAttribute("uid") == null) {
			hresp.sendRedirect("index.jsp?"+"error=Please Login!");
		} else {
			chain.doFilter(req, resp);
		}
		
	}
}
