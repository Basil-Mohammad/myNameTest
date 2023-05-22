package myNameTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class myNameTest {
	
	String myURL = "https://www.google.com/";
	String myName = "basil";
	
	WebDriver driver = new ChromeDriver();
	
	Assertion myAssert = new Assertion();

	@BeforeTest
	
	public void preTest() {
		
		driver.get(myURL);
		WebElement searchSpace = driver.findElement(By.xpath("//*[@id=\"APjFqb\"]"));
		searchSpace.sendKeys(myName);
		
		WebElement searchButton = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[1]"));
		searchButton.click();
		
	}
	
	@Test()
	public void nameAppearsInAllSearchResults () {
		
		String  ExpectedItem = myName;

		List<WebElement> searchResult = driver.findElements(By.className("LC20lb"));
		
		System.out.println(searchResult.size()+"@@@@@@@@@");
		
		for(int i = 0 ; i < searchResult.size() ; i++) {
			
			String ActualItemsInSearchResult = searchResult.get(i).getText();
			
		//	myAssert.assertTrue(ActualItemsInSearchResult.toLowerCase().contains(ExpectedItem),"User input string not found in search results");
			myAssert.assertEquals(ActualItemsInSearchResult.toLowerCase().contains(ExpectedItem), true);
			System.out.println(ActualItemsInSearchResult);
			
		}
		
	}
	
	@AfterTest
	public void afterTest() {}
}
