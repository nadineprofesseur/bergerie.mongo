package donnee;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class BaseDeDonnees {
	protected MongoClient mongo;
	protected DB basededonnees;
	
	private BaseDeDonnees()
	{
		mongo = new MongoClient();		
		basededonnees = mongo.getDB("bergerie");
	}
	
	protected static BaseDeDonnees instance = null;
	public static BaseDeDonnees getInstance()
	{
		if(instance == null) instance = new BaseDeDonnees();
		return instance;
	}

	@Override
	public void finalize() 
	{
		System.out.println("Fermer la base de données Mongo");
		mongo.close();
	}
	
	public DB getBasededonnees() {
		return basededonnees;
	}
	
}
