package fr.eni.clinique.ihm.animal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class EcranAnimaux extends JFrame {

	private JPanel panelFinal, panelBtn, panelClt, panelFields, panelIterm;
	private JLabel jlClient, jlCode, jlName, jlColor, jlSpecies, jlRace, jlTatoo;
	private JTextField jtClient, jtCode, jtName, jtColor, jtTatoo;
	private JButton btnValider, btnAnnuler;
	private JComboBox<String> jcombSexe, jcombSpicies, jcombRace;

	public EcranAnimaux() {
		super();
		initIHM();
	}

	private void initIHM() {
		panelFinal = new JPanel();
		panelIterm = new JPanel();
		panelBtn = new JPanel();
		panelClt = new JPanel();
		panelFields = new JPanel();
		panelFinal.setOpaque(true);
		panelFinal.setLayout(new BorderLayout());
		panelFinal.setBackground(Color.lightGray);
		panelIterm.setOpaque(true);
		panelIterm.setLayout(new BorderLayout());
		panelIterm.setBackground(Color.lightGray);
		panelBtn.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelBtn.setBackground(Color.lightGray);
		panelBtn.setPreferredSize(new Dimension(500, 50));
		panelClt.setLayout(new GridBagLayout());
		panelClt.setBackground(Color.lightGray);
		panelClt.setPreferredSize(new Dimension(500, 80));
		panelFields.setLayout(new GridBagLayout());
		panelFields.setBackground(Color.GRAY);
		panelFields.setMaximumSize(new Dimension(750, 750));
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
		panelFields.add(getJlCode(), gbc);

		gbc.gridx = 1;
		gbc.gridwidth = 3;
		panelFields.add(getJtCode(), gbc);

		// ligne2

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		panelFields.add(getJlName(), gbc);

		gbc.gridx = 1;
		gbc.gridwidth = 3;
		panelFields.add(getJtName(), gbc);

		gbc.gridx = 4;
		gbc.gridwidth = 1;
		panelFields.add(getJcombSexe(), gbc);

		// ligne3
		gbc.gridx = 0;
		gbc.gridy = 2;
		panelFields.add(getJlColor(), gbc);

		gbc.gridx = 1;
		gbc.gridwidth = 3;
		panelFields.add(getJtColor(), gbc);

		// ligne4
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		panelFields.add(getJlSpecies(), gbc);

		gbc.gridx = 1;
		gbc.gridwidth = 2;
		panelFields.add(getJcombSpicies(), gbc);

		gbc.gridx = 3;
		gbc.gridwidth = 1;
		panelFields.add(getJlRace(), gbc);

		gbc.gridx = 4;
		panelFields.add(getJcombRace(), gbc);

		// ligne 5
		gbc.gridx = 0;
		gbc.gridy = 4;
		panelFields.add(getJlTatoo(), gbc);

		gbc.gridx = 1;
		gbc.gridwidth = 3;
		panelFields.add(getJtTatoo(), gbc);

		// panels
		gbcp.gridx = 0;
		gbcp.gridy = 0;
		panelFinal.add(panelBtn, BorderLayout.NORTH);
		gbcp.gridx = 0;
		gbcp.gridy = 1;
		panelIterm.add(panelClt, BorderLayout.NORTH);
		gbcp.gridx = 0;
		gbcp.gridy = 1;
		panelIterm.add(panelFields, BorderLayout.CENTER);
		gbcp.gridx = 0;
		gbcp.gridy = 2;
		panelFinal.add(panelIterm, BorderLayout.CENTER);

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
		if (jlName == null) {
			jlName = new JLabel("Nom ");
		}
		return jlName;
	}

	public JLabel getJlColor() {
		if (jlColor == null) {
			jlColor = new JLabel("Couleur ");
		}
		return jlColor;
	}

	public JLabel getJlSpecies() {
		if (jlSpecies == null) {
			jlSpecies = new JLabel("Espèce ");
		}
		return jlSpecies;
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
		if (jtName == null) {
			jtName = new JTextField(20);
		}
		return jtName;
	}

	public JTextField getJtColor() {
		if (jtColor == null) {
			jtColor = new JTextField(20);
		}
		return jtColor;
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
					Toolkit.getDefaultToolkit().getImage(getClass().getResource("../../images/aim.png")));
			btnValider = new JButton(image);
		}
		return btnValider;
	}

	public JButton getBtnAnnuler() {
		if (btnAnnuler == null) {
			ImageIcon image = new ImageIcon(
					Toolkit.getDefaultToolkit().getImage(getClass().getResource("../../images/Forward24.gif")));
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

	public JComboBox<String> getJcombSpicies() {
		jcombSpicies = new JComboBox<String>();
		jcombSpicies.setPreferredSize(new Dimension(150, 20));
		jcombSpicies.addItem("test1");
		jcombSpicies.addItem("test2");

		return jcombSpicies;
	}

	public JComboBox<String> getJcombRace() {
		jcombRace = new JComboBox<String>();
		jcombRace.setPreferredSize(new Dimension(150, 20));
		jcombRace.addItem("test1");
		jcombRace.addItem("test2");
		return jcombRace;
	}

}
