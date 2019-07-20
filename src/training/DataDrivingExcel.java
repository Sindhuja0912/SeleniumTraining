package training;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import training.ExcelInteraction;

public class DataDrivingExcel {
	
	static WebDriver driver;

			
			
			public static void main(String[] args) throws InterruptedException, IOException 
			{
				
				System.setProperty("webdriver.chrome.driver", "E:\\Training\\Python_docs\\chromedriver.exe");
				driver=new ChromeDriver();
			//System.setProperty("webdriver.gecko.driver", "E:\\Training\\Python_docs\\geckodriver.exe");		
			//	driver=new FirefoxDriver();
				driver.get("https://demo.opencart.com/");
				ArrayList<String> a1=ExcelInteraction.readFromExcel("D:\\SeleniumAppiumTraining\\Day 4\\Test_data (1).xls","Sheet2");
				ArrayList<String> a2=new ArrayList<String>();
				for(int i=0;i<a1.size();i++)
				{
					WebElement search=driver.findElement(By.name("search"));
					WebElement button=driver.findElement(By.xpath("//div[@id='search']//button"));
					search.clear();
					search.sendKeys( a1.get(i));
					button.click();
					try
					{
						if(driver.findElement(By.xpath("//input[@id='button-search']/following-sibling::p")).isDisplayed())
						{
							a2.add("fail");
						}
					}
					catch(Exception e)
					{
						a2.add("pass");
					}
				}
				
				ExcelInteraction.writeToExcel("D:\\SeleniumAppiumTraining\\Day 4\\Test_data (1).xls","Sheet2", a2);
			
			}

		}

