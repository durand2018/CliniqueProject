package fr.eni.clinique.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.bo.Personnels;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.DAOFactory;
import fr.eni.clinique.dal.PersonnelDAO;


public class LoginMger {
	private static LoginMger instance = null;
	private PersonnelDAO daoPersonnel = DAOFactory.getPersonnelDAO();
	private List<Personnels> liste;
	
	private LoginMger() throws BLLException {
		super();
		try{
			liste = daoPersonnel.selectAll();
		} catch (DALException e){
			throw new BLLException("Erreur liste personnel", e);
		}
	}
	
	public static synchronized LoginMger getInstance() throws BLLException{
		if (instance == null){
			instance = new LoginMger();
		}
		return instance;
	}
	
	public List<Personnels> getList() throws BLLException {
		try {
			liste = daoPersonnel.selectAll();
		} catch (DALException e) {
			throw new BLLException("Erreur liste personnel", e);
		}
		return liste;
	}
	
	public void addPersonnel(Personnels p) throws BLLException{
		if (p.getCodePers()!=0){
			throw new BLLException("Membre de personnel déjà enregistré");
		}
		validerPersonnel(p);
		try{
			daoPersonnel.insert(p);
		} catch (DALException e){
			throw new BLLException("Echec addPersonnel "+ p ,e);
		}
	}
	
	public void updatePersonnel(Personnels p) throws BLLException{
		validerPersonnel(p);
		try {
			daoPersonnel.update(p);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			throw new BLLException("Echec updatePersonnel "+ p ,e);
		}
	}
	
	public void removePersonnel(int numeroLigne) throws BLLException{
		try{
			daoPersonnel.delete(getPersonnel(numeroLigne).getCodePers());
		} catch (DALException e){
			throw new BLLException("Echec deletePersonnel "+ numeroLigne, e);
		}
	}
	
	public Personnels getPersonnel(int codePers){
		return liste.get(codePers);
	}
	
	public void validerPersonnel(Personnels p) throws BLLException {
		boolean test = true;
		StringBuffer sb = new StringBuffer();
		if (p.getNom().equals(null) ||p.getNom().trim().isEmpty()){
			test=false;
		sb.append("Nom non renseigné \n");
		}
		if (p.getPrenom().equals(null) ||p.getPrenom().trim().isEmpty()){
			test=false;
		sb.append("Prénom non renseigné \n");
		}
		if (p.getMotPasse().equals(null) ){
			test=false;
		sb.append("saisir au moin un caractere \n");
		}
		if (test==false)
		{
		throw new BLLException(sb.toString());
		}
	}
}
