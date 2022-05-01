package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import java.util.ArrayList;
import metier.Patient;


public class GestionPatient implements IGestionPatient{

	private Connection connection=SingletonConnection.getConnection();
//ajouter
	public void AddPatient(Patient e){
		try {
			PreparedStatement ps=connection.prepareStatement("insert into patient (nom,adresse,alergie,sexe,telephone,date_naissance) values(?,?,?,?,?,?)");
		    ps.setString(1, e.getNom());
		    ps.setString(2, e.getAdresse());
		    ps.setString(3, e.getAlergie());
		    ps.setString(4, e.getSexe());
		    ps.setString(5, e.getTelephone());
		    ps.setString(6, e.getDate_naissance());
		    ps.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

//consulter la liste des patients	
	public List<Patient> getAllPatient() {
		List<Patient> Liste = new ArrayList<>();
		try {
			PreparedStatement ps = connection.prepareStatement("select * from patient ");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			   Patient p = new Patient();
			   p.setId(rs.getInt(1));
			   p.setNom(rs.getString(2));
			   p.setAdresse(rs.getString(3));
			   p.setAlergie(rs.getString(4));
			   p.setSexe(rs.getString(5));
			   p.setTelephone(rs.getString(6));
			   p.setDate_naissance(rs.getString(7));
			   Liste.add(p);
		   }
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return Liste;
	}


//modifier patient
	public void UpdatePatient(Patient p){
		try {
			PreparedStatement ps=connection.prepareStatement("update patient set nom=?, adresse=?, alergie=? , sexe=? ,telephone=? ,date_naissance=? where id =? ");
		    ps.setString(1, p.getNom());
		    ps.setString(2, p.getAdresse());
		    ps.setString(3, p.getAlergie());
		    ps.setString(4, p.getSexe());
		    ps.setString(5, p.getTelephone());
		    ps.setString(6, p.getDate_naissance());
		    ps.setInt(7, p.getId());
		    ps.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} 
	}
//supprimer par id
	public void deletePatient(int id) {
		try {
			PreparedStatement ps = connection.prepareStatement("delete from patient where id=? ");
		    ps.setInt(1, id);
		    ps.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
//consulter; rechercher par nom
	public List<Patient> getPatientParNom(String mc) {
		List<Patient> Liste =  new ArrayList<>();
		try {
			PreparedStatement ps = connection.prepareStatement("select * from patient where nom like ?");
		    ps.setString(1, "%"+mc+"%");
		    ResultSet rs = ps.executeQuery();
		   while(rs.next()) {
			   Patient p = new Patient();
			   p.setId(rs.getInt(1));
			   p.setNom(rs.getString(2));
			   p.setAdresse(rs.getString(3));
			   p.setAlergie(rs.getString(4));
			   p.setSexe(rs.getString(5));
			   p.setTelephone(rs.getString(6));
			   p.setDate_naissance(rs.getString(7));
			   Liste.add(p);
		   }
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return Liste;
		
	}
	
}