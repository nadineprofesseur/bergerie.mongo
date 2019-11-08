package modele;

import java.util.HashMap;
import java.util.Map;

public class Mouton {
	
	protected String nom;
	protected String couleur;

	public Mouton()
	{
	}

	public Mouton(String nom, String couleur)
	{
		this.nom = nom;
		this.couleur = couleur;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	
	public Map exporterHashmap()
	{
		Map valeursMouton = new HashMap();
		valeursMouton.put("nom",this.getNom());
		valeursMouton.put("couleur",this.getCouleur());
		return valeursMouton;
	}
	
}
