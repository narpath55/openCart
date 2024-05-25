package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		//Taking Excel file from testData
		String path = ".\\testData\\openCart_logindata.xlsx";
		
		//creating object for ExcelUtility
		ExcelUtility xlutil = new ExcelUtility(path);
		
		int totalrows = xlutil.getRowCount("Sheet1");
		int totalcols = xlutil.getColoumnCount("Sheet1", 1);
		
		//created for two dimension array
		String logindata[][] = new String[totalrows][totalcols];
		
		//read the data from excel storing in two dimensional array
		for(int i =1; i<=totalrows; i++) //i=1 because to eliminate the headers row
		{
			for(int j=0; j<totalcols; j++) //j=1 for coloumns
			{
				logindata[i-1][j] = xlutil.getCellData("Sheet1", i, j);
			}
		}
		
		return logindata;
		
		
	}

}
