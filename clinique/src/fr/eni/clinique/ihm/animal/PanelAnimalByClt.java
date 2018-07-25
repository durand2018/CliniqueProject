package fr.eni.clinique.ihm.animal;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class PanelAnimalByClt extends JFrame {
	private JLabel jlTitre, jlAucunAni;
	private JButton btnAjouter, btnSupprimer, btnEditer;
	private JPanel panelBtn, panelAni;

	public PanelAnimalByClt(){
		super();
		initIHM();
	}
	
	public PanelAnimalByClt(int CodeClt){
		super();
		initIHM(CodeClt);
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
		
		panelAni.add(getJlTitre(),BorderLayout.NORTH);
		panelAni.add(panelBtn,BorderLayout.SOUTH);
		panelAni.add(getJlAucunAni(),BorderLayout.CENTER);
		
		return panelAni;
	}
	
	public Component initIHM(int CodeClt) { 
		panelAni = new JPanel();
		panelBtn = new JPanel();
		JTable tabAni = new JTable(new ModeleTableAnimaux(CodeClt));
		
		panelAni.setOpaque(true);
		panelAni.setLayout(new BorderLayout());
		
		panelBtn.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelBtn.add(getBtnAjouter());
		panelBtn.add(getBtnSupprimer());
		panelBtn.add(getBtnEditer());
		
		panelAni.add(getJlTitre(),BorderLayout.NORTH);
		panelAni.add(panelBtn,BorderLayout.SOUTH);
		if(tabAni.getRowCount() == 0){
			panelAni.add(getJlAucunAni(),BorderLayout.CENTER);
		} else {
			panelAni.add(tabAni,BorderLayout.CENTER);
		}
		
		return panelAni;
	}
	
	public JLabel getJlTitre() {
		if(jlTitre == null){
			jlTitre = new JLabel("ANIMAUX DU CLIENT SELECTIONNE");
		}
		return jlTitre;
	}
	
	public JLabel getJlAucunAni() {
		if(jlAucunAni == null){
			jlAucunAni = new JLabel("Aucun Animal");
			jlAucunAni.setPreferredSize(new Dimension(300, 200));
			jlAucunAni.setHorizontalAlignment(SwingConstants.CENTER);
			jlAucunAni.setBorder(BorderFactory.createEtchedBorder());
		}
		return jlAucunAni;
	}
	
	public JButton getBtnAjouter() {
		if(btnAjouter == null){
			ImageIcon image = new ImageIcon(
					Toolkit.getDefaultToolkit().getImage(getClass().getResource("../../images/ajouterBlanc.jpg")));
			btnAjouter = new JButton(image);
			btnAjouter.setToolTipText("Ajouter");
		}
		return btnAjouter;
	}
	
	public JButton getBtnSupprimer() {
		if(btnSupprimer == null){
			ImageIcon image = new ImageIcon(
					Toolkit.getDefaultToolkit().getImage(getClass().getResource("../../images/eteindreBlanc.jpg")));
			btnSupprimer = new JButton(image);
			btnSupprimer.setToolTipText("Supprimer");
		}
		return btnSupprimer;
	}
	
	public JButton getBtnEditer() {
		if(btnEditer == null){
			ImageIcon image = new ImageIcon(
					Toolkit.getDefaultToolkit().getImage(getClass().getResource("../../images/imprimerBlanc.jpg")));
			btnEditer = new JButton(image);
			btnEditer.setToolTipText("Editer");
		}
		return btnEditer;
	}

	

	

}
