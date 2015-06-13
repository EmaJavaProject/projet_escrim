package ihm;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumnModel;

public class Main_gui {
	// private boolean clicked = true;
	private JFrame frmEscrim;
	private JTable tableLocalContenuTop;
	private JTextField filtreRecherche;
	private JTable tableLocalContenuBot;
	private JTable tableLocalConteneurTop;
	private JTable tableLocalConteneurBot;
	private JTable tableContenu;

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

		JTabbedPane ongletStock = new JTabbedPane(JTabbedPane.TOP);
		ongletStock.setAlignmentY(Component.TOP_ALIGNMENT);
		ongletStock.setAlignmentX(Component.LEFT_ALIGNMENT);
		panelPrincipal.addTab("Stock", null, ongletStock, null);

		JPanel contenuStock = new JPanel();
		contenuStock.setMinimumSize(new Dimension(20, 20));
		ongletStock.addTab("Contenu", null, contenuStock, null);
		contenuStock.setLayout(null);

		JScrollPane scrollPaneContenu = new JScrollPane();
		scrollPaneContenu.setBounds(12, 56, 800, 486);
		contenuStock.add(scrollPaneContenu);

		tableContenu = new JTable();
		scrollPaneContenu.setViewportView(tableContenu);
		TableColumnModel allTableContenuColumn = new DefaultTableColumnModel();

		// JTableHeader headerContenu = new JTableHeader();

