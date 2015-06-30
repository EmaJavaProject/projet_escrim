package ihm;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JTextField;

import escrim.manager.ColisManager;
import escrim.metiers.Colis;
import escrim.model.table.ColisTableModel;
import escrim.model.table.ConfigurationHopitalTableModel;
import escrim.model.table.RemplissageColisTableModel;

/**
 * The Class Localisation.
 */
public class Localisation {

	/** The table local configHopital top. */
	private  JTable tableLocalconfigHopitalTop;
	
	/** The table local configHopital bot. */
	private  JTable tableLocalconfigHopitalBot;
	
	/** The table local Colis top. */
	private  JTable tableLocalColisTop;
	
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
	private JComboBox<String> comboSelectconfigHopitalLocal;
	
	/** The btn modifier configHopital. */
	private JButton btnModifierconfigHopital;
	
	/** The Colis localisation. */
	private JPanel ColisLocalisation;
	
	/** The bouton editer localisation. */
	private JButton boutonEditerLocalisation;
	
	/** The scroll pane Colis. */
	private JScrollPane scrollPaneColis;
	
	/** The secteur. */
	private JComboBox<?> secteur;
	
	/** The scroll pane local Colis top. */
	private JScrollPane scrollPaneLocalColisTop;
	
	/** The scroll pane local Colis bot. */
	private JScrollPane scrollPaneLocalColisBot;
	
	/** The lbl secteur. */
	private JLabel lblSecteur;
	
	private ColisTableModel hopitalTableModel;
	
	private ColisTableModel colisModelTable; 
	
	private RemplissageColisTableModel remplissageColisTableModel;

	/**
	 * Instantiates a new localisation.
	 *
	 * @param tabPrincipal the tab principal
	 * @param gestionairePage 
	 */
	public Localisation(JTabbedPane tabPrincipal, JLayeredPane gestionairePage) {

		this.initPage(tabPrincipal,gestionairePage);

	}

	/**
	 * Inits the page.
	 *
	 * @param tabPrincipal the tab principal
	 * @param gestionairePage 
	 */
	private void initPage(JTabbedPane tabPrincipal, JLayeredPane gestionairePage) {

		
		hopitalTableModel = new ColisTableModel();
		

		

		tableLocalconfigHopitalTop = new JTable(hopitalTableModel);
		tableLocalconfigHopitalTop.setBounds(50, 357, 750, 223);
		tableLocalconfigHopitalTop.removeColumn(tableLocalconfigHopitalTop.getColumn("uid"));

		scrollPaneconfigHopitalTop = new JScrollPane();
		scrollPaneconfigHopitalTop.setBounds(50, 73, 750, 223);
		scrollPaneconfigHopitalTop.add(tableLocalconfigHopitalTop);
		scrollPaneconfigHopitalTop.setViewportView(tableLocalconfigHopitalTop);


		tableLocalconfigHopitalBot = new JTable();
		tableLocalconfigHopitalBot.setName("Colis");
		tableLocalconfigHopitalBot.setBounds(50, 72, 750, 223);
		
		scrollPaneconfigHopitalLocalBot = new JScrollPane();
		scrollPaneconfigHopitalLocalBot.setBounds(50, 357, 750, 223);
		scrollPaneconfigHopitalLocalBot.add(tableLocalconfigHopitalBot);
		scrollPaneconfigHopitalLocalBot.setViewportView(tableLocalconfigHopitalBot);

		comboSelectconfigHopitalLocal = new JComboBox<String>();
		comboSelectconfigHopitalLocal.setBounds(121, 13, 136, 22);

		btnModifierconfigHopital = new JButton("Modifier la configuration hopital");
		btnModifierconfigHopital.setBounds(340, 310, 240, 25);
		btnModifierconfigHopital.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!(tableLocalconfigHopitalTop.getSelectedRow() == -1))
					Remplissage
							.CreationJpanelRemplissageConfigHopital(
									gestionairePage,
									(int) hopitalTableModel.getValueAt(
											tableLocalconfigHopitalTop.getSelectedRow(),
											tableLocalconfigHopitalTop.getColumnCount()));

			}

		});


		secteur = new JComboBox<Object>();
		secteur.setName("");
		secteur.setBounds(75, 29, 160, 22);
		
		colisModelTable = new ColisTableModel();
		
		tableLocalColisTop = new JTable(colisModelTable);
		tableLocalColisTop.removeColumn(tableLocalColisTop.getColumn("uid"));
		
		tableLocalColisBot = new JTable();
		
		boutonEditerLocalisation = new JButton("Modifier le contenue du colis");
		boutonEditerLocalisation.setBounds(340, 310, 240, 25);
		boutonEditerLocalisation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!(tableLocalColisTop.getSelectedRow() == -1))
					Remplissage
							.CreationJpanelRemplissageConfigHopital(
									gestionairePage,
									(int) colisModelTable.getValueAt(
											tableLocalColisTop.getSelectedRow(),
											tableLocalColisTop.getColumnCount()));

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

		ColisLocalisation = new JPanel();
		ColisLocalisation.setLayout(null);
		ColisLocalisation.add(boutonEditerLocalisation);
		ColisLocalisation.add(scrollPaneLocalColisBot);
		ColisLocalisation.add(lblSecteur);
		ColisLocalisation.add(scrollPaneLocalColisTop);
		ColisLocalisation.add(secteur);

		onglet = new JTabbedPane(JTabbedPane.TOP);
		onglet.addTab("Colis", null, ColisLocalisation, null);
		onglet.addTab("Configuration hopital", null, configHopitalLocalisation, null);
		onglet.setBorder(null);
		onglet.setAlignmentY(Component.TOP_ALIGNMENT);
		onglet.setAlignmentX(Component.LEFT_ALIGNMENT);
		tabPrincipal.addTab("Localisation", null, onglet, null);

	}
}
	