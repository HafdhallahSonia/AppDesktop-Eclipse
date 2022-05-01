package dao;

import java.util.List;
import metier.Patient;

public interface IGestionPatient {
	public void AddPatient(Patient e);  //ajouter 
	public List<Patient> getAllPatient(); //consulter la liste des patients
	public List<Patient> getPatientParNom(String nom);//consulter par nom
	public void UpdatePatient(Patient p); //modifier 
	public void deletePatient(int id);  //supprimer par id
}
