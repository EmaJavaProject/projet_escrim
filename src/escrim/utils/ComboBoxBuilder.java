package escrim.utils;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

import escrim.manager.TypeColisManager;
import escrim.metiers.TypeColis;
import escrim.model.table.ColisTableModel;

/**
 * The Class ComboBoxBuilder.
 */
public class ComboBoxBuilder {

	/**
	 * Sets the up type colis column.
	 *
	 * @param table
	 *            the table
	 * @param sportColumn
	 *            the sport column
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

	public static ComboBoxModel<Object> setSecteurModel(JTable table) {
		return new DefaultComboBoxModel<Object>(
				((ColisTableModel) table.getModel()).getDisctinctSecteur());

	}

	public static ComboBoxModel<Object> setConfigModel(JTable table) {
		return new DefaultComboBoxModel<Object>(
				((ColisTableModel) table.getModel()).getDisctinctConfig());
	}
}
