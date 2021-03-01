 package vts.listeners;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.openqa.selenium.WebElement;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;


import io.appium.java_client.MobileBy;
import vts.basetest.TestBase;
import vts.utils.Contents;
import vts.utils.Keywords;
import vts.utils.StrideContents;
import vts.utils.VehicleStridesBean;
import vts.utils.VehicleTripBean;

public class Trips extends TestBase {

	Listeners ls = new Listeners();
	Keywords keywords = new Keywords();
	HttpHeaders headers = new HttpHeaders();
	RestTemplate template = new RestTemplate();
	DecimalFormat FormatChanger = new DecimalFormat("#.##");

	public void trips(Object vehiclenum, Object startdate, Object enddate)
			throws InterruptedException, ParseException, IOException, java.text.ParseException {

		// ls.login(uname, pwd);
//		driver.findElementById("com.affluencesystems.admin:id/text_email").sendKeys(String.valueOf(uname));
//		driver.findElementById("com.affluencesystems.admin:id/text_user_pass").sendKeys(String.valueOf(pwd));
//		driver.findElementById("com.affluencesystems.admin:id/im_pass_hide").click();
//		driver.findElementById("com.affluencesystems.admin:id/text_sign_in").click();
//		driver.findElementByXPath(
//				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[7]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RadioButton")
//				.click();
//		driver.findElementById("com.affluencesystems.admin:id/submit").click();
//		driver.findElementById("com.affluencesystems.admin:id/menu_img").click();
//		driver.findElementById("com.affluencesystems.admin:id/vehicle_number_state").click();
//		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
//				+ ".scrollIntoView(new UiSelector().text(\""+vehiclenum+"\"))"));
//		driver.findElementByXPath("//*[@text='"+vehiclenum+"']").click();
//		Thread.sleep(2000);
//		driver.findElementById("com.affluencesystems.admin:id/trip_count_layout").click();

//		driver.findElementById("com.affluencesystems.admin:id/tripList").click();
//		driver.findElementById("com.affluencesystems.admin:id/past_trip_layout").click();
		driver.findElementById("com.affluencesystems.admin:id/sp_selection").click();
		driver.findElementByXPath("//*[@text='Custom']").click();
		driver.findElementById("com.affluencesystems.admin:id/start_date_layout").click();
		keywords.setAndroidTripDatePicker(startdate);
		driver.findElementById("com.affluencesystems.admin:id/end_date_layout").click();
		keywords.setAndroidTripDatePicker(enddate);

		// API Call

		headers.add("Authorization",
				"eyJraWQiOiJ3ZEJYOHZpbEVSanZEQ291MStsMEUwNG0zT3BOb2FaMml6UXZobkNKZHJBPSIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiI1YTQ4ODhkOS1mZjlmLTQwNmQtYWYyOC1iYzEwZWVmOWVkOGUiLCJhdWQiOiI3aW5lZ3ZrOXNnYXI0MzY0ZXU4M3FkcjRlbSIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwiZXZlbnRfaWQiOiI0OWU5MjAxNC0xOGRiLTRhZjktYWU4My04MTc1NGVmM2M1NTciLCJ0b2tlbl91c2UiOiJpZCIsImF1dGhfdGltZSI6MTYwODAxNDM2NSwiaXNzIjoiaHR0cHM6XC9cL2NvZ25pdG8taWRwLmFwLXNvdXRoLTEuYW1hem9uYXdzLmNvbVwvYXAtc291dGgtMV9PWEZkdlc3b08iLCJjb2duaXRvOnVzZXJuYW1lIjoiNWE0ODg4ZDktZmY5Zi00MDZkLWFmMjgtYmMxMGVlZjllZDhlIiwicGhvbmVfbnVtYmVyIjoiKzkxNzAzNjQ3ODI4MiIsImV4cCI6MTYwODAxNzk2NSwiaWF0IjoxNjA4MDE0MzY1LCJlbWFpbCI6IkluZm85ODc2QGdtYWlsLmNvbSJ9.IivlQcE7HkDYD5Fy-3fGdxnjE1K01KAyxbooRlG-BsBkTllVhzeWpqHIdUyPIes-pf8kvcCBJjkOe9mlzbq-grkXs_Acje5De94mK2dW7UWymOPMSNSy3ERc4l0a02wqLXaVErw06TVKk_Cg3Bhl6DH1J-H8CsHlMKwTlyLRbw3XqwPnAS_G9HJJac6UjXWvt964_7BoyPWJ0ImeKZcSyOaKqEV6i4hkhXJUQ8vX8o4zAhzfq3kdJmHTznCT2xZFapU9DTNXLyXfVbCCAxmIwz74LW1A_SNXNw4EPCU3bHK-yG0Gpsduv0JtEzAPdlHBS1kDQnHm_tRopvCn3Cna0g");
		headers.add("userToken", "ZWkyNTRmYWR9NWliYn1hYTUxfTFhaGZ9ZDQ2MWMyYjI0Y2Np");
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		Contents VehicleTrips = null;

		try {
			VehicleTrips = template.exchange("http://apptest.myintelligo.com:8003/vehicletrips/gettriplistbyimeinumber/"
					+ keywords.getVehicleImeinumber(vehiclenum) + "/" + keywords.getEpoachDate(startdate) + "/"
					+ keywords.getEpoachDate(enddate) + "", HttpMethod.GET, entity, Contents.class).getBody();
		} catch (Exception e) {
			e.getStackTrace();
		}

		List<VehicleTripBean> vehicle = VehicleTrips.getContent();
		if (!(vehicle.size() == 0)) {

			for (int i = 0; i < vehicle.size(); i++) {
				Object tripname = vehicle.get(i).getTripName();
				driver.findElement(MobileBy.AndroidUIAutomator(
						"new UiScrollable(new UiSelector().className(\"androidx.recyclerview.widget.RecyclerView\")).getChildByText(new UiSelector().className(\"android.widget.TextView\"),\""
								+ tripname + "\")"));
				driver.findElementByXPath("//*[@text='" + tripname + "']").click();
				Thread.sleep(2000);

				// distance

				String distance2 = driver.findElementById("com.affluencesystems.admin:id/distance").getText();
				String distance3 = (String) distance2.substring(0, distance2.length() - 3);

				String distance1 = FormatChanger.format(vehicle.get(i).getDistanceTravel() / 1000.0).toString();
				if (!(distance1.equals("0.0"))) {
					System.out.println(distance1 + distance3);
					if (distance1.equals(distance3)) {
						System.out.println("distance is equal");
					} else {
						System.out.println("distance is not equal");
					}
				} else {
					String[] d = distance1.split(".");
					if (d[0].equals(distance3)) {
						System.out.println("distance is equal");
					} else {
						System.out.println("distance is not equal");
					}
				}

				// time
				String time1 = driver.findElementById("com.affluencesystems.admin:id/time").getText();
				int time = Math.round(vehicle.get(i).getTimeDuration());
				if (!(String.valueOf(time).equals("0"))) {
					Date date = new Date(time * 1000);
					SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
					sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
					String formattedDate = sdf.format(date);
					System.out.println(formattedDate);
					if (time1.equals(formattedDate)) {
						System.out.println("Time is equal");
					} else {
						System.out.println("Time is not equal");
					}

				} else {
					String t = String.valueOf(time);
					t = "00:00:00";
					if (time1.equals(t)) {
						System.out.println("Time is equal");
					} else {
						System.out.println("Time is not equal");
					}
				}

				// fuel

				String fuel2 = driver.findElementById("com.affluencesystems.admin:id/fuel").getText();
				String fuel3 = (String) fuel2.substring(0, fuel2.length() - 2);

				String fuel1 = FormatChanger.format(vehicle.get(i).getFuelConsumed() / 1000.0).toString();
				System.out.println(fuel1 + fuel3);
				if (fuel1.equals(fuel3)) {
					System.out.println("fuel is equal");
				} else {
					System.out.println("fuel is not equal");
				}

				// mileage
				String mileage1 = driver.findElementById("com.affluencesystems.admin:id/mileage").getText();
				String mileage2 = (String) mileage1.substring(0, mileage1.length() - 5);
				float dist1 = Float.valueOf(distance3);
				float fuel4 = Float.valueOf(fuel3);
				if (!(fuel3.equals("0"))) {
					String mileage3 = FormatChanger.format(dist1 / fuel4).toString();
					System.out.println(mileage2 + mileage3);
					if (mileage2.equals(mileage3)) {
						System.out.println("mileage is equal");
					} else {
						System.out.println("mileage is not equal");
					}
				} else {
					String m = "0";
					if (mileage2.equals(m)) {
						System.out.println("mileage is equal");
					} else {
						System.out.println("mileage is not equal");
					}
				}
				driver.findElementById("com.affluencesystems.admin:id/dismiss").click();
			}
		} else {
			System.out.println("No Trips are there");
		}
	}

