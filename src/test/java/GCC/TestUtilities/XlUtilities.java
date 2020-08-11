package GCC.TestUtilities;

	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.IOException;

	import org.apache.poi.ss.usermodel.DataFormatter;
	import org.apache.poi.xssf.usermodel.XSSFCell;
	import org.apache.poi.xssf.usermodel.XSSFRow;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	public class XlUtilities {

		public FileInputStream fi;
		public FileOutputStream fo;
		public  XSSFWorkbook wb;
		public  XSSFSheet sh;
		public  XSSFRow row;
		public  XSSFCell cell;
		
		public int getrowcount(String xlfile,String xlsheet) throws Exception
		{
			
			fi = new FileInputStream(xlfile);
			wb = new XSSFWorkbook(fi);
			sh = wb.getSheet(xlsheet);
			int rowcount = sh.getLastRowNum();
			wb.close();
			fi.close();
			return rowcount;
			
			
		}
		
		public int cellcount(String xlfile,String xlsheet, int rownum) throws Exception
		{
			
			fi = new FileInputStream(xlfile);
			wb = new XSSFWorkbook(fi);
			sh = wb.getSheet(xlsheet);
			row = sh.getRow(rownum);
			int cellcount = row.getLastCellNum();
			wb.close();
			fi.close();
			return cellcount;
			
			
		}
		
		public void setcellData (String xlfile, String xlsheet, int rownum, int cellnum, String data) throws Exception
		{
			fi = new FileInputStream(xlfile);
			wb = new XSSFWorkbook(fi);
			sh = wb.getSheet(xlsheet);
			row = sh.getRow(rownum);
			cell = row.getCell(cellnum);
			fo = new FileOutputStream(xlfile);
			wb.write(fo);
			wb.close();
			fi.close();
	        fo.close();		
		
			
		}
		
		public String getCellData (String xlfile, String xlsheet, int rownum, int cellnum) throws IOException
	{

			fi = new FileInputStream(xlfile);
			wb = new XSSFWorkbook(fi);
			sh = wb.getSheet(xlsheet);
			row = sh.getRow(rownum);
			cell = row.getCell(cellnum);
			String data;
			try
			{
			
			DataFormatter formatter = new DataFormatter();
			String cellData = formatter.formatCellValue(cell);
			return cellData;
			}
			catch(Exception e)
			{
				data ="";
				e.getMessage();
			}
			
			wb.close();
			fi.close();
			return data;
			
			
			
	}
		
		
		
		
		
		
		
	}



