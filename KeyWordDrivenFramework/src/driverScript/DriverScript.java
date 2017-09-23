package driverScript;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;

import basicClass.ExcelReadTestStepData;
import pagesDemo.LaunchBrowser;
import pagesDemo.Login;
import pagesDemo.RegisterationPage;
import basicClass.Constants;

public class DriverScript extends LaunchBrowser {
	public static Login ActionKeyword1;
	public static RegisterationPage ActionKeyword2;
	public static String SActioneKeyword;
	public static String STestData;
	public static WebDriver driver;
	public  Method method1[];
	public  Method method2[];
	public DriverScript()
	{
		//Launch Browser & assign the driver
		this.driver = launch_Browser(Constants.BrowserName);
		//initialize all pagefactoryElements
		ActionKeyword1 = new Login(driver);
		ActionKeyword2 = new RegisterationPage(driver);
		//Java reflection classes
		method1 = ActionKeyword1.getClass().getMethods();
		method2 = ActionKeyword2.getClass().getMethods();
}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DriverScript driver1 = new DriverScript();
		//INItialize the workbook
		ExcelReadTestStepData.setExcelFile(Constants.Path, "TestStep_TC001");
		//Get the NUMber of steps
		int TestStepCount = ExcelReadTestStepData.TestStepCount();
		//Iterate the steps
		for (int iRow = 1;iRow <= TestStepCount;iRow++){
		    //This to get the value of column Action Keyword from the excel
			SActioneKeyword = ExcelReadTestStepData.getCellData(iRow, 3);
			STestData = ExcelReadTestStepData.getCellData(iRow, 4);
           
			//Method to run all the functions
			 driver1.execute_Actions();
			 //Send the results back IN this Test I didn't do validation.PLeas Write validation function
			 ExcelReadTestStepData.result(iRow, 5, "Passed");
    		}
	}
		 private  void execute_Actions() throws Exception {
				
				for(int i = 0;i < method1.length;i++){
					//This is now comparing the method name with the ActionKeyword value got from excel
					if(method1[i].getName().equals(SActioneKeyword)){
						//In case of match found, it will execute the matched method
						if(!STestData.isEmpty())
						{	
							method1[i].invoke(ActionKeyword1,STestData);
							break;
						}
						else{
						method1[i].invoke(ActionKeyword1);
						break;
						}
						//Once any method is executed, this break statement will take the flow outside of for loop
					}
				}			
					
				for(int k = 0;k < method2.length;k++){
					//This is now comparing the method name with the ActionKeyword value got from excel
					if(method2[k].getName().equals(SActioneKeyword)){
						//In case of match found, it will execute the matched method
						if(!STestData.isEmpty())
						{
							method2[k].invoke(ActionKeyword2,STestData);
							break;
						}
						else{
						method2[k].invoke(ActionKeyword2);
						break;
						}
						//Once any method is executed, this break statement will take the flow outside of for loop
						
						}
					
					}
				
				}

}

