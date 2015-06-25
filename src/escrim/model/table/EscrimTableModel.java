package escrim.model.table;

import javax.swing.table.DefaultTableModel;

/**
 * Classe de gestion du mod�le de table
 * 
 * @author Martin
 *
 */

public abstract class EscrimTableModel extends DefaultTableModel {

	protected boolean edition = false;
	protected boolean addition = false;
	protected boolean remove = false;
	protected int editedRow;

	public int getEditedRow() {
		return editedRow;
	}

	public void setEditedRow(int editedRow) {
		this.editedRow = editedRow;
	}

	public boolean isEdition() {
		return edition;
	}

	public void setEdition(boolean edition) {
		this.edition = edition;
	}

	public boolean isAddition() {
		return addition;
	}

	public void setAddition(boolean add) {
		this.addition = addition;
	}

	public boolean isRemove() {
		return remove;
	}

	public void setRemove(boolean remove) {
		this.remove = remove;
	}

	public static String[] materielColName = { "", "D�nomination",
			"Observations", "Quantit�", "uid" };

	public static String[] medicColName = { "", "D�nomination",
			"Principe Actif", "Dosage", "DLU", "Quantit�", "Lot",
			"Classe Th�rapeutique", "Dotation U7", "uid" };

	public static String[] colisColumnName = { "", "Num�ro Colis",
			"D�signation", "Nature Colis", "Affectataire", "Optionnel",
			"Secteur", "Dimension", "Volume", "Poids", "Valeur", "Iata",
			"Projection", "Observation", "uid" };

	public static String[] caisse = { "", "Num�ro Caisse", "Secteur",
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
