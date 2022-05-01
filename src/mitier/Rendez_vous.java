package metier;

public class Rendez_vous {
	private int id;
	private String nom;
	private String date_R;
	private String Heure;
    
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDate_R() {
		return date_R;
	}
	public void setDate_R(String date_R) {
		this.date_R = date_R;
	}
	public String getHeure() {
		return Heure;
	}
	public void setHeure(String heure) {
		Heure = heure;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Rendez_vous() {
	}
	
	public Rendez_vous(String nom, String date_R, String heure) {
		this.nom = nom;
		this.date_R = date_R;
		this.Heure = heure;
	}
	public Rendez_vous(int id, String nom, String date_R, String heure) {
		super();
		this.id = id;
		this.nom = nom;
		this.date_R = date_R;
		this.Heure = heure;
	}
	public Rendez_vous( String nom, String date_R, String heure, int id) {
		super();
		this.id = id;
		this.nom = nom;
		this.date_R = date_R;
		this.Heure = heure;
	}

	

}
