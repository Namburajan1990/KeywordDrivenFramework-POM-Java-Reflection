package basicClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadTestStepData {
	public static XSSFWorkbook ExcelWBook ;
	public static XSSFSheet ExcelWSheet;
	public static int LastRowNo;
	public static int LastColumnNo;
	public static Cell cell;
	public static int Count;
	
    public static void setExcelFile(String ExcelPath,String SheetName) throws Exception {
        FileInputStream ExcelFile = new FileInputStream(ExcelPath);
         ExcelWBook = new XSSFWorkbook(ExcelFile);
        ExcelWSheet = ExcelWBook.getSheet(SheetName);
       }
	
	public static String getCellData(int RowNo,int ColumnNo)
	{
		String CellData = null;
		
		cell = ExcelWSheet.getRow(RowNo).getCell(ColumnNo);
		if(cell==null)
		{
			cell=ExcelWSheet.getRow(RowNo).createCell(ColumnNo);
		}
		CellData = cell.getStringCellValue();
		return CellData;
		
	}
	
	public static int TestStepCount()
	{
		Count = 1;
		LastRowNo = ExcelWSheet.getLastRowNum()+1;
		
		LastColumnNo = ExcelWSheet.getRow(0).getLastCellNum();
	
		for(int i=2;i<=LastRowNo-2;i++)
		{
			Row row = ExcelWSheet.getRow(i);
			Row row1 = ExcelWSheet.getRow(i+1);
				if(row.getCell(0)==null)
				{
					cell = row.createCell(0);
					
				}
				else if(row.getCell(0).getStringCellValue().equalsIgnoreCase(row1.getCell(0).getStringCellValue()))
				{
					Count = Count+1;
				}
				
				
		}
		
		return Count;
	}
	public static void result(int rowNo,int columnNo,String status) throws IOException
	{
		Row row = ExcelWSheet.getRow(rowNo);
		Cell cell = row.createCell(columnNo);
		cell.setCellValue(status);
		try {
			FileOutputStream outputstream = new FileOutputStream(Constants.Path);
			ExcelWBook.write(outputstream);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
public static void main(String args[]) throws Exception
{
	setExcelFile(Constants.Path,"TestSteps");
	System.out.println(TestStepCount());
}

}
