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

	public static String[] materielColName = { "Dénomination", "Observations",
			"Quantité" };

	public static String[] medicColName = { "Dénomination", "Principe Actif",
			"Dosage", "DLU", "Quantité", "Lot", "Classe Thérapeutique",
			"Dotation U7" };

	public static String[] colisColumnName = { "Numéro Colis", "Désignation",
			"Nature Colis", "Affectataire", "Module", "Optionnel", "Secteur",
			"Dimension", "Volume", "Poids", "Valeur", "Iata", "Projection",
			"Observation" };

	private static final Map<String, String[]> mapTableToColumn = createMap();

	private static Map<String, String[]> createMap() {
		Map<String, String[]> result = new HashMap<String, String[]>();
		result.put("Materiel", materielColName);
		result.put("Médicaments", medicColName);
		result.put("Colis", colisColumnName);
		return Collections.unmodifiableMap(result);
	}

	/**
	 * 
	 * @param tableColumnModel
	 *            modèle de colonnes pour la table en question
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
