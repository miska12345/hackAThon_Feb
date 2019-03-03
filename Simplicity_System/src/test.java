import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import DAO.Comment;
import DAO.IDAOFactory;
import DAO.Member;
import DAO.Pair;
import DAO.Topic;
import util.TimeDate;
import xml.Schedule;
import xml.mDate;
import xml.mEvent;
import xml.xmlparser;

public class test {
	public static void main(String[] args) throws Exception {
		Schedule sc = xmlparser.read(new File("C:\\Users\\23156\\Desktop\\ISMS\\Schedules\\weifengCentral.xml"));
		
		if (sc == null) {
			System.out.println("xx");
		}
		
		System.out.println(sc.getDates().get(0).getEvents().get(0).getName());
		String j;
	}
}
