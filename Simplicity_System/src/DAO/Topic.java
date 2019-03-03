package DAO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Topic {
	private String name;
	private Comment cmd;
	
	public Topic() {

	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Comment getCmd() {
		return cmd;
	}
	public void setCmd(Comment cmd) {
		this.cmd = cmd;
	}
	public String toString() {
		return this.cmd.toString();
	}
	
}
