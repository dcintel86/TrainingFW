package automationCore;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;


public class LogListener extends TestListenerAdapter {
	public static final Logger logger = LogManager.getLogger("Log listener");
	@Override
	public void onTestStart(ITestResult tr) {
		logger.info("Clear log");
		String workingDir = System.getProperty("user.dir");
		String srcLog = workingDir + File.separator + "logs" + File.separator + "testlog2.log";
		String emptyLog = workingDir + File.separator + "logs" + File.separator + "empty.log";
		File src = new File(srcLog);
		File emptyFile = new File(emptyLog);
		try {
			FileUtils.copyFile(emptyFile, src);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	  @Override
	  public void onTestFailure(ITestResult tr) {
		  try {
			//Logout.logout(10);
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  Common.copyLog(tr, "FAILED");
	  }
	  
	  @Override
	  public void onTestSuccess(ITestResult tr) {
		  Common.copyLog(tr, "PASSED");
	  }
}
