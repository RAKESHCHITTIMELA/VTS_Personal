package vts.listeners;

import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileBy;
import vts.basetest.TestBase;

public class Profile extends TestBase {

	Listeners ls = new Listeners();
	public boolean validateEditProfile(Object uname, Object pwd, Object firstname, Object lastname, Object mobilenumber, Object email, Object address ) throws InterruptedException {
		
//		ls.login(uname, pwd);
//		driver.findElementById("com.affluencesystems.admin:id/menu_img").click();
		
		driver.findElementById("com.affluencesystems.admin:id/back_button").click();
		Thread.sleep(2000);
		driver.findElementById("com.affluencesystems.admin:id/back_button").click();
		Thread.sleep(2000);
		driver.findElementById("com.affluencesystems.admin:id/back_button").click();
		Thread.sleep(2000);
		driver.findElementById("com.affluencesystems.admin:id/back_button").click();
		Thread.sleep(10000);

		driver.findElementById("com.affluencesystems.admin:id/edit_profile").click();
		if(driver.findElementById("com.affluencesystems.admin:id/r1_profile").isDisplayed()){
			driver.findElementById("com.affluencesystems.admin:id/text_first_name").sendKeys(String.valueOf(firstname));
			driver.findElementById("com.affluencesystems.admin:id/text_last_name").sendKeys(String.valueOf(lastname));
			driver.findElementById("com.affluencesystems.admin:id/editmob").click();
			driver.findElementById("com.affluencesystems.admin:id/text_mobile_number").clear();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElementById("com.affluencesystems.admin:id/text_mobile_number").sendKeys(String.valueOf(mobilenumber));
			driver.findElementById("com.affluencesystems.admin:id/editmob").click();
			Thread.sleep(2000);
			driver.findElementById("com.affluencesystems.admin:id/editemail").click();
			//driver.findElementById("com.affluencesystems.admin:id/text_email").clear();
			driver.findElementById("com.affluencesystems.admin:id/text_email").sendKeys(String.valueOf(email));
			driver.findElementById("com.affluencesystems.admin:id/editemail").click();
			Thread.sleep(2000);
			driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
					+".scrollIntoView(new UiSelector().resourceIdMatches(\"com.affluencesystems.admin:id/reset_pass1\"))"));
			
			driver.findElementById("com.affluencesystems.admin:id/text_address").sendKeys(String.valueOf(address));
			
			driver.findElementById("com.affluencesystems.admin:id/text_update").click();
			
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			if(driver.findElementById("com.affluencesystems.admin:id/edit_profile").isDisplayed()){
				
				return true;
				
			}
			else{
				return false;
			}
			
		}else{
			return false;
		}
	}
	


		
		
		
	}
	

