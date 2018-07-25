package fr.eni.clinique.bo;

public class Race {
	
	private String Race;
	private String Espece;
	
	
	
	public Race() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Race(String race, String espece) {
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



	@Override
	public String toString() {
		StringBuilder sb= new StringBuilder ();
		sb=sb.append(" 	 Race = "+Race);
		sb.append("  Espece= " + Espece);
		sb.append("\n");
		
				
		return sb.toString();
	}
	
	
	

}
