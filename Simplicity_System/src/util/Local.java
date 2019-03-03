package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.servlet.http.HttpServletRequest;

import DAO.Member;

public class Local {
	
	//Generate a unique file name per user
	public static String getUniqueSchedule(Member mem) {
		if (mem == null) {
			return null;
		}
		String str = "";
		str += (mem.getUsername());
		str += (mem.getCanvas());
		
		return str;
	}
	
	public static String getPathSchedule(HttpServletRequest req, Member mem) {
		String path = req.getServletContext().getRealPath("/") + "Schedules" + File.separator +
				mem.getSchedule()+".xml";
		return path;
	}
	
	public static void signalCrawler(Member mem, String realPath) throws IOException {
		OutputStream output = new FileOutputStream(realPath + "command.txt");
		File file = new File(realPath + "command.txt");
		PrintStream printStream = new PrintStream(output);
		String[] tmp = mem.getCanvasAccount().split("_");
		if (tmp.length >= 2) {
			printStream.println(tmp[0] + " " + tmp[1] + " " + mem.getCanvas() + " " + mem.getSchedule());
		}
		printStream.close();
		output.close();
	}
}
