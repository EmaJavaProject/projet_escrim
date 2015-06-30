package ihm;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import escrim.model.table.TypeColisTableModel;

/**
 * The Class CreationTypeColis.
 */
public class CreationTypeColis {

	/** The jpanel type colis. */
	private static JPanel jpanelTypeColis;
	
	/** The table type colis. */
	private static JTable tableTypeColis;
	
	/** The scroll panel type colis. */
	private static JScrollPane scrollPanelTypeColis;
	
	/** The txt type colis. */
	private static JTextField txtTypeColis;
	
	/** The type colis table model. */
	private static TypeColisTableModel typeColisTableModel;
	
	/** The bouton ajouter type colis. */
	private static JButton boutonAjouterTypeColis;
	
	/** The bouton quitter. */
	private static JButton boutonQuitter;
	
	/** The bouton supprimer type colis. */
	private static JButton boutonSupprimerTypeColis;
	
	/** The bouton modifier type colis. */
	private static JButton boutonModifierTypeColis;
	
	/** The bouton valider type colis. */
	private static JButton boutonValiderTypeColis;
	
	/** The bouton annuler type colis. */
	private static JButton boutonAnnulerTypeColis;
	
	/** The tab principal. */
	private static JTabbedPane tabPrincipal;

	/**
	 * Création jpanel type colis.
	 *
	 * @param pPanelPrincipal the panel principal
	 * @return the action listener
	 */
	public static ActionListener CréationJpanelTypeColis(
			JLayeredPane pPanelPrincipal) {

		ActionListener action = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (pPanelPrincipal != null) {

					// -------------------------pour éviter de créer plusieur
					// Jpanel-----------//////////
					for (Component composantPanelPrincipal : pPanelPrincipal
							.getComponents()) {
						for (Component composantsPanelPrincipal : composantPanelPrincipal
								.getParent().getComponents()) {

							if (composantsPanelPrincipal != null
									&& composantsPanelPrincipal.getName() != null
									&& composantsPanelPrincipal
									.getName()
									.equals("Création de type de colis")|| composantsPanelPrincipal
											.getName()
											.equals("Gestion configuration d'hopital")|| composantsPanelPrincipal.getName()
											.equals("Gestion Transport")
									|| composantsPanelPrincipal.getName()
											.equals("Remplissage")) {
								return;
							}
						}
					}
				}
				typeColisTableModel = new TypeColisTableModel();
				tableTypeColis = new JTable(typeColisTableModel);
				tableTypeColis.setName("Table Colis");
				tableTypeColis.setBounds(12, 72, 899, 800);
				boutonQuitter = new JButton("Quitter");
				boutonQuitter.setBounds(800, 13, 97, 25);
				boutonQuitter.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						for (Component composant : pPanelPrincipal
								.getComponents()) {
							if (composant.getName().equals(
									"Création de type de colis"))
								pPanelPrincipal.remove(composant);
						}
						pPanelPrincipal.repaint();

					}
				});

				boutonAjouterTypeColis = new JButton("+");
				boutonAjouterTypeColis.setBounds(12, 589, 97, 25);

				boutonSupprimerTypeColis = new JButton("-");
				boutonSupprimerTypeColis.setBounds(121, 589, 97, 25);

				boutonModifierTypeColis = new JButton("Editer");
				boutonModifierTypeColis.setBounds(230, 589, 97, 25);

				boutonValiderTypeColis = new JButton("Valider");
				boutonValiderTypeColis.setBounds(340, 589, 97, 25);

				boutonAnnulerTypeColis = new JButton("Annuler");
				boutonAnnulerTypeColis.setBounds(450, 589, 97, 25);

				boutonValiderTypeColis.setEnabled(false);
				boutonAnnulerTypeColis.setEnabled(false);

				boutonSupprimerTypeColis
						.addActionListener(new ActionListener() {
							@SuppressWarnings("deprecation")
							public void actionPerformed(ActionEvent arg0) {
								if (!(tableTypeColis.getSelectedRow() == -1)) {
									typeColisTableModel
											.removeElement(tableTypeColis
													.getSelectedRow());
								}
							}

						});

				boutonAjouterTypeColis.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						disableTypeColisButton(true);
						typeColisTableModel.addElement();
						tableTypeColis.setRowSelectionInterval(
								tableTypeColis.getRowCount() - 1,
								tableTypeColis.getRowCount() - 1);

					}

				});

				boutonModifierTypeColis.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						disableTypeColisButton(true);
						typeColisTableModel.updateElement(tableTypeColis
								.getSelectedRow());

					}

				});

				boutonValiderTypeColis.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (tableTypeColis.isEditing()) {
							tableTypeColis.getCellEditor().stopCellEditing();
						}
						disableTypeColisButton(false);
						typeColisTableModel.persistData(
								tableTypeColis.getSelectedRow(), true);
					}

				});

				boutonAnnulerTypeColis.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						disableTypeColisButton(false);
						typeColisTableModel.persistData(
								tableTypeColis.getSelectedRow(), false);

					}

				});

				scrollPanelTypeColis = new JScrollPane();
				scrollPanelTypeColis.setName("Scroll TypeColis");
				scrollPanelTypeColis.setViewportView(tableTypeColis);
				scrollPanelTypeColis.setBounds(12, 56, 950, 486);

				txtTypeColis = new JTextField();
				txtTypeColis.setHorizontalAlignment(SwingConstants.CENTER);
				txtTypeColis.setEnabled(false);
				txtTypeColis.setPreferredSize(new Dimension(20, 20));
				txtTypeColis.setText("Gestion Type de Colis");
				txtTypeColis.setColumns(10);
				txtTypeColis.setBounds(44, 11, 260, 25);

				// ---------------------------------------------création et
				// ajout des Jpanel dans le
				// Tabprincipal---------------------------------------------------//


				jpanelTypeColis = new JPanel();
				jpanelTypeColis.add(boutonModifierTypeColis);
				jpanelTypeColis.setBounds(0, 0, 1017, 706);
				jpanelTypeColis.setName("Création de type de colis");
				jpanelTypeColis.add(txtTypeColis);
				jpanelTypeColis.add(scrollPanelTypeColis);
				jpanelTypeColis.setLayout(null);
				jpanelTypeColis.add(boutonQuitter);
				jpanelTypeColis.add(boutonModifierTypeColis);
				jpanelTypeColis.add(boutonSupprimerTypeColis);
				jpanelTypeColis.add(boutonAjouterTypeColis);
				jpanelTypeColis.add(boutonValiderTypeColis);
				jpanelTypeColis.add(boutonAnnulerTypeColis);


				pPanelPrincipal.add(jpanelTypeColis, new Integer(3));
				pPanelPrincipal.revalidate();

			}
		};

		return action;

	}

	/**
	 * Disable type colis button.
	 *
	 * @param disable the disable
	 */
	private static void disableTypeColisButton(boolean disable) {
		if (disable) {
			boutonAjouterTypeColis.setEnabled(false);
			boutonSupprimerTypeColis.setEnabled(false);
			boutonModifierTypeColis.setEnabled(false);
			boutonValiderTypeColis.setEnabled(true);
			boutonAnnulerTypeColis.setEnabled(true);
		} else {
			boutonAjouterTypeColis.setEnabled(true);
			boutonSupprimerTypeColis.setEnabled(true);
			boutonModifierTypeColis.setEnabled(true);
			boutonValiderTypeColis.setEnabled(false);
			boutonAnnulerTypeColis.setEnabled(false);
		}
	}
}