	public void previousTrips(Object uname, Object pwd, Object vehiclenum, Object startdate, Object enddate)
			throws InterruptedException {

//		driver.findElementById("com.affluencesystems.admin:id/text_email").sendKeys(String.valueOf(uname));
//		driver.findElementById("com.affluencesystems.admin:id/text_user_pass").sendKeys(String.valueOf(pwd));
//		driver.findElementById("com.affluencesystems.admin:id/im_pass_hide").click();
//		driver.findElementById("com.affluencesystems.admin:id/text_sign_in").click();
//		driver.findElementByXPath(
//				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RadioButton")
//				.click();
//		driver.findElementById("com.affluencesystems.admin:id/submit").click();
//		driver.findElementById("com.affluencesystems.admin:id/menu_img").click();
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
				+ ".scrollIntoView(new UiSelector().text(\"Vehicle Management\"))"));
		driver.findElementById("com.affluencesystems.admin:id/vehicle_number_state").click();
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
				+ ".scrollIntoView(new UiSelector().text(\"" + vehiclenum + "\"))"));
		driver.findElementByXPath("//*[@text='" + vehiclenum + "']").click();
		Thread.sleep(2000);
		driver.findElementById("com.affluencesystems.admin:id/trip_count_layout").click();

//		driver.findElementById("com.affluencesystems.admin:id/tripList").click();
//		driver.findElementById("com.affluencesystems.admin:id/past_trip_layout").click();
		driver.findElementById("com.affluencesystems.admin:id/sp_selection").click();

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
			Contents VehicleTrips = null;

			try {
				VehicleTrips = template
						.exchange("http://apptest.myintelligo.com:8003/vehicletrips/gettriplistbyimeinumber/"
								+ keywords.getVehicleImeinumber(vehiclenum) + "/"
								+ keywords.getLastDayDates(days[i]) + "/"
								+ keywords.getCurrentDayInEpoach() + "", HttpMethod.GET, entity, Contents.class)
						.getBody();
			} catch (Exception e) {
				e.getStackTrace();
			}
			List<VehicleTripBean> vehicle = VehicleTrips.getContent();
			if (!(vehicle.size() == 0)) {
				driver.findElement(MobileBy.AndroidUIAutomator(
						"new UiScrollable(new UiSelector().className(\"androidx.recyclerview.widget.RecyclerView\")).getChildByText(new UiSelector().className(\"android.widget.TextView\"),\""
								+ vehicle.get(vehicle.size() - 1).getTripName() + "\")"));
			} else {
				String nodatatext = driver.findElementById("com.affluencesystems.admin:id/no_docs").getText();

				System.out.println(nodatatext);
				System.out.println("No Trips are there");
			}

		}

		
		Thread.sleep(5000);
	}

	 public void TripPath(Object uname, Object pwd, Object vehiclenum, Object startdate, Object enddate) throws InterruptedException, freemarker.core.ParseException, IOException, ParseException {
		 
		 driver.findElementById("com.affluencesystems.admin:id/text_email").sendKeys(String.valueOf(uname));
			driver.findElementById("com.affluencesystems.admin:id/text_user_pass").sendKeys(String.valueOf(pwd));
			driver.findElementById("com.affluencesystems.admin:id/im_pass_hide").click();
			driver.findElementById("com.affluencesystems.admin:id/text_sign_in").click();
			driver.findElementByXPath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[7]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RadioButton")
					.click();
			driver.findElementById("com.affluencesystems.admin:id/submit").click();
			driver.findElementById("com.affluencesystems.admin:id/menu_img").click();
			driver.findElementById("com.affluencesystems.admin:id/vehicle_number_state").click();
			driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
					+ ".scrollIntoView(new UiSelector().text(\""+vehiclenum+"\"))"));
			driver.findElementByXPath("//*[@text='"+vehiclenum+"']").click();
			Thread.sleep(2000);
			driver.findElementById("com.affluencesystems.admin:id/trip_count_layout").click();
			driver.findElementById("com.affluencesystems.admin:id/sp_selection").click();
			driver.findElementByXPath("//*[@text='Custom']").click();
			driver.findElementById("com.affluencesystems.admin:id/start_date_layout").click();
			keywords.setAndroidTripDatePicker(startdate);
			driver.findElementById("com.affluencesystems.admin:id/end_date_layout").click();
			keywords.setAndroidTripDatePicker(enddate);
			headers.add("Authorization",
					"eyJraWQiOiJ3ZEJYOHZpbEVSanZEQ291MStsMEUwNG0zT3BOb2FaMml6UXZobkNKZHJBPSIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiI1YTQ4ODhkOS1mZjlmLTQwNmQtYWYyOC1iYzEwZWVmOWVkOGUiLCJhdWQiOiI3aW5lZ3ZrOXNnYXI0MzY0ZXU4M3FkcjRlbSIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwiZXZlbnRfaWQiOiI0OWU5MjAxNC0xOGRiLTRhZjktYWU4My04MTc1NGVmM2M1NTciLCJ0b2tlbl91c2UiOiJpZCIsImF1dGhfdGltZSI6MTYwODAxNDM2NSwiaXNzIjoiaHR0cHM6XC9cL2NvZ25pdG8taWRwLmFwLXNvdXRoLTEuYW1hem9uYXdzLmNvbVwvYXAtc291dGgtMV9PWEZkdlc3b08iLCJjb2duaXRvOnVzZXJuYW1lIjoiNWE0ODg4ZDktZmY5Zi00MDZkLWFmMjgtYmMxMGVlZjllZDhlIiwicGhvbmVfbnVtYmVyIjoiKzkxNzAzNjQ3ODI4MiIsImV4cCI6MTYwODAxNzk2NSwiaWF0IjoxNjA4MDE0MzY1LCJlbWFpbCI6IkluZm85ODc2QGdtYWlsLmNvbSJ9.IivlQcE7HkDYD5Fy-3fGdxnjE1K01KAyxbooRlG-BsBkTllVhzeWpqHIdUyPIes-pf8kvcCBJjkOe9mlzbq-grkXs_Acje5De94mK2dW7UWymOPMSNSy3ERc4l0a02wqLXaVErw06TVKk_Cg3Bhl6DH1J-H8CsHlMKwTlyLRbw3XqwPnAS_G9HJJac6UjXWvt964_7BoyPWJ0ImeKZcSyOaKqEV6i4hkhXJUQ8vX8o4zAhzfq3kdJmHTznCT2xZFapU9DTNXLyXfVbCCAxmIwz74LW1A_SNXNw4EPCU3bHK-yG0Gpsduv0JtEzAPdlHBS1kDQnHm_tRopvCn3Cna0g");
			headers.add("userToken", "ZWkyNTRmYWR9NWliYn1hYTUxfTFhaGZ9ZDQ2MWMyYjI0Y2Np");
			HttpEntity<String> entity = new HttpEntity<String>(headers);
			Contents VehicleTrips = null;

			try {
				VehicleTrips = template.exchange("http://apptest.myintelligo.com:8003/vehicletrips/gettriplistbyimeinumber/"
						+ keywords.getVehicleImeinumber(vehiclenum) + "/" + keywords.getEpoachDate(startdate) + "/"
						+ keywords.getEpoachDate(enddate) + "", HttpMethod.GET, entity, Contents.class).getBody();
			} catch (Exception e) {
				e.getStackTrace();
			}

			List<VehicleTripBean> vehicle = VehicleTrips.getContent();
			driver.findElementByXPath("//*[@text='"+vehicle.get(2).getTripName()+"']").click();
			driver.findElementById("com.affluencesystems.admin:id/proceed_map").click();
			Thread.sleep(5000);
			driver.findElementById("com.affluencesystems.admin:id/play").click();
			Thread.sleep(2000);

			int time1 = 1;
			int time2 = 2;
		 while(!(time1>=time2)){
			 for(int i=0;i<5;i++) {
					driver.findElementById("com.affluencesystems.admin:id/im_fast").click();
				 
			 }
			 String s =driver.findElementById("com.affluencesystems.admin:id/start_time").getText();
				String s2 =driver.findElementById("com.affluencesystems.admin:id/finish_time").getText();
			 	 String[] hourMin = s.split(" : ");
			     int hour = Integer.parseInt(hourMin[0]);
			     int mins = Integer.parseInt(hourMin[1]);
			     int sec = Integer.parseInt(hourMin[2]);
			     int hour1 = hour * 60;
			     int mins1 = mins * 60;
			     
			     System.out.println(hour1 + mins1 + sec); 
			      time1 = hour1 + mins1 + sec;
			     String[] hourMin1 = s2.split(" : ");
			     int hour3 = Integer.parseInt(hourMin1[0]);
			     int mins3 = Integer.parseInt(hourMin1[1]);
			     int sec1 = Integer.parseInt(hourMin1[2]);
			     int hour2 = hour3 * 60;
			     int mins2 = mins3 * 60;
			 System.out.println(hour2 + mins2 + sec1); 
			  time2 = hour2 + mins2 + sec1;
				driver.findElementById("com.affluencesystems.admin:id/im_fast").click();

		 System.out.println("loop"); }
		      }
		 
	 
	
	public void tripss_1() throws IOException, ParseException {

		RestTemplate template = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization",
				"eyJraWQiOiJ3ZEJYOHZpbEVSanZEQ291MStsMEUwNG0zT3BOb2FaMml6UXZobkNKZHJBPSIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiI1YTQ4ODhkOS1mZjlmLTQwNmQtYWYyOC1iYzEwZWVmOWVkOGUiLCJhdWQiOiI3aW5lZ3ZrOXNnYXI0MzY0ZXU4M3FkcjRlbSIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwiZXZlbnRfaWQiOiI0OWU5MjAxNC0xOGRiLTRhZjktYWU4My04MTc1NGVmM2M1NTciLCJ0b2tlbl91c2UiOiJpZCIsImF1dGhfdGltZSI6MTYwODAxNDM2NSwiaXNzIjoiaHR0cHM6XC9cL2NvZ25pdG8taWRwLmFwLXNvdXRoLTEuYW1hem9uYXdzLmNvbVwvYXAtc291dGgtMV9PWEZkdlc3b08iLCJjb2duaXRvOnVzZXJuYW1lIjoiNWE0ODg4ZDktZmY5Zi00MDZkLWFmMjgtYmMxMGVlZjllZDhlIiwicGhvbmVfbnVtYmVyIjoiKzkxNzAzNjQ3ODI4MiIsImV4cCI6MTYwODAxNzk2NSwiaWF0IjoxNjA4MDE0MzY1LCJlbWFpbCI6IkluZm85ODc2QGdtYWlsLmNvbSJ9.IivlQcE7HkDYD5Fy-3fGdxnjE1K01KAyxbooRlG-BsBkTllVhzeWpqHIdUyPIes-pf8kvcCBJjkOe9mlzbq-grkXs_Acje5De94mK2dW7UWymOPMSNSy3ERc4l0a02wqLXaVErw06TVKk_Cg3Bhl6DH1J-H8CsHlMKwTlyLRbw3XqwPnAS_G9HJJac6UjXWvt964_7BoyPWJ0ImeKZcSyOaKqEV6i4hkhXJUQ8vX8o4zAhzfq3kdJmHTznCT2xZFapU9DTNXLyXfVbCCAxmIwz74LW1A_SNXNw4EPCU3bHK-yG0Gpsduv0JtEzAPdlHBS1kDQnHm_tRopvCn3Cna0g");
		headers.add("userToken", "ZWkyNTRmYWR9NWliYn1hYTUxfTFhaGZ9ZDQ2MWMyYjI0Y2Np");
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		StrideContents vehiclestrides = null;

		try {
			vehiclestrides = template.exchange(
					"http://apptest.myintelligo.com:8003/stridedata/getstridelistbyimeinumber/867459041559873/1605810600/1608402600",
					HttpMethod.GET, entity, StrideContents.class).getBody();
		} catch (Exception e) {
			e.getStackTrace();
		}

		List<VehicleStridesBean> VehicleStridesBean = vehiclestrides.getContent();
		System.out.println(keywords.getCurrentDayInEpoach());

		// API Body purpose code
