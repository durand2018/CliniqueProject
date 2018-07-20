package fr.eni.clinique.bll;

import java.util.List;

import fr.eni.clinique.bo.Animaux;
import fr.eni.clinique.dal.AnimauxDAO;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.DAOFactory;

public class AnimalMger {

	private static AnimalMger instance = null;
	private AnimauxDAO daoAnimal = DAOFactory.getAnimauxDAO();
	private List<Animaux> liste;

	private AnimalMger() throws BLLException {
		super();
		try {
			liste = daoAnimal.selectAll();
		} catch (DALException e) {
			throw new BLLException("Erreur dans la liste des animaux.", e);
		}
	}

	public static synchronized AnimalMger getInstance() throws BLLException {
		if (instance == null) {
			instance = new AnimalMger();
		}
		return instance;
	}

	public List<Animaux> getList() throws BLLException {
		try {
			liste = daoAnimal.selectAll();
		} catch (DALException e) {
			throw new BLLException("Erreur dans la liste des animaux.", e);
		}
		return liste;
	}

	public void addAnimaux(Animaux a) throws BLLException {
		if (a.getCodeAnimal() != 0) {
			throw new BLLException("Animal déjà enregistré");
		}
		validerAnimal(a);
		try {
			daoAnimal.insert(a);
		} catch (DALException e) {
			throw new BLLException("Echec de l'ajout d'un animal " + a, e);
		}
	}

	public void updateAnimal(Animaux a) throws BLLException {
		validerAnimal(a);
		try {
			daoAnimal.update(a);
		} catch (DALException e) {
			throw new BLLException("Echec de l'ajout d'animal " + a, e);
		}
	}

	public void removeAnimal(int codeAnimal) throws BLLException {
		try {
			daoAnimal.delete(liste.get(codeAnimal).getCodeAnimal());
		} catch (DALException e) {
			throw new BLLException("Echec suppression animal " + codeAnimal, e);
		}
	}

	public Animaux getAnimal(int codeAnimal) {
		return liste.get(codeAnimal);
	}

	public void validerAnimal(Animaux a) throws BLLException {
		boolean test = true;
		StringBuffer sb = new StringBuffer();
		if (a.getNomAnimal().equals(null) || a.getNomAnimal().trim().isEmpty()) {
			test = false;
			sb.append("Nom de l'animal non renseigné \n");
		}
		if (a.getCouleur().equals(null) || a.getCouleur().trim().isEmpty()) {
			test = false;
			sb.append("Couleur non renseignée \n");
		}
		if (a.getEspece().equals(null)) {
			test = false;
			sb.append("Espèce non renseignée \n");
		}
		if (a.getRace().equals(null)) {
			test = false;
			sb.append("Race non renseignée \n");
		}
		if (test == false) {
			throw new BLLException(sb.toString());
		}
	}
	
	public List<Animaux> selectAnimalByClient(int codeClient) throws BLLException {
		try {
			liste = daoAnimal.selectAnimalByClient(codeClient);
		} catch (DALException e) {
			throw new BLLException("Erreur dans la sélection.", e);
		}
		return liste;
	}
}
