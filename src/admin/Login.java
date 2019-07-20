package admin;

import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Login { 	  
	
	static WebDriver driver;
 
  @BeforeSuite(groups= {"init"})
  @Parameters({"browser"})
  public void beforeSuite(String sbrowser) {
	  if(sbrowser.equalsIgnoreCase("chrome")) {
		  System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver_win32\\chromedriver.exe");
			driver= new ChromeDriver();
	  }
	  else if(sbrowser.equalsIgnoreCase("firefox")) {
		System.setProperty("webdriver.gecko.driver", "D:\\Softwares\\geckodriver-v0.24.0-win64\\geckodriver.exe");
			driver=new FirefoxDriver();
	  }
	  else if(sbrowser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "D:\\Softwares\\geckodriver-v0.24.0-win64\\geckodriver.exe");
				driver=new InternetExplorerDriver();
		  } 
  }

  @BeforeTest(groups= {"init"})
  public void beforeTest() {
	  driver.get("https://demo.opencart.com/");
  }

  @Test(groups= {"Smoke","Regression"},priority=1)
  public void searchFunctionality() {
	  String sTitle=driver.getTitle();
	  Assert.assertEquals(sTitle, "Your Store");
		driver.findElement(By.name("search")).sendKeys("iPhone");
		driver.findElement(By.xpath("//div[@id='search']//button")).click();
		new Select(driver.findElement(By.name("category_id"))).selectByIndex(3);
		driver.findElement(By.name("sub_category")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//img[@title='iPhone']")).isDisplayed(),true);
  }
  
  @Test(groups= {"Regression"},priority=2)
  public void cartverification() {
	  	String sProduct="iPhone";
		String sQty="2";
		driver.findElement(By.xpath("//img[@title='iPhone']")).click();
		driver.findElement(By.xpath(" //input[@name='quantity']")).clear();
		driver.findElement(By.xpath(" //input[@name='quantity']")).sendKeys("2");
		driver.findElement(By.xpath(" //button[@id='button-cart']")).click();
		driver.findElement(By.id("cart")).click();
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@id='cart']/ul/li[1]/table//tr/td[2]"), "iPhone"));
		String sProductA=driver.findElement(By.xpath("//div[@id='cart']/ul/li[1]/table//tr/td[2]")).getText();
		String sQtyA=driver.findElement(By.xpath("//div[@id='cart']/ul/li[1]/table//tr/td[3]")).getText();
		//String sQtyActual=sQtyA.replaceFirst("x ", "");
		Assert.assertEquals(sProductA.toLowerCase(), sProduct.toLowerCase());
		Assert.assertEquals(sQtyA.contains(sQty), true);
  }
  
  @AfterSuite(groups= {"init"})
  public void afterSuite() {
	  driver.quit();
  }

}

