package escrim.model.table;

import java.util.ArrayList;
import java.util.List;

import escrim.manager.CompartimentManager;
import escrim.metiers.Compartiment;

@SuppressWarnings("serial")
public class RemplissageTransportTableModel extends EscrimTableModel {
	private List<Compartiment> listeCompartiments = new ArrayList<Compartiment>();
	private String[] CompartimentColumnName = { "Nom", "Hauteur", "Largeur",
			"Longueur", "Volume", "Poids", "uid" };
	private int uidTransportToManage;

	public RemplissageTransportTableModel(boolean allCompartiments,
			int uidTransport) {
		uidTransportToManage = uidTransport;
		if (allCompartiments) {
			listeCompartiments = CompartimentManager
					.loadOutsideTransport(uidTransportToManage);
		} else {
			listeCompartiments = CompartimentManager
					.loadByTransport(uidTransportToManage);
		}
	}

	public int getColumnCount() {
		return 7;
	}

	public void refreshModel(boolean allCompartiment) {
		if (allCompartiment) {
			listeCompartiments = CompartimentManager
					.loadOutsideTransport(uidTransportToManage);

		} else {
			listeCompartiments = CompartimentManager
					.loadByTransport(uidTransportToManage);
		}
		fireTableDataChanged();

	}

	public int getRowCount() {
		if (listeCompartiments != null) {
			return listeCompartiments.size();
		} else {
			return 0;
		}
	}

	@Override
	public String getColumnName(int columnIndex) {
		return CompartimentColumnName[columnIndex];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return String.class;
		case 1:
			return Float.class;
		case 2:
			return Float.class;
		case 3:
			return Float.class;
		case 4:
			return Float.class;
		case 5:
			return Float.class;
		case 6:
			return Integer.class;

		}
		return null;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Compartiment compartiment = listeCompartiments.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return compartiment.getNom();
		case 1:
			return compartiment.getHauteur();
		case 2:
			return compartiment.getLargeur();
		case 3:
			return compartiment.getLongueur();
		case 4:
			return compartiment.getVolume();
		case 5:
			return compartiment.getPoids();
		case 6:
			return compartiment.getUid();
		}
		return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		switch (columnIndex) {

		case 0:
			listeCompartiments.get(rowIndex).setNom(
					aValue == null ? null : aValue.toString());
			break;
		case 1:
			listeCompartiments.get(rowIndex).setHauteur(
					aValue == null ? new Float(0) : Float
							.parseFloat(((String) aValue).trim()));
			break;
		case 2:
			listeCompartiments.get(rowIndex).setLargeur(
					aValue == null ? new Float(0) : Float
							.parseFloat(((String) aValue).trim()));
			break;
		case 3:
			listeCompartiments.get(rowIndex).setLongueur(
					aValue == null ? new Float(0) : Float
							.parseFloat(((String) aValue).trim()));
			break;
		case 4:
			if (listeCompartiments.get(rowIndex).getHauteur() != 0
					&& listeCompartiments.get(rowIndex).getLargeur() != 0
					&& listeCompartiments.get(rowIndex).getLongueur() != 0) {
				listeCompartiments.get(rowIndex).setVolume();
			}
			break;
		case 5:
			listeCompartiments.get(rowIndex).setPoids(
					aValue == null ? new Float(0) : Float
							.parseFloat(((String) aValue).trim()));
			break;
		}
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		return false;

	}
}
