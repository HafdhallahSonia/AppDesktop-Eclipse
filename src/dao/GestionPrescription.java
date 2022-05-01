package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.Prescription;

public class GestionPrescription implements IGestionPrescription{
	private Connection connection=SingletonConnection.getConnection();
	@Override
	public void AddPrescription(Prescription e) {
		try {
			PreparedStatement ps=connection.prepareStatement("insert into prescription (nom, alergie, traitement, medicament, dose, prix) values(?,?,?,?,?,?)");
		    ps.setString(1, e.getNom());
		    ps.setString(2, e.getAlergie());
		    ps.setString(3, e.getTraitement());
		    ps.setString(4, e.getMedicament());
		    ps.setString(5, e.getDose());
		    ps.setString(6, e.getPrix());
		    ps.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}

	@Override
	public List<Prescription> getAllPrescription() {
		List<Prescription> Liste = new ArrayList<>();
		try {
			PreparedStatement ps = connection.prepareStatement("select * from prescription ");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			   Prescription t = new Prescription();
			   t.setId(rs.getInt(1));
			   t.setNom(rs.getString(2));
			   t.setAlergie(rs.getString(3));
			   t.setTraitement(rs.getString(4));
			   t.setMedicament(rs.getString(5));
			   t.setDose(rs.getString(6));
			   t.setPrix(rs.getString(7));
			   Liste.add(t);
		   }
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return Liste;
	}

	@Override
	public List<Prescription> getPrescriptionParNom(String nom) {
		List<Prescription> Liste = new ArrayList<>();
		try {
			PreparedStatement ps = connection.prepareStatement("select * from prescription where nom like ?");
			ps.setString(1, nom);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			   Prescription t = new Prescription();
			   t.setId(rs.getInt(1));
			   t.setNom(rs.getString(2));
			   t.setAlergie(rs.getString(3));
			   t.setTraitement(rs.getString(4));
			   t.setMedicament(rs.getString(5));
			   t.setDose(rs.getString(6));
			   t.setPrix(rs.getString(7));
			   Liste.add(t);
		   }
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return Liste;
		
	}

}
