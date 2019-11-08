import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import donnee.BaseDeDonnees;
import donnee.MoutonDAO;
import modele.Mouton;

public class App {

	public static void main(String[] args) {
		
		System.out.println("Allo Mongo");
		MoutonDAO moutonDAO = new MoutonDAO();
		
		// Test pour ajouter
		/*
		Mouton mouton = new Mouton();
		mouton.setNom("Toutou");
		mouton.setCouleur("Bleu");
		moutonDAO.ajouterMouton(mouton); 
		 */
		
		// Test pour liste des moutons
		Mouton mouton = null;
		List<Mouton> moutons = moutonDAO.listerMoutons();
		for(Iterator<Mouton> visiteur = moutons.iterator();
				visiteur.hasNext(); mouton = visiteur.next())
		{
			System.out.println(mouton.getNom() + " - " + mouton.getCouleur());
		}
		
		BaseDeDonnees.getInstance().finalize(); // TODO trouver la solution pour que cela s'appelle tout seul
	}

}
