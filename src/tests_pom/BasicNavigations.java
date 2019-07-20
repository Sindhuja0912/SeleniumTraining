package tests_pom;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import common_pom.Configuration;
import pages_pom.AdminPage;
import pages_pom.HomePage;
import pages_pom.LoginPage;

public class BasicNavigations extends Configuration
{
	LoginPage objLogin;
	HomePage objHome;
	AdminPage objAdmin;
		
	@BeforeTest
		public void login()
		{
			objLogin=new LoginPage(); 
			objHome=objLogin.login("admin", "admin123");	
		}
		
	@Test
	public void verifyLogin() 

	{
		//objHome=new HomePage();
		objHome.VerifyHomePage();

	}
	
	@Test
	public void verifyAdminFunctionality() 

	{
		objHome.VerifyHomePage();
		objAdmin=objHome.NavigatetoAdminPage();
		objHome=objAdmin.navigateBack();

	}
	
	@Test
	public void verifyPIMFunctionality() 

	{
		objHome.NavigatetoPIMPage();

	}
}
