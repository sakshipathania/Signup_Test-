package SetupClass.TestStep;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import SetupClass.SetClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class sign_up_correct_data extends SetClass {

	@Given("^user is already on sign up page cd$")
	public void user_is_already_on_sign_up_page_cd() throws Throwable {
		driver.get(AppURL);
		ClearBrowserCache();
		Thread.sleep(3000);
		try {
			driver.findElement(By.cssSelector("ul.header > li:nth-child(1) > a:nth-child(1)")).click();
			Thread.sleep(2000);
			log.info("It's opening the website URL and redirect user to sign up page");
		} catch (NoSuchElementException popup) {
		}
	}

	@Then("^enter new email to sign up cd$")
	public void enter_new_email_to_sign_up_cd() throws InterruptedException {

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
		System.out.println("Email ID = " + full_email);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.findElement(By.id("email_address")).sendKeys(full_email);

		Thread.sleep(2000);
		WebElement new_email_signup = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='email_address']")));
		Thread.sleep(2000);
		new_email_signup.sendKeys(full_email);
		Thread.sleep(2000);
	}

	@Then("^User enter firstname and lastname to sign up cd$")
	public void user_enter_firstname_and_lastname_to_sign_up_cd() throws InterruptedException {

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
	}

	@Then("^user enter password and confirm password to sign up cd$")
	public void user_enter_password_and_confirm_password_to_sign_up_cd() throws InterruptedException {

		WebElement new_pwd_signup = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='password']")));
		Thread.sleep(2000);
		new_pwd_signup.sendKeys("selenium@123");
		Thread.sleep(2000);

		WebElement new_pwd1_signup = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='password-confirmation']")));
		Thread.sleep(2000);
		new_pwd1_signup.sendKeys("selenium@123");
		Thread.sleep(2000);
	}

	@Then("^user enter captcha to sign up cd$")
	public void user_enter_captcha_to_sign_up_cd() throws InterruptedException {

		/*
		 * WebElement new_captcha_signup = wait
		 * .until(ExpectedConditions.elementToBeClickable(By.id("captcha_user_create")))
		 * ; Thread.sleep(2000); new_captcha_signup.sendKeys("Aj7W2mtf9namwf55");
		 */
	}

	@Then("^check checkbox to sign up cd$")
	public void check_checkbox_to_sign_up_cd() throws InterruptedException {

		/*
		 * WebElement new_checkbox_signup =
		 * wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
		 * ".iCheck-helper"))); Thread.sleep(2000); new_checkbox_signup.click();
		 */
		Thread.sleep(2000);
	}

	@Then("^user click on sign up button to sign up cd$")
	public void user_click_on_sign_up_button_to_sign_up_cd() throws InterruptedException {

		WebElement new_btn_signup = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Sign Up']")));
		Thread.sleep(2000);
		new_btn_signup.click();

		Thread.sleep(5000);

	}

	@Then("^user lands on pricing page and then user go to free ppts page cd$")
	public void user_lands_on_pricing_page_and_then_user_go_to_free_ppts_page_cd() throws InterruptedException {

		try {
			WebElement popular_PPt = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Most Downloaded']")));
			Thread.sleep(2000);
			popular_PPt.click();
			Thread.sleep(2000);
			WebElement select_PPt = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//div[4]/div[1]/ol[1]/li[4]/div[1]/a[1]/img[1]")));
			js.executeScript("arguments[0].scrollIntoView();", select_PPt);
			Thread.sleep(2000);
			//select_PPt.click();
			js.executeScript("arguments[0].click();", select_PPt);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("^user download a free product cd$")
	public void user_download_a_free_product_cd() throws InterruptedException {

		try {
			Thread.sleep(2000);
			WebElement download_PPt = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='clicking']")));
			js.executeScript("arguments[0].scrollIntoView();", download_PPt);
			download_PPt.click();
			Thread.sleep(5000);

			// user should be on pricing page.
			String expected_url = "https://www.slideteam.net/pricing";
			Thread.sleep(3000);
			String actual_URL = driver.getCurrentUrl();
			System.out.println("Title = " + actual_URL);
			Assert.assertEquals("url does not match", expected_url, actual_URL);

		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("^user delete the new account created cd$")
	public void user_delete_the_new_account_created_cd() throws InterruptedException {
		Thread.sleep(3000);

		WebElement account = driver.findElement(By.xpath("//a[contains(.,'My Account')]"));
		Thread.sleep(3000);
		account.click();
		Thread.sleep(8000);

		WebElement delete_account = driver.findElement(By.cssSelector("#clicking"));
		js.executeScript("arguments[0].scrollIntoView();", delete_account);
		delete_account.click();
		Thread.sleep(3000);
		WebElement delete_reason = driver.findElement(By.cssSelector("#exampleRadios1"));
		Thread.sleep(3000);
		delete_reason.click();
		Thread.sleep(3000);

		WebElement delete_profile = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#delete-final")));
		js.executeScript("arguments[0].scrollIntoView();", delete_profile);
		delete_profile.click();
		Thread.sleep(3000);

		WebElement delete_profile_coupon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
				"#flipModal > div > div > div.modal-footer.button_action > button.btn.btn-default.button_2")));
		js.executeScript("arguments[0].scrollIntoView();", delete_profile_coupon);
		//delete_profile_coupon.click();
		Thread.sleep(3000);
		String verifyDeleteAccount = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@x-html='message.text']"))).getText();
		Thread.sleep(3000);
		Assert.assertTrue("Account is not deleted",
				verifyDeleteAccount.contains("Your account has been deleted successfully."));
		System.out.println("your account delete successfully");
	}

}
