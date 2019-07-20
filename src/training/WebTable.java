package training;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		int numOfRows=driver.findElements(By.xpath("//table[@id='customers']/tbody/tr")).size();
		int numOfCols=driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[2]/td")).size();
		System.out.println("No of rows is "+numOfRows);
		
		WebElement table=driver.findElement(By.id("customers"));
		int desireColumn=1;
		for (int k=1;k<=numOfCols;k++)
		{
			if(table.findElement(By.xpath("tbody/tr[1]/th["+k+"]")).getText().equals("Contact"))
			{
				desireColumn=k;
				break;
			}
		}
		for (int i=2;i<=numOfRows;i++)
		{
			//for (int j=1;j<=numOfCols;j++)
			//{
			String sData=table.findElement(By.xpath("tbody/tr["+i+"]/td[1]")).getText();	
			if(sData.equals("Island Trading"))
			{
				String contact=table.findElement(By.xpath("tbody/tr["+i+"]/td["+desireColumn+"]")).getText();
				String country=driver.findElement(By.xpath("//table[@id='customers']/tbody/tr["+i+"]/td[3]")).getText();
				System.out.println(contact);
				System.out.println(country);
			}
			
			
		}
	}

}

