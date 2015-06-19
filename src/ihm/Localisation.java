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
import javax.swing.ListSelectionModel;

public class Localisation {

	private JTable tableLocalContenuTop;
	private JTable tableLocalContenuBot;
	private JTable tableLocalConteneurTop;
	private JTable tableLocalConteneurBot;
	private JTextField filtreRecherche;
	private JTabbedPane onglet;
	private JScrollPane scrollPaneContenu;
	private JPanel contenuLocalisation;
	private JScrollPane scrollPaneContenuLocalBot;
	private JComboBox<String> comboSelectContenuLocal;
	private JButton btnModifierContenu;
	private JPanel conteneurLocalisation;
	private JButton boutonEditerLocalisation;
	private JScrollPane scrollPaneConteneur;
	private JComboBox<?> secteur;
	private JScrollPane scrollPaneLocalConteneurTop;
	private JScrollPane scrollPaneLocalConteneurBot;
	private JLabel lblSecteur;

	public Localisation(JTabbedPane tabPrincipal) {

		this.initPage(tabPrincipal);

	}

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
		tableLocalContenuBot.getColumn(tableLocalContenuBot.getColumnName(0))
				.setMaxWidth(20);
		tableLocalContenuBot.setBounds(52, 324, 706, 223); // todo
		scrollPaneContenuLocalBot = new JScrollPane();
		scrollPaneContenuLocalBot.setBounds(52, 324, 706, 223);
		scrollPaneContenuLocalBot.add(tableLocalContenuBot);
		scrollPaneContenuLocalBot.setViewportView(tableLocalContenuBot);

		comboSelectContenuLocal = new JComboBox<String>();

		// Mise a jour de la JTable en fonction de la combobox

		comboSelectContenuLocal.addItem("Materiel");
		comboSelectContenuLocal.addItem("Médicaments");
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

		tableLocalConteneurTop.setRowSelectionAllowed(true);
		tableLocalConteneurTop
				.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableLocalConteneurTop.setCellSelectionEnabled(false);

		scrollPaneLocalConteneurBot = new JScrollPane();
		scrollPaneLocalConteneurBot.setBounds(12, 357, 899, 194);

		lblSecteur = new JLabel("Secteur :");
		lblSecteur.setBounds(12, 32, 56, 16);

		tableLocalConteneurBot.setRowSelectionAllowed(true);
		tableLocalConteneurBot
				.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableLocalConteneurBot.setCellSelectionEnabled(false);

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
