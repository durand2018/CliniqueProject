package fr.eni.clinique.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.bo.Animaux;
import fr.eni.clinique.bo.Race;
import fr.eni.clinique.dal.AnimauxDAO;
import fr.eni.clinique.dal.DALException;

public class AnimauxDAOJdbcImpl implements AnimauxDAO {

	// requêtes SQL
	private static final String SQL_INSERT = "insert into Animaux(NomAnimal,Sexe,Couleur,Race,Espece,CodeClient,Tatouage,"
			+ "Archive) values(?,?,?,?,?,?,?,?)";
	private static final String SQL_SELECT_BY_CODE = "select * from Animaux where CodeAnimal = ?";
	private static final String SQL_SELECT_ALL = "select * from Animaux";
	private static final String SQL_SELECT_ALL_NO_ARCHIVE = "select * from Animaux where Archive = 0";
	private static final String SQL_UPDATE = "update Animaux set NomAnimal=?,Sexe=?,Couleur=?,Race=?,Espece=?,CodeClient=?,"
			+ "Tatouage=?,Antecedents=?,Archive=? where CodeAnimal = ?";
	private static final String SQL_DELETE = "delete from Animaux where CodeAnimal=?";
	private static final String SQL_ANIMAL_BY_CLIENT = "SELECT CodeAnimal, NomAnimal, Sexe, Couleur, Race, Espece, CodeClient, Tatouage, Antecedents, Archive FROM Animaux WHERE CodeClient = ?";
	private static final String SQL_ESPECE = "SELECT DISTINCT Espece FROM Races ORDER BY Espece";
	private static final String SQL_SELECT_RACE_BY_ESPECE = "SELECT Race FROM Races WHERE Espece like ? ORDER BY Race;";

	// Constructeur vide
	public AnimauxDAOJdbcImpl() {
		super();
	}

	@Override
	public Animaux selectByCode(int code) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Animaux ani = null;

