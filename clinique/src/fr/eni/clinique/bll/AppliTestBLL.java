package fr.eni.clinique.bll;

import java.util.List;

//import java.util.List;

//import fr.eni.clinique.bo.Animaux;
import fr.eni.clinique.bo.Clients;
//import fr.eni.clinique.bo.Personnels;
//import fr.eni.clinique.bo.Race;

public class AppliTestBLL {

	public static void main(String[] args) {
		/////////////////////////////////////////////////////////////////////////// Personnel
		// Personnels p1 = new Personnels("Nom", "Pr�nom", "MdPasse5", "SEC",
		// false);
		// Personnels p2 = new Personnels("FAB", "John", "M@Passe6", "VET",
		// false);
		// LoginMger mger = null;
		// try {
		//
		// mger = LoginMger.getInstance();
		// // ajout.pers
		// mger.addPersonnel(p1);
		// mger.addPersonnel(p2);
		// afficherPersonnel(mger.getList());
		// // Modif.pers
		// System.out.println("\n Modification d'un membre du personnel :");
		// System.out.println("Personne avant :" + p1.toString());
		// p1.setNom("MACHIN");
		// p1.setPrenom("Truc");
		// p1.setMotPasse("MdP1");
		// mger.updatePersonnel(p1);
		// System.out.println("Personne apr�s :" + p1.toString());
		// mger.removePersonnel(0);
		// System.out.println("\n Suppression d'un membre du peronnel :");
		//
		// afficherPersonnel(mger.getList());
		//
		// } catch (BLLException e) {
		// e.printStackTrace();
		// }
		// }

		/////////////////////////////////////////////////////////////////////////// Animal
		// Animaux a1 = new Animaux("NomAnimal", "M", "Couleur", "Levrier",
		// "Chien", 8, "KVBHJK464", false);
		// Animaux a2 = new Animaux("Lunette", "F", "Miroir", "Siamois", "Chat",
		// 2, "KVB59464", false);
		// AnimalMger amger = null;
		// try {
		//
		// amger = AnimalMger.getInstance();
		// // Ajout animal
		// amger.addAnimaux(a1);
		// amger.addAnimaux(a2);
		// afficherAnimal(amger.getList());
		// Modif animal
		// System.out.println("\n Modification d'un animal :");
		// System.out.println("Animal avant :" + a1.toString());
		// a1.setNomAnimal("Bibou");
		// a1.setCouleur("Vert corridore");
		// a1.setSexe("F");
		// amger.updateAnimal(a1);
		// System.out.println("Animal apr�s :" + a1.toString());
		// amger.removeAnimal(1);
		// System.out.println("\n Suppression d'un animal :" + a1);
		// System.out.println("\n Liste apr�s suppression :");
		// afficherAnimal(amger.selectAnimalByClient(2));
		// afficherAnimalRace(amger.selectEspece());
		//
		// } catch (BLLException e) {
		// e.printStackTrace();
		// }
		// }

		///////////////////////////////////////////////////////////////////////////

		// Afficher animal
		// private static void afficherAnimal(List<Animaux> anim) {
		// StringBuffer sb = new StringBuffer();
		// for (Animaux a : anim) {
		// sb.append(a.toString());
		// sb.append("\n");
		// }
		// System.out.println(sb.toString());
		// }
		// private static void afficherAnimalRace(List<Race> anirace) {
		// StringBuffer sb = new StringBuffer();
		// for (Race r : anirace) {
		// sb.append(r.toString());
		// sb.append("\n");
		// }
		// System.out.println(sb.toString());
		// }

		/////////////////////////////////////////////////////////////////////////// Afficher
		// personnel
		// private static void afficherPersonnel(List<Personnels> perso) {
		// StringBuffer sb = new StringBuffer();
		// for (Personnels a : perso) {
		// sb.append(a.toString());
		// sb.append("\n");
		// }
		// System.out.println(sb.toString());
		//
		// }

		/////////////////////////////////////////////////////////////////////////// Client
		Clients c1 = new Clients("Truc", "Alain", "19 Once", "", "91934", "SEMARE", "01 95 86 03 09", "MMA",
				"dededudu@yahouuuu.fr", "Attention � bien le faire payer en liquide car il est interdit bancaire. ",
				false);
		Clients c2 = new Clients("MET", "Val", "1 rue des ET", "La Base", "44440", "RIAIL", "02 15 48 15 49", "AXA",
				"vmet@sfr.fr", "", false);
		ClientsMger cmger = null;
		try {
			cmger = ClientsMger.getInstance();
			// Ajout clients
			cmger.addClients(c1);
			cmger.addClients(c2);

			afficherClients(cmger.getListcl());
			
			System.out.println(cmger.getClient(13));
			System.out.println(cmger.selectByCode(13));
			

		} catch (BLLException e) {
			System.out.println("Erreur instance client");
			e.printStackTrace();
		}
	}

	/**
	 * Fonction en charge de Afficher client
	 * 
	 * @param listcl
	 */
	private static void afficherClients(List<Clients> clt) {
		StringBuffer sb = new StringBuffer();
		for (Clients c : clt) {
			sb.append(c.toString());
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	
}