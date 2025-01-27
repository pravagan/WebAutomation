package utilities;

import org.testng.annotations.DataProvider;
import java.io.IOException;

public class ExcelDataProvider {

    //Data Provider 1
    @DataProvider(name = "LoginTestData")
    public Object[][] getTestData() throws IOException {
            String filePath = getClass().getClassLoader().getResource("Test_Data.xlsx").getPath();
            String sheetName = "Sheet1";

            ExcelUtility excel = new ExcelUtility(filePath);
            int rowCount = excel.getRowCount(sheetName);
            int cellCount = excel.getCellCount(sheetName, 1);

            Object[][] data = new Object[rowCount][cellCount];

            for (int i = 1; i <= rowCount; i++) {  // Start from 1 assuming row 0 has headers
                for (int j = 0; j < cellCount; j++) {
                    data[i - 1][j] = excel.getCellData(sheetName, i, j);
                }
            }
            return data;
    }

    //Data Provider 2

    //Data Provider 3
}

