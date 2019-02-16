package DAO;

public class IDAOFactory {
	public static IDAOInterface getIDAO() throws Exception {
		return new IDAOProxy();
	}
}
