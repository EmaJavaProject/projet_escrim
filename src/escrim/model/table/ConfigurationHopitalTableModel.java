package escrim.model.table;

import java.util.ArrayList;
import java.util.List;

import escrim.manager.ConfigurationHopitalManager;
import escrim.metiers.Colis;
import escrim.metiers.ConfigurationHopital;

/**
 * The Class ConfigurationHopitalTableModel.
 */
@SuppressWarnings("serial")
public class ConfigurationHopitalTableModel extends EscrimTableModel {
	
	/** The liste configuration hopital. */
	private List<ConfigurationHopital> listeConfigurationHopital = ConfigurationHopitalManager.loadAllConfigurationHopital();
	
	/** The Configuration hopital column name. */
	private String[] ConfigurationHopitalColumnName = { "","Dénomination","uid"};

	/**
	 * Instantiates a new configuration hopital table model.
	 */
	public ConfigurationHopitalTableModel() {
		listeConfigurationHopital = ConfigurationHopitalManager.loadAllConfigurationHopital();
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.DefaultTableModel#getColumnName(int)
	 */
	@Override
	public String getColumnName(int columnIndex) {
		return ConfigurationHopitalColumnName[columnIndex];
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.DefaultTableModel#getRowCount()
	 */
	@Override
	public int getRowCount() {
		if (listeConfigurationHopital != null) {
			return listeConfigurationHopital.size();
		} else {
			return 0;
		}
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.DefaultTableModel#getColumnCount()
	 */
	@Override
	public int getColumnCount() {
		return 3;
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.DefaultTableModel#getValueAt(int, int)
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		ConfigurationHopital ConfigurationHopital = listeConfigurationHopital.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return null;
		case 1:
			return ConfigurationHopital.getDenomination();
		case 2:
			return ConfigurationHopital.getUid();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.DefaultTableModel#setValueAt(java.lang.Object, int, int)
	 */
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		switch (columnIndex) {

		case 1:
			listeConfigurationHopital.get(rowIndex).setDenomination(
					aValue == null ? null : aValue.toString());
			break;

		default:
			break;
		}
	}

	/**
	 * Validate persistance.
	 *
	 * @param rowIndex the row index
	 */
	public void validatePersistance(int rowIndex) {
		ConfigurationHopitalManager.createConfigurationHopital(listeConfigurationHopital.get(rowIndex));
	}

	/**
	 * Refresh model.
	 */
	public void refreshModel() {
		listeConfigurationHopital = ConfigurationHopitalManager.loadAllConfigurationHopital();
		fireTableDataChanged();
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.AbstractTableModel#getColumnClass(int)
	 */
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return String.class;
		case 1:
			return String.class;
		case 2:
			return Integer.class;
		}
		return null;
	}

	/**
	 * Adds the element.
	 */
	public void addElement() {
		// Adds the element in the last position in the list
		super.setAddition(true);
		super.setEdition(false);
		super.setRemove(false);
		listeConfigurationHopital.add(getRowCount(), ConfigurationHopitalManager.createTempConfigurationHopital());
		fireTableRowsInserted(0, getRowCount());
	}

	/**
	 * Removes the element.
	 *
	 * @param rowIndex the row index
	 */
	public void removeElement(int rowIndex) {
		super.setRemove(true);
		super.setAddition(false);
		super.setEdition(false);
		persistData(rowIndex, true);
	}

	/**
	 * Persist data.
	 *
	 * @param rowIndex the row index
	 * @param validate the validate
	 */
	public void persistData(int rowIndex, boolean validate) {
		if (validate) {
			if (super.isAddition() && !super.isEdition() && !super.isRemove()) {
				ConfigurationHopitalManager.createConfigurationHopital(listeConfigurationHopital.get(rowIndex));
				setAddition(false);
			} else if (!super.isAddition() && super.isEdition()
					&& !super.isRemove()) {
				ConfigurationHopitalManager.updateConfigurationHopital(listeConfigurationHopital.get(rowIndex),
						(Integer) getValueAt(rowIndex, getColumnCount() - 1));
				setEdition(false);
			} else if (!super.isAddition() && !super.isEdition()
					&& super.isRemove()) {
				ConfigurationHopitalManager.removeConfigurationHopital((Integer) getValueAt(rowIndex,
						getColumnCount() - 1));
				setRemove(false);
			}
		}

		refreshModel();

	}

	/**
	 * Update element.
	 *
	 * @param rowIndex the row index
	 */
	public void updateElement(int rowIndex) {
		setEditedRow(rowIndex);
		setEdition(true);
		setAddition(false);
		setRemove(false);
	}
}
