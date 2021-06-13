
//EXPLICIT METHOD
package Module10;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Explicit77 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\\\selenium_driver\\\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		
		//implicit declare globally
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//EXPLICIT WAIT
		WebDriverWait w = new WebDriverWait(driver, 5);
		
		
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		// array
		String[] itemsNeeded = { "Cucumber", "Brocolli", "Beetroot" };

		// xpth based on text
		Thread.sleep(2000L);
		addItem(driver, itemsNeeded);
		
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		//explicit wait until the promo code load
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
	
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		//click on apply button
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		//EXPLIXIT WAIT method
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		
		
		
	}

	public static void addItem(WebDriver driver, String[] itemsNeeded) {
		int j = 0;
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < products.size(); i++) {
			// Brocolli - 1 Kg
			// Brocolli , 1 Kg

			String[] name = products.get(i).getText().split("-");
			String formattedNameString = name[0].trim();

			// format to get actually vegetable name

			// convert array into arrayList.
			// check whether name you entered is present in arrayList or not

			List itemNeddedList = Arrays.asList(formattedNameString);

			if (itemNeddedList.contains(formattedNameString)) {
				j++;
				// click on add to cart

				// driver.findElements(By.xpath("//button[text()='ADD TO
				// CART']")).get(i).click(); it doesnt work beacuse it is dynamic

				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				// 3 times

				if (j == itemsNeeded.length) {
					break;
				}

			}

		}
	}

}
