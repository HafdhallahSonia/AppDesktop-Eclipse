package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.Traitement;

public class GestionTraitement implements IGestionTraitement{
	
	private Connection connection=SingletonConnection.getConnection();
	//ajouter 
	public void AddTraitement(Traitement e) {
		try {
			PreparedStatement ps=connection.prepareStatement("insert into traitement (nom, medicament,traitement, dose, prix) values(?,?,?,?,?)");
		    ps.setString(1, e.getNom());
		    ps.setString(2, e.getMedicament());
		    ps.setString(3, e.getTraitement());
		    ps.setString(4, e.getDose());
		    ps.setString(5, e.getPrix());
		    ps.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}

	//Consulter la liste
	public List<Traitement> getAllTraitement() {
		List<Traitement> Liste = new ArrayList<>();
		try {
			PreparedStatement ps = connection.prepareStatement("select * from traitement ");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Traitement t = new Traitement();
			   t.setId(rs.getInt(1));
			   t.setNom(rs.getString(2));
			   t.setMedicament(rs.getString(3));
			   t.setTraitement(rs.getString(4));
			   t.setDose(rs.getString(5));
			   t.setPrix(rs.getString(6));
			   Liste.add(t);
		   }
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return Liste;
	}

	//rechercher par nom
	public List<Traitement> getTraitementParNom(String nom) {
		List<Traitement> Liste = new ArrayList<>();
		try {
			PreparedStatement ps = connection.prepareStatement("select * from traitement where nom like ?");
			ps.setString(1, nom);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Traitement t = new Traitement();
			   t.setId(rs.getInt(1));
			   t.setNom(rs.getString(2));
			   t.setMedicament(rs.getString(3));
			   t.setTraitement(rs.getString(4));
			   t.setDose(rs.getString(5));
			   t.setPrix(rs.getString(6));
			   Liste.add(t);
		   }
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return Liste;
	}

	//modifier
	public void UpdateTraitment(Traitement R) {
		try {
			PreparedStatement ps=connection.prepareStatement("update traitement set nom=?, medicament=?, traitement=?, dose=?, prix=? where id =? ");
		    ps.setString(1, R.getNom());
		    ps.setString(2, R.getMedicament());
		    ps.setString(3, R.getTraitement());
		    ps.setString(4, R.getDose());
		    ps.setString(5, R.getPrix());
		    ps.setInt(6, R.getId());
		    ps.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} 
		
	}

	//supprimer
	public void deleteTraitement(int id) {
		try {
			PreparedStatement ps = connection.prepareStatement("delete from traitement where id=? ");
		    ps.setInt(1, id);
		    ps.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}
}
