package presentation;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import metier.Patient;

public class TableModele extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	
  List<Patient> liste=new ArrayList<>();
  String titres[]= {"id","Nom et Prènom","Adresse","Alergie","Sexe","Télèphone","date de naissance"};
  
	public int getColumnCount() {
		return titres.length;
	}

	public int getRowCount() {
		return liste.size();
	}

	public Object getValueAt(int l, int c) {
		switch (c) {
		case 0:return liste.get(l).getId();
		case 1:return liste.get(l).getNom();
		case 2:return liste.get(l).getAdresse();
		case 3:return liste.get(l).getAlergie();
		case 4:return liste.get(l).getSexe();
		case 5:return liste.get(l).getTelephone();
		case 6:return liste.get(l).getDate_naissance();
			
		}
		return null;
	}
	
	
		public String getColumnName(int column) {
			return titres[column];
		}
	
	public void chargerTable(List<Patient> L) {
		this.liste = L;
		fireTableDataChanged();
	}
	
}