		JButton btnAjouterStock = new JButton("+");
		btnAjouterStock.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// tableContenu.addR
			}
		});
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

		JComboBox<String> comboSelectContenu = new JComboBox<String>();

		// Mise a jour de la JTable en fonction de la combobox
		comboSelectContenu.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (allTableContenuColumn.getColumnCount() != 0) {
					while (allTableContenuColumn.getColumnCount() != 0) {
						allTableContenuColumn
								.removeColumn(allTableContenuColumn
										.getColumn(0));
					}
				}

				;
				tableContenu.setColumnModel(IhmBuilder.BuildTableColumn(
						allTableContenuColumn, comboSelectContenu
								.getSelectedItem().toString()));
			}

		});
		comboSelectContenu.setBounds(12, 13, 141, 25);
		contenuStock.add(comboSelectContenu);
		comboSelectContenu.addItem("Materiel");
		comboSelectContenu.addItem("Médicaments");

		JComboBox<?> comboBox = new JComboBox<Object>();
		comboBox.setBounds(12, 13, 141, 25);
		contenuStock.add(comboBox);

		JPanel conteneurStock = new JPanel();
		ongletStock.addTab("Conteneur", null, conteneurStock, null);

		JTabbedPane ongletLocal = new JTabbedPane(JTabbedPane.TOP);
		ongletLocal.setBorder(null);
		ongletLocal.setAlignmentY(Component.TOP_ALIGNMENT);
		ongletLocal.setAlignmentX(Component.LEFT_ALIGNMENT);
		panelPrincipal.addTab("Localisation", null, ongletLocal, null);

		JPanel contenuLocalisation = new JPanel();
		ongletLocal.addTab("Contenu", null, contenuLocalisation, null);
		contenuLocalisation.setLayout(null);

		JComboBox<?> typeObjets = new JComboBox<Object>();
		typeObjets.setBounds(121, 13, 136, 22);
		contenuLocalisation.add(typeObjets);

		tableLocalContenuTop = new JTable();
		tableLocalContenuTop.setBounds(52, 82, 706, 223);
		contenuLocalisation.add(tableLocalContenuTop);

		filtreRecherche = new JTextField();
		filtreRecherche.setBounds(504, 13, 177, 22);
		contenuLocalisation.add(filtreRecherche);
		filtreRecherche.setColumns(10);

		tableLocalContenuBot = new JTable();
		tableLocalContenuBot.setBounds(52, 359, 706, 223);
		contenuLocalisation.add(tableLocalContenuBot);

		JButton btnModifierContenu = new JButton("Modifier contenu");
		btnModifierContenu.setBounds(121, 612, 136, 25);
		contenuLocalisation.add(btnModifierContenu);

		JPanel conteneurLocalisation = new JPanel();
		ongletLocal.addTab("Conteneur", null, conteneurLocalisation, null);
		conteneurLocalisation.setLayout(null);

		JButton btnNewButton = new JButton("Editer localisation");
		btnNewButton.setBounds(340, 279, 149, 25);
		conteneurLocalisation.add(btnNewButton);

		JComboBox<?> secteur = new JComboBox<Object>();
		secteur.setBounds(63, 29, 160, 22);
		conteneurLocalisation.add(secteur);

		tableLocalConteneurTop = new JTable();
		tableLocalConteneurTop.setBounds(12, 72, 899, 194);
		conteneurLocalisation.add(tableLocalConteneurTop);

		tableLocalConteneurBot = new JTable();
		tableLocalConteneurBot.setBounds(12, 357, 899, 194);
		conteneurLocalisation.add(tableLocalConteneurBot);
		// -------------- THOMAS
		// --------------------------------------------------------------------------
		JPanel ongletAvion = new JPanel();
		panelPrincipal.addTab("Avion", null, ongletAvion, null);
		ongletAvion.setLayout(null);

		// Il affiche obligatoirement un onglet avec le JPanel, voir pour
		// l'enlever ?
		JPanel donneeAvion = new JPanel();
		donneeAvion.setBounds(10, 11, 177, 143);
		ongletAvion.add(donneeAvion);
		donneeAvion.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblDonnee1 = new JLabel("Donn\u00E9e 1 :");
		lblDonnee1.setHorizontalAlignment(SwingConstants.CENTER);
		donneeAvion.add(lblDonnee1);

		JLabel lblValeur1 = new JLabel("Valeur");
		donneeAvion.add(lblValeur1);

		JLabel lblDonne2 = new JLabel("Donn\u00E9e 2 :");
		lblDonne2.setHorizontalAlignment(SwingConstants.CENTER);
		donneeAvion.add(lblDonne2);

		JLabel lblValeur2 = new JLabel("Valeur");
		donneeAvion.add(lblValeur2);

		JLabel lblTransport = new JLabel("Transport :");
		lblTransport.setBounds(219, 12, 70, 21);
		ongletAvion.add(lblTransport);

		JComboBox comboBoxTransport = new JComboBox();
		comboBoxTransport.setBounds(299, 12, 124, 21);
		ongletAvion.add(comboBoxTransport);

		JLabel lblConfiguration = new JLabel("configuration");
		lblConfiguration.setBounds(451, 12, 70, 21);
		ongletAvion.add(lblConfiguration);

		JComboBox comboBoxConfiguration = new JComboBox();
		comboBoxConfiguration.setBounds(531, 12, 124, 21);
		ongletAvion.add(comboBoxConfiguration);

		JButton btnValidationChargement = new JButton("Valider");
		btnValidationChargement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnValidationChargement.setBounds(688, 11, 89, 23);
		ongletAvion.add(btnValidationChargement);

		JScrollPane scrollPaneEditChargement = new JScrollPane();
		scrollPaneEditChargement.setBounds(10, 178, 177, 484);
		ongletAvion.add(scrollPaneEditChargement);

		JPanel listeCaisse = new JPanel();
		scrollPaneEditChargement.setViewportView(listeCaisse);
		listeCaisse.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel caisseObligatoire = new JPanel();
		listeCaisse.add(caisseObligatoire);
		caisseObligatoire.setLayout(null);

		JTable tableCaisseObligatoire = new JTable();
		tableCaisseObligatoire.setBounds(0, 155, 175, -152);
		caisseObligatoire.add(tableCaisseObligatoire);

		JPanel caisseOptionnel = new JPanel();
		listeCaisse.add(caisseOptionnel);
		caisseOptionnel.setLayout(null);

		JTable tableCaisseOptionnelle = new JTable();
		tableCaisseOptionnelle.setBounds(87, 5, 0, 0);
		caisseOptionnel.add(tableCaisseOptionnelle);

		JPanel validation = new JPanel();
		listeCaisse.add(validation);
		validation.setLayout(null);

		JButton btnValidationCaisse = new JButton("Enregistrer");
		btnValidationCaisse.setBounds(43, 76, 89, 23);
		validation.add(btnValidationCaisse);

		JLabel labelValidModif = new JLabel("Toutes modifications non");
		labelValidModif.setHorizontalAlignment(SwingConstants.CENTER);
		labelValidModif.setBounds(10, 11, 155, 23);
		validation.add(labelValidModif);

		JLabel lblNewLabel_1 = new JLabel(" valid\u00E9es ne seront pas prises");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 34, 155, 14);
		validation.add(lblNewLabel_1);

		JLabel lblEnCompte = new JLabel(" en compte");
		lblEnCompte.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnCompte.setBounds(10, 51, 155, 14);
		validation.add(lblEnCompte);

		JButton btnExporter = new JButton("Export");
		btnExporter.setBounds(570, 602, 120, 31);
		ongletAvion.add(btnExporter);

		JPanel panelPlanChargement = new JPanel();
		panelPlanChargement.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelPlanChargement.setBounds(219, 58, 533, 484);
		ongletAvion.add(panelPlanChargement);

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
