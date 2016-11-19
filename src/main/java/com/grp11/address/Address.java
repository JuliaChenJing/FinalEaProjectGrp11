package com.grp11.address;
import java.io.Serializable;
import javax.persistence.*;
/* Immutable */
@Embeddable
final public class Address implements Serializable {
	
	private static final long serialVersionUID = -891229800414574888L;
	private String street;
	private String city;
	private String state;
	private String zip;
	// comment example	
	public Address(String street, String city, String state, String zip) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	public String getStreet() {
		return street;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public String getZip() {
		return zip;
	}
	@Override
	public String toString() {
		return "(" + street + ", " + city + ", " + zip + ")";
		
	}
}