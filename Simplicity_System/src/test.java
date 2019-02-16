import DAO.IDAOFactory;
import DAO.Member;

public class test {
	public static void main(String[] args) throws Exception {
		Member mem = new Member();
		mem.setUsername("miska");
		mem.setPassword("wassup");
		mem.setCanvas("wtf");
		mem.setCanvasAccount("lol");
		mem.setSchedule("nothing yet");
		if (IDAOFactory.getIDAO().doCreate(mem)) {
			System.out.println("Got it");
		}
	}
}
