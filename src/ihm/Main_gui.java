package ihm;


import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


public class Main_gui {
	// private boolean clicked = true;
	private JFrame frmEscrim;
	private Stock stockPage;
	private Localisation localisationPage;
	private Avion avionPage;

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

		JMenu menuGestionTransport = new JMenu("Gestion Transport");
		menu.add(menuGestionTransport);

		JLayeredPane gestionairePage = new JLayeredPane();
		gestionairePage.setBounds(0, 0, 1018, 707);
		frmEscrim.getContentPane().add(gestionairePage);

		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBounds(0, 0, 1018, 718);
		panelPrincipal.setLayout(null);
		panelPrincipal.setName("panelPrincipale");
		panelPrincipal.setOpaque(true);

		gestionairePage.add(panelPrincipal, new Integer(1));
		gestionairePage.moveToBack(panelPrincipal);
		gestionairePage.revalidate();

		JTabbedPane tabPrincipal = new JTabbedPane(JTabbedPane.LEFT);
		tabPrincipal.setName("");
		tabPrincipal.setBounds(0, 0, 1017, 706);
		panelPrincipal.add(tabPrincipal);

		JMenuItem sousMenuGestionAvion = new JMenuItem("Gestion Avion");
		sousMenuGestionAvion.addActionListener(GestionAvion
				.CréationJpanelAvion(gestionairePage));
		menuGestionTransport.add(sousMenuGestionAvion);

		stockPage = new Stock(tabPrincipal);
		localisationPage = new Localisation(tabPrincipal);
		avionPage = new Avion(tabPrincipal);


	}
}
