package training;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AutomationAssgnone {

		static WebDriver driver;

		public static void main(String[] args) throws InterruptedException {
			int j=0;
			System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver_win32\\chromedriver.exe");
			driver= new ChromeDriver();
			driver.get("http://automationpractice.com/index.php?");
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.findElement(By.linkText("Women")).click();
			driver.findElement(By.linkText("Faded Short Sleeve T-shirts")).click();
			driver.findElement(By.id("quantity_wanted")).clear();
			driver.findElement(By.id("quantity_wanted")).sendKeys("2");
			new Select(driver.findElement(By.id("group_1"))).selectByValue("2");
			driver.findElement(By.name("Blue")).click();
			driver.findElement(By.id("add_to_cart")).click();
			Thread.sleep(2000);
			String price=driver.findElement(By.xpath("//span[@id='layer_cart_product_price']")).getText();
			String sc=driver.findElement(By.xpath("//span[@id='layer_cart_product_attributes']")).getText();
			Thread.sleep(2000);
			String Qty=driver.findElement(By.xpath("//span[@id='layer_cart_product_quantity']")).getText();
			Thread.sleep(2000);
			System.out.println(sc);
			System.out.println(Qty);
			if(sc.contains("Blue, M"))
			{
				System.out.println("Size and Color verified");
			}
			else
			{
				System.out.println("Size and Color aren't matched");
			}
			if(Qty.contains("2"))
			{
				System.out.println("Quantity verified");
			}
			else
			{
				System.out.println("Quantity is not matched");
			}
			driver.findElement(By.linkText("Proceed to checkout")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"cart_quantity_up_1_4_0_0\"]/span/i")).click();
			String price1= driver.findElement(By.xpath("//span[@id='total_price']")).getText();	
			System.out.println(price1);
			if(!price.equals(price1)) 
			{
				System.out.println("Price is changed");
			}
			driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("email_create")).sendKeys("automation@kony.com");
			driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]/span")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("id_gender1")).click();
			driver.findElement(By.id("customer_firstname")).sendKeys("oneione");
			driver.findElement(By.id("email")).sendKeys("automationone@Kony.com");
			driver.findElement(By.xpath("//*[@id=\"submitAccount\"]/span")).click();
			Thread.sleep(2000);
			String errormsg = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/ol/li")).getText();
			Actions act = new Actions(driver);
			WebElement k = driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a/span[3]"));
			act.moveToElement(k).build().perform();
			driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/div/div/div/dl/dt/span/a")).click();
			Thread.sleep(2000);
			String price2 = driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/div/div/div/div/div[2]/span[1]")).getText();
			if(!price2.equals(j))
			{
				System.out.println("Cart is Empty");
			}		

	}

}
