package fr.eni.clinique.bll;

import java.util.List;

import fr.eni.clinique.bo.Animaux;
import fr.eni.clinique.bo.Personnels;

public class AppliTestBLL {

	public static void main(String[] args) {
		/////////////////////////////////////////////////////////////////////////// Personnel
		// Personnels p1 = new Personnels("Nom", "Prénom", "MdPasse5", "SEC",
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
		// System.out.println("Personne après :" + p1.toString());
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
//		Animaux a1 = new Animaux("NomAnimal", "M", "Couleur", "Levrier", "Chien", 8, "KVBHJK464", false);
//		Animaux a2 = new Animaux("Lunette", "F", "Miroir", "Siamois", "Chat", 2, "KVB59464", false);
		AnimalMger amger = null;
		try {

			amger = AnimalMger.getInstance();
			// Ajout animal
//			amger.addAnimaux(a1);
//			amger.addAnimaux(a2);
//			afficherAnimal(amger.getList());
			// Modif animal
//			System.out.println("\n Modification d'un animal :");
//			System.out.println("Animal avant :" + a1.toString());
//			a1.setNomAnimal("Bibou");
//			a1.setCouleur("Vert corridore");
//			a1.setSexe("F");
//			amger.updateAnimal(a1);
//			System.out.println("Animal après :" + a1.toString());
//			amger.removeAnimal(1);
//			System.out.println("\n Suppression d'un animal :" + a1);
//			System.out.println("\n Liste après suppression :");
			afficherAnimal(amger.selectAnimalByClient(2));
			

		} catch (BLLException e) {
			e.printStackTrace();
		}
	}

	///////////////////////////////////////////////////////////////////////////
	// Afficher animal
	private static void afficherAnimal(List<Animaux> anim) {
		StringBuffer sb = new StringBuffer();
		for (Animaux a : anim) {
			sb.append(a.toString());
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
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
}