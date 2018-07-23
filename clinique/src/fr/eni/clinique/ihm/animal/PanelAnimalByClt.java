package fr.eni.clinique.ihm.animal;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PanelAnimalByClt extends JFrame {
	private JButton btnAjouter, btnSupprimer, btnEditer;
	private JPanel panelBtn, panelAni;
	private JTextArea tabProvisoire;

	public PanelAnimalByClt(){
		super();
		initIHM();
	}
	
	public Component initIHM() { 
		panelAni = new JPanel();
		panelBtn = new JPanel();
		
		panelAni.setOpaque(true);
		panelAni.setLayout(new BorderLayout());
		
		panelBtn.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelBtn.add(getBtnAjouter());
		panelBtn.add(getBtnSupprimer());
		panelBtn.add(getBtnEditer());
		
		panelAni.add(panelBtn,BorderLayout.SOUTH);
		panelAni.add(getTabProvisoire(),BorderLayout.CENTER);
		
		return panelAni;
		
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
	
	public JButton getBtnEditer() {
		if(btnEditer == null){
			ImageIcon image = new ImageIcon(
					Toolkit.getDefaultToolkit().getImage(getClass().getResource("../../images/imprimerBlanc.jpg")));
			btnEditer = new JButton(image);
		}
		return btnEditer;
	}

	public JTextArea getTabProvisoire() {
		if (tabProvisoire == null){
			tabProvisoire = new JTextArea(50,80);
		}
		return tabProvisoire;
	}

	

}
