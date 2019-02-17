package DAO;

//What should IDAO implement?
public interface IDAOInterface {
	public boolean doCreate(Member mem) throws Exception;
	
	public Member findByName(String name) throws Exception;
	
	public boolean alter(Member mem) throws Exception;
}
