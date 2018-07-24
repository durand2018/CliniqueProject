package fr.eni.clinique.ihm.animal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.ItemSelectable;
import java.awt.List;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicComboBoxUI.ItemHandler;

import fr.eni.clinique.bll.AnimalMger;
import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bo.Race;

@SuppressWarnings("serial")
public class EcranAnimaux extends JFrame {

	private JPanel panelFinal, panelBtn, panelClt, panelChamps, panelItermediaire;
	private JLabel jlClient, jlCode, jlNom, jlCouleur, jlEspece, jlRace, jlTatoo;
	private JTextField jtClient, jtCode, jtNom, jtCouleur, jtTatoo;
	private JButton btnValider, btnAnnuler;
	private JComboBox<String> jcombSexe, jcombEspece, jcombRaces;
	private AnimalMger mgr;

	public EcranAnimaux() {
		super("Animaux");
		try {
			mgr = AnimalMger.getInstance();
		} catch (BLLException e) {
			e.printStackTrace();
			System.out.println("Aucun animal à afficher !");
		}

		initIHM();
//		jtCode.setText(Integer.toString(mgr.getAnimal(0).getCodeAnimal()));
//		jtNom.setText(mgr.getAnimal(0).getNomAnimal());
//		jtCouleur.setText(mgr.getAnimal(0).getCouleur());
//		jcombSexe.setToolTipText(mgr.getAnimal(0).getSexe());
	jcombEspece.setToolTipText(mgr.getAnimal(6).getEspece());
//		jcombRaces.setToolTipText(mgr.getAnimal(0).getRace());
//		jtTatoo.setText(mgr.getAnimal(0).getTatouage());
	}

