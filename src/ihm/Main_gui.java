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

public class Main_gui {
	// private boolean clicked = true;
	private JFrame frmEscrim;

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

		JTabbedPane conteneurStock = new JTabbedPane(JTabbedPane.TOP);
		stock.addTab("Conteneur", null, conteneurStock, null);

		JTabbedPane contenuStock = new JTabbedPane(JTabbedPane.TOP);
		stock.addTab("Contenu", null, contenuStock, null);

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
		localisation.setAlignmentY(Component.TOP_ALIGNMENT);
		localisation.setAlignmentX(Component.LEFT_ALIGNMENT);
		panelPrincipal.addTab("Localisation", new ImageIcon(
				"images/icone_localiser.jpg"),
				localisation, null);

		JTabbedPane conteneurLocalisation = new JTabbedPane(JTabbedPane.TOP);
		conteneurLocalisation.setAlignmentY(Component.TOP_ALIGNMENT);
		localisation.addTab("Conteneur", null, conteneurLocalisation, null);

		JTabbedPane contenuLocalisation = new JTabbedPane(JTabbedPane.TOP);
		localisation.addTab("Contenu", null, contenuLocalisation, null);

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
