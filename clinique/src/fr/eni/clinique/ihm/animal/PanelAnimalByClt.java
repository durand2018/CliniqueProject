package fr.eni.clinique.ihm.animal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import fr.eni.clinique.ihm.MiseEnPage;

@SuppressWarnings("serial")
public class PanelAnimalByClt extends JFrame {
	private JLabel jlTitre, jlAucunAni;
	private JButton btnAjouter, btnSupprimer, btnEditer;
	private JPanel panelBtn, panelAni;

	public PanelAnimalByClt() {
		super();
		MiseEnPage.getMiseEnPage();
		initIHM();
	}

	public PanelAnimalByClt(int CodeClt) {
		super();
		MiseEnPage.getMiseEnPage();
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
		panelBtn.setBackground(Color.gray);

		panelAni.add(getJlTitre(), BorderLayout.NORTH);
		panelAni.add(panelBtn, BorderLayout.SOUTH);
		panelAni.add(getJlAucunAni(), BorderLayout.CENTER);
		panelAni.setBackground(Color.gray);
		//créer une bordure de trait noir et largeur minimale 1
	    Border lineborder = BorderFactory.createLineBorder(Color.gray, 5); 
	    //associer à JLabel
	    panelAni.setBorder(lineborder);
	    
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
		panelBtn.setBackground(Color.gray);

		panelAni.add(getJlTitre(), BorderLayout.NORTH);
		panelAni.add(panelBtn, BorderLayout.SOUTH);
		panelAni.setBackground(Color.gray);
		//créer une bordure de trait noir et largeur minimale 1
	    Border lineborder = BorderFactory.createLineBorder(Color.gray, 5); 
	    //associer à JLabel
	    panelAni.setBorder(lineborder);
		if (tabAni.getRowCount() == 0) {
			panelAni.add(getJlAucunAni(), BorderLayout.CENTER);
		} else {
			panelAni.add(tabAni, BorderLayout.CENTER);
		}

		return panelAni;
	}

	public JLabel getJlTitre() {
		if (jlTitre == null) {
			jlTitre = new JLabel("ANIMAUX DU CLIENT SELECTIONNE");
		}
		return jlTitre;
	}

	public JLabel getJlAucunAni() {
		if (jlAucunAni == null) {
			jlAucunAni = new JLabel("Aucun Animal");
			jlAucunAni.setPreferredSize(new Dimension(300, 200));
			jlAucunAni.setHorizontalAlignment(SwingConstants.CENTER);
			jlAucunAni.setBorder(BorderFactory.createEtchedBorder());
		}
		return jlAucunAni;
	}

	public JButton getBtnAjouter() {
		if (btnAjouter == null) {
			ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource("ajouter.png"));
			btnAjouter = new JButton(image);
			btnAjouter.setBackground(Color.white);
			btnAjouter.setToolTipText("Ajouter");
		}
		return btnAjouter;
	}

	public JButton getBtnSupprimer() {
		if (btnSupprimer == null) {
			ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource("supprimer.png"));
			btnSupprimer = new JButton(image);
			btnSupprimer.setBackground(Color.white);
			btnSupprimer.setToolTipText("Supprimer");
		}
		return btnSupprimer;
	}

	public JButton getBtnEditer() {
		if (btnEditer == null) {
			ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource("editer.png"));
			btnEditer = new JButton(image);
			btnEditer.setBackground(Color.white);
			btnEditer.setToolTipText("Editer");
		}
		return btnEditer;
	}

}
