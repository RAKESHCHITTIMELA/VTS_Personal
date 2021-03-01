 package vts.listeners;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;

import org.apache.commons.io.IOUtils;

import io.appium.java_client.MobileBy;
import vts.basetest.TestBase;
import vts.utils.Keywords;

public class Listeners extends TestBase {

	Keywords keywords = new Keywords();

	public void login(Object uname, Object pwd) throws InterruptedException {

		driver.findElementById("com.affluencesystems.admin:id/text_email").sendKeys(String.valueOf(uname));
		driver.findElementById("com.affluencesystems.admin:id/text_user_pass").sendKeys(String.valueOf(pwd));
		driver.findElementById("com.affluencesystems.admin:id/im_pass_hide").click();
		driver.findElementById("com.affluencesystems.admin:id/text_sign_in").click();
		driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RadioButton").click();

		driver.findElementById("com.affluencesystems.admin:id/submit").click();
		Thread.sleep(2000);

	}

	// Login functionality with Valid data
	public boolean login_Validdata(Object uname, Object pwd) throws InterruptedException {
		driver.findElementById("com.affluencesystems.admin:id/text_email").sendKeys(String.valueOf(uname));
		driver.findElementById("com.affluencesystems.admin:id/text_user_pass").sendKeys(String.valueOf(pwd));
		driver.findElementById("com.affluencesystems.admin:id/im_pass_hide").click();
		driver.findElementById("com.affluencesystems.admin:id/text_sign_in").click();
		driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RadioButton")
				.click();

		driver.findElementById("com.affluencesystems.admin:id/submit").click();
//		String toastmessage = driver.findElementByXPath("//*[@text='Vehicle successfully selected']").getText();
		// System.out.println(toastmessage);

		// Assert.assertEquals(actual, expected);
		if (driver.findElementById("com.affluencesystems.admin:id/middle").isDisplayed()) {
			driver.findElementById("com.affluencesystems.admin:id/menu_img").click();
			Thread.sleep(2000);
			driver.findElementById("com.affluencesystems.admin:id/logout_rl").click();
			Thread.sleep(2000);
			driver.findElementById("android:id/button1").click();
			Thread.sleep(2000);
			return true;

		} else

			return false;

	}

	// Login functionality with invalid data

	public boolean login_Invaliddata(Object invaliduname, Object invalidpwd) throws InterruptedException {
		driver.findElementById("com.affluencesystems.admin:id/text_email").sendKeys(String.valueOf(invaliduname));
		driver.findElementById("com.affluencesystems.admin:id/text_user_pass").sendKeys(String.valueOf(invalidpwd));
		driver.findElementById("com.affluencesystems.admin:id/im_pass_hide").click();
		driver.findElementById("com.affluencesystems.admin:id/text_sign_in").click();
		Thread.sleep(2000);
		if (driver.findElementById("com.affluencesystems.admin:id/text_sign_in").isDisplayed()) {
			return true;
		} else {
			return false;
		}

	}

	public boolean home(Object uname, Object pwd) throws InterruptedException {

		driver.findElementById("com.affluencesystems.admin:id/text_email").sendKeys(String.valueOf(uname));
		driver.findElementById("com.affluencesystems.admin:id/text_user_pass").sendKeys(String.valueOf(pwd));
		driver.findElementById("com.affluencesystems.admin:id/im_pass_hide").click();
		driver.findElementById("com.affluencesystems.admin:id/text_sign_in").click();
		driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RadioButton")
				.click();

		driver.findElementById("com.affluencesystems.admin:id/submit").click();

		Thread.sleep(2000);

		if (driver.findElementById("com.affluencesystems.admin:id/middle").isDisplayed()) {
			return true;
		} else {
			return false;
		}

	}

	public void forgotpassword(String mailid, String newpword) {

		driver.findElementById("com.affluencesystems.admin:id/forgot_pass").click();

		driver.findElementById("com.affluencesystems.admin:id/edit_email").sendKeys(mailid);
		driver.findElementById("com.affluencesystems.admin:id/otp_btn").click();

		driver.findElementById("com.affluencesystems.admin:id/otp").sendKeys(null);
		driver.findElementById("com.affluencesystems.admin:id/edit_new_pwd").sendKeys(newpword);
		driver.findElementById("com.affluencesystems.admin:id/edit_confirm_pwd").sendKeys(newpword);
		driver.findElementById("com.affluencesystems.admin:id/update_pwd").click();

	}

