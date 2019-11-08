package donnee;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
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

}
