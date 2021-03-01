package vts.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import vts.basetest.TestBase;
import vts.utils.XLutils;
import vts.listeners.Geofence_Management;

@Test
public class Geofence extends TestBase {
 
	Object uname, pwd, radiusfencename, fenceradius, customfencename;
	boolean res;
	
	Geofence_Management gm = new Geofence_Management();
	
	public void validateGeofence() throws IOException, InterruptedException {
		
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
	
	
}
