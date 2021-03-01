package vts.utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import freemarker.core.ParseException;
import vts.basetest.TestBase;

public class Keywords extends TestBase {

	public void goToMenu() throws InterruptedException {

		String Menu = "Menu";
		while (!(Menu.equalsIgnoreCase("Profile"))) {
			Menu = driver.findElementById("com.affluencesystems.admin:id/header_text").getText();

			if (!(Menu.equalsIgnoreCase("Profile"))) {
				driver.findElementById("com.affluencesystems.admin:id/back_button").click();
				Thread.sleep(2000);

			}
		}
	}

	// using method we can conver epoch date to this format(dd-mm-2020)
	public String getEpochDateCovert(long date) {

		System.out.println(date);

		long date1 = date * 1000;
		Date date_format = new Date(date1);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy, hh:mm:ss a", Locale.ENGLISH);
		// sdf.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
		String formattedDate = sdf.format(date_format);
		System.out.println(formattedDate);

		return formattedDate;
	}

	public String getLastDaysDate(long days) {

		LocalDateTime datetime1 = LocalDateTime.now();
		LocalDateTime datetime2 = datetime1.minusDays(days);
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd MM yy, HH:mm:ss a");
		String last30daysdate = datetime2.format(format);
		return last30daysdate;
		// dd MMM yy, HH:mm:ss a
	}

	public String getEpochDateAndTime1(long date) {

		LocalDateTime datetime1 = LocalDateTime.now();
		LocalDateTime datetime2 = datetime1.minusDays(date);
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		String last30daysdate = datetime2.format(format);
		return last30daysdate;
	}

	public String getEpochDateAndTime(long date) {

		System.out.println(date);

		long date1 = date * 1000;
		Date date_format = new Date(date1);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy, hh:mm:ss a", Locale.ENGLISH);
		// sdf.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
		String formattedDate = sdf.format(date_format);
		System.out.println(formattedDate);

		return formattedDate;

		/*
		 * LocalDateTime datetime1 = LocalDateTime.now(); LocalDateTime datetime2 =
		 * datetime1.minusDays(date); DateTimeFormatter format =
		 * DateTimeFormatter.ofPattern("dd MM yyyy"); String last30daysdate =
		 * datetime2.format(format); return last30daysdate;
		 * 
		 * 
		 * LocalDateTime dateTime = LocalDateTime.ofEpochSecond(seconds, 0,
		 * ZoneOffset.UTC); DateTimeFormatter formatter =
		 * DateTimeFormatter.ofPattern("EEEE,MMMM d,yyyy h:mm,a", Locale.ENGLISH);
		 * String formattedDate = dateTime.format(formatter);
		 * System.out.println(formattedDate); // Tuesday,November 1,2011 12:00,AM
		 * 
		 */
	}

	public long getLastDayDates(int days) {
		Calendar calendar = Calendar.getInstance();
//		calendar.set(Calendar.AM_PM, Calendar.AM);
//		calendar.set(Calendar.HOUR, 0);
//		calendar.set(Calendar.MINUTE, 0);
//		calendar.set(Calendar.SECOND, 0);
//		

		calendar.add(Calendar.DATE, days);

		return calendar.getTimeInMillis() / 1000;

	}

//	public static void main(String[] args) {
//	
//		System.out.println(getLastDayDates(30));
//	}

	public long getCurrentDayInEpoach() {
		long epoch = System.currentTimeMillis() / 1000;
		return epoch;
	}
	/*
	 * public String getEpochDateAndTime(long date){ long date1=date*1000L; Date
	 * date_format = new Date(date1); SimpleDateFormat sdf = new
	 * SimpleDateFormat("dd MMM yy,HH:mm:ss a", Locale.ENGLISH);
	 * sdf.setTimeZone(TimeZone.getTimeZone("UTC")); String formattedDate =
	 * sdf.format(date_format); System.out.println(formattedDate);
	 * 
	 * 
	 * 
	 * return formattedDate;
	 * 
	 * 
	 * LocalDateTime dateTime = LocalDateTime.ofEpochSecond(seconds, 0,
	 * ZoneOffset.UTC); DateTimeFormatter formatter =
	 * DateTimeFormatter.ofPattern("EEEE,MMMM d,yyyy h:mm,a", Locale.ENGLISH);
	 * String formattedDate = dateTime.format(formatter);
	 * System.out.println(formattedDate); // Tuesday,November 1,2011 12:00,AM
	 * 
	 * 
	 * }
	 */

