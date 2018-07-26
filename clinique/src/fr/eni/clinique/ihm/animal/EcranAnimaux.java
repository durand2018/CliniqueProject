package fr.eni.clinique.ihm.animal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.eni.clinique.bll.AnimalMger;
import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.ClientsMger;
import fr.eni.clinique.bo.Animaux;
import fr.eni.clinique.bo.Clients;
import fr.eni.clinique.bo.Race;
import fr.eni.clinique.ihm.MiseEnPage;
import fr.eni.clinique.ihm.client.EcranClients;

@SuppressWarnings("serial")
public class EcranAnimaux extends JFrame {

	private JPanel panelFinal, panelBtn, panelClt, panelChamps, panelItermediaire;
	private JLabel jlClient, jlCode, jlNom, jlCouleur, jlEspece, jlRace, jlTatoo;
	private JTextField jtClient, jtCode, jtNom, jtCouleur, jtTatoo;
	private JButton btnValider, btnAnnuler;
	private JComboBox<String> jcombSexe, jcombEspece, jcombRaces;
	private AnimalMger mgr;
	private ClientsMger cmgr;

	private int indexSexe;
	private int indexEspece;
	private int indexRace;

	public int getIndexRace() {
		return indexRace;
	}

	public void setIndexRace(int indexRace) {
		this.indexRace = indexRace;
	}

	public JPanel getPanelFinal() {
		return panelFinal;
	}

	public JPanel getPanelBtn() {
		return panelBtn;
	}

	public JPanel getPanelClt() {
		return panelClt;
	}

	public JPanel getPanelChamps() {
		return panelChamps;
	}

	public JPanel getPanelItermediaire() {
		return panelItermediaire;
	}

	public AnimalMger getMgr() {
		return mgr;
	}

	public int getIndexEspece() {
		return indexEspece;
	}

	public void setIndexEspece(int indexEspece) {
		this.indexEspece = indexEspece;
	}

	public int getIndexSexe() {
		return indexSexe;
	}

	public void setIndexSexe(int indexSexe) {
		this.indexSexe = indexSexe;
	}

	public EcranAnimaux() throws BLLException {
		super("Animaux");
		MiseEnPage.getMiseEnPage();
		this.setLocation(280, 200);
		try {
			mgr = AnimalMger.getInstance();
		} catch (BLLException e) {
			e.printStackTrace();
			System.out.println("Aucun animal à afficher !");
		}
		initIHM();
	}

	public EcranAnimaux(int codeAnimal) throws BLLException {
		super("Animaux");
		try {
			mgr = AnimalMger.getInstance();
			this.setLocation(280, 200);
		} catch (BLLException e) {
			e.printStackTrace();
			System.out.println("Aucun animal à afficher !");
		}

		initIHM(codeAnimal);
		jtCode.setText(Integer.toString(mgr.selectAnimalByCode(codeAnimal).getCodeAnimal()));
		jtNom.setText(mgr.selectAnimalByCode(codeAnimal).getNomAnimal());
		jtCouleur.setText(mgr.selectAnimalByCode(codeAnimal).getCouleur());
		jcombSexe.setToolTipText(mgr.selectAnimalByCode(codeAnimal).getSexe());
		jcombEspece.setToolTipText(mgr.selectAnimalByCode(codeAnimal).getEspece());
		jcombRaces.setToolTipText(mgr.selectAnimalByCode(codeAnimal).getRace());
		jtTatoo.setText(mgr.selectAnimalByCode(codeAnimal).getTatouage());
		jtClient.setText(Integer.toString(mgr.selectAnimalByCode(codeAnimal).getCodeClient()));
	}

	private void initIHM() throws BLLException {
		panelFinal = new JPanel();
		panelItermediaire = new JPanel();
		panelBtn = new JPanel();
		panelClt = new JPanel();
		panelChamps = new JPanel();
		panelFinal.setOpaque(true);
		panelFinal.setLayout(new BorderLayout());
		panelFinal.setBackground(Color.gray);
		panelItermediaire.setOpaque(true);
		panelItermediaire.setLayout(new BorderLayout());
		panelItermediaire.setBackground(Color.gray);
		panelBtn.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelBtn.setBackground(Color.gray);
		panelBtn.setSize(new Dimension(500, 70));
		panelClt.setLayout(new GridBagLayout());
		panelClt.setBackground(Color.lightGray);
		panelClt.setSize(new Dimension(500, 80));
		panelChamps.setLayout(new GridBagLayout());
		panelChamps.setBackground(Color.gray);
		panelChamps.setMaximumSize(new Dimension(750, 750));
		GridBagConstraints gbc = new GridBagConstraints();

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
		panelChamps.add(getJlNom(), gbc);

		gbc.gridx = 1;
		gbc.gridwidth = 3;
		panelChamps.add(getJtNom(), gbc);

		gbc.gridx = 4;
		gbc.gridwidth = 1;
		panelChamps.add(getJcombSexe(), gbc);

		// ligne3
		gbc.gridx = 0;
		gbc.gridy = 2;
		panelChamps.add(getJlCouleur(), gbc);

		gbc.gridx = 1;
		gbc.gridwidth = 3;
		panelChamps.add(getJtCouleur(), gbc);

		// ligne4
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		panelChamps.add(getJlEspece(), gbc);

		gbc.gridx = 1;
		gbc.gridwidth = 2;
		panelChamps.add(getJcombEspece(), gbc);

		gbc.gridx = 3;
		gbc.gridwidth = 1;
		panelChamps.add(getJlRace(), gbc);
		gbc.anchor = GridBagConstraints.EAST;

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

		// Changer Icone fenêtre
		ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource("ico_veto.png"));
		this.setIconImage(image.getImage());

