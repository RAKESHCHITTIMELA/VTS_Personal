package vts.testcases;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import vts.basetest.TestBase;
import vts.listeners.Change_Password;
import vts.listeners.Feedback;
import vts.listeners.Geofence_Management;
import vts.listeners.Listeners;
import vts.listeners.Profile;
import vts.listeners.Service_List;
import vts.listeners.Settings;
import vts.listeners.Trips;
import vts.listeners.Vehicle_Management;
import vts.utils.Keywords;
import vts.utils.StrideContents;
import vts.utils.VehicleStridesBean;
import vts.utils.XLutils;


public class TestCases extends TestBase{

	Object uname, pwd, invaliduname, invalidpwd, 
	lastservicedate,billamount, odometerreading,nextservicedate, nextservicekm, description,
	rating, feedback, issue,
	radiusfencename, fenceradius, customfencename, 
	speedlimit, harshbraking, harshacceleration, rashturning, 
	firstname, lastname, mobilenumber, email, address,
	newpwd, 
	vehiclenumber, enginenumber, chasisnumber, state, type, brand, model, variant, color, fuel,
	manufacturedate, purchasedate, deviceserialnumber, insuranceexpirydate, insurancenumber, insurancecompany,
	insurancepremium,  vehicle, changedvehiclenumber, vehicledelete,vehiclenum,startdate,enddate;


	boolean res;
	Listeners ls = new Listeners();
	Service_List sl = new Service_List();
	Feedback fb = new Feedback();
	Geofence_Management gm = new Geofence_Management();
	Settings st = new Settings();
	Profile pf = new Profile();
	Change_Password cp = new Change_Password();
	Vehicle_Management vm = new Vehicle_Management();
	Trips t = new Trips();

	
	
	
	
//	LoginPage login = new LoginPage();
//	Home home = new Home();
//	Service service = new Service();
//	feedback feedback = new feedback();
//	Geofence geofence = new Geofence();
//	settings settings = new settings();
//	EditProfile editprofile = new EditProfile();
//	VehicleManagement vehiclemanagement = new VehicleManagement();
//	ChangePassword changepassword = new ChangePassword();
	
	
		
//		home.validateHome();
//		service.validateService();
//		feedback.validateFeedback();
//		settings.validateVehicleConfig();
//		geofence.validateGeofence();
//		editprofile.validateEditProfile();
//		changepassword.validateChangePassword();
//		vehiclemanagement.validateAddVehicle();
		
	@Test
		public void TC001_validateLogin() throws IOException, InterruptedException {

			uname = XLutils.getCellData(keywordfile, sheet, 1, 0);
			pwd = XLutils.getCellData(keywordfile, sheet, 1, 1);
			res = ls.login_Validdata(uname, pwd);
			if (res == true) {
				test.log(Status.PASS, "Login Successful with Credentials :  " + uname + " \t   " + pwd + ".");

				XLutils.setCellData(keywordfile, resultsheet, 1, 3, "Pass");
				XLutils.fillGreenColor(keywordfile, resultsheet, 1, 3);
			} else {
				test.log(Status.FAIL, "Login UnSuccessful with Credentials :  " + uname + "    " + pwd + ".");

				XLutils.setCellData(keywordfile, resultsheet, 1, 3, "Fail");
				XLutils.fillRedColor(keywordfile, resultsheet, 1, 3);
			} 

			for (int i = 2; i <= 4; i++) {
				invaliduname = XLutils.getCellData(keywordfile, sheet, i, 0);
				invalidpwd = XLutils.getCellData(keywordfile, sheet, i, 1);
				res = ls.login_Invaliddata(invaliduname, invalidpwd);
				if (res == true) {

					test.log(Status.PASS,
							"Login UnSuccessful with Credentials :  " + invaliduname + " \t      " + invalidpwd + ".");

					XLutils.setCellData(keywordfile, resultsheet, i, 3, "Pass");
					XLutils.fillGreenColor(keywordfile, resultsheet, i, 3);

				} else {
					test.log(Status.FAIL,
							"Login UnSuccessful with Credentials :  " + invaliduname + "       " + invalidpwd + ".");

					XLutils.setCellData(keywordfile, resultsheet, i, 3, "Fail");
					XLutils.fillRedColor(keywordfile, resultsheet, i, 3);
				}

			}
		}
		
