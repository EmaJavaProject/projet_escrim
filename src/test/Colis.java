package test;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Colis
 *
 */
@Entity

public class Colis implements Serializable {

	   
	@Id
	private int OID;
	private String Type;
	private static final long serialVersionUID = 1L;

	public Colis() {
		super();
	}   
	public int getOID() {
		return this.OID;
	}

	public void setOID(int OID) {
		this.OID = OID;
	}   
	public String getType() {
		return this.Type;
	}

	public void setType(String Type) {
		this.Type = Type;
	}
   
}
