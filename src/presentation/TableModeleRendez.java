package presentation;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import metier.Rendez_vous;

public class TableModeleRendez extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	
  List<Rendez_vous> liste=new ArrayList<>();
  String titres[]= {"id","Nom et Prènom","Date","Heure"};
  
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
		case 2:return liste.get(l).getDate_R();
		case 3:return liste.get(l).getHeure();
			
		}
		return null;
	}
	
	
		public String getColumnName(int column) {
			return titres[column];
		}
	
	public void chargerTable(List<Rendez_vous> L) {
		this.liste = L;
		fireTableDataChanged();
	}
	
}
