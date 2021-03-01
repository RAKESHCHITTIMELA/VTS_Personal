package vts.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import vts.basetest.TestBase;
import vts.listeners.Feedback;
import vts.utils.XLutils;

@Test
public class feedback extends TestBase {

	
	Object uname, pwd, rating, feedback, issue;

	Feedback fb = new Feedback();

	boolean res;

	public void validateFeedback() throws IOException, InterruptedException {

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

}
