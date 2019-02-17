package util;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import DAO.Member;

public class Local {
	
	//Generate a unique file name per user
	public static String getUniqueSchedule(Member mem) {
		if (mem == null) {
			return null;
		}
		String str = "";
		str += String.valueOf(mem.getUid());
		str += (mem.getUsername());
		str += (mem.getCanvas());
		
		return str;
	}
	
	public static String getPathSchedule(HttpServletRequest req, Member mem) {
		String path = req.getServletContext().getRealPath("/") + "Schedules" + File.separator +
				mem.getSchedule()+".xml";
		return path;
	}
}
