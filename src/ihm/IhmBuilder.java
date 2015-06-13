/**
 * 
 */
package ihm;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 * @author Martin
 *
 */
public class IhmBuilder {

	public static String[] materielColName = { "D�nomination", "Observations",
			"Quantit�" };

	public static String[] medicColName = { "D�nomination", "Principe Actif",
			"Dosage", "DLU", "Quantit�", "Lot", "Classe Th�rapeutique",
			"Dotation U7" };

	public static String[] colisColumnName = { "Num�ro Colis", "D�signation",
			"Nature Colis", "Affectataire", "Module", "Optionnel", "Secteur",
			"Dimension", "Volume", "Poids", "Valeur", "Iata", "Projection",
			"Observation" };

	private static final Map<String, String[]> mapTableToColumn = createMap();

	private static Map<String, String[]> createMap() {
		Map<String, String[]> result = new HashMap<String, String[]>();
		result.put("Materiel", materielColName);
		result.put("M�dicaments", medicColName);
		result.put("Colis", colisColumnName);
		return Collections.unmodifiableMap(result);
	}

	/**
	 * 
	 * @param tableColumnModel
	 *            mod�le de colonnes pour la table en question
	 * @param tableParam
	 *            nom de la table a initialiser
	 */

	public static TableColumnModel BuildTableColumn(
			TableColumnModel tableColumnModel, String tableParam) {

		for (String col : mapTableToColumn.get(tableParam)) {
			TableColumn tableColumn = new TableColumn();
			tableColumn.setHeaderValue(col);
			tableColumnModel.addColumn(tableColumn);
		}

		return tableColumnModel;

	}
}
