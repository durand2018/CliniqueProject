package fr.eni.clinique.dal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import fr.eni.clinique.dal.DALException;

public class JdbcTools  {
	
	private static Connection connection;
	
	private static String urldb;
	private static String userdb;
	private static String passworddb;

	//bloc d'initialisation statique
	static {
		try {
			Class.forName(Settings.getProperty("driverdb"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		urldb = Settings.getProperty("urldb");
		userdb = Settings.getProperty("userdb");
		passworddb = Settings.getProperty("passworddb");
//		System.out.println("urldb: " + urldb);
//		System.out.println("userdb: " + userdb);
//		System.out.println("passworddb: " +passworddb);
	}
	
	//Connexion à la Base de données
	public static Connection getConnection() throws SQLException{
		if (connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(urldb, userdb, passworddb);
		}
		return connection;
	}
	
	//Fermeture connexion base de données
	public static void closeConnection() throws DALException {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new DALException("close connection failed - ", e);
			}
			connection = null;
		}
	}
}
