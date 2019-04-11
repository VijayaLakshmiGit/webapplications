package mysamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ECommerceLoginTest_Ng {
	WebDriver driver = null;

	@BeforeMethod
	public void TestBefore() {
		// create the web driver
		System.setProperty("webdriver.gecko.driver", "C:\\users\\anu3p\\geckodriver.exe");
		driver = new FirefoxDriver();
		// open the page
		driver.get("http://ecommerce.saipratap.net/customerlogin.php");
	}

	@Test
	public void TestWithNoPwd() throws InterruptedException {
		// Step 3 identify the elements and set the data
		driver.findElement(By.name("email")).sendKeys("anu.vijji3@gmail.com");
		// Step 4 -perform action driver.findElement(By.name("email")).click();
		// driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.xpath("//a[@class='continue']/div")).click();
		Thread.sleep(5000);
		String Message = driver.findElement(By.className("msg")).getText();
		System.out.println("%&&&&&&&&&&$$&$&$&$" + Message);
		Assert.assertEquals(Message, "Invalid Username / Password!");

	}

	@Test
	public void TestWithWrongEmail() throws InterruptedException { //
		// Step 3 -identify the elements and set the data
		driver.findElement(By.name("email")).sendKeys("tester@gmail.com");
		driver.findElement(By.name("password")).sendKeys("anusha");
		// Step -perform action
		driver.findElement(By.name("email")).click();
		// driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.xpath("//a[@class='continue']/div")).click();
		Thread.sleep(5000);
		String Message = driver.findElement(By.className("msg")).getText();
		System.out.println("%&&&&&&&&&&$$&$&$&$" + Message);
		Assert.assertEquals(Message, "Invalid Username / Password!");

	}

	@Test
	public void TestWithCorrectEmailWrongPwd() throws InterruptedException { // Step
																				// 3
																				// -identify
																				// the
																				// elements
																				// and
																				// set
																				// the
																				// data
		driver.findElement(By.name("email")).sendKeys("anu.vijji3@gmail.com");
		driver.findElement(By.name("password")).sendKeys("password");
		// Step 4-perform action
		driver.findElement(By.name("email")).click(); //
		// driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.xpath("//a[@class='continue']/div")).click();
		Thread.sleep(5000);
		String Message = driver.findElement(By.className("msg")).getText();
		System.out.println("%&&&&&&&&&&$$&$&$&$" + Message);
		Assert.assertEquals(Message, "Invalid Username / Password!");
	}

	@Test
	public void TestWithWrongEmailAndPwd() throws InterruptedException { // Step
																			// 3
																			// -identify
																			// the
																			// elements
																			// and
																			// set
																			// the
																			// data
		driver.findElement(By.name("email")).sendKeys("tester@gmail.com");
		driver.findElement(By.name("password")).sendKeys("password");
		// Step 4-perform action
		driver.findElement(By.name("email")).click(); //
		// driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.xpath("//a[@class='continue']/div")).click();
		Thread.sleep(5000);
		String Message = driver.findElement(By.className("msg")).getText();
		System.out.println("%&&&&&&&&&&$$&$&$&$" + Message);
		Assert.assertEquals(Message, "Invalid Username / Password!");
	}

	@Test
	public void TestWithEmptyEmailAndPwd() throws InterruptedException { // Step
																			// 3
																			// -identify
																			// the
																			// elements
																			// and
																			// set
																			// the
																			// data
		driver.findElement(By.name("email")).sendKeys("");
		driver.findElement(By.name("password")).sendKeys("");
		// Step 4 -performaction
		driver.findElement(By.name("email")).click(); //
		// driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.xpath("//a[@class='continue']/div")).click();
		Thread.sleep(5000);
		String Message = driver.findElement(By.className("msg")).getText();
		System.out.println("%&&&&&&&&&&$$&$&$&$" + Message);
		Assert.assertEquals(Message, "Invalid Username / Password!");
	}

	@Test
	public void TestForLogout() throws InterruptedException {
		// Step 3 -identify the elements and set the data
		driver.findElement(By.name("email")).sendKeys("anu.vijji3@gmail.com");
		driver.findElement(By.name("password")).sendKeys("anusha");
		// Step 4 -perform action
		driver.findElement(By.name("email")).click();
		// driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.xpath("//a[@class='continue']/div")).click();
		Thread.sleep(5000);
		driver.findElement(By.className("navigation")).click();
		String Message = driver.findElement(By.className("welcome")).getText();
		System.out.println("%&&&&&&&&&&$$&$&$&$" + Message);
		Assert.assertEquals(Message, "Welcome to Ez Shop Online");
	}

	@Test
	public void TestMaskedPassword() throws InterruptedException {
		// Step 3 -identify the elements and set the data
		driver.findElement(By.name("email")).sendKeys("anu.vijji3@gmail.com");
		driver.findElement(By.name("password")).sendKeys("anusha");
		WebElement input = driver.findElement(By.id("password"));
		boolean isEncrypted = input.getAttribute("type").equals("password");

	}

	@Test
	public void TestWithCorrectValues() throws InterruptedException {
		// Step 3 -identify the elements and set the data
		driver.findElement(By.name("email")).sendKeys("anu.vijji3@gmail.com");
		driver.findElement(By.name("password")).sendKeys("anusha");
		// Step 4 -perform action
		driver.findElement(By.name("email")).click();
		// driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.xpath("//a[@class='continue']/div")).click();
		Thread.sleep(5000);
		String Message = driver.findElement(By.className("fntstyle")).getText();
		System.out.println("%&&&&&&&&&&$$&$&$&$" + Message);
		Assert.assertEquals(Message, "You have Logged In successfully.");

	}

	@AfterMethod
	public void Clenup() {
		driver.close();
	}

}