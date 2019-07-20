package pages_pom;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import common_pom.Configuration;

public class HomePage extends Configuration
{

	@FindBy(id="welcome")
	WebElement welcomeText;

	@FindBy(id="menu_admin_viewAdminModule")
	WebElement adminLink;
	
	@FindBy(id="menu_pim_viewPimModule")
	WebElement pimLink;


	public void VerifyHomePage()
	{
		String sText=welcomeText.getText();
		Assert.assertEquals(sText, "Welcome Admin");
	
	}

	public AdminPage NavigatetoAdminPage()
	{
		adminLink.click();
		return new AdminPage();
	}
	
	public void NavigatetoPIMPage()
	{
		pimLink.click();
	}
	
	
	public HomePage()
	{
		PageFactory.initElements(driver,this);
	}

}
