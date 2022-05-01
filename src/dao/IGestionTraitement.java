package dao;

import java.util.List;
import metier.Traitement;

public interface IGestionTraitement {
	public void AddTraitement(Traitement e); //ajouter
	public List<Traitement> getAllTraitement(); //consulter
	public List<Traitement> getTraitementParNom(String nom); //consulter traitement par patient
	public void UpdateTraitment(Traitement R);   //modifeier 
	public void deleteTraitement(int id); //delete par id
	
}
