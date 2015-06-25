package escrim.model.table;

import javax.swing.table.DefaultTableModel;

/**
 * Classe de gestion du modèle de table
 * 
 * @author Martin
 *
 */

public abstract class EscrimTableModel extends DefaultTableModel {

	protected boolean edition = false;
	protected boolean addition = false;
	protected boolean remove = false;
	protected int editedRow;

	protected int getEditedRow() {
		return editedRow;
	}

	protected void setEditedRow(int editedRow) {
		this.editedRow = editedRow;
	}

	protected boolean isEdition() {
		return edition;
	}

	protected void setEdition(boolean edition) {
		this.edition = edition;
	}

	protected boolean isAddition() {
		return addition;
	}

	protected void setAddition(boolean addition) {
		this.addition = addition;
	}

	protected boolean isRemove() {
		return remove;
	}

	protected void setRemove(boolean remove) {
		this.remove = remove;
	}

	public static String[] medicColName = { "", "Dénomination",
			"Principe Actif", "Dosage", "DLU", "Quantité", "Lot",
			"Classe Thérapeutique", "Dotation U7", "uid" };

	public static String[] colisColumnName = { "", "Numéro Colis",
			"Désignation", "Nature Colis", "Affectataire", "Optionnel",
			"Secteur", "Dimension", "Volume", "Poids", "Valeur", "Iata",
			"Projection", "Observation", "uid" };

	public static String[] caisse = { "", "Numéro Caisse", "Secteur",
			"Dimension", "Observation" };

	public static String[] AvionColumnName = { "", "Nom", "Compartiments",
			"uid" };

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
