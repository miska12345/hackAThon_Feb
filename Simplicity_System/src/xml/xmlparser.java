package xml;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;

public class xmlparser {
	
	//Given a user's unique schedule path, read file and return Schedule obj
	public static Schedule parse(String schedule) {
		File file = new File(schedule);
		Schedule sc = null;
		if (file.exists() & !file.isDirectory()) {
			try {
				sc = read(file);
			} catch (Exception e) {
				//Opps
			}
		}
		return sc;
	}
	
	public static void write(Schedule sc, String path) {
		Document doc = DocumentHelper.createDocument();
		Element schedule = doc.addElement("Schedule");
		List<Element> dates = new ArrayList<>();
		for (int i = 0; i < sc.getDates().size(); i++) {
			List<Element> events = new ArrayList<>();
			mDate d = new mDate();
			Element dat = schedule.addElement("Date");
			d.setDate(sc.getDates().get(i).getDate());
			d.setColor(sc.getDates().get(i).getColor());
			dat.setText(d.getDateStr() + "@" + d.getColor());
			dates.add(dat);
			for (int j = 0; j < sc.getDates().get(i).getEvents().size(); j++) {
				Element ev = dat.addElement("Event");
				Element name = ev.addElement("Name");
				Element note = ev.addElement("Note");
				name.setText(sc.getDates().get(i).getEvents().get(j).getName());
				note.setText(sc.getDates().get(i).getEvents().get(j).getNote());
				events.add(ev);
			}
		}
		OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("GBK");
        try {
            XMLWriter writer = new XMLWriter(new FileOutputStream(new File(path)), format);
            writer.write(doc);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static Schedule read(File file) throws ParseException {
        SAXReader reader = new SAXReader();
        Document doc = null;
        if (file.exists() & !file.isDirectory()) {
	        try {
	            doc = reader.read(file);
	        } catch (DocumentException e) {
	            System.out.println("Cannot read file " + file.getName());
	        }
	        Schedule sc = new Schedule();
	        Element root = doc.getRootElement();
	        Iterator<Element> iter = root.elementIterator();
	        while (iter.hasNext()) {
	            Element date = iter.next();
	            mDate d = new mDate();
	            String[] dparts = date.getText().split("@");
	            d.setDate(dparts[0]);
	            d.setColor(dparts[1]);
	            Iterator<Element> bIter = date.elementIterator();
	            while (bIter.hasNext()) {
	            	Element eve = bIter.next();
	            	mEvent e = new mEvent();
	            	e.setName(eve.elementText("Name"));
	            	e.setNote(eve.elementText("Note"));
	            	d.getEvents().add(e);
	            }
	            sc.getDates().add(d);
	        }
	        return sc;
        }
        return null;
	}
}
