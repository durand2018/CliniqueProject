package fr.eni.clinique.dal;

import java.util.List;

import fr.eni.clinique.bo.Animaux;

public interface AnimauxDAO {
	
public Animaux selectByCode(int code) throws DALException;
	
	public List<Animaux> selectAll() throws DALException;
	
	public List<Animaux> selectAllNoArchive() throws DALException;
	
	public List<Animaux> selectAnimalByClient(int code) throws DALException;
	
	public void update(Animaux data) throws DALException;
	
	public void insert(Animaux data) throws DALException;
	
	public void delete(int code) throws DALException;

}
