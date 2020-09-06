package fit5042.assx.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Printer implements Serializable
{	
	@Id @GeneratedValue
	private int printerId;
	private String printerType;
	
	public Printer() 
	{
		super();
	}

	public Printer(int printerId, String printerType) 
	{
		super();
		this.printerId = printerId;
		this.printerType = printerType;
	}
	
	public int getPrinterId() 
	{
		return printerId;
	}
	
	public void setPrinterId(int printerId) 
	{
		this.printerId = printerId;
	}
	
	public String getPrinterType() 
	{
		return printerType;
	}
	
	public void setPrinterType(String printerType) 
	{
		this.printerType = printerType;
	}

	@Override
	public String toString() 
	{
		return "Printer [printerId=" + printerId + ", printerType=" + printerType + "]";
	}
}
