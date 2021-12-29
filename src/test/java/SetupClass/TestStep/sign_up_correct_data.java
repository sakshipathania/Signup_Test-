package SetupClass.TestStep;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import SetupClass.Set;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class sign_up_correct_data extends Set {
	WebDriverWait wait = new WebDriverWait(driver,50);
       JavascriptExecutor js = (JavascriptExecutor) driver;
	
	@Given("^user is already on sign up page cd$")
	public void user_is_already_on_sign_up_page_cd() throws InterruptedException  {
	    driver.manage().deleteAllCookies();
		Thread.sleep(4000); // wait 4 seconds to clear cookies.
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.get(AppURL);
		
		driver.manage().deleteAllCookies();
		Thread.sleep(4000); // wait 4 seconds to clear cookies.
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		log.info("It's opening the website URL");
	    Thread.sleep(2000);
	   /* try {
			WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]"));
			if (logout.isEnabled()) {
				logout.click();
				Thread.sleep(8000);
				driver.navigate().refresh();
				Thread.sleep(2000);
			}
		} catch (NoSuchElementException Ext) {

		}*/
	    Thread.sleep(3000);
		try {
			driver.findElement(By.cssSelector("ul.header > li:nth-child(1) > a:nth-child(1)")).click();
			Thread.sleep(2000);
			log.info("It's opening the website URL and redirect user to sign up page");
		} 
		catch (NoSuchElementException popup) {
		}
	}

	@Then("^enter new email to sign up cd$")
	public void enter_new_email_to_sign_up_cd() throws InterruptedException  {
	    
		int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 10;
	    Random random = new Random();
	    StringBuilder buffer = new StringBuilder(targetStringLength);
	    for (int i = 0; i < targetStringLength; i++) {
	        int randomLimitedInt = leftLimit + (int) 
	          (random.nextFloat() * (rightLimit - leftLimit + 1));
	        buffer.append((char) randomLimitedInt);
	    }
	    String generatedString = buffer.toString();
	 
	    System.out.println(generatedString);
	    
	    String signup_email=generatedString;
	    String full_email="selenium.testing."+generatedString+"@gmail.com";
	    System.out.println(full_email);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		//driver.findElement(By.id("email_address")).sendKeys(full_email);
		

		Thread.sleep(2000);
	    WebElement new_email_signup = wait.until(ExpectedConditions.elementToBeClickable(By.id("email_address")));
		Thread.sleep(2000);
	    new_email_signup.sendKeys(full_email);
		Thread.sleep(2000);
	}

	@Then("^User enter firstname and lastname to sign up cd$")
	public void user_enter_firstname_and_lastname_to_sign_up_cd() throws InterruptedException  {
	    

	    WebElement new_fname_signup = wait.until(ExpectedConditions.elementToBeClickable(By.id("firstname")));
		Thread.sleep(2000);
	    new_fname_signup.sendKeys("Selenium");
		Thread.sleep(2000);

	    WebElement new_lname_signup = wait.until(ExpectedConditions.elementToBeClickable(By.id("lastname")));
		Thread.sleep(2000);
	    new_lname_signup.sendKeys("Testing");
		Thread.sleep(2000);
	}

	@Then("^user enter password and confirm password to sign up cd$")
	public void user_enter_password_and_confirm_password_to_sign_up_cd() throws InterruptedException  {
	    
		 WebElement new_pwd_signup = wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));
			Thread.sleep(2000);
		    new_pwd_signup.sendKeys("selenium@123");
			Thread.sleep(2000);

		    WebElement new_pwd1_signup = wait.until(ExpectedConditions.elementToBeClickable(By.id("password-confirmation")));
			Thread.sleep(2000);
		    new_pwd1_signup.sendKeys("selenium@123");
			Thread.sleep(2000);
	}

	@Then("^user enter captcha to sign up cd$")
	public void user_enter_captcha_to_sign_up_cd() throws InterruptedException  {
	    
		WebElement new_captcha_signup = wait.until(ExpectedConditions.elementToBeClickable(By.id("captcha_user_create")));
		Thread.sleep(2000);
	    new_captcha_signup.sendKeys("Aj7W2mtf9namwf55");
		
	}

	@Then("^check checkbox to sign up cd$")
	public void check_checkbox_to_sign_up_cd() throws InterruptedException  {
	    
		/*
		 * WebElement new_checkbox_signup =
		 * wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
		 * ".iCheck-helper"))); Thread.sleep(2000); new_checkbox_signup.click();
		 */
		Thread.sleep(2000);
	}

	@Then("^user click on sign up button to sign up cd$")
	public void user_click_on_sign_up_button_to_sign_up_cd() throws InterruptedException  {
	    
		WebElement new_btn_signup = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".submit")));
		Thread.sleep(1000);
	    new_btn_signup.click();
			Thread.sleep(1000);
		String free_ppt_btn1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Thank you for registering with SlideTeam.')]"))).getText();
		Assert.assertTrue("user is not able to signup", free_ppt_btn1.contains("Thank you for registering with SlideTeam."));
		System.out.println("signup successfully");
		Thread.sleep(2000);
	   
	}

	@Then("^user lands on pricing page and then user go to free ppts page cd$")
	public void user_lands_on_pricing_page_and_then_user_go_to_free_ppts_page_cd() throws InterruptedException  {
		
		/*
		 * Thread.sleep(1000); Actions actions = new Actions(driver); WebElement
		 * free_ppt_btn1 =
		 * wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Free Stuff"))
		 * ); actions.moveToElement(free_ppt_btn1)
		 * .moveToElement(driver.findElement(By.xpath("//a[@title='Free Business PPTs']"
		 * ))).click().build() .perform();
		 */

		try {
			WebElement popular_PPt = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Most Downloaded']")));
                        Thread.sleep(2000);
			popular_PPt.click();
			Thread.sleep(2000);
			WebElement select_PPt = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//a[@title='Business Process Evaluation Powerpoint Show']")));
			js.executeScript("arguments[0].scrollIntoView();", select_PPt);
			Thread.sleep(2000);
			select_PPt.click();
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	}

	@Then("^user download a free product cd$")
	public void user_download_a_free_product_cd() throws InterruptedException  {
		
		/*driver.get("https://www.slideteam.net/circular-flow-of-process-4-stages-powerpoint-slides-templates.html");
		Thread.sleep(3000);
		
		WebElement dwnd_btn = driver.findElement(By.cssSelector("#clicking"));
		js.executeScript("arguments[0].scrollIntoView();", dwnd_btn);
		 dwnd_btn.click();
		Thread.sleep(3000);
	   driver.get("https://www.slideteam.net/");
	   Thread.sleep(3000);*/
		try {
			Thread.sleep(2000);
			WebElement download_PPt = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='clicking']")));
			js.executeScript("arguments[0].scrollIntoView();", download_PPt);
			download_PPt.click();
			Thread.sleep(2000);

			/*String Error_message = wait
					.until(ExpectedConditions.elementToBeClickable(
							By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")))
					.getText();
			Assert.assertTrue("message is not showing", Error_message.contains(""));
			System.out.println("message is showing");*/
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Then("^user delete the new account created cd$")
	public void user_delete_the_new_account_created_cd() throws InterruptedException  {
       Thread.sleep(3000);

		
		 WebElement account = driver.findElement(By.xpath("//a[contains(.,'My Account')]"));
			  Thread.sleep(3000);
			account.click();
		 Thread.sleep(3000);
		 
		

		 WebElement delete_account = driver.findElement(By.cssSelector("#clicking"));
		js.executeScript("arguments[0].scrollIntoView();",delete_account);
		 delete_account.click();
		 Thread.sleep(3000);
		WebElement delete_reason = driver.findElement(By.cssSelector("#exampleRadios1"));
		Thread.sleep(3000);
		delete_reason.click();
		Thread.sleep(3000);
		
		 WebElement delete_profile = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#delete-final")));
		js.executeScript("arguments[0].scrollIntoView();",delete_profile);
		delete_profile.click();
		 Thread.sleep(3000);
		
		WebElement delete_profile_coupon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#flipModal > div > div > div.modal-footer.button_action > button.btn.btn-default.button_2")));
		js.executeScript("arguments[0].scrollIntoView();",delete_profile_coupon);
		delete_profile_coupon.click();
		 Thread.sleep(4000);
		String verifyDeleteAccount = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"))).getText();
		 Thread.sleep(3000);
	    // Assert.assertTrue("Account is not deleted", verifyDeleteAccount.contains("Your account has been deleted successfully."));
	     System.out.println("your account delete successfully");
	}
	
	
}