	@Test
		public void TC002_validateHome() throws IOException, InterruptedException {

			uname = XLutils.getCellData(keywordfile, sheet, 1, 0);
			pwd = XLutils.getCellData(keywordfile, sheet, 1, 1);

			System.out.println("Home");
			res= ls.home(uname, pwd);
			if (res == true) {
				test.log(Status.PASS, "Login Successful with Credentials : "+uname+"  \t  " +pwd+".");

				XLutils.setCellData(keywordfile, resultsheet, 5, 3, "Pass");
				XLutils.fillGreenColor(keywordfile, resultsheet, 5, 3);
			} else {
				test.log(Status.FAIL, "Login failed with Credentials : "+uname+"    " +pwd+".");

				XLutils.setCellData(keywordfile, resultsheet, 5, 3, "Fail");
				XLutils.fillRedColor(keywordfile, resultsheet, 5, 3);
			}

		}
		
	@Test
		public void TC003_validateService() throws IOException, InterruptedException, ParseException {
			
			uname = XLutils.getCellData(keywordfile, sheet, 1, 0);
			pwd = XLutils.getCellData(keywordfile, sheet, 1, 1);
			lastservicedate=XLutils.getCellData(keywordfile, sheet, 17, 0);
			billamount = XLutils.getCellData(keywordfile, sheet, 18, 0);
			odometerreading = XLutils.getCellData(keywordfile, sheet, 19, 0);
			nextservicedate= XLutils.getCellData(keywordfile, sheet, 20, 0);
			nextservicekm = XLutils.getCellData(keywordfile, sheet, 21, 0);
			description = XLutils.getCellData(keywordfile, sheet, 22, 0);
			
			res = sl.addNewService(uname, pwd, lastservicedate,billamount, odometerreading,nextservicedate, nextservicekm, description);
			
			if (res == true) {
				test.log(Status.PASS, "Credentials : " + uname+"  \t  " + pwd + ".");
				test.log(Status.PASS, "Successfully Added New Service Details.");

				XLutils.setCellData(keywordfile, resultsheet, 6, 3, "Pass");
	            XLutils.fillGreenColor(keywordfile, resultsheet, 6, 3);
			} else {
				test.log(Status.FAIL, "Adding a New Service is Failed");

				XLutils.setCellData(keywordfile, resultsheet, 6, 3, "Fail");
				XLutils.fillRedColor(keywordfile, resultsheet, 6, 3);
			}
			
		
		
			res= sl.deleteService();
			if (res == true) {
				test.log(Status.PASS, "Successfully Deleted a Service Details.");

				XLutils.setCellData(keywordfile, resultsheet, 7, 3, "Pass");
	            XLutils.fillGreenColor(keywordfile, resultsheet, 7, 3);
			} else {
				test.log(Status.FAIL, "Deleting a Service is Failed");

				XLutils.setCellData(keywordfile, resultsheet, 7, 3, "Fail");
				XLutils.fillRedColor(keywordfile, resultsheet, 7, 3);
			}
	 
			
		}

