package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {

	@Test(dataProvider = "logindata")
	public void loginDDT(String username, String password) throws IOException {
		logger.info("URL is opened");

		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("username provided");
		lp.setPassword(password);
		logger.info("password provided");
		lp.clickSubmit();

		if (isAlertPresent() == true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.info("login test failed");
		} else {

			Assert.assertTrue(true);
			logger.info("login test passed");
			lp.clickLogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();

		}
	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}

	}

	@DataProvider(name = "logindata")
	public String[][] getData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/com/inetbanking/testData/LoginTestdata.xlsx";

		int rows = XLUtils.getRowCount(path, "login");
		int column = XLUtils.getCellCount(path, "login", 1);

		String loginData[][] = new String[rows][column];
		for (int i = 1; i < rows; i++) {

			for (int j = 0; j < column; j++) {
				loginData[i - 1][j] = XLUtils.getCellData(path, "login", i, j);

			}
		}
		return loginData;
	}

}
