package vts.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import freemarker.core.ParseException;
import vts.basetest.TestBase;
import vts.listeners.Notification_Functionality;
import vts.utils.Keywords;
import vts.utils.XLutils;
@Test
public class Notifications_Activity extends TestBase{

	
	
	

		Object uname, pwd, vehiclenum, startdate, enddate;
		boolean res;
		Notification_Functionality notification = new Notification_Functionality();
		Keywords keywords = new Keywords();

		public void validReportData() throws IOException, InterruptedException, ParseException, java.text.ParseException {

			
			  uname = XLutils.getCellData(keywordfile, sheet, 1, 0); 
			  pwd =XLutils.getCellData(keywordfile, sheet, 1, 1); 
			  vehiclenum =XLutils.getCellData(keywordfile, sheet, 7, 5); 
			  startdate =XLutils.getCellData(keywordfile, sheet, 13, 5); 
			  enddate = XLutils.getCellData(keywordfile, sheet, 14, 5);
			  
			  notification.customeNotifications(uname, pwd, vehiclenum, startdate, enddate);
			  //notification.verifyNotification(uname, pwd, vehiclenum, startdate, enddate);
		
	}

}
