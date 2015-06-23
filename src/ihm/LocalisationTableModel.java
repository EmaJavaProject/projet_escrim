package ihm;

import java.util.ArrayList;
import java.util.List;

import escrim.manager.LocalisationManager;
import escrim.metiers.Localisation;


public class LocalisationTableModel extends EscrimModelTable {

	private static final long serialVersionUID = -3731824714239498186L;
	
	private List<Localisation> listeLocalisation = new ArrayList<Localisation>();
	public static String[] localisationColumnName = {"", "Numero de secteur", 
		"Nom de secteur", "uid" };

	public LocalisationTableModel() {
		listeLocalisation = LocalisationManager.loadAllLocalisation();
	}

	@Override
	public String getColumnName(int columnIndex) {
		return localisationColumnName[columnIndex];
	}

	@Override
	public int getRowCount() {
		if (listeLocalisation != null) {
			return listeLocalisation.size();
		} else
			return 0;
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Localisation localisation = listeLocalisation.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return null;
		case 1:
			return localisation.getNumeroSector();
		case 2:
			return localisation.getNomSector();
		case 3:
			return localisation.getUid();
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
			return String.class;
		case 3:
			return Integer.class;
		}
		return null;
	}

	public void addRow() {
		listeLocalisation.add(0, null);
		fireTableDataChanged();
	}
}
