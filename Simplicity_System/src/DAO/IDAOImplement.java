package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class IDAOImplement implements IDAOInterface {

	private Connection conn = null;
    private PreparedStatement psmt = null;
    
    public IDAOImplement(Connection conn) {
    	this.conn = conn;
    }
	@Override
	public boolean doCreate(Member mem) throws Exception {
		boolean flag = false;
		String sql = "INSERT INTO member(Username,Password,Canvas,Canvas_Accounts,Schedule) VALUE (?,?,?,?,?)";
		this.psmt = this.conn.prepareStatement(sql);
		this.psmt.setString(1, mem.getUsername());
		this.psmt.setString(2, mem.getPassword());
		this.psmt.setString(3, mem.getCanvas());
		this.psmt.setString(4, mem.getCanvasAccount());
		this.psmt.setString(5, mem.getSchedule());
		if (this.psmt.executeUpdate() > 0) {
			flag = true;
		}
		this.psmt.close();
		return flag;
	}

	@Override
	public Member findByName(String name) throws Exception{
		Member mem = null;
		String sql = "SELECT uid,Username,Password,Canvas,Canvas_Accounts,Schedule FROM member WHERE Username LIKE ?";
		this.psmt = this.conn.prepareStatement(sql);
		this.psmt.setString(1, name);
		ResultSet rs = this.psmt.executeQuery();
		while (rs.next()) {
			mem = new Member();
			mem.setUid((rs.getInt(1)));
			mem.setUsername(rs.getString(2));
			mem.setPassword(rs.getString(3));
			mem.setCanvas(rs.getString(4));
			mem.setCanvasAccount(rs.getString(5));
			mem.setSchedule(rs.getString(6));
		}
		this.psmt.close();
		return mem;
	}

}
