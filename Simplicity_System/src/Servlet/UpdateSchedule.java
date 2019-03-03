package Servlet;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Member;
import xml.Schedule;
import xml.xmlparser;

public class UpdateSchedule extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		int id = Integer.parseInt(req.getParameter("i"));
		Member mem = (Member)req.getSession().getAttribute("member");
		String[] tasks = req.getParameterValues("dtxt");
		String[] notes = req.getParameterValues("dnote");
		Schedule sc = (Schedule)req.getSession().getAttribute("schedule");
		if (sc.getDates().size() <= id || tasks.length != notes.length) {
			resp.sendRedirect("edit.jsp?error=Illegal Index");
		} else if (mem == null) {
			resp.sendRedirect("./index.jsp?error=Please Login");
		} else {
			try {
				for (int i = 0; i < tasks.length; i++) {
					sc.getDates().get(id).getEvents().get(i).setName(tasks[i]);
					sc.getDates().get(id).getEvents().get(i).setNote(notes[i]);
				}
				req.getSession().setAttribute("schedule", sc);
				xmlparser.write(sc, util.Local.getPathSchedule(req, mem));
				resp.sendRedirect("../schedule");
			} catch (Exception e) {
				resp.sendRedirect("edit.jsp?error=Illegal Date Format");
			}
			
		}
		
	}
	
public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		this.doGet(req, resp);
	}
}