	// Registration process starts here
	public boolean registration(Object firstname, Object lastname, Object mobilenumber, Object mailid, Object pword,
			Object address, Object city, Object state, Object pincode, Object Drivinglicencenumber)
			throws InterruptedException, IOException, ParseException {
		char[] otp = null;
		driver.findElementById("com.affluencesystems.admin:id/txt_create_new").click();
		driver.findElementById("com.affluencesystems.admin:id/text_type").click();
		driver.findElementByXPath("//*[@text='Personal']").click();

		driver.findElementById("com.affluencesystems.admin:id/text_first_name").sendKeys(String.valueOf(firstname));
		driver.findElementById("com.affluencesystems.admin:id/text_last_name").sendKeys(String.valueOf(lastname));
		driver.navigate().back();

		driver.findElementById("com.affluencesystems.admin:id/text_mobile_number")
				.sendKeys(String.valueOf(mobilenumber));

		driver.findElementById("com.affluencesystems.admin:id/text_email").sendKeys(String.valueOf(mailid));

		driver.findElementById("com.affluencesystems.admin:id/text_password").sendKeys(String.valueOf(pword));
		driver.findElementById("com.affluencesystems.admin:id/im_pass_hide").click();

		driver.findElementById("com.affluencesystems.admin:id/text_retype_password").sendKeys(String.valueOf(pword));
//		driver.findElementById("com.affluencesystems.admin:id/im_re_pass_show").click();
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
				+ ".scrollIntoView(new UiSelector().resourceIdMatches(\"com.affluencesystems.admin:id/text_sign_up\"))"));
		driver.findElementById("com.affluencesystems.admin:id/text_address").sendKeys(String.valueOf(address));

		driver.findElementById("com.affluencesystems.admin:id/et_city").sendKeys(String.valueOf(city));

		driver.findElementById("com.affluencesystems.admin:id/et_state").sendKeys(String.valueOf(state));

		driver.findElementById("com.affluencesystems.admin:id/et_pin").sendKeys(String.valueOf(pincode));
		driver.findElementById("com.affluencesystems.admin:id/checkbox").click();

		driver.findElementById("com.affluencesystems.admin:id/text_sign_up").click();

		Thread.sleep(3000);
		URL url = new URL("http://apptest.myintelligo.com:8004/test/getotpbymobileNumber/" + mobilenumber);
		URLConnection con = url.openConnection();
		InputStream in = con.getInputStream();
		String encoding = con.getContentEncoding();
		encoding = encoding == null ? "UTF-8" : encoding;
		String body = IOUtils.toString(in, encoding);
		System.out.println(body);
		otp = body.toCharArray();
		System.out.println(otp[52]);
		System.out.println(otp[53]);
		System.out.println(otp[54]);
		System.out.println(otp[55]);

		driver.findElementById("com.affluencesystems.admin:id/pin1").sendKeys(String.valueOf(otp[52]));
		driver.findElementById("com.affluencesystems.admin:id/pin2").sendKeys(String.valueOf(otp[53]));
		driver.findElementById("com.affluencesystems.admin:id/pin3").sendKeys(String.valueOf(otp[54]));
		driver.findElementById("com.affluencesystems.admin:id/pin4").sendKeys(String.valueOf(otp[55]));
		driver.findElementById("com.affluencesystems.admin:id/next_btn").click();

		Thread.sleep(3000);

//		// Establishing MongoDB connection
//
//		String client_url = "mongodb://" + "13.233.160.62" + ":" + 27017;
//
//		MongoClientURI mongoclientURI = new MongoClientURI(client_url);
//		MongoClient mongoclient = new MongoClient(mongoclientURI);
//
//		MongoDatabase mongodatabase = mongoclient.getDatabase("mainDB");
//		MongoIterable<String> mongoiterable = mongodatabase.listCollectionNames();
//		MongoCursor<String> iterator = mongoiterable.iterator();
//
//		while (iterator.hasNext()) {
//
//			System.out.println(iterator.next());
//		}
//
//		// Getting OTP from mongodb collection
//
//		MongoCollection<Document> collection = mongodatabase.getCollection("otpVerificationBean");
//		MongoCursor<Document> cursor = collection.find().iterator();
//		while (cursor.hasNext()) {
//
//			Document doc = cursor.next();
//			ArrayList<Object> users = new ArrayList<Object>(doc.values());
//
//			// resend OTP
//			// driver.findElementById("com.affluencesystems.admin:id/tv_resend").click();
//
//			if (users.get(0).toString().equals(mobilenumber)) {
//				otp = users.get(2).toString().toCharArray();
//				System.out.println(otp);
//				driver.findElementById("com.affluencesystems.admin:id/pin1").sendKeys(String.valueOf(otp[0]));
//				driver.findElementById("com.affluencesystems.admin:id/pin2").sendKeys(String.valueOf(otp[1]));
//				driver.findElementById("com.affluencesystems.admin:id/pin3").sendKeys(String.valueOf(otp[2]));
//				driver.findElementById("com.affluencesystems.admin:id/pin4").sendKeys(String.valueOf(otp[3]));
//				driver.findElementById("com.affluencesystems.admin:id/next_btn").click();
//
//				break;
//			}

		driver.findElementById("com.affluencesystems.admin:id/et_proof_number_licence")
				.sendKeys(String.valueOf(Drivinglicencenumber));
		driver.findElementById("com.affluencesystems.admin:id/im_proof_one_front_img").click();
		driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.ListView/android.widget.LinearLayout/android.widget.LinearLayout[1]")
				.click();
		driver.findElementByAccessibilityId("Shutter").click();
		Thread.sleep(2000);
		driver.findElementByAccessibilityId("Done").click();
		Thread.sleep(2000);
		driver.findElementById("com.affluencesystems.admin:id/crop_image_menu_crop").click();
		driver.findElementById("com.affluencesystems.admin:id/im_proof_two_back_img").click();
		driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.ListView/android.widget.LinearLayout/android.widget.LinearLayout[1]")
				.click();
		driver.findElementByAccessibilityId("Shutter").click();
		driver.findElementByAccessibilityId("Done").click();
		driver.findElementById("com.affluencesystems.admin:id/crop_image_menu_crop").click();
		driver.findElementById("com.affluencesystems.admin:id/tv_next").click();
		Thread.sleep(10000);
		if (driver.findElementById("com.affluencesystems.admin:id/text_sign_in").isDisplayed()) {

			return true;
		} else {
			return false;

		}
