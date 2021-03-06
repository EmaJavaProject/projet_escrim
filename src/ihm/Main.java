package ihm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 * The Class Main_gui.
 */
public class Main {

	/** The frm escrim. */
	private JFrame frmEscrim;

	/** The stock page. */
	@SuppressWarnings("unused")
	private Stock stockPage;

	/** The localisation page. */
	@SuppressWarnings("unused")
	private Localisation localisationPage;

	/** The avion page. */
	@SuppressWarnings("unused")
	private Avion avionPage;

	/** The panel principal. */
	private JPanel panelPrincipal;

	/** The mntm importer. */
	private JMenuItem mntmImporter;

	/** The menu gestion. */
	private JMenu menuGestion;

	/** The mntm exporter. */
	private JMenuItem mntmExporter;

	/** The mn fichier. */
	private JMenu mnFichier;

	/** The sous menu gestion transport. */
	private JMenuItem sousMenuGestionTransport;

	/** The menu. */
	private JMenuBar menu;

	/** The gestionaire page. */
	private JLayeredPane gestionairePage;

	/** The tab principal. */
	private JTabbedPane tabPrincipal;

	/** The sous menu colis. */
	private JMenuItem sousMenuColis;

	/** The sous menu hopital. */
	private JMenuItem sousMenuHopital;

	/**
	 * Launch the application.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	/**
	 * 
	 */
	private void initialize() {
		DialogTestConnexion diag = new DialogTestConnexion();
		diag.setVisible(true);
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
						"Etes vous s�r de vouloir quitter ?",
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
		menuGestion = new JMenu("Gestion");
		mntmExporter = new JMenuItem("Exporter...");

		mnFichier = new JMenu("Fichier");
		mnFichier.add(mntmImporter);
		mnFichier.add(mntmExporter);

		menu = new JMenuBar();
		menu.add(mnFichier);
		menu.add(menuGestion);

		tabPrincipal = new JTabbedPane(JTabbedPane.LEFT);
		tabPrincipal.setName("");
		tabPrincipal.setBounds(0, 0, 1017, 706);
		panelPrincipal.add(tabPrincipal);

		sousMenuGestionTransport = new JMenuItem("Gestion Transport");
		sousMenuGestionTransport.addActionListener(GestionTransport
				.CreationJpanelTransport(gestionairePage));
		menuGestion.add(sousMenuGestionTransport);

		sousMenuHopital = new JMenuItem("Gestion configuration hopital");
		sousMenuHopital.addActionListener(CreationHopital
				.CreationJpanelHopital(gestionairePage));
		menuGestion.add(sousMenuHopital);

		sousMenuColis = new JMenuItem("Gestion type colis");
		sousMenuColis.addActionListener(CreationTypeColis
				.CreationJpanelTypeColis(gestionairePage));
		menuGestion.add(sousMenuColis);

		stockPage = new Stock(tabPrincipal, gestionairePage);
		localisationPage = new Localisation(tabPrincipal, gestionairePage);
		avionPage = new Avion(tabPrincipal);

		frmEscrim.setJMenuBar(menu);
		frmEscrim.getContentPane().add(gestionairePage);

	}
}
