package com.simplilearn.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Registerproject {
	public static void main(String args[])
	{
		System.setProperty("webdriver.chrome.driver","D:\\java phase 5\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://profile.oracle.com/myprofile/account/create-account.jspx");
		WebElement email = driver.findElement(By.cssSelector("#sView1\\:r1\\:0\\:email\\:\\:content"));
		WebElement pass = driver.findElement(By.cssSelector("#sView1\\:r1\\:0\\:password\\:\\:content"));
		WebElement repass = driver.findElement(By.cssSelector("#sView1\\:r1\\:0\\:retypePassword\\:\\:content"));
		WebElement Fname = driver.findElement(By.cssSelector("#sView1\\:r1\\:0\\:firstName\\:\\:content"));
		WebElement Lname = driver.findElement(By.cssSelector("#sView1\\:r1\\:0\\:lastName\\:\\:content"));
		WebElement JobTitle = driver.findElement(By.cssSelector("#sView1\\:r1\\:0\\:jobTitle\\:\\:content"));
		WebElement phoneno = driver.findElement(By.cssSelector("#sView1\\:r1\\:0\\:workPhone\\:\\:content"));
		WebElement CompanyName = driver.findElement(By.cssSelector("#sView1\\:r1\\:0\\:companyName\\:\\:content"));
		WebElement Address = driver.findElement(By.cssSelector("#sView1\\:r1\\:0\\:address1\\:\\:content"));
		WebElement City = driver.findElement(By.cssSelector("#sView1\\:r1\\:0\\:city\\:\\:content"));
		WebElement State = driver.findElement(By.cssSelector("#sView1\\:r1\\:0\\:state\\:\\:content"));
		WebElement Zipcode = driver.findElement(By.cssSelector("#sView1\\:r1\\:0\\:postalCode\\:\\:content"));
		WebElement CreateAcc  = driver.findElement(By.cssSelector("#sView1\\:r1\\:0\\:subsecCreateAccount > table > tbody > tr > td > table > tbody > tr:nth-child(30) > td.x51"));
		
		try {
			Thread.sleep(2000);
			email.sendKeys("abcd@gmail.com");
			pass.sendKeys("Startigh@10");
			repass.sendKeys("Startigh@10");
			Thread.sleep(1000);
			Fname.sendKeys("Abcf");
			Lname.sendKeys("G");
			JobTitle.sendKeys("Software Developer");
			phoneno.sendKeys("9666634444");
			CompanyName.sendKeys("ABC Company");
			Address.sendKeys("No.10, XYC Road");
			City.sendKeys("Chennai");
			State.sendKeys("Tamil Nadu");
			Zipcode.sendKeys("603110");
			CreateAcc.click();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

						
	}


