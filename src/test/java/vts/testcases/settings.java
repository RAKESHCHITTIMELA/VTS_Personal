package vts.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import vts.basetest.TestBase;
import vts.listeners.Settings;
import vts.utils.XLutils;

@Test
public class settings extends TestBase {

	Settings st = new Settings();
	
	Object uname, pwd, speedlimit, harshbraking, harshacceleration, rashturning ;
	boolean res;
	
	public void validateVehicleConfig() throws IOException, InterruptedException {
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
	
}
