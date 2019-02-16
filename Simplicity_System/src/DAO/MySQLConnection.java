package DAO;
import java.sql.*;

//This class connects to MYSQL
public class MySQLConnection {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://localhost:3306/hack";
    private static final String DBUSER = "root";
    private static final String DBPASS = "";
    
private Connection conn = null;
    
    public MySQLConnection() throws Exception {
        try {
            Class.forName(DRIVER);
            this.conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Connection getConnection() {
        return this.conn;
    }
    
    public void close() throws Exception {
        try {
            this.conn.close();
        } catch (Exception e) {
            throw e;
        }
    }
	
	
}
