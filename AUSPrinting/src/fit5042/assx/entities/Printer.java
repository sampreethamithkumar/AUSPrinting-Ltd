package fit5042.assx.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ @NamedQuery(name = Printer.GET_ID, query = "SELECT p.printerId FROM Printer p order by p.printerId ") })
public class Printer implements Serializable {
	public static final String GET_ID = "Printer.getId";
	@Id
	@GeneratedValue
	private int printerId;
	private String printerType;

	public Printer() {
		super();
	}

	public Printer(int printerId, String printerType) {
		super();
		this.printerId = printerId;
		this.printerType = printerType;
	}

	public int getPrinterId() {
		return printerId;
	}

	public void setPrinterId(int printerId) {
		this.printerId = printerId;
	}

	public String getPrinterType() {
		return printerType;
	}

	public void setPrinterType(String printerType) {
		this.printerType = printerType;
	}

	@Override
	public String toString() {
		return "Printer [printerId=" + printerId + ", printerType=" + printerType + "]";
	}
}
