package com.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CSVEntity {
	@Id
	private int id;
	private String lastName;
	private String location;
	private String outletName;
	private String outletType;
	
	
	public CSVEntity() {
		super();
	}
	public CSVEntity(int id, String lastName, String location, String outletName, String outletType) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.location = location;
		this.outletName = outletName;
		this.outletType = outletType;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getOutletName() {
		return outletName;
	}
	public void setOutletName(String outletName) {
		this.outletName = outletName;
	}
	public String getOutletType() {
		return outletType;
	}
	public void setOutletType(String outletType) {
		this.outletType = outletType;
	}
}
