package fr.eni.clinique.bll;

import java.util.List;

import fr.eni.clinique.bo.Clients;
import fr.eni.clinique.bo.Personnels;
import fr.eni.clinique.dal.ClientsDAO;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.DAOFactory;
import fr.eni.clinique.dal.PersonnelDAO;

public class ClientsMger {
	private static ClientsMger instance = null;
	private ClientsDAO daoClients = DAOFactory.getClientsDAO();
	private List<Clients> liste;

	private ClientsMger() throws BLLException {
		super();
		try {
			liste = daoClients.selectAll();
		} catch (DALException e) {
			throw new BLLException("Erreur liste clients", e);
		}
	}

	public static synchronized ClientsMger getInstance() throws BLLException {
		if (instance == null) {
			instance = new ClientsMger();
		}
		return instance;
	}

	public List<Clients> getListcl() throws BLLException {
		try {
			liste = daoClients.selectAll();
		} catch (DALException e) {
			throw new BLLException("Erreur liste client", e);
		}
		return liste;
	}

	public void addClients(Clients c) throws BLLException {
		if (c.getCodeClient() != 0) {
			throw new BLLException("Membre de client déjà enregistré");
		}
		validerClient(c);
		try {
			daoClients.insert(c);
		} catch (DALException e) {
			throw new BLLException("Echec addClient " + c, e);
		}

	}
	
	public void updateClients(Clients c) throws BLLException{
		validerClient(c);
		try {
			daoClients.update(c);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			throw new BLLException("Echec updatePersonnel "+ c ,e);
		}
	}

	public void removePersonnel(int numeroLigne) throws BLLException{
		try{
			daoClients.delete(getClients(numeroLigne).getCodeClient());
		} catch (DALException e){
			throw new BLLException("Echec delete client "+ numeroLigne, e);
		}
	}
	public Clients getClients(int codeClient){
		return liste.get(codeClient);
	}
	
	private void validerClient(Clients c) throws BLLException {
		// TODO Auto-generated method stub
		boolean test = true;
		StringBuffer sb = new StringBuffer();
		if (c.getNomClient().equals(null) || c.getNomClient().trim().isEmpty()) {
			test = false;
			sb.append("Nom non renseigné \n");
		}
		if (c.getPrenomClient().equals(null) || c.getPrenomClient().trim().isEmpty()) {
			test = false;
			sb.append("Prénom non renseigné \n");
		}
		if (test == false) {
			throw new BLLException(sb.toString());
		}
	}
}
