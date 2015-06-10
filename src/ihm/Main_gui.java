package ihm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import java.awt.Component;

import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.UIManager;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;

public class Main_gui {
	// private boolean clicked = true;
	private JFrame frmEscrim;
	private JTable tableContenu;
	private JTextField filtreRecherche;
	private JTable tableConteneur;
	private JTable tableLocalisationConteneur;
	private JTable tableContenuConteneur;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_gui window = new Main_gui();
					window.frmEscrim.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main_gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEscrim = new JFrame();
		frmEscrim.setTitle("ESCRIM");
		frmEscrim.setResizable(false);
		frmEscrim.setBounds(100, 100, 1024, 768);
		frmEscrim.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmEscrim.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				String ObjButtons[] = { "Oui", "Non" };
				int PromptResult = JOptionPane.showOptionDialog(null,
						"Etes vous sûr de vouloir quitter ?",
						"Quitter l'application", JOptionPane.DEFAULT_OPTION,
						JOptionPane.WARNING_MESSAGE, null, ObjButtons,
						ObjButtons[1]);
				if (PromptResult == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});

		JMenuBar menu = new JMenuBar();
		frmEscrim.setJMenuBar(menu);

		JMenu mnFichier = new JMenu("Fichier");
		menu.add(mnFichier);

		JMenuItem mntmImporter = new JMenuItem("Importer...");
		mnFichier.add(mntmImporter);

		JMenuItem mntmExporter = new JMenuItem("Exporter...");
		mnFichier.add(mntmExporter);

		JMenuItem mnQuitter = new JMenuItem("Quitter");
		mnQuitter.setMaximumSize(new Dimension(100, 50));
		mnQuitter.addActionListener(new QuitterAppli());
		menu.add(mnQuitter);

		JTabbedPane panelPrincipal = new JTabbedPane(JTabbedPane.LEFT);
		panelPrincipal.setName("");
		panelPrincipal.setBounds(0, 0, 1018, 707);
		frmEscrim.getContentPane().add(panelPrincipal);

		JTabbedPane stock = new JTabbedPane(JTabbedPane.TOP);
		stock.setAlignmentY(Component.TOP_ALIGNMENT);
		stock.setAlignmentX(Component.LEFT_ALIGNMENT);
		panelPrincipal
				.addTab("Stock",
						new ImageIcon(
								"images/icone_stock.jpg"),
						stock, null);
		
		JPanel contenuStock = new JPanel();
		contenuStock.setMinimumSize(new Dimension(20, 20));
		stock.addTab("Contenu", null, contenuStock, null);
		contenuStock.setLayout(null);
		
		
		
		table = new JTable();
		table.setBounds(12, 56, 619, 486);
		contenuStock.add(table);
		
		JButton btnAjouterStock = new JButton("+");
		btnAjouterStock.setBounds(12, 589, 97, 25);
		contenuStock.add(btnAjouterStock);
		
		JButton btnSupprimerStock = new JButton("-");
		btnSupprimerStock.setBounds(121, 589, 97, 25);
		contenuStock.add(btnSupprimerStock);
		
		JButton btnEditerStock = new JButton("Editer");
		btnEditerStock.setBounds(230, 589, 97, 25);
		contenuStock.add(btnEditerStock);
		
		JButton btnLocaliserStock = new JButton("Localiser");
		btnLocaliserStock.setBounds(339, 589, 97, 25);
		contenuStock.add(btnLocaliserStock);
		
		JComboBox<?> comboBox = new JComboBox<Object>();
		comboBox.setBounds(12, 13, 141, 25);
		contenuStock.add(comboBox);
		
		JPanel panel = new JPanel();
		panel.setBounds(655, 56, 141, 353);
		contenuStock.add(panel);
		
		JCheckBox chckbxId = new JCheckBox("Produit");
		chckbxId.setPreferredSize(new Dimension(129, 23));
		chckbxId.setMinimumSize(new Dimension(50, 100));
		chckbxId.setSelected(true);
		panel.add(chckbxId);
		
		JCheckBox chckbxDci = new JCheckBox("DCI");
		chckbxDci.setPreferredSize(new Dimension(129, 22));
		chckbxDci.setSize(new Dimension(50, 100));
		chckbxDci.setAlignmentX(Component.RIGHT_ALIGNMENT);
		chckbxDci.setBackground(SystemColor.control);
		chckbxDci.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxDci.setMaximumSize(new Dimension(100, 50));
		chckbxDci.setSelected(true);
		panel.add(chckbxDci);
		
		JCheckBox chckbxFormeDosage = new JCheckBox("Forme dosage");
		chckbxFormeDosage.setPreferredSize(new Dimension(129, 23));
		chckbxFormeDosage.setSelected(true);
		panel.add(chckbxFormeDosage);
		
		JCheckBox chckbxPoids = new JCheckBox("DLU");
		chckbxPoids.setPreferredSize(new Dimension(129, 23));
		chckbxPoids.setSelected(true);
		panel.add(chckbxPoids);
		
		JCheckBox chckbxQuantit = new JCheckBox("Quantitt\u00E9");
		chckbxQuantit.setPreferredSize(new Dimension(129, 23));
		chckbxQuantit.setSelected(true);
		panel.add(chckbxQuantit);
		
		JCheckBox chckbxLot = new JCheckBox("Lot");
		chckbxLot.setPreferredSize(new Dimension(129, 23));
		panel.add(chckbxLot);
		
		JCheckBox chckbxClasseThrapeutique_1 = new JCheckBox("Classe Th\u00E9rapeutique");
		panel.add(chckbxClasseThrapeutique_1);
		
		JCheckBox chckbxClasseThrapeutique = new JCheckBox("N\u00B0 Caisse");
		chckbxClasseThrapeutique.setPreferredSize(new Dimension(129, 23));
		panel.add(chckbxClasseThrapeutique);
		
		JCheckBox chckbxCaisse = new JCheckBox("Caisse");
		chckbxCaisse.setPreferredSize(new Dimension(129, 23));
		panel.add(chckbxCaisse);
		
		JCheckBox chckbxDotationU = new JCheckBox("Dotation U7");
		chckbxDotationU.setPreferredSize(new Dimension(129, 23));
		chckbxDotationU.setActionCommand("Dotation U7");
		panel.add(chckbxDotationU);
		
		JPanel conteneurStock = new JPanel();
		stock.addTab("Conteneur", null, conteneurStock, null);

		JTabbedPane avion = new JTabbedPane(JTabbedPane.LEFT);
		avion.setAlignmentY(Component.TOP_ALIGNMENT);
		avion.setAlignmentX(Component.LEFT_ALIGNMENT);
		panelPrincipal
				.addTab("Avion",
						new ImageIcon(
								"images/icone_avion.jpg"),
						avion, null);
		panelPrincipal.setEnabledAt(1, true);

		JTabbedPane localisation = new JTabbedPane(JTabbedPane.TOP);
		localisation.setBorder(null);
		localisation.setAlignmentY(Component.TOP_ALIGNMENT);
		localisation.setAlignmentX(Component.LEFT_ALIGNMENT);
		panelPrincipal.addTab("Localisation", new ImageIcon(
				"images/icone_localiser.jpg"),
				localisation, null);
		
		JPanel contenuLocalisation = new JPanel();
		localisation.addTab("Contenu", null, contenuLocalisation, null);
		contenuLocalisation.setLayout(null);
		
		JComboBox<?> typeObjets = new JComboBox<Object>();
		typeObjets.setBounds(121, 13, 136, 22);
		contenuLocalisation.add(typeObjets);
		
		tableContenu = new JTable();
		tableContenu.setBounds(52, 82, 706, 223);
		contenuLocalisation.add(tableContenu);
		
		filtreRecherche = new JTextField();
		filtreRecherche.setBounds(504, 13, 177, 22);
		contenuLocalisation.add(filtreRecherche);
		filtreRecherche.setColumns(10);
		
		tableConteneur = new JTable();
		tableConteneur.setBounds(52, 359, 706, 223);
		contenuLocalisation.add(tableConteneur);
		
		JButton btnModifierContenu = new JButton("Modifier contenu");
		btnModifierContenu.setBounds(121, 612, 136, 25);
		contenuLocalisation.add(btnModifierContenu);
		
		JPanel conteneurLocalisation = new JPanel();
		localisation.addTab("Conteneur", null, conteneurLocalisation, null);
		conteneurLocalisation.setLayout(null);
		
		JButton btnNewButton = new JButton("Editer localisation");
		btnNewButton.setBounds(340, 279, 149, 25);
		conteneurLocalisation.add(btnNewButton);
		
		JComboBox<?> secteur = new JComboBox<Object>();
		secteur.setBounds(63, 29, 160, 22);
		conteneurLocalisation.add(secteur);
		
		tableLocalisationConteneur = new JTable();
		tableLocalisationConteneur.setBounds(12, 72, 899, 194);
		conteneurLocalisation.add(tableLocalisationConteneur);
		
		tableContenuConteneur = new JTable();
		tableContenuConteneur.setBounds(12, 357, 899, 194);
		conteneurLocalisation.add(tableContenuConteneur);

		// Icon buttonIcon = new ImageIcon("images/ICONE_AVION.jpg");
		// Icon buttonIcon2 = new ImageIcon("images/ICONE_AVION_GRIS.jpg");
		// JButton button = new JButton(buttonIcon);
		// button.setToolTipText("Avion");
		// button.setBorder(BorderFactory.createEmptyBorder());
		// ActionListener action = new ActionListener() {
		// public void actionPerformed(ActionEvent e) {
		// if (clicked) {
		// button.setIcon(buttonIcon2);
		// clicked = false;
		// } else {
		// button.setIcon(buttonIcon);
		// clicked = true;
		// }
		//
		// }
		// };
		// button.addActionListener(action);

		// button.setContentAreaFilled(false);
		// panel.add(button);

	}

	static class QuitterAppli implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String ObjButtons[] = { "Oui", "Non" };
			int PromptResult = JOptionPane.showOptionDialog(null,
					"Etes vous sûr de vouloir quitter ?",
					"Quitter l'application", JOptionPane.DEFAULT_OPTION,
					JOptionPane.WARNING_MESSAGE, null, ObjButtons,
					ObjButtons[1]);
			if (PromptResult == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}
	}
}
