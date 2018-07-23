package fr.eni.clinique.ihm.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import fr.eni.clinique.ihm.animal.PanelAnimalByClt;

public class EcranClients extends JFrame {
	private JButton btnValider, btnAnnuler, btnAjouter, btnSupprimer, btnRechercher;
	private JPanel panelClt, panelBtn, panelAni, panelBas;
	
	public EcranClients(){
		super("Clients");
		initIHM();
	}
	
	private void initIHM(){
		panelClt = new JPanel();
		panelBtn = new JPanel();
		panelAni = new JPanel();
		panelBas = new JPanel();
		PanelClient panClt = new PanelClient();
		PanelAnimalByClt panAni = new PanelAnimalByClt();
		
		panelBtn.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelBtn.add(getBtnRechercher());
		panelBtn.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelBtn.add(getBtnAjouter());
		panelBtn.add(getBtnSupprimer());
		panelBtn.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelBtn.add(getBtnValider());
		panelBtn.add(getBtnAnnuler());
		
		panelClt.setBackground(Color.gray);
		panelClt.add(panelBtn, BorderLayout.NORTH);
		panelClt.add(panClt.initIHM(), BorderLayout.CENTER);
//		panelClt.add(panAni.initIHM(),BorderLayout.SOUTH);
		
		this.setContentPane(panelClt);
	}

	public JButton getBtnValider() {
		if(btnValider == null){
			ImageIcon image = new ImageIcon(
					Toolkit.getDefaultToolkit().getImage(getClass().getResource("../../images/saveBlanc.jpg")));
			btnValider = new JButton(image);
		}
		return btnValider;
	}

	public JButton getBtnAnnuler() {
		if(btnAnnuler == null){
			ImageIcon image = new ImageIcon(
					Toolkit.getDefaultToolkit().getImage(getClass().getResource("../../images/annulerBlanc.jpg")));
			btnAnnuler = new JButton(image);
		}
		return btnAnnuler;
	}

	public JButton getBtnAjouter() {
		if(btnAjouter == null){
			ImageIcon image = new ImageIcon(
					Toolkit.getDefaultToolkit().getImage(getClass().getResource("../../images/ajouterBlanc.jpg")));
			btnAjouter = new JButton(image);
		}
		return btnAjouter;
	}

	public JButton getBtnSupprimer() {
		if(btnSupprimer == null){
			ImageIcon image = new ImageIcon(
					Toolkit.getDefaultToolkit().getImage(getClass().getResource("../../images/eteindreBlanc.jpg")));
			btnSupprimer = new JButton(image);
		}
		return btnSupprimer;
	}

	public JButton getBtnRechercher() {
		if(btnRechercher == null){
			ImageIcon image = new ImageIcon(
					Toolkit.getDefaultToolkit().getImage(getClass().getResource("../../images/rechercherBlanc.jpg")));
			btnRechercher = new JButton(image);
		}
		return btnRechercher;
	}
	
	
	
}
