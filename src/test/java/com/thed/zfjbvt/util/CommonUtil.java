package com.thed.zfjbvt.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import au.com.bytecode.opencsv.CSVReader;

import com.thed.zfjbvt.Config;
import com.thed.zfjbvt.Constants;

public class CommonUtil {
	private Logger logger = Logger.getLogger(this.getClass());
	private static boolean flag=false;
	private static WebDriverWait wait=null;
	
	public static boolean alertMsg(String msg){
		try{
			((JavascriptExecutor) Driver.driver).executeScript("setTimeout(function(){alert('"+msg+"');},0)");
			Thread.sleep(2000);
			Driver.driver.switchTo().alert().accept();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	public static String getCurrentUrl(){
		String currentUrl = null;
		try{
			currentUrl = Driver.driver.getCurrentUrl();
		}catch(Exception e){
			return currentUrl;
		}
		return currentUrl;
	}
	
	/*public static boolean isElementPresents(String xpath) {
		boolean flag= false;
		try{
		for (int second = 0;; second++) {
		     if (second >= 3)
		    	 break;
		    	 if (isElementPresent(xpath))
		    	 {
		    		 flag=true;
		    		 break;
		    	 } 
		}
		}catch(Exception e){
			return flag;
		}
		return flag;
	}*/
	
	public static void flash(WebElement element) {
        JavascriptExecutor js = ((JavascriptExecutor) Driver.driver);
        String bgcolor  = element.getCssValue("backgroundColor");
        for (int i = 0; i <  3; i++) {
            changeColor("rgb(0,200,0)", element, js);
            changeColor(bgcolor, element, js);
        }
    }
	public static void changeColor(String color, WebElement element,  JavascriptExecutor js) {
        js.executeScript("arguments[0].style.backgroundColor = '"+color+"'",  element);

        try {
            Thread.sleep(20);
        }  catch (InterruptedException e) {
        }
     }
	public static void highlightElement(WebElement element) {

	    for (int i = 0; i < 3; i++) {

	        JavascriptExecutor js = (JavascriptExecutor) Driver.driver;

	        js.executeScript("arguments[0].setAttribute('style', arguments[1]);",

	                element, "color: red; border: 5px solid red;");

	        js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");

	    }

	}
	public static String returnDateFormat(String format){
		Date date = new Date();
		SimpleDateFormat ft = new SimpleDateFormat (format);
		return ft.format(date);
	}
	public static boolean scrollPage(){
		try{
			((JavascriptExecutor)Driver.driver).executeScript("javascript:window.scrollBy(0,400)"); 
		    
		}catch(Exception e){
			return false;
		}
		return true;
	}
	public static boolean scrollPage(WebElement wb){
		try{    
		    ((JavascriptExecutor)Driver.driver).executeScript("arguments[0].scrollIntoView();", wb);
		}catch(Exception e){
			return false;
		}
		return true;
	}
	public static boolean scrollToWebElement(WebElement wb){
		try{    
		    ((JavascriptExecutor)Driver.driver).executeScript("arguments[0].scrollIntoView();", wb);
		}catch(Exception e){
			return false;
		}
		return true;
	}
	public static boolean ClickOnElementUsingJS(WebElement wb){
		try{    
		    ((JavascriptExecutor)Driver.driver).executeScript("arguments[0].click();", wb);
		}catch(Exception e){
			return false;
		}
		return true;
	}
	
	public void convertCSVToExcel(String csvFileName, String excelFileName, String sheetName) throws Throwable{
		 Workbook wb = new HSSFWorkbook();
	        CreationHelper helper = wb.getCreationHelper();
	        Sheet sheet = wb.createSheet(sheetName);

	       CSVReader reader = new CSVReader(new FileReader(csvFileName));
	        String[] line;
	        int r = 0;
	        while ((line = reader.readNext()) != null) {
	            Row row = sheet.createRow((short) r++);

	            for (int i = 0; i < line.length; i++){
	                row.createCell(i)
	                   .setCellValue(helper.createRichTextString(line[i]));
	            }
	        }

	        // Write the output to a file
	        FileOutputStream fileOut = new FileOutputStream(excelFileName);
	        wb.write(fileOut);
	        fileOut.close();
	}
	
	public static boolean fileExists(String filePathString){
		try{
			File f = new File(filePathString);
			if(f.exists()) {
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}
	public static boolean fileSize(String filePath){
		try{
			File file=new File(filePath);
			  if(file.exists()){
					double d=file.length();
					if(d != 0){
						System.out.println("File is present and file length is : "+d);
						return true;
					}else{
						//logger.info("File is present but size is 0 may be not downloaded properly.");
						return false;
					}
			  }
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public static boolean isElementPresent(String xpath) {
	    try {
	        Driver.driver.findElement(By.xpath(xpath));
	    } catch (Throwable e) {
	        return false;
	    }
	    return true;
	}
	public static boolean isElementPresent(WebElement element) {
	    try {
	        WebElement webElement=element;
	        return true;
	    } catch (Exception e) {
	        return false;
	    }
	}
	public static String dateConversion(String date) throws ParseException{
		SimpleDateFormat formatter = new SimpleDateFormat("d/MMM/yy");
		Date returnDate = formatter.parse(date);
		return formatter.format(returnDate);
	}
	public static Actions actionClass(){
		Actions act=new Actions(Driver.driver);
		return act;
	}
	public static Alert switchToAlert(){
		try{
			return Driver.driver.switchTo().alert();
		}catch(Exception e){
			return null;
		}
	}
	
	public static Properties propertiesSetup( String propertiesFile) throws Throwable{
		Properties properties=null;
		FileInputStream fis;
		try{
			fis=new FileInputStream(propertiesFile);
			properties=new Properties();
			properties.load(fis);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return properties;
	}
	
	public static boolean launchBrowser(String url){
		try{
			Driver.driver.manage().window().maximize();
			Driver.driver.get(url);
		}catch(Exception e){
			return false;
		}
		return true;
	}
	
	public static void implicitWait(int timetowait){
		Driver.driver.manage().timeouts().implicitlyWait(timetowait, TimeUnit.SECONDS);
	}
	public static void closeTheDriver(){
		Driver.driver.quit();
	}
	public static void screenshot(String destPath){
		try{
			EventFiringWebDriver edriver=new EventFiringWebDriver(Driver.driver);
			File src=edriver.getScreenshotAs(OutputType.FILE);
			File dest=new File(destPath);
			FileUtils.copyFileToDirectory(src,dest);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static String getTextFromUIByXpath(String xpath){
		String text= null;
		try{
			text=Driver.driver.findElement(By.xpath(xpath)).getText();
		}catch(Exception e){
			e.printStackTrace();
		}
		return text;
	}
	public static String getTextFromUIByLinkText(String linkText){
		return Driver.driver.findElement(By.linkText(linkText)).getText();
	}
	public static void javaWait(int time) throws InterruptedException{
		if(time==1){
			Thread.sleep(1000);
		}else if (time==2) {
			Thread.sleep(2000);
		}else if (time==3) {
			Thread.sleep(3000);
		}else if (time==4) {
			Thread.sleep(4000);
		}else if (time==5){
			Thread.sleep(5000);
		}
	}
	public static void navigateTo(WebElement wb){
		wb.click();
	}
	public static boolean navigateThroughXpath(String xpathForWebElement){
		try{
			Driver.driver.findElement(By.xpath(xpathForWebElement)).click();
			implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
		}catch(Exception e){
			return false;
		}
		return true;
	}
	
	public static boolean searchTheTextInList(String xpath, String searchText){
		try{
			List<WebElement> lst=Driver.driver.findElements(By.xpath(xpath));
			for(int i=0;i<lst.size();i++){
				if(searchText.equals(lst.get(i).getText())){
					flag=true;
					break;
				}else{
					flag=false;
				}
			}
		}catch(Exception e){
			return flag;
		}
		return flag;
	}
	public static List<WebElement> returnWebElementsFromXpath(String xpath){
		try{
			return Driver.driver.findElements(By.xpath(xpath));
		}catch(Exception e){
			return null;
		}
	}
	
	/**
	 * 
	 * @param xpath
	 * @param attributeName
	 * @return String value, given attribute's value.
	 */
	
	public static String getAttributeValue(String xpath,String attributeName){
		return Driver.driver.findElement(By.xpath(xpath)).getAttribute(attributeName);
	}
	
	/**
	 * 
	 * @param xpath
	 * @return WebElement, i.e corresponding to the given xpath. 
	 */
	public static WebElement changeToWebElement(String xpath)
	{
		try{
			return Driver.driver.findElement(By.xpath((xpath)));
		}
		catch(Throwable th)
		{
			return null;
		}
	}
	
	
	/**
	 * this Method takes web element as input and returns the String value of the 
	 * attribute specified...
	 */
	public static String getAttributeValueUsingWebElements(WebElement element,String attributeName){
		String value=null;
		try{
			value=element.getAttribute(attributeName);
		} catch(Exception e){
			e.printStackTrace();
			return value;
		}
		return value;
		}
	
	
	/**
	 * @return returns title of current page.
	 */
	public static String getTitle(){
		return Driver.driver.getTitle();
	}
	
	/**
	 * this method returns appropriate boolean value, 
	 * based on the given xpath element existences.
	 *  
	 */
	public static boolean isObjectExists(String xpath){
		try{
			Driver.driver.findElement(By.xpath((xpath)));
			 return true;
		}
		catch(Throwable th)
		{
			return false;
		}
	}
	
	/**
	 * this method returns appropriate boolean value, 
	 * based on the given xpath element displayed on the ui.
	 *  
	 */
	public static boolean isObjectDisplayed(String xpath){
		try{
			Driver.driver.findElement(By.xpath((xpath))).isDisplayed();
			 return true;
		}catch(Throwable th){
			return false;
		}
	}
	/**
	 * this method returns String values, 
	 * i.e the total String values of the WebElements under the given xpath element displayed on the ui.
	 *  
	 */
	
	public static  List<String> getValues(String xpath)
	{
		try{
			List<WebElement> lst= Driver.driver.findElements(By.xpath(xpath));
			List<String> str=new ArrayList<String>();
			int s=lst.size();
			String val;
			for(int i=0;i<=s-1;i++){
				val=lst.get(i).getText();
				str.add(val);
			}
			return str;
		}catch(Exception e){
			return null;
		}
	}
	
	/**
	 * this method returns String value, 
	 * i.e the String value of the WebElements under the given xpath element displayed on the ui.
	 *  
	 */
	public static String getValue(String xpath)
	{
		String str= Driver.driver.findElement(By.xpath(xpath)).getText();
		return str;
	}
	
	
	/**
	 * this method clicks on the webElement,
	 * by taking its Xpath.
	 * 
	 * 
	 */
	public static void clickOnElement(String xpath){
		Driver.driver.findElement(By.xpath(xpath)).click();
	}
	
	/**
	 * this method returns a boolen value,
	 * if the webElement is displayed.
	 * 
	 */
	public static boolean isElementDisplayed(WebElement element){
		try{
			element.isDisplayed();
		}catch(Exception e){
			return false;
		}
		return true;
	}
	public static boolean isElementEnabled(WebElement element){
		try{
			element.isEnabled();
		}catch(Exception e){
			return false;
		}
		return true;
	}
	
	public static  int getSizeOfElements(String xpath ){
		try{
			List<WebElement> ele=Driver.driver.findElements(By.xpath(xpath));
			int count=ele.size();
			return count;
		}catch(Exception e){
			return 0;
		}
	}
	
	
	
	public static  List<WebElement> getWebElements(String xpathKey)
	{
		try{
			return Driver.driver.findElements(By.xpath((xpathKey)));
		}
		catch(Throwable th)
		{
			System.out.println("Element "+xpathKey+" not found");
			return null;
		}
	}
	public static boolean switchToFrame(String id){
		try{
			Driver.driver.switchTo().frame(id);
		}catch(Exception e){
			return false;
		}
		return true;
	}
	public static boolean switchToDefualtContent(){
		try{
			Driver.driver.switchTo().defaultContent();
		}catch(Exception e){
			return false;
		}
		return true;
	}
	
	public static boolean selectListWithVisibleText(WebElement wb, String textToSelect){
		try{
			Select select=new Select(wb);
			select.selectByVisibleText(textToSelect);
		}catch(Exception e){
			return false;
		}
		return true;
	}
	public static void selectListWithIndex(WebElement wb, int indexToSelect){
		Select select=new Select(wb);
		select.selectByIndex(indexToSelect);
	}
	public static void selectListWithValue(WebElement wb, int valueToSelect){
		Select select=new Select(wb);
		select.selectByIndex(valueToSelect);
	}
	public static WebElement returnWebElement(String xpath){
		return Driver.driver.findElement(By.xpath(xpath));
	}
	public static boolean visibilityOfElementLocated(String xpath){
		try{
			WebDriverWait wb=new WebDriverWait(Driver.driver, Constants.EXPLICIT_WAIT_EXTREME_HIGH);
			wb.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		}catch(Exception e){
			return false;
		}
		return true;
	}
	public static boolean invisibilityOfElementLocated(String xpath){
		try{
			WebDriverWait wb=new WebDriverWait(Driver.driver, Constants.EXPLICIT_WAIT_HIGH);
			wb.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
		}catch(Exception e){
			return false;
		}
		return true;
	}
	public static boolean invisibilityOfElementLocatedWithString(String xpath, String text, int time){
		try{
			WebDriverWait wb=new WebDriverWait(Driver.driver, time);
			wb.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath(xpath), text));
		}catch(Exception e){
			return false;
		}
		return true;
	}
	public static boolean titleContains(String title, int time){
		try{
			wait = new WebDriverWait(Driver.driver, time);
			wait.until(ExpectedConditions.titleContains(title));
			
		}catch(Exception e){
			return false;
		}
		return true;
	}
	
	public static boolean frameToBeAvailableAndSwitchToIt(String frameLocator){
		try{
			WebDriverWait wb=new WebDriverWait(Driver.driver, Constants.EXPLICIT_WAIT_HIGH);
			wb.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
		}catch(Exception e){
			return false;
		}
		return true;
	}
	
	public static boolean waitForStaleElement(WebElement element,int waitTill){
		boolean stale=false;
		try{
			WebDriverWait wb = new WebDriverWait(Driver.driver, waitTill);
			stale=wb.until(ExpectedConditions.stalenessOf(element));
		}catch(Exception e){
			return stale;
		}
		return stale;
	}
	
	public static boolean invisibilityOfElementWithText(String xpath, String text){
		try{
			WebDriverWait wb=new WebDriverWait(Driver.driver, Constants.EXPLICIT_WAIT_HIGH);
			wb.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath(xpath), text));
		}catch(Exception e){
			return false;
		}
		return true;
	}
	public static void ExplicitWaitForElement(WebElement element){
		try{
			WebDriverWait wb=new WebDriverWait(Driver.driver, Constants.EXPLICIT_WAIT_HIGH);
			wb.until(ExpectedConditions.visibilityOf(element));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void presenceOfAllElementsLocatedBy(String xpath){
		try{
			WebDriverWait wb=new WebDriverWait(Driver.driver, Constants.EXPLICIT_WAIT_HIGH);
			wb.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath)));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/*public static void ExplicitWaitForElement(ExpectedConditions condition){
		try{
			WebDriverWait wb=new WebDriverWait(Driver.driver, Constants.EXPLICIT_WAIT_HIGH);
			wb.until(ExpectedConditions.refreshed(condition));
		}catch(Exception e){
			e.printStackTrace();
		}
	}*/
	
	public static boolean searchTheTextInList(List<WebElement> list, String searchText){
		try{
			flag=false;
			for(int i=0; i<list.size(); i++){
				if(list.get(i).getText().equals(searchText)){
					flag=true;
					break;
				}
			}
		}catch(Exception e){
			//flag=false;
			//e.printStackTrace();
			return flag;
		}
		return flag;
	}
	public static boolean searchAndClickFromList(List<WebElement> list, String searchText){
		try{
			flag=false;
			for(int i=0; i<list.size(); i++){
				if(list.get(i).getText().equals(searchText)){
					list.get(i).click();
					flag=true;
					break;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			return flag;
		}
		return flag;
	}
	public static boolean searchTextInList(List<WebElement> list, String searchText){
		try{
			flag=false;
			for(int i=0; i<list.size(); i++){
					//String s=list.get(i).getText();
					if(list.get(i).getText().equals(searchText)){
						flag=true;
					}else{
						flag=false;
						break;
					}
			}
		}catch(Exception e){
			return flag;
		}
		return flag;
	}
	
	public static String captureScreenshotInLog() {
		CommonUtil.captureScreenshot(Config.getScreenPath());
		String imgPath = CommonUtil.captureScreenshot(Config.getScreenPath());
		//logger.info(CustomHTMLLayout.IMAGE_PREFIX + "src=\"../" + imgPath + "\"/>");
		return CustomHTMLLayout.IMAGE_PREFIX + "src=\"../" + imgPath + "\"/>";
	}
	public static String captureScreenshot(String destPath){
		try{
			EventFiringWebDriver edriver=new EventFiringWebDriver(Driver.driver);
			File src=edriver.getScreenshotAs(OutputType.FILE);
			System.out.println("output: " + src.getAbsolutePath());
			File dest=new File(destPath);
			FileUtils.copyFile(src, new File(destPath));
			return destPath;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null ;
	}
	public static File getPropertyFilePath(String path) throws URISyntaxException {
        URL url = path.getClass().getResource(path);
	    File inputFile = new File(url.toURI());
	    return inputFile ;
	}
	
	public static Properties loadProperties(String path) {
		Properties properties = new Properties();
		FileInputStream fis = null ;
		try {
			File file = getPropertyFilePath(path); 
			fis = new FileInputStream(file);
			properties.load(fis);
			fis.close();
		} catch (Exception e) {
			return null ;
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (Exception e) {
					;
				}
			}
		}
		return properties ;
	}
	
	public static void clickOnLink(String linkName){
		Driver.driver.findElement(By.linkText(linkName)).click();
	}
	
	public static void refreshPage(){
		Driver.driver.navigate().refresh();
		implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
	}
	
	public static boolean navigateBack(){
		try{
			Driver.driver.navigate().back();
		}catch(Exception e){
			return false;
		}
		return true;
	}
	/**
	 * This method will take input as xpath and time to wait and it will check that element is present or not .
	 * It only accept xpath not other locators. 
	 * @param xpath It is the parameter to find the elements as String format.
	 * @param time It is a parameter that will take some time unit in miliseconds as integer format.
	 * @return The boolean Value i.e. True or False.
	 */
	public static boolean isElementPresent(String xpath, int time){
		boolean flag = false;
		try{
			long time1=System.currentTimeMillis();
			long expWaitTime = System.currentTimeMillis() + time;
			while (System.currentTimeMillis() < expWaitTime) {
				try{
					List<WebElement> wb=Driver.driver.findElements(By.xpath(xpath));
					//WebElement wb=Driver.driver.findElement(By.xpath(xpath));
			       /*if (wb.isDisplayed()) {
			    	   flag=true;
			    	   break;
			       }*/
					if(wb.size() != 0){
						flag=true;
				    	break;
					}
				}catch(Exception e){
					flag=false;
				}
			}
			long time2=System.currentTimeMillis();
			System.out.println("Total time: "+(time2-time1));
			System.out.println("Total time: "+((time2-time1)/1000));
			
		}catch(Exception e){
			return flag;
		}
		return flag;
	}
	
}
