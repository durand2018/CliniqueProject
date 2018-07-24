package fr.eni.clinique.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.bo.Personnels;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.PersonnelDAO;

public class PersonnelDAOJdbcImpl implements PersonnelDAO {

	// declaration des requetes sql
	private static final String sqlInsert = "insert into Personnels(Nom,Prenom,MotPasse,Role,Archive) values(?,?,?,?,?)";
	private static final String sqlSelectByCode = "select * from Personnels where CodePers = ?";
	private static final String sqlSelectAll = "select * from Personnels";
	private static final String sqlSelectAllNoArchive = "select * from Personnels where Archive = 0";
	private static final String sqlUpdate = "update Personnels set Nom=?,Prenom=?,MotPasse=?,Role=?,Archive=? where CodePers=?" ;
	private static final String sqlDelete = "update Personnels set Archive=1 where CodePers=?";

	public PersonnelDAOJdbcImpl() {
		super();
	}

	@Override
	public Personnels selectByCode(int code) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Personnels perso = null;
		try {
			//Lancement connexion
			cnx = JdbcTools.getConnection();
			//Lancement Select sur la BDD
			rqt = cnx.prepareStatement(sqlSelectByCode);
			rqt.setInt(1, code);
			//Execution Select 
			rs = rqt.executeQuery();
			if (rs.next()) {
				perso = new Personnels();
				perso.setCodePers(rs.getInt("CodePers"));
				perso.setNom(rs.getString("Nom"));
				perso.setPrenom(rs.getString("Prenom"));
				perso.setMotPasse(rs.getString("MotPasse"));
				perso.setRole(rs.getString("Role"));
				perso.setArchive(rs.getBoolean("Archive"));
			}
			return perso;
		} catch (SQLException e) {
			throw new DALException("Ce membre du personnel n'existe pas ! - " + code, e);
		} finally {
			JdbcTools.closeConnection();
		}
	}

	@Override
	public List<Personnels> selectAll() throws DALException {
		Connection cnx = null;
		Statement rqt = null;
		ResultSet rs = null;
		Personnels perso = null;
		List<Personnels> lePersonnel = new ArrayList<>();
		try {
			//Lancement connexion
			cnx = JdbcTools.getConnection();
			//Preparation Select sans argument sur la BDD
			rqt = cnx.createStatement();
			//Execution Select 
			rs = rqt.executeQuery(sqlSelectAll);
			//transfert infos BDD dans la liste
			while (rs.next()) {
				perso = new Personnels();
				
				perso.setCodePers(rs.getInt("CodePers"));
				perso.setNom(rs.getString("nom"));
				perso.setPrenom(rs.getString("prenom"));
				perso.setMotPasse(rs.getString("motPasse"));
				perso.setRole(rs.getString("role"));
				perso.setArchive(rs.getBoolean("archive"));
				lePersonnel.add(perso);
			}
			return lePersonnel;
		} catch (SQLException e) {
			throw new DALException("select all member failed - ", e);
		} finally {
			JdbcTools.closeConnection();
		}
		
	}

	public List<Personnels> selectAllNoArchive() throws DALException {
		Connection cnx = null;
		Statement rqt = null;
		ResultSet rs = null;
		Personnels perso = null;
		List<Personnels> lePersonnelActif = new ArrayList<>();
		try {
			//Lancement connexion
			cnx = JdbcTools.getConnection();
			//Preparation Select sans argument sur la BDD
			rqt = cnx.createStatement();
			//Execution Select 
			rs = rqt.executeQuery(sqlSelectAllNoArchive);
			//transfert infos BDD dans la liste
			while (rs.next()) {
				perso = new Personnels();
				
				perso.setCodePers(rs.getInt("CodePers"));
				perso.setNom(rs.getString("nom"));
				perso.setPrenom(rs.getString("prenom"));
				perso.setMotPasse(rs.getString("motPasse"));
				perso.setRole(rs.getString("role"));
				perso.setArchive(rs.getBoolean("archive"));
				lePersonnelActif.add(perso);
			}
			return lePersonnelActif;
		} catch (SQLException e) {
			throw new DALException("select personnel actif failed - ", e);
		} finally {
			JdbcTools.closeConnection();
		}
	}
	
	@Override
	public void update(Personnels p1) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {
			//Lancement connexion
			cnx = JdbcTools.getConnection();
			//Lancement Select sur la BDD
			rqt = cnx.prepareStatement(sqlUpdate);
			rqt.setString(1, p1.getNom());
			rqt.setString(2, p1.getPrenom());
			rqt.setString(3, p1.getMotPasse());
			rqt.setString(4, p1.getRole());
			rqt.setBoolean(5, p1.isArchive());
			rqt.setInt(6, p1.getCodePers());
			//Execution Select
			rqt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("update personnel failed - " + p1, e);
		} finally {
			JdbcTools.closeConnection();
		}
	}

	@Override
	public void insert(Personnels data) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {
			//Lancement connexion
			cnx = JdbcTools.getConnection();
			//Lancement Select sur la BDD
			rqt = cnx.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
			String nom = data.getNom();
			String prenom = data.getPrenom();
			String motPasse = data.getMotPasse();
			String role = data.getRole();
			boolean archive = data.isArchive();

			rqt.setString(1, nom);
			rqt.setString(2, prenom);
			rqt.setString(3, motPasse);
			rqt.setString(4, role);
			rqt.setBoolean(5, archive);
			
			//Execution Select
			int nbRows = rqt.executeUpdate();
			if (nbRows == 1) {
				//R�cup�ration identifiant g�n�r� par la BDD
				ResultSet rs = rqt.getGeneratedKeys();
				if (rs.next()) {
					int cle = rs.getInt(1);
					data.setCodePers(cle);
				}
			}
		} catch (SQLException e) {
			throw new DALException("Insertion de personnel non effectuée - " + data, e);
		} finally {
			JdbcTools.closeConnection();
		}
	}

	/**
	 * Fonction qui gère l'archivage du membre du personnel supprimé
	 * codePers
	 */
	public void delete(int codePers) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {
			//Lancement connexion
			cnx = JdbcTools.getConnection();
			//Lancement Select sur la BDD
			rqt = cnx.prepareStatement(sqlDelete);
			rqt.setInt(1, codePers);
			//Execution Select
			rqt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("Supression d'un membre ratée - " + codePers, e);
		} finally {
			JdbcTools.closeConnection();
		}
	}

	
}
