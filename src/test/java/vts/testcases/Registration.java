package vts.testcases;

import vts.basetest.TestBase;
import vts.utils.XLutils;
import vts.listeners.Listeners;

import java.io.IOException;
import java.text.ParseException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

@Test
public class Registration extends TestBase {
	Listeners ls = new Listeners();
	XLutils xl = new XLutils();
	Object firstname, lastname, mobilenumber, mailid, pword, address, city, state, pincode, Drivinglicencenumber;

	// Reads data from excel sheet
	public void validateRegistration() throws IOException, InterruptedException, ParseException {

		firstname = XLutils.getCellData(keywordfile, sheet, 6, 0);
		lastname = XLutils.getCellData(keywordfile, sheet, 7, 0);

		mobilenumber = XLutils.getCellData(keywordfile, sheet, 8, 0);
		mailid = XLutils.getCellData(keywordfile, sheet, 9, 0);
		pword = XLutils.getCellData(keywordfile, sheet, 10, 0);
		address = XLutils.getCellData(keywordfile, sheet, 11, 0);
		city = XLutils.getCellData(keywordfile, sheet, 12, 0);
		state = XLutils.getCellData(keywordfile, sheet, 13, 0);
		pincode = XLutils.getCellData(keywordfile, sheet, 14, 0);
		Drivinglicencenumber = XLutils.getCellData(keywordfile, sheet, 15, 0);

		boolean res;

		res = ls.registration(firstname, lastname, mobilenumber, mailid, pword, address, city, state, pincode,
				Drivinglicencenumber);
		if (res == true) {
			test.log(Status.PASS, "Person Registered Successfully.");

//			XLutils.setCellData(keywordfile, resultsheet, 7, 3, "Pass");
//            XLutils.fillGreenColor(keywordfile, resultsheet, 7, 3);
		} else {
			test.log(Status.FAIL, "Person Registration is Failed");

//			XLutils.setCellData(keywordfile, resultsheet, 7, 3, "Fail");
//			XLutils.fillRedColor(keywordfile, resultsheet, 7, 3);
		}

	}

}
