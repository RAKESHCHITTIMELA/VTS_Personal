package vts.listeners;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import vts.basetest.TestBase;
import vts.utils.Contents;
import vts.utils.Keywords;
import vts.utils.ReportContent;
import vts.utils.ReportsData;
import vts.utils.StrideContents;
import vts.utils.VehicleStridesBean;
import vts.utils.VehicleTripBean;
@Test
public class Reports_Function extends TestBase {

	Listeners ls = new Listeners();
	static Keywords keywords = new Keywords();
	static HttpHeaders headers = new HttpHeaders();
	static RestTemplate template = new RestTemplate();
	DecimalFormat FormatChanger = new DecimalFormat("#.##");

	/*
	 * public void reports(Object uname, Object pwd,Object vehiclenum, Object
	 * startdate, Object enddate) throws InterruptedException, ParseException,
	 * IOException {
	 * 
	 * 
	 * driver.findElementById("com.affluencesystems.admin:id/text_email").sendKeys(
	 * String.valueOf(uname));
	 * driver.findElementById("com.affluencesystems.admin:id/text_user_pass").
	 * sendKeys(String.valueOf(pwd));
	 * driver.findElementById("com.affluencesystems.admin:id/im_pass_hide").click();
	 * driver.findElementById("com.affluencesystems.admin:id/text_sign_in").click();
	 * driver.findElementByXPath(
	 * "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RadioButton")
	 * .click();
	 * driver.findElementById("com.affluencesystems.admin:id/submit").click();
	 * driver.findElementById("com.affluencesystems.admin:id/menu_img").click();
	 * //driver.findElementById("com.affluencesystems.admin:id/vehicle_number_state"
	 * ).click();
	 * 
	 * driver.findElement(MobileBy.
	 * AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
	 * ".scrollIntoView(new UiSelector().text(\""+vehiclenum+"\"))"));
	 * driver.findElementByXPath("//*[@text='"+vehiclenum+"']").click();
	 * 
	 * Thread.sleep(2000);
	 * 
	 * 
	 * driver.findElement(MobileBy.
	 * AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
	 * ".scrollIntoView(new UiSelector().resourceIdMatches(\"com.affluencesystems.admin:id/reports\"))"
	 * ));
	 * 
	 * driver.findElementById("com.affluencesystems.admin:id/reports").click();
	 * 
	 * //driver.findElementById("com.affluencesystems.admin:id/sp_selection").click(
	 * ); //int
	 * len=driver.findElementsById("com.affluencesystems.admin:id/text1").size();
	 * 
	 * try {
	 * driver.findElementById("com.affluencesystems.admin:id/sp_selection").click();
	 * List<WebElement>
	 * web=driver.findElementsById("com.affluencesystems.admin:id/text1");
	 * System.out.println(web.size()); for(int i=0;i<web.size();i++) {
	 * 
	 * //driver.findElementsById("com.affluencesystems.admin:id/text1");
	 * 
	 * 
	 * //String startDate; if(i==0) { Thread.sleep(3000);
	 * //driver.findElementById("com.affluencesystems.admin:id/text1").click();
	 * //driver.findElementByName("Today").click();
	 * 
	 * web.get(0).click();
	 * 
	 * //startDate=keywords.getEpochDateAndTime1(1);//one day date in epoch
	 * custome_report(vehiclenum, keywords.getEpochDateAndTime1(1),
	 * keywords.getCurrentDayInEpoach());
	 * 
	 * driver.findElementById("com.affluencesystems.admin:id/sp_selection").click();
	 * }else if(i==1) { Thread.sleep(3000); web.get(1).click();
	 * //driver.findElementByName("Last 7 Days").click();
	 * //driver.findElementById("com.affluencesystems.admin:id/text1").click();
	 * custome_report(vehiclenum,
	 * keywords.getEpochDateAndTime1(1),keywords.getCurrentDayInEpoach() );
	 * driver.findElementById("com.affluencesystems.admin:id/sp_selection").click();
	 * } else if(i==2) { Thread.sleep(3000); web.get(2).click();
	 * //driver.findElementByName("Last 30 Days").click();
	 * //driver.findElementById("com.affluencesystems.admin:id/text1").click();
	 * custome_report(vehiclenum, keywords.getEpochDateAndTime1(1),
	 * keywords.getCurrentDayInEpoach());
	 * driver.findElementById("com.affluencesystems.admin:id/sp_selection").click();
	 * } else { web.get(3).click(); //driver.findElementByName("Custom").click();
	 * //driver.findElementById("com.affluencesystems.admin:id/text1").click();
	 * Thread.sleep(3000); custome_report(vehiclenum, startdate, enddate); } } }
	 * catch(StaleElementReferenceException exception) { System.out.println(""); }
	 * 
	 * //driver.findElementByXPath("//*[@text='Last 30 days']").click();
	 * 
	 * 
	 * 
	 * 
	 * }
	 */	public static void custome_report(Object uname,Object pwd,Object vehiclenum, Object startdate, Object enddate)
			throws InterruptedException, ParseException, IOException, java.text.ParseException {
		
		
		
		  driver.findElementById("com.affluencesystems.admin:id/text_email").sendKeys(
		  String.valueOf(uname));
		  driver.findElementById("com.affluencesystems.admin:id/text_user_pass").
		  sendKeys(String.valueOf(pwd));
		  driver.findElementById("com.affluencesystems.admin:id/im_pass_hide").click();
		  driver.findElementById("com.affluencesystems.admin:id/text_sign_in").click();
		  driver.findElementByXPath(
		  "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RadioButton")
		  .click();
		  
		  driver.findElementById("com.affluencesystems.admin:id/submit").click(); //
		  driver.findElementById("com.affluencesystems.admin:id/menu_img").click(); //
		  
		  Thread.sleep(2000);
		  
		  driver.findElement(MobileBy.
		  AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
		  ".scrollIntoView(new UiSelector().resourceIdMatches(\"com.affluencesystems.admin:id/reports\"))"
		  ));
		  
