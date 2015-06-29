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

import escrim.manager.MaterielManager;
import escrim.model.table.ConfigurationHopitalTableModel;
import escrim.model.table.RemplissageColisTableModel;
import escrim.model.table.TransportTableModel;

public class Remplissage {

	private static JTable tableContenuTop;
	private static JTable tableContenuBot;
	private static JTextField txtConteneur;
	private static JPanel contenueRemplissage;
	private static JScrollPane scrollPaneContenuBot;
	private static JScrollPane scrollPaneContenuTop;
	private static JButton btnSauvegarderEtQuitter;
	private static JButton boutonAjouterContenu;
	private static JButton boutonSupprimerContenu;

	// ------------------------------------------COLIS--------------------------------------------------//

	public static void CréationJpanelRemplissageColis(
			JLayeredPane gestionairePage, int uidColis) {

		txtConteneur = new JTextField();
		txtConteneur.setHorizontalAlignment(SwingConstants.CENTER);
		txtConteneur.setEnabled(false);
		txtConteneur.setPreferredSize(new Dimension(20, 20));
		txtConteneur.setText("Contenue du colis");
		txtConteneur.setColumns(10);
		txtConteneur.setBounds(50, 20, 260, 25);

		tableContenuTop = new JTable(new RemplissageColisTableModel(true,
				uidColis));
		tableContenuTop.setBounds(62, 100, 706, 223);

		tableContenuBot = new JTable(new RemplissageColisTableModel(false,
				uidColis));
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
					((RemplissageColisTableModel) tableContenuTop.getModel())
							.refreshModel(true);
					((RemplissageColisTableModel) tableContenuBot.getModel())
							.refreshModel(false);
					tableContenuTop.repaint();
					tableContenuBot.repaint();
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

		gestionairePage.add(contenueRemplissage, new Integer(2));
		gestionairePage.revalidate();
		gestionairePage.repaint();

	}

	// ---------------------------------------TRANSPORT-----------------------------------------------------//

	public static void CréationJpanelRemplissageTransport(
			JLayeredPane gestionairePage, TransportTableModel pModelTable,
			int index) {

		txtConteneur = new JTextField();
		txtConteneur.setHorizontalAlignment(SwingConstants.CENTER);
		txtConteneur.setEnabled(false);
		txtConteneur.setPreferredSize(new Dimension(20, 20));
		txtConteneur.setText("Composition Du transport");
		txtConteneur.setColumns(10);
		txtConteneur.setBounds(50, 20, 260, 25);

		tableContenuTop = new JTable();
		tableContenuTop.setBounds(62, 100, 706, 223);

		tableContenuBot = new JTable();
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

		gestionairePage.add(contenueRemplissage, new Integer(4));
		gestionairePage.revalidate();
		gestionairePage.repaint();

	}

	// -----------------------------------CONFIGURATION
	// HOPITAL----------------------------------------//

	public static void CréationJpanelRemplissageConfigHopital(
			JLayeredPane gestionairePage,
			ConfigurationHopitalTableModel pModelTable, int index) {

		txtConteneur = new JTextField();
		txtConteneur.setHorizontalAlignment(SwingConstants.CENTER);
		txtConteneur.setEnabled(false);
		txtConteneur.setPreferredSize(new Dimension(20, 20));
		txtConteneur.setText("Contenue de la configuration d'hopital");
		txtConteneur.setColumns(10);
		txtConteneur.setBounds(50, 20, 260, 25);

		tableContenuTop = new JTable();
		tableContenuTop.setBounds(62, 100, 706, 223);

		tableContenuBot = new JTable();
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

		gestionairePage.add(contenueRemplissage, new Integer(4));
		gestionairePage.revalidate();
		gestionairePage.repaint();

	}
}
