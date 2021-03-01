package vts.listeners;

import vts.basetest.TestBase;
import vts.utils.Keywords;

public class Change_Password extends TestBase {

	Listeners ls = new Listeners();
	Keywords keywords = new Keywords();

	public boolean validateChangePassowrd(Object uname, Object pwd, Object newpwd) throws InterruptedException {

//		ls.login(uname, pwd);
//		driver.findElementById("com.affluencesystems.admin:id/menu_img").click();
//		Thread.sleep(5000);
//		keywords.goToMenu();
		driver.findElementById("com.affluencesystems.admin:id/text_email").sendKeys(String.valueOf(uname));
		driver.findElementById("com.affluencesystems.admin:id/text_user_pass").sendKeys(String.valueOf(pwd));
		driver.findElementById("com.affluencesystems.admin:id/im_pass_hide").click();
		driver.findElementById("com.affluencesystems.admin:id/text_sign_in").click();
		driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RadioButton")
				.click();
		driver.findElementById("com.affluencesystems.admin:id/submit").click();
		driver.findElementById("com.affluencesystems.admin:id/menu_img").click();
		driver.findElementById("com.affluencesystems.admin:id/edit_profile").click();
		driver.findElementById("com.affluencesystems.admin:id/reset_pass1").click();
		driver.findElementById("com.affluencesystems.admin:id/edit_old_pwd").sendKeys(String.valueOf(pwd));
		driver.findElementById("com.affluencesystems.admin:id/im_pass_hide").click();
		driver.findElementById("com.affluencesystems.admin:id/edit_new_pwd").sendKeys(String.valueOf(newpwd));
		driver.findElementById("com.affluencesystems.admin:id/im_pass_hide_new").click();
		driver.findElementById("com.affluencesystems.admin:id/im_pass_hide_new").click();
		driver.findElementById("com.affluencesystems.admin:id/edit_confirm_pwd").sendKeys(String.valueOf(newpwd));
		driver.findElementById("com.affluencesystems.admin:id/update_pwd").click();
		Thread.sleep(3000);
		ls.login(uname, newpwd);
		if (driver.findElementById("com.affluencesystems.admin:id/middle").isDisplayed()) {
			return true;
		} else { 
			return false;
		}

	}

}
