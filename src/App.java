import java.util.HashMap;
import java.util.Map;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class App {

	public static void main(String[] args) {
		
		System.out.println("Allo Mongo");
		MongoClient mongo = new MongoClient();
		
		DB basededonnees = mongo.getDB("bergerie");
		
		DBCollection listeMoutons = basededonnees.getCollection("mouton");
		
		DBObject mouton = new BasicDBObject();
		Map valeursMouton = new HashMap();
		valeursMouton.put("nom","Lion");
		valeursMouton.put("couleur","verte");
		mouton.putAll(valeursMouton);
		
		listeMoutons.insert(mouton);
		
		mongo.close();

	}

}
