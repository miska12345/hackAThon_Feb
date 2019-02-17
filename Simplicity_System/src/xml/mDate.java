package xml;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import xml.mEvent;
public class mDate {
		private List<mEvent> events;
		private Date date;
		private String color;
		public mDate() {
			events = new ArrayList<>();
			color = "#5697ff"; // Default color
		}
		
		public List<mEvent> getEvents() {
			return this.events;
		}

		public void setEvents(List<mEvent> evs) {
			this.events = evs;
		}
		public Date getDate() {
			return date;
		}
		
		public String getDateStr() {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
			String strDate = dateFormat.format(date);  
			return strDate;
		}

		public void setDate(String date) throws ParseException {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
			
			this.date = format.parse(date);
		}
		
		public void setDate(Date date){
			this.date = date;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}
		
}
