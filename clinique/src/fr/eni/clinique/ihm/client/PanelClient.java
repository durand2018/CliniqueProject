package fr.eni.clinique.ihm.client;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import fr.eni.clinique.bo.Clients;

//import fr.eni.clinique.bll.BLLException;
//import fr.eni.clinique.bll.ClientsMger;

@SuppressWarnings("serial")
public class PanelClient extends JFrame {
	private JLabel jlCodeClt, jlNomClt, jlPrenomClt, jlAdresse, jlCodePostal, jlVille, jlNumTel,
	jlAssurance, jlEmail, jlRemarque;
	private JTextField jtCodeClt, jtNomClt, jtPrenomClt, jtAdresse1, jtAdresse2, jtCodePostal, jtVille, jtNumTel,
	jtAssurance, jtEmail;
	private JTextArea jtRemarque;
//	private JScrollPane defil;
	private JPanel panelClt;
//	private ClientsMger mgr = null;
//	private Integer numEnreg;
	
	
	public PanelClient()  {
		super();
		
//		try {
//			//Chargement du catalogue des clients
//			mgr = ClientsMger.getInstance();
//		} catch (BLLException e) {
//			System.out.println("Aucun client � afficher");
//			System.exit(1);
//		}
		initIHM();
//		numEnreg = 0;
//		jtCodeClt.setText(Integer.toString((mgr.getClients(numEnreg).getCodeClient())));
//		jtNomClt.setText(mgr.getClients(numEnreg).getNomClient());
//		jtPrenomClt.setText(mgr.getClients(numEnreg).getPrenomClient());
//		jtAdresse1.setText(mgr.getClients(numEnreg).getAdresse1());
//		jtAdresse2.setText(mgr.getClients(numEnreg).getAdresse2());
//		jtCodePostal.setText(mgr.getClients(numEnreg).getCodePostal());
//		jtVille.setText(mgr.getClients(numEnreg).getVille());
//		jtNumTel.setText(mgr.getClients(numEnreg).getNumTel());
//		jtAssurance.setText(mgr.getClients(numEnreg).getAssurance());
//		jtEmail.setText(mgr.getClients(numEnreg).getEmail());
//		jtRemarque.setText(mgr.getClients(numEnreg).getRemarque());
	}


	public Component initIHM() {
		// creation panel
		panelClt = new JPanel();
		panelClt.setOpaque(true);
//		panelClt.setPreferredSize(new Dimension(500,600));
		panelClt.setBackground(Color.gray);
		panelClt.setLayout(new GridBagLayout());
		
		//Placement des �l�ments sur la grille
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		//Ligne 1
		gbc.anchor = GridBagConstraints.WEST;
//		gbc.gridx = 0;
//		gbc.gridy = 0;
//		panelClt.add(getJlCodeClt(), gbc);
//		gbc.gridx = 1;
//		panelClt.add(getJtCodeClt(), gbc);
		
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

		//Mise en place scroll sur Case Remarque - ne fonctionne pas !
//		defil = new JScrollPane(jtRemarque);
//		panelClt.add(getDefil());
		
		getJtRemarque().setLineWrap(true);
				
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
			jlNumTel = new JLabel("N� T�l�phone ");
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


	public JTextArea getJtRemarque() {
		if(jtRemarque == null){
			jtRemarque = new JTextArea(5,20);
//			defil = new JScrollPane(jtRemarque);
			jtRemarque.setWrapStyleWord(true);
		}
		return jtRemarque;
	}
	
//	public JScrollPane getDefil(){
//		if(defil == null){
//			defil = new JScrollPane(getJtRemarque());
//		}
//		return defil;
//	}
	
	/**
	 * Fonction en charge de r�cup�rer les infos du formulaire Clients
	 * @return un client
	 */
	public Clients getClient(){
		Clients cltCourant = new Clients();
		cltCourant.setNomClient(getJtNomClt().getText());
		cltCourant.setPrenomClient(getJtPrenomClt().getText());
		cltCourant.setAdresse1(getJtAdresse1().getText());
		cltCourant.setAdresse2(getJtAdresse2().getText());
		cltCourant.setCodePostal(getJtCodePostal().getText());
		cltCourant.setVille(getJtVille().getText());
		cltCourant.setNumTel(getJtNumTel().getText());
		cltCourant.setAssurance(getJtAssurance().getText());
		cltCourant.setEmail(getJtEmail().getText());
		cltCourant.setRemarque(getJtRemarque().getText());
		System.out.println(cltCourant);
		return cltCourant;
		
	}
	
}
