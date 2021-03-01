package vts.testcases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import vts.basetest.TestBase;
import vts.utils.XLutils;
import vts.listeners.Listeners;
import vts.listeners.Service_List;

import java.io.IOException;
import java.text.ParseException;

public class Service extends TestBase {
	Listeners ls = new Listeners();
    
    Service_List sl = new Service_List();
    
    Object uname, pwd, lastservicedate,billamount, odometerreading,nextservicedate, nextservicekm, description;
	boolean res;
	
	@Test	
	public void validateService() throws IOException, InterruptedException, ParseException {
		
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

}
