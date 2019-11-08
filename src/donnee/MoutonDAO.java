package donnee;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import modele.Mouton;

public class MoutonDAO {
	protected DBCollection listeMoutons;
	
	public MoutonDAO()
	{
		listeMoutons = BaseDeDonnees.getInstance().getBasededonnees().getCollection("mouton");
	}
	
	public void ajouterMouton(Mouton mouton)
	{			
		DBObject moutonMongo = new BasicDBObject();
		moutonMongo.putAll(mouton.exporterHashmap());
		listeMoutons.insert(moutonMongo);
	}
	
	public List<Mouton> listerMoutons()
	{
		List<Mouton> moutons = new ArrayList<Mouton>();
		
		DBCursor pointeurMouton = listeMoutons.find();
		Map valeursMouton = pointeurMouton.one().toMap();
		Mouton mouton = new Mouton();
		mouton.setNom((String)valeursMouton.get("nom"));
		mouton.setCouleur((String)valeursMouton.get("couleur"));
		moutons.add(mouton);
		return moutons;
	}

}
