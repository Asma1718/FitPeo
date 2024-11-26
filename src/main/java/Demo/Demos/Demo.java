package Demo.Demos;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Demo {

	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		// Launching URL
		driver.get("https://www.fitpeo.com/");
		String title = driver.getTitle();
		System.out.println("Title displayed is: "+title);
		Thread.sleep(10000);
		
		//navigating to revenue calculator page
		driver.navigate().to("https://fitpeo.com/revenue-calculator");

		
		WebElement element = driver
				.findElement(By.xpath("//span[@class='MuiTypography-root MuiTypography-caption inter css-43plts']"));
		
		// Scroll down to scroll element using Actions
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
		Thread.sleep(2000);
		
		// moving cursor to position of 820
		WebElement slider = driver.findElement(By.xpath("//input[@data-index='0']"));
		Actions action = new Actions(driver);
		action.dragAndDropBy(slider, 94, 0).perform();
		System.out.println("successfully moved slider to position 820");
		Thread.sleep(1000);
		
		// clearing input field before typing
		WebElement inputField = driver.findElement(By.xpath("//input[@id=':R57alklff9da:']"));
		inputField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		inputField.sendKeys(Keys.BACK_SPACE);

		// Enter new text
		inputField.sendKeys("560");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id=':R57alklff9da:']")).sendKeys("560");
		Thread.sleep(2000);
		
		WebElement value = driver.findElement(By.xpath("//input[@data-index='0']"));
		String val = value.getAttribute("value").trim();
		System.out.println(val);
		
		//verifying 560 is displayed in scroll
		if (val.equals("560")) {
			System.out.println("successfully displayed: " + val);
		}
		Thread.sleep(1000);

		//clearing field before entering 820
		WebElement inputFields = driver.findElement(By.xpath("//input[@id=':R57alklff9da:']"));
		inputFields.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		inputFields.sendKeys(Keys.BACK_SPACE);

		// Enter new text
		inputFields.sendKeys("820");
		Thread.sleep(2000);
		WebElement values = driver.findElement(By.xpath("//input[@data-index='0']"));
		String val1 = values.getAttribute("value").trim();
		System.out.println("Successfully displayed: " + val1);

		//scrolling check boxes into view before clicking on them
		WebElement element1 = driver.findElement(By.xpath("//p[text()='CPT-99091']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element1);
		System.out.println("Scrolled to the Check box element");

		//Taking List of elements for check boxes
		List<WebElement> eles = driver
				.findElements(By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 inter css-1s3unkt' and "
						+ "(text()='CPT-99091' or text()='CPT-99453' or text()='CPT-99454' or text()='CPT-99474')])/..//input"));

		//Iterating all elements and performing click action
		for (WebElement ele : eles) {
			js.executeScript("arguments[0].scrollIntoView(true);", ele);
			System.out.println("Scrolled to the Check box ele");

			js.executeScript("arguments[0].click();", ele);
			System.out.println("clicked on checkbox");
			Thread.sleep(2000);
		}
		
		// getting the text to validate
		String reimbursement = driver.findElement(By.xpath("//p[contains(text(),'Total Recurring Reimbursement')]")).getText();
		System.out.println(reimbursement);

		// Verifying text 
		if (reimbursement.contains("Total Recurring Reimbursement for all Patients Per Month:")) {
			System.out.println(
					"Total Recurring Reimbursement for all Patients Per Month: " + "is displayed successfully");
		} else {
			System.out.println("Total Recurring Reimbursement for all Patients Per Month: " + "not displayed");
		}
		if (reimbursement.contains("$110700")) {
			System.out.println("$110700 " + "is displayed successfully");
		} else {
			System.out.println("$110700 " + "not displayed");
		}
		//closing the driver
		driver.quit();
		

	}

}
