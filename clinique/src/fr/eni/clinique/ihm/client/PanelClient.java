package fr.eni.clinique.ihm.client;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelClient extends JFrame {
	private JLabel jlCodeClt, jlNomClt, jlPrenomClt, jlAdresse, jlCodePostal, jlVille, jlNumTel,
	jlAssurance, jlEmail, jlRemarque;
	private JTextField jtCodeClt, jtNomClt, jtPrenomClt, jtAdresse1, jtAdresse2, jtCodePostal, jtVille, jtNumTel,
	jtAssurance, jtEmail, jtRemarque;
	private JPanel panelClt;
	
	
	
	public PanelClient()  {
		super();
		initIHM();
		
	}


	public Component initIHM() {
		// creation panel
		panelClt = new JPanel();
		panelClt.setOpaque(true);
//		panelClt.setPreferredSize(new Dimension(500,600));
		panelClt.setBackground(Color.gray);
		panelClt.setLayout(new GridBagLayout());
		
		//Placement des éléments sur la grille
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		//Ligne 1
		gbc.gridx = 0;
		gbc.gridy = 0;
		panelClt.add(getJlCodeClt(), gbc);
		gbc.gridx = 1;
		panelClt.add(getJtCodeClt(), gbc);
		
		//Ligne 2
		gbc.gridx = 0;
		gbc.gridy = 1;
		panelClt.add(getJlNomClt(), gbc);
		gbc.gridx = 1;
		panelClt.add(getJtNomClt(), gbc);
		
		//Ligne 3
		gbc.gridx = 0;
		gbc.gridy = 2;
		panelClt.add(getJlPrenomClt(), gbc);
		gbc.gridx = 1;
		panelClt.add(getJtPrenomClt(), gbc);
		
		//Ligne 4
		gbc.gridx = 0;
		gbc.gridy = 3;
		panelClt.add(getJlAdresse(), gbc);
		gbc.gridx = 1;
		panelClt.add(getJtAdresse1(), gbc);
		
		//Ligne 5
		gbc.gridy = 4;
		panelClt.add(getJtAdresse2(), gbc);
		
		
		//Ligne 6
		gbc.gridx = 0;
		gbc.gridy = 5;
		panelClt.add(getJlCodePostal(), gbc);
		gbc.gridx = 1;
		panelClt.add(getJtCodePostal(), gbc);
		
		//Ligne 7
		gbc.gridx = 0;
		gbc.gridy = 6;
		panelClt.add(getJlVille(), gbc);
		gbc.gridx = 1;
		panelClt.add(getJtVille(), gbc);
		
		//Ligne 8
		gbc.gridx = 0;
		gbc.gridy = 7;
		panelClt.add(getJlNumTel(), gbc);
		gbc.gridx = 1;
		panelClt.add(getJtNumTel(), gbc);
		
		//Ligne 9
		gbc.gridx = 0;
		gbc.gridy = 8;
		panelClt.add(getJlAssurance(), gbc);
		gbc.gridx = 1;
		panelClt.add(getJtAssurance(), gbc);
		
		//Ligne 10
		gbc.gridx = 0;
		gbc.gridy = 9;
		panelClt.add(getJlEmail(), gbc);
		gbc.gridx = 1;
		panelClt.add(getJtEmail(), gbc);
		
		//Ligne 11
		gbc.gridx = 0;
		gbc.gridy = 10;
		panelClt.add(getJlRemarque(), gbc);
		gbc.gridx = 1;
		panelClt.add(getJtRemarque(), gbc);
		
		
		return panelClt;
		
	}


	public JLabel getJlCodeClt() {
		if(jlCodeClt == null){
			jlCodeClt = new JLabel("Code ");
		}
		return jlCodeClt;
	}


	public JLabel getJlNomClt() {
		if(jlNomClt == null){
			jlNomClt = new JLabel("Nom ");
		}
		return jlNomClt;
	}


	public JLabel getJlPrenomClt() {
		if(jlPrenomClt == null){
			jlPrenomClt = new JLabel("Prenom ");
		}
		return jlPrenomClt;
	}


	public JLabel getJlAdresse() {
		if(jlAdresse == null){
			jlAdresse = new JLabel("Adresse ");
		}
		return jlAdresse;
	}


	public JLabel getJlCodePostal() {
		if(jlCodePostal == null){
			jlCodePostal = new JLabel("Code Postal ");
		}
		return jlCodePostal;
	}


	public JLabel getJlVille() {
		if(jlVille == null){
			jlVille = new JLabel("Ville ");
		}
		return jlVille;
	}


	public JLabel getJlNumTel() {
		if(jlNumTel == null){
			jlNumTel = new JLabel("N° Téléphone ");
		}
		return jlNumTel;
	}


	public JLabel getJlAssurance() {
		if(jlAssurance == null){
			jlAssurance = new JLabel("Assurance ");
		}
		return jlAssurance;
	}


	public JLabel getJlEmail() {
		if(jlEmail == null){
			jlEmail = new JLabel("Email ");
		}
		return jlEmail;
	}


	public JLabel getJlRemarque() {
		if(jlRemarque == null){
			jlRemarque = new JLabel("Remarque ");
		}
		return jlRemarque;
	}


	public JTextField getJtCodeClt() {
		if(jtCodeClt == null){
			jtCodeClt = new JTextField(20);
		}
		return jtCodeClt;
	}


	public JTextField getJtNomClt() {
		if(jtNomClt == null){
			jtNomClt = new JTextField(20);
		}
		return jtNomClt;
	}


	public JTextField getJtPrenomClt() {
		if(jtPrenomClt == null){
			jtPrenomClt = new JTextField(20);
		}
		return jtPrenomClt;
	}


	public JTextField getJtAdresse1() {
		if(jtAdresse1 == null){
			jtAdresse1 = new JTextField(20);
		}
		return jtAdresse1;
	}


	public JTextField getJtAdresse2() {
		if(jtAdresse2 == null){
			jtAdresse2 = new JTextField(20);
		}
		return jtAdresse2;
	}


	public JTextField getJtCodePostal() {
		if(jtCodePostal == null){
			jtCodePostal = new JTextField(20);
		}
		return jtCodePostal;
	}


	public JTextField getJtVille() {
		if(jtVille == null){
			jtVille = new JTextField(20);
		}
		return jtVille;
	}


	public JTextField getJtNumTel() {
		if(jtNumTel == null){
			jtNumTel = new JTextField(20);
		}
		return jtNumTel;
	}


	public JTextField getJtAssurance() {
		if(jtAssurance == null){
			jtAssurance = new JTextField(20);
		}
		return jtAssurance;
	}


	public JTextField getJtEmail() {
		if(jtEmail == null){
			jtEmail = new JTextField(20);
		}
		return jtEmail;
	}


	public JTextField getJtRemarque() {
		if(jtRemarque == null){
			jtRemarque = new JTextField(20);
		}
		return jtRemarque;
	}


	
	
	
	
}
