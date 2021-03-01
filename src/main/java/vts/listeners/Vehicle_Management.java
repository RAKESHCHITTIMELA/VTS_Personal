package vts.listeners;

import java.io.IOException;

import org.openqa.selenium.WebElement;

import freemarker.core.ParseException;
import io.appium.java_client.MobileBy;
import vts.basetest.TestBase;
import vts.utils.Keywords;

public class Vehicle_Management extends TestBase {

	Listeners ls = new Listeners();
	Keywords keywords = new Keywords();

	public boolean addVehicle(Object uname, Object pwd, Object vehiclenumber, Object enginenumber, Object chasisnumber,
			Object state, Object type, Object brand, Object model, Object variant, Object color, Object fuel,
			Object manufacturedate, Object purchasedate, Object deviceserialnumber, Object insuranceexpirydate,
			Object insurancenumber, Object insurancecompany, Object insurancepremium, Object odometerreading)
			throws ParseException, IOException, java.text.ParseException, InterruptedException {

//		ls.login(uname, pwd); 
		Thread.sleep(10000);
		driver.findElementById("com.affluencesystems.admin:id/menu_img").click();

		driver.findElementById("com.affluencesystems.admin:id/vehicle_number_state").click();
		driver.findElementById("com.affluencesystems.admin:id/floating_action_text").click();

		driver.findElementById("com.affluencesystems.admin:id/text_vehicleId").sendKeys(String.valueOf(vehiclenumber));
		driver.findElementById("com.affluencesystems.admin:id/engine_number").sendKeys(String.valueOf(enginenumber));
		driver.findElementById("com.affluencesystems.admin:id/chasis_number").sendKeys(String.valueOf(chasisnumber));

		driver.findElementById("com.affluencesystems.admin:id/statesSpinner").click();
		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().className(\"android.widget.ListView\")).getChildByText(new UiSelector().className(\"android.widget.TextView\"),\""
						+ state + "\")"))
				.click();

