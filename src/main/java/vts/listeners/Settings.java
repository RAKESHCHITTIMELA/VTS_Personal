package vts.listeners;

import io.appium.java_client.MobileBy;
import vts.basetest.TestBase;

public class Settings extends TestBase {

	Listeners ls = new Listeners();

	public boolean validateConfigSettings(Object uname, Object pwd, Object speedlimit, Object harshbraking,
			Object harshacceleration, Object rashturning) throws InterruptedException {

//		ls.login(uname, pwd);
//		driver.findElementById("com.affluencesystems.admin:id/menu_img").click();
//		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
//				+ ".scrollIntoView(new UiSelector().resourceIdMatches(\"com.affluencesystems.admin:id/settings_card\"))"));

		Thread.sleep(10000);
		driver.findElementById("com.affluencesystems.admin:id/settings_card").click();
		org.openqa.selenium.WebElement textDemo = driver.findElementById("com.affluencesystems.admin:id/card_config");

		if (textDemo.isDisplayed()) {
			System.out.println("Element found using text"); 
			textDemo.click();

			String speed_linit_value = driver.findElementById("com.affluencesystems.admin:id/et_speed")
					.getAttribute("text");
			String harsh_breaking = driver.findElementById("com.affluencesystems.admin:id/et_harsh_breaking")
					.getAttribute("text");
			String harsj_acceleration = driver.findElementById("com.affluencesystems.admin:id/et_raah_acceleration")
					.getAttribute("text");
			String rash_turning = driver.findElementById("com.affluencesystems.admin:id/et_rash_turning")
					.getAttribute("text");
			System.out.println(speed_linit_value + " , " + "" + harsh_breaking + " , " + harsj_acceleration + " , "
					+ rash_turning);

			int i = 40;
			int speed = Integer.parseInt(String.valueOf(speedlimit)) - i;

			driver.findElementById("com.affluencesystems.admin:id/et_speed_listener").sendKeys(String.valueOf(0));
			driver.findElementById("com.affluencesystems.admin:id/et_speed_listener").sendKeys(String.valueOf(speed));
			driver.findElementById("com.affluencesystems.admin:id/et_harsh_breaking_listener")
					.sendKeys(String.valueOf(0));
			driver.findElementById("com.affluencesystems.admin:id/et_harsh_breaking_listener")
					.sendKeys(String.valueOf(harshbraking));
			driver.findElementById("com.affluencesystems.admin:id/et_raah_acceleration_listener")
					.sendKeys(String.valueOf(0));
			driver.findElementById("com.affluencesystems.admin:id/et_raah_acceleration_listener")
					.sendKeys(String.valueOf(harshacceleration));
			driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
					+ ".scrollIntoView(new UiSelector().resourceIdMatches(\"com.affluencesystems.admin:id/text_update\"))"));
			driver.findElementById("com.affluencesystems.admin:id/et_rash_turning_listener")
					.sendKeys(String.valueOf(0));
			driver.findElementById("com.affluencesystems.admin:id/et_rash_turning_listener")
					.sendKeys(String.valueOf(rashturning));

			driver.findElementById("com.affluencesystems.admin:id/text_update").click();

			if (driver.findElementById("com.affluencesystems.admin:id/card_config").isDisplayed()) {
	//			driver.findElementById("com.affluencesystems.admin:id/back_button").click();
				return true;
			} else {
				return false;
			}

		} else {
			System.out.println("Element not found");
			return false;
		}

		// driver.quit();
	}// end method settingConfig
}
