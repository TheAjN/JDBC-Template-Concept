package com.ajn.dao;

import com.ajn.domain.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository("orgDao")
public class OrganizationDAOImpl implements OrganizationDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	@Override
	public void setDatasource(DataSource ds) { //here BasicDataSource sends its value through @Autowired via type

		jdbcTemplate = new JdbcTemplate(ds); //wrapping the datasource in an instance on jdbc template
											//The datasource is configured in a xml file
											//This method is called when the context is created
										//ie, the ClasspathXmlApplicationContext which contains beans-cp.xml
			//This is also a perfect example of setter dependency injection
		
	}

	@Override
	public boolean create(Organization org) { //Here, "org" is a DTO(data transfer object)
		String sql = "INSERT INTO organization(company_name,year_of_incorporation,postal_code,employee_count" +
				",slogan) VALUES(?, ?, ?, ?, ?)"; //Question marks for the placeholders to replace it

		Object[] args = new Object[]{org.getCompany_name(), org.getYear_of_incorporation(),
				org.getPostal_code(),org.getEmployee_count(),org.getSlogan()}; //here, the ordering of the placeholders are important

		return jdbcTemplate.update(sql,args) == 1; //Since we are creating only one row,
													// the output will come as true
		
	}

	@Override
	public Organization getOrganization(Integer id) {
	/*	String query= "SELECT company_name,year_of_incorporation,postal_code,employee_count," +
				"slogan from organization WHERE id= ?";

		Object[] obj = new Object[]{id};
		Organization org = jdbcTemplate.queryForObject(query,obj, new OrganizationRowMapper());*/ // This method is deprecated

		String query = "SELECT * from organization WHERE id=" + id;

		return jdbcTemplate.queryForObject(query, new OrganizationRowMapper());
 	}

	@Override
	public List<Organization> getAll() {
		String query = "SELECT * from organization";
		
		//here, query gets the entire list of the database via a sql query and through a rowMapper.
		List<Organization> orglist = jdbcTemplate.query(query, new OrganizationRowMapper());
		return orglist;
	}

	@Override
	public boolean remove(Organization org) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Organization org) { //org contains the updated organization, in this method we are updating
											//org into the Database via jdbcTemplate.update();
		String query = "UPDATE organization SET slogan = ? WHERE id = ?";
		Object[] args = new Object[]{org.getSlogan(),org.getId()};
		return jdbcTemplate.update(query,args) == 1;
	}

	@Override
	public void cleanup() {
		String  sql ="TRUNCATE TABLE organization"; //Wipes out the entire table, and setting the id count back to 1
		jdbcTemplate.execute(sql); //execute() method just executes an sql statement here
	}
	
	

}
