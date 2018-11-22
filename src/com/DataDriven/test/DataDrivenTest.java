package com.DataDriven.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class DataDrivenTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		Excel_Reader reader = new Excel_Reader ("C:\\Users\\User\\eclipse-workspace\\Task2\\src\\com\\DataDriven\\test\\TestData.xlsx");
		System.out.println("=============================");
		String firstName = reader.getCellData("Sheet1", "First Name", 2);
		System.out.println(firstName);
		
		String lastName = reader.getCellData("Sheet1", "Last Name", 2);
		System.out.println(lastName);
		
		String userName = reader.getCellData("Sheet1", "User Name (*)", 2);
		System.out.println(userName);
		
		String password = reader.getCellData("Sheet1", "Password", 2);
		System.out.println(password);
		
		String customer = reader.getCellData("Sheet1", "Customer", 2);
		System.out.println(customer);
		
		String role = reader.getCellData("Sheet1", "Role ", 2);
		System.out.println(role);
		
		String email = reader.getCellData("Sheet1", "Email ", 2);
		System.out.println(email);
		
		String cell = reader.getCellData("Sheet1", "Cell", 2);
		System.out.println(cell);
		
		//Open Browser
        WebDriver driver = new FirefoxDriver();
		
		driver.get("http://www.way2automation.com/angularjs-protractor/webtables/");
		driver.findElement(By.xpath("/html/body/table/thead/tr[2]/td/button")).click();
		
		
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/table/tbody/tr[1]/td[2]/input")).sendKeys(firstName);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/table/tbody/tr[2]/td[2]/input")).sendKeys(lastName);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/table/tbody/tr[3]/td[2]/input")).sendKeys(userName);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/table/tbody/tr[4]/td[2]/input")).sendKeys(password);
		Select select = new Select(driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/table/tbody/tr[6]/td[2]/select")));
		select.selectByVisibleText(role);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/table/tbody/tr[7]/td[2]/input")).sendKeys(email);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/table/tbody/tr[8]/td[2]/input")).sendKeys(cell);
	
	}

}
