package pages_pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import common_pom.Configuration;

public class LoginPage
{

	//WebElements in Login Page

	@FindBy(id="txtUsername")
	By userNameField;

	@FindBy(id="txtPassword")
	WebElement passwordField;

	@FindBy(id="btnLogin")
	WebElement loginBtn;
	
	@FindBy(xpath="//*[@id=\"menu_admin_viewAdminModule\"]/b")
	WebElement admin;
	
	@FindBy(id="searchSystemUser_userName")
	WebElement usernamehomepage;
	
	@FindBy(id="searchSystemUser_userType")
	WebElement userRole;
	
	@FindBy(id="searchBtn")
	WebElement search;
	
	@FindBy(name="searchSystemUser[employeeName][empName]")
	WebElement employeeName;
	
	@FindBy(id="searchSystemUser_status")
	WebElement status;
	
	@FindBy(xpath="//*[@id=\"resultTable\"]/tbody/tr[2]")
	WebElement firstRow;
	
	@FindBy(xpath="//*[@id=\"resultTable\"]/tbody/tr/td")
	WebElement norecords;
	
	@FindBy(xpath="//*[@id=\"menu_pim_viewPimModule\"]/b")
	WebElement pimf;
	
	@FindBy(id="empsearch_employee_name_empName")
	WebElement eName;
	
	@FindBy(id="empsearch_id")
	WebElement id;
	
	@FindBy(id="empsearch_employee_status")
	WebElement empStatus;
	
	@FindBy(id="empsearch_termination")
	WebElement include;
	
	@FindBy(id="empsearch_supervisor_name")
	WebElement sName;
	
	@FindBy(id="empsearch_job_title")
	WebElement jTitle;
	
	@FindBy(id="empsearch_sub_unit")
	WebElement sUnit;

	@FindBy(id="searchBtn")
	WebElement pimSearch;
	WebDriver driver;
	
	@BeforeSuite
	public void  login()
	{	
		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(userNameField).sendKeys("admin");
		passwordField.sendKeys("admin123");
		loginBtn.click();
		
	}

	/*public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}*/
	@Test(priority=1)
	public void admin()
	{
		admin.click();	
	}
	
	@Test(priority=2)
	public void userName()
	{
		usernamehomepage.sendKeys("admin");
		search.click();
	}
	
	@Test(priority=3)
	public void userRole()
	{
		new Select(employeeName).selectByIndex(1);
		search.click();
	}
	
	@Test(priority=4)
	public void  employeeSearch()
	{
		employeeName.sendKeys("Linda");
		search.click();
	}
	
	@Test(priority=5)
	public void search()
	{
		new Select(status).selectByIndex(1);
		status.click();
	}
	
	@Test(priority=6)
	public void table()
	{
		String rowone = firstRow.getText();
		System.out.println(rowone);
	}
	
	@Test(priority=7)
	public void noRecord()
	{
		usernamehomepage.sendKeys("user");
		search.click();
		Assert.assertEquals(norecords.getText(), "No Records Found");
	}
	
	@Test(priority=8)
	public void pim()
	{
		pimf.click();
	}
	
	@Test(priority=9)
	public void employeeName()
	{
		eName.sendKeys("abc");
		pimSearch.click();
	}
	
	@Test(priority=10)
	public void pimId()
	{
		id.sendKeys("10");
		pimSearch.click();
	}
	
	@Test(priority=11)
	public void empStatus()
	{
		new Select(empStatus).selectByIndex(2);
		pimSearch.click();
	}
	
	@Test(priority=12)
	public void includ()
	{
		new Select(include).selectByIndex(1);
		pimSearch.click();
	}
	
	@Test(priority=13)
	public void supervisorName()
	{
		sName.sendKeys("abcd");
		pimSearch.click();
	}
	
	@Test(priority=14)
	public void jobTitle()
	{
		new Select(jTitle).selectByIndex(1);
		pimSearch.click();
	}
	
	@Test(priority=15)
	public void subUnit()
	{
		new Select(sUnit).selectByIndex(1);
		pimSearch.click();
	}
	@AfterSuite
	public void close()
	{
		driver.close();
	}
	
}
