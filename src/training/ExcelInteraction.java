package training;

import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook; 



public class ExcelInteraction {

	public static void main(String[] args) {
	}
	
	public static void writeToExcel(String filePath,String sheetName,ArrayList<String> a1) throws IOException
	{
		File src=new File(filePath);
		
		FileInputStream fis=new FileInputStream(src);
		HSSFWorkbook wb = new HSSFWorkbook(fis);
    	HSSFSheet sh1 = wb.getSheet(sheetName);

		for(int i=0;i<a1.size();i++)
		{
			sh1.getRow(1).getCell(i).setCellValue(a1.get(i));
			
			// Cell cell = row.createCell(i);
			 //cell.setCellValue(a1.get(i));
		}
		fis.close();
		File src1=new File(filePath);
		FileOutputStream fos=new FileOutputStream(src1);
		wb.write(fos);
		fos.close();
	}
	
	
	
	public static ArrayList<String>  readFromExcel(String filePath,String sheetName) 
	{
		String sdata;
		ArrayList<String> aList=new ArrayList<String>();
		try {

			File src=new File(filePath);
			FileInputStream fis=new FileInputStream(src);
			HSSFWorkbook wb=new HSSFWorkbook(fis);
			HSSFSheet sh1= wb.getSheet(sheetName);
			int noOfColumn=sh1.getRow(0).getPhysicalNumberOfCells();
			for(int i=0;i<noOfColumn;i++)
			{
				 sdata=sh1.getRow(0).getCell(i).getStringCellValue();
				 aList.add(sdata);
			}
			fis.close();
			
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			sdata=null;
		}
		return aList;
	}

}
