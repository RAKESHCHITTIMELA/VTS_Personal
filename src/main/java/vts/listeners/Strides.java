package vts.listeners;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import vts.basetest.TestBase;
import vts.utils.Contents;
import vts.utils.Keywords;
import vts.utils.StrideContents;
import vts.utils.VehicleStridesBean;
import vts.utils.VehicleTripBean;


public class Strides extends TestBase {

	Listeners ls = new Listeners();
	Keywords keywords = new Keywords();
	HttpHeaders headers = new HttpHeaders();
	RestTemplate template = new RestTemplate();
	DecimalFormat FormatChanger = new DecimalFormat("#.##");

	public void strides(Object uname, Object pwd, Object vehiclenum, Object startdate, Object enddate)
			throws InterruptedException, ParseException, IOException, java.text.ParseException {

		// ls.login(uname, pwd);
		driver.findElementById("com.affluencesystems.admin:id/text_email").sendKeys(String.valueOf(uname));
		driver.findElementById("com.affluencesystems.admin:id/text_user_pass").sendKeys(String.valueOf(pwd));
		driver.findElementById("com.affluencesystems.admin:id/im_pass_hide").click();
		driver.findElementById("com.affluencesystems.admin:id/text_sign_in").click();
		driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RadioButton")
				.click();
<<<<<<< HEAD
		// driver.findElementByXPath( //
		// "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[7]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RadioButton")
		// .click();

		// driver.findElement(MobileBy. AndroidUIAutomator("new UiScrollable(new
		// UiSelector().scrollable(true))" +".scrollIntoView(new
		// UiSelector().text(\""+vehiclenum+"\"))"));
		// driver.findElementByXPath("//*[@text='"+vehiclenum+"']").click();

		driver.findElementById("com.affluencesystems.admin:id/submit").click();

		driver.findElementById("com.affluencesystems.admin:id/menu_img").click();
		// driver.findElementById("com.affluencesystems.admin:id/vehicle_number_state").
		// click();
		// driver.findElement(MobileBy.
		// AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" // +
		// ".scrollIntoView(new UiSelector().text(\""+vehiclenum+"\"))")); //
		// driver.findElementByXPath("//*[@text='"+vehiclenum+"']").click();
		Thread.sleep(2000);
		driver.findElementById("com.affluencesystems.admin:id/strideList").click();// com.affluencesystems.admin:id/strideList

		driver.findElementById("com.affluencesystems.admin:id/sp_selection").click();
		driver.findElementByXPath("//*[@text='Custom']").click();
		driver.findElementById("com.affluencesystems.admin:id/start_date_layout").click();
		keywords.setAndroidTripDatePicker(startdate);
		driver.findElementById("com.affluencesystems.admin:id/end_date_layout").click();
		keywords.setAndroidTripDatePicker(enddate);

		// driver.findElementById("com.affluencesystems.admin:id/start_date_layout").
		// click();//android:id/prev //keywords.setAndroidTripDatePicker(startdate);
		// driver.findElementById("com.affluencesystems.admin:id/end_date_layout").click();
		// //keywords.setAndroidTripDatePicker(enddate);

		// API Call

		headers.add("Authorization",
				"eyJraWQiOiJ3ZEJYOHZpbEVSanZEQ291MStsMEUwNG0zT3BOb2FaMml6UXZobkNKZHJBPSIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiI1YTQ4ODhkOS1mZjlmLTQwNmQtYWYyOC1iYzEwZWVmOWVkOGUiLCJhdWQiOiI3aW5lZ3ZrOXNnYXI0MzY0ZXU4M3FkcjRlbSIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwiZXZlbnRfaWQiOiI0OWU5MjAxNC0xOGRiLTRhZjktYWU4My04MTc1NGVmM2M1NTciLCJ0b2tlbl91c2UiOiJpZCIsImF1dGhfdGltZSI6MTYwODAxNDM2NSwiaXNzIjoiaHR0cHM6XC9cL2NvZ25pdG8taWRwLmFwLXNvdXRoLTEuYW1hem9uYXdzLmNvbVwvYXAtc291dGgtMV9PWEZkdlc3b08iLCJjb2duaXRvOnVzZXJuYW1lIjoiNWE0ODg4ZDktZmY5Zi00MDZkLWFmMjgtYmMxMGVlZjllZDhlIiwicGhvbmVfbnVtYmVyIjoiKzkxNzAzNjQ3ODI4MiIsImV4cCI6MTYwODAxNzk2NSwiaWF0IjoxNjA4MDE0MzY1LCJlbWFpbCI6IkluZm85ODc2QGdtYWlsLmNvbSJ9.IivlQcE7HkDYD5Fy-3fGdxnjE1K01KAyxbooRlG-BsBkTllVhzeWpqHIdUyPIes-pf8kvcCBJjkOe9mlzbq-grkXs_Acje5De94mK2dW7UWymOPMSNSy3ERc4l0a02wqLXaVErw06TVKk_Cg3Bhl6DH1J-H8CsHlMKwTlyLRbw3XqwPnAS_G9HJJac6UjXWvt964_7BoyPWJ0ImeKZcSyOaKqEV6i4hkhXJUQ8vX8o4zAhzfq3kdJmHTznCT2xZFapU9DTNXLyXfVbCCAxmIwz74LW1A_SNXNw4EPCU3bHK-yG0Gpsduv0JtEzAPdlHBS1kDQnHm_tRopvCn3Cna0g");
		headers.add("userToken", "ZWkyNTRmYWR9NWliYn1hYTUxfTFhaGZ9ZDQ2MWMyYjI0Y2Np");
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		StrideContents vehicleStridesData = null;

		try {
			vehicleStridesData = template.exchange(
					// http://apptest.myintelligo.com:8003/stridedata/getstridelistbyimeinumber/867459041559873/keywords.getEpoachDate(enddate)/?pageNumber=1&pageSize=10
					"http://apptest.myintelligo.com:8003/stridedata/getstridelistbyimeinumber/"
							+ keywords.getVehicleImeinumber(vehiclenum) + "/" + keywords.getEpoachDate(startdate) + "/"
							+ keywords.getEpoachDate(enddate) + "",
					HttpMethod.GET, entity, StrideContents.class).getBody();
			System.out.println("Startdate:" + keywords.getEpoachDate(startdate) + ", End Date: "
					+ keywords.getEpoachDate(enddate) + "Vehicle Number: " + vehiclenum + ", Vehicle NUMEI NUmber: "
					+ keywords.getVehicleImeinumber(vehiclenum));
		} catch (Exception e) {
			e.getStackTrace();
		}

		List<VehicleStridesBean> vehicle = vehicleStridesData.getContent();
		if (!(vehicle.size() == 0)) {

			for (int i = 0; i < vehicle.size(); i++) {
				long startDate1 = vehicle.get(i).getStartDate();
				long endDate1 = vehicle.get(i).getEndDate();

				driver.findElement(MobileBy.AndroidUIAutomator(
						"new UiScrollable(new UiSelector().className(\"androidx.recyclerview.widget.RecyclerView\")).getChildByText(new UiSelector().className(\"android.widget.TextView\"),\""
								+ keywords.getEpochDateAndTime(startDate1) + "\")"));
				driver.findElementByXPath("//*[@text='" + keywords.getEpochDateAndTime(startDate1) + " to "
						+ keywords.getEpochDateAndTime(endDate1) + "']").click();

				// distance

				String distance2 = driver.findElementById("com.affluencesystems.admin:id/distance").getText();
				String distance3 = (String) distance2.substring(0, distance2.length() - 3);

				String distance1 = FormatChanger.format(vehicle.get(i).getDistanceSinceStrideON() / 1000.0).toString();
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

				// time String time1

				String time1 = driver.findElementById("com.affluencesystems.admin:id/time").getText();
				int time = Math.round(vehicle.get(i).getTravelledTime());
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

				// mileage String mileage1 =
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

	public void previousStrideData(Object uname, Object pwd, Object vehiclenum, Object startdate, Object enddate)
=======
	  //driver.findElementByXPath( //
	 // "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[7]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RadioButton")
	  //.click();
	  
	//  driver.findElement(MobileBy. AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +".scrollIntoView(new UiSelector().text(\""+vehiclenum+"\"))"));
	  //driver.findElementByXPath("//*[@text='"+vehiclenum+"']").click();
	  
	  driver.findElementById("com.affluencesystems.admin:id/submit").click(); 
	  Thread.sleep(3000);
	  driver.findElementById("com.affluencesystems.admin:id/menu_img").click();
	  //driver.findElementById("com.affluencesystems.admin:id/menu_img").click(); 
	  //driver.findElementById("com.affluencesystems.admin:id/vehicle_number_state"). click();
	  // driver.findElement(MobileBy.
	  //AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" // +
	  //".scrollIntoView(new UiSelector().text(\""+vehiclenum+"\"))")); //
	//  driver.findElementByXPath("//*[@text='"+vehiclenum+"']").click();
	  Thread.sleep(2000); 
	  driver.findElementById( "com.affluencesystems.admin:id/strideList").click();//com.affluencesystems.admin:id/strideList
	  
	  
	  
	  driver.findElementById("com.affluencesystems.admin:id/sp_selection").click();
	  driver.findElementByXPath("//*[@text='Custom']").click();
	  driver.findElementById("com.affluencesystems.admin:id/start_date_layout").
	  click();
	  keywords.setAndroidTripDatePicker(startdate);
	  driver.findElementById("com.affluencesystems.admin:id/end_date_layout").click();
	  keywords.setAndroidTripDatePicker(enddate);
	  
	  
	  //driver.findElementById("com.affluencesystems.admin:id/start_date_layout").
	 // click();//android:id/prev //keywords.setAndroidTripDatePicker(startdate);
	  //driver.findElementById("com.affluencesystems.admin:id/end_date_layout").click(); //keywords.setAndroidTripDatePicker(enddate);
	  
	  // API Call
	  
	  headers.add("Authorization",
	  "eyJraWQiOiJ3ZEJYOHZpbEVSanZEQ291MStsMEUwNG0zT3BOb2FaMml6UXZobkNKZHJBPSIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiI1YTQ4ODhkOS1mZjlmLTQwNmQtYWYyOC1iYzEwZWVmOWVkOGUiLCJhdWQiOiI3aW5lZ3ZrOXNnYXI0MzY0ZXU4M3FkcjRlbSIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwiZXZlbnRfaWQiOiI0OWU5MjAxNC0xOGRiLTRhZjktYWU4My04MTc1NGVmM2M1NTciLCJ0b2tlbl91c2UiOiJpZCIsImF1dGhfdGltZSI6MTYwODAxNDM2NSwiaXNzIjoiaHR0cHM6XC9cL2NvZ25pdG8taWRwLmFwLXNvdXRoLTEuYW1hem9uYXdzLmNvbVwvYXAtc291dGgtMV9PWEZkdlc3b08iLCJjb2duaXRvOnVzZXJuYW1lIjoiNWE0ODg4ZDktZmY5Zi00MDZkLWFmMjgtYmMxMGVlZjllZDhlIiwicGhvbmVfbnVtYmVyIjoiKzkxNzAzNjQ3ODI4MiIsImV4cCI6MTYwODAxNzk2NSwiaWF0IjoxNjA4MDE0MzY1LCJlbWFpbCI6IkluZm85ODc2QGdtYWlsLmNvbSJ9.IivlQcE7HkDYD5Fy-3fGdxnjE1K01KAyxbooRlG-BsBkTllVhzeWpqHIdUyPIes-pf8kvcCBJjkOe9mlzbq-grkXs_Acje5De94mK2dW7UWymOPMSNSy3ERc4l0a02wqLXaVErw06TVKk_Cg3Bhl6DH1J-H8CsHlMKwTlyLRbw3XqwPnAS_G9HJJac6UjXWvt964_7BoyPWJ0ImeKZcSyOaKqEV6i4hkhXJUQ8vX8o4zAhzfq3kdJmHTznCT2xZFapU9DTNXLyXfVbCCAxmIwz74LW1A_SNXNw4EPCU3bHK-yG0Gpsduv0JtEzAPdlHBS1kDQnHm_tRopvCn3Cna0g"
	  ); headers.add("userToken",
	  "ZWkyNTRmYWR9NWliYn1hYTUxfTFhaGZ9ZDQ2MWMyYjI0Y2Np"); HttpEntity<String>
	  entity = new HttpEntity<String>(headers); 
	  StrideContents vehicleStridesData =null;
	  
	  try { vehicleStridesData = template .exchange(
			//  http://apptest.myintelligo.com:8003/stridedata/getstridelistbyimeinumber/867459041559873/keywords.getEpoachDate(enddate)/?pageNumber=1&pageSize=10
	  "http://apptest.myintelligo.com:8003/stridedata/getstridelistbyimeinumber/" +
	  keywords.getVehicleImeinumber(vehiclenum) + "/" +
	  keywords.getEpoachDate(startdate) + "/" + keywords.getEpoachDate(enddate) +
	  "", HttpMethod.GET, entity, StrideContents.class) .getBody(); 
	  System.out.println("Startdate:"+keywords.getEpoachDate(startdate)+ ", End Date: "+keywords.getEpoachDate(enddate)+"Vehicle Number: "+vehiclenum+", Vehicle NUMEI NUmber: "+keywords.getVehicleImeinumber(vehiclenum));
	  }
	  catch(Exception e) { e.getStackTrace(); }
	  
	  
	  List<VehicleStridesBean> vehicle = vehicleStridesData.getContent();
	  if(!(vehicle.size()==0)) {
	  
	  for(int i= 0;i<vehicle.size();i++) { 
		  long startDate1 = vehicle.get(i).getStartDate();
		  long endDate1 = vehicle.get(i).getEndDate();
		  
	  driver.findElement(MobileBy.AndroidUIAutomator(
	  "new UiScrollable(new UiSelector().className(\"androidx.recyclerview.widget.RecyclerView\")).getChildByText(new UiSelector().className(\"android.widget.TextView\"),\""
	  + keywords.getEpochDateAndTime(startDate1) + "\")"));
	  driver.findElementByXPath("//*[@text='" +
	  keywords.getEpochDateAndTime(startDate1) +" to "+keywords.getEpochDateAndTime(endDate1)+ "']").click();
	  
	  // distance
	  
	  String distance2 =
	  driver.findElementById("com.affluencesystems.admin:id/distance").getText();
	  String distance3 = (String) distance2.substring(0, distance2.length() - 3);
	  
	  String distance1 =
	  FormatChanger.format(vehicle.get(i).getDistanceSinceStrideON() /
	  1000.0).toString(); if (!(distance1.equals("0.0"))) {
	  System.out.println(distance1 + distance3); if (distance1.equals(distance3)) {
	  System.out.println("distance is equal"); } else {
	  System.out.println("distance is not equal"); } } else { String[] d =
	  distance1.split("."); if (d[0].equals(distance3)) {
	  System.out.println("distance is equal"); } else {
	  System.out.println("distance is not equal"); } }
	  
	  // time String time1 
	  
	 String time1= driver.findElementById("com.affluencesystems.admin:id/time").getText();
	  int time = Math.round(vehicle.get(i).getTravelledTime()); 
	  if
	  (!(String.valueOf(time).equals("0"))) { Date date = new Date(time * 1000);
	  SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	  sdf.setTimeZone(TimeZone.getTimeZone("UTC")); String formattedDate =
	  sdf.format(date); System.out.println(formattedDate); 
	  if (time1.equals(formattedDate)) { System.out.println("Time is equal"); } else {
	  System.out.println("Time is not equal"); }
	  
	  } else { String t = String.valueOf(time); t = "00:00:00";
	  if(time1.equals(t)) { System.out.println("Time is equal"); } else {
	  System.out.println("Time is not equal"); } }
	  
	  // fuel
	  
	  String fuel2 =
	  driver.findElementById("com.affluencesystems.admin:id/fuel").getText();
	  String fuel3 = (String) fuel2.substring(0, fuel2.length() - 2);
	  
	  String fuel1 = FormatChanger.format(vehicle.get(i).getFuelConsumed() /
	  1000.0).toString(); System.out.println(fuel1 + fuel3); if
	  (fuel1.equals(fuel3)) { System.out.println("fuel is equal"); } else {
	  System.out.println("fuel is not equal"); }
	  
	  // mileage String mileage1 =
	  String mileage1=driver.findElementById("com.affluencesystems.admin:id/mileage").getText();
	  String mileage2 = (String) mileage1.substring(0, mileage1.length() - 5);
	  float dist1 = Float.valueOf(distance3); float fuel4 = Float.valueOf(fuel3);
	  if(!(fuel3.equals("0"))) { String mileage3 = FormatChanger.format(dist1 /
	  fuel4).toString(); System.out.println(mileage2 + mileage3); if
	  (mileage2.equals(mileage3)) { System.out.println("mileage is equal"); } else
	  { System.out.println("mileage is not equal"); } }else { String m = "0"; if
	  (mileage2.equals(m)) { System.out.println("mileage is equal"); } else {
	  System.out.println("mileage is not equal"); } }
	  driver.findElementById("com.affluencesystems.admin:id/dismiss").click(); }
	  }else { System.out.println("No Trips are there"); } }
	  
	  public void previousStrideData(Object uname, Object pwd, Object vehiclenum, Object startdate, Object enddate)
>>>>>>> 900edd9a00b22a4c6b9f05e797debdc8ec0d5e11
			throws InterruptedException {

		driver.findElementById("com.affluencesystems.admin:id/text_email").sendKeys(String.valueOf(uname));
		driver.findElementById("com.affluencesystems.admin:id/text_user_pass").sendKeys(String.valueOf(pwd));
		driver.findElementById("com.affluencesystems.admin:id/im_pass_hide").click();
		driver.findElementById("com.affluencesystems.admin:id/text_sign_in").click();

		driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[7]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RadioButton")
				.click();

		/*
		 * driver.findElement(MobileBy.
		 * AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
		 * ".scrollIntoView(new UiSelector().text(\""+vehiclenum+"\"))"));
		 * driver.findElementByXPath(
		 * "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[5]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RadioButton"
		 * ).click();
		 */

		driver.findElementById("com.affluencesystems.admin:id/submit").click();

		Thread.sleep(2000);
		driver.findElementById("com.affluencesystems.admin:id/menu_img").click();
		driver.findElementById("com.affluencesystems.admin:id/strideList").click();

		driver.findElementById("com.affluencesystems.admin:id/sp_selection").click();
		driver.findElementByXPath("//*[@text='Last 7 Days']").click();

		headers.add("Authorization",
				"eyJraWQiOiJ3ZEJYOHZpbEVSanZEQ291MStsMEUwNG0zT3BOb2FaMml6UXZobkNKZHJBPSIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiI1YTQ4ODhkOS1mZjlmLTQwNmQtYWYyOC1iYzEwZWVmOWVkOGUiLCJhdWQiOiI3aW5lZ3ZrOXNnYXI0MzY0ZXU4M3FkcjRlbSIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwiZXZlbnRfaWQiOiI0OWU5MjAxNC0xOGRiLTRhZjktYWU4My04MTc1NGVmM2M1NTciLCJ0b2tlbl91c2UiOiJpZCIsImF1dGhfdGltZSI6MTYwODAxNDM2NSwiaXNzIjoiaHR0cHM6XC9cL2NvZ25pdG8taWRwLmFwLXNvdXRoLTEuYW1hem9uYXdzLmNvbVwvYXAtc291dGgtMV9PWEZkdlc3b08iLCJjb2duaXRvOnVzZXJuYW1lIjoiNWE0ODg4ZDktZmY5Zi00MDZkLWFmMjgtYmMxMGVlZjllZDhlIiwicGhvbmVfbnVtYmVyIjoiKzkxNzAzNjQ3ODI4MiIsImV4cCI6MTYwODAxNzk2NSwiaWF0IjoxNjA4MDE0MzY1LCJlbWFpbCI6IkluZm85ODc2QGdtYWlsLmNvbSJ9.IivlQcE7HkDYD5Fy-3fGdxnjE1K01KAyxbooRlG-BsBkTllVhzeWpqHIdUyPIes-pf8kvcCBJjkOe9mlzbq-grkXs_Acje5De94mK2dW7UWymOPMSNSy3ERc4l0a02wqLXaVErw06TVKk_Cg3Bhl6DH1J-H8CsHlMKwTlyLRbw3XqwPnAS_G9HJJac6UjXWvt964_7BoyPWJ0ImeKZcSyOaKqEV6i4hkhXJUQ8vX8o4zAhzfq3kdJmHTznCT2xZFapU9DTNXLyXfVbCCAxmIwz74LW1A_SNXNw4EPCU3bHK-yG0Gpsduv0JtEzAPdlHBS1kDQnHm_tRopvCn3Cna0g");
		headers.add("userToken", "ZWkyNTRmYWR9NWliYn1hYTUxfTFhaGZ9ZDQ2MWMyYjI0Y2Np");
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		StrideContents vehicleStrideData = null;

		try {
			vehicleStrideData = template
					.exchange(
							"http://apptest.myintelligo.com:8003/stridedata/getstridelistbyimeinumber/"
									+ keywords.getVehicleImeinumber(vehiclenum) + "/"
									+ keywords.getEpoachDate2(keywords.getLastDaysDate(7)) + "/"
									+ keywords.getCurrentDayInEpoach() + "",
							HttpMethod.GET, entity, StrideContents.class)
					.getBody();
		} catch (Exception e) {
			e.getStackTrace();
		}

		List<VehicleStridesBean> vehicle = vehicleStrideData.getContent();
		if (!(vehicle.size() == 0)) {
			driver.findElement(MobileBy.AndroidUIAutomator(
					"new UiScrollable(new UiSelector().className(\"androidx.recyclerview.widget.RecyclerView\")).getChildByText(new UiSelector().className(\"android.widget.TextView\"),\""
							+ vehicle.get(vehicle.size() - 1).getStartDate() + "\")"));
		} else {
			String nodatatext = driver.findElementById("com.affluencesystems.admin:id/no_docs").getText();

			System.out.println(nodatatext);
			System.out.println("No Strides");
		}

	}

}
