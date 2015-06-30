package escrim.model.table;

import java.util.ArrayList;
import java.util.List;

import escrim.manager.ColisManager;
import escrim.manager.TypeColisManager;
import escrim.metiers.Colis;

@SuppressWarnings("serial")
public class RemplissageConfigurationHopitalTableModel extends EscrimTableModel {

	private List<Colis> listeColis = new ArrayList<Colis>();

	private String[] ColisColumnName = { "N° Colis", "Nom", "Affectataire",
			"Optionnel", "Secteur", "Type Colis", "Observation", "uid" };

	private int uidConfigHopitalToManage;

	public RemplissageConfigurationHopitalTableModel(boolean allColis,
			int uidConfig) {
		uidConfigHopitalToManage = uidConfig;
		if (allColis) {
			listeColis = ColisManager
					.loadOutsideConfigHopital(uidConfigHopitalToManage);
		} else {
			listeColis = ColisManager
					.loadByConfigHopital(uidConfigHopitalToManage);
		}
	}

	public int getColumnCount() {
		return 8;
	}

	public void refreshModel(boolean allColis) {
		if (allColis) {
			listeColis = ColisManager
					.loadOutsideConfigHopital(uidConfigHopitalToManage);

		} else {
			listeColis = ColisManager
					.loadByConfigHopital(uidConfigHopitalToManage);
		}
		fireTableDataChanged();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.DefaultTableModel#getRowCount()
	 */
	public int getRowCount() {
		if (listeColis != null) {
			return listeColis.size();
		} else {
			return 0;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.DefaultTableModel#getColumnName(int)
	 */
	@Override
	public String getColumnName(int columnIndex) {
		return ColisColumnName[columnIndex];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.AbstractTableModel#getColumnClass(int)
	 */
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {

		case 0:
			return Integer.class;
		case 1:
			return String.class;
		case 2:
			return String.class;
		case 3:
			return Boolean.class;
		case 4:
			return Integer.class;
		case 5:
			return Integer.class;
		case 6:
			return String.class;
		case 7:
			return Integer.class;

		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.DefaultTableModel#getValueAt(int, int)
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Colis colis = listeColis.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return colis.getNumeroColis();
		case 1:
			return colis.getDesignation();
		case 2:
			return colis.getAffectation();
		case 3:
			return colis.isOptionnel();
		case 4:
			return colis.getSecteur();
		case 5:
			return colis.getTypeColis();
		case 6:
			return colis.getObservation();
		case 7:
			return colis.getUid();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.DefaultTableModel#setValueAt(java.lang.Object,
	 * int, int)
	 */
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		switch (columnIndex) {

		case 0:
			listeColis.get(rowIndex).setNumeroColis(
					aValue == null ? new Integer(0) : Integer
							.parseInt(((String) aValue).trim()));
			break;
		case 1:
			listeColis.get(rowIndex).setDesignation(
					aValue == null ? null : aValue.toString());
			break;
		case 2:
			listeColis.get(rowIndex).setAffectation(
					aValue == null ? null : aValue.toString());
			break;
		case 3:
			listeColis.get(rowIndex).setOptionnel(((boolean) aValue));
			break;
		case 4:
			listeColis.get(rowIndex).setSecteur(
					aValue == null ? new Integer(0) : Integer
							.parseInt(((String) aValue).trim()));
			break;
		case 5:
			listeColis.get(rowIndex).setTypeColis(
					TypeColisManager.createTempTypeColis());
			listeColis.get(rowIndex).getTypeColis()
					.setDesignation(aValue == null ? null : aValue.toString());
			break;
		case 6:
			listeColis.get(rowIndex).setObservation(
					aValue == null ? null : aValue.toString());
			break;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see escrim.model.table.EscrimTableModel#isCellEditable(int, int)
	 */
	@Override
	public boolean isCellEditable(int row, int column) {
		return false;

	}
}
