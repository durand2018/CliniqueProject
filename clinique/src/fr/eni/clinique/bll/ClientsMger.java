package fr.eni.clinique.bll;

import java.util.List;


import fr.eni.clinique.bo.Clients;
import fr.eni.clinique.dal.ClientsDAO;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.DAOFactory;

public class ClientsMger {
	private static ClientsMger instance = null;
	private ClientsDAO daoClients = DAOFactory.getClientsDAO();
	private List<Clients> liste;

	public ClientsMger() throws BLLException {
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
	
	public List<Clients> rechercherClt(String saisie) throws BLLException {
		try {
			liste = daoClients.selectByNomPartiel(saisie);
		} catch (DALException e) {
			throw new BLLException("Erreur liste client", e);
		}
		return liste;
	}

	public void addClients(Clients c) throws BLLException {
		if (c.getCodeClient() != 0) {
			throw new BLLException("Client déjà enregistré");
		}
		validerClient(c);
		try {
			daoClients.insert(c);
		} catch (DALException e) {
			throw new BLLException("Echec addClient " + c, e);
		}

	}
	
	public void updateClient(Clients c) throws BLLException{
		validerClient(c);
		try {
			daoClients.update(c);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			throw new BLLException("Echec updateClient "+ c ,e);
		}
	}

	public void removeClient(int numeroClt) throws BLLException{
		try{
			daoClients.delete(numeroClt);
		} catch (DALException e){
			throw new BLLException("Echec delete client "+ numeroClt, e);
			
		}
	}
	
	public Clients getClient(int codeClient){
		return liste.get(codeClient);
	}
	
	public List<Clients> selectAllNoArchive() throws BLLException{
		try {
			liste = daoClients.selectAllNoArchive();
		} catch (DALException e) {
			throw new BLLException("Erreur liste client non archivé", e);
		}
		return liste;
	}
	public Clients selectByCode (int code) throws BLLException{
		Clients client;
		try {
			client = daoClients.selectByCode(code);
		} catch (DALException e) {
			throw new BLLException("Erreur client sélectionné par Id", e);
		}
		return client;
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
