package vts.testcases;

import java.io.IOException;
import java.text.ParseException;

import org.testng.annotations.Test;

import vts.basetest.TestBase;
import vts.listeners.Reports_Function;
import vts.utils.Keywords;
import vts.utils.XLutils;
@Test
public class ReportActivity extends TestBase{

	
	Object uname, pwd, vehiclenum, startdate, enddate;
	boolean res;
	Reports_Function reports = new Reports_Function();
	Keywords keywords = new Keywords();

	public void validReportData() throws IOException, InterruptedException, ParseException {

		uname = XLutils.getCellData(keywordfile, sheet, 1, 0);
		pwd = XLutils.getCellData(keywordfile, sheet, 1, 1);
		vehiclenum = XLutils.getCellData(keywordfile, sheet, 7, 5);
		startdate = XLutils.getCellData(keywordfile, sheet, 2, 5);
		enddate = XLutils.getCellData(keywordfile, sheet, 3, 5);
		
		
	//	keywords.getVehicleImeinumber(vehiclenum);
		//stride.previousStrideData(uname, pwd, vehiclenum, startdate, enddate);
		
		reports.custome_report(uname, pwd, vehiclenum, startdate, enddate);
		
}
}
