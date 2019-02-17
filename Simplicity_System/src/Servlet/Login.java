package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.IDAOFactory;
import DAO.Member;
public class Login extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String username = req.getParameter("username");
		String password = req.getParameter("pass");
		Member mem = null;
		RequestDispatcher rs = null;
		boolean flag = false;
		try {
			mem = IDAOFactory.getIDAO().findByName(username);
		} catch (Exception e) {
			//Something is not right...
		}
		if (mem != null) {
			flag = util.Validate.validPass(mem, password);
			if (flag) {
				// Login is successful
				req.getSession().setAttribute("member", mem);
				
				resp.sendRedirect(req.getContextPath() + "/AuthOK/");
			} else {
				req.setAttribute("error", "Password is incorrect");
				req.getRequestDispatcher("/index.jsp").forward(req, resp);
			}
		} else {
			req.setAttribute("error", "User doesn't exist");
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		}
		
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		this.doGet(req, resp);
	}
}
