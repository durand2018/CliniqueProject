package fr.eni.clinique.ihm.gestionpersonnel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.LoginMger;
import fr.eni.clinique.bo.Personnels;
import fr.eni.clinique.ihm.MiseEnPage;

@SuppressWarnings("serial")
public class ModeleDynamique extends AbstractTableModel {

	private LoginMger mger = null;
	private List<Personnels> listePerso;

	private final String[] entetes = { "Nom", "Prénom", "MDP", "Role" };

	public ModeleDynamique() {
		MiseEnPage.getMiseEnPage();
		try {
			mger = LoginMger.getInstance();
			listePerso = mger.getListePnonArchive();
		} catch (BLLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int getRowCount() {
		return listePerso.size();
	}
	// ************

	@Override
	public int getColumnCount() {
		return entetes.length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return entetes[columnIndex];
	}

	@Override
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
