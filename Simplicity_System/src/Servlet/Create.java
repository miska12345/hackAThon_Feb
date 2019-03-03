package Servlet;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Member;
import xml.Schedule;
import xml.mDate;
import xml.mEvent;
import xml.xmlparser;

public class Create extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String task = (String)req.getParameter("dTask");
		String note = (String)req.getParameter("dNote");
		String dDate = (String)req.getParameter("dDate");
		Schedule sc = (Schedule)req.getSession().getAttribute("schedule");
		if (sc == null) {
			resp.sendRedirect("index.jsp?error=NoSchedule!");
		} else {
			mDate md = new mDate();
			try {
				md.setDate(dDate);
				mEvent me = new mEvent();
				me.setName(task);
				me.setNote(note);
				
				md.getEvents().add(me);
				
				sc.getDates().add(md);	
				xmlparser.write(sc, util.Local.getPathSchedule(req, (Member)req.getSession().getAttribute("member")));
				resp.sendRedirect("../schedule");
			} catch (ParseException e) {
				resp.sendRedirect("index.jsp?error=Internal Error");
			}
		}
	}
	
public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		this.doGet(req, resp);
	}
}