		driver.findElementById("com.affluencesystems.admin:id/text_type").click();

		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().className(\"android.widget.ListView\")).getChildByText(new UiSelector().className(\"android.widget.TextView\"),\""
						+ type + "\")"))
				.click();

		driver.findElementById("com.affluencesystems.admin:id/text_brand").click();
		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().className(\"android.widget.ListView\")).getChildByText(new UiSelector().className(\"android.widget.TextView\"),\""
						+ brand + "\")"))
				.click();

		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
				+ ".scrollIntoView(new UiSelector().resourceIdMatches(\"com.affluencesystems.admin:id/text_device_Id\"))"));

		driver.findElementById("com.affluencesystems.admin:id/text_vehicleModel").click();
		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().className(\"android.widget.ListView\")).getChildByText(new UiSelector().className(\"android.widget.TextView\"),\""
						+ model + "\")"))
				.click();

		driver.findElementById("com.affluencesystems.admin:id/text_vehicleModelNumber").click();
		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().className(\"android.widget.ListView\")).getChildByText(new UiSelector().className(\"android.widget.TextView\"),\""
						+ variant + "\")"))
				.click();

		driver.findElementById("com.affluencesystems.admin:id/text_color").click();

		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().className(\"android.widget.ListView\")).getChildByText(new UiSelector().className(\"android.widget.TextView\"),\""
						+ color + "\")"))
				.click();

		driver.findElementById("com.affluencesystems.admin:id/text_fuel").click();

		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().className(\"android.widget.ListView\")).getChildByText(new UiSelector().className(\"android.widget.TextView\"),\""
						+ fuel + "\")"))
				.click();

		driver.findElementById("com.affluencesystems.admin:id/et_manufacturer_date").click();
		keywords.setAndroidDatePicker(manufacturedate);

		driver.findElementById("com.affluencesystems.admin:id/et_parchase_date").click();
		keywords.setAndroidDatePicker(purchasedate);

		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
				+ ".scrollIntoView(new UiSelector().resourceIdMatches(\"com.affluencesystems.admin:id/text_sign_up\"))"));

		driver.findElementById("com.affluencesystems.admin:id/text_device_Id")
				.sendKeys(String.valueOf(deviceserialnumber));

		driver.findElementById("com.affluencesystems.admin:id/et_insurance_expire_date").click();
		keywords.setAndroidDatePicker(insuranceexpirydate);

		driver.findElementById("com.affluencesystems.admin:id/et_insurance_number")
				.sendKeys(String.valueOf(insurancenumber));

		driver.findElementById("com.affluencesystems.admin:id/text1").click();
		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().className(\"android.widget.ListView\")).getChildByText(new UiSelector().className(\"android.widget.TextView\"),\""
						+ insurancecompany + "\")"))
				.click();

		driver.findElementById("com.affluencesystems.admin:id/et_insurance_premium")
				.sendKeys(String.valueOf(insurancepremium));
		driver.findElementById("com.affluencesystems.admin:id/et_odometer_reading")
				.sendKeys(String.valueOf(odometerreading));
		driver.findElementById("com.affluencesystems.admin:id/text_sign_up").click();
		Thread.sleep(2000);

		if (driver.findElementById("com.affluencesystems.admin:id/floating_action_text").isDisplayed()) {

			System.out.println("Vehicle Added Successfully");
			return true;

		} else {

			System.out.println("Vehicle is not Added successfully");
			return false;
		}
	}

	public boolean addedVehicle(Object vehiclenumber) throws InterruptedException {

		Thread.sleep(3000);
		WebElement vehicle = driver
				.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
						+ ".scrollIntoView(new UiSelector().text(\"" + vehiclenumber + "\"))"));
		if (vehicle.isDisplayed()) {
//			driver.findElementByXPath("//*[contains(text()," + vehiclenumber + ")]").click();
//			Thread.sleep(3000);
			System.out.println("Newly Added is Present in Vehicle List");
			return true;

		} else {

			System.out.println("Newly Added is not present in vehicle list");
			return false;
		}

	}

	public boolean deleteVehicle(Object vehicledelete) throws InterruptedException {

		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
				+ ".scrollIntoView(new UiSelector().text(\"" + vehicledelete + "\"))"));

		driver.findElementByXPath("//*[@text='" + vehicledelete + "']").click();

		Thread.sleep(3000);
		driver.findElementById("com.affluencesystems.admin:id/delete_fence").click();
		Thread.sleep(3000);
		driver.findElementById("android:id/button1").click();
		Thread.sleep(3000);
		if (!driver.findElementByXPath("//*[contains(text()," + vehicledelete + ")]").isDisplayed()) {
			System.out.println("Vehicle deleted successfully");
			return true;
		} else {
			System.out.println("Vehicle deletion failed");
			return false;

		}

	}

	public boolean editVehicle(Object vehicle, Object changedvehiclenumber, Object enginenumber, Object chasisnumber)
			throws InterruptedException {

		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
				+ ".scrollIntoView(new UiSelector().text(\"" + vehicle + "\"))"));
		driver.findElementByXPath("//*[@text='" + vehicle + "']").click();
		Thread.sleep(2000);
		driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.ImageView")
				.click();
		Thread.sleep(2000);
		driver.findElementById("com.affluencesystems.admin:id/text_vehicleId")
				.sendKeys(String.valueOf(changedvehiclenumber));
		Thread.sleep(2000);
		driver.findElementById("com.affluencesystems.admin:id/engine_number").sendKeys(String.valueOf(enginenumber));
		Thread.sleep(2000);
		driver.findElementById("com.affluencesystems.admin:id/chasis_number").sendKeys(String.valueOf(chasisnumber));
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
				+ ".scrollIntoView(new UiSelector().resourceIdMatches(\"com.affluencesystems.admin:id/text_sign_up\"))"));
		driver.findElementById("com.affluencesystems.admin:id/text_sign_up").click();

		Thread.sleep(3000);

		driver.findElementById("com.affluencesystems.admin:id/back_button").click();
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
				+ ".scrollIntoView(new UiSelector().text(\"" + changedvehiclenumber + "\"))"));

		driver.findElementByXPath("//*[@text='" + changedvehiclenumber + "']").click();
		driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.ImageView")
				.click();

		Object en = driver.findElementById("com.affluencesystems.admin:id/engine_number").getText();

		System.out.println(en);

		if (en.equals(enginenumber)) {
			System.out.println("Vehicle edited successfully");

			return true;
		} else {
			System.out.println("Vehicle edit failed");

			return false;
		}

	}
}
