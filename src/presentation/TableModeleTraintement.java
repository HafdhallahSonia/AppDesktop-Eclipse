package presentation;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import metier.Traitement;

public class TableModeleTraintement extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	
  List<Traitement> liste=new ArrayList<>();
  String titres[]= {"id","Nom et Prènom","Traitement","Medicament","Dose","Prix"};
  
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
		case 2:return liste.get(l).getTraitement();
		case 3:return liste.get(l).getMedicament();
		case 4:return liste.get(l).getDose();
		case 5:return liste.get(l).getPrix();	
		}
		return null;
	}
	
	
		public String getColumnName(int column) {
			return titres[column];
		}
	
	public void chargerTable(List<Traitement> L) {
		this.liste = L;
		fireTableDataChanged();
	}
	
}
