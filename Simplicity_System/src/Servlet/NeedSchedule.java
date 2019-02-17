package Servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Member;
import xml.Schedule;
import xml.xmlparser;

//This class allows front-back communication
//Return Object Schedule if successful, otherwise null
public class NeedSchedule extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		if (util.Validate.isOnline(req.getSession())) {
			Member user = (Member)req.getSession().getAttribute("member");
			String path = req.getServletContext().getRealPath("/") + "Schedules" + File.separator +
					user.getSchedule()+".xml";
			Schedule sc = xmlparser.parse(path);
			req.getSession().setAttribute("ah", path);
			if (sc != null) {
				//Got it
				req.getSession().setAttribute("schedule", sc);
			}
			//req.getRequestDispatcher("/AuthOK/index.jsp").forward(req, resp);
			resp.sendRedirect(req.getContextPath() + "/AuthOK/index.jsp");
		} else {
			resp.sendRedirect(req.getContextPath() + "/index.jsp?error=Login First");
		}
		
	}
	
public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		this.doGet(req, resp);
	}
}
