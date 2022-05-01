package dao;

import java.util.List;
import metier.Patient;
import metier.Rendez_vous;

public interface IGestionRendez {
	public void AddRendez(Rendez_vous e); //ajouter
	public List<Rendez_vous> getAllRendez(); //consulter
	public List<Patient> getPatientParNom(String nom); //consulter patient par nom
	public List<Rendez_vous> getRendez_vousParDate(String date); //consulter rendez_vous par date
	public List<Rendez_vous> getRendez_vousParNom(String nom, String date); //consulter rendez_vous par nom et date
	public void UpdateR(Rendez_vous R);   //modifeier 
	public void deleteR(int id); //delete par id
	
}
