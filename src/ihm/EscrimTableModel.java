package ihm;

import javax.swing.table.DefaultTableModel;

/**
 * Classe de gestion du modèle de table
 * 
 * @author Martin
 *
 */

public abstract class EscrimTableModel extends DefaultTableModel {

	private boolean lockCell;

	public boolean isLockCell() {
		return lockCell;
	}

	public void setLockCell(boolean lockCell) {
		this.lockCell = lockCell;
	}

	public static String[] materielColName = { "", "Dénomination",
			"Observations", "Quantité", "uid" };

	public static String[] medicColName = { "", "Dénomination",
			"Principe Actif", "Dosage", "DLU", "Quantité", "Lot",
			"Classe Thérapeutique", "Dotation U7", "uid" };

	public static String[] colisColumnName = { "", "Numéro Colis",
			"Désignation", "Nature Colis", "Affectataire", "Optionnel",
			"Secteur", "Dimension", "Volume", "Poids", "Valeur", "Iata",
			"Projection", "Observation", "uid" };

	public static String[] AvionColumnName = { "", "Nom", "Compartiments",
			"uid" };

	public void isRowEditable(boolean rowEdit) {
		for (int i = 0; i < this.getRowCount(); i++) {
			if (i == 0) {
				this.setLockCell(rowEdit);
			} else {
				this.setLockCell(false);
			}
			for (int j = 0; j < this.getColumnCount(); j++) {

				System.out.println(i + " - " + j + "="
						+ this.isCellEditable(i, j));

			}
		}
	}

	public void unlockFirstRow(boolean locker) {
		System.out.println("unlock");
		setLockCell(locker);

		for (int j = 0; j < this.getColumnCount(); j++) {
			this.isCellEditable(0, j);

		}

	}

	public void lockAllRow(boolean locker) {

		this.setLockCell(locker);
		for (int i = 1; i < this.getRowCount(); i++) {
			for (int j = 0; j < this.getColumnCount(); j++) {

				this.isCellEditable(i, j);
			}
		}
	}

	@Override
	public boolean isCellEditable(int row, int column) {

		if (isLockCell() && row == 0) {
			return super.isCellEditable(row, column);

		} else {
			return false;

		}
	}

	public boolean testRowValue(int selectedRow) {
		try {
			for (int i = 1; i < this.getColumnCount() - 1; i++) {
				if (this.getValueAt(selectedRow, i) == ""
						|| this.getValueAt(selectedRow, i) == null) {
					return false;
				}
			}
			return true;
		} catch (Exception e) {
			return false;
		}

	}

}
