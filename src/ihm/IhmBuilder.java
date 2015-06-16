/**
 * 
 */
package ihm;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.swing.table.DefaultTableModel;

/**
 * @author Martin
 *
 */
public class IhmBuilder {

	public static String[] materielColName = { "", "D�nomination",
			"Observations", "Quantit�" };

	public static String[] medicColName = { "", "D�nomination",
			"Principe Actif", "Dosage", "DLU", "Quantit�", "Lot",
			"Classe Th�rapeutique", "Dotation U7" };

	public static String[] colisColumnName = { "", "Num�ro Colis",
			"D�signation", "Nature Colis", "Affectataire", 
			"Optionnel", "Secteur", "Dimension", "Volume", "Poids", "Valeur",
			"Iata", "Projection", "Observation" };
	
	public static String[] AvionColumnName = { "", "Nom",
			"Compartiments" };
	
	public static String[] CompartimentColumnName = { "", "Nom",
		"Volume", "Nombre de niveau", "Capacit� en poids" };
	


	private static final Map<String, String[]> mapTableToColumn = createMap();

	private static Map<String, String[]> createMap() {
		Map<String, String[]> result = new HashMap<String, String[]>();
		result.put("Materiel", materielColName);
		result.put("M�dicaments", medicColName);
		result.put("Colis", colisColumnName);
		result.put("Table Transports", AvionColumnName);
		result.put("Table Compartiments", CompartimentColumnName);
		return Collections.unmodifiableMap(result);
	}

	/**
	 * 
	 * @param modelTableContenu
	 *            mod�le de colonnes pour la table en question
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
}
