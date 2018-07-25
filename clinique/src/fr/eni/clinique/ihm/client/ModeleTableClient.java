package fr.eni.clinique.ihm.client;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.ClientsMger;
import fr.eni.clinique.bo.Clients;



@SuppressWarnings("serial")
public class ModeleTableClient extends AbstractTableModel {

	private ClientsMger mger = null;
	private List<Clients> listeClients;
	private JTable tableau;
	
	private final String[] entetes = { "NomClient", "PrenomClient", "Adresse1", "Adresse2","CodePostal","Ville","NumTel","Assurance","Email","Remarques" };

	public ModeleTableClient() {

		try {
			mger = ClientsMger.getInstance();
			listeClients = mger.getListcl();
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
			return listeClients.get(rowIndex).getAdresse1();
		case 3:
			return listeClients.get(rowIndex).getAdresse2();
		case 4:
			return listeClients.get(rowIndex).getCodePostal();
		case 5:
			return listeClients.get(rowIndex).getVille();
		case 6:
			return listeClients.get(rowIndex).getNumTel();
		case 7:
			return listeClients.get(rowIndex).getAssurance();
		case 8:
			return listeClients.get(rowIndex).getEmail();
		case 9:
			return listeClients.get(rowIndex).getRemarque();
		default:
			return null; // Ne devrait jamais arriver
		}
	}
}
