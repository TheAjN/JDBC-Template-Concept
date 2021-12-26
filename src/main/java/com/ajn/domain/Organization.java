package com.ajn.domain;

public class Organization {

	private int id;
	private String company_name;
	private int year_of_incorporation;
	private String postal_code;
	private int employee_count;
	private String slogan;

	public Organization() {
	//	this(null,0,null,0,null);
	}


	public Organization(String company_name, int year_of_incorporation, String postal_code, int employee_count, String slogan) {
		this.company_name = company_name;
		this.year_of_incorporation = year_of_incorporation;
		this.postal_code = postal_code;
		this.employee_count = employee_count;
		this.slogan = slogan;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public int getYear_of_incorporation() {
		return year_of_incorporation;
	}
	public void setYear_of_incorporation(int year_of_incorporation) {
		this.year_of_incorporation = year_of_incorporation;
	}
	public String getPostal_code() {
		return postal_code;
	}
	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}
	public int getEmployee_count() {
		return employee_count;
	}
	public void setEmployee_count(int employee_count) {
		this.employee_count = employee_count;
	}
	public String getSlogan() {
		return slogan;
	}
	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}
	
	@Override
	public String toString() {
		return "Organization [id=" + id + ", company_name=" + company_name + ", year_of_incorporation="
				+ year_of_incorporation + ", postal_code=" + postal_code + ", employee_count=" + employee_count
				+ ", slogan=" + slogan + "]";
	}
	
	
	

}
