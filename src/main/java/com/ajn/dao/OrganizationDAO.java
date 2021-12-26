package com.ajn.dao;

import java.util.List;

import javax.sql.DataSource;

import com.ajn.domain.Organization;

public interface OrganizationDAO {
	
	//To set the datasource that would require to create a connection to the database
	public void setDatasource(DataSource ds);
	
	//To create a new organization in the table
	public boolean create(Organization org);
	
	//To get/find one organization by id
	public Organization getOrganization(Integer id);
	
	//to get the list of all organizations from the database
	public List<Organization> getAll();
	
	// To remove an organization from the database
	public boolean remove(Organization org);
	
	// To update an organization from the database
	public boolean update(Organization org);

	//To truncate/delete all the rows from our database
	public void cleanup();
}
