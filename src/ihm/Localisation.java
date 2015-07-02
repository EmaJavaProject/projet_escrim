package ihm;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import escrim.model.table.ColisTableModel;
import escrim.model.table.RemplissageColisTableModel;
import escrim.utils.ComboBoxBuilder;

/**
 * The Class Localisation.
 */
public class Localisation {

	/** The table local configHopital top. */
	private JTable tableLocalconfigHopitalTop;

	/** The table local configHopital bot. */
	private JTable tableLocalconfigHopitalBot;

	/** The table local Colis top. */
	private JTable tableLocalColisTop;

	/** The table local Colis bot. */
	private JTable tableLocalColisBot;

	/** The onglet. */
	private JTabbedPane onglet;

	/** The scroll pane configHopital. */
	private JScrollPane scrollPaneconfigHopitalTop;

	/** The configHopital localisation. */
	private JPanel configHopitalLocalisation;

	/** The scroll pane configHopital local bot. */
	private JScrollPane scrollPaneconfigHopitalLocalBot;

	/** The combo select configHopital local. */
	private JComboBox<Object> comboSelectconfigHopitalLocal;

	/** The btn modifier configHopital. */
	private JButton btnModifierconfigHopital;

	/** The Colis localisation. */
	private JPanel ColisLocalisationPanel;

	/** The bouton editer localisation. */
	private JButton boutonEditerLocalisation;

	/** The secteur. */
	private JComboBox<Object> comboBoxsecteur;

	/** The scroll pane local Colis top. */
	private JScrollPane scrollPaneLocalColisTop;

	/** The scroll pane local Colis bot. */
	private JScrollPane scrollPaneLocalColisBot;

	/** The lbl secteur. */
	private JLabel lblSecteur;

	/** The hopital table model. */
	private ColisTableModel hopitalTableModel;

	/** The colis model table. */
	private ColisTableModel colisModelTable;

	/** The remplissage colis table model. */
	private RemplissageColisTableModel remplissageColisTableModel;
	
	/** The remplissage hopital table model. */
	private RemplissageColisTableModel remplissageHopitalTableModel;

	/**
	 * Instantiates a new localisation.
	 *
	 * @param tabPrincipal            the tab principal
	 * @param gestionairePage the gestionaire page
	 */
	public Localisation(JTabbedPane tabPrincipal, JLayeredPane gestionairePage) {

		this.initPage(tabPrincipal, gestionairePage);

	}

