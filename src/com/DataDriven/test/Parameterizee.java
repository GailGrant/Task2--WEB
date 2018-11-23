package com.DataDriven.test;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Parameterizee {
	
@Test
	public static void VerifyAndAddUser() throws Exception {
		// TODO Auto-generated method stub
	
	    //Reads the Test data from the Excel file
		Excel_Reader reader = new Excel_Reader ("C:\\Users\\User\\eclipse-workspace\\Task2\\src\\com\\DataDriven\\test\\TestData.xlsx");
		int rowCount = reader.getRowCount("Sheet1");
		
		//Open Browser in Firefox 
        WebDriver driver = new FirefoxDriver();
		
        //Navigates to the given link
		driver.get("http://www.way2automation.com/angularjs-protractor/webtables/");
		
		//Verifies the actual and expected page
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "Protractor practice website - WebTables";
		Assert.assertEquals(ActualTitle, ExpectedTitle);
		
		
		
		//Parameterization using for loop
		//Reads test data from different cells in the excel file
		//Verifies when a new user is added
		for(int rowNum = 2; rowNum<=rowCount; rowNum++) {
			System.out.println("=============================");
			String firstname = reader.getCellData("Sheet1", "First Name", rowNum);
			System.out.println(firstname);
			
			String lastName = reader.getCellData("Sheet1", "Last Name", rowNum);
			System.out.println(lastName);
			
			String userName = reader.getCellData("Sheet1", "User Name (*)", rowNum);
			System.out.println(userName);
			
			String password = reader.getCellData("Sheet1", "Password", rowNum);
			System.out.println(password);
			
			String customer = reader.getCellData("Sheet1", "Customer", rowNum);
			System.out.println(customer);
			
			String role = reader.getCellData("Sheet1", "Role ", rowNum);
			System.out.println(role);
			
			String email = reader.getCellData("Sheet1", "Email ", rowNum);
			System.out.println(email);
			
			String cell = reader.getCellData("Sheet1", "Cell", rowNum);
			System.out.println(cell);
			
			//Navigates and clicks the add user button
			driver.findElement(By.xpath("/html/body/table/thead/tr[2]/td/button")).click();
			
			//enter/Send data from excel file to the different text boxes in the web page	
			driver.findElement(By.cssSelector("tr.smart-table-edit-data-cell:nth-child(1) > td:nth-child(2) > input:nth-child(1)")).clear();
			driver.findElement(By.cssSelector("tr.smart-table-edit-data-cell:nth-child(1) > td:nth-child(2) > input:nth-child(1)")).sendKeys(firstname);
			
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("tr.smart-table-edit-data-cell:nth-child(2) > td:nth-child(2) > input:nth-child(1)")).clear();
			driver.findElement(By.cssSelector("tr.smart-table-edit-data-cell:nth-child(2) > td:nth-child(2) > input:nth-child(1)")).sendKeys(lastName);
			
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("tr.smart-table-edit-data-cell:nth-child(3) > td:nth-child(2) > input:nth-child(1)")).clear();
			driver.findElement(By.cssSelector("tr.smart-table-edit-data-cell:nth-child(3) > td:nth-child(2) > input:nth-child(1)")).sendKeys(userName);
			
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("tr.smart-table-edit-data-cell:nth-child(4) > td:nth-child(2) > input:nth-child(1)")).clear();
			driver.findElement(By.cssSelector("tr.smart-table-edit-data-cell:nth-child(4) > td:nth-child(2) > input:nth-child(1)")).sendKeys(password);
			
			Thread.sleep(2000);
			if (customer.contains("Company AAA"))  {WebElement radioBtn = driver.findElement(By.cssSelector("label.radio:nth-child(1)"));
	        radioBtn.click();}
			else
			{WebElement radioBtn = driver.findElement(By.cssSelector("label.radio:nth-child(2)"));
	        radioBtn.click();}
			Select select = new Select (driver.findElement(By.cssSelector("select.ng-pristine")));
			select.selectByVisibleText(role);
			
			Thread.sleep(2000);
			driver.findElement(By.cssSelector(".ng-valid-email")).clear();
			driver.findElement(By.cssSelector(".ng-valid-email")).sendKeys(email);
			
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("tr.smart-table-edit-data-cell:nth-child(8) > td:nth-child(2) > input:nth-child(1)")).clear();
			driver.findElement(By.cssSelector("tr.smart-table-edit-data-cell:nth-child(8) > td:nth-child(2) > input:nth-child(1)")).sendKeys(cell);
			
			//Navigates and clicks the submit button
			driver.findElement(By.cssSelector("button.btn:nth-child(2)")).click();
			
				//array to locate the user name on the web
				int tr[]= new int [7];
				System.out.println(userName);
				
				
				//looping the names
				for(int i=1; i<tr.length;i++ ) {
					
					tr[i]=i;
					
					String jk = driver.findElement(By.xpath("/html/body/table/tbody/tr["+tr[i]+"]/td[3]")).getText();
					
					
				if(userName.contains(jk)) {
					System.out.println("Username exist in the table");
					break;
					
				}

				}
			  
				System.out.println("User is successfully added to the table");
			
		
	}

}
}
