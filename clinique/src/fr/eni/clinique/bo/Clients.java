package fr.eni.clinique.bo;

public class Clients {

	private int CodeClient;
	private String NomClient;
	private String PrenomClient;
	private String Adresse1;
	private String Adresse2;
	private String CodePostal;
	private String Ville;
	private String NumTel;
	private String Assurance;
	private String Email;
	private String Remarque;
	private Boolean Archive;

	// constructeur avec id
	public Clients(int codeClient, String nomClient, String prenomClient, String adresse1, String adresse2,
			String codePostal, String ville, String numTel, String assurance, String email) {
		super();
		this.CodeClient = codeClient;
		this.NomClient = nomClient;
		this.PrenomClient = prenomClient;
		this.Adresse1 = adresse1;
		this.Adresse2 = adresse2;
		this.CodePostal = codePostal;
		this.Ville = ville;
		this.NumTel = numTel;
		this.Assurance = assurance;
		this.Email = email;
	}

	// constructeur sans id
	public Clients(String nomClient, String prenomClient, String adresse1, String adresse2, String codePostal,
			String ville, String numTel, String assurance, String email, String remarque, boolean archive) {
		super();
		this.NomClient = nomClient;
		this.PrenomClient = prenomClient;
		this.Adresse1 = adresse1;
		this.Adresse2 = adresse2;
		this.CodePostal = codePostal;
		this.Ville = ville;
		this.NumTel = numTel;
		this.Assurance = assurance;
		this.Remarque = remarque;
		this.Email = email;
		this.Archive = archive;
	}

	public Clients() {
		super();
	}

	public int getCodeClient() {
		return CodeClient;
	}

	public void setCodeClient(int codeClient) {
		this.CodeClient = codeClient;
	}

	public String getNomClient() {
		return NomClient;
	}

	public void setNomClient(String nomClient) {
		this.NomClient = nomClient;
	}

	public String getPrenomClient() {
		return PrenomClient;
	}

	public void setPrenomClient(String prenomClient) {
		this.PrenomClient = prenomClient;
	}

	public String getAdresse1() {
		return Adresse1;
	}

	public void setAdresse1(String adresse1) {
		this.Adresse1 = adresse1;
	}

	public String getAdresse2() {
		return Adresse2;
	}

	public void setAdresse2(String adresse2) {
		this.Adresse2 = adresse2;
	}

	public String getCodePostal() {
		return CodePostal;
	}

	public void setCodePostal(String codePostal) {
		this.CodePostal = codePostal;
	}

	public String getVille() {
		return Ville;
	}

	public void setVille(String ville) {
		this.Ville = ville;
	}

	public String getNumTel() {
		return NumTel;
	}

	public void setNumTel(String numTel) {
		this.NumTel = numTel;
	}

	public String getAssurance() {
		return Assurance;
	}

	public void setAssurance(String assurance) {
		this.Assurance = assurance;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		this.Email = email;
	}

	public String getRemarque() {
		return Remarque;
	}

	public void setRemarque(String remarque) {
		this.Remarque = remarque;
	}

	public Boolean getArchive() {
		return Archive;
	}

	public void setArchive(Boolean archive) {
		this.Archive = archive;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb = sb.append("CodeClient = " + CodeClient);
		sb.append("NomClient= " + NomClient);
		sb.append("PrenomClient = " + PrenomClient);
		sb.append("Adresse1 =" + Adresse1);
		sb.append("Adresse2 = " + Adresse2);
		sb.append("CodePostal =" + CodePostal);
		sb.append("Ville = " + Ville);
		sb.append("NumTel =" + NumTel);
		sb.append("Assurance = " + Assurance);
		sb.append("Email = " + Email);
		sb.append("Remarque = " + Remarque);
		sb.append("Archive =" + Archive);
		sb.append("\n");

		return sb.toString();
	}

}
