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
	MongoClient mongo;
	public MoutonDAO()
	{
		mongo = new MongoClient();		
	}
	
	public void ajouterMouton(Mouton moutonRecu)
	{
		
		DB basededonnees = mongo.getDB("bergerie");
				
		Map valeursMouton = new HashMap();
		valeursMouton.put("nom","Lion");
		valeursMouton.put("couleur","verte");
		
		DBObject mouton = new BasicDBObject();
		mouton.putAll(valeursMouton);
		
		DBCollection listeMoutons = basededonnees.getCollection("mouton");
		listeMoutons.insert(mouton);
	
	}
	
	@Override
	public void finalize() 
	{
		System.out.println("Fermer la base de donn�es Mongo");
		mongo.close();
	}

}
