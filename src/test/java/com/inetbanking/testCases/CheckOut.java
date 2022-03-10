package com.inetbanking.testCases;

import java.io.IOException;

import com.inetbanking.utilities.XLUtils;

public class CheckOut {

	public static String[][] getData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/com/inetbanking/testData/LoginTestdata.xlsx";
		// String path = "G:\\Selenium files\\Selenium eclipse
		// Repository\\Guru99Bank\\src\\test\\java\\com\\inetbanking\\testData\\LoginTestdata.xlsx";
		int rows = XLUtils.getRowCount(path, "login");
		int column = XLUtils.getCellCount(path, "login", 1);
		System.out.println("row=" + rows + "columns=" + column);

		String loginData[][] = new String[rows][column];
		for (int i = 1; i < rows; i++) {

			for (int j = 0; j < column; j++) {
				loginData[i - 1][j] = XLUtils.getCellData(path, "login", i, j);
				System.out.println(loginData[i - 1][j]);

			}
		}
		return loginData;
	}

	public static void main(String[] args) throws IOException {
		getData();
	}

}
