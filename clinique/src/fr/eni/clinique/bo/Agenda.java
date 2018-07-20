package fr.eni.clinique.bo;

import java.util.Date;

public class Agenda {
	
	private int CodeVeto;
	private Date DateRdv;
	private int CodeAnimal;
	
	
	public Agenda(int codeVeto, Date dateRdv, int codeAnimal) {
		super();
		this.CodeVeto = codeVeto;
		this.DateRdv = dateRdv;
		this.CodeAnimal = codeAnimal;
	}


	public Agenda() {
		super();
	}


	public int getCodeVeto() {
		return CodeVeto;
	}


	public void setCodeVeto(int codeVeto) {
		this.CodeVeto = codeVeto;
	}


	public Date getDateRdv() {
		return DateRdv;
	}


	public void setDateRdv(Date dateRdv) {
		this.DateRdv = dateRdv;
	}


	public int getCodeAnimal() {
		return CodeAnimal;
	}


	public void setCodeAnimal(int codeAnimal) {
		this.CodeAnimal = codeAnimal;
	}


	@Override
	public String toString() {
		StringBuilder sb= new StringBuilder ();
		sb=sb.append(" 	 DateRdv = "+DateRdv);
		sb.append("  CodeAnimal= " + CodeAnimal);
		sb.append("\n");
		
				
		return sb.toString();
	}
	
	
	
	

}
