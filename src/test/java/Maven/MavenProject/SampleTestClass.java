package Maven.MavenProject;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SampleTestClass {
	String driverPath = "C:\\Users\\matam.sravanthi\\chromedriver_win32\\chromedriver.exe";
	WebDriver driver;
	SameTestClassPage pageClass;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		pageClass = new SameTestClassPage(driver);
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
	}

	@Test
	public void autoQuesOne() {
		pageClass.enterUsername("standard_user");
		pageClass.enterPassword();
		pageClass.login();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		pageClass.addToCart();
		pageClass.clickCart();
		pageClass.removeItem();
		String expectedItem1Price = pageClass.actualItem1price();
		String expectedItem2Price = pageClass.actualItem2price();
		pageClass.clickCheckout();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		pageClass.enterFirstName("Sravanthi");
		pageClass.enterLastName("Matam");
		pageClass.enterPostalCode("502319");
		pageClass.clickContinue();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		Assert.assertEquals(pageClass.actualItem1price(), expectedItem1Price);
		Assert.assertEquals(pageClass.actualItem2price(), expectedItem2Price);
		pageClass.clickFinish();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		Assert.assertEquals(pageClass.thankyouHeader(), "THANK YOU FOR YOUR ORDER");
		Assert.assertEquals(pageClass.subHeaderText(), "Your order has been dispatched, and will arrive just as fast as the pony can get there!");
		Assert.assertTrue(pageClass.verifyImage());
	}
	
	@Test
	public void autoQuesTwo(){
	pageClass.enterUsername("locked_out_user");
	pageClass.enterPassword();
	pageClass.login();
	Assert.assertEquals(pageClass.errorMessage(),"Epic sadface: Sorry, this user has been locked out.");
	}

	@AfterMethod
	public void quit() {
		driver.quit();
	}

}
