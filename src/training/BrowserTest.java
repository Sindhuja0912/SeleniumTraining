package training;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserTest {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		//System.setProperty("webdriver.gecko.driver", "D:\\Softwares\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		//driver=new FirefoxDriver();
		driver.get("https://demo.opencart.com/");
		String sTitle=driver.getTitle();
		System.out.println("Title is:" +sTitle);
		if(sTitle.equalsIgnoreCase("Your Store"))
		{
			System.out.println("Page load Verification passed");
		}
		else
		{
			System.out.println("Page load Verification failed");
		}
		
		String sProduct="iPhone";
		String sQty="2";
		driver.findElement(By.name("search")).sendKeys("phone");
		driver.findElement(By.xpath("//div[@id='search']//button")).click();
		new Select(driver.findElement(By.name("category_id"))).selectByIndex(3);
		driver.findElement(By.name("sub_category")).click();
		driver.findElement(By.xpath("//img[@title='iPhone']")).click();
		driver.findElement(By.xpath(" //input[@name='quantity']")).clear();
		driver.findElement(By.xpath(" //input[@name='quantity']")).sendKeys("2");
		driver.findElement(By.xpath(" //button[@id='button-cart']")).click();
		driver.findElement(By.id("cart")).click();
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@id='cart']/ul/li[1]/table//tr/td[2]"), "iPhone"));
		String sProductA=driver.findElement(By.xpath("//div[@id='cart']/ul/li[1]/table//tr/td[2]")).getText();
		System.out.println(sProductA);
		String sQtyA=driver.findElement(By.xpath("//div[@id='cart']/ul/li[1]/table//tr/td[3]")).getText();
		System.out.println(sQtyA);
		if(sProduct.contains(sProductA))
		{
			System.out.println("Product Verified");
		}
		else
		{
			System.out.println("Product Not verified");
		}
		if(sQtyA.contains(sQty))
		{
			System.out.println("Quantity Verified");
		}
		else
		{
			System.out.println("Quantity Not Verified");
		}
		/*System.out.println(sProduct.contains(sProductA));
		System.out.println(sQtyA.contains(sQty));*/
		driver.findElement(By.xpath("//*[@id='cart']/ul/li[2]/div/p/a[2]/strong")).click();
		driver.findElement(By.xpath("//*[@id='accordion']/div[1]/div[1]/h4/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='input-coupon']")).sendKeys("COUPON30");
		driver.findElement(By.xpath("//*[@id='button-coupon']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='accordion']/div[2]/div[1]/h4/a")).click();
		Thread.sleep(2000);
		new Select(driver.findElement(By.name("country_id"))).selectByValue("186"); 
		Thread.sleep(2000);
		new Select(driver.findElement(By.name("zone_id"))).selectByIndex(4);
		Thread.sleep(2000);
		driver.findElement(By.name("postcode")).sendKeys("72201");
		driver.findElement(By.linkText("Checkout")).click();	 
	} 

}
