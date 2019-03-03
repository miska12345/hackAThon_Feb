package DAO;

import java.util.ArrayList;
import java.util.List;

public class Comment {
	private List<Pair> allCom;
	
	public Comment() {
		this.setAllCom(new ArrayList<>());
	}
	
	//Takes massive string and convert pair object
	public void doParse(String mtxt) {
		System.out.println(mtxt);
		List<Pair> lst = new ArrayList<>();
		String[] tmp = mtxt.split("|@|");
		for (int i = 0; i < tmp.length; i++) {
			String tmp2 = tmp[i];
			String[] tmpsplit = tmp2.split("<:>");
			if (tmpsplit.length < 2) {
				//This pair is invalid
				
				System.out.println(tmpsplit[0]);
				continue;
			}
			Pair pair = new Pair();
			pair.setDisplayName(tmpsplit[0]);
			pair.setContent(tmpsplit[1]);
			lst.add(pair);
		}
		this.setAllCom(lst);
	}

	public List<Pair> getAllCom() {
		return allCom;
	}

	public void setAllCom(List<Pair> allCom) {
		this.allCom = allCom;
	}
	
	public String toString() {
		String str = "";
		for (int i = 0; i < this.allCom.size(); i++) {
			str += this.allCom.get(i).toString();
			str+="|@|";

		}
		return str;
	}
}
