package ihm;

import java.util.ArrayList;
import java.util.List;

import escrim.manager.ConfigurationHopitalManager;
import escrim.metiers.ConfigurationHopital;



public class ConfigurationHopitalTableModel extends EscrimModelTable {

	private static final long serialVersionUID = -6952441053721179931L;
	
	private List<ConfigurationHopital> listeConfigurationHopital = new ArrayList<ConfigurationHopital>();
	public static String[] configurationHopitalColumnName = {"", "Nom", "uid" };

	public ConfigurationHopitalTableModel() {
		listeConfigurationHopital = ConfigurationHopitalManager.loadAllConfigurationHopital();
	}

	@Override
	public String getColumnName(int columnIndex) {
		return configurationHopitalColumnName[columnIndex];
	}

	@Override
	public int getRowCount() {
		if (listeConfigurationHopital != null) {
			return listeConfigurationHopital.size();
		} else
			return 0;
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		ConfigurationHopital config = listeConfigurationHopital.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return null;
		case 1:
			return config.getDenomination();
		case 2:
			return config.getUid();
		}
		return null;
	}

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

	public void addRow() {
		listeConfigurationHopital.add(0, null);
		fireTableDataChanged();
	}
}
