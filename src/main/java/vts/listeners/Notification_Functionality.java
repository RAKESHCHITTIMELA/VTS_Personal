package vts.listeners;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.Test;

import io.appium.java_client.HidesKeyboardWithKeyName;
import io.appium.java_client.MobileBy;
import vts.basetest.TestBase;
import vts.utils.Contents;
import vts.utils.Keywords;
import vts.utils.NotificationContent;
import vts.utils.NotificationsData;
import vts.utils.ReportContent;
import vts.utils.ReportsData;

@Test
public class Notification_Functionality extends TestBase {

	Listeners ls = new Listeners();
	static Keywords keywords = new Keywords();
	static HttpHeaders headers = new HttpHeaders();
	static RestTemplate template = new RestTemplate();
	DecimalFormat FormatChanger = new DecimalFormat("#.##");

	public void verifyNotification(Object uname, Object pwd, Object vehiclenum, Object startdate, Object enddate)
			throws InterruptedException, ParseException, IOException {

		driver.findElementById("com.affluencesystems.admin:id/text_email").sendKeys(String.valueOf(uname));
		driver.findElementById("com.affluencesystems.admin:id/text_user_pass").sendKeys(String.valueOf(pwd));
		driver.findElementById("com.affluencesystems.admin:id/im_pass_hide").click();
		driver.findElementById("com.affluencesystems.admin:id/text_sign_in").click();
		driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RadioButton")
				.click();
		driver.findElementById("com.affluencesystems.admin:id/submit").click();
		driver.findElementById("com.affluencesystems.admin:id/notification_text").click();

		Thread.sleep(2000);

		driver.findElementById("com.affluencesystems.admin:id/spinner_type_not").click();
		// com.affluencesystems.admin:id/text1

		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().className(\"android.widget.ListView\")).getChildByText(new UiSelector().className(\"android.widget.TextView\"),\""
						+ "Rash Turning" + "\")"));
		Thread.sleep(2000);
		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().className(\"android.widget.ListView\")).getChildByText(new UiSelector().className(\"android.widget.TextView\"),\""
						+ "All" + "\")"))
				.click();
		Thread.sleep(1000);
		driver.findElementById("com.affluencesystems.admin:id/sp_selection_").click();
		driver.findElementByXPath("//*[@text='Custom']").click();
		driver.findElementById("com.affluencesystems.admin:id/start_layout").click();
		keywords.setAndroidTripDatePicker(startdate);
		driver.findElementById("com.affluencesystems.admin:id/end_layout").click();
		keywords.setAndroidTripDatePicker(enddate);

		System.out.println("Startdate: "+keywords.getEpoachDate(startdate)+", Enddate: "+keywords.getEpoachDate(enddate)+", IMEI: "+keywords.getVehicleImeinumber(vehiclenum)+","+vehiclenum);
		

		NotificationContent vehicle_notification = null;
		List<WebElement> list1 = driver.findElementsById("com.affluencesystems.admin:id/text1");

		driver.navigate().back();

		int[] days = { 0, -7, -30 };
		for (int i = 0; i <= list1.size() - 2; i++) {
			driver.findElementById("com.affluencesystems.admin:id/text1").click();

			WebElement list = (WebElement) driver.findElementsById("com.affluencesystems.admin:id/text1").get(i);
			list.click();
		headers.add("Authorization",
				"eyJraWQiOiJ3ZEJYOHZpbEVSanZEQ291MStsMEUwNG0zT3BOb2FaMml6UXZobkNKZHJBPSIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiI1YTQ4ODhkOS1mZjlmLTQwNmQtYWYyOC1iYzEwZWVmOWVkOGUiLCJhdWQiOiI3aW5lZ3ZrOXNnYXI0MzY0ZXU4M3FkcjRlbSIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwiZXZlbnRfaWQiOiI0OWU5MjAxNC0xOGRiLTRhZjktYWU4My04MTc1NGVmM2M1NTciLCJ0b2tlbl91c2UiOiJpZCIsImF1dGhfdGltZSI6MTYwODAxNDM2NSwiaXNzIjoiaHR0cHM6XC9cL2NvZ25pdG8taWRwLmFwLXNvdXRoLTEuYW1hem9uYXdzLmNvbVwvYXAtc291dGgtMV9PWEZkdlc3b08iLCJjb2duaXRvOnVzZXJuYW1lIjoiNWE0ODg4ZDktZmY5Zi00MDZkLWFmMjgtYmMxMGVlZjllZDhlIiwicGhvbmVfbnVtYmVyIjoiKzkxNzAzNjQ3ODI4MiIsImV4cCI6MTYwODAxNzk2NSwiaWF0IjoxNjA4MDE0MzY1LCJlbWFpbCI6IkluZm85ODc2QGdtYWlsLmNvbSJ9.IivlQcE7HkDYD5Fy-3fGdxnjE1K01KAyxbooRlG-BsBkTllVhzeWpqHIdUyPIes-pf8kvcCBJjkOe9mlzbq-grkXs_Acje5De94mK2dW7UWymOPMSNSy3ERc4l0a02wqLXaVErw06TVKk_Cg3Bhl6DH1J-H8CsHlMKwTlyLRbw3XqwPnAS_G9HJJac6UjXWvt964_7BoyPWJ0ImeKZcSyOaKqEV6i4hkhXJUQ8vX8o4zAhzfq3kdJmHTznCT2xZFapU9DTNXLyXfVbCCAxmIwz74LW1A_SNXNw4EPCU3bHK-yG0Gpsduv0JtEzAPdlHBS1kDQnHm_tRopvCn3Cna0g");
		headers.add("userToken", "ZWkyNTRmYWR9NWliYn1hYTUxfTFhaGZ9ZDQ2MWMyYjI0Y2Np");
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		
		try {
			
			
			vehicle_notification = template
					.exchange("http://apptest.myintelligo.com:8003/vehiclealerts/getalertsdatabyimei/"
			+keywords.getVehicleImeinumber(vehiclenum) + "/All/"
							+ keywords.getLastDayDates(days[i])+ "/"+keywords.getCurrentDayInEpoach() + "", HttpMethod.GET, entity, NotificationContent.class)
					.getBody();
			//System.out.println(vehicle_notification.getContent());
			
			System.out.println("Startdate: "+keywords.getEpoachDate(startdate)+", Enddate: "+keywords.getEpoachDate(enddate)+", IMEI: "+keywords.getVehicleImeinumber(vehiclenum)+","+vehiclenum);
			
		} catch (Exception e) {
			e.getStackTrace();
		}}
		try{
			if(vehicle_notification.getContent()!=null) {
			List<NotificationsData> notifications = vehicle_notification.getContent();
			System.out.println(notifications.size());
			if(notifications.size()!=0) {
				
			for(int i= 0;i<notifications.size();i++) {
			long notification_time = notifications.get(i).getDateTime();
			String notification_alert_type = notifications.get(i).getAlertType();
			System.out.println(notifications.get(i).getDateTime()+", DateAndTime"+keywords.getEpochDateCovert(notifications.get(i).getDateTime()).substring(0,10));
			
			driver.findElement(MobileBy.AndroidUIAutomator(
					"new UiScrollable(new UiSelector().className(\"androidx.recyclerview.widget.RecyclerView\")).getChildByText(new UiSelector().className(\"android.widget.TextView\"),\""
							+  keywords.getEpochDateCovert(notification_time).substring(0,10)+ "\")"));
			driver.findElementByXPath("//*[@text='at " + keywords.getEpochDateCovert(notification_time).substring(12,23) + "']").click();
			
			System.out.println(keywords.getEpochDateCovert(notification_time).substring(12,22));
			
			driver.findElementByXPath("//*[@text='" + notification_alert_type + "']").click();
			driver.findElementById("com.affluencesystems.admin:id/cancel_map").click();

			}
			
		
			}}
			else {
				System.out.println("No Data Found");
			}}
			catch(Exception e) {
				e.printStackTrace();
				System.out.println(e);
			}


		/*
		 * try { vehicle_notification = template .exchange(
		 * "http://apptest.myintelligo.com:8003/vehiclealerts/getalertsdatabyimei/"+
		 * keywords.getVehicleImeinumber(vehiclenum) + "/" +
		 * keywords.getEpoachDate(startdate) + "/" + keywords.getEpoachDate(enddate) +
		 * "", HttpMethod.GET, entity, NotificationContent.class) .getBody();
		 * //System.out.println(vehicle_report.getContent());
		 * System.out.println("Startdate: "+keywords.getEpoachDate(startdate)
		 * +", Enddate: "+keywords.getEpoachDate(enddate)+", IMEI: "+keywords.
		 * getVehicleImeinumber(vehiclenum)+","+vehiclenum);
		 * 
		 * if(vehicle_notification.getContent().size()>0) { List<NotificationsData>
		 * notification_data = vehicle_notification.getContent();
		 * System.out.println(notification_data.size());
		 * if(!(notification_data.size()==0) && notification_data!=null) {
		 * 
		 * for(int i= 0;i<notification_data.size();i++) { long notification_start_time =
		 * notification_data.get(i).getDateTime();
		 * System.out.println(notification_data.get(i).getDateTime()+", Time:"+keywords.
		 * getEpochDateAndTime1(notification_start_time));
		 * 
		 * driver.findElement(MobileBy.AndroidUIAutomator(
		 * "new UiScrollable(new UiSelector().className(\"androidx.recyclerview.widget.RecyclerView\")).getChildByText(new UiSelector().className(\"android.widget.TextView\"),\""
		 * + keywords.getEpochDateCovert(notification_start_time).substring(0,10)+
		 * "\")")); //driver.findElementByXPath("//*[@text='" +
		 * keywords.getEpochDateCovert(notification_start_time).substring(0, 10) +
		 * "']").click();
		 * System.out.println(keywords.getEpochDateCovert(notification_start_time).
		 * substring(0,10));
		 * 
		 * 
		 * Thread.sleep(2000);
		 * driver.findElementById("com.affluencesystems.admin:id/card").click();
		 * 
		 * 
		 * }}} else { System.out.println("No Data Found"); }
		 * 
		 * } catch (Exception e) { e.getMessage(); }
		 */

	}

	
	public void customeNotifications(Object uname, Object pwd, Object vehiclenum, Object startdate, Object enddate)
			throws InterruptedException, ParseException, IOException {

		driver.findElementById("com.affluencesystems.admin:id/text_email").sendKeys(String.valueOf(uname));
		driver.findElementById("com.affluencesystems.admin:id/text_user_pass").sendKeys(String.valueOf(pwd));
		driver.findElementById("com.affluencesystems.admin:id/im_pass_hide").click();
		driver.findElementById("com.affluencesystems.admin:id/text_sign_in").click();
		driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RadioButton")
				.click();
		driver.findElementById("com.affluencesystems.admin:id/submit").click();
		driver.findElementById("com.affluencesystems.admin:id/not_layout").click();

		Thread.sleep(2000);

		driver.findElementById("com.affluencesystems.admin:id/spinner_type_not").click();
		// com.affluencesystems.admin:id/text1

		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().className(\"android.widget.ListView\")).getChildByText(new UiSelector().className(\"android.widget.TextView\"),\""
						+ "Rash Turning" + "\")"));
		Thread.sleep(2000);
		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().className(\"android.widget.ListView\")).getChildByText(new UiSelector().className(\"android.widget.TextView\"),\""
						+ "All" + "\")"))
				.click();
		Thread.sleep(1000);
		driver.findElementById("com.affluencesystems.admin:id/sp_selection_").click();
		driver.findElementByXPath("//*[@text='Custom']").click();
		driver.findElementById("com.affluencesystems.admin:id/start_layout").click();
		keywords.setAndroidTripDatePicker(startdate);
		driver.findElementById("com.affluencesystems.admin:id/end_layout").click();
		keywords.setAndroidTripDatePicker(enddate);

		System.out.println("Startdate: "+keywords.getEpoachDate(startdate)+", Enddate: "+keywords.getEpoachDate(enddate)+", IMEI: "+keywords.getVehicleImeinumber(vehiclenum)+","+vehiclenum);
		headers.add("Authorization",
				"eyJraWQiOiJ3ZEJYOHZpbEVSanZEQ291MStsMEUwNG0zT3BOb2FaMml6UXZobkNKZHJBPSIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiI1YTQ4ODhkOS1mZjlmLTQwNmQtYWYyOC1iYzEwZWVmOWVkOGUiLCJhdWQiOiI3aW5lZ3ZrOXNnYXI0MzY0ZXU4M3FkcjRlbSIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwiZXZlbnRfaWQiOiI0OWU5MjAxNC0xOGRiLTRhZjktYWU4My04MTc1NGVmM2M1NTciLCJ0b2tlbl91c2UiOiJpZCIsImF1dGhfdGltZSI6MTYwODAxNDM2NSwiaXNzIjoiaHR0cHM6XC9cL2NvZ25pdG8taWRwLmFwLXNvdXRoLTEuYW1hem9uYXdzLmNvbVwvYXAtc291dGgtMV9PWEZkdlc3b08iLCJjb2duaXRvOnVzZXJuYW1lIjoiNWE0ODg4ZDktZmY5Zi00MDZkLWFmMjgtYmMxMGVlZjllZDhlIiwicGhvbmVfbnVtYmVyIjoiKzkxNzAzNjQ3ODI4MiIsImV4cCI6MTYwODAxNzk2NSwiaWF0IjoxNjA4MDE0MzY1LCJlbWFpbCI6IkluZm85ODc2QGdtYWlsLmNvbSJ9.IivlQcE7HkDYD5Fy-3fGdxnjE1K01KAyxbooRlG-BsBkTllVhzeWpqHIdUyPIes-pf8kvcCBJjkOe9mlzbq-grkXs_Acje5De94mK2dW7UWymOPMSNSy3ERc4l0a02wqLXaVErw06TVKk_Cg3Bhl6DH1J-H8CsHlMKwTlyLRbw3XqwPnAS_G9HJJac6UjXWvt964_7BoyPWJ0ImeKZcSyOaKqEV6i4hkhXJUQ8vX8o4zAhzfq3kdJmHTznCT2xZFapU9DTNXLyXfVbCCAxmIwz74LW1A_SNXNw4EPCU3bHK-yG0Gpsduv0JtEzAPdlHBS1kDQnHm_tRopvCn3Cna0g");
		headers.add("userToken", "ZWkyNTRmYWR9NWliYn1hYTUxfTFhaGZ9ZDQ2MWMyYjI0Y2Np");
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		NotificationContent vehicle_notification = null;
		try {
			vehicle_notification = template
					.exchange("http://apptest.myintelligo.com:8003/vehiclealerts/getalertsdatabyimei/"+keywords.getVehicleImeinumber(vehiclenum) + "/All/"
							+ keywords.getEpoachDate(startdate) + "/" + keywords.getEpoachDate(enddate) + "", HttpMethod.GET, entity, NotificationContent.class)
					.getBody();
			//System.out.println(vehicle_notification.getContent());
			
			System.out.println("Startdate: "+keywords.getEpoachDate(startdate)+", Enddate: "+keywords.getEpoachDate(enddate)+", IMEI: "+keywords.getVehicleImeinumber(vehiclenum)+","+vehiclenum);
			
		} catch (Exception e) {
			e.getStackTrace();
		}
		try{
			if(vehicle_notification.getContent()!=null) {
			List<NotificationsData> notifications = vehicle_notification.getContent();
			System.out.println(notifications.size());
			if(notifications.size()!=0) {
				
			for(int i= 0;i<notifications.size();i++) {
			long notification_time = notifications.get(i).getDateTime();
			String notification_alert_type = notifications.get(i).getAlertType();
			System.out.println(notifications.get(i).getDateTime()+", DateAndTime"+keywords.getEpochDateCovert(notifications.get(i).getDateTime()).substring(0,10));
			
			driver.findElement(MobileBy.AndroidUIAutomator(
					"new UiScrollable(new UiSelector().className(\"androidx.recyclerview.widget.RecyclerView\")).getChildByText(new UiSelector().className(\"android.widget.TextView\"),\""
							+"at "+  keywords.getEpochDateCovert(notification_time).substring(12,23)+ "\")"));
			
			//driver.findElementByXPath("//*[@text='at " + keywords.getEpochDateCovert(notification_time).substring(12,23) + "']").click();
			
			System.out.println("Time: "+keywords.getEpochDateCovert(notification_time).substring(12,23));
			
			driver.findElementByXPath("//*[@text='" + notification_alert_type + "']").click();
			driver.findElementById("com.affluencesystems.admin:id/cancel_map").click();
			

			}
			
		
			}}
			else {
				System.out.println("No Data Found");
			}}
			catch(Exception e) {
				e.printStackTrace();
				System.out.println(e);
			}


		/*
		 * try { vehicle_notification = template .exchange(
		 * "http://apptest.myintelligo.com:8003/vehiclealerts/getalertsdatabyimei/"+
		 * keywords.getVehicleImeinumber(vehiclenum) + "/" +
		 * keywords.getEpoachDate(startdate) + "/" + keywords.getEpoachDate(enddate) +
		 * "", HttpMethod.GET, entity, NotificationContent.class) .getBody();
		 * //System.out.println(vehicle_report.getContent());
		 * System.out.println("Startdate: "+keywords.getEpoachDate(startdate)
		 * +", Enddate: "+keywords.getEpoachDate(enddate)+", IMEI: "+keywords.
		 * getVehicleImeinumber(vehiclenum)+","+vehiclenum);
		 * 
		 * if(vehicle_notification.getContent().size()>0) { List<NotificationsData>
		 * notification_data = vehicle_notification.getContent();
		 * System.out.println(notification_data.size());
		 * if(!(notification_data.size()==0) && notification_data!=null) {
		 * 
		 * for(int i= 0;i<notification_data.size();i++) { long notification_start_time =
		 * notification_data.get(i).getDateTime();
		 * System.out.println(notification_data.get(i).getDateTime()+", Time:"+keywords.
		 * getEpochDateAndTime1(notification_start_time));
		 * 
		 * driver.findElement(MobileBy.AndroidUIAutomator(
		 * "new UiScrollable(new UiSelector().className(\"androidx.recyclerview.widget.RecyclerView\")).getChildByText(new UiSelector().className(\"android.widget.TextView\"),\""
		 * + keywords.getEpochDateCovert(notification_start_time).substring(0,10)+
		 * "\")")); //driver.findElementByXPath("//*[@text='" +
		 * keywords.getEpochDateCovert(notification_start_time).substring(0, 10) +
		 * "']").click();
		 * System.out.println(keywords.getEpochDateCovert(notification_start_time).
		 * substring(0,10));
		 * 
		 * 
		 * Thread.sleep(2000);
		 * driver.findElementById("com.affluencesystems.admin:id/card").click();
		 * 
		 * 
		 * }}} else { System.out.println("No Data Found"); }
		 * 
		 * } catch (Exception e) { e.getMessage(); }
		 */

	}

}
