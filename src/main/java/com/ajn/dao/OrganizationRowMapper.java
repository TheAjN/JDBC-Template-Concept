package com.ajn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ajn.domain.Organization;

public class OrganizationRowMapper implements RowMapper<Organization>{

	@Override
	public Organization mapRow(ResultSet rs, int rowNum) throws SQLException {
		Organization org = new Organization();
		
		// setting the data from row/rows of DB to the org object
		org.setId(rs.getInt("id"));
		org.setCompany_name(rs.getString("company_name"));
		org.setYear_of_incorporation(rs.getInt("year_of_incorporation"));
		org.setPostal_code(rs.getString("postal_code"));
		org.setEmployee_count(rs.getInt("employee_count"));
		org.setSlogan(rs.getString("slogan"));
		
		return org;
	}

	
	
}
