package vts.testcases;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import io.appium.java_client.MobileBy;
import vts.basetest.TestBase;
import vts.listeners.Trips;
import vts.utils.Contents;
import vts.utils.Keywords;
import vts.utils.VehicleTripBean;
import vts.utils.XLutils;

@Test
public class Trip_Management extends TestBase {

	Object uname, pwd, vehiclenum, startdate, enddate;
	boolean res;
	Trips t = new Trips();
	Keywords keywords = new Keywords();
	HttpHeaders headers = new HttpHeaders();
	RestTemplate template = new RestTemplate();

	public void validateTripsData() throws IOException, InterruptedException, ParseException {

		uname = XLutils.getCellData(keywordfile, sheet, 1, 0);
		pwd = XLutils.getCellData(keywordfile, sheet, 1, 1);
		vehiclenum = XLutils.getCellData(keywordfile, sheet, 1, 5);
		startdate = XLutils.getCellData(keywordfile, sheet, 2, 5);
		enddate = XLutils.getCellData(keywordfile, sheet, 3, 5);

		t.previousTrips(uname, pwd, vehiclenum, startdate, enddate);
		t.trips(vehiclenum, startdate, enddate);
//		System.out.println(keywords.getVehicleImeinumber("AP66CC0011"));
//		System.out.println(keywords.getLastDayDates(-30));
//		System.out.println(keywords.getCurrentDayInEpoach());
//		headers.add("Authorization",
//				"eyJraWQiOiJ3ZEJYOHZpbEVSanZEQ291MStsMEUwNG0zT3BOb2FaMml6UXZobkNKZHJBPSIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiI1YTQ4ODhkOS1mZjlmLTQwNmQtYWYyOC1iYzEwZWVmOWVkOGUiLCJhdWQiOiI3aW5lZ3ZrOXNnYXI0MzY0ZXU4M3FkcjRlbSIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwiZXZlbnRfaWQiOiI0OWU5MjAxNC0xOGRiLTRhZjktYWU4My04MTc1NGVmM2M1NTciLCJ0b2tlbl91c2UiOiJpZCIsImF1dGhfdGltZSI6MTYwODAxNDM2NSwiaXNzIjoiaHR0cHM6XC9cL2NvZ25pdG8taWRwLmFwLXNvdXRoLTEuYW1hem9uYXdzLmNvbVwvYXAtc291dGgtMV9PWEZkdlc3b08iLCJjb2duaXRvOnVzZXJuYW1lIjoiNWE0ODg4ZDktZmY5Zi00MDZkLWFmMjgtYmMxMGVlZjllZDhlIiwicGhvbmVfbnVtYmVyIjoiKzkxNzAzNjQ3ODI4MiIsImV4cCI6MTYwODAxNzk2NSwiaWF0IjoxNjA4MDE0MzY1LCJlbWFpbCI6IkluZm85ODc2QGdtYWlsLmNvbSJ9.IivlQcE7HkDYD5Fy-3fGdxnjE1K01KAyxbooRlG-BsBkTllVhzeWpqHIdUyPIes-pf8kvcCBJjkOe9mlzbq-grkXs_Acje5De94mK2dW7UWymOPMSNSy3ERc4l0a02wqLXaVErw06TVKk_Cg3Bhl6DH1J-H8CsHlMKwTlyLRbw3XqwPnAS_G9HJJac6UjXWvt964_7BoyPWJ0ImeKZcSyOaKqEV6i4hkhXJUQ8vX8o4zAhzfq3kdJmHTznCT2xZFapU9DTNXLyXfVbCCAxmIwz74LW1A_SNXNw4EPCU3bHK-yG0Gpsduv0JtEzAPdlHBS1kDQnHm_tRopvCn3Cna0g");
//		headers.add("userToken", "ZWkyNTRmYWR9NWliYn1hYTUxfTFhaGZ9ZDQ2MWMyYjI0Y2Np");
//		HttpEntity<String> entity = new HttpEntity<String>(headers);
//		Contents VehicleTrips = null;
//
//		try {
//			VehicleTrips = template
//					.exchange("http://apptest.myintelligo.com:8003/vehicletrips/gettriplistbyimeinumber/"
//							+ keywords.getVehicleImeinumber(vehiclenum) + "/"
//							+ keywords.getEpoachDate2(keywords.getLastDaysDate(30)) + "/"
//							+ keywords.getCurrentDayInEpoach() + "", HttpMethod.GET, entity, Contents.class)
//					.getBody();
//		} catch (Exception e) {
//			e.getStackTrace();
//		}
//		List<VehicleTripBean> vehicle = VehicleTrips.getContent();
//		System.out.println(vehicle);
//
//		


		
//		if (res == true) {
//			test.log(Status.PASS, "Credentials : " + uname + "    " + pwd + ".");
//			test.log(Status.PASS,
//					"Successfully Verified distance, time, fuel consumed and mileage of each and every trip.");
//
//			XLutils.setCellData(keywordfile, resultsheet, 19, 3, "Pass");
//			XLutils.fillGreenColor(keywordfile, resultsheet, 19, 3);
//		} else {
//			test.log(Status.FAIL, "Verification of trips data is Failed");
//
//			XLutils.setCellData(keywordfile, resultsheet, 19, 3, "Fail");
//			XLutils.fillRedColor(keywordfile, resultsheet, 19, 3);
//		}

 	}
}


