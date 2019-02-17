package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IDAOImplement implements IDAOInterface {

	private Connection conn = null;
    private PreparedStatement psmt = null;
    
    public IDAOImplement(Connection conn) {
    	this.conn = conn;
    }
	@Override
	public boolean doCreate(Member mem) throws Exception {
		boolean flag = false;
		String sql = "INSERT INTO member(Username,Password,Canvas,Canvas_Accounts,Schedule,DisplayName) VALUE (?,?,?,?,?)";
		this.psmt = this.conn.prepareStatement(sql);
		this.psmt.setString(1, mem.getUsername());
		this.psmt.setString(2, mem.getPassword());
		this.psmt.setString(3, mem.getCanvas());
		this.psmt.setString(4, mem.getCanvasAccount());
		this.psmt.setString(5, mem.getSchedule());
		this.psmt.setString(6, mem.getDisplayName());
		if (this.psmt.executeUpdate() > 0) {
			flag = true;
		}
		this.psmt.close();
		return flag;
	}

	@Override
	public Member findByName(String name) throws Exception{
		Member mem = null;
		String sql = "SELECT uid,Username,Password,Canvas,Canvas_Accounts,Schedule,DisplayName FROM member WHERE Username LIKE ?";
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
			mem.setDisplayName(rs.getString(7));
		}
		this.psmt.close();
		return mem;
	}
	
	private Member findByID(int id) throws Exception{
		Member mem = null;
		String sql = "SELECT uid,Username,Password,Canvas,Canvas_Accounts,Schedule,DisplayName FROM member WHERE uid LIKE ?";
		this.psmt = this.conn.prepareStatement(sql);
		this.psmt.setInt(1, id);
		ResultSet rs = this.psmt.executeQuery();
		while (rs.next()) {
			mem = new Member();
			mem.setUid((rs.getInt(1)));
			mem.setUsername(rs.getString(2));
			mem.setPassword(rs.getString(3));
			mem.setCanvas(rs.getString(4));
			mem.setCanvasAccount(rs.getString(5));
			mem.setSchedule(rs.getString(6));
			mem.setDisplayName(rs.getString(7));
		}
		this.psmt.close();
		return mem;
	}
	@Override
	public boolean alter(Member mem) throws Exception {
		// TODO Auto-generated method stub
		if (update("DisplayName", mem.getDisplayName(), mem.getUid()) & update("Canvas", mem.getCanvas(), mem.getUid())&
				update("Canvas_Accounts", mem.getCanvasAccount(), mem.getUid())) {
			return true;
		}
		return false;
	}

	private boolean update(String col, String val, int uid) throws Exception {
		boolean flag = false;
		String sql = "UPDATE member SET " + col + " = ? WHERE uid = ?";
		this.psmt = this.conn.prepareStatement(sql);
		this.psmt.setString(1,val);
		this.psmt.setInt(2, uid);
		if (this.psmt.executeUpdate() > 0) {
			flag = true;
		}
		this.psmt.close();
		return flag;
	}
}