		  driver.findElementById("com.affluencesystems.admin:id/reports").click();
		  driver.findElementById("com.affluencesystems.admin:id/sp_selection").click();
		  driver.findElementByXPath("//*[@text='Custom']").click();
		  driver.findElementById("com.affluencesystems.admin:id/lin_start").click();
		  keywords.setAndroidTripDatePicker(startdate);
		  driver.findElementById("com.affluencesystems.admin:id/lin_end").click();
		  keywords.setAndroidTripDatePicker(enddate);
		  
		// API Call
		
		headers.add("Authorization",
				"eyJraWQiOiJ3ZEJYOHZpbEVSanZEQ291MStsMEUwNG0zT3BOb2FaMml6UXZobkNKZHJBPSIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiI1YTQ4ODhkOS1mZjlmLTQwNmQtYWYyOC1iYzEwZWVmOWVkOGUiLCJhdWQiOiI3aW5lZ3ZrOXNnYXI0MzY0ZXU4M3FkcjRlbSIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwiZXZlbnRfaWQiOiI0OWU5MjAxNC0xOGRiLTRhZjktYWU4My04MTc1NGVmM2M1NTciLCJ0b2tlbl91c2UiOiJpZCIsImF1dGhfdGltZSI6MTYwODAxNDM2NSwiaXNzIjoiaHR0cHM6XC9cL2NvZ25pdG8taWRwLmFwLXNvdXRoLTEuYW1hem9uYXdzLmNvbVwvYXAtc291dGgtMV9PWEZkdlc3b08iLCJjb2duaXRvOnVzZXJuYW1lIjoiNWE0ODg4ZDktZmY5Zi00MDZkLWFmMjgtYmMxMGVlZjllZDhlIiwicGhvbmVfbnVtYmVyIjoiKzkxNzAzNjQ3ODI4MiIsImV4cCI6MTYwODAxNzk2NSwiaWF0IjoxNjA4MDE0MzY1LCJlbWFpbCI6IkluZm85ODc2QGdtYWlsLmNvbSJ9.IivlQcE7HkDYD5Fy-3fGdxnjE1K01KAyxbooRlG-BsBkTllVhzeWpqHIdUyPIes-pf8kvcCBJjkOe9mlzbq-grkXs_Acje5De94mK2dW7UWymOPMSNSy3ERc4l0a02wqLXaVErw06TVKk_Cg3Bhl6DH1J-H8CsHlMKwTlyLRbw3XqwPnAS_G9HJJac6UjXWvt964_7BoyPWJ0ImeKZcSyOaKqEV6i4hkhXJUQ8vX8o4zAhzfq3kdJmHTznCT2xZFapU9DTNXLyXfVbCCAxmIwz74LW1A_SNXNw4EPCU3bHK-yG0Gpsduv0JtEzAPdlHBS1kDQnHm_tRopvCn3Cna0g");
		headers.add("userToken", "ZWkyNTRmYWR9NWliYn1hYTUxfTFhaGZ9ZDQ2MWMyYjI0Y2Np");
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		
		
