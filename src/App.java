import java.util.HashMap;
import java.util.Map;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import donnee.MoutonDAO;
import modele.Mouton;

public class App {

	public static void main(String[] args) {
		
		System.out.println("Allo Mongo");
		MoutonDAO moutonDAO = new MoutonDAO();
		
		
		Mouton mouton = new Mouton();
		mouton.setNom("Toto");
		mouton.setCouleur("Bleu");
		
		moutonDAO.ajouterMouton(mouton); 

		
		moutonDAO.finalize(); // TODO trouver la solution pour que cela s'appelle tout seul
	}

}
