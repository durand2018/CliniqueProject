package fr.eni.clinique.ihm.client;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class EcranAjoutClient extends JFrame{
	private JButton btnValider, btnAnnuler;
	private JPanel panelAjoutClt, panelBtn;
	
	public EcranAjoutClient() {
		super();
		initIHM();
		
	}


	private void initIHM() {
		panelAjoutClt = new JPanel();
		panelAjoutClt.setOpaque(true);
		panelAjoutClt.setLayout(new BorderLayout());
		
//		panelBtn.setLayout(new FlowLayout(FlowLayout.RIGHT));
//		panelBtn.add(btnValider);
//		panelBtn.add(btnAnnuler);
		PanelClient panClt = new PanelClient();
		
//		panelAjoutClt.add(panelBtn);
		panelAjoutClt.add(panClt);
		
		this.setContentPane(panelAjoutClt);
		
		
		
	}
	
	public JButton getBtnValider() {
		if(btnValider == null){
			ImageIcon image = new ImageIcon(
					Toolkit.getDefaultToolkit().getImage(getClass().getResource("../../images/valider_rond.png")));
			btnValider = new JButton(image);
		}
		return btnValider;
	}


	public JButton getBtnAnnuler() {
		if(btnAnnuler == null){
			ImageIcon image = new ImageIcon(
					Toolkit.getDefaultToolkit().getImage(getClass().getResource("../../images/annuler_rond.png")));
			btnAnnuler = new JButton(image);
		}
		return btnAnnuler;
	}
}
