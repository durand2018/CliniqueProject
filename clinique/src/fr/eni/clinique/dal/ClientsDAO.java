package fr.eni.clinique.dal;

import java.util.List;
import fr.eni.clinique.bo.Clients;


public interface ClientsDAO {

public Clients selectByCode(int code) throws DALException;
	
	public List<Clients> selectAll() throws DALException;

	public List<Clients> selectAllNoArchive() throws DALException;
	
	public void update(Clients data) throws DALException;
	
	public void insert(Clients data) throws DALException;
	
	public void delete(int code) throws DALException;
}
