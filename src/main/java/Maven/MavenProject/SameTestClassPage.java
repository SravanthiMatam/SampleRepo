package Maven.MavenProject;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SameTestClassPage {
	WebDriver driver;
	public SameTestClassPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(id = "user-name")
	WebElement username_id;

	@FindBy(id = "password")
	WebElement password_id;

	@FindBy(id = "login-button")
	WebElement login_id;

	@FindBy(xpath = "(//*[contains(@id,'add-to-cart')])")
	WebElement add_to_cart;

	@FindBy(xpath = "//*[@class='shopping_cart_link']")
	WebElement click_cart;

	@FindBy(xpath = "(//*[contains(@id,'remove-sauce-labs')])[2]")
	WebElement remove_second_item;

	@FindBy(id = "checkout")
	WebElement checkout;

	@FindBy(id = "first-name")
	WebElement first_name;

	@FindBy(id = "last-name")
	WebElement last_name;

	@FindBy(id = "postal-code")
	WebElement postal_code;

	@FindBy(id = "continue")
	WebElement continueButton;

	@FindBy(xpath = "(//*[@class='inventory_item_price'])[1]")
	WebElement item1price;

	@FindBy(xpath = "(//*[@class='inventory_item_price'])[2]")
	WebElement item2price;

	@FindBy(id = "finish")
	WebElement finishButton;

	@FindBy(xpath = "//*[@class='complete-header']")
	WebElement Thankyou_Header;

	@FindBy(xpath = "//div[@class='complete-text']")
	WebElement subHeaderText;

	@FindBy(xpath = "//div[@class='error-message-container error']")
	WebElement error_message;

	
	public void enterUsername(String username) {
		username_id.sendKeys(username);
	}

	public void enterPassword() {
		password_id.sendKeys("secret_sauce");
	}

	public void login() {
		login_id.click();
	}

	public void addToCart() {
		for (int i = 1; i <= 3; i++) {
			String xPathWithVariable = "(//*[contains(@id,'add-to-cart')])" + "[" + i + "]";
			driver.findElement(By.xpath(xPathWithVariable)).click();

		}
	}

	public void clickCart() {
		click_cart.click();
	}

	public void removeItem() {
		remove_second_item.click();
	}

	public void clickCheckout() {
		checkout.click();
	}

	public void enterFirstName(String firstname) {
		first_name.sendKeys(firstname);
	}

	public void enterLastName(String lastname) {
		last_name.sendKeys(lastname);
	}

	public void enterPostalCode(String postalcode) {
		postal_code.sendKeys(postalcode);
	}

	public void clickContinue() {
		continueButton.click();
	}

	public String actualItem1price() {

		String item1 = item1price.getText();
		return item1;

	}

	public String actualItem2price() {
		String item2 = item2price.getText();
		return item2;
	}

	public void clickFinish() {
		finishButton.click();
	}

	public String thankyouHeader() {
		String headerText = Thankyou_Header.getText();
		return headerText;
	}

	public String subHeaderText() {
		String subheaderText = subHeaderText.getText();
		return subheaderText;
	}

	public boolean verifyImage() {
		WebElement i = driver.findElement(By.xpath("//img[@alt='Pony Express']"));
		Boolean p = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete "
				+ "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0", i);
		if (p) {
			System.out.println("Logo present");
		} else {
			System.out.println("Logo not present");
		}
		return p;
	}

	public String errorMessage() {
		String errorMessage = error_message.getText();
		return errorMessage;
	}
}
