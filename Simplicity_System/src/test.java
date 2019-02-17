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
		/*Schedule sc = new Schedule();
		for (int i=0;i<10;i++) {
		List<mDate> da = new ArrayList<>();
		mEvent e = new mEvent();
		e.setName("Buy stuff");
		e.setNote("Without paying");
		mDate d = new mDate();
		d.setDate("2019-10-19 00:00:00");
		d.getEvents().add(e);
		sc.getDates().add(d);
		
		}
		xmlparser.write(sc);*/
		
		Schedule sc = xmlparser.read();
		Iterator<mDate> iter = sc.getDates().iterator();
		while (iter.hasNext()) {
			mDate d = iter.next();
			Iterator<mEvent> iter2 = d.getEvents().iterator();
			System.out.print(d.getDateStr() + " | ");
			while (iter2.hasNext()) {
				mEvent e = iter2.next();
				System.out.println(e.getName() + " | " + e.getNote());
			}
		}
	}
}
