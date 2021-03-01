package vts.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import vts.basetest.TestBase;
import vts.listeners.*;
import vts.utils.XLutils;

@Test
public class Home extends TestBase {

	Object uname, pwd;

	Listeners ls = new Listeners();
	boolean res;

	public void validateHome() throws IOException, InterruptedException {

		uname = XLutils.getCellData(keywordfile, sheet, 1, 0);
		pwd = XLutils.getCellData(keywordfile, sheet, 1, 1);

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

}
