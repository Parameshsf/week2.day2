package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkWithButton {

	ChromeDriver driver = new ChromeDriver();

	@SuppressWarnings("deprecation")
	public void button() {
		// TODO Auto-generated method stub
		driver.get("http://leafground.com/pages/Button.html");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//button[@id='home']")).click();// button click
		driver.navigate().back();//bring back to the previous URL page
		
		//to get position of a web element
		WebElement position = driver.findElement(By.xpath("//button[@id='position']"));
		System.out.println("The position of button is " + position.getLocation());
		System.out.println("x Position " + position.getLocation().getX());
		System.out.println("y Position " + position.getLocation().getY());
		//to get a background color of an element
		String color = driver.findElement(By.xpath("//button[text()='What color am I?']"))
				.getCssValue("background-color");
		System.out.println("The color of the element is " + color);
		String colorText = driver.findElement(By.xpath("//button[text()='What color am I?']")).getAttribute("style");
		System.out.println(colorText);
		//to get a size of an element
		Dimension size = driver.findElement(By.xpath("//button[text()='What is my size?']")).getSize();
		System.out.println("The size of an element is " + size);
		int height = driver.findElement(By.xpath("//button[text()='What is my size?']")).getSize().getHeight();
		int width = driver.findElement(By.xpath("//button[text()='What is my size?']")).getSize().getWidth();
		System.out.println("The height of an element is " + height);
		System.out.println("The width of an element is " + width);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WorkWithButton wB = new WorkWithButton();
		wB.button();

	}

}
