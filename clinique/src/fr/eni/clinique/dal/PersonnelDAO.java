package fr.eni.clinique.dal;

import java.util.List;
import fr.eni.clinique.bo.Personnels;


public interface PersonnelDAO {
	
	public Personnels selectByCode(int code) throws DALException;
	
	public List<Personnels> selectAll() throws DALException;
	
	public List<Personnels> selectAllNoArchive() throws DALException;
	
	public void update(Personnels data) throws DALException;
	
	public void insert(Personnels data) throws DALException;
	
	public void delete(int code) throws DALException;

}
