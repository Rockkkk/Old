package com.thed.zfjbvt.util;

import java.util.Hashtable;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.thed.zfjbvt.Config;

public class Driver {
	
	public static WebDriver driver= browserFactory();
	
	public static WebDriver browserFactory(){
		String browserType=Config.getValue("BROWSER_TYPE");
		if(browserType.equals("firefox")){
			FirefoxProfile profile=new FirefoxProfile();
			profile.setPreference("browser.download.folderList",2);
			profile.setPreference("browser.download.manager.showWhenStarting",false);
			profile.setPreference("browser.download.dir",Config.getValue("EXPORT_FILE_PATH"));
			profile.setPreference("browser.helperApps.neverAsk.saveToDisk","image/jpg, text/csv,text/xml,application/xml,application/vnd.ms-excel,application/x-excel,application/x-msexcel,application/excel,application/pdf,application/octet-stream");
			System.setProperty("webdriver.gecko.driver","F:/CurrentEclipseProject/zfjbvt/trunk/src/test/resources/geckodriver.exe");
			driver=new FirefoxDriver(profile);
		}
		else if(browserType.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", Config.getFilePath("", "chromedriver.exe"));
			Map<String, String> prefs = new Hashtable<String, String>();
			prefs.put("download.prompt_for_download", "false");
			prefs.put("download.default_directory", Config.getValue("EXPORT_FILE_PATH"));
			prefs.put("download.extensions_to_open", "image/jpg, text/csv,text/xml,application/xml,application/vnd.ms-excel,application/x-excel,application/x-msexcel,application/excel,application/pdf");
			prefs.put("download.extensions_to_open", "image/jpg, text/csv,text/xml,application/xml,application/vnd.ms-excel,application/x-excel,application/x-msexcel,application/excel,application/pdf,application/octet-stream");
			
			ChromeOptions options= new ChromeOptions();
			//options.setExperimentalOptions("prefs", prefs);
			driver= new ChromeDriver(options);
			
		}
		else if(browserType.equals("ie")){
			System.setProperty("webdriver.ie.driver", Config.getFilePath("", "IEDriverServer.exe"));
			driver= new InternetExplorerDriver();
			
		}else if(browserType.equals("safari")){
			driver= new SafariDriver();
		}
		
		return driver;
	}

}
