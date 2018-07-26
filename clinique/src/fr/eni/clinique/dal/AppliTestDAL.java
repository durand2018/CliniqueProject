package fr.eni.clinique.dal;

import java.util.List;

import fr.eni.clinique.bo.Clients;

public class AppliTestDAL {

	public static void main(String[] args) {
		// *******************************************************************************PERSONNEL***********
		// D�claration et instanciation de la DAO sec, vet ou adm)
		// PersonnelDAO PersonnelDAO = DAOFactory.getPersonnelDAO();
		//
		// // Instanciation du jeu d'essai
		// Personnels p1 = new Personnels("ADMIN", "Admin", "mdp", "ADM",
		// false);
		// Personnels p2 = new Personnels("BOSAPIN", "Raymond", "mdp", "VET",
		// false);
		// Personnels p3 = new Personnels("HISSON", "Marie-Paule", "mdp",
		// "SEC", true);
		// Personnels p4= new Personnels("SUEM", "Marie", "mdp", "SEC", true);
		//
		// System.out.println("Ajout personnel... ");
		// try {
		// Ajout d'un membre du Personnel
		// PersonnelDAO.insert(p1);
		// System.out.println("Personnel ajout� : " + p1.toString());
		// PersonnelDAO.insert(p2);
		// System.out.println("Personnel ajout� : " + p2.toString());
		// PersonnelDAO.insert(p3);
		// System.out.println("Personnel ajout� : " + p3.toString());
		// PersonnelDAO.insert(p4);
		// System.out.println("Personnel ajout� : " + p4.toString());

		// S�lection d'un membre
		// Personnels p = PersonnelDAO.selectByCode(p2.getCodePers());
		// System.out.println("\n S�lection d'un membre du Personnel par code :
		// " + p.toString());

		// S�lection de tout le Personnel
		// List<Personnels> Personnels = PersonnelDAO.selectAll();
		// System.out.println("\n S�lection de tous le Personnel : ");
		// afficherPersonnels(Personnels);
		//
		// // S�lection du Personnel non archiv�
		// List<Personnels> PersonnelActif = PersonnelDAO.selectAllNoArchive();
		// System.out.println("\n S�lection du Personnel actuel : ");
		// afficherPersonnels(PersonnelActif);

		// Modification d'un Personnel
		// System.out.println("\nModification Personnel : ");
		// System.out.println("Personnel avant modification : " +
		// p1.toString());
		// p1.setNom("ADMINISTRATEUR");
		// p2.setPrenom("Edmond");
		// p12.setMotPasse("prout");
		// PersonnelDAO.update(p1);
		// PersonnelDAO.update(p2);
		// PersonnelDAO.update(p12);
		// System.out.println("Personnel apres modification : " +
		// p1.toString());
		// System.out.println("Personnel apres modification : " +
		// p2.toString());
		// System.out.println("Personnel apres modification : " +
		// p12.toString());
		//
		//
		// Suppression d'un �l�ment du Personnel
		// System.out.println("\n Suppression d'un membre du personnel : " +
		// p13.toString());
		// PersonnelDAO.delete(p13.getCodePers());
		// Personnels = PersonnelDAO.selectAll();
		// System.out.println("Liste des membre du personnel apr�s suppression :
		// ");
		// afficherPersonnels(Personnels);
		// System.out.println("---------------------------------------------------------------");

		// } catch (DALException e) {
		// e.printStackTrace();
		// }
		//
		// private static void afficherPersonnels(List<Personnels> Personnels) {
		// StringBuffer sb = new StringBuffer();
		// for (Personnels art : Personnels) {
		// sb.append(art.toString());
		// sb.append("\n");
		// }
		// System.out.println(sb.toString());
		// }

		// //
		// *******************************************************************************ANIMAL***********
		// D�claration et instanciation de la DAO animaux)
		//AnimauxDAO AnimauxDAO = DAOFactory.getAnimauxDAO();

		// // Instanciation du jeu d'essai
		// Animaux a1 = new Animaux("MEDA", "F", "Verte", "Levrier", "Chien", 9,
		// "KVB464", false);
		// Animaux a2 = new Animaux("MEDOU", "M", "Bleu", "Siamois", "Chat", 3,
		// "KVBHJK464", true);
		//
		// System.out.println("Ajout animal... ");
//		try {
			// // Ajout d'un Animal
			// AnimauxDAO.insert(a1);
			// System.out.println("Animal ajout� : " + a1.toString());
			// AnimauxDAO.insert(a2);
			// System.out.println("Animal ajout� : " + a2.toString());

			// // S�lection d'un Animal
			// Animaux a = AnimauxDAO.selectByCode(a2.getCodeAnimal());
			// System.out.println("\n S�lection d'un animal par code : " +
			// a.toString());

			// S�lection d'une espece
//			List<Race> EspeceList = AnimauxDAO.selectEspece();
//			System.out.println("\n S�lection des especes : ");
//			afficherEspece(EspeceList);
//
//			// S�lection d'une race
//			List<Race> RaceList = AnimauxDAO.selectRaceByEspece("Chien");
//			System.out.println("\n S�lection des races : ");
//			afficherRace(RaceList);

			// S�lection de tout le Animal
			// List<Animaux> Animaux = AnimauxDAO.selectAll();
			// System.out.println("\n S�lection de tous les animaux : ");
			//
			// afficherAnimaux(Animaux);

			// S�lection des animaux non archiv�
			// List<Animaux> AnimauxActif = AnimauxDAO.selectAllNoArchive();
			// System.out.println("\n S�lection des animaux actuel : ");
			// afficherAnimaux(AnimauxActif);

			// // Modification d'un Animal
			// System.out.println("\nModification animal : ");
			// System.out.println("Animal avant modification : " +
			// a1.toString());
			// a1.setNomAnimal("ABRICOT");
			// a2.setCouleur("Rouge");
			// a2.setRace("Levrier");
			// AnimauxDAO.update(a1);
			// AnimauxDAO.update(a2);
			// System.out.println("Animal apres modification : " +
			// a1.toString());
			// System.out.println("Animal apres modification : " +
			// a2.toString());
			// //
			// //
			// // Suppression d'un Animal
			// System.out.println("\n Suppression d'un Animall : " +
			// a2.toString());
			// AnimauxDAO.delete(a2.getCodeAnimal());
			// Animaux = AnimauxDAO.selectAll();
			// System.out.println("Liste des animaux apr�s suppression : ");
			// afficherAnimaux(Animaux);
			// System.out.println("---------------------------------------------------------------");

//		} catch (DALException e) {
//			e.printStackTrace();
//		}
//	}

	// private static void afficherAnimaux(List<Animaux> Animaux) {
	// StringBuffer sb = new StringBuffer();
	// for (Animaux art : Animaux) {
	// sb.append(art.toString());
	// sb.append("\n");
	// }
	// System.out.println(sb.toString());
	// }
//	private static void afficherEspece(List<Race> Espece) {
//		StringBuffer sb = new StringBuffer();
//		for (Race spc : Espece) {
//			sb.append(spc.toString());
//			sb.append("\n");
//		}
//		System.out.println(sb.toString());
//	}
//
//	private static void afficherRace(List<Race> Race) {
//		StringBuffer sb = new StringBuffer();
//		for (Race rce : Race) {
//			sb.append(rce.toString());
//			sb.append("\n");
//		}
//		System.out.println(sb.toString());
//	}
	// *******************************************************************************CLIENTS***********
	 // Déclaration et instanciation de la DAO Clients)
	 ClientsDAO ClientsDAO = DAOFactory.getClientsDAO();
	
	 // Instanciation du jeu d'essai
//	 Clients c1 = new Clients("SPECTOR", "Phil", "19 la mainge ", "", "91934",
//	 "SEMARE", "0195860309", "MMA",
//	 "dededudu@yahouuuu.fr", "Attention � bien le faire payer en liquide car il est interdit bancaire. ",
//	 false);
//	 Clients c2 = new Clients("LA FRITE", "Jean-Jean", "le petit bois", "",
//	 "44250", "QUEVILLY", "0295867896", "AXA",
//	 "jeanlafrite@free.fr", "", false);
//	 Clients c3 = new Clients("BALLE", "Jean", "12 le rumbaleur ", "le pont au
//	 vieux", "44800", "LIGNE",
//	 "0295860659", "GROUPAMA", "jeanballe@orange.fr", "", false);
	
//	 System.out.println("Ajout Client... ");
	 try {
	 // Ajout d'un Client
//	 ClientsDAO.insert(c1);
//	 System.out.println("Client ajout� : " + c1.toString());
//	 ClientsDAO.insert(c2);
//	 System.out.println("Client ajout� : " + c2.toString());
//	 ClientsDAO.insert(c3);
//	 System.out.println("Client ajout� : " + c3.toString());
	
	 // S�lection d'un Client
//	 Clients c = ClientsDAO.selectByCode(c2.getCodeClient());
//	 System.out.println("\n S�lection d'un Client par code : " +
//	 c.toString());
	
	 // S�lection de tout le Client
	 List<Clients> Clients = ClientsDAO.selectAll();
	 System.out.println("\n S�lection de tous les Clients : ");
	
	 afficherClients(Clients);
	
	 // S�lection des Clients non archiv�
//	 List<Clients> ClientsActif = ClientsDAO.selectAllNoArchive();
//	 System.out.println("\n S�lection des Clients actuel : ");
//	 afficherClients(ClientsActif);
	
	// Recherche Clients
	 List<Clients> c = ClientsDAO.selectByNomPartiel("Ver");
	 System.out.println("\n Recherche Client par nom partiel : " );
	 afficherClients(c);
	 
	 // Modification d'un Client
//	 System.out.println("\nModification Clients : ");
//	 System.out.println("Client avant modification : " + c1.toString());
//	 c1.setNomClient("LATRIQUE");
//	 c1.setPrenomClient("Patrick");
//	 c1.setAssurance("GROUPAMA");
//	 c3.setArchive(true);
//	 ClientsDAO.update(c1);
//	 ClientsDAO.update(c2);
//	 ClientsDAO.update(c3);
//	 System.out.println("Client apres modification : " + c1.toString());
//	 System.out.println("Client apres modification : " + c2.toString());
//	 System.out.println("Client apres modification : " + c3.toString());
	 //
	 //
	 // Suppression d'un Client
//	 System.out.println("\n Suppression d'un Client : " + c3.toString());
//	 ClientsDAO.delete(c2.getCodeClient());
//	 Clients = ClientsDAO.selectAll();
//	 System.out.println("Liste des Clients apr�s suppression : ");
//	 afficherClients(Clients);
//	 System.out.println("---------------------------------------------------------------");
	
	 } catch (DALException e) {
	 e.printStackTrace();
	 }
	 }

