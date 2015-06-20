package ihm;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.swing.table.DefaultTableModel;

/**
 * Classe de gestion du modèle de table
 * 
 * @author Martin
 *
 */

public class EscrimModelTable extends DefaultTableModel {

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
	
	public static String[] caisse = { "", "Numéro Caisse",
		"Secteur", "Dimension", "Observation"};

	public static String[] AvionColumnName = { "", "Nom", "Compartiments",
			"uid" };

	public static String[] CompartimentColumnName = { "", "Nom", "Volume",
			"Nombre de niveau", "Capacité en poids", "uid" };

	private static final Map<String, String[]> mapTableToColumn = createMap();

	private static Map<String, String[]> createMap() {
		Map<String, String[]> result = new HashMap<String, String[]>();
		result.put("Materiel", materielColName);
		result.put("Médicaments", medicColName);
		result.put("Colis", colisColumnName);
		result.put("Caisse", caisse);
		result.put("Table Transports", AvionColumnName);
		result.put("Table Compartiments", CompartimentColumnName);
		return Collections.unmodifiableMap(result);
	}

	/**
	 * 
	 * @param modelTableContenu
	 *            modèle de colonnes pour la table en question
	 * @param tableParam
	 *            nom de la table a initialiser
	 */

	public static DefaultTableModel BuildTableColumn(
			DefaultTableModel modelTableContenu, String tableParam) {
		while (modelTableContenu.getRowCount() != 0) {
			modelTableContenu.removeRow(0);
		}

		for (String col : mapTableToColumn.get(tableParam)) {
			modelTableContenu.addColumn(col);
			if (col == "") {
			}
		}

		return modelTableContenu;

	}

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
