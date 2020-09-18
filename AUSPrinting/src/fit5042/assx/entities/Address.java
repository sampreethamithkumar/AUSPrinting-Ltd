package fit5042.assx.entities;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;

@Embeddable
@Access(AccessType.PROPERTY)
public class Address implements Serializable
{
    private String streetNumber;
    private String streetAddress;
    private String suburb;
    private String postcode;
    private String state;
    
	public Address() 
	{
		super();
	}
	
	
	public Address(String streetNumber, String streetAddress, String suburb, String postcode, String state) 
	{
		super();
		this.streetNumber = streetNumber;
		this.streetAddress = streetAddress;
		this.suburb = suburb;
		this.postcode = postcode;
		this.state = state;
	}
	
	public String getStreetNumber() 
	{
		return streetNumber;
	}
	
	public void setStreetNumber(String streetNumber) 
	{
		this.streetNumber = streetNumber;
	}
	
	public String getStreetAddress() 
	{
		return streetAddress;
	}
	
	public void setStreetAddress(String streetAddress) 
	{
		this.streetAddress = streetAddress;
	}
	
	public String getSuburb() 
	{
		return suburb;
	}
	
	public void setSuburb(String suburb) 
	{
		this.suburb = suburb;
	}
	
	public String getPostcode()
	{
		return postcode;
	}
	
	public void setPostcode(String postcode) 
	{
		this.postcode = postcode;
	}
	
	public String getState() 
	{
		return state;
	}
	public void setState(String state) 
	{
		this.state = state;
	}

	@Override
	public String toString() 
	{
		return "Address [streetNumber=" + streetNumber + ", streetAddress=" + streetAddress + ", suburb=" + suburb
				+ ", postcode=" + postcode + ", state=" + state + "]";
	}
}
