package com.acid.aig.traning.aigtraning.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.EqualsBuilder;

@Entity
public class Customer {

	@Id
	@GeneratedValue
	private long customerId;

	private String companyName;

	private String contactName;

	private String address;

	private String city;

	private String state;

	private String zip;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	private String country;

	/**
	 * Gets the customer id
	 * 
	 * @return The customer id
	 */
	public long getCustomerId() {
		return this.customerId;
	}

	/**
	 * Sets the customer id
	 * 
	 * @param customerId The customer id
	 */
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	/**
	 * Gets the company name
	 * 
	 * @return The company name
	 */
	public String getCompanyName() {
		return this.companyName;
	}

	/**
	 * Sets the company name
	 * 
	 * @param companyName The company name
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * Gets the company contact name
	 * 
	 * @return The company contact name
	 */
	public String getContactName() {
		return this.contactName;
	}

	/**
	 * Sets the company contact name
	 * 
	 * @param contactName The company contact name
	 */
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	/**
	 * Gets the address
	 * 
	 * @return The address
	 */
	public String getAddress() {
		return this.address;
	}

	/**
	 * Sets the address
	 * 
	 * @param address The address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Gets the city
	 * 
	 * @return The city
	 */
	public String getCity() {
		return this.city;
	}

	/**
	 * Sets the city
	 * 
	 * @param city The city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Gets the state
	 * 
	 * @return The state
	 */
	public String getState() {
		return this.state;
	}

	/**
	 * Sets the state
	 * 
	 * @param state The state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Gets the zip
	 * 
	 * @return The zip
	 */
	public String getZip() {
		return this.zip;
	}

	/**
	 * Sets the zip
	 * 
	 * @param zip The zip
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.customerId);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		if (obj == this) {
			return true;
		}

		if (obj.getClass() != getClass()) {
			return false;
		}

		Customer rhs = (Customer) obj;
		return new EqualsBuilder().append(this.customerId, rhs.customerId).isEquals();
	}

	@Override
	public String toString() {
		return companyName + contactName;
	}
}