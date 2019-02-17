package xml;
import java.util.List;
import java.util.ArrayList;
public class Schedule {
	private List<mDate> dates;
	
	public Schedule() {
		dates = new ArrayList<>();
	}
	
	public List<mDate> getDates() {
		return this.dates;
	}
}

