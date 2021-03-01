package vts.testcases;

import java.io.IOException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import vts.basetest.TestBase;
import vts.listeners.*;
import vts.utils.XLutils;

@Test
public class LoginPage extends TestBase {

	Object uname, pwd, invaliduname, invalidpwd;
	boolean res;
	Listeners ls = new Listeners();



	public void validateLogin() throws IOException, InterruptedException {

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
}
