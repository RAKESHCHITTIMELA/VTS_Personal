package vts.listeners;

import io.appium.java_client.MobileBy;
import vts.basetest.TestBase;
import vts.utils.Keywords;

public class Feedback extends TestBase {

	Listeners ls = new Listeners();
	Keywords keywords = new Keywords();

	public boolean givefeedback(Object uname, Object pwd, Object rating, Object feedback) throws InterruptedException {

//		ls.login(uname, pwd);
//		driver.findElementById("com.affluencesystems.admin:id/menu_img").click();
//		driver.findElementById("com.affluencesystems.admin:id/back_button").click();
		keywords.goToMenu();

		Thread.sleep(10000);
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
				+ ".scrollIntoView(new UiSelector().resourceIdMatches(\"com.affluencesystems.admin:id/feedback\"))"));
		driver.findElementById("com.affluencesystems.admin:id/feedback").click();
		Thread.sleep(2000);
		driver.findElementById("com.affluencesystems.admin:id/rating_bar").click();
		
		driver.findElementById("com.affluencesystems.admin:id/rating_bar").sendKeys(String.valueOf(rating));
		Thread.sleep(2000);
		driver.findElementById("com.affluencesystems.admin:id/tv_description").sendKeys(String.valueOf(feedback));
		Thread.sleep(2000);
		driver.findElementById("com.affluencesystems.admin:id/submit").click();
		Thread.sleep(2000);
		
		if (driver.findElementById("com.affluencesystems.admin:id/feedback").isDisplayed()) {
			return true;
		} else {
			return false;
		}


	}

	public boolean writeissue(Object issue) throws InterruptedException {
		
		driver.findElementById("com.affluencesystems.admin:id/feedback").click();
		driver.findElementById("com.affluencesystems.admin:id/issue_type").click();
		Thread.sleep(2000);
		driver.findElementById("com.affluencesystems.admin:id/tv_description").sendKeys(String.valueOf(issue));
		Thread.sleep(2000);
		driver.findElementById("com.affluencesystems.admin:id/submit").click();
		Thread.sleep(2000);
		if (driver.findElementById("com.affluencesystems.admin:id/feedback").isDisplayed()) {
			return true;
		} else {
			return false;
		}


		
	}
	
}
