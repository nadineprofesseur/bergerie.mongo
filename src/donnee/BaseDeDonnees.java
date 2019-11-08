package donnee;

public class BaseDeDonnees {
	
	private BaseDeDonnees()
	{
		
	}
	
	protected static BaseDeDonnees instance = null;
	public static BaseDeDonnees getInstance()
	{
		if(instance == null) instance = new BaseDeDonnees();
		return instance;
	}

}
