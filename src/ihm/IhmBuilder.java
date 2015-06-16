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

	public static String[] materielColName = { "", "Dénomination",
			"Observations", "Quantité" };

	public static String[] medicColName = { "", "Dénomination",
			"Principe Actif", "Dosage", "DLU", "Quantité", "Lot",
			"Classe Thérapeutique", "Dotation U7" };

	public static String[] colisColumnName = { "", "Numéro Colis",
			"Désignation", "Nature Colis", "Affectataire", 
			"Optionnel", "Secteur", "Dimension", "Volume", "Poids", "Valeur",
			"Iata", "Projection", "Observation" };
	
	public static String[] AvionColumnName = { "", "Nom",
			"Compartiments" };
	
	public static String[] CompartimentColumnName = { "", "Nom",
		"Volume", "Nombre de niveau", "Capacité en poids" };
	


	private static final Map<String, String[]> mapTableToColumn = createMap();

	private static Map<String, String[]> createMap() {
		Map<String, String[]> result = new HashMap<String, String[]>();
		result.put("Materiel", materielColName);
		result.put("Médicaments", medicColName);
		result.put("Colis", colisColumnName);
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
}