//			String url = "https://extraction.myintelligo.com/stride/getStrideData/1601455413/1601458692";
//			String url1 = "https://extraction.myintelligo.com/stride/getStrideData/1601424947/1601426756";
//			String url2 = "https://extraction.myintelligo.com/stride/getStrideData/1601371418/1601374672";
//			String url3 = "https://extraction.myintelligo.com/stride/getStrideData/1601097031/1601098429";
//			String url4 = "https://extraction.myintelligo.com/stride/getStrideData/1606473848/1606474700";
//			HttpHeaders headers = new HttpHeaders();
//			List<String> primaryKeys = new ArrayList<>();
//			primaryKeys.add("VTS-867459041560376-1601455413-20");
//			HttpEntity<List<String>> gpsData = new HttpEntity<>(primaryKeys, headers);
//			List<GpsDataBean> gpsDataBean = template.exchange(url, HttpMethod.POST, gpsData, new ParameterizedTypeReference<List<GpsDataBean>>() {
//			}).getBody();
//			List<String> primaryKeys1 = new ArrayList<>();
//			primaryKeys1.add("VTS-867459041560376-1601424947-18");
//			HttpEntity<List<String>> gpsData1 = new HttpEntity<>(primaryKeys1, headers);
//			List<GpsDataBean> gpsDataBean1 = restTemplate
//			.exchange(url1, HttpMethod.POST, gpsData1, new ParameterizedTypeReference<List<GpsDataBean>>() {
//			}).getBody();
//			// List<String> primaryKeys2 = new ArrayList<>();
//			// primaryKeys.add("VTS-867459041560376-1601371418-16");
//			// HttpEntity<List<String>> gpsData2 = new HttpEntity<>(primaryKeys,headers);
//			// List<GpsDataBean> gpsDataBean2 = restTemplate.exchange(url2,
//			// HttpMethod.POST, gpsData2, new ParameterizedTypeReference<List<GpsDataBean>>() {
//			// }).getBody();
//			List<String> primaryKeys2 = new ArrayList<>();
//			primaryKeys2.add("VTS-867459041560376-1601097031-6");
//			HttpEntity<List<String>> gpsData2 = new HttpEntity<>(primaryKeys2, headers);
//			List<GpsDataBean> gpsDataBean2 = restTemplate
//			.exchange(url3, HttpMethod.POST, gpsData2, new ParameterizedTypeReference<List<GpsDataBean>>() {
//			}).getBody();
//			List<String> primaryKeys3 = new ArrayList<>();
//			primaryKeys3.add("VTS-867459041560368-1606473848-5");
//			HttpEntity<List<String>> gpsData3 = new HttpEntity<>(primaryKeys3, headers);
//			List<GpsDataBean> gpsDataBean3 = restTemplate
//			.exchange(url4, HttpMethod.POST, gpsData3, new ParameterizedTypeReference<List<GpsDataBean>>() {
//			}).getBody();

	}

}
