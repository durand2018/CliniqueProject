package fr.eni.clinique.dal;

import fr.eni.clinique.dal.jdbc.AnimauxDAOJdbcImpl;
import fr.eni.clinique.dal.jdbc.ClientsDAOJdbcImpl;
import fr.eni.clinique.dal.jdbc.PersonnelDAOJdbcImpl;

public class DAOFactory<T> {
	
	public static PersonnelDAO getPersonnelDAO()  {
		PersonnelDAO personnelDAO = new PersonnelDAOJdbcImpl();
		return personnelDAO;
		}
	
	public static AnimauxDAO getAnimauxDAO()  {
		AnimauxDAO animalDAO = new AnimauxDAOJdbcImpl();
		return animalDAO;
		}
	
	public static ClientsDAO getClientsDAO()  {
		ClientsDAO clientDAO = new ClientsDAOJdbcImpl();
		return clientDAO;
		}

}
