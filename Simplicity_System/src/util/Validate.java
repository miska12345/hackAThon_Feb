package util;

import javax.servlet.http.HttpSession;

import DAO.Member;

public class Validate {
	public static boolean validPass(Member mem, String pass) {
		return mem.getPassword().equals(pass);
	}
	
	public static boolean isOnline(HttpSession session) {
		return session.getAttribute("member") != null;
	}
	
	public static boolean isValidCanvasAccount(String str) {
		return str.contains("@");
	}
}
