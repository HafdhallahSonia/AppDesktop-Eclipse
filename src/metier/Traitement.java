package metier;

public class Traitement {
	private int id;
	private String nom,traitement,medicament,dose, prix;
	
	public String getTraitement() {
		return traitement;
	}
	public void setTraitement(String traitement) {
		this.traitement = traitement;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getMedicament() {
		return medicament;
	}
	public void setMedicament(String medicament) {
		this.medicament = medicament;
	}
	public String getDose() {
		return dose;
	}
	public void setDose(String dose) {
		this.dose = dose;
	}
	public String getPrix() {
		return prix;
	}
	public void setPrix(String prix) {
		this.prix = prix;
	}
	public Traitement() {

	}
	
	public Traitement(int id, String nom, String medicament,String traitement, String dose, String prix) {
		super();
		this.id = id;
		this.nom = nom;
		this.medicament = medicament;
		this.traitement = traitement;
		this.dose = dose;
		this.prix = prix;
	}
	public Traitement(String nom, String medicament,String traitement, String dose, String prix, int id) {
		super();
		this.id = id;
		this.nom = nom;
		this.medicament = medicament;
		this.traitement = traitement;
		this.dose = dose;
		this.prix = prix;
	}
	
	public Traitement(String nom, String medicament, String traitement,String dose, String prix) {
		this.nom = nom;
		this.medicament = medicament;
		this.traitement = traitement;
		this.dose = dose;
		this.prix = prix;
	}
	
	

}