		// Lancer la fenêtre
		this.setContentPane(panelFinal);

	}

	private void initIHM(int codeAnimal) throws BLLException {
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
		panelBtn.setSize(new Dimension(500, 70));
		panelClt.setLayout(new GridBagLayout());
		panelClt.setBackground(Color.lightGray);
		panelClt.setSize(new Dimension(500, 80));
		panelChamps.setLayout(new GridBagLayout());
		panelChamps.setBackground(Color.GRAY);
		panelChamps.setMaximumSize(new Dimension(750, 750));
		GridBagConstraints gbc = new GridBagConstraints();

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
		panelChamps.add(getJlNom(), gbc);

		gbc.gridx = 1;
		gbc.gridwidth = 3;
		panelChamps.add(getJtNom(), gbc);

		gbc.gridx = 4;
		gbc.gridwidth = 1;
		panelChamps.add(getJcombSexe(), gbc);

		// ligne3
		gbc.gridx = 0;
		gbc.gridy = 2;
		panelChamps.add(getJlCouleur(), gbc);

		gbc.gridx = 1;
		gbc.gridwidth = 3;
		panelChamps.add(getJtCouleur(), gbc);

		// ligne4
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		panelChamps.add(getJlEspece(), gbc);

		gbc.gridx = 1;
		gbc.gridwidth = 2;
		panelChamps.add(getJcombEspece(codeAnimal), gbc);

		gbc.gridx = 3;
		gbc.gridwidth = 1;
		panelChamps.add(getJlRace(), gbc);

		gbc.gridx = 4;
		panelChamps.add(getJcombRaces(codeAnimal), gbc);

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
			jlClient = new JLabel("Code client ");
		}
		return jlClient;
	}

	public JLabel getJlCode() {
		if (jlCode == null) {
			jlCode = new JLabel("Code animal ");
		}
		return jlCode;
	}

	public JLabel getJlNom() {
		if (jlNom == null) {
			jlNom = new JLabel("Nom ");
		}
		return jlNom;
	}

	public JLabel getJlCouleur() {
		if (jlCouleur == null) {
			jlCouleur = new JLabel("Couleur ");
		}
		return jlCouleur;
	}

	public JLabel getJlEspece() {
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
			// Récupère le code client
			// Animaux codeClt = getJtClient().getCodeClient();
			// System.out.println(codeClt);

		}
		return jtClient;
	}

	public JTextField getJtCode() {
		if (jtCode == null) {
			jtCode = new JTextField(20);
			jtCode.setEnabled(false);
		}
		return jtCode;
	}

	public JTextField getJtNom() {
		if (jtNom == null) {
			jtNom = new JTextField(20);
		}
		return jtNom;
	}

	public JTextField getJtCouleur() {
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
			ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource("ajouter.png"));
			btnValider = new JButton(image);
			btnValider.setBackground(Color.white);
			btnValider.setToolTipText("Valider");

			btnValider.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					try {
						// Recupere l'animal affiche
						Animaux aniAffiche = getAnimal();
						System.out.println(aniAffiche);
						// Sauvegarde un nouvel animal dans la BDD
						mgr = new AnimalMger();
						mgr.addAnimaux(aniAffiche);

						// Récupère le client correspondant
						cmgr = new ClientsMger();
						int idClt = aniAffiche.getCodeClient();
						Clients c = cmgr.selectByCode(idClt);

						// Ferme l'ecran
						dispose();
						// Actualisation du client
						EcranClients ecranClt = new EcranClients(c);
						ecranClt.setSize(new Dimension(1000, 600));
						ecranClt.setVisible(true);
					} catch (BLLException e1) {
						JOptionPane.showMessageDialog(EcranAnimaux.this, "Une erreur est survenue lors de l'Ajout");
						e1.printStackTrace();
					}
				}
			});
		}
		return btnValider;
	}

	public Animaux getAnimal() throws BLLException {

		Animaux AniCourant = new Animaux();
		AniCourant.setCodeClient(Integer.parseInt(getJtClient().getText()));
		AniCourant.setNomAnimal(getJtNom().getText());
		AniCourant.setCouleur(getJtCouleur().getText());
		// att
		AniCourant.setSexe(getJcombSexe().getItemAt(getIndexSexe()));
		AniCourant.setTatouage(getJtTatoo().getText());
		// att
		AniCourant.setEspece(getJcombEspece().getItemAt(indexEspece).toString().trim());
		// att
		AniCourant.setRace(getJcombRaces().getItemAt(indexRace).toString().trim());
		System.out.println(AniCourant);
		return AniCourant;
	}

	public JButton getBtnAnnuler() {
		if (btnAnnuler == null) {
			ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource("annuler.png"));
			btnAnnuler = new JButton(image);
			btnAnnuler.setBackground(Color.white);
			btnAnnuler.setToolTipText("Annuler");

			btnAnnuler.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
		}
		return btnAnnuler;
	}

	public JComboBox<String> getJcombSexe() {
		jcombSexe = new JComboBox<String>();
		jcombSexe.setPreferredSize(new Dimension(50, 25));
		jcombSexe.addItem("M");
		jcombSexe.addItem("F");
		jcombSexe.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				indexSexe = jcombSexe.getSelectedIndex();
				System.out.println(indexSexe);
				setIndexSexe(indexSexe);

			}
		});

		return jcombSexe;
	}

	public JComboBox<String> getJcombEspece() throws BLLException {
		jcombEspece = new JComboBox<String>();
		jcombEspece.setPreferredSize(new Dimension(180, 25));

		Iterator<Race> itR;
		try {
			itR = mgr.selectEspece().iterator();
			Race ra;
			while (itR.hasNext()) {
				ra = itR.next();
				jcombEspece.addItem(ra.getEspece());
			}
		} catch (BLLException e1) {
			e1.printStackTrace();
		}

		jcombEspece.addActionListener(new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent e) {

				indexEspece = jcombEspece.getSelectedIndex();
				setIndexEspece(indexEspece);
				System.out.println("index choisie dans la comboEspece----" + getIndexEspece());

				try {
					System.out.println("recuperer l'espece choisie----" + getJcombEspece().getItemAt(getIndexEspece()));
				} catch (BLLException e1) {
					e1.printStackTrace();
				}
			}
		});
		return jcombEspece;
	}

	public JComboBox<String> getJcombEspece(int codeAnimal) throws BLLException {
		jcombEspece = new JComboBox<String>();
		jcombEspece.setSize(new Dimension(180, 25));
		jcombEspece.addItem(mgr.selectAnimalByCode(codeAnimal).getEspece());

		return jcombEspece;
	}

	public JComboBox<String> getJcombRaces() throws BLLException {
		jcombRaces = new JComboBox<String>();
		jcombRaces.setPreferredSize(new Dimension(180, 25));
		Iterator<Race> itR;
		try {
			itR = mgr.selectRace().iterator();
			Race ra;
			while (itR.hasNext()) {
				ra = itR.next();
				jcombRaces.addItem(ra.getRace());
			}
			jcombRaces.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					indexRace = jcombRaces.getSelectedIndex();
					setIndexRace(indexRace);
					System.out.println("index race " + indexRace);
				}
			});

		} catch (BLLException e) {
			e.printStackTrace();
		}

		return jcombRaces;
	}

	public JComboBox<String> getJcombRaces(String espece) {
		jcombRaces = new JComboBox<String>();
		jcombRaces.setSize(new Dimension(180, 25));

		Iterator<Race> itR;

		try {
			itR = mgr.selectRaceByEspece(espece).iterator();
			Race ra;
			while (itR.hasNext()) {
				ra = itR.next();
				jcombRaces.addItem(ra.getRace());
				jcombRaces.addItemListener(new ItemListener() {
					@Override
					public void itemStateChanged(ItemEvent e) {
						setIndexEspece(indexRace);
						System.out.println("index race " + getIndexRace());
					}
				});

			}
		} catch (BLLException e) {
			e.printStackTrace();
		}

		return jcombRaces;
	}

	public JComboBox<String> getJcombRaces(int codeAnimal) {
		jcombRaces = new JComboBox<String>();
		jcombRaces.setSize(new Dimension(180, 25));
		try {
			jcombRaces.addItem(mgr.selectAnimalByCode(codeAnimal).getRace());
		} catch (BLLException e) {
			e.printStackTrace();
		}

		return jcombRaces;

	}
}