package fr.eni.clinique.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.bo.Clients;
import fr.eni.clinique.dal.ClientsDAO;
import fr.eni.clinique.dal.DALException;

public class ClientsDAOJdbcImpl implements ClientsDAO {

	private static final String sqlInsert = "insert into Clients(NomClient,PrenomClient,Adresse1,Adresse2,CodePostal,Ville,NumTel,Assurance,Email,remarque,Archive) values(?,?,?,?,?,?,?,?,?,?,?)";
	private static final String sqlSelectByCode = "select * from Clients where CodeClient = ?";
	private static final String sqlSelectAll = "select * from Clients";
	private static final String sqlSelectAllNoArchive = "select * from Clients where Archive = 0";
	private static final String sqlUpdate = "update Clients set NomClient=?,PrenomClient=?,Adresse1=?,Adresse2=?,CodePostal=?,Ville=?,NumTel=?,Assurance=?,Email=?,Remarque=?,Archive=? where CodeClient=?";
	private static final String sqlDelete = "update Clients set Archive=1 where CodeClient=?";
	private static final String sqlFind = "select * from Clients where NomClient LIKE ?";

	@Override
	public List<Clients> selectByNomPartiel(String saisie) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Clients client = null;
		List<Clients> lesClientsParNomPartiel = new ArrayList<>();
		try {
			// Lancement connexion
			cnx = JdbcTools.getConnection();
			// Lancement Select sur la BDD
			rqt = cnx.prepareStatement(sqlFind);
			rqt.setString(1, saisie+"%");
			
			// Execution Select
			rs = rqt.executeQuery();
			while (rs.next()) {
				client = new Clients();

				client.setCodeClient(rs.getInt("CodeClient"));
				client.setNomClient(rs.getString("NomClient"));
				client.setPrenomClient(rs.getString("PrenomClient"));
				client.setAdresse1(rs.getString("Adresse1"));
				client.setAdresse2(rs.getString("Adresse2"));
				client.setCodePostal(rs.getString("CodePostal"));
				client.setVille(rs.getString("Ville"));
				client.setNumTel(rs.getString("NumTel"));
				client.setAssurance(rs.getString("Assurance"));
				client.setEmail(rs.getString("Email"));
				client.setRemarque(rs.getString("Remarque"));
				client.setArchive(rs.getBoolean("Archive"));
				lesClientsParNomPartiel.add(client);
			}
			return lesClientsParNomPartiel;

		} catch (SQLException e) {
			throw new DALException("Aucun Client ne commence par ces lettres ! - " + saisie, e);
		} finally {
			JdbcTools.closeConnection();
		}
	}
	
	@Override
	public Clients selectByCode(int codeClient) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Clients client = null;
		try {
			// Lancement connexion
			cnx = JdbcTools.getConnection();
			// Lancement Select sur la BDD
			rqt = cnx.prepareStatement(sqlSelectByCode);
			rqt.setInt(1, codeClient);
			// Execution Select
			rs = rqt.executeQuery();
			if (rs.next()) {
				client = new Clients();
				client.setCodeClient(rs.getInt("CodeClient"));
				client.setNomClient(rs.getString("NomClient"));
				client.setPrenomClient(rs.getString("PrenomClient"));
				client.setAdresse1(rs.getString("adresse1"));
				client.setAdresse2(rs.getString("adresse2"));
				client.setCodePostal(rs.getString("CodePostal"));
				client.setVille(rs.getString("Ville"));
				client.setNumTel(rs.getString("NumTel"));
				client.setAssurance(rs.getString("Assurance"));
				client.setEmail(rs.getString("Email"));
				client.setRemarque(rs.getString("Remarque"));
				client.setArchive(rs.getBoolean("Archive"));
			}
			return client;

		} catch (SQLException e) {
			throw new DALException("Ce Client n'existe pas! (patate..) - " + codeClient, e);
		} finally {
			JdbcTools.closeConnection();
		}
	}

	@Override
	public List<Clients> selectAll() throws DALException {
		// TODO Auto-generated method stub
		Connection cnx = null;
		Statement rqt = null;
		ResultSet rs = null;
		Clients client = null;
		List<Clients> lesClients = new ArrayList<>();
		try {
			// Lancement connexion
			cnx = JdbcTools.getConnection();
			// Preparation Select sans argument sur la BDD
			rqt = cnx.createStatement();
			// Execution Select
			rs = rqt.executeQuery(sqlSelectAll);
			// transfert infos BDD dans la liste
			while (rs.next()) {
				client = new Clients();

				client.setCodeClient(rs.getInt("CodeClient"));
				client.setNomClient(rs.getString("NomClient"));
				client.setPrenomClient(rs.getString("PrenomClient"));
				client.setAdresse1(rs.getString("Adresse1"));
				client.setAdresse2(rs.getString("Adresse2"));
				client.setCodePostal(rs.getString("CodePostal"));
				client.setVille(rs.getString("Ville"));
				client.setNumTel(rs.getString("NumTel"));
				client.setAssurance(rs.getString("Assurance"));
				client.setEmail(rs.getString("Email"));
				client.setRemarque(rs.getString("Remarque"));
				client.setArchive(rs.getBoolean("Archive"));
				lesClients.add(client);
			}
			return lesClients;
		} catch (SQLException e) {
			throw new DALException("select all Clients echou� ", e);
		} finally {
			JdbcTools.closeConnection();
		}
	}

	@Override
	public List<Clients> selectAllNoArchive() throws DALException {
		
		Connection cnx = null;
		Statement rqt = null;
		ResultSet rs = null;
		Clients client = null;
		List<Clients> lesClientsActifs = new ArrayList<>();
		try {
			//Lancement connexion
			cnx = JdbcTools.getConnection();
			//Preparation Select sans argument sur la BDD
			rqt = cnx.createStatement();
			//Execution Select 
			rs = rqt.executeQuery(sqlSelectAllNoArchive);
			//transfert infos BDD dans la liste
			while (rs.next()) {
				client = new Clients();

				client.setCodeClient(rs.getInt("CodeClient"));
				client.setNomClient(rs.getString("NomClient"));
				client.setPrenomClient(rs.getString("PrenomClient"));
				client.setAdresse1(rs.getString("Adresse1"));
				client.setAdresse2(rs.getString("Adresse2"));
				client.setCodePostal(rs.getString("CodePostal"));
				client.setVille(rs.getString("Ville"));
				client.setNumTel(rs.getString("NumTel"));
				client.setAssurance(rs.getString("Assurance"));
				client.setEmail(rs.getString("Email"));
				client.setRemarque(rs.getString("Remarque"));
				client.setArchive(rs.getBoolean("Archive"));
				lesClientsActifs.add(client);
			}
			return lesClientsActifs;
		} catch (SQLException e) {
			throw new DALException("select personnel actif failed - ", e);
		} finally {
			JdbcTools.closeConnection();
		}
	}

	
	@Override
	public void update(Clients c) throws DALException {
		// TODO Auto-generated method stub
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {
			//Lancement connexion
			cnx = JdbcTools.getConnection();
			//Lancement Select sur la BDD
			rqt = cnx.prepareStatement(sqlUpdate);
			rqt.setString(1, c.getNomClient());
			rqt.setString(2, c.getPrenomClient());
			rqt.setString(3, c.getAdresse1());
			rqt.setString(4, c.getAdresse2());
			rqt.setString(5, c.getCodePostal());
			rqt.setString(6, c.getVille());
			rqt.setString(7, c.getNumTel());
			rqt.setString(8, c.getAssurance());
			rqt.setString(9, c.getEmail());
			rqt.setString(10, c.getRemarque());
			rqt.setBoolean(11, c.getArchive());
			rqt.setInt(12, c.getCodeClient());
			//Execution Select
			rqt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("update personnel failed - " + c, e);
		} finally {
			JdbcTools.closeConnection();
		}

	}

	@Override
	public void insert(Clients data) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {
			//Lancement connexion
			cnx = JdbcTools.getConnection();
			//Lancement Select sur la BDD
			rqt = cnx.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
			String nomclient = data.getNomClient();
			String prenomclient = data.getPrenomClient();
			String Adresse1 = data.getAdresse1();
			String Adresse2 = data.getAdresse2();
			String CodePostal = data.getCodePostal();
			String Ville = data.getVille();
			String NumTel = data.getNumTel();
			String Assurance = data.getAssurance();
			String Email = data.getEmail();
			String Remarque = data.getRemarque();
			boolean archive = data.getArchive();

			rqt.setString(1, nomclient);
			rqt.setString(2, prenomclient);
			rqt.setString(3, Adresse1);
			rqt.setString(4, Adresse2);
			rqt.setString(5, CodePostal);
			rqt.setString(6, Ville);
			rqt.setString(7, NumTel);
			rqt.setString(8, Assurance);
			rqt.setString(9, Email);
			rqt.setString(10, Remarque);
			rqt.setBoolean(11, archive);
			
			//Execution Select
			int nbRows = rqt.executeUpdate();
			if (nbRows == 1) {
				//R�cup�ration identifiant g�n�r� par la BDD
				ResultSet rs = rqt.getGeneratedKeys();
				if (rs.next()) {
					int cle = rs.getInt(1);
					data.setCodeClient(cle);
				}
			}
		} catch (SQLException e) {
			throw new DALException("Insertion du client non effectu�e - " + data, e);
		} finally {
			JdbcTools.closeConnection();
		}

	}

	@Override
	public void delete(int codeClient) throws DALException {
		// TODO Auto-generated method stub
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {
			System.out.println("codeClt delete =" + codeClient);
			//Lancement connexion
			cnx = JdbcTools.getConnection();
			//Lancement Select sur la BDD
			rqt = cnx.prepareStatement(sqlDelete);
			rqt.setInt(1, codeClient);
			//Execution Select
			rqt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("Supression d'un membre rat�e - " + codeClient, e);
		} finally {
			JdbcTools.closeConnection();
		}
	}
}


