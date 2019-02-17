package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.IDAOFactory;
import DAO.Member;

public class AccountUpdate extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String display = req.getParameter("dname");
		String Canvas_Account = req.getParameter("dAccount");
		String Canvas_Password = req.getParameter("dPass");
		if (display != null && Canvas_Account != null && Canvas_Password != null && display.length() > 0 && Canvas_Account.length() > 0 && Canvas_Password.length() > 0 &&
				Canvas_Account.contains("@")) {
			Member mem = (Member)req.getSession().getAttribute("member");
			if (mem == null) {
				resp.sendRedirect("settings.jsp?error=Session expired");
			}
			mem.setDisplayName(display);
			String[] canvas = Canvas_Account.split("@");
			mem.setCanvas(canvas[1]);
			mem.setCanvasAccount(canvas[0] + "_" + Canvas_Password);
			try {
				IDAOFactory.getIDAO().alter(mem);
				req.getSession().setAttribute("member", mem);
				resp.sendRedirect("settings.jsp?error=Saved");
				
			} catch (Exception e) {
				resp.sendRedirect("settings.jsp?error=Database problem");
			}
		} else {
			resp.sendRedirect("settings.jsp?error=Invalid/Empty Input Detected");
		}
	}
	
public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		this.doGet(req, resp);
	}
}