	@Test
		public void TC004_validateFeedback() throws IOException, InterruptedException {

			uname = XLutils.getCellData(keywordfile, sheet, 1, 0);
			pwd = XLutils.getCellData(keywordfile, sheet, 1, 1);
			rating = XLutils.getCellData(keywordfile, sheet, 1, 3);
			feedback = XLutils.getCellData(keywordfile, sheet, 2, 3);
			issue = XLutils.getCellData(keywordfile, sheet, 3, 3);

			res = fb.givefeedback(uname, pwd, rating, feedback);
			if (res == true) {
				test.log(Status.PASS, "Credentials : " + uname + "    " + pwd + ".");
				test.log(Status.PASS, "Successfully Given Feedback for Intelligo Application.");

				XLutils.setCellData(keywordfile, resultsheet, 9, 3, "Pass");
				XLutils.fillGreenColor(keywordfile, resultsheet, 9, 3);
			} else {
				test.log(Status.FAIL, "Giving Feedback is Failed");

				XLutils.setCellData(keywordfile, resultsheet, 9, 3, "Fail");
				XLutils.fillRedColor(keywordfile, resultsheet, 9, 3);
			}

			res = fb.writeissue(issue);
			if (res == true) {
				test.log(Status.PASS, "Successfully Sent Issue to Intelligo Application.");

				XLutils.setCellData(keywordfile, resultsheet, 10, 3, "Pass");
				XLutils.fillGreenColor(keywordfile, resultsheet, 10, 3);
			} else {
				test.log(Status.FAIL, "Sending Issue is Failed");

				XLutils.setCellData(keywordfile, resultsheet, 10, 3, "Fail");
				XLutils.fillRedColor(keywordfile, resultsheet, 10, 3);
			}

		}
	
	@Test
	public void TC005_validateVehicleConfig() throws IOException, InterruptedException {
		uname = XLutils.getCellData(keywordfile, sheet, 1, 0);
		pwd = XLutils.getCellData(keywordfile, sheet, 1, 1);
		speedlimit = XLutils.getCellData(keywordfile, sheet, 1, 4);
		harshbraking = XLutils.getCellData(keywordfile, sheet, 2, 4);
		harshacceleration = XLutils.getCellData(keywordfile, sheet, 3, 4);
		rashturning = XLutils.getCellData(keywordfile, sheet, 4, 4);
		

		res = st.validateConfigSettings(uname, pwd, speedlimit, harshbraking, harshacceleration, rashturning);
		if (res == true) {
			test.log(Status.PASS, "Credentials : " + uname + "    " + pwd + ".");
			test.log(Status.PASS, "Successfully Updated Vehicle Config.");

			XLutils.setCellData(keywordfile, resultsheet, 15, 3, "Pass");
			XLutils.fillGreenColor(keywordfile, resultsheet, 15, 3);
		} else {
			test.log(Status.FAIL, "Updation of vehicle config is Failed");

			XLutils.setCellData(keywordfile, resultsheet, 15, 3, "Fail");
			XLutils.fillRedColor(keywordfile, resultsheet, 15, 3);
		}
		
		}

