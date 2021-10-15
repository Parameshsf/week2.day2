package week2.day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkWithLink {
	
	ChromeDriver driver = new ChromeDriver();
	
	@SuppressWarnings("deprecation")
	public void link() {
		// TODO Auto-generated method stub
		driver.get("http://leafground.com/pages/Link.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50000,TimeUnit.SECONDS);
		
		
		driver.findElement(By.xpath("(//a[text()='Go to Home Page'])[1]")).click();
		driver.navigate().back();
		
		WebElement where = driver.findElement(By.xpath("//a[text()='Find where am supposed to go without clicking me?']"));
		String iamgoingto = where.getAttribute("href");
		System.out.println("I am going to this URL "+iamgoingto);
		
		//Verify the link if its broken or not
		driver.findElement(By.xpath("//a[text()='Verify am I broken?']")).click();
		String error = driver.findElement(By.xpath("//h1[text()='HTTP Status 404 – Not Found']")).getText();
		
		if (error.contentEquals("HTTP Status 404 – Not Found")) {
			System.out.println("The page is broken " + error);
			driver.navigate().back();
			
		} else {
			System.out.println("The page is not broken "+error);
			driver.navigate().back();

		}
		
		List<WebElement> findLinksCount = driver.findElements(By.tagName("a"));
		System.out.println("The Link Counts in this page is :"+findLinksCount.size());
		
		driver.close();
		
		
			
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WorkWithLink wF = new WorkWithLink();
		
		wF.link();

	}

}
