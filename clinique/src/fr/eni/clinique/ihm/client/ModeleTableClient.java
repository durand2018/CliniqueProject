package fr.eni.clinique.ihm.client;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.ClientsMger;
import fr.eni.clinique.bo.Clients;


@SuppressWarnings("serial")
public class ModeleTableClient extends AbstractTableModel {

	private ClientsMger mger = null;
	private List<Clients> listeClients;
	
	private final String[] entetes = { "NomClient", "PrenomClient", "CodePostal","Ville" };

	public ModeleTableClient(String saisie) {

		try {
			mger = ClientsMger.getInstance();
			listeClients = mger.rechercherClt(saisie);
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public int getRowCount() {
		return listeClients.size();
	}
	//************

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
			return listeClients.get(rowIndex).getNomClient();
		case 1:
			return listeClients.get(rowIndex).getPrenomClient();
		case 2:
			return listeClients.get(rowIndex).getCodePostal();
		case 3:
			return listeClients.get(rowIndex).getVille();
		default:
			return null; // Ne devrait jamais arriver
		}
	}
}
