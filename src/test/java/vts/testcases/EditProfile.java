package vts.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import vts.basetest.TestBase;
import vts.listeners.Profile;
import vts.utils.XLutils;

@Test
public class EditProfile extends TestBase{

	Profile pf = new Profile();
	Object uname, pwd, firstname, lastname, mobilenumber, email, address ;
	boolean res;
	 
	public void validateEditProfile() throws IOException, InterruptedException {
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
	
}
