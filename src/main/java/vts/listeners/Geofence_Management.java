package vts.listeners;

import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import vts.basetest.TestBase;

public class Geofence_Management extends TestBase {

	Listeners ls = new Listeners();
	

	public boolean createRadiusGeofence(Object uname, Object pwd, Object radiusfencename, Object fenceradius)
			throws InterruptedException {
//
//		ls.login(uname, pwd);
//		driver.findElementById("com.affluencesystems.admin:id/menu_img").click();
//		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
//				+ ".scrollIntoView(new UiSelector().resourceIdMatches(\"com.affluencesystems.admin:id/settings_card\"))"));
//
//		driver.findElementById("com.affluencesystems.admin:id/settings_card").click();
		Thread.sleep(10000); 
		driver.findElementById("com.affluencesystems.admin:id/card_config").click();

		driver.findElementById("com.affluencesystems.admin:id/no_of_fences").click();
		driver.findElementById("com.affluencesystems.admin:id/floating_action_text_add").click();
		Thread.sleep(5000);

		driver.findElementById("com.affluencesystems.admin:id/create").click();
		Thread.sleep(2000);
		PointOption point = new PointOption();
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(PointOption.point(706, 1426)).release().perform();
		Thread.sleep(2000);
		driver.findElementById("com.affluencesystems.admin:id/done").click();
		driver.findElementById("com.affluencesystems.admin:id/et_fence_name").sendKeys(String.valueOf(radiusfencename));
		driver.findElementById("com.affluencesystems.admin:id/radius").sendKeys(String.valueOf(fenceradius));
		driver.findElementById("com.affluencesystems.admin:id/ok").click();
		Thread.sleep(2000);

		WebElement createdgeofence = driver
				.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
						+ ".scrollIntoView(new UiSelector().text(\"" + radiusfencename + "\"))"));

		if (createdgeofence.isDisplayed()) {
			driver.findElementById("com.affluencesystems.admin:id/enterted_fence").sendKeys(String.valueOf(radiusfencename));;

			driver.findElementById("com.affluencesystems.admin:id/fencename").click();
			Thread.sleep(8000);
			driver.findElementById("com.affluencesystems.admin:id/back_button").click();

			System.out.println("New Radius Geofence created successfully");
			return true;
		} else {
			System.out.println("New Radius Geofence creation failed");

			return false;
		}

	}

	
	
	public boolean createCustomGeofence(Object customfencename) throws InterruptedException {

		driver.findElementById("com.affluencesystems.admin:id/floating_action_text_add").click();
		Thread.sleep(5000);

		driver.findElementById("com.affluencesystems.admin:id/custom").click();
		Thread.sleep(2000);
		driver.findElementById("com.affluencesystems.admin:id/create").click();
		Thread.sleep(2000);
		PointOption point = new PointOption();
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(PointOption.point(414, 1548)).release().perform();
		Thread.sleep(2000);
		touchAction.tap(PointOption.point(409, 1285)).release().perform();
		Thread.sleep(2000);
		touchAction.tap(PointOption.point(466, 988)).release().perform();
		Thread.sleep(2000);
		touchAction.tap(PointOption.point(621, 847)).release().perform();
		Thread.sleep(2000);
		touchAction.tap(PointOption.point(814, 894)).release().perform();
		Thread.sleep(2000);
		touchAction.tap(PointOption.point(913, 1064)).release().perform();
		Thread.sleep(2000);
		touchAction.tap(PointOption.point(904, 1280)).release().perform();
		Thread.sleep(2000);
//		touchAction.tap(PointOption.point(842, 1445)).release().perform(); 
//		Thread.sleep(2000);
		touchAction.tap(PointOption.point(758, 1708)).release().perform();
		Thread.sleep(2000);
		driver.findElementById("com.affluencesystems.admin:id/done").click();
		driver.findElementById("com.affluencesystems.admin:id/et_fence_name").sendKeys(String.valueOf(customfencename));
		driver.findElementById("com.affluencesystems.admin:id/ok").click();
		Thread.sleep(2000);

		WebElement createdgeofence = driver
				.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
						+ ".scrollIntoView(new UiSelector().text(\"" + customfencename + "\"))"));

		if (createdgeofence.isDisplayed()) {
			driver.findElementById("com.affluencesystems.admin:id/enterted_fence").sendKeys(String.valueOf(customfencename));;

			driver.findElementById("com.affluencesystems.admin:id/fencename").click();
			Thread.sleep(8000);

			System.out.println("New Custom Geofence created successfully");
			return true;
		} else {
			System.out.println("New Custom Geofence creation failed");

			return false;
		}

	}

}
