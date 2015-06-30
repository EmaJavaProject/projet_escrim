package escrim.model.table;

import java.util.ArrayList;
import java.util.List;

import escrim.manager.ConfigurationHopitalManager;
import escrim.metiers.Colis;
import escrim.metiers.ConfigurationHopital;

@SuppressWarnings("serial")
public class ConfigurationHopitalTableModel extends EscrimTableModel {
	private List<ConfigurationHopital> listeConfigurationHopital = ConfigurationHopitalManager.loadAllConfigurationHopital();
	private String[] ConfigurationHopitalColumnName = { "","listeColis","denomination","uid"};

	public ConfigurationHopitalTableModel() {
		listeConfigurationHopital = ConfigurationHopitalManager.loadAllConfigurationHopital();
	}

	@Override
	public String getColumnName(int columnIndex) {
		return ConfigurationHopitalColumnName[columnIndex];
	}

	@Override
	public int getRowCount() {
		if (listeConfigurationHopital != null) {
			return listeConfigurationHopital.size();
		} else {
			return 0;
		}
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		ConfigurationHopital ConfigurationHopital = listeConfigurationHopital.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return null;
		case 1:
			return ConfigurationHopital.getListeColis();
		case 2:
			return ConfigurationHopital.getDenomination();
		case 3:
			return ConfigurationHopital.getUid();
		}
		return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		switch (columnIndex) {

		case 1:
			listeConfigurationHopital.get(rowIndex).setListeColis(new ArrayList<Colis>());
			break;
			
		case 2:
			listeConfigurationHopital.get(rowIndex).setDenomination(
					aValue == null ? null : aValue.toString());
			break;

		default:
			break;
		}
	}

	public void validatePersistance(int rowIndex) {
		ConfigurationHopitalManager.createConfigurationHopital(listeConfigurationHopital.get(rowIndex));
	}

	public void refreshModel() {
		listeConfigurationHopital = ConfigurationHopitalManager.loadAllConfigurationHopital();
		fireTableDataChanged();
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return String.class;
		case 1:
			return String.class;
		case 2:
			return String.class;
		case 3:
			return Integer.class;
		}
		return null;
	}

	public void addElement() {
		// Adds the element in the last position in the list
		super.setAddition(true);
		super.setEdition(false);
		super.setRemove(false);
		listeConfigurationHopital.add(getRowCount(), ConfigurationHopitalManager.createTempConfigurationHopital());
		fireTableRowsInserted(0, getRowCount());
	}

	public void removeElement(int rowIndex) {
		super.setRemove(true);
		super.setAddition(false);
		super.setEdition(false);
		persistData(rowIndex, true);
	}

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

	public void updateElement(int rowIndex) {
		setEditedRow(rowIndex);
		setEdition(true);
		setAddition(false);
		setRemove(false);
	}
}
