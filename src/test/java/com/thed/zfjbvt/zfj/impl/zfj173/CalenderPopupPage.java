package com.thed.zfjbvt.zfj.impl.zfj173;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.thed.zfjbvt.util.Driver;

public class CalenderPopupPage {
	
	public static CalenderPopupPage getInstance() {
		CalenderPopupPage page = PageFactory.initElements(Driver.driver, CalenderPopupPage.class);
		return page;
	}
	
	/******************************************************
	 * 	XPATH
	 *****************************************************/
	
	@FindBy(xpath="//div[@class='calendar active']/table/thead/tr[1]/td[2]")
	private WebElement selectMonthAndYear;
	
	@FindBy(xpath="//div[@class='calendar active']/table/thead/tr/td/div[text()='›']")
	private WebElement selectForwardMonth;
	
	@FindBy(xpath="//div[@class='calendar active']/table/thead/tr/td/div[text()='‹']")
	private WebElement selectBackwardMonth;
	
	@FindBy(xpath="//div[@class='calendar active']/table/thead/tr/td/div[text()='«']")
	private WebElement selectBackwardYear;
	
	@FindBy(xpath="//div[@class='calendar active']/table/thead/tr/td/div[text()='»']")
	private WebElement selectForwardYear;
	
	@FindBy(xpath="//div[@class='calendar active']/table/thead/tr/td/div[text()='×']")
	private WebElement selectCloseOfCalender;
	
	@FindBy(xpath="//div[@class='calendar active']/table/thead/tr/td/div[text()='Today']")
	private WebElement checkTodayOfCalender;
	
	/******************************************************
	 * 	PAGE OBJECT METHODS
	 *****************************************************/
	
