package escrim.model.table;

import java.util.ArrayList;
import java.util.List;

import escrim.manager.ColisManager;
import escrim.manager.ConfigurationHopitalManager;
import escrim.manager.TypeColisManager;
import escrim.metiers.Colis;
import escrim.metiers.ConfigurationHopital;

/**
 * The Class RemplissageConfigurationHopitalTableModel.
 */
@SuppressWarnings("serial")
public class RemplissageConfigurationHopitalTableModel extends EscrimTableModel {

	/** The liste colis. */
	private List<Colis> listeColis = new ArrayList<Colis>();

	/** The Colis column name. */
	private String[] ColisColumnName = { "N° Colis", "Nom", "Affectataire",
			"Optionnel", "Secteur", "Type Colis", "Observation" };

	/** The uid config hopital to manage. */
	private int uidConfigHopitalToManage;

	/**
	 * Instantiates a new remplissage configuration hopital table model.
	 *
	 * @param allColis the all colis
	 * @param uidConfig the uid config
	 */
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

	/* (non-Javadoc)
	 * @see javax.swing.table.DefaultTableModel#getColumnCount()
	 */
	public int getColumnCount() {
		return 7;
	}

	/**
	 * Refresh model.
	 *
	 * @param allColis the all colis
	 * @param uidConfigHopitalToManage the uid config hopital to manage
	 */
	public void refreshModel(boolean allColis, int uidConfigHopitalToManage) {
		this.uidConfigHopitalToManage = uidConfigHopitalToManage;
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
			return String.class;
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
			return colis.getTypeColis().getDesignation();
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

	/**
	 * Fill config.
	 *
	 * @param uidConfig the uid config
	 * @param uidColis the uid colis
	 */
	public void fillConfig(int uidConfig, int uidColis) {
		Colis colis = ColisManager.loadColis(uidColis);
		ConfigurationHopital conf = ConfigurationHopitalManager
				.loadConfigurationHopital(uidConfig);

		conf.addColis(colis);
		colis.addConfiguration(conf);

		ColisManager.updateColis(colis, colis.getUid());
		ConfigurationHopitalManager.updateConfigurationHopital(conf, uidConfig);
	}

	/**
	 * Fill out config.
	 *
	 * @param uidConfig the uid config
	 * @param uidColis the uid colis
	 */
	public void fillOutConfig(int uidConfig, int uidColis) {
		Colis colis = ColisManager.loadColis(uidColis);
		ConfigurationHopital conf = ConfigurationHopitalManager
				.loadConfigurationHopital(uidConfig);

		conf.removeColis(colis);
		colis.removeConfiguration(conf);

		ColisManager.updateColis(colis, colis.getUid());
		ConfigurationHopitalManager.updateConfigurationHopital(conf, uidConfig);

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
