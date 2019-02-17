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
		Schedule sc = new Schedule();
		mDate d = new mDate();
		mEvent e = new mEvent();
		e.setName("watch movie");
		e.setNote("nah");
		d.getEvents().add(e);
		d.setDate("2019-10-11 11:11:11");
		d.setColor("rgb(1,2,3)");
		sc.getDates().add(d);
		xmlparser.write(sc, "d:" + File.separator + "output.xml");
	}
}
