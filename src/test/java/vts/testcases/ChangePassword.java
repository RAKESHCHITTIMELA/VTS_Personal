package vts.testcases;

import java.io.IOException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;


import vts.basetest.TestBase;
import vts.listeners.*;
import vts.utils.XLutils;

@Test
public class ChangePassword extends TestBase {

	Object uname, pwd, newpwd;
	Listeners ls = new Listeners();
	Change_Password cp = new Change_Password();
	boolean res;
	 
	
	public void validateChangePassword() throws IOException, InterruptedException {
	
		uname = XLutils.getCellData(keywordfile, sheet, 1, 0);
		pwd = XLutils.getCellData(keywordfile, sheet, 1, 1);
		newpwd = XLutils.getCellData(keywordfile, sheet, 6, 3);
		
		res = cp.validateChangePassowrd(uname, pwd, newpwd);
		if (res == true) {
			//test.log(Status.PASS, "Credentials : " + uname + "    " + pwd + ".");
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
