package dao;

import java.util.List;
import metier.Prescription;

public interface IGestionPrescription {
	public void AddPrescription(Prescription e);  //ajouter 
	public List<Prescription> getAllPrescription(); //consulter la liste des patients
	public List<Prescription> getPrescriptionParNom(String nom);//consulter par nom
}
