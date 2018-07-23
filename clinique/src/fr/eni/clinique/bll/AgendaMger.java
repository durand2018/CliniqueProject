/**
 * 
 */
package fr.eni.clinique.bll;

import java.util.List;

import fr.eni.clinique.bo.Agenda;
import fr.eni.clinique.bo.Clients;
import fr.eni.clinique.dal.AnimauxDAO;
import fr.eni.clinique.dal.ClientsDAO;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.DAOFactory;

/**
 * Classe en charge de
 * @author frimajou2018
 * @date 23 juil. 2018 - 14:18:41
 * clinique - Version 1.0
 */
public class AgendaMger {
	
	private static AgendaMger instance = null;
	private AnimauxDAO daoAnimaux = DAOFactory.getAnimauxDAO();
	private ClientsDAO daoClients = DAOFactory.getClientsDAO();
	private List<Agenda> listeRdv;



private AgendaMger() throws BLLException {
	super();
//	try {
//		listeRdv = 
//	} catch (DALException e) {
//		throw new BLLException("Erreur liste clients", e);
//	}
}



/**
 * Fonction en charge de 
 * @return
 */
public static AgendaMger getInstance() {
	// TODO Auto-generated method stub
	return null;
}
}
