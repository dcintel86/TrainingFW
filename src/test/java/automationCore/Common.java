package automationCore;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.testng.ITestResult;

public class Common{

public static String getTestClassName(ITestResult result) {
    String testName = result.getInstanceName().trim();
    String[] reqTestClassname = testName.split("\\.");
    int i = reqTestClassname.length - 1;
    return reqTestClassname[i];
}

public static String getTestName(ITestResult result) {
    String testName = result.getName().toString().trim();
    return testName;
}
public static void copyLog(ITestResult tr, String result) {
	  String threadName = Thread.currentThread().getName();
	  String tmp;
	  String fileName = null;
	  String workingDir = System.getProperty("user.dir");
	  String logName = System.getProperty("user.dir") + File.separator + "logs" + File.separator + "logName.txt";
	  File log_name = new File(logName);
	  String logDirectory = System.getProperty("reportDir") + File.separator + "logs";
	  File logDir = new File(logDirectory);
	  //Create Log dir
	  if(!logDir.exists()) logDir.mkdirs();
	  System.out.println("BROWSER:   " + System.getProperty("browser").toUpperCase());
	  //handle log file for API
	  if (System.getProperty("browser").toUpperCase().matches("API")) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(log_name));
				fileName = br.readLine();
				fileName = fileName.replaceFirst("ResultTC", result);
				br.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
	  }
	  else {
		  fileName = result + "_" +  getTestClassName(tr) + "_" + getTestName(tr);
	  }
	  //handle log file for API
	  String destLog = null;
	  if (System.getProperty("browser").toUpperCase().matches("API")) {
		  destLog = fileName + ".log";
	  }
	  else destLog = logDirectory + File.separator + fileName + ".log";
	  Path path = Paths.get(destLog);
	  //Create file log
	  try {
		Files.createFile(path);
	} catch (IOException e1) {
		e1.printStackTrace();
	}
	  String srcLog = workingDir + File.separator + "logs" + File.separator + "testlog2.log";
	  String BackupLog_path = workingDir + File.separator + "logs" + File.separator + "testlog.log";
	  String emptyLog = workingDir + File.separator + "logs" + File.separator + "empty.log";
	  File src = new File(srcLog);
	  File emptyFile = new File(emptyLog);
	  File backUpLog = new File(BackupLog_path);
	try {
		FileWriter backupLogFile = new FileWriter(backUpLog);
		FileWriter file = new FileWriter(destLog,true);
		BufferedReader br = new BufferedReader(new FileReader(srcLog));
		while ((tmp = br.readLine())!=null){
			//check log for Thread
			if(tmp.contains(threadName)) {
				file.append(tmp + "\n");
			}
			else {
				backupLogFile.append(tmp + "\n");
			}
			tmp = "";
		}
		file.close();
		backupLogFile.close();
		br.close();
	} catch (IOException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
		
	  try {
		  FileUtils.copyFile(backUpLog, src);
		  FileUtils.copyFile(emptyFile, backUpLog);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
	}

}

public static void copyReport(){
	String workingDir = System.getProperty("user.dir");
	String browser = System.getProperty("browser").toUpperCase();
	DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
	Date date = new Date();
	String reportLog = workingDir + File.separator + "target" + File.separator + "report.log";
	String destFile = workingDir + File.separator + "target" + File.separator + "demo-reports"  + File.separator + browser + "_" + dateFormat.format(date);
	String srcFile = workingDir + File.separator + "target" + File.separator + "failsafe-reports";
	File src = new File(srcFile);
	File report = new File(reportLog);
	
	BufferedReader br;
	try {
		br = new BufferedReader(new FileReader(report));
		String tmp = br.readLine();
		System.out.println("The older report is store under: " + tmp);
		File dest = new File(tmp);
		if (tmp != null) {
			FileUtils.copyDirectory(src, dest);
		}
		br.close();
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		//e1.printStackTrace();
	}
	//Write file;
	try {
		FileWriter file = new FileWriter(report,false);
			file.write(destFile + "\n");
		file.close();
	} catch (IOException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
}

}
