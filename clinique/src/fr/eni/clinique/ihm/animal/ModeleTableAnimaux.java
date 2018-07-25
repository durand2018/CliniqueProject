package fr.eni.clinique.ihm.animal;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import fr.eni.clinique.bll.AnimalMger;
import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bo.Animaux;

@SuppressWarnings("serial")
public class ModeleTableAnimaux extends AbstractTableModel {

	private AnimalMger mger = null;
	private List<Animaux> listeAnimaux;

	private final String[] entetes = { "Numero", "Nom", "Sexe", "Couleur", "Race", "Espece", "Tatouage" };

	public ModeleTableAnimaux() {
		try {
			mger = AnimalMger.getInstance();
			listeAnimaux = mger.getList();

		} catch (BLLException e) {
			System.out.println("Pb chgt liste Animaux");
		}
		
	}

	@Override
	public int getColumnCount() {
		return entetes.length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return entetes[columnIndex];
	}

	@Override
	public int getRowCount() {
		return listeAnimaux.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return listeAnimaux.get(rowIndex).getCodeAnimal();
		case 1:
			return listeAnimaux.get(rowIndex).getNomAnimal();
		case 2:
			return listeAnimaux.get(rowIndex).getSexe();
		case 3:
			return listeAnimaux.get(rowIndex).getCouleur();
		case 4:
			return listeAnimaux.get(rowIndex).getRace();
		case 5:
			return listeAnimaux.get(rowIndex).getEspece();
		case 6:
			return listeAnimaux.get(rowIndex).getTatouage();
		default:
			return null;// Ne devrait jamais arriver
		}

	}

}
