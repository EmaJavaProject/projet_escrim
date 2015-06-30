package ihm;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import escrim.manager.ColisManager;
import escrim.manager.CompartimentManager;
import escrim.manager.MaterielManager;
import escrim.model.table.ConfigurationHopitalTableModel;
import escrim.model.table.RemplissageColisTableModel;
import escrim.model.table.RemplissageConfigurationHopitalTableModel;
import escrim.model.table.RemplissageTransportTableModel;
import escrim.model.table.TransportTableModel;

/**
 * The Class Remplissage.
 */
public class Remplissage {

	/** The table contenu top. */
	private static JTable tableContenuTop;

	/** The table contenu bot. */
	private static JTable tableContenuBot;

	/** The txt conteneur. */
	private static JTextField txtConteneur;

	/** The contenue remplissage. */
	private static JPanel contenueRemplissage;

	/** The scroll pane contenu bot. */
	private static JScrollPane scrollPaneContenuBot;

	/** The scroll pane contenu top. */
	private static JScrollPane scrollPaneContenuTop;

	/** The btn sauvegarder et quitter. */
	private static JButton btnSauvegarderEtQuitter;

	/** The bouton ajouter contenu. */
	private static JButton boutonAjouterContenu;

	/** The bouton supprimer contenu. */
	private static JButton boutonSupprimerContenu;

	/** The outside colis table model. */
	private static RemplissageColisTableModel outsideColisTableModel;

	/** The inside colis table model. */
	private static RemplissageColisTableModel insideColisTableModel;

	/** The outside transport table model. */
	private static RemplissageTransportTableModel outsideTransportTableModel;

	/** The inside transport table model. */
	private static RemplissageTransportTableModel insideTransportTableModel;

	private static RemplissageConfigurationHopitalTableModel outsideConfigHopitalTableModel;

	private static RemplissageConfigurationHopitalTableModel insideConfigHopitalTableModel;

	// ------------------------------------------COLIS--------------------------------------------------//