	public boolean selectCalender(String date){
		try{
		
		//String dateno="22/May/2015";
		String arr[]=date.split("/");
			int expDate=Integer.parseInt(arr[0]);
			//String expMonth=arr[1];
			int expMonth=returnMonth(arr[1]);
			int expYear=Integer.parseInt(arr[2]);
			
			if(expDate < 10){
				expDate=Integer.parseInt(arr[0].replace("0", ""));
			}else{
				expDate=Integer.parseInt(arr[0]);
			}
			/*System.out.println(arr[0]+" "+arr[1]+" "+arr[2]);
			System.out.println(expDate+" "+expMonth+" "+expYear);*/
			//String monthWithYear=getSelectMonthAndYear().getText();
			
			String monthWithYear=Driver.driver.findElement(By.xpath("//div[@class='calendar active']/table/thead/tr[1]/td[2]")).getText();
			//System.out.println(monthWithYear);
			//String monthWithYear=selectMonthAndYear.getText();
			//String[] str=monthWithYear.split(", ");
			int actMonth=returnMonth(monthWithYear);
			int actYear=returnYear(monthWithYear);
			//int actYear=Integer.parseInt(str[1]);
			//System.out.println(str[0]+" "+str[1]);
			//System.out.println(actMonth+" "+actYear);
			
			if(expYear == actYear){
				//System.out.println("Year is same here");
				if(expMonth == actMonth){
					//System.out.println("Month is same here");
					String selectDatexpath="//div[@class='calendar active']/table/tbody/tr/td[text()='"+expDate+"']";
					Driver.driver.findElement(By.xpath(selectDatexpath)).click();
					Driver.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					//System.out.println("Date is selected successfully");
					
				}else{
					//System.out.println("Month is not same here . so changing the Month.");
					do{
						if(expMonth < actMonth){
							//System.out.println("expMonth < actMonth checking. Passed in if");
							Driver.driver.findElement(By.xpath("//div[@class='calendar active']/table/thead/tr/td/div[text()='‹']")).click();
							//getSelectBackwardYear().click();
							//System.out.println("clicked");
						}else{
							//System.out.println("expMonth < actMonth checking. Passed in else");
							Driver.driver.findElement(By.xpath("//div[@class='calendar active']/table/thead/tr/td/div[text()='›']")).click();

							//getSelectForwardYear().click();
							//System.out.println("clicked");
						}
						Thread.sleep(1000);
						monthWithYear=Driver.driver.findElement(By.xpath("//div[@class='calendar active']/table/thead/tr[1]/td[2]")).getText();
						//monthWithYear=getSelectMonthAndYear().getText();
						actMonth=returnMonth(monthWithYear);
						/*System.out.println(str[0]+" "+str[1]);
						System.out.println(actMonth+" "+actYear);*/
						//System.out.println(monthWithYear);
						//System.out.println(actMonth);
					}while(!(expMonth == actMonth));
					//System.out.println("Month is same here");
					
					String selectDatexpath="//div[@class='calendar active']/table/tbody/tr/td[text()='"+expDate+"']";
					Driver.driver.findElement(By.xpath(selectDatexpath)).click();
					Driver.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						//System.out.println("Date is selected successfully");
					
				}
				
				
			}else{
				//System.out.println("Year is not same here . so changing the year.");
				//String str1;
				do{
					if(expYear < actYear){
						//System.out.println("expYear < actYear checking. Passed in if");
						Driver.driver.findElement(By.xpath("//div[@class='calendar active']/table/thead/tr/td/div[text()='«']")).click();
						//getSelectBackwardYear().click();
						//System.out.println("clicked");
					}else{
						//System.out.println("expYear < actYear checking. Passed in else");
						Driver.driver.findElement(By.xpath("//div[@class='calendar active']/table/thead/tr/td/div[text()='»']")).click();

						//getSelectForwardYear().click();
						//System.out.println("clicked");
					}
					Thread.sleep(1000);
					monthWithYear=Driver.driver.findElement(By.xpath("//div[@class='calendar active']/table/thead/tr[1]/td[2]")).getText();
					//monthWithYear=getSelectMonthAndYear().getText();
					actYear=returnYear(monthWithYear);
					/*System.out.println(str[0]+" "+str[1]);
					System.out.println(actMonth+" "+actYear);*/
					//System.out.println(monthWithYear);
					//System.out.println(actYear);
				}while(!(expYear == actYear));
				
				//System.out.println("Year is same here");
				
				
					if(expMonth == actMonth){
						//System.out.println("Month is same here");
						String selectDatexpath="//div[@class='calendar active']/table/tbody/tr/td[text()='"+expDate+"']";
						Driver.driver.findElement(By.xpath(selectDatexpath)).click();
						Driver.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							//System.out.println("Date is selected successfully");
						
					}else{
						//System.out.println("Month is not same here . so changing the Month.");
						do{
							if(expMonth < actMonth){
								//System.out.println("expMonth < actMonth checking. Passed in if");
								Driver.driver.findElement(By.xpath("//div[@class='calendar active']/table/thead/tr/td/div[text()='‹']")).click();
								//getSelectBackwardYear().click();
								//System.out.println("clicked");
							}else{
								//System.out.println("expMonth < actMonth checking. Passed in else");
								Driver.driver.findElement(By.xpath("//div[@class='calendar active']/table/thead/tr/td/div[text()='›']")).click();

								//getSelectForwardYear().click();
								//System.out.println("clicked");
							}
							Thread.sleep(1000);
							monthWithYear=Driver.driver.findElement(By.xpath("//div[@class='calendar active']/table/thead/tr[1]/td[2]")).getText();
							//monthWithYear=getSelectMonthAndYear().getText();
							actMonth=returnMonth(monthWithYear);
							/*System.out.println(str[0]+" "+str[1]);
							System.out.println(actMonth+" "+actYear);*/
							//System.out.println(monthWithYear);
							//System.out.println(actMonth);
						}while(!(expMonth == actMonth));
						//System.out.println("Month is same here");
						
						String selectDatexpath="//div[@class='calendar active']/table/tbody/tr/td[text()='"+expDate+"']";
						Driver.driver.findElement(By.xpath(selectDatexpath)).click();
						Driver.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							//System.out.println("Date is selected successfully");
					
					}
					
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
		
	}

	/******************************************************
	 * 	UTIL METHODS
	 *****************************************************/
	
	
	public int returnYear(String str){
				String[] str1=str.split(", ");
				return Integer.parseInt(str1[1]);
		
	}
	public int returnMonth(String str){
		String[] str1=str.split(", ");
		return returnMonthAsInt(str1[0]);
		
		//return Integer.parseInt(str1[1]);
	}
	
	
	public int returnMonthAsInt(String month){
		int returnMonth=0;
		if(month.equals("January")){
			returnMonth=1;
		}else if (month.equals("February")) {
			returnMonth=2;
		}else if (month.equals("March")) {
			returnMonth=3;
		}else if (month.equals("April")) {
			returnMonth=4;
		}else if (month.equals("May")) {
			returnMonth=5;
		}else if (month.equals("June")) {
			returnMonth=6;
		}else if (month.equals("July")) {
			returnMonth=7;
		}else if (month.equals("August")) {
			returnMonth=8;
		}else if (month.equals("September")) {
			returnMonth=9;
		}else if (month.equals("October")) {
			returnMonth=10;
		}else if (month.equals("November")) {
			returnMonth=11;
		}else if (month.equals("December")) {
			returnMonth=12;
		}
		return returnMonth;
	}
	
	
	/******************************************************
	 * 	GETTER AND SETTER
	 *****************************************************/
	
	public WebElement getSelectMonthAndYear() {
		return selectMonthAndYear;
	}

	public WebElement getSelectForwardMonth() {
		return selectForwardMonth;
	}

	public WebElement getSelectBackwardMonth() {
		return selectBackwardMonth;
	}

	public WebElement getSelectBackwardYear() {
		return selectBackwardYear;
	}

	public WebElement getSelectForwardYear() {
		return selectForwardYear;
	}

	public WebElement getSelectCloseOfCalender() {
		return selectCloseOfCalender;
	}

	public WebElement getCheckTodayOfCalender() {
		return checkTodayOfCalender;
	}
	
}