		/*
		 * @Test public void validateStrideData() throws IOException,
		 * InterruptedException { // Listeners ls = new Listeners(); Keywords keywords =
		 * new Keywords();
		 * 
		 * 
		 * HttpHeaders headers = new HttpHeaders(); RestTemplate template = new
		 * RestTemplate(); DecimalFormat FormatChanger = new DecimalFormat("#.##");
		 * 
		 * 
		 * 
		 * uname = XLutils.getCellData(keywordfile, sheet, 1, 0); pwd =
		 * XLutils.getCellData(keywordfile, sheet, 1, 1); vehiclenum =
		 * XLutils.getCellData(keywordfile, sheet, 1, 5); startDate =
		 * XLutils.getCellData(keywordfile, sheet, 2, 5); endDate =
		 * XLutils.getCellData(keywordfile, sheet, 3, 5);
		 * 
		 * // API Call
		 * 
		 * 
		 * headers.add("Authorization",
		 * "eyJraWQiOiJ3ZEJYOHZpbEVSanZEQ291MStsMEUwNG0zT3BOb2FaMml6UXZobkNKZHJBPSIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiI1YTQ4ODhkOS1mZjlmLTQwNmQtYWYyOC1iYzEwZWVmOWVkOGUiLCJhdWQiOiI3aW5lZ3ZrOXNnYXI0MzY0ZXU4M3FkcjRlbSIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwiZXZlbnRfaWQiOiI0OWU5MjAxNC0xOGRiLTRhZjktYWU4My04MTc1NGVmM2M1NTciLCJ0b2tlbl91c2UiOiJpZCIsImF1dGhfdGltZSI6MTYwODAxNDM2NSwiaXNzIjoiaHR0cHM6XC9cL2NvZ25pdG8taWRwLmFwLXNvdXRoLTEuYW1hem9uYXdzLmNvbVwvYXAtc291dGgtMV9PWEZkdlc3b08iLCJjb2duaXRvOnVzZXJuYW1lIjoiNWE0ODg4ZDktZmY5Zi00MDZkLWFmMjgtYmMxMGVlZjllZDhlIiwicGhvbmVfbnVtYmVyIjoiKzkxNzAzNjQ3ODI4MiIsImV4cCI6MTYwODAxNzk2NSwiaWF0IjoxNjA4MDE0MzY1LCJlbWFpbCI6IkluZm85ODc2QGdtYWlsLmNvbSJ9.IivlQcE7HkDYD5Fy-3fGdxnjE1K01KAyxbooRlG-BsBkTllVhzeWpqHIdUyPIes-pf8kvcCBJjkOe9mlzbq-grkXs_Acje5De94mK2dW7UWymOPMSNSy3ERc4l0a02wqLXaVErw06TVKk_Cg3Bhl6DH1J-H8CsHlMKwTlyLRbw3XqwPnAS_G9HJJac6UjXWvt964_7BoyPWJ0ImeKZcSyOaKqEV6i4hkhXJUQ8vX8o4zAhzfq3kdJmHTznCT2xZFapU9DTNXLyXfVbCCAxmIwz74LW1A_SNXNw4EPCU3bHK-yG0Gpsduv0JtEzAPdlHBS1kDQnHm_tRopvCn3Cna0g"
		 * ); headers.add("userToken",
		 * "ZWkyNTRmYWR9NWliYn1hYTUxfTFhaGZ9ZDQ2MWMyYjI0Y2Np"); HttpEntity<String>
		 * entity = new HttpEntity<String>(headers); StrideContents vehicleStrides =
		 * null;
		 * 
		 * try { vehicleStrides = template .exchange(
		 * "http://apptest.myintelligo.com:8003/stridedata/getstridelistbyimeinumber/" +
		 * keywords.getVehicleImeinumber(vehiclenum) + "/" +
		 * keywords.getEpoachDate(startDate) + "/" + keywords.getEpoachDate(endDate) +
		 * "", HttpMethod.GET, entity, StrideContents.class) .getBody();
		 * System.out.println(startDate+" to "+endDate);
		 * System.out.println("Vehicle Number"+vehiclenum+", vehicle imei number:"
		 * +keywords.getVehicleImeinumber(vehiclenum));
		 * System.out.println("Date in epoch format :"+keywords.getEpoachDate(startDate)
		 * +" to "+keywords.getEpoachDate(endDate)); } catch (Exception e) {
		 * e.getStackTrace(); }
		 * 
		 * System.out.println("Vehicle Number"+vehiclenum+", vehicle imei number:"
		 * +keywords.getVehicleImeinumber(vehiclenum)); List<VehicleStridesBean> vehicle
		 * = vehicleStrides.getContent(); if(!(vehicle.size()==0)) {
		 * 
		 * System.out.println("Vehicle Number"+vehiclenum+", vehicle imei number:"
		 * +keywords.getVehicleImeinumber(vehiclenum)); for(int i=
		 * 0;i<vehicle.size();i++) { Object strideStartDate =
		 * vehicle.get(i).getStartDate();
		 * 
		 * String startdate=keywords.getEpochDateAndTime((Long)strideStartDate);
		 * System.out.println("vehicle start date: "+vehicle.get(i).getStartDate());
		 * 
		 * 
		 * }
		 * 
		 * } }
		 */
	
	

	
 @Test
 public void TC006_validateGeofence() throws IOException, InterruptedException {
		
		uname = XLutils.getCellData(keywordfile, sheet, 1, 0);
		pwd = XLutils.getCellData(keywordfile, sheet, 1, 1);
		radiusfencename = XLutils.getCellData(keywordfile, sheet, 9, 3);
		fenceradius = XLutils.getCellData(keywordfile, sheet, 10, 3);
		customfencename = XLutils.getCellData(keywordfile, sheet, 13, 3);
		
		res = gm.createRadiusGeofence(uname, pwd, radiusfencename, fenceradius);
		if (res == true) {
		test.log(Status.PASS, "Credentials : " + uname + " \t   " + pwd + ".");
		test.log(Status.PASS, "Successfully Created Radius Geofence.");

			XLutils.setCellData(keywordfile, resultsheet, 17, 3, "Pass");
			XLutils.fillGreenColor(keywordfile, resultsheet, 17, 3);
		} else {
		test.log(Status.FAIL, "Radius Geofence Creation is Failed");
			XLutils.setCellData(keywordfile, resultsheet, 17, 3, "Fail");
			XLutils.fillRedColor(keywordfile, resultsheet, 17, 3);
		}
		
		res= gm.createCustomGeofence(customfencename);
		if (res == true) {
		test.log(Status.PASS, "Successfully Created Custom Geofence.");

			XLutils.setCellData(keywordfile, resultsheet, 18, 3, "Pass");
			XLutils.fillGreenColor(keywordfile, resultsheet, 18, 3);
		} else {
		test.log(Status.FAIL, "Custom Geofence Creation is Failed");
			XLutils.setCellData(keywordfile, resultsheet, 18, 3, "Fail");
			XLutils.fillRedColor(keywordfile, resultsheet, 18, 3);
		}
		
	}
 @Test
 public void TC007_validateEditProfile() throws IOException, InterruptedException {
		uname = XLutils.getCellData(keywordfile, sheet, 1, 0);
		pwd = XLutils.getCellData(keywordfile, sheet, 1, 1);
		firstname = XLutils.getCellData(keywordfile, sheet, 7, 4);
		lastname = XLutils.getCellData(keywordfile, sheet, 8, 4);
		mobilenumber = XLutils.getCellData(keywordfile, sheet, 9, 4);
		email = XLutils.getCellData(keywordfile, sheet, 10, 4);
		address = XLutils.getCellData(keywordfile, sheet, 11, 4);
		
		res = pf.validateEditProfile(uname, pwd, firstname, lastname, mobilenumber, email, address);
		if (res == true) {
			test.log(Status.PASS, "Credentials : " + uname + "    " + pwd + ".");
			test.log(Status.PASS, "Successfully Updated Profile.");

			XLutils.setCellData(keywordfile, resultsheet, 16, 3, "Pass");
			XLutils.fillGreenColor(keywordfile, resultsheet, 16, 3);
		} else {
			test.log(Status.FAIL, "Updation of Profile is Failed");

			XLutils.setCellData(keywordfile, resultsheet, 16, 3, "Fail");
			XLutils.fillRedColor(keywordfile, resultsheet, 16, 3);
		}
		
		}
 @Test
 public void TC008_validateTripsData() throws IOException, InterruptedException, ParseException {

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
 
 public void TC009_validateChangePassword() throws IOException, InterruptedException {
		
		uname = XLutils.getCellData(keywordfile, sheet, 1, 0);
		pwd = XLutils.getCellData(keywordfile, sheet, 1, 1);
		newpwd = XLutils.getCellData(keywordfile, sheet, 6, 3);
		
		res = cp.validateChangePassowrd(uname, pwd, newpwd);
		if (res == true) {
			test.log(Status.PASS, "Credentials : " + uname + "    " + pwd + ".");
			test.log(Status.PASS, "Successfully Changed Password.");

			XLutils.setCellData(keywordfile, resultsheet, 11, 3, "Pass");
			XLutils.fillGreenColor(keywordfile, resultsheet, 11, 3);
		} else {
			test.log(Status.FAIL, "Changing Password is Failed");

			XLutils.setCellData(keywordfile, resultsheet, 11, 3, "Fail");
			XLutils.fillRedColor(keywordfile, resultsheet, 11, 3);
		}
		
		
	}
}
	 
	