	/**
	 * Création jpanel remplissage colis.
	 *
	 * @param gestionairePage
	 *            the gestionaire page
	 * @param uidColis
	 *            the uid colis
	 */
	public static void CreationJpanelRemplissageColis(
			JLayeredPane gestionairePage, int uidColis) {

		txtConteneur = new JTextField();
		txtConteneur.setHorizontalAlignment(SwingConstants.CENTER);
		txtConteneur.setEnabled(false);
		txtConteneur.setPreferredSize(new Dimension(20, 20));
		txtConteneur.setText("Contenue du colis");
		txtConteneur.setColumns(10);
		txtConteneur.setBounds(50, 20, 260, 25);

		outsideColisTableModel = new RemplissageColisTableModel(true, uidColis);

		tableContenuTop = new JTable(outsideColisTableModel);
		tableContenuTop.setBounds(62, 100, 706, 223);

		insideColisTableModel = new RemplissageColisTableModel(false, uidColis);

		tableContenuBot = new JTable(insideColisTableModel);
		tableContenuBot.setBounds(52, 400, 706, 223);

		tableContenuTop.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableContenuTop.setRowSelectionAllowed(true);

		tableContenuBot.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableContenuBot.setRowSelectionAllowed(true);

		scrollPaneContenuTop = new JScrollPane();
		scrollPaneContenuTop.setBounds(52, 75, 706, 223);
		scrollPaneContenuTop.add(tableContenuTop);

		scrollPaneContenuBot = new JScrollPane();
		scrollPaneContenuBot.setBounds(52, 425, 706, 223);
		scrollPaneContenuBot.add(tableContenuBot);

		boutonAjouterContenu = new JButton(
				new ImageIcon("images/flecheBas.png"));
		boutonAjouterContenu.setBounds(155, 324, 70, 70);

		boutonSupprimerContenu = new JButton(new ImageIcon(
				"images/flechehaut.png"));
		boutonSupprimerContenu.setBounds(550, 324, 70, 70);

		boutonAjouterContenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!(tableContenuTop.getSelectedRow() == -1)) {
					MaterielManager.fillColis(uidColis, (int) tableContenuTop
							.getValueAt(tableContenuTop.getSelectedRow(),
									tableContenuTop.getColumnCount() - 1));
					outsideColisTableModel.refreshModel(true);
					insideColisTableModel.refreshModel(false);
				}
			}
		});

		boutonSupprimerContenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int selectedRow = tableContenuBot.getSelectedRow();
				if (!(selectedRow == -1)) {
					MaterielManager.fillOutColis(uidColis,
							(int) tableContenuBot.getValueAt(selectedRow,
									tableContenuBot.getColumnCount() - 1));
					((RemplissageColisTableModel) tableContenuTop.getModel())
							.refreshModel(true);
					((RemplissageColisTableModel) tableContenuBot.getModel())
							.refreshModel(false);
					tableContenuTop.repaint();
					tableContenuBot.repaint();
				}
			}
		});

		btnSauvegarderEtQuitter = new JButton("Sauvegarder et quitter");
		btnSauvegarderEtQuitter.setBounds(800, 612, 180, 25);
		btnSauvegarderEtQuitter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				for (Component composant : gestionairePage.getComponents()) {
					if (composant.getName().equals("Remplissage"))
						gestionairePage.remove(composant);
				}
				gestionairePage.repaint();

			}
		});

		contenueRemplissage = new JPanel();
		contenueRemplissage.setLayout(null);
		contenueRemplissage.setName("Remplissage");
		contenueRemplissage.add(scrollPaneContenuBot);
		contenueRemplissage.add(btnSauvegarderEtQuitter);
		contenueRemplissage.add(boutonAjouterContenu);
		contenueRemplissage.add(boutonSupprimerContenu);
		contenueRemplissage.add(scrollPaneContenuTop);
		contenueRemplissage.add(txtConteneur);
		contenueRemplissage.setBounds(0, 0, 1017, 706);

		scrollPaneContenuTop.setViewportView(tableContenuTop);
		scrollPaneContenuBot.setViewportView(tableContenuBot);

		gestionairePage.add(contenueRemplissage, new Integer(5));
		gestionairePage.revalidate();
		gestionairePage.repaint();

	}

	// ---------------------------------------TRANSPORT-----------------------------------------------------//

	/**
	 * Création jpanel remplissage transport.
	 *
	 * @param gestionairePage
	 *            the gestionaire page
	 * @param pModelTable
	 *            the model table
	 * @param uidTransport
	 *            the uid transport
	 */
	public static void CreationJpanelRemplissageTransport(
			JLayeredPane gestionairePage,
			int uidTransport) {

		txtConteneur = new JTextField();
		txtConteneur.setHorizontalAlignment(SwingConstants.CENTER);
		txtConteneur.setEnabled(false);
		txtConteneur.setPreferredSize(new Dimension(20, 20));
		txtConteneur.setText("Composition du transport");
		txtConteneur.setColumns(10);
		txtConteneur.setBounds(50, 20, 260, 25);

		outsideTransportTableModel = new RemplissageTransportTableModel(true,
				uidTransport);

		tableContenuTop = new JTable(outsideTransportTableModel);
		tableContenuTop.setBounds(62, 100, 706, 223);

		insideTransportTableModel = new RemplissageTransportTableModel(false,
				uidTransport);

		tableContenuBot = new JTable(insideTransportTableModel);
		tableContenuBot.setBounds(52, 400, 706, 223);

		tableContenuBot.setName("Caisse");
		tableContenuBot.setBounds(52, 400, 706, 223);

		scrollPaneContenuTop = new JScrollPane();
		scrollPaneContenuTop.setBounds(52, 75, 706, 223);
		scrollPaneContenuTop.add(tableContenuTop);
		scrollPaneContenuTop.setViewportView(tableContenuTop);

		scrollPaneContenuBot = new JScrollPane();
		scrollPaneContenuBot.setBounds(52, 425, 706, 223);
		scrollPaneContenuBot.add(tableContenuBot);
		scrollPaneContenuBot.setViewportView(tableContenuBot);

		boutonAjouterContenu = new JButton(
				new ImageIcon("images/flecheBas.png"));
		boutonAjouterContenu.setBounds(155, 324, 70, 70);
		boutonSupprimerContenu = new JButton(new ImageIcon(
				"images/flechehaut.png"));
		boutonSupprimerContenu.setBounds(550, 324, 70, 70);

		boutonAjouterContenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (!(tableContenuTop.getSelectedRow() == -1)) {
					CompartimentManager.fillTransport(uidTransport,
							(int) tableContenuTop.getValueAt(
									tableContenuTop.getSelectedRow(),
									tableContenuTop.getColumnCount() - 1));
					outsideTransportTableModel.refreshModel(true);
					insideTransportTableModel.refreshModel(false);
				}
			}
		});
		boutonSupprimerContenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (!(tableContenuBot.getSelectedRow() == -1)) {
					CompartimentManager.fillOutTransport(uidTransport,
							(int) tableContenuBot.getValueAt(
									tableContenuBot.getSelectedRow(),
									tableContenuBot.getColumnCount() - 1));
					outsideTransportTableModel.refreshModel(true);
					insideTransportTableModel.refreshModel(false);

				}
			}
		});

		btnSauvegarderEtQuitter = new JButton("Sauvegarder et quitter");
		btnSauvegarderEtQuitter.setBounds(800, 612, 180, 25);
		btnSauvegarderEtQuitter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				for (Component composant : gestionairePage.getComponents()) {
					if (composant.getName().equals("Remplissage"))
						gestionairePage.remove(composant);
				}
				gestionairePage.repaint();

			}
		});

		contenueRemplissage = new JPanel();
		contenueRemplissage.setLayout(null);
		contenueRemplissage.setName("Remplissage");
		contenueRemplissage.add(scrollPaneContenuBot);
		contenueRemplissage.add(btnSauvegarderEtQuitter);
		contenueRemplissage.add(boutonAjouterContenu);
		contenueRemplissage.add(boutonSupprimerContenu);
		contenueRemplissage.add(scrollPaneContenuTop);
		contenueRemplissage.add(txtConteneur);
		contenueRemplissage.setBounds(0, 0, 1017, 706);

		gestionairePage.add(contenueRemplissage, new Integer(5));
		gestionairePage.revalidate();
		gestionairePage.repaint();

	}

	// -----------------------------------CONFIGURATION
	// HOPITAL----------------------------------------//

	/**
	 * Création jpanel remplissage config hopital.
	 *
	 * @param gestionairePage
	 *            the gestionaire page
	 * @param pModelTable
	 *            the model table
	 * @param index
	 *            the index
	 */
	public static void CreationJpanelRemplissageConfigHopital(
			JLayeredPane gestionairePage,
			int uidConfigurationHopital) {

		outsideConfigHopitalTableModel = new RemplissageConfigurationHopitalTableModel(
				true, uidConfigurationHopital);

		tableContenuTop = new JTable(outsideConfigHopitalTableModel);
		tableContenuTop.setBounds(62, 100, 706, 223);

		insideConfigHopitalTableModel = new RemplissageConfigurationHopitalTableModel(
				false, uidConfigurationHopital);

		tableContenuBot = new JTable(insideConfigHopitalTableModel);
		tableContenuBot.setBounds(52, 400, 706, 223);

		txtConteneur = new JTextField();
		txtConteneur.setHorizontalAlignment(SwingConstants.CENTER);
		txtConteneur.setEnabled(false);
		txtConteneur.setPreferredSize(new Dimension(20, 20));
		txtConteneur.setText("Contenu de la configuration d'hopital");
		txtConteneur.setColumns(10);
		txtConteneur.setBounds(50, 20, 260, 25);

		tableContenuBot.setBounds(52, 400, 706, 223);

		scrollPaneContenuTop = new JScrollPane();
		scrollPaneContenuTop.setBounds(52, 75, 706, 223);
		scrollPaneContenuTop.add(tableContenuTop);
		scrollPaneContenuTop.setViewportView(tableContenuTop);

		scrollPaneContenuBot = new JScrollPane();
		scrollPaneContenuBot.setBounds(52, 425, 706, 223);
		scrollPaneContenuBot.add(tableContenuBot);
		scrollPaneContenuBot.setViewportView(tableContenuBot);

		boutonAjouterContenu = new JButton(
				new ImageIcon("images/flecheBas.png"));
		boutonAjouterContenu.setBounds(155, 324, 70, 70);

		boutonSupprimerContenu = new JButton(new ImageIcon(
				"images/flechehaut.png"));
		boutonSupprimerContenu.setBounds(550, 324, 70, 70);

		boutonAjouterContenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (!(tableContenuTop.getSelectedRow() == -1)) {
					ColisManager.fillConfig(uidConfigurationHopital,
							(int) tableContenuTop.getValueAt(
									tableContenuTop.getSelectedRow(),
									tableContenuTop.getColumnCount() - 1));
					outsideConfigHopitalTableModel.refreshModel(true);
					insideConfigHopitalTableModel.refreshModel(false);
				}
			}
		});
		boutonSupprimerContenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (!(tableContenuBot.getSelectedRow() == -1)) {
					ColisManager.fillOutConfig(uidConfigurationHopital,
							(int) tableContenuBot.getValueAt(
									tableContenuBot.getSelectedRow(),
									tableContenuBot.getColumnCount() - 1));
					outsideConfigHopitalTableModel.refreshModel(true);
					insideConfigHopitalTableModel.refreshModel(false);

				}
			}
		});

		btnSauvegarderEtQuitter = new JButton("Sauvegarder et quitter");
		btnSauvegarderEtQuitter.setBounds(800, 612, 180, 25);
		btnSauvegarderEtQuitter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				for (Component composant : gestionairePage.getComponents()) {
					if (composant.getName().equals("Remplissage"))
						gestionairePage.remove(composant);
				}
				gestionairePage.repaint();

			}
		});

		contenueRemplissage = new JPanel();
		contenueRemplissage.setLayout(null);
		contenueRemplissage.setName("Remplissage");
		contenueRemplissage.add(scrollPaneContenuBot);
		contenueRemplissage.add(btnSauvegarderEtQuitter);
		contenueRemplissage.add(boutonAjouterContenu);
		contenueRemplissage.add(boutonSupprimerContenu);
		contenueRemplissage.add(scrollPaneContenuTop);
		contenueRemplissage.add(txtConteneur);
		contenueRemplissage.setBounds(0, 0, 1017, 706);

		gestionairePage.add(contenueRemplissage, new Integer(5));
		gestionairePage.revalidate();
		gestionairePage.repaint();

	}
}
