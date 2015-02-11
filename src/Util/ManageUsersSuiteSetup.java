package Util;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.http.auth.UsernamePasswordCredentials;
import org.testng.annotations.BeforeSuite;

import commons.UIMethods;
import jxl.JXLException;

public class ManageUsersSuiteSetup {

	public static List<Map<String, String>> usersXLS;

	@BeforeSuite //(groups = {"Acceptance"})
	public void init() throws JXLException, IOException 
	{
		ExcelSheetReader xlsFile = new ExcelSheetReader(System.getProperty("user.dir") + "/src/data/ManageUsersSuiteSetup.xls");
		usersXLS = xlsFile.getValues("Users");			
		createUsersByUI(usersXLS);
	}    	
	
	public static void createUsersByUI(List<Map<String, String>> usersXL)
	{
		System.out.println("-------------List of created users-------------\n");
		int index = 0;
		for (Map<String, String> usersInfo : usersXL)
		{
			
			if(index > 0){
			//printUsers(usersInfo.get("FirstName"), usersInfo.get("LastName"), usersInfo.get("Country"));
			UIMethods.createUserByUI(usersInfo.get("FirstName"),usersInfo.get("LastName"),
					usersInfo.get("Phone"),usersInfo.get("Email"),usersInfo.get("Address1"),
					usersInfo.get("Address2"),usersInfo.get("City"),usersInfo.get("State"),
					usersInfo.get("PostalCode"),usersInfo.get("Country"),usersInfo.get("UserName"),
					usersInfo.get("Password"),usersInfo.get("Repassword"));	
			}
			index++;
		}	        
	}
	
	public static String[] getCreatedUser(List<Map<String, String>> usersXL)
	{
		String[] usuario = new String[2];
		String userName = "";
		String password = "";
		for (Map<String, String> usersInfo : usersXL)
		{
			userName = usersInfo.get("UserName");
			password = usersInfo.get("Password");
		}		
		usuario[0] = userName;
		usuario[1] = password;		
		return usuario;
	}

	public static void printUsers(String firstName, String lastName, String country){
	   	System.out.println(firstName+"  "+lastName+"  "+country+"\n");		 
	}
}

