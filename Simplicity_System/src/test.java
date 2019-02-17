import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import DAO.IDAOFactory;
import DAO.Member;
import xml.Schedule;
import xml.mDate;
import xml.mEvent;
import xml.xmlparser;

public class test {
	public static void main(String[] args) throws Exception {
		Member mem = new Member();
		mem.setUsername("admin");
		mem.setPassword("wassup");
		mem.setCanvas("UW");
		mem.setCanvasAccount("no");
		mem.setSchedule("default");
		IDAOFactory.getIDAO().doCreate(mem);
	}
}
