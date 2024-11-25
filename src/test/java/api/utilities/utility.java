package api.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class utility {
	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	String path;
	
	
 public utility(String path) {
		this.path= path;
	}




public  int getRowCount(String xlsheet) throws IOException
 { 
	 fi= new FileInputStream(path);
	 wb= new XSSFWorkbook(fi);
	 ws= wb.getSheet(xlsheet);
	int row= ws.getLastRowNum();
	 wb.close();
	 fi.close();
	 return row;
 }
	
 
 
 
 public int getCellCount( String xlsheet,int rownum) throws IOException
 
 {
	 fi= new FileInputStream(path);
	 wb= new XSSFWorkbook(fi);
	 ws= wb.getSheet(xlsheet);
	 row= ws.getRow(rownum);
	 int cell=row.getLastCellNum();
	 wb.close();
	 fi.close();
	 return cell;
 }
 
 
 
 public  String getcelldata(String xlsheet,int rownum,int cellnum  ) throws IOException
 {
	 fi= new FileInputStream(path);
	 wb= new XSSFWorkbook(fi);
	 ws= wb.getSheet(xlsheet);
	 row= ws.getRow(rownum);
	 cell=row.getCell(cellnum);
	 
	 String data;
	 try {
		 
		 data= cell.toString();
		
	 } catch (Exception e) {
		
		data="";
		
		
	}
	 
	 fi.close();
	 wb.close();
	 
	 
	 
	return data;
	 
	 
 }
 
 
 
 
 
 
 
 
 
		
		

		
		
		

	

}
