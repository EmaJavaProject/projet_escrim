package ihm;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 * The Class Localisation.
 */
public class Localisation {

	/** The table local contenu top. */
	private  JTable tableLocalContenuTop;
	
	/** The table local contenu bot. */
	private  JTable tableLocalContenuBot;
	
	/** The table local conteneur top. */
	private  JTable tableLocalConteneurTop;
	
	/** The table local conteneur bot. */
	private JTable tableLocalConteneurBot;
	
	/** The filtre recherche. */
	private JTextField filtreRecherche;
	
	/** The onglet. */
	private JTabbedPane onglet;
	
	/** The scroll pane contenu. */
	private JScrollPane scrollPaneContenu;
	
	/** The contenu localisation. */
	private JPanel contenuLocalisation;
	
	/** The scroll pane contenu local bot. */
	private JScrollPane scrollPaneContenuLocalBot;
	
	/** The combo select contenu local. */
	private JComboBox<String> comboSelectContenuLocal;
	
	/** The btn modifier contenu. */
	private JButton btnModifierContenu;
	
	/** The conteneur localisation. */
	private JPanel conteneurLocalisation;
	
	/** The bouton editer localisation. */
	private JButton boutonEditerLocalisation;
	
	/** The scroll pane conteneur. */
	private JScrollPane scrollPaneConteneur;
	
	/** The secteur. */
	private JComboBox<?> secteur;
	
	/** The scroll pane local conteneur top. */
	private JScrollPane scrollPaneLocalConteneurTop;
	
	/** The scroll pane local conteneur bot. */
	private JScrollPane scrollPaneLocalConteneurBot;
	
	/** The lbl secteur. */
	private JLabel lblSecteur;

	/**
	 * Instantiates a new localisation.
	 *
	 * @param tabPrincipal the tab principal
	 */
	public Localisation(JTabbedPane tabPrincipal) {

		this.initPage(tabPrincipal);

	}

	/**
	 * Inits the page.
	 *
	 * @param tabPrincipal the tab principal
	 */
	private void initPage(JTabbedPane tabPrincipal) {

		scrollPaneContenu = new JScrollPane();
		scrollPaneContenu.setBounds(52, 73, 706, 212);

		tableLocalContenuTop = new JTable();
		tableLocalContenuTop.setBounds(62, 287, 706, 223);

		filtreRecherche = new JTextField();
		filtreRecherche.setBounds(504, 13, 177, 22);

		filtreRecherche.setColumns(10);

		tableLocalContenuBot = new JTable();
		tableLocalContenuBot.setName("Caisse");
		tableLocalContenuBot.setBounds(52, 324, 706, 223); // todo
		scrollPaneContenuLocalBot = new JScrollPane();
		scrollPaneContenuLocalBot.setBounds(52, 324, 706, 223);
		scrollPaneContenuLocalBot.add(tableLocalContenuBot);
		scrollPaneContenuLocalBot.setViewportView(tableLocalContenuBot);

		comboSelectContenuLocal = new JComboBox<String>();

		// Mise a jour de la JTable en fonction de la combobox

		comboSelectContenuLocal.addItem("Materiel");
		comboSelectContenuLocal.addItem("M�dicaments");
		comboSelectContenuLocal.setBounds(121, 13, 136, 22);

		filtreRecherche = new JTextField();
		filtreRecherche.setBounds(504, 13, 177, 22);
		filtreRecherche.setColumns(10);

		btnModifierContenu = new JButton("Modifier contenu");
		btnModifierContenu.setBounds(121, 612, 136, 25);

		boutonEditerLocalisation = new JButton("Editer localisation");
		boutonEditerLocalisation.setBounds(340, 279, 149, 25);

		// LOCAL CONTENEUR

		boutonEditerLocalisation = new JButton("Editer localisation");
		boutonEditerLocalisation.setBounds(340, 279, 149, 25);

		scrollPaneContenu.add(tableLocalContenuTop);
		scrollPaneContenu.setViewportView(tableLocalContenuTop);

		secteur = new JComboBox<Object>();
		secteur.setName("");
		secteur.setBounds(75, 29, 160, 22);

		scrollPaneLocalConteneurTop = new JScrollPane();
		scrollPaneLocalConteneurTop.setBounds(12, 72, 899, 194);

		scrollPaneLocalConteneurBot = new JScrollPane();
		scrollPaneLocalConteneurBot.setBounds(12, 357, 899, 194);

		lblSecteur = new JLabel("Secteur :");
		lblSecteur.setBounds(12, 32, 56, 16);

		scrollPaneConteneur = new JScrollPane();
		scrollPaneConteneur.setBounds(12, 56, 800, 486);
		scrollPaneConteneur.setViewportView(tableLocalConteneurTop);
		scrollPaneConteneur.setViewportView(tableLocalConteneurBot);

		contenuLocalisation = new JPanel();
		contenuLocalisation.setLayout(null);
		contenuLocalisation.add(filtreRecherche);
		contenuLocalisation.add(comboSelectContenuLocal);
		contenuLocalisation.add(scrollPaneContenuLocalBot);
		contenuLocalisation.add(scrollPaneContenu);

		conteneurLocalisation = new JPanel();
		conteneurLocalisation.setLayout(null);
		conteneurLocalisation.add(boutonEditerLocalisation);
		conteneurLocalisation.add(scrollPaneLocalConteneurBot);
		conteneurLocalisation.add(lblSecteur);
		conteneurLocalisation.add(scrollPaneLocalConteneurTop);
		conteneurLocalisation.add(secteur);

		onglet = new JTabbedPane(JTabbedPane.TOP);
		onglet.addTab("Contenu", null, contenuLocalisation, null);
		onglet.addTab("Conteneur", null, conteneurLocalisation, null);
		onglet.setBorder(null);
		onglet.setAlignmentY(Component.TOP_ALIGNMENT);
		onglet.setAlignmentX(Component.LEFT_ALIGNMENT);
		tabPrincipal.addTab("Localisation", null, onglet, null);

	}
}
