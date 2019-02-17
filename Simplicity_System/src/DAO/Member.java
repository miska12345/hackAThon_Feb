package DAO;

//This is a VO
//DO NOT MODIFY
public class Member {
	private int uid;
	private String username;
	private String password;
	private String Canvas;
	private String CanvasAccount; //username|password
	private String schedule; 
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCanvas() {
		return Canvas;
	}
	public void setCanvas(String canvas) {
		Canvas = canvas;
	}
	public String getCanvasAccount() {
		return CanvasAccount;
	}
	public void setCanvasAccount(String canvasAccount) {
		CanvasAccount = canvasAccount;
	}
	public String getSchedule() {
		return schedule;
	}
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
}