	public long getEpoachDate2(Object date) throws java.text.ParseException {
		String[] splitdate = ((String) date).split(" ");

		long epoach = new java.text.SimpleDateFormat("dd/MM/yyyy")
				.parse(splitdate[0] + "/" + splitdate[1] + "/" + splitdate[2]).getTime() / 1000;

		return epoach;

	}

	public long getEpoachDate(Object date) throws ParseException, java.text.ParseException {
		String[] splitdate = ((String) date).split(" ");
		int month = getMonthNumber(splitdate[1]);

		long epoach = new java.text.SimpleDateFormat("dd/MM/yyyy")
				.parse(splitdate[0] + "/" + month + "/" + splitdate[2]).getTime() / 1000;

		return epoach;
	}

	public String getVehicleImeinumber(Object vehiclenum) {
		String vehicle = vehiclenum.toString();
		RestTemplate template = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization",
				"eyJraWQiOiJ3ZEJYOHZpbEVSanZEQ291MStsMEUwNG0zT3BOb2FaMml6UXZobkNKZHJBPSIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiI1YTQ4ODhkOS1mZjlmLTQwNmQtYWYyOC1iYzEwZWVmOWVkOGUiLCJhdWQiOiI3aW5lZ3ZrOXNnYXI0MzY0ZXU4M3FkcjRlbSIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwiZXZlbnRfaWQiOiI0OWU5MjAxNC0xOGRiLTRhZjktYWU4My04MTc1NGVmM2M1NTciLCJ0b2tlbl91c2UiOiJpZCIsImF1dGhfdGltZSI6MTYwODAxNDM2NSwiaXNzIjoiaHR0cHM6XC9cL2NvZ25pdG8taWRwLmFwLXNvdXRoLTEuYW1hem9uYXdzLmNvbVwvYXAtc291dGgtMV9PWEZkdlc3b08iLCJjb2duaXRvOnVzZXJuYW1lIjoiNWE0ODg4ZDktZmY5Zi00MDZkLWFmMjgtYmMxMGVlZjllZDhlIiwicGhvbmVfbnVtYmVyIjoiKzkxNzAzNjQ3ODI4MiIsImV4cCI6MTYwODAxNzk2NSwiaWF0IjoxNjA4MDE0MzY1LCJlbWFpbCI6IkluZm85ODc2QGdtYWlsLmNvbSJ9.IivlQcE7HkDYD5Fy-3fGdxnjE1K01KAyxbooRlG-BsBkTllVhzeWpqHIdUyPIes-pf8kvcCBJjkOe9mlzbq-grkXs_Acje5De94mK2dW7UWymOPMSNSy3ERc4l0a02wqLXaVErw06TVKk_Cg3Bhl6DH1J-H8CsHlMKwTlyLRbw3XqwPnAS_G9HJJac6UjXWvt964_7BoyPWJ0ImeKZcSyOaKqEV6i4hkhXJUQ8vX8o4zAhzfq3kdJmHTznCT2xZFapU9DTNXLyXfVbCCAxmIwz74LW1A_SNXNw4EPCU3bHK-yG0Gpsduv0JtEzAPdlHBS1kDQnHm_tRopvCn3Cna0g");
		headers.add("userToken", "ZWkyNTRmYWR9NWliYn1hYTUxfTFhaGZ9ZDQ2MWMyYjI0Y2Np");
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		UserLoginBean Imeinumber = new UserLoginBean();

		try {
			Imeinumber = template
					.exchange("http://apptest.myintelligo.com:8003/userlogin/logindetails/pranaviravella@gmail.co",
							HttpMethod.POST, entity, UserLoginBean.class)
					.getBody();
		} catch (Exception e) {
			e.getStackTrace();
		}

