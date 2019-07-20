package pages_pom;

import org.openqa.selenium.support.PageFactory;

import common_pom.Configuration;

public class AdminPage extends Configuration
{
	public HomePage navigateBack()
	{
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php");
		return new HomePage();
	}

	public AdminPage()
	{
		PageFactory.initElements(driver, this);
	}
}
