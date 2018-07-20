package fr.eni.clinique.ihm.accueil;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import fr.eni.clinique.bll.LoginMger;
import fr.eni.clinique.bo.Personnels;
import fr.eni.clinique.ihm.gestionpersonnel.EcranGestion;
import fr.eni.clinique.ihm.login.AppliTestIHM;
import fr.eni.clinique.ihm.login.EcranLogin;

public class EcranAccueil extends JFrame {

	private JMenuBar menuBar = new JMenuBar();
	private JMenu menu = new JMenu("Fichier");
	private JMenu menu_2 = new JMenu("Gestion des RDV");
	private JMenuItem menu_3 = new JMenuItem("Agenda");
	private JMenuItem menu_4 = new JMenuItem("Gestion du Personnel");
	private JMenuItem menuItem = new JMenuItem("Deconnection");
	private JMenuItem menuItem1 = new JMenuItem("Fermer");
	private JMenuItem menuItem2 = new JMenuItem("Prise de RDV");
	private JMenuItem menuItem2b = new JMenuItem("Gestion des Clients");
	protected EcranLogin ecranLogin;
	private LoginMger mger = null;
	private Personnels p;

	public EcranAccueil(EcranLogin ecranLogin) {

		CardLayout CardL = new CardLayout();
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.DARK_GRAY);
		setTitle("Ecran d'accueil");
		// setSize(400,300);
		// setResizable(true);
		System.out.println("Lancement EcranAccueil");
		menuBar.add(menu);
		menuBar.add(menu_2);
		menuBar.add(menu_3);
		menuBar.add(menu_4, BorderLayout.EAST);
	

		menu.add(menuItem);
		menu.add(menuItem1);
		menu_2.add(menuItem2);
		menu_2.add(menuItem2b);

		setJMenuBar(menuBar);

		System.out.println(ecranLogin.getCodeRole());
		if (ecranLogin.getCodeRole().equals("VET")) {
			menu_2.setEnabled(false);
			menu_4.setEnabled(false);
		}
		if (ecranLogin.getCodeRole().equals("SEC")) {
			menu_3.setEnabled(false);
			menu_4.setEnabled(false);
		}
		panel1.setLayout(CardL);

		menu_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//
				//
			    //
				//***********ECRAN AGENDA************
				//
				//
				//
			}
		});

		menu_4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				EcranGestion ecranGestion = new EcranGestion();
				ecranGestion.setSize(new Dimension(400, 400));
				ecranGestion.setVisible(true);
			}
		});

		// revenir a l'ecran login a l'action "deconnection"
		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				EcranLogin ecranLogin2 = new EcranLogin();

				ecranLogin2.setSize(new Dimension(500, 250));

				dispose();

				ecranLogin2.setVisible(true);
			}
		});

		// fermer la fenetre a l'action "fermer"
		menuItem1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(DISPOSE_ON_CLOSE);

			}

		});
	}

}