	/**
	 * Inits the page.
	 *
	 * @param tabPrincipal            the tab principal
	 * @param gestionairePage the gestionaire page
	 */
	private void initPage(JTabbedPane tabPrincipal, JLayeredPane gestionairePage) {

		hopitalTableModel = new ColisTableModel();

		tableLocalconfigHopitalTop = new JTable(hopitalTableModel);
		tableLocalconfigHopitalTop.setBounds(50, 357, 750, 223);

		scrollPaneconfigHopitalTop = new JScrollPane();
		scrollPaneconfigHopitalTop.setBounds(50, 73, 750, 223);
		scrollPaneconfigHopitalTop.add(tableLocalconfigHopitalTop);
		scrollPaneconfigHopitalTop.setViewportView(tableLocalconfigHopitalTop);

		tableLocalconfigHopitalBot = new JTable(remplissageHopitalTableModel);
		tableLocalconfigHopitalBot.setName("Colis");
		tableLocalconfigHopitalBot.setBounds(50, 72, 750, 223);

		scrollPaneconfigHopitalLocalBot = new JScrollPane();
		scrollPaneconfigHopitalLocalBot.setBounds(50, 357, 750, 223);
		scrollPaneconfigHopitalLocalBot.add(tableLocalconfigHopitalBot);
		scrollPaneconfigHopitalLocalBot
				.setViewportView(tableLocalconfigHopitalBot);

		comboSelectconfigHopitalLocal = new JComboBox<Object>();
		comboSelectconfigHopitalLocal.setBounds(121, 13, 136, 22);

		btnModifierconfigHopital = new JButton(
				"Modifier la configuration hopital");
		btnModifierconfigHopital.setBounds(340, 310, 240, 25);
		btnModifierconfigHopital.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!(tableLocalconfigHopitalTop.getSelectedRow() == -1))
					Remplissage.CreationJpanelRemplissageConfigHopital(
							gestionairePage, (int) hopitalTableModel
									.getValueAt(tableLocalconfigHopitalTop
											.getSelectedRow(),
											tableLocalconfigHopitalTop
													.getColumnCount()));

			}

		});

		comboBoxsecteur = new JComboBox<Object>();
		comboBoxsecteur.setName("Secteur");
		comboBoxsecteur.setBounds(75, 29, 160, 22);
		colisModelTable = new ColisTableModel();
		tableLocalColisTop = new JTable(colisModelTable);

		remplissageHopitalTableModel = new RemplissageColisTableModel();
		remplissageColisTableModel = new RemplissageColisTableModel();
		tableLocalconfigHopitalTop = new JTable(hopitalTableModel);
		tableLocalColisBot = new JTable(remplissageColisTableModel);

		boutonEditerLocalisation = new JButton("Modifier le contenu du colis");
		boutonEditerLocalisation.setBounds(340, 310, 240, 25);
		boutonEditerLocalisation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!(tableLocalColisTop.getSelectedRow() == -1))
					Remplissage.CreationJpanelRemplissageColis(gestionairePage,
							(int) colisModelTable.getValueAt(
									tableLocalColisTop.getSelectedRow(),
									colisModelTable.getColumnCount()));

			}

		});

		scrollPaneLocalColisTop = new JScrollPane();
		scrollPaneLocalColisTop.setBounds(50, 73, 750, 223);
		scrollPaneLocalColisTop.add(tableLocalColisTop);
		scrollPaneLocalColisTop.setViewportView(tableLocalColisTop);

		scrollPaneLocalColisBot = new JScrollPane();
		scrollPaneLocalColisBot.setBounds(50, 357, 750, 223);
		scrollPaneLocalColisBot.add(tableLocalColisBot);
		scrollPaneLocalColisBot.setViewportView(tableLocalColisBot);

		lblSecteur = new JLabel("Secteur :");
		lblSecteur.setBounds(12, 32, 56, 16);

		configHopitalLocalisation = new JPanel();
		configHopitalLocalisation.setLayout(null);
		configHopitalLocalisation.add(comboSelectconfigHopitalLocal);
		configHopitalLocalisation.add(btnModifierconfigHopital);
		configHopitalLocalisation.add(scrollPaneconfigHopitalLocalBot);
		configHopitalLocalisation.add(scrollPaneconfigHopitalTop);

		ColisLocalisationPanel = new JPanel();
		ColisLocalisationPanel.setLayout(null);
		ColisLocalisationPanel.add(boutonEditerLocalisation);
		ColisLocalisationPanel.add(scrollPaneLocalColisBot);
		ColisLocalisationPanel.add(lblSecteur);
		ColisLocalisationPanel.add(scrollPaneLocalColisTop);
		ColisLocalisationPanel.add(comboBoxsecteur);

		onglet = new JTabbedPane(JTabbedPane.TOP);
		onglet.addTab("Colis", null, ColisLocalisationPanel, null);
		onglet.addTab("Configuration hopital", null, configHopitalLocalisation,
				null);
		onglet.setBorder(null);
		onglet.setAlignmentY(Component.TOP_ALIGNMENT);
		onglet.setAlignmentX(Component.LEFT_ALIGNMENT);

		comboBoxsecteur.setModel(ComboBoxBuilder
				.setSecteurModel(tableLocalColisTop));
		comboSelectconfigHopitalLocal.setModel(ComboBoxBuilder
				.setConfigModel(tableLocalconfigHopitalTop));

		onglet.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseExited(MouseEvent e) {
				int indexSelected = 0;
				int rowIndexSelected = 0;
				// On stock l'item selectionné dans la combo box
				if (comboBoxsecteur.getSelectedItem() != null) {
					indexSelected = comboBoxsecteur.getSelectedIndex();
				}

				// On stock la row selectionné dans la JTable
				if (tableLocalColisTop.getSelectedRow() != -1) {
					rowIndexSelected = tableLocalColisTop.getSelectedRow();
				}

				// Mise a jour des comboBox
				comboBoxsecteur.setModel(ComboBoxBuilder
						.setSecteurModel(tableLocalColisTop));
				comboBoxsecteur.repaint();

				// Mise a jour de la JTable du Haut
				if (comboBoxsecteur.getItemCount() != 0) {
					tableLocalColisTop.setModel(new ColisTableModel("secteur",
							(int) comboBoxsecteur.getSelectedItem()));
					comboBoxsecteur.setSelectedIndex(indexSelected);
				}

				tableLocalColisTop.getSelectionModel().setSelectionInterval(
						rowIndexSelected, rowIndexSelected);
			}
		});

		tableLocalColisTop.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				remplissageColisTableModel
						.refreshModel(
								false,
								(int) tableLocalColisTop.getModel().getValueAt(
										tableLocalColisTop.getSelectedRow(),
										tableLocalColisTop.getModel()
												.getColumnCount()));

			}
		});

		/**
		 * Mise à jour du modèle de table Colis lors de la mise a jour de la
		 * comboBox
		 */
		comboBoxsecteur.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				tableLocalColisTop.setModel(new ColisTableModel("secteur",
						(int) comboBoxsecteur.getSelectedItem()));
				tableLocalColisTop.getSelectionModel().clearSelection();
				colisModelTable.refreshModel();
				remplissageColisTableModel
						.refreshModel(
								false,
								(int) tableLocalColisTop.getModel().getValueAt(
										0,
										tableLocalColisTop.getModel()
												.getColumnCount()));
			}
		});

		/*
		 * Work In Progress ! configHopitalLocalisation.addMouseListener(new
		 * MouseAdapter() {
		 * 
		 * @Override public void mouseClicked(MouseEvent e) { int indexSelected
		 * = 0; int rowIndexSelected = 0;
		 * 
		 * if (comboSelectconfigHopitalLocal.getSelectedItem() != null) {
		 * indexSelected = (int) comboSelectconfigHopitalLocal
		 * .getSelectedIndex(); }
		 * 
		 * comboSelectconfigHopitalLocal.setModel(ComboBoxBuilder
		 * .setConfigModel(tableLocalconfigHopitalTop));
		 * comboSelectconfigHopitalLocal.repaint();
		 * 
		 * if (comboSelectconfigHopitalLocal.getItemCount() != 0) {
		 * tableLocalconfigHopitalTop.setModel(new ColisTableModel( "configs",
		 * (int) comboSelectconfigHopitalLocal .getSelectedItem()));
		 * comboSelectconfigHopitalLocal .setSelectedIndex(indexSelected); }
		 * 
		 * tableLocalconfigHopitalTop.getSelectionModel()
		 * .setSelectionInterval(rowIndexSelected, rowIndexSelected); }
		 * 
		 * });
		 * 
		 * comboSelectconfigHopitalLocal.addItemListener(new ItemListener() {
		 * 
		 * @Override public void itemStateChanged(ItemEvent e) {
		 * tableLocalconfigHopitalTop.setModel(new ColisTableModel( "configs",
		 * (String) comboSelectconfigHopitalLocal .getSelectedItem()));
		 * tableLocalconfigHopitalTop.getSelectionModel().clearSelection();
		 * hopitalTableModel.refreshModel();
		 * remplissageHopitalTableModel.refreshModel( false, (int)
		 * tableLocalconfigHopitalTop.getModel().getValueAt( 0,
		 * tableLocalconfigHopitalTop.getModel() .getColumnCount())); } });
		 * 
		 * tableLocalconfigHopitalTop.addMouseListener(new MouseAdapter() {
		 * 
		 * @Override public void mouseClicked(MouseEvent e) {
		 * remplissageHopitalTableModel.refreshModel( false, (int)
		 * tableLocalconfigHopitalTop.getModel().getValueAt(
		 * tableLocalconfigHopitalTop.getSelectedRow(),
		 * tableLocalconfigHopitalTop.getModel() .getColumnCount()));
		 * 
		 * } });
		 */

		tabPrincipal.addTab("Localisation", null, onglet, null);

	}
}
