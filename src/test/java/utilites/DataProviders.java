package utilites;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	//DataProvider 1
	
	@DataProvider(name="TestLogin")
	public String [][] getData() throws IOException
	{
		String path=".\\testData\\LoginData.xlsx";
		
		ExcelUtility xlutil=new ExcelUtility(path);//creating an object for ExcelUtility
		
		int totalrows=xlutil.getRowCount("Sheet1");	//Find total no of rows
		int totalcols=xlutil.getCellCount("Sheet1",1);//Find total no of columns and 1 is the row
				
		String logindata[][]=new String[totalrows][totalcols];//created for two dimension array which can store the data user and password
		
		for(int i=1;i<=totalrows;i++)  //1   //read the data from xl storing in two deminsional array
		{		
			for(int j=0;j<totalcols;j++)  //0  where  i is rows j is col
			{
				logindata[i-1][j]= xlutil.getCellData("Sheet1",i, j);  //1,0 because array index will start from 0 that is why we have written i-1
			}
		}
	             return logindata;//returning two dimension array
				
	}
	
	//DataProvider 2
	
	//DataProvider 3
	
	//DataProvider 4
}
