package metier;

public class Patient {
	private int id;
	private String nom, adresse, alergie, sexe, telephone;
	private String date_naissance;
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
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getAlergie() {
		return alergie;
	}
	public void setAlergie(String algerie) {
		this.alergie = algerie;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getDate_naissance() {
		return date_naissance;
	}
	public void setDate_naissance(String date_naissance) {
		this.date_naissance = date_naissance;
	}
	
	
	public Patient() {
		
	}
	
	public Patient(int id, String nom, String adresse, String alergie, String sexe, String telephone,
			String date_naissance) {
		super();
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.alergie = alergie;
		this.sexe = sexe;
		this.telephone = telephone;
		this.date_naissance = date_naissance;
	}
	public Patient(String nom, String adresse, String alergie, String sexe, String telephone,
			String date_naissance, int id) {
		super();
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.alergie = alergie;
		this.sexe = sexe;
		this.telephone = telephone;
		this.date_naissance = date_naissance;
	}
	
	public Patient(String nom, String adresse, String alergie, String sexe, String telephone,
			String date_naissance) {
		this.nom = nom;
		this.adresse = adresse;
		this.alergie = alergie;
		this.sexe = sexe;
		this.telephone = telephone;
		this.date_naissance = date_naissance;
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	public int compareTo(Patient o) {
		// TODO Auto-generated method stub
		return this.nom.compareTo(o.nom);
	}
	
	
}
