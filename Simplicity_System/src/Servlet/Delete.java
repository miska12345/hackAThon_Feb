package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Member;
import xml.Schedule;
import xml.xmlparser;

public class Delete extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		int id = Integer.parseInt(req.getParameter("i"));
		Schedule sc = (Schedule)req.getSession().getAttribute("schedule");
		Member mem = (Member)req.getSession().getAttribute("member");
		
		if (mem == null) {
			resp.sendRedirect("../index.jsp?error=Please Login");
		} else if (sc == null) {
			resp.sendRedirect("index.jsp?error=EmptySchedule");
		} else {
			if (id >= sc.getDates().size()) {
				resp.sendRedirect("index.jsp?error=InvalidIndex");
			} else {
				sc.getDates().remove(id);
				xmlparser.write(sc, util.Local.getPathSchedule(req, mem));
				resp.sendRedirect("../schedule");
			}
		}
		
	}
public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		this.doGet(req, resp);
	}
}
