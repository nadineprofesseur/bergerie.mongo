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
		Map moutonMap = null;
		Mouton mouton = null;
		
		DBCursor pointeurMouton = listeMoutons.find();
		while(pointeurMouton.hasNext())
		{
			moutonMap = pointeurMouton.next().toMap();
			mouton = new Mouton(moutonMap);
			moutons.add(mouton);		
		}
		return moutons;
	}
	
	public void effacerMouton()
	{
		
	}

	public void effacerMoutonSelonNom(String nom)
	{
		BasicDBObject critere = new BasicDBObject("nom", nom);
		this.listeMoutons.remove(critere);
	}
	
	public Mouton trouverMoutonSelonNom(String nom)
	{
		
	}
	
}
