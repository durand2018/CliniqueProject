package fr.eni.clinique.ihm.gestionpersonnel;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.LoginMger;
import fr.eni.clinique.bo.Personnels;

public class ModeleDynamique extends AbstractTableModel {

	private LoginMger mger = null;
	private List<Personnels> listePerso;
	private JTable tableau;
	
	private final String[] entetes = { "Nom", "Pr�nom", "MDP", "Role" };

	public ModeleDynamique() {

		try {
			mger = LoginMger.getInstance();
			listePerso = mger.getList();
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getRowCount() {
		return listePerso.size();
	}
	//************

	public int getColumnCount() {
		return entetes.length;
	}

	public String getColumnName(int columnIndex) {
		return entetes[columnIndex];
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return listePerso.get(rowIndex).getNom();
		case 1:
			return listePerso.get(rowIndex).getPrenom();
		case 2:
			return listePerso.get(rowIndex).getRole();
		case 3:
			return listePerso.get(rowIndex).getMotPasse();
		default:
			return null; // Ne devrait jamais arriver
		}
	}
}