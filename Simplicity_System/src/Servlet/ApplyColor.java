package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Member;
import util.Local;
import xml.Schedule;
import xml.xmlparser;

//Set color of blocks
public class ApplyColor extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String color = req.getParameter("color");
		int id = Integer.parseInt(req.getParameter("id")); //Date id in Schedule.getDates() list
		Schedule sc = (Schedule)req.getSession().getAttribute("schedule");
		if (sc != null && sc.getDates().size() > id && color != null) {
			sc.getDates().get(id).setColor(color);
			req.getSession().setAttribute("schedule", sc);
			xmlparser.write(sc, Local.getPathSchedule(req, (Member)req.getSession().getAttribute("member")));
			req.getRequestDispatcher("index.jsp").forward(req, resp);
			//resp.sendRedirect(req.getContextPath() + "/AuthOK/index.jsp");
		} else {
			resp.sendRedirect(req.getContextPath() + "/AuthOK/index.jsp?error=Internal error");
		}
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		this.doGet(req, resp);
	}
}
