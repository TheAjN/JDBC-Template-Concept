package com.ajn;

import com.ajn.com.ajn.Utils.DaoUtils;
import com.ajn.dao.OrganizationDAO;
import com.ajn.domain.Organization;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class JDBC_TemplateClassicApp1 {

    public static void main(String[] args) {


        //creating the application context
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");

        //Create the bean
        OrganizationDAO dao = (OrganizationDAO) ctx.getBean("orgDao");

        //Creating seed data
	    DaoUtils.createSeedData(dao);

        //Getting the list of Organizations and printing it
        List<Organization> orglist = dao.getAll();
        DaoUtils.printOrganizations(orglist,DaoUtils.readOperation);

        //create a new organization record
        Organization newOrg = new Organization("Riot Games", 2005, "85275", 9007, "King of MOBA");
        DaoUtils.printSuccessFailure(DaoUtils.createOperation,dao.create(newOrg));
        //DaoUtils.printOrganizationCount(dao.getAll(),DaoUtils.createOperation);
        DaoUtils.printOrganizations(dao.getAll(),DaoUtils.readOperation);

        //Get a single organization
        Organization org2 = dao.getOrganization(1);
        DaoUtils.printOrganization(org2,"getOrganization");

        //update an organization
        Organization updateOrg = dao.getOrganization(4);
        updateOrg.setSlogan("king of mobile games");
        boolean isUpdated = dao.update(updateOrg);
        DaoUtils.printSuccessFailure(DaoUtils.updateOperation,isUpdated);
        DaoUtils.printOrganization(dao.getOrganization(4),DaoUtils.updateOperation);


        //Cleaning up the table organization
        dao.cleanup(); //comment this line to transfer the information into the database
        DaoUtils.printOrganizationCount(dao.getAll(),DaoUtils.cleanupOperation);

		/*
		List<Organization> orgList = dao.getAll();
		for(Organization org : orgList) {

			System.out.println(org);
		}*/



        ((ClassPathXmlApplicationContext) ctx).close();

    }

}