	private void initIHM() {
		panelFinal = new JPanel();
		panelItermediaire = new JPanel();
		panelBtn = new JPanel();
		panelClt = new JPanel();
		panelChamps = new JPanel();
		panelFinal.setOpaque(true);
		panelFinal.setLayout(new BorderLayout());
		panelFinal.setBackground(Color.lightGray);
		panelItermediaire.setOpaque(true);
		panelItermediaire.setLayout(new BorderLayout());
		panelItermediaire.setBackground(Color.lightGray);
		panelBtn.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelBtn.setBackground(Color.lightGray);
		panelBtn.setPreferredSize(new Dimension(500, 50));
		panelClt.setLayout(new GridBagLayout());
		panelClt.setBackground(Color.lightGray);
		panelClt.setPreferredSize(new Dimension(500, 80));
		panelChamps.setLayout(new GridBagLayout());
		panelChamps.setBackground(Color.GRAY);
		panelChamps.setMaximumSize(new Dimension(750, 750));
		GridBagConstraints gbc = new GridBagConstraints();
		GridBagConstraints gbcp = new GridBagConstraints();

		/////////////////////////////////////////////////////// PanelBtn
		panelBtn.add(getBtnValider());
		panelBtn.add(getBtnAnnuler());
		gbc.insets = new Insets(5, 5, 5, 5);
		/////////////////////////////////////////////////////// PanelClt
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.anchor = GridBagConstraints.WEST;
		panelClt.add(getJlClient(), gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		panelClt.add(getJtClient(), gbc);

		/////////////////////////////////////////////////////// PanelFields
		// ligne 1
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(5, 5, 5, 5);
		panelChamps.add(getJlCode(), gbc);

		gbc.gridx = 1;
		gbc.gridwidth = 3;
		panelChamps.add(getJtCode(), gbc);

		// ligne2

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		panelChamps.add(getJlName(), gbc);

		gbc.gridx = 1;
		gbc.gridwidth = 3;
		panelChamps.add(getJtName(), gbc);

		gbc.gridx = 4;
		gbc.gridwidth = 1;
		panelChamps.add(getJcombSexe(), gbc);

		// ligne3
		gbc.gridx = 0;
		gbc.gridy = 2;
		panelChamps.add(getJlColor(), gbc);

		gbc.gridx = 1;
		gbc.gridwidth = 3;
		panelChamps.add(getJtColor(), gbc);

		// ligne4
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		panelChamps.add(getJlSpecies(), gbc);

		gbc.gridx = 1;
		gbc.gridwidth = 2;
		panelChamps.add(getJcombEscpece(), gbc);

		gbc.gridx = 3;
		gbc.gridwidth = 1;
		panelChamps.add(getJlRace(), gbc);

		gbc.gridx = 4;
		panelChamps.add(getJcombRaces(), gbc);

		// ligne 5
		gbc.gridx = 0;
		gbc.gridy = 4;
		panelChamps.add(getJlTatoo(), gbc);

		gbc.gridx = 1;
		gbc.gridwidth = 3;
		panelChamps.add(getJtTatoo(), gbc);

		// panels finaux

		panelFinal.add(panelBtn, BorderLayout.NORTH);
		panelItermediaire.add(panelClt, BorderLayout.NORTH);
		panelItermediaire.add(panelChamps, BorderLayout.CENTER);
		panelFinal.add(panelItermediaire, BorderLayout.CENTER);

		this.setContentPane(panelFinal);

	}

	public JLabel getJlClient() {
		if (jlClient == null) {
			jlClient = new JLabel("Client ");
		}
		return jlClient;
	}

	public JLabel getJlCode() {
		if (jlCode == null) {
			jlCode = new JLabel("Code ");
		}
		return jlCode;
	}

	public JLabel getJlName() {
		if (jlNom == null) {
			jlNom = new JLabel("Nom ");
		}
		return jlNom;
	}

	public JLabel getJlColor() {
		if (jlCouleur == null) {
			jlCouleur = new JLabel("Couleur ");
		}
		return jlCouleur;
	}

	public JLabel getJlSpecies() {
		if (jlEspece == null) {
			jlEspece = new JLabel("Espèce ");
		}
		return jlEspece;
	}

	public JLabel getJlRace() {
		if (jlRace == null) {
			jlRace = new JLabel("Race ");
		}
		return jlRace;
	}

	public JLabel getJlTatoo() {
		if (jlTatoo == null) {
			jlTatoo = new JLabel("Tatouage ");
		}
		return jlTatoo;
	}

	public JTextField getJtClient() {
		if (jtClient == null) {
			jtClient = new JTextField(20);
		}
		return jtClient;
	}

	public JTextField getJtCode() {
		if (jtCode == null) {
			jtCode = new JTextField(20);
		}
		return jtCode;
	}

	public JTextField getJtName() {
		if (jtNom == null) {
			jtNom = new JTextField(20);
		}
		return jtNom;
	}

	public JTextField getJtColor() {
		if (jtCouleur == null) {
			jtCouleur = new JTextField(20);
		}
		return jtCouleur;
	}

	public JTextField getJtTatoo() {
		if (jtTatoo == null) {
			jtTatoo = new JTextField(20);
		}
		return jtTatoo;
	}

	public JButton getBtnValider() {
		if (btnValider == null) {
			ImageIcon image = new ImageIcon(
					Toolkit.getDefaultToolkit().getImage(getClass().getResource("../../images/New24.gif")));
			btnValider = new JButton(image);
		}
		return btnValider;
	}

	public JButton getBtnAnnuler() {
		if (btnAnnuler == null) {
			ImageIcon image = new ImageIcon(
					Toolkit.getDefaultToolkit().getImage(getClass().getResource("../../images/New24.gif")));
			btnAnnuler = new JButton(image);
		}
		return btnAnnuler;
	}

	public JComboBox<String> getJcombSexe() {
		jcombSexe = new JComboBox<String>();
		jcombSexe.setPreferredSize(new Dimension(80, 20));
		jcombSexe.addItem("Mâle");
		jcombSexe.addItem("Femelle");

		return jcombSexe;
	}

	public JComboBox<String> getJcombEscpece() {
		jcombEspece = new JComboBox<String>();
		jcombEspece.setPreferredSize(new Dimension(150, 20));
		
		
		jcombEspece.addItemListener(new ItemListener() {
	

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
			System.out.println(jcombEspece.getSelectedIndex());
			}
		});
		Iterator<Race> itR;
		//(null)String especeSelection=(String) jcombEspece.getSelectedItem();

		try {
			ArrayList<String> listeItem = new ArrayList<>(); 
			itR = mgr.selectEspece().iterator();
			Race ra;
			while (itR.hasNext()) {
				ra = itR.next();
				jcombEspece.addItem(ra.getEspece());
				listeItem.add(ra.getEspece().toString());
				//System.out.println(listeItem);
				
				//(null)   System.out.println(especeSelection);
			}
		} catch (BLLException e) {
			e.printStackTrace();
		}

		return jcombEspece;
	}
	
	public JComboBox<String> getJcombRaces() {
		jcombRaces = new JComboBox<String>();
		jcombRaces.setPreferredSize(new Dimension(150, 20));
	
		Iterator<Race> itR;
		String espece=getJcombEscpece().getSelectedItem().toString();
		//System.out.println(espece);
		

		try {
			itR = mgr.selectRaceByEspece(espece).iterator();
			Race ra;
			while (itR.hasNext()) {
				ra = itR.next();
				int i= 0;
				jcombRaces.addItem(ra.getRace());
				
				
				
			}
		} catch (BLLException e) {
			e.printStackTrace();
		}

		return jcombRaces;
	}

	

	// public JComboBox<String> getJcombRace() {
	// jcombRace = new JComboBox<String>();
	// jcombRace.setPreferredSize(new Dimension(150, 20));
	
	// return jcombRace;
	// }

}
