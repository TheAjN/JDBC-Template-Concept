package com.ajn.com.ajn.Utils;

import com.ajn.dao.OrganizationDAO;
import com.ajn.domain.Organization;

import java.util.ArrayList;
import java.util.List;

public class DaoUtils {

    public static final String createOperation = "CREATE";
    public static final String readOperation = "READ";
    public static final String updateOperation = "UPDATE";
    public static final String deleteOperation = "DELETE";
    public static final String cleanupOperation = "TRUNCATE";


    public static void printOrganizations(List<Organization> orgg, String operation) {
        System.out.println("\n********* printing organizations after " + operation + " operation *********");
        for (Organization org : orgg) {
            System.out.println(org);
        }
    }

    public static void printOrganization(Organization org,String operation){
        System.out.println("\n********* printing a single organization after invoking " +
                "operation " + operation +" *********\n"+org);
    }

    public static void printSuccessFailure(String operation, boolean param){
        if(param)
            System.out.println("\nOperation " + operation + " successful");
        else
            System.out.println("\nOperation " + operation + " failed");
    }

    public static void createSeedData(OrganizationDAO orgDao){
        Organization org1= new Organization("BMW",1929,"45456",10000,"To build cars!");
        Organization org2 = new Organization("Amazon",1994,"75757",20000,"Online Giant");
        Organization org3 = new Organization("Google", 1996, "57575", 4567, "Don't be evil");

        List<Organization> organizationList = new ArrayList<>();
        organizationList.add(0,org1);
        organizationList.add(1,org2);
        organizationList.add(2,org3);

        int count = 0;
        for(Organization org: organizationList){
          boolean check=orgDao.create(org);
            if(check){
                count++;
            }
        }

        System.out.println("Number of organizations added is "+count);
    }


    public static void printOrganizationCount(List<Organization> orgs, String operation){
        System.out.println("\n*********Currently we have " + orgs.size()+ " organizations after " + operation + " operation" + "   *********");

    }
}
