package vts.listeners;

import vts.utils.*;

import java.io.IOException;

import freemarker.core.ParseException;
import vts.basetest.TestBase;
import vts.listeners.Listeners;;

public class Service_List extends TestBase {
	Listeners ls = new Listeners();
	Keywords keywords = new Keywords();

	public boolean addNewService(Object uname, Object pwd, Object lastservicedate, Object billamount,
			Object odometerreading, Object nextservicedate, Object nextservicekm, Object description)
			throws InterruptedException, ParseException, IOException, java.text.ParseException {

//		ls.login(uname, pwd);
		Thread.sleep(10000);
		driver.findElementById("com.affluencesystems.admin:id/menu_img").click();
		driver.findElementById("com.affluencesystems.admin:id/services_cardView").click();

		driver.findElementById("com.affluencesystems.admin:id/floating_action_text1").click();

		driver.findElementById("com.affluencesystems.admin:id/lastservicelayout").click();

		keywords.setAndroidDatePicker(lastservicedate);

		driver.findElementById("com.affluencesystems.admin:id/et_amount").sendKeys(String.valueOf(billamount));
		driver.findElementById("com.affluencesystems.admin:id/et_odometer_reading")
				.sendKeys(String.valueOf(odometerreading));
		driver.findElementById("com.affluencesystems.admin:id/et_next_service").click();
		keywords.setAndroidDatePicker(nextservicedate);

		driver.findElementById("com.affluencesystems.admin:id/et_next_service_km")
				.sendKeys(String.valueOf(nextservicekm));
		driver.findElementById("com.affluencesystems.admin:id/et_description").sendKeys(String.valueOf(description));

//		Thread.sleep(2000);
//		driver.findElementById("com.affluencesystems.admin:id/im_doc").click();
//		driver.findElementById("android:id/button1").click();
//		Thread.sleep(2000);
//		driver.findElementById("com.android.camera2:id/shutter_button").click();
//		Thread.sleep(3000);
//		driver.findElementById("com.android.camera2:id/done_button").click();

		Thread.sleep(2000);
		driver.findElementById("com.affluencesystems.admin:id/submit").click();
		Thread.sleep(2000);

		if (driver.findElementByXPath("//*[contains(text()," + description + ")]").isDisplayed()) {
			System.out.println("New service added successfully");
			return true;
		} else {
			System.out.println("New service creation failed");
			return false;

		}

	}

	public boolean deleteService() throws InterruptedException {

		Thread.sleep(4000);
		String service = driver.findElementById("com.affluencesystems.admin:id/description_data").getText();

		driver.findElementById("com.affluencesystems.admin:id/description_data").click();
		Thread.sleep(3000);
		driver.findElementById("com.affluencesystems.admin:id/search_bar").click();
		Thread.sleep(3000);
		driver.findElementById("android:id/button1").click();
		Thread.sleep(3000);
		if (!driver.findElementByXPath("//*[contains(text()," + service + ")]").isDisplayed()) {
			System.out.println("Service deletion failed");
			return false;
		} else {
			System.out.println("Service deleted successfully");
			return true;

		}

	}

}
