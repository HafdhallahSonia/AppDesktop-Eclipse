package metier;

public class Prescription {
	private int id;
	private String nom,alergie,traitement,medicament,dose, prix;
	
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
	public String getAlergie() {
		return alergie;
	}
	public void setAlergie(String alergie) {
		this.alergie = alergie;
	}
	public String getTraitement() {
		return traitement;
	}
	public void setTraitement(String traitement) {
		this.traitement = traitement;
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
	
	public Prescription() {
		
	}
	public Prescription(int id, String nom, String alergie, String traitement, String medicament, String dose,
			String prix) {
		super();
		this.id = id;
		this.nom = nom;
		this.alergie = alergie;
		this.traitement = traitement;
		this.medicament = medicament;
		this.dose = dose;
		this.prix = prix;
	}
	public Prescription(String nom, String alergie, String traitement, String medicament, String dose,
			String prix) {

		this.nom = nom;
		this.alergie = alergie;
		this.traitement = traitement;
		this.medicament = medicament;
		this.dose = dose;
		this.prix = prix;
	}

}
