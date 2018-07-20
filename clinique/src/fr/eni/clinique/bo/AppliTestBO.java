package fr.eni.clinique.bo;


import java.util.ArrayList;

public class AppliTestBO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
	
	ArrayList<Personnels> ListPersonnels = new ArrayList<>();
	Personnels personnel1 = new Personnels(1,"BOSAPIN","Edmon", "password", "ADM", false);
	Personnels personnel2 = new Personnels(2,"DE Cajou","Benoit", "password", "ADM", false);
	Personnels personnel3 = new Personnels(3,"MALANICH","Melanie", "password", "VET", false);
	Personnels personnel4 = new Personnels(4,"AIMOINE","Anne", "password", "VET", false);
	Personnels personnel5 = new Personnels(5,"TOURNE","Sylvain", "password", "VET", false);
	Personnels personnel6 = new Personnels(6,"SWITAUME","Guillaume", "password", "VET", false);
	Personnels personnel7 = new Personnels(7,"MONFILS","Thibault", "password", "VET", false);
	Personnels personnel8 = new Personnels(8,"ELABETE","Isabelle", "password", "VET", false);
	Personnels personnel9 = new Personnels(9,"DE JEU","Odette", "password", "SEC", false);
	Personnels personnel10 = new Personnels(10,"ABONDIEU","Elisabeth", "password", "SEC", false);
	Personnels personnel11 = new Personnels(11,"HISSON","Marie-Paule", "password", "SEC", false);
	System.out.println(personnel1);
	System.out.println(personnel2);
	System.out.println(personnel3);
	System.out.println(personnel4);
	System.out.println(personnel5);
	System.out.println(personnel6);
	System.out.println(personnel7);
	System.out.println(personnel8);
	System.out.println(personnel9);
	System.out.println(personnel10);
	System.out.println(personnel11);
	
	ListPersonnels.add(personnel1);
	ListPersonnels.add(personnel2);
	ListPersonnels.add(personnel3);
	ListPersonnels.add(personnel4);
	ListPersonnels.add(personnel5);
	ListPersonnels.add(personnel6);
	ListPersonnels.add(personnel7);
	ListPersonnels.add(personnel8);
	ListPersonnels.add(personnel9);
	ListPersonnels.add(personnel10);
	ListPersonnels.add(personnel11);
	System.out.println(" --------------------------");
	
	System.out.println("Affichage de la liste du personel");
	
	
	System.out.println(ListPersonnels);
	
	
	}
	
}