//			// Add vehicle code
//
//			driver.findElementById("com.affluencesystems.admin:id/text_vehicleId").sendKeys(null);
//			driver.findElementById("com.affluencesystems.admin:id/engine_number").sendKeys(null);
//			driver.findElementById("com.affluencesystems.admin:id/chasis_number").sendKeys(null);
//			
//			driver.findElementById("com.affluencesystems.admin:id/statesSpinner").click();
//			driver.findElement(MobileBy.AndroidUIAutomator(
//					"new UiScrollable(new UiSelector().className(\"android.widget.ListView\")).getChildByText(new UiSelector().className(\"android.widget.TextView\"),\"Telangana\")"))
//					.click();
//
//			driver.findElementById("com.affluencesystems.admin:id/text_type").click();
//			driver.findElementByXPath("//*[@text='Car']").click();
//			driver.findElementById("com.affluencesystems.admin:id/text_brand").click();
//			driver.findElement(MobileBy.AndroidUIAutomator(
//					"new UiScrollable(new UiSelector().className(\"android.widget.ListView\")).getChildByText(new UiSelector().className(\"android.widget.TextView\"),\"Bugatti\")"))
//					.click();
//
//			driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
//					+ ".scrollIntoView(new UiSelector().resourceIdMatches(\"com.affluencesystems.admin:id/text_device_Id\"))"));
//			
//			driver.findElementById("com.affluencesystems.admin:id/text_vehicleModel").click();
//			driver.findElement(MobileBy.AndroidUIAutomator(
//					"new UiScrollable(new UiSelector().className(\"android.widget.ListView\")).getChildByText(new UiSelector().className(\"android.widget.TextView\"),\"Veyron\")"))
//					.click();
//
//			driver.findElementById("com.affluencesystems.admin:id/text_vehicleModelNumber").click();
//			driver.findElement(MobileBy.AndroidUIAutomator(
//					"new UiScrollable(new UiSelector().className(\"android.widget.ListView\")).getChildByText(new UiSelector().className(\"android.widget.TextView\"),\"16.4 Grand Sport\")"))
//					.click();
//
//	
//			driver.findElementById("com.affluencesystems.admin:id/text_color").click();
//			driver.findElementByXPath("//*[@text='Blue']").click();
//			driver.findElementById("com.affluencesystems.admin:id/text_fuel").click();
//			driver.findElementByXPath("//*[@text='Petrol']").click();
//			driver.findElementById("com.affluencesystems.admin:id/et_manufacturer_date").click();
//
//			keywords.setAndroidDatePicker("03 October 2020"); 
//			driver.findElementById("com.affluencesystems.admin:id/et_parchase_date").click();
//
//			keywords.setAndroidDatePicker("10 October 2020");
//			driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
//					+ ".scrollIntoView(new UiSelector().resourceIdMatches(\"com.affluencesystems.admin:id/text_sign_up\"))"));
//			driver.findElementById("com.affluencesystems.admin:id/text_device_Id").sendKeys(null);
//			
//			driver.findElementById("com.affluencesystems.admin:id/et_insurance_expire_date").click();
//			keywords.setAndroidDatePicker("10 October 2025");
//			driver.findElementById("com.affluencesystems.admin:id/et_insurance_number").sendKeys(null);
//			driver.findElementById("com.affluencesystems.admin:id/text1").click();
//			driver.findElement(MobileBy.AndroidUIAutomator(
//		 			"new UiScrollable(new UiSelector().className(\"android.widget.ListView\")).getChildByText(new UiSelector().className(\"android.widget.TextView\"),\"Oriental insurance\")"))
//					.click();
//
//			driver.findElementById("com.affluencesystems.admin:id/et_insurance_premium").sendKeys(null);
//			driver.findElementById("com.affluencesystems.admin:id/et_odometer_reading").sendKeys(null);
//			driver.findElementById("com.affluencesystems.admin:id/text_sign_up").click();

	}
}