	private static void afficherClients(List<Clients> Clients) {
		StringBuffer sb = new StringBuffer();
		for (Clients clt : Clients) {
			sb.append(clt.toString());
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	// *******************************************************************************CLIENTS***********
	// // D�claration et instanciation de la DAO Clients)
	// ClientsDAO ClientsDAO = DAOFactory.getClientsDAO();
	//
	// // Instanciation du jeu d'essai
	// Clients c1 = new Clients("SPECTOR", "Phil", "19 la mainge ", "", "91934",
	// "SEMARE", "0195860309", "MMA",
	// "dededudu@yahouuuu.fr", "Attention � bien le faire payer en liquide car
	// il est interdit bancaire. ",
	// false);
	// Clients c2 = new Clients("LA FRITE", "Jean-Jean", "le petit bois", "",
	// "44250", "QUEVILLY", "0295867896", "AXA",
	// "jeanlafrite@free.fr", "", false);
	// Clients c3 = new Clients("BALLE", "Jean", "12 le rumbaleur ", "le pont au
	// vieux", "44800", "LIGNE",
	// "0295860659", "GROUPAMA", "jeanballe@orange.fr", "", false);
	//
	// System.out.println("Ajout Client... ");
	// try {
	// // Ajout d'un Client
	// ClientsDAO.insert(c1);
	// System.out.println("Client ajout� : " + c1.toString());
	// ClientsDAO.insert(c2);
	// System.out.println("Client ajout� : " + c2.toString());
	// ClientsDAO.insert(c3);
	// System.out.println("Client ajout� : " + c3.toString());
	//
	// // S�lection d'un Client
	// Clients c = ClientsDAO.selectByCode(c2.getCodeClient());
	// System.out.println("\n S�lection d'un Client par code : " +
	// c.toString());
	//
	// // S�lection de tout le Client
	// List<Clients> Clients = ClientsDAO.selectAll();
	// System.out.println("\n S�lection de tous les Clients : ");
	//
	// afficherClients(Clients);
	//
	// // S�lection des Clients non archiv�
	// List<Clients> ClientsActif = ClientsDAO.selectAllNoArchive();
	// System.out.println("\n S�lection des Clients actuel : ");
	// afficherClients(ClientsActif);
	//
	// // Modification d'un Client
	// System.out.println("\nModification Clients : ");
	// System.out.println("Client avant modification : " + c1.toString());
	// c1.setNomClient("LATRIQUE");
	// c1.setPrenomClient("Patrick");
	// c1.setAssurance("GROUPAMA");
	// c3.setArchive(true);
	// ClientsDAO.update(c1);
	// ClientsDAO.update(c2);
	// ClientsDAO.update(c3);
	// System.out.println("Client apres modification : " + c1.toString());
	// System.out.println("Client apres modification : " + c2.toString());
	// System.out.println("Client apres modification : " + c3.toString());
	// //
	// //
	// // Suppression d'un Client
	// System.out.println("\n Suppression d'un Client : " + c3.toString());
	// ClientsDAO.delete(c2.getCodeClient());
	// Clients = ClientsDAO.selectAll();
	// System.out.println("Liste des Clients apr�s suppression : ");
	// afficherClients(Clients);
	// System.out.println("---------------------------------------------------------------");
	//
	// } catch (DALException e) {
	// e.printStackTrace();
	// }
	// }
	//
	// private static void afficherClients(List<Clients> Clients) {
	// StringBuffer sb = new StringBuffer();
	// for (Clients clt : Clients) {
	// sb.append(clt.toString());
	// sb.append("\n");
	// }
	// System.out.println(sb.toString());
	// }
}
