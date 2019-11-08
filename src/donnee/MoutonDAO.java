package donnee;

import java.util.HashMap;
import java.util.Map;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import modele.Mouton;

public class MoutonDAO {
	protected MongoClient mongo;
	protected DB basededonnees;
	protected DBCollection listeMoutons;
	
	public MoutonDAO()
	{
		mongo = new MongoClient();		
		basededonnees = mongo.getDB("bergerie");
		listeMoutons = basededonnees.getCollection("mouton");
	}
	
	public void ajouterMouton(Mouton mouton)
	{			
		DBObject moutonMongo = new BasicDBObject();
		moutonMongo.putAll(mouton.exporterHashmap());
		listeMoutons.insert(moutonMongo);
	}
	
	@Override
	public void finalize() 
	{
		System.out.println("Fermer la base de données Mongo");
		mongo.close();
	}

}
