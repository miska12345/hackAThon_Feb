package DAO;

//What should IDAO implement?
public interface IDAOInterface {
	public boolean doCreate(Member mem) throws Exception;
	
	public Member findByName(String name) throws Exception;
	
	public boolean alter(Member mem) throws Exception;
	
	//Comment stuff
	
	public Topic findByTopic(String top) throws Exception;
	
	public boolean insertComment(Topic top) throws Exception;
	
	public boolean doCreateTopic(Topic top) throws Exception;
	
	public boolean doReplace(Topic top) throws Exception;
}
