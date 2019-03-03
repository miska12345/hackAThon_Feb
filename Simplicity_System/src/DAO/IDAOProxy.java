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

	@Override
	public boolean insertComment(Topic top) throws Exception {
		Topic serverT = null;
		boolean flag = false;
		if (this.IDAObase.findByTopic(top.getName()) == null) {
			flag = doCreateTopic(top);
			serverT = top;
			System.out.println("c");
		} else {
			serverT = this.IDAObase.findByTopic(top.getName());
			for (int i = 0; i < top.getCmd().getAllCom().size(); i++) {
				serverT.getCmd().getAllCom().add(top.getCmd().getAllCom().get(i));
			}
			flag = doReplace(serverT);
		}
		
		//Topic is already in data base
		return flag;
	}

	@Override
	public boolean doCreateTopic(Topic top) throws Exception {
		boolean flag = false;
		try {
			if (this.IDAObase.findByTopic("top") == null) {
				flag = this.IDAObase.doCreateTopic(top);
			}
		} catch (Exception e) {
			throw e;
		}
		this.dbc.close();
		return flag;
	}

	@Override
	public Topic findByTopic(String top) throws Exception {
		Topic t = null;
		try {
			t = new Topic();
			t = this.IDAObase.findByTopic(top);
		} catch (Exception e) {
			throw e;
		}
		this.dbc.close();
		return t;
	}

	@Override
	public boolean doReplace(Topic top) throws Exception {
		boolean flag = false;
		try {
			flag = this.IDAObase.doReplace(top);
		} catch (Exception e) {
			
		}
		return flag;
	}

}
