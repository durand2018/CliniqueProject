package fr.eni.clinique.bo;

public class Races {
	
	private String Race;
	private String Espece;
	
	
	
	public Races() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Races(String race, String espece) {
		super();
		this.Race = race;
		this.Espece = espece;
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



	public String toString() {
		StringBuilder sb= new StringBuilder ();
		sb=sb.append(" 	 Race = "+Race);
		sb.append("  Espece= " + Espece);
		sb.append("\n");
		
				
		return sb.toString();
	}
	
	
	

}
