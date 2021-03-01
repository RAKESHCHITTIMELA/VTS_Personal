 package vts.testcases;

import java.io.IOException;
import java.text.ParseException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import vts.basetest.TestBase;
import vts.listeners.Listeners;
import vts.listeners.Vehicle_Management;
import vts.utils.XLutils;

public class VehicleManagement extends TestBase {

	Object uname, pwd, vehiclenumber, enginenumber, chasisnumber, state, type, brand, model, variant, color, fuel,
			manufacturedate, purchasedate, deviceserialnumber, insuranceexpirydate, insurancenumber, insurancecompany,
			insurancepremium, odometerreading, vehicle, changedvehiclenumber, vehicledelete;

	boolean res;
	Listeners ls = new Listeners();
	XLutils xl = new XLutils();
	Vehicle_Management vm = new Vehicle_Management();

	@Test
	public void validateAddVehicle() throws IOException, ParseException, InterruptedException {

		uname = XLutils.getCellData(keywordfile, sheet, 1, 0);
		pwd = XLutils.getCellData(keywordfile, sheet, 1, 1);
		vehiclenumber = XLutils.getCellData(keywordfile, sheet, 1, 2);
		enginenumber = XLutils.getCellData(keywordfile, sheet, 2, 2);
		chasisnumber = XLutils.getCellData(keywordfile, sheet, 3, 2);
		state = XLutils.getCellData(keywordfile, sheet, 4, 2);
		type = XLutils.getCellData(keywordfile, sheet, 5, 2);
		brand = XLutils.getCellData(keywordfile, sheet, 6, 2);
		model = XLutils.getCellData(keywordfile, sheet, 7, 2);
		variant = XLutils.getCellData(keywordfile, sheet, 8, 2);
		color = XLutils.getCellData(keywordfile, sheet, 9, 2);
		fuel = XLutils.getCellData(keywordfile, sheet, 10, 2);
		manufacturedate = XLutils.getCellData(keywordfile, sheet, 11, 2);
		purchasedate = XLutils.getCellData(keywordfile, sheet, 12, 2);
		deviceserialnumber = XLutils.getCellData(keywordfile, sheet, 13, 2);
		insuranceexpirydate = XLutils.getCellData(keywordfile, sheet, 14, 2);
		insurancenumber = XLutils.getCellData(keywordfile, sheet, 15, 2);
		insurancecompany = XLutils.getCellData(keywordfile, sheet, 16, 2);
		insurancepremium = XLutils.getCellData(keywordfile, sheet, 17, 2);
		odometerreading = XLutils.getCellData(keywordfile, sheet, 18, 2);
		vehicle = XLutils.getCellData(keywordfile, sheet, 21, 2);
		changedvehiclenumber = XLutils.getCellData(keywordfile, sheet, 22, 2);
		vehicledelete = XLutils.getCellData(keywordfile, sheet, 25, 2);

		

		res = vm.addVehicle(uname, pwd, vehiclenumber, enginenumber, chasisnumber, state, type, brand, model, variant,
				color, fuel, manufacturedate, purchasedate, deviceserialnumber, insuranceexpirydate, insurancenumber,
				insurancecompany, insurancepremium, odometerreading);

		if (res == true) {
			test.log(Status.PASS, "Credentials : " + uname + " \t   " + pwd + ".");
			test.log(Status.PASS, "Successfully Added a New Vehicle.");

			XLutils.setCellData(keywordfile, resultsheet, 8, 3, "Pass");
			XLutils.fillGreenColor(keywordfile, resultsheet, 8, 3);
		} else {
			test.log(Status.FAIL, "Adding a Vehicle is Failed");

			XLutils.setCellData(keywordfile, resultsheet, 8, 3, "Fail");
			XLutils.fillRedColor(keywordfile, resultsheet, 8, 3);
		}

		res = vm.addedVehicle(vehiclenumber);
		if (res == true) {
			test.log(Status.PASS, "Newly Added is Present in Vehicle List.");

			XLutils.setCellData(keywordfile, resultsheet, 12, 3, "Pass");
			XLutils.fillGreenColor(keywordfile, resultsheet, 12, 3);
		} else {
			test.log(Status.FAIL, "Newly Added is not present in vehicle list");

			XLutils.setCellData(keywordfile, resultsheet, 12, 3, "Fail");
			XLutils.fillRedColor(keywordfile, resultsheet, 12, 3);
		}

		res = vm.editVehicle(vehicle, changedvehiclenumber, enginenumber, chasisnumber);
		if (res == true) {
			test.log(Status.PASS, "Successfully Edited a Vehicle .");

			XLutils.setCellData(keywordfile, resultsheet, 13, 3, "Pass");
			XLutils.fillGreenColor(keywordfile, resultsheet, 13, 3);
		} else {
			test.log(Status.FAIL, "Vehicle edit failed");

			XLutils.setCellData(keywordfile, resultsheet, 13, 3, "Fail");
			XLutils.fillRedColor(keywordfile, resultsheet, 13, 3);
		}
		
//		res = vm.deleteVehicle(vehicledelete);
//		if (res == true) {
//		test.log(Status.PASS, "Successfully Deleted a Vehicle.");
//			XLutils.setCellData(keywordfile, resultsheet, 14, 3, "Pass");
//            XLutils.fillGreenColor(keywordfile, resultsheet, 14, 3);
//		} else {
//		test.log(Status.FAIL, "Deleting a Vehicle is Failed");
//			XLutils.setCellData(keywordfile, resultsheet, 14, 3, "Fail");
//			XLutils.fillRedColor(keywordfile, resultsheet, 14, 3);
//		}

	}

}
