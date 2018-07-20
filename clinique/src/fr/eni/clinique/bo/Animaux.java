package fr.eni.clinique.bo;

public class Animaux {
	
	private int CodeAnimal;
	private String NomAnimal;
	private String Sexe;
	private String Couleur;
	private String Race; 
	private String Espece;
	private int CodeClient; 
	private String Tatouage; 
	private String Antecedents; 
	private boolean Archive;
	
	
	public Animaux(int codeAnimal, String nomAnimal, String sexe, String couleur, String race, String espece,
			int codeClient, String tatouage, String antecedents, boolean Archive) {
		super();
		this.CodeAnimal = codeAnimal;
		this.NomAnimal = nomAnimal;
		this.Sexe = sexe;
		this.Couleur = couleur;
		this.Race = race;
		this.Espece = espece;
		this.CodeClient = codeClient;
		this.Tatouage = tatouage;
		this.Antecedents = antecedents;
		this.Archive = Archive;
	}


	public Animaux() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Animaux(String nomAnimal, String sexe, String couleur, String race, String espece, int numClt, String tatouage,
			boolean Archive) {
		super();
		this.NomAnimal = nomAnimal;
		this.Sexe = sexe;
		this.Couleur = couleur;
		this.Race = race;
		this.Espece = espece;
		this.CodeClient = numClt;
		this.Tatouage = tatouage;
		this.Archive = Archive;
	}


	public int getCodeAnimal() {
		return CodeAnimal;
	}


	public void setCodeAnimal(int codeAnimal) {
		this.CodeAnimal = codeAnimal;
	}


	public String getNomAnimal() {
		return NomAnimal;
	}


	public void setNomAnimal(String nomAnimal) {
		this.NomAnimal = nomAnimal;
	}


	public String getSexe() {
		return Sexe;
	}


	public void setSexe(String sexe) {
		this.Sexe = sexe;
	}


	public String getCouleur() {
		return Couleur;
	}


	public void setCouleur(String couleur) {
		this.Couleur = couleur;
	}


	public String getRace() {
		return Race;
	}


	public void setRace(String race) {
		this.Race = race;
	}


	public String getEspece() {
		return Espece;
	}


	public void setEspece(String espece) {
		this.Espece = espece;
	}


	public int getCodeClient() {
		return CodeClient;
	}


	public void setCodeClient(int codeClient) {
		this.CodeClient = codeClient;
	}


	public String getTatouage() {
		return Tatouage;
	}


	public void setTatouage(String tatouage) {
		this.Tatouage = tatouage;
	}


	public String getAntecedents() {
		return Antecedents;
	}


	public void setAntecedents(String antecedents) {
		this.Antecedents = antecedents;
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
		sb=sb.append(" 	 CodeAnimal = "+CodeAnimal);
		sb.append("  NomAnimal= " + NomAnimal);
		sb.append("  	Sexe= " + Sexe);
		sb.append("  Couleur=" + Couleur);
		 sb.append(" 	Race= " + Race );
		 sb.append("  Espece=" + Espece);
		 sb.append(" 	CodeClient= " + CodeClient );
		 sb.append("  Tatouage=" + Tatouage);
		 sb.append(" 	Antecedents= " + Antecedents );
		 sb.append("	 Archive=" + Archive );
		sb.append("\n");
		
				
		return sb.toString();

	
	}	
	

}
