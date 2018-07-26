package fr.eni.clinique.bll;

import java.util.List;

import fr.eni.clinique.bo.Animaux;
import fr.eni.clinique.bo.Race;
import fr.eni.clinique.dal.AnimauxDAO;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.DAOFactory;

public class AnimalMger {

	private static AnimalMger instance = null;
	private AnimauxDAO daoAnimal = DAOFactory.getAnimauxDAO();
	private List<Animaux> listeAni;
	private List<Race> listeEscpece;
	private List<Race> listeRace;
	private Animaux a;

	public AnimalMger() throws BLLException {
		super();
		try {
			listeAni = daoAnimal.selectAll();
		} catch (DALException e) {
			throw new BLLException("Erreur dans la listeAni des animaux.", e);
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
			listeAni = daoAnimal.selectAll();
		} catch (DALException e) {
			throw new BLLException("Erreur dans la listeAni des animaux.", e);
		}
		return listeAni;
	}

	public void addAnimaux(Animaux a) throws BLLException {
		if (a.getCodeAnimal() != 0) {
			throw new BLLException("Animal d�j� enregistr�");
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
			daoAnimal.delete(codeAnimal);
		} catch (DALException e) {
			throw new BLLException("Echec suppression animal " + codeAnimal, e);
		}
	}

	public Animaux getAnimal(int codeAnimal) {
		return listeAni.get(codeAnimal);
	}

	public void validerAnimal(Animaux a) throws BLLException {
		boolean test = true;
		StringBuffer sb = new StringBuffer();
		if (a.getNomAnimal().equals(null) || a.getNomAnimal().trim().isEmpty()) {
			test = false;
			sb.append("Nom de l'animal non renseign� \n");
		}
		if (a.getCouleur().equals(null) || a.getCouleur().trim().isEmpty()) {
			test = false;
			sb.append("Couleur non renseign�e \n");
		}
		if (a.getEspece().equals(null)) {
			test = false;
			sb.append("Esp�ce non renseign�e \n");
		}
		if (a.getRace().equals(null)) {
			test = false;
			sb.append("Race non renseign�e \n");
		}
		if (test == false) {
			throw new BLLException(sb.toString());
		}
	}

	public List<Animaux> selectAnimalByClient(int codeClient) throws BLLException {
		try {
			listeAni = daoAnimal.selectAnimalByClient(codeClient);
		} catch (DALException e) {
			throw new BLLException("Erreur dans la s�lection.", e);
		}
		return listeAni;
	}
	
	public Animaux selectAnimalByCode(int codeAnimal) throws BLLException {
		try {
			a = daoAnimal.selectByCode(codeAnimal);
		} catch (DALException e) {
			throw new BLLException("Erreur dans la sélection par id", e);
		}
		return a;
	}
	
	public List<Race> selectEspece() throws BLLException {
		try {
			listeEscpece = daoAnimal.selectEspece();
		} catch (DALException e) {
			throw new BLLException("Erreur dans la s�lection.", e);
		}
		return listeEscpece;
	}

	public List<Race> selectRaceByEspece(String espece) throws BLLException {
		try {
			listeRace = daoAnimal.selectRaceByEspece(espece);
		} catch (DALException e) {
			throw new BLLException("Erreur dans la s�lection.", e);
		}
		return listeRace;
	}

	public List<Race> selectRace() throws BLLException {
		try {
			listeRace = daoAnimal.selectRace();
		} catch (DALException e) {
			throw new BLLException("Erreur dans la s�lection.", e);
		}
		return listeRace;
	}
}
