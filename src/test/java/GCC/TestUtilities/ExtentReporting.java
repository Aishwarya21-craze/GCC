package GCC.TestUtilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporting {
	
	public class Reporting extends TestListenerAdapter {
		
		public ExtentHtmlReporter htmlreporter;
		public ExtentReports extent;
		public ExtentTest test;
		//public WebDriver driver;
		String timestamp;
			
		//Initial settings
		public void onStart(ITestContext testContext)
		{
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			String repName = "Test-Report-" +timeStamp+".html";
			
			htmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/" + repName);
		    htmlreporter.config().setDocumentTitle("Automation-Report");
		    htmlreporter.config().setReportName("Functional test");
		    htmlreporter.config().setTheme(Theme.DARK);
		    htmlreporter.config().setTestViewChartLocation(ChartLocation.TOP);
		   htmlreporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");
		    
		    extent = new ExtentReports();
		    
		    extent.attachReporter(htmlreporter);
		    
		    extent.setSystemInfo("Hostname", "LocalHost");
		    extent.setSystemInfo("OS", "Windows10");
		    extent.setSystemInfo("TesterNamme", "Aishwarya");
		    extent.setSystemInfo("Browser", "Chrome");
		}
		
		
		//After all tests are completed
		
		public void onTestSuccess(ITestResult tr)
		{
			test = extent.createTest(tr.getName());
			test.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
			
		}
		
		public void onTestFailure(ITestResult tr)
		{
			
			test = extent.createTest(tr.getName());
			test.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		//	test.log(Status.FAIL, MarkupHelper.createLabel(tr.getThrowable(), ExtentColor.ORANGE));
		   
		   String screenshotpath = "./Screenshots/" + tr.getName() + ".png";
		   // String screenshotpath = System.getProperty("user.dir") + "/Screenshots/" + tr.getName() + timeStamp + ".png"
		    
		    
		    File f = new File (screenshotpath);
		    
		    if (f.exists())
		    {
		    	try {
					test.fail("Screenshot is attached below : " + test.addScreenCaptureFromPath(screenshotpath));
				} catch (Exception e) {
				 e.getMessage();
				}
		    }
		}
		    
		    public void onTestSkipped(ITestResult tr)
		    {
		    	
		    	test = extent.createTest(tr.getName());
		        test.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));	
		    			
		    }
		    	
		    public void onFinish(ITestContext testContext)
			{
			 extent.flush();
			}
				    
		    
		
	}



}
