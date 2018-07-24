package fr.eni.clinique.ihm.client;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.ClientsMger;
import fr.eni.clinique.bo.Clients;

@SuppressWarnings("serial")
public class EcranAjoutClient extends JFrame{
	private PanelClient panClt;
	
	private JButton btnValider, btnAnnuler;
	private JPanel panelAjoutClt, panelBtn;
	
	private ClientsMger mger;
	
	public EcranAjoutClient() {
		super("Ajouter Client");
		initIHMAjoutClt();
	}


	private void initIHMAjoutClt() {
		panelAjoutClt = new JPanel();
		panelBtn = new JPanel();
				
		panelAjoutClt.setOpaque(true);
		panelAjoutClt.setLayout(new BorderLayout());
		
		panelBtn.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelBtn.add(getBtnValider());
		panelBtn.add(getBtnAnnuler());
		
		panelAjoutClt.add(panelBtn, BorderLayout.NORTH);
		panelAjoutClt.add(getPanClt().initIHM(), BorderLayout.CENTER);
		
		this.setContentPane(panelAjoutClt);
	}
	
	public PanelClient getPanClt() {
		if (panClt == null){
			panClt = new PanelClient();
		}
		return panClt;
	}
	
	public JButton getBtnValider() {
		if(btnValider == null){
			ImageIcon image = new ImageIcon(
					Toolkit.getDefaultToolkit().getImage(getClass().getResource("../../images/saveBlanc.jpg")));
			btnValider = new JButton(image);
			btnValider.setToolTipText("Valider");
			
			btnValider.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// Récupère le client affiché
					Clients cltAffiche = getPanClt().getClient();
					try {
						// Sauvegarde un nouveau client dans la BDD
						mger = new ClientsMger();
						mger.addClients(cltAffiche);
						// Ferme l'écran
						dispose();
						//Ouvre un nouvel �cran client qui affiche le nouveau client
						EcranClients ecranClt = new EcranClients(cltAffiche);
						ecranClt.setSize(new Dimension(1000,600));
						ecranClt.setVisible(true);
						ecranClt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					} catch (BLLException e1) {
						JOptionPane.showConfirmDialog(EcranAjoutClient.this, "Une erreur est survenue lors de l'Ajout");
						e1.printStackTrace();
					}
				}
			});
		}
		return btnValider;
	}


	public JButton getBtnAnnuler() {
		if(btnAnnuler == null){
			ImageIcon image = new ImageIcon(
					Toolkit.getDefaultToolkit().getImage(getClass().getResource("../../images/annulerBlanc.jpg")));
			btnAnnuler = new JButton(image);
			btnAnnuler.setToolTipText("Annuler");
			
			btnAnnuler.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
		}
		return btnAnnuler;
	}
}
