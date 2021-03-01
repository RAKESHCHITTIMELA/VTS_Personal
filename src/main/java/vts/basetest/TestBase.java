package vts.basetest;

import java.io.File;

import java.net.URL;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import vts.utils.Constants;

public class TestBase extends Constants {

	public static AppiumDriver driver;
	public static String service_url;
	public static ExtentSparkReporter reporter;
	public static ExtentReports extent;
	public static MongoDatabase mongodatabase;

	public static ExtentReports report;

	public static ExtentTest test;

	public static String actualdate;


	@BeforeClass
	public void launchingApp() throws Exception {
		File appDir = new File(System.getProperty("user.dir") + "\\AppFiles\\");

		File app = new File(appDir, "TrackAI_QA.apk");

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
//		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator");
//		caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");


		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
		caps.setCapability(MobileCapabilityType.NO_RESET, false);
		caps.setCapability("autoGrantPermissions", true);
		caps.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());


		// URL url= new URL("http://127.0.0.1:4723/wd/hub");

//		 URL url= new URL("http://127.0.0.1:4723/wd/hub");

//		driver = new AppiumDriver(url, caps);

		AppiumServerStartStop ap = new AppiumServerStartStop();
		driver = new AppiumDriver(new URL(ap.appiumStart()), caps);

	//	System.out.println(ap.appiumStart());

		driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
		System.out.println("IntelliGO Application Started....");
	}

	@AfterClass
	public void teardown() {

		driver.quit();
	}

	public static class AppiumServerStartStop {

		static String Appium_Node_Path = "C:\\Program Files\\nodejs\\node.exe";
		static String Appium_JS_Path = "C:\\Program Files\\Appium\\resources\\app\\node_modules\\appium\\build\\lib\\main.js";
		static AppiumDriverLocalService service;

		public String appiumStart() throws Exception {

			service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingAnyFreePort()
					.withArgument(GeneralServerFlag.RELAXED_SECURITY).withArgument(GeneralServerFlag.SESSION_OVERRIDE)
					.usingDriverExecutable(new File(Appium_Node_Path)).withAppiumJS(new File(Appium_JS_Path)));
			service.start();
			Thread.sleep(30000);
			System.out.println("---- Appium Server Started-----");
			service_url = service.getUrl().toString();
			return service_url;
		}

		public static void appiumStop() throws Exception {
			service.stop();

		}
	}

	public static void mongoDB() {

//		String client_url = "mongodb://" + "USERNAME" + ":" + "PASSWORD" + "@" + "localhost" + ":" +27017;
		String client_url = "mongodb://" + "13.233.160.62" + ":" + 27017;

		MongoClientURI mongoclientURI = new MongoClientURI(client_url);
		MongoClient mongoclient = new MongoClient(mongoclientURI);

		MongoDatabase mongodatabase = mongoclient.getDatabase("mainDB");
		MongoIterable<String> mongoiterable = mongodatabase.listCollectionNames();
		// MongoCursor<String> iterator = mongoiterable.iterator();

//		MongoCollection<Document>	collection = mongodatabase.getCollection("otpVerificationBean");
//		      MongoCursor<Document> cursor = collection.find().iterator();
//		      while(cursor.hasNext()) {
//		   
//		    	  Document doc = cursor.next();
//		    	ArrayList<Object> users = new ArrayList <Object > (doc.values());
//		    
//		    	if(users.get(0).toString().equals(mobilenumber))
//		    	 System.out.printf("%s",  users.get(2));	 
//		    	
//		      }
	}

	public static ExtentReports setupExtentReport() {

		PropertyConfigurator.configure("log4j.properties");
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date date = new Date();
		actualdate = format.format(date);
		ExtentSparkReporter sparkreport = new ExtentSparkReporter(System.getProperty("user.dir")
				+ "\\src\\main\\java\\vts\\reports\\extentreport " + actualdate + ".html");
		extent = new ExtentReports();
		extent.attachReporter(sparkreport);
		extent.setSystemInfo("Project Name", "VTS");
		extent.setSystemInfo("User", "QA Team");
		extent.setSystemInfo("Platform", "Android");
		sparkreport.config().setDocumentTitle("VTS Automation Report");
		sparkreport.config().setReportName("Track AI");
		sparkreport.config().setTheme(Theme.STANDARD);
	
		return extent;
	}
	
}
