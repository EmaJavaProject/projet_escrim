package escrim.model.table;

import javax.swing.table.DefaultTableModel;

/**
 * Classe de gestion du modèle de table.
 *
 * @author Martin
 */

public abstract class EscrimTableModel extends DefaultTableModel {

	/** The edition. */
	protected boolean edition = false;
	
	/** The addition. */
	protected boolean addition = false;
	
	/** The remove. */
	protected boolean remove = false;
	
	/** The edited row. */
	protected int editedRow;

	/**
	 * Gets the edited row.
	 *
	 * @return the edited row
	 */
	protected int getEditedRow() {
		return editedRow;
	}

	/**
	 * Sets the edited row.
	 *
	 * @param editedRow the new edited row
	 */
	protected void setEditedRow(int editedRow) {
		this.editedRow = editedRow;
	}

	/**
	 * Checks if is edition.
	 *
	 * @return true, if is edition
	 */
	protected boolean isEdition() {
		return edition;
	}

	/**
	 * Sets the edition.
	 *
	 * @param edition the new edition
	 */
	protected void setEdition(boolean edition) {
		this.edition = edition;
	}

	/**
	 * Checks if is addition.
	 *
	 * @return true, if is addition
	 */
	protected boolean isAddition() {
		return addition;
	}

	/**
	 * Sets the addition.
	 *
	 * @param addition the new addition
	 */
	protected void setAddition(boolean addition) {
		this.addition = addition;
	}

	/**
	 * Checks if is removes the.
	 *
	 * @return true, if is removes the
	 */
	protected boolean isRemove() {
		return remove;
	}

	/**
	 * Sets the removes the.
	 *
	 * @param remove the new removes the
	 */
	protected void setRemove(boolean remove) {
		this.remove = remove;
	}

	/** The medic col name. */
	public static String[] medicColName = { "", "Dénomination",
			"Principe Actif", "Dosage", "DLU", "Quantité", "Lot",
			"Classe Thérapeutique", "Dotation U7", "uid" };

	/** The colis column name. */
	public static String[] colisColumnName = { "", "Numéro Colis",
			"Désignation", "Nature Colis", "Affectataire", "Optionnel",
			"Secteur", "Dimension", "Volume", "Poids", "Valeur", "Iata",
			"Projection", "Observation", "uid" };

	/** The caisse. */
	public static String[] caisse = { "", "Numéro Caisse", "Secteur",
			"Dimension", "Observation" };

	/** The Avion column name. */
	public static String[] AvionColumnName = { "", "Nom", "Compartiments",
			"uid" };



	/* (non-Javadoc)
	 * @see javax.swing.table.DefaultTableModel#isCellEditable(int, int)
	 */
	@Override
	public boolean isCellEditable(int row, int column) {

		if (isAddition() && row == getRowCount() - 1) {
			return true;
		} else if (isEdition() && row == editedRow) {
			return true;
		} else {
			return false;

		}
	}

}