		ReportContent vehicle_report = null;

		try {
			vehicle_report = template
					.exchange("http://apptest.myintelligo.com:8003/fuelstatistics/getfuelstatsdatebydateinbetweendatesbasedonimeinumberandstartandenddate/"+keywords.getVehicleImeinumber(vehiclenum) + "/"
							+ keywords.getEpoachDate(startdate) + "/" + keywords.getEpoachDate(enddate) + "", HttpMethod.GET, entity, ReportContent.class)
					.getBody();
			//System.out.println(vehicle_report.getContent());
			System.out.println("Startdate: "+keywords.getEpoachDate(startdate)+", Enddate: "+keywords.getEpoachDate(enddate)+", IMEI: "+keywords.getVehicleImeinumber(vehiclenum)+","+vehiclenum);
			
		} catch (Exception e) {
			e.getStackTrace();
		}


		try{if(vehicle_report.getContent()!=null) {
		List<ReportsData> reports = vehicle_report.getContent();
		if(!(reports.size()==0) && reports!=null) {
		
		for(int i= 0;i<reports.size();i++) {
		long report_startTime = reports.get(i).getStartTime();
		System.out.println(reports.get(i).getStartTime()+", enddate"+reports.get(i).getEndTime()+", startTime:"+keywords.getEpochDateAndTime(report_startTime)+"startTime:"+keywords.getEpochDateAndTime(reports.get(i).getEndTime()));
		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().className(\"androidx.recyclerview.widget.RecyclerView\")).getChildByText(new UiSelector().className(\"android.widget.TextView\"),\""
						+  keywords.getEpochDateAndTime(report_startTime).substring(0,11)+ "\")"));
		driver.findElementByXPath("//*[@text='" + keywords.getEpochDateAndTime(report_startTime).substring(0, 11) + "']").click();

		
		
		  String travelled_distance=driver.findElementById(
		  "com.affluencesystems.admin:id/distance_travelled").getAttribute("text");
		  String fuel_consumption=driver.findElementById(
		  "com.affluencesystems.admin:id/fuel_consumed").getAttribute("text"); 
		  String travel_time=driver.findElementById(
		  "com.affluencesystems.admin:id/driven_time").getAttribute("text"); 
		  String total_cost=driver.findElementById(
		  "com.affluencesystems.admin:id/cost_of_drive").getAttribute("text"); 
		  String mileage=driver.findElementById("com.affluencesystems.admin:id/tv_Mileage").
		  getAttribute("text");
		  
		  System.out.println("Time: "+travelled_distance+", fuel_Consumption: "
		  +fuel_consumption+", travel_time"+travel_time+", cost:"
		  +total_cost+", mileage"+mileage);
		
		}}}
		else {
			System.out.println("No Data Found");
		}}
		catch(Exception e) {
			System.out.println("No Data Found");
		}
	}
	
	
}
