import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Suman {
	static WebDriver driver;
public static void main(String args[]) throws Exception {


	
	System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("https://opensource-demo.orangehrmlive.com/");
	driver.manage().window().maximize();
	driver.findElement(By.id("txtUsername")).sendKeys("admin");
	driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	driver.findElement(By.id("btnLogin")).click();
	Thread.sleep(3000);
	//Actions sc = new Actions(driver);
	driver.findElement(By.xpath("//div[@class='menu']/ul/li[1]/a/b")).click();
	//sc.moveToElement(s).build().perform();
	Thread.sleep(3000);
	driver.findElement(By.id("searchSystemUser_userName")).sendKeys("user");
	Thread.sleep(3000);
	driver.findElement(By.id("searchBtn")).click();
	Thread.sleep(3000);
	new Select(driver.findElement(By.id("searchSystemUser_userType"))).selectByIndex(1);
	Thread.sleep(3000);
	driver.findElement(By.id("searchBtn")).click();
	Thread.sleep(3000);
	driver.findElement(By.name("searchSystemUser[employeeName][empName]")).sendKeys("Linda");
	Thread.sleep(3000);
	driver.findElement(By.id("searchBtn")).click();
	Thread.sleep(3000);
	new Select(driver.findElement(By.id("searchSystemUser_status"))).selectByIndex(1);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//div[@class='menu']/ul/li[2]/a/b")).click();
	Thread.sleep(3000);
	driver.findElement(By.name("empsearch[employee_name][empName]")).sendKeys("John");
	Thread.sleep(3000);
	driver.findElement(By.name("empsearch[employee_name][empName]")).sendKeys(Keys.ENTER);
	driver.findElement(By.id("searchBtn")).click();
	Thread.sleep(3000);
	driver.findElement(By.name("empsearch[id]"));
	Thread.sleep(3000);
	driver.findElement(By.id("searchBtn")).click();

	Thread.sleep(3000);
	new Select(driver.findElement(By.name("empsearch[employee_status]"))).selectByIndex(3);
	Thread.sleep(3000);
	driver.findElement(By.id("searchBtn")).click();
	Thread.sleep(3000);
	new Select(driver.findElement(By.name("empsearch[termination]"))).selectByIndex(1);
	Thread.sleep(3000);
	driver.findElement(By.id("searchBtn")).click();
	Thread.sleep(3000);
	driver.findElement(By.name("empsearch[supervisor_name]")).sendKeys("Linda");
	Thread.sleep(3000);
	driver.findElement(By.id("searchBtn")).click();
	Thread.sleep(3000);
	new Select(driver.findElement(By.name("empsearch[job_title]"))).selectByValue("3");
	Thread.sleep(3000);
	driver.findElement(By.id("searchBtn")).click();
	Thread.sleep(3000);
	
	new Select(driver.findElement(By.name("empsearch[sub_unit]"))).selectByValue("5");
	Thread.sleep(3000);
	driver.findElement(By.id("searchBtn")).click();
	
	
	
	
	
	
	
}
}
