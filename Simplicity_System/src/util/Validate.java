package util;

import DAO.Member;

public class Validate {
	public static boolean validPass(Member mem, String pass) {
		return mem.getPassword().equals(pass);
	}
}
