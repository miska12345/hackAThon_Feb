package util;

import DAO.Member;

public class Local {
	
	//Generate a unique file name per user
	public static String getUniqueSchedule(Member mem) {
		if (mem == null) {
			return null;
		}
		String str = "";
		
		str.concat(String.valueOf(mem.getUid()));
		str.concat(mem.getUsername());
		str.concat(mem.getCanvas());
		
		return str;
	}
}
