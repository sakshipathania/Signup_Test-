package SetupClass.TestStep;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SetupClass.SetClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Non_Logged_In_User extends SetClass {

	@Given("^user is already on PDP Page MD viii$")
	public void user_is_already_on_PDP_Page_MD_viii() throws Throwable {

		driver.get("https://www.slideteam.net/");
		ClearBrowserCache();
		Thread.sleep(2000);
		WebElement popularPPTs = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Most Downloaded']")));
		popularPPTs.click();

		WebElement selectPPt = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[2]/div[1]/div[4]/div[1]/ol[1]/li[1]/div[1]/a[1]/img[1]")));
		selectPPt.click();

	}

	@Then("^User click on Download button to download the product viii$")
	public void User_click_on_Download_button_to_download_the_product_viii() throws Throwable {

		WebElement download_btn_pdp_fp = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[normalize-space()='Download this presentation']")));
		js.executeScript("arguments[0].scrollIntoView();", download_btn_pdp_fp);
		Thread.sleep(2000);
		download_btn_pdp_fp.click();

		Thread.sleep(4000);

	}

	@Then("^user is redirected to Login page viii$")
	public void user_is_redirected_to_Login_page_viii() throws Throwable {

		WebElement Sign_Up = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign up")));
		Thread.sleep(2000);
		Sign_Up.click();
		Thread.sleep(2000);
	}

	@Then("^user sign up with correct details viii$")
	public void user_sign_up_with_correct_details_viii() throws Throwable {
		Thread.sleep(2000);
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 10;
		Random random = new Random();
		StringBuilder buffer = new StringBuilder(targetStringLength);
		for (int i = 0; i < targetStringLength; i++) {
			int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
			buffer.append((char) randomLimitedInt);
		}
		String generatedString = buffer.toString();

		System.out.println(generatedString);

		String signup_email = generatedString;
		String full_email = "selenium.testing." + generatedString + "@gmail.com";
		System.out.println(full_email);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.findElement(By.id("email_address")).sendKeys(full_email);

		Thread.sleep(2000);
		/*
		 * WebElement new_email_signup =
		 * wait.until(ExpectedConditions.elementToBeClickable(By.
		 * xpath("//input[@title= 'Email Address']"))); Thread.sleep(2000);
		 * new_email_signup.sendKeys(full_email); Thread.sleep(2000);
		 * 
		 * WebElement new_fname_signup =
		 * wait.until(ExpectedConditions.elementToBeClickable(By.
		 * xpath("//input[@title= 'First Name']"))); Thread.sleep(2000);
		 * new_fname_signup.sendKeys("Selenium"); Thread.sleep(2000);
		 * 
		 * WebElement new_lname_signup =
		 * wait.until(ExpectedConditions.elementToBeClickable(By.
		 * xpath("//input[@title= 'Last Name']"))); Thread.sleep(2000);
		 * new_lname_signup.sendKeys("Testing"); Thread.sleep(2000);
		 * 
		 * WebElement new_pwd_signup =
		 * wait.until(ExpectedConditions.elementToBeClickable(By.
		 * xpath("//input[@class= 'input-text popupform-pass']"))); Thread.sleep(2000);
		 * new_pwd_signup.sendKeys("selenium@123"); Thread.sleep(2000);
		 * 
		 * 
		 * WebElement new_captcha_signup =
		 * wait.until(ExpectedConditions.elementToBeClickable(By.
		 * xpath("//input[@name= 'captcha[downloadable_ajax_loginform]']")));
		 * Thread.sleep(2000); new_captcha_signup.sendKeys("Aj7W2mtf9namwf55");
		 * 
		 * WebElement new_btn_signup =
		 * wait.until(ExpectedConditions.elementToBeClickable(By.
		 * xpath("//button[@title= 'Sign UP']"))); Thread.sleep(2000);
		 * new_btn_signup.click(); Thread.sleep(3000);
		 */

		// login popup not appear
		Thread.sleep(2000);
		WebElement new_email_signup = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='email_address']")));
		Thread.sleep(2000);
		new_email_signup.sendKeys(full_email);
		Thread.sleep(2000);

		// enter name

		WebElement new_fname_signup = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='firstname']")));
		Thread.sleep(2000);
		new_fname_signup.sendKeys("Selenium");
		Thread.sleep(2000);

		WebElement new_lname_signup = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='lastname']")));
		Thread.sleep(2000);
		new_lname_signup.sendKeys("Testing");
		Thread.sleep(2000);

		// enter password
		WebElement new_pwd_signup = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='password']")));
		Thread.sleep(2000);
		new_pwd_signup.sendKeys("selenium@123");
		Thread.sleep(2000);

		WebElement new_pwd1_signup = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='password-confirmation']")));
		Thread.sleep(2000);
		new_pwd1_signup.sendKeys("selenium@123");
		Thread.sleep(3000);
		WebElement new_btn_signup = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Sign Up']")));
		Thread.sleep(2000);
		new_btn_signup.click();
		Thread.sleep(2000);

	}

	@Then("^user will be redirected to same pdp page viii$")
	public void user_will_be_redirected_to_same_pdp_page_viii() throws Throwable {

	}

	@Then("^user download the product viii$")
	public void user_download_the_product_viii() throws Throwable {

		Thread.sleep(3000);
		WebElement popularPPTs = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Most Downloaded']")));
		popularPPTs.click();
		Thread.sleep(3000);
		WebElement selectPPt = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[2]/div[1]/div[4]/div[1]/ol[1]/li[1]/div[1]/a[1]/img[1]")));
		selectPPt.click();
		Thread.sleep(3000);
		WebElement download_btn_pdp = wait.until(ExpectedConditions.elementToBeClickable(By.id("clicking")));
		js.executeScript("arguments[0].scrollIntoView();", download_btn_pdp);
		Thread.sleep(2000);
		download_btn_pdp.click();
		Thread.sleep(2000);

		// user should be on pricing page.
		String expected_url = "https://www.slideteam.net/pricing";
		Thread.sleep(3000);
		String actual_URL = driver.getCurrentUrl();
		System.out.println("Title = " + actual_URL);
		Assert.assertEquals("url does not match", expected_url, actual_URL);

	}

	@Then("^user logout from website viii$")
	public void user_logout_from_website_viii() throws Throwable {

		Thread.sleep(3000);

		WebElement account = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'My Account')]")));
		js.executeScript("arguments[0].click();", account);
		Thread.sleep(3000);
		chatWindow();
		WebElement delete_account = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='clicking']")));
		Thread.sleep(3000);
		// js.executeScript("arguments[0].scrollIntoView();", delete_account);
		js.executeScript("arguments[0].click();", delete_account);

		Thread.sleep(3000);
		boolean deletePopUp = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#exampleRadios1")))
				.isDisplayed();
		Assert.assertTrue("Delete pop-up was not dispalyed", deletePopUp);
		WebElement delete_reason = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#exampleRadios1")));
		Thread.sleep(3000);
		delete_reason.click();
		Thread.sleep(3000);

		WebElement delete_profile = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button#delete-final")));
		delete_profile.click();
		Thread.sleep(3000);

		WebElement delete_profile_coupon = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//button[@class = 'btn btn-default button_2']")));
		delete_profile_coupon.click();
		Thread.sleep(30000);
		String verifyDeleteAccount = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@x-html='message.text']"))).getText();
		Thread.sleep(3000);
		Assert.assertTrue("Account is not deleted",
				verifyDeleteAccount.contains("Your account has been deleted successfully."));
		System.out.println("your account delete successfully");

	}
}
