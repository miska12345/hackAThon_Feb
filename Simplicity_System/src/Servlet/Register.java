
package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.IDAOFactory;
import DAO.Member;

public class Register extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String username =  req.getParameter("username");
		String password =  req.getParameter("pass");
		String CanvasAccount = req.getParameter("cid");
		String CanvasPass = req.getParameter("cpass");
		String dName = req.getParameter("dname");
		Member mem = null;
		RequestDispatcher rs = null;
		boolean flag = false;
		try {
			mem = IDAOFactory.getIDAO().findByName(username);
		} catch (Exception e) {
			//Not a member
		}
		if (mem == null && username != null && password != null && CanvasAccount != null && CanvasPass != null) {
			if (!util.Validate.isValidCanvasAccount(CanvasAccount)) {
				resp.sendRedirect("register.jsp?error=Invalid Canvas Account (xxx@yy)");
			} else {
				String[] parts = CanvasAccount.split("@");
				mem = new Member();
				mem.setUsername(username);
				mem.setPassword(password);
				mem.setCanvas(parts[1]);
				mem.setCanvasAccount(parts[0] + "_"+ CanvasPass);
				mem.setDisplayName(dName);
				mem.setSchedule(util.Local.getUniqueSchedule(mem));
				util.Local.signalCrawler(mem, req.getServletContext().getRealPath("/"));
				try {
					if (IDAOFactory.getIDAO().doCreate(mem)) {
						resp.sendRedirect("index.jsp?error=Registeration Complete");
					}
				} catch (Exception e) {
					resp.sendRedirect("register.jsp?error=Internal Error");
				}
			}
		} else {
			resp.sendRedirect("register.jsp?error=Invalid Input/User already exist");
		}
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		this.doGet(req, resp);
	}
}
