package fr.eni.clinique.bo;



public class Personnels {

	
	private int CodePers;
	private String Nom;
	private String Prenom;
	private String MotPasse;
	private String Role;
	private boolean Archive;
	
	
	
	
	public Personnels() {
		super();
	}




	public Personnels(int codePers, String nom, String prenom, String motPasse, String role, boolean Archive) {
		super();
		this.CodePers = codePers;
		this.Nom = nom;
		this.Prenom = prenom;
		this.MotPasse = motPasse;
		this.Role = role;
		this.Archive = Archive;
	}




	public Personnels(String nom, String prenom, String motPasse, String role, boolean Archive) {
		super();
		this.Nom = nom;
		this.Prenom = prenom;
		this.MotPasse = motPasse;
		this.Role = role;
		this.Archive = Archive;
	}




	public int getCodePers() {
		return CodePers;
	}




	public void setCodePers(int codePers) {
		this.CodePers = codePers;
	}




	public String getNom() {
		return Nom;
	}




	public void setNom(String nom) {
		this.Nom = nom;
	}




	public String getPrenom() {
		return Prenom;
	}




	public void setPrenom(String prenom) {
		this.Prenom = prenom;
	}




	public String getMotPasse() {
		return MotPasse;
	}




	public void setMotPasse(String motPasse) {
		this.MotPasse = motPasse;
	}




	public String getRole() {
		return Role;
	}




	public void setRole(String role) {
		this.Role = role;
	}




	public boolean isArchive() {
		return Archive;
	}




	public void setArchive(boolean Archive) {
		this.Archive = Archive;
	}




	@Override
	public String toString() {
		StringBuilder sb= new StringBuilder ();
		sb=sb.append(" 	 CodePers = "+CodePers);
		sb.append("  nom= " + Nom);
		sb.append("  	Prenom= " + Prenom);
		sb.append("  MotPasse=" + MotPasse);
		 sb.append(" 	Role= " + Role );
		 sb.append("	 Archive=" + Archive );
		sb.append("\n");
		
				
		return sb.toString();
	}
	
	
	
	
	
}




