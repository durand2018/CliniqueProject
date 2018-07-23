package fr.eni.clinique.ihm.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
//import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.eni.clinique.ihm.animal.PanelAnimalByClt;

@SuppressWarnings("serial")
public class EcranClients extends JFrame {
//	private JLabel logo;
	private JButton btnValider, btnAnnuler, btnAjouter, btnSupprimer, btnRechercher;
	private JPanel panelClt, panelBtn, panelBas;
	
	public EcranClients(){
		super("Clients");
		initIHM();
	}
	
	private void initIHM(){
		panelClt = new JPanel();
		panelBtn = new JPanel();
		panelBas = new JPanel();
		PanelClient panClt = new PanelClient();
		PanelAnimalByClt panAni = new PanelAnimalByClt();
		
		panelBtn.setLayout(new FlowLayout(FlowLayout.LEFT));
//		panelBtn.add(getLogo());
		panelBtn.add(getBtnRechercher());
		panelBtn.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelBtn.add(getBtnAjouter());
		panelBtn.add(getBtnSupprimer());
		panelBtn.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelBtn.add(getBtnValider());
		panelBtn.add(getBtnAnnuler());
		
		panelBas.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		panelBas.add(panClt.initIHM());
		gbc.gridx = 1;
		panelBas.add(panAni.initIHM());
		
		panelClt.setBackground(Color.gray);
		panelClt.add(panelBtn, BorderLayout.NORTH);
		panelClt.add(panelBas, BorderLayout.CENTER);
		
		
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
			
			btnAnnuler.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
		}
		return btnAnnuler;
	}

	public JButton getBtnAjouter() {
		if(btnAjouter == null){
			ImageIcon image = new ImageIcon(
					Toolkit.getDefaultToolkit().getImage(getClass().getResource("../../images/ajouterBlanc.jpg")));
			btnAjouter = new JButton(image);
			
			btnAjouter.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// Ouvre Ecran AjoutClient
					EcranAjoutClient ecranAjclt = new EcranAjoutClient ();
					ecranAjclt.setSize(new Dimension(500,600));
					ecranAjclt.setVisible(true);
					ecranAjclt.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}
			});
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

//	public JLabel getLogo() {
//		if(logo == null){
//			ImageIcon image = new ImageIcon(
//					Toolkit.getDefaultToolkit().getImage(getClass().getResource("../../images/ico_veto.png")));
//			logo.setIcon(image);
//		}
//		return logo;
//	}

	
	
	
	
}
