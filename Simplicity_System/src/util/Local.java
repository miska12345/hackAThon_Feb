package util;

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
}
