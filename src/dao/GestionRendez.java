package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import metier.Patient;
import metier.Rendez_vous;

public class GestionRendez implements IGestionRendez{

	private Connection connection=SingletonConnection.getConnection();

	//ajouter
	public void AddRendez(Rendez_vous e) {
		try {
			PreparedStatement ps=connection.prepareStatement("insert into rendez_vous (nom,date,heure) values(?,?,?)");
		    ps.setString(1, e.getNom());
		    ps.setString(2, e.getDate_R());
		    ps.setString(3, e.getHeure());
		    ps.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}
//consulter la liste
	public List<Rendez_vous> getAllRendez() {
		List<Rendez_vous> Liste = new ArrayList<>();
		try {
			PreparedStatement ps = connection.prepareStatement("select * from rendez_vous ");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			   Rendez_vous r = new Rendez_vous();
			   r.setId(rs.getInt(1));
			   r.setNom(rs.getString(2));
			   r.setDate_R(rs.getString(3));
			   r.setHeure(rs.getString(4));
			   Liste.add(r);
		   }
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return Liste;
	}
	//recherche par date 
		public List<Rendez_vous> getRendez_vousParDate(String date) {
			List<Rendez_vous> Liste = new ArrayList<>();
			try {
				PreparedStatement ps = connection.prepareStatement("select * from rendez_vous where date like ? ");
			    ps.setString(1, "%"+date+"%");
			    ResultSet rs = ps.executeQuery();
			   while(rs.next()) {
				   Rendez_vous r = new Rendez_vous();
				   r.setId(rs.getInt(1));
				   r.setNom(rs.getString(2));
				   r.setDate_R(rs.getString(3));
				   r.setHeure(rs.getString(4));
				   Liste.add(r);
			   }
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return Liste;
		}
		//recherche par nom et date
		public List<Rendez_vous> getRendez_vousParNom(String nom, String date) {
			List<Rendez_vous> Liste = new ArrayList<>();
			try {
				PreparedStatement ps = connection.prepareStatement("select * from rendez_vous where nom like ? and date like ?");
			    ps.setString(1, nom);
			    ps.setString(2, "%"+date+"%");
			    ResultSet rs = ps.executeQuery();
			   while(rs.next()) {
				   Rendez_vous r = new Rendez_vous();
				   r.setId(rs.getInt(1));
				   r.setNom(rs.getString(2));
				   r.setDate_R(rs.getString(3));
				   r.setHeure(rs.getString(4));
				   Liste.add(r);
			   }
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return Liste;
			}


	//recherche patient par nom
	public List<Patient> getPatientParNom(String mc) {
		List<Patient> Liste =  new ArrayList<>();
		try {
			PreparedStatement ps = connection.prepareStatement("select * from patient where nom like ?");
		    ps.setString(1, "%"+mc+"%");
		    ResultSet rs = ps.executeQuery();
		   while(rs.next()) {
			   Patient p = new Patient();
			   p.setAlergie(rs.getString(0));
			   Liste.add(p);
		   }
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return Liste;
	}

	//recherche rendez_vous par id
	public Rendez_vous getRendez(int id) {
		Rendez_vous r = null;
		try {
			PreparedStatement ps = connection.prepareStatement("select * from rendez_vous where id = ? ");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			   r = new Rendez_vous();
			   r.setId(rs.getInt(1));
			   r.setNom(rs.getString(2));
			   r.setDate_R(rs.getString(3));
			   r.setHeure(rs.getString(4));
		   }
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return r;
	}

	//modifier
	public void UpdateR(Rendez_vous R) {
		try {
			PreparedStatement ps=connection.prepareStatement("update rendez_vous set nom=?, date=? ,heure=? where id =? ");
		    ps.setString(1, R.getNom());
		    ps.setString(2, R.getDate_R());
		    ps.setString(3, R.getHeure());
		    ps.setInt(4, R.getId());
		    ps.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} 
		
	}

	//supprimer
	public void deleteR(int id) {
		try {
			PreparedStatement ps = connection.prepareStatement("delete from rendez_vous where id=? ");
		    ps.setInt(1, id);
		    ps.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	

}