package escrim.utils;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

import escrim.manager.TypeColisManager;
import escrim.metiers.TypeColis;

/**
 * The Class ComboBoxBuilder.
 */
public class ComboBoxBuilder {

	/**
	 * Sets the up type colis column.
	 *
	 * @param table the table
	 * @param sportColumn the sport column
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void setUpTypeColisColumn(JTable table,
			TableColumn sportColumn) {

		JComboBox comboBox = new JComboBox();
		for (TypeColis typeColis : TypeColisManager.loadAllTypeColis()) {
			if (typeColis.getDesignation() != null) {
				comboBox.addItem((String) typeColis.getDesignation());
			}
		}
		sportColumn.setCellEditor(new DefaultCellEditor(comboBox));
		// Set up tool tips for the sport cells.
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		renderer.setToolTipText("Click for combo box");
		sportColumn.setCellRenderer(renderer);
	}
}