		List<VehicleDeviceOrganizationBean> vehicleDeviceOrganizationBean = Imeinumber
				.getVehicleDeviceOrganizationBean();
		List<UserVehicleDataBean> vehicleData = new ArrayList<UserVehicleDataBean>();
		List<String> vehicleList = new ArrayList<String>();
		for (int i = 0; i <= vehicleDeviceOrganizationBean.size() - 1; i++) {
			if (vehicleDeviceOrganizationBean.get(i).getVehicleData() != null) {
				vehicleList.add(vehicleDeviceOrganizationBean.get(i).getVehicleData().getVehicleNumber());
				vehicleData.add(vehicleDeviceOrganizationBean.get(i).getVehicleData());
			}
		}
		String imeiNumber = null;
		for (UserVehicleDataBean i : vehicleData) {
			if (i.getVehicleNumber().equalsIgnoreCase(vehicle)) {
				imeiNumber = i.getImeiNumber();
			}
		}
		System.out.println("imei Number" + imeiNumber);
		return imeiNumber;

	}

	public int getIndexOfVehicle(Object vehiclenumber) {

		RestTemplate template = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization",
				"eyJraWQiOiJ3ZEJYOHZpbEVSanZEQ291MStsMEUwNG0zT3BOb2FaMml6UXZobkNKZHJBPSIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiI1YTQ4ODhkOS1mZjlmLTQwNmQtYWYyOC1iYzEwZWVmOWVkOGUiLCJhdWQiOiI3aW5lZ3ZrOXNnYXI0MzY0ZXU4M3FkcjRlbSIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwiZXZlbnRfaWQiOiI0OWU5MjAxNC0xOGRiLTRhZjktYWU4My04MTc1NGVmM2M1NTciLCJ0b2tlbl91c2UiOiJpZCIsImF1dGhfdGltZSI6MTYwODAxNDM2NSwiaXNzIjoiaHR0cHM6XC9cL2NvZ25pdG8taWRwLmFwLXNvdXRoLTEuYW1hem9uYXdzLmNvbVwvYXAtc291dGgtMV9PWEZkdlc3b08iLCJjb2duaXRvOnVzZXJuYW1lIjoiNWE0ODg4ZDktZmY5Zi00MDZkLWFmMjgtYmMxMGVlZjllZDhlIiwicGhvbmVfbnVtYmVyIjoiKzkxNzAzNjQ3ODI4MiIsImV4cCI6MTYwODAxNzk2NSwiaWF0IjoxNjA4MDE0MzY1LCJlbWFpbCI6IkluZm85ODc2QGdtYWlsLmNvbSJ9.IivlQcE7HkDYD5Fy-3fGdxnjE1K01KAyxbooRlG-BsBkTllVhzeWpqHIdUyPIes-pf8kvcCBJjkOe9mlzbq-grkXs_Acje5De94mK2dW7UWymOPMSNSy3ERc4l0a02wqLXaVErw06TVKk_Cg3Bhl6DH1J-H8CsHlMKwTlyLRbw3XqwPnAS_G9HJJac6UjXWvt964_7BoyPWJ0ImeKZcSyOaKqEV6i4hkhXJUQ8vX8o4zAhzfq3kdJmHTznCT2xZFapU9DTNXLyXfVbCCAxmIwz74LW1A_SNXNw4EPCU3bHK-yG0Gpsduv0JtEzAPdlHBS1kDQnHm_tRopvCn3Cna0g");
		headers.add("userToken", "ZWkyNTRmYWR9NWliYn1hYTUxfTFhaGZ9ZDQ2MWMyYjI0Y2Np");
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		UserLoginBean Imeinumber = new UserLoginBean();

		try {
			Imeinumber = template.exchange(
					"http://apptest.myintelligo.com:8003/userlogin/logindetails/haripriyaa@affluencesystems.com",
					HttpMethod.POST, entity, UserLoginBean.class).getBody();
		} catch (Exception e) {
			e.getStackTrace();
		}

		List<VehicleDeviceOrganizationBean> vehicleDeviceOrganizationBean = Imeinumber
				.getVehicleDeviceOrganizationBean();
		List<UserVehicleDataBean> vehicleData = new ArrayList<UserVehicleDataBean>();
		List<String> vehicleList = new ArrayList<String>();
		for (int i = 0; i <= vehicleDeviceOrganizationBean.size() - 1; i++) {
			if (vehicleDeviceOrganizationBean.get(i).getVehicleData() != null) {
				vehicleList.add(vehicleDeviceOrganizationBean.get(i).getVehicleData().getVehicleNumber());
				vehicleData.add(vehicleDeviceOrganizationBean.get(i).getVehicleData());
			}
		}
		Collections.sort(vehicleList);

		int indexnumber = vehicleList.lastIndexOf(vehiclenumber);
		return indexnumber;

	}

	public static int getMonthNumber(String monthName) throws ParseException, java.text.ParseException {
		Date date = new SimpleDateFormat("MMMM").parse(monthName);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
//		System.out.println(calendar.get(Calendar.MONTH) + 1);
		return calendar.get(Calendar.MONTH) + 1;
	}

	// Pass date param as "13 July 1998"
	public static String getMonthNameInThreeChars(String date) {
		return date.substring(5, 8);
	}

	public void setAndroidDatePicker(Object date) throws IOException, ParseException, java.text.ParseException {
		int thisYear = Integer
				.valueOf(driver.findElement(By.id("android:id/date_picker_header_year")).getAttribute("name"));
		String today = driver.findElementById("android:id/date_picker_header_date").getAttribute("name");
		int thisMonth = getMonthNumber(getMonthNameInThreeChars(today));

		// Split the given date into date, month and year
		String[] splitdate = ((String) date).split(" ");

		int givenDay = Integer.valueOf(splitdate[0]);
		int givenMonth = getMonthNumber(splitdate[1]);
		int givenYear = Integer.valueOf(splitdate[2]);

		int forwardTaps = 0;
		int backwardTaps = 0;
		int yearFactor = 0;

		if (givenYear == thisYear) {
			if (givenMonth >= thisMonth) {
				forwardTaps = givenMonth - thisMonth;
			} else {
				backwardTaps = thisMonth - givenMonth;
			}
		} else if (givenYear > thisYear) {
			yearFactor = (givenYear - thisYear) * 12;
			if (givenMonth >= thisMonth) {
				forwardTaps = yearFactor + (givenMonth - thisMonth);
			} else {
				forwardTaps = yearFactor - (thisMonth - givenMonth);
			}
		} else {
			yearFactor = (thisYear - givenYear) * 12;
			if (givenMonth >= thisMonth) {
				backwardTaps = yearFactor - (givenMonth - thisMonth);
			} else {
				backwardTaps = yearFactor + (thisMonth - givenMonth);
			}
		}

		for (int i = 1; i <= forwardTaps; i++) {
			driver.findElement(By.id("android:id/next")).click();
		}

		for (int i = 1; i <= backwardTaps; i++) {
			driver.findElement(By.id("android:id/prev")).click();
		}

		String xpath = "//android.view.View[@text='day']";
		driver.findElement(By.xpath(xpath.replace("day", String.valueOf(givenDay)))).click();
		// Tap on OK button of the date picker
		driver.findElement(By.id("android:id/button1")).click();

	}

	public void setAndroidTripDatePicker(Object date) throws IOException, ParseException, java.text.ParseException {
		int thisYear = Integer
				.valueOf(driver.findElement(By.id("android:id/date_picker_header_year")).getAttribute("name"));
		String today = driver.findElementById("android:id/date_picker_header_date").getAttribute("name");
		int thisMonth = getMonthNumber(getMonthNameInThreeChars(today));

		// Split the given date into date, month and year
		String[] splitdate = ((String) date).split(" ");

		int givenDay = Integer.valueOf(splitdate[0]);
		int givenMonth = getMonthNumber(splitdate[1]);
		int givenYear = Integer.valueOf(splitdate[2]);

		int forwardTaps = 0;
		int backwardTaps = 0;
		int yearFactor = 0;

		if (givenYear == thisYear) {
			if (givenMonth >= thisMonth) {
				forwardTaps = givenMonth - thisMonth;
			} else {
				backwardTaps = thisMonth - givenMonth;
			}
		} else if (givenYear > thisYear) {
			yearFactor = (givenYear - thisYear) * 12;
			if (givenMonth >= thisMonth) {
				forwardTaps = yearFactor + (givenMonth - thisMonth);
			} else {
				forwardTaps = yearFactor - (thisMonth - givenMonth);
			}
		} else {
			yearFactor = (thisYear - givenYear) * 12;
			if (givenMonth >= thisMonth) {
				backwardTaps = yearFactor - (givenMonth - thisMonth);
			} else {
				backwardTaps = yearFactor + (thisMonth - givenMonth);
			}
		}

		for (int i = 1; i <= forwardTaps; i++) {
			driver.findElement(By.id("android:id/next")).click();
		}

		for (int i = 1; i <= backwardTaps; i++) {
			driver.findElement(By.id("android:id/prev")).click();
		}

		String xpath = "//android.view.View[@text='day']";
		driver.findElement(By.xpath(xpath.replace("day", String.valueOf(givenDay)))).click();

	}
}
