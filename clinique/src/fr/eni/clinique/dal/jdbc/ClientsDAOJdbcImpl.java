package fr.eni.clinique.dal.jdbc;

import java.util.List;

import fr.eni.clinique.bo.Clients;
import fr.eni.clinique.dal.ClientsDAO;
import fr.eni.clinique.dal.DALException;

public class ClientsDAOJdbcImpl implements ClientsDAO {

	@Override
	public Clients selectByCode(int code) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Clients> selectAll() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Clients> selectAllNoArchive() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void update(Clients data) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(Clients data) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int code) throws DALException {
		// TODO Auto-generated method stub
		
	}

}
