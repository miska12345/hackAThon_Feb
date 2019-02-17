package DAO;

public class IDAOProxy implements IDAOInterface{

	private MySQLConnection dbc = null;
    private IDAOImplement IDAObase = null;
    
    public IDAOProxy() throws Exception {
        dbc = new MySQLConnection();
        IDAObase = new IDAOImplement(dbc.getConnection());
    }
	
	@Override
	public boolean doCreate(Member mem) throws Exception{
		boolean flag = false;
		try {
			if (IDAObase.findByName(mem.getUsername()) != null) {
				throw new IllegalArgumentException("User already exist");
			} else {
				flag = IDAObase.doCreate(mem);
			}
		} catch (Exception e) {
			throw e;
		}
		this.dbc.close();
		return flag;
	}

	@Override
	public Member findByName(String name) throws Exception{
		Member mem = null;
		try {
			mem = IDAObase.findByName(name);
		} catch (Exception e) {
			throw e;
		}
		this.dbc.close();
		return mem;
	}

	@Override
	public boolean alter(Member mem) throws Exception {
		boolean flag = false;
		try {
			flag = IDAObase.alter(mem);
		} catch (Exception e) {
			throw e;
		}
		this.dbc.close();
		return flag;
	}

}