		try {
			// Lancement connexion
			cnx = JdbcTools.getConnection();
			// Lancement Select sur la BDD
			rqt = cnx.prepareStatement(SQL_SELECT_BY_CODE);
			rqt.setInt(1, code);
			// Execution Select
			rs = rqt.executeQuery();
			// transfert info BDD dans l'instance de ani si une ligne
			// sélectionnée
			if (rs.next()) {
				ani = new Animaux();
				ani.setCodeAnimal(rs.getInt("CodeAnimal"));
				ani.setNomAnimal(rs.getString("nomAnimal"));
				ani.setSexe(rs.getString("sexe"));
				ani.setCouleur(rs.getString("Couleur"));
				ani.setRace(rs.getString("race"));
				ani.setEspece(rs.getString("Espece"));
				ani.setCodeClient(rs.getInt("CodeClient"));
				ani.setTatouage(rs.getString("tatouage"));
				ani.setAntecedents(rs.getString("Antecedents"));
				ani.setArchive(rs.getBoolean("Archive"));
			}
			return ani;
		} catch (SQLException e) {
			throw new DALException("Cet animal n'existe pas ! - " + code, e);
		} finally {
			JdbcTools.closeConnection();
		}
	}

	@Override
	public List<Animaux> selectAll() throws DALException {
		Connection cnx = null;
		Statement rqt = null;
		ResultSet rs = null;
		Animaux ani = null;
		List<Animaux> lesAnimaux = new ArrayList<>();
		try {
			// Lancement connexion
			cnx = JdbcTools.getConnection();
			// Preparation Select sans argument sur la BDD
			rqt = cnx.createStatement();
			// Execution Select
			rs = rqt.executeQuery(SQL_SELECT_ALL);
			// transfert infos BDD dans la liste
			while (rs.next()) {
				ani = new Animaux();
				ani.setCodeAnimal(rs.getInt("CodeAnimal"));
				ani.setNomAnimal(rs.getString("nomAnimal"));
				ani.setSexe(rs.getString("sexe"));
				ani.setCouleur(rs.getString("Couleur"));
				ani.setRace(rs.getString("race"));
				ani.setEspece(rs.getString("Espece"));
				ani.setCodeClient(rs.getInt("CodeClient"));
				ani.setTatouage(rs.getString("tatouage"));
				ani.setAntecedents(rs.getString("Antecedents"));
				ani.setArchive(rs.getBoolean("Archive"));
				lesAnimaux.add(ani);
			}
			return lesAnimaux;
		} catch (SQLException e) {
			throw new DALException("select all animals failed ! - ", e);
		} finally {
			JdbcTools.closeConnection();
		}
	}

	@Override
	public List<Animaux> selectAllNoArchive() throws DALException {
		Connection cnx = null;
		Statement rqt = null;
		ResultSet rs = null;
		Animaux ani = null;
		List<Animaux> lesAnimauxActifs = new ArrayList<>();
		try {
			// Lancement connexion
			cnx = JdbcTools.getConnection();
			// Preparation Select sans argument sur la BDD
			rqt = cnx.createStatement();
			// Execution Select
			rs = rqt.executeQuery(SQL_SELECT_ALL_NO_ARCHIVE);
			// transfert infos BDD dans la liste
			while (rs.next()) {
				ani = new Animaux();

				ani.setCodeAnimal(rs.getInt("CodeAnimal"));
				ani.setNomAnimal(rs.getString("nomAnimal"));
				ani.setSexe(rs.getString("sexe"));
				ani.setCouleur(rs.getString("Couleur"));
				ani.setRace(rs.getString("race"));
				ani.setEspece(rs.getString("Espece"));
				ani.setCodeClient(rs.getInt("CodeClient"));
				ani.setTatouage(rs.getString("tatouage"));
				ani.setAntecedents(rs.getString("Antecedents"));
				ani.setArchive(rs.getBoolean("Archive"));
				lesAnimauxActifs.add(ani);
			}
			return lesAnimauxActifs;
		} catch (SQLException e) {
			throw new DALException("select all animals failed ! - ", e);
		} finally {
			JdbcTools.closeConnection();
		}
	}

	@Override
	public void update(Animaux data) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {
			// Lancement connexion
			cnx = JdbcTools.getConnection();
			// Lancement Select sur la BDD
			rqt = cnx.prepareStatement(SQL_UPDATE);
			rqt.setString(1, data.getNomAnimal());
			rqt.setString(2, data.getSexe());
			rqt.setString(3, data.getCouleur());
			rqt.setString(4, data.getRace());
			rqt.setString(5, data.getEspece());
			rqt.setInt(6, data.getCodeClient());
			rqt.setString(7, data.getTatouage());
			rqt.setString(8, data.getAntecedents());
			rqt.setBoolean(9, data.isArchive());
			rqt.setInt(10, data.getCodeAnimal());
			// Execution Select
			rqt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("update animal failed - " + data, e);
		} finally {
			JdbcTools.closeConnection();
		}
	}

	@Override
	public void insert(Animaux data) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {
			// Lancement connexion
			cnx = JdbcTools.getConnection();
			// Lancement Select sur la BDD
			rqt = cnx.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
			String nomAni = data.getNomAnimal();
			String sexe = data.getSexe();
			String couleur = data.getCouleur();
			String race = data.getRace();
			String espece = data.getEspece();
			int codeClt = data.getCodeClient();
			String tatouage = data.getTatouage();
			boolean archive = data.isArchive();

			rqt.setString(1, nomAni);
			rqt.setString(2, sexe);
			rqt.setString(3, couleur);
			rqt.setString(4, race);
			rqt.setString(5, espece);
			rqt.setInt(6, codeClt);
			rqt.setString(7, tatouage);
			rqt.setBoolean(8, archive);

			// Execution Select
			int nbRows = rqt.executeUpdate();
			if (nbRows == 1) {
				// Récupération identifiant généré par la BDD
				ResultSet rs = rqt.getGeneratedKeys();
				if (rs.next()) {
					int cle = rs.getInt(1);
					data.setCodeAnimal(cle);
				}
			}
		} catch (SQLException e) {
			throw new DALException("insert animal failed - " + data, e);
		} finally {
			JdbcTools.closeConnection();
		}
	}

	@Override
	public void delete(int code) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {
			// Lancement connexion
			cnx = JdbcTools.getConnection();
			// Lancement Select sur la BDD
			rqt = cnx.prepareStatement(SQL_DELETE);
			rqt.setInt(1, code);
			// Execution Select
			rqt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("delete animal failed - " + code, e);
		} finally {
			JdbcTools.closeConnection();
		}
	}

	public List<Animaux> selectAnimalByClient(int CodeClient) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Animaux ani = null;
		List<Animaux> lesAnimaux = new ArrayList<>();
		try {
			// Lancement connexion
			cnx = JdbcTools.getConnection();
			// Preparation Select sans argument sur la BDD
			rqt = cnx.prepareStatement(SQL_ANIMAL_BY_CLIENT);
			rqt.setInt(1, CodeClient);
			// Execution Select
			rs = rqt.executeQuery();
			// transfert infos BDD dans la liste
			while (rs.next()) {
				ani = new Animaux();
				ani.setCodeAnimal(rs.getInt("CodeAnimal"));
				ani.setNomAnimal(rs.getString("NomAnimal"));
				ani.setSexe(rs.getString("Sexe"));
				ani.setCouleur(rs.getString("Couleur"));
				ani.setRace(rs.getString("Race"));
				ani.setEspece(rs.getString("Espece"));
				ani.setCodeClient(rs.getInt("CodeClient"));
				ani.setTatouage(rs.getString("Tatouage"));
				ani.setAntecedents(rs.getString("Antecedents"));
				ani.setArchive(rs.getBoolean("Archive"));
				lesAnimaux.add(ani);
			}
			return lesAnimaux;
		} catch (SQLException e) {
			throw new DALException("select animals by customer failed ! - ", e);
		} finally {
			JdbcTools.closeConnection();
		}
	}

	public List<Race> selectEspece() throws DALException {
		Connection cnx = null;
		Statement rqt = null;
		ResultSet rs = null;
		Race rc = null;
		List<Race> lesEspeces = new ArrayList<>();
		try {
			// Lancement connexion
			cnx = JdbcTools.getConnection();
			// Preparation Select sans argument sur la BDD
			rqt = cnx.createStatement();
			// Execution Select
			rs = rqt.executeQuery(SQL_ESPECE);
			// transfert infos BDD dans la liste
			while (rs.next()) {
				rc = new Race();
				rc.setEspece(rs.getString("Espece"));

				lesEspeces.add(rc);
			}
			return lesEspeces;
		} catch (SQLException e) {
			throw new DALException("select spicies failed ! - ", e);
		} finally {
			JdbcTools.closeConnection();
		}

	}

	public List<Race> selectRaceByEspece(String espece) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Race race = null;
		List<Race> lesRaces = new ArrayList<>();
		try {
			// Lancement connexion
			cnx = JdbcTools.getConnection();
			// Lancement Select sur la BDD
			rqt = cnx.prepareStatement(SQL_SELECT_RACE_BY_ESPECE);
			rqt.setString(1, espece);
			// Execution Select
			rs = rqt.executeQuery();
			// transfert info BDD dans l'instance de race si une ligne
			// sélectionnée
			while (rs.next()) {
				race = new Race();
				race.setRace(rs.getString("Race"));

				lesRaces.add(race);
			}
			return lesRaces;
		} catch (SQLException e) {
			throw new DALException("Cette race ne peut être affefctée ! - " + espece, e);
		} finally {
			JdbcTools.closeConnection();
		}
	}

}
