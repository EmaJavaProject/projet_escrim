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
	private JPanel panelPrincipal;
	private JMenuItem mntmImporter;
	private JMenu menuGestionTransport;
	private JMenuItem mntmExporter;
	private JMenu mnFichier;
	private JMenuItem sousMenuGestionAvion;
	private JMenuBar menu;
	private JLayeredPane gestionairePage;
	private JTabbedPane tabPrincipal;

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

		panelPrincipal = new JPanel();
		panelPrincipal.setBounds(0, 0, 1018, 718);
		panelPrincipal.setLayout(null);
		panelPrincipal.setName("panelPrincipale");
		panelPrincipal.setOpaque(true);
		
		gestionairePage = new JLayeredPane();
		gestionairePage.setBounds(0, 0, 1018, 707);
		gestionairePage.add(panelPrincipal, new Integer(1));
		gestionairePage.moveToBack(panelPrincipal);
		gestionairePage.revalidate();
		
		mntmImporter = new JMenuItem("Importer...");
		menuGestionTransport = new JMenu("Gestion Transport");
		mntmExporter = new JMenuItem("Exporter...");

		mnFichier = new JMenu("Fichier");
		mnFichier.add(mntmImporter);
		mnFichier.add(mntmExporter);

		menu = new JMenuBar();
		menu.add(mnFichier);
		menu.add(menuGestionTransport);

		

		tabPrincipal = new JTabbedPane(JTabbedPane.LEFT);
		tabPrincipal.setName("");
		tabPrincipal.setBounds(0, 0, 1017, 706);
		panelPrincipal.add(tabPrincipal);

		sousMenuGestionAvion = new JMenuItem("Gestion Avion");
		sousMenuGestionAvion.addActionListener(GestionTransport
				.CréationJpanelTransport(gestionairePage));
		menuGestionTransport.add(sousMenuGestionAvion);

		stockPage = new Stock(tabPrincipal);
		localisationPage = new Localisation(tabPrincipal);
		avionPage = new Avion(tabPrincipal);

		frmEscrim.setJMenuBar(menu);
		frmEscrim.getContentPane().add(gestionairePage);

	}
}
