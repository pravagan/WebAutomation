package utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class ExcelUtility {
    public static FileInputStream fi;
    public static FileOutputStream fo;
    public static XSSFWorkbook wb;
    public static XSSFSheet ws;
    public static XSSFRow row;
    public static XSSFCell cell;
    public static CellStyle style;
    static String path;

    public ExcelUtility(String path){
        this.path=path;
    }

    public  static int getRowCount(String xlsheet) throws IOException {
        fi=new FileInputStream(path);
        wb=new XSSFWorkbook(fi);
        ws=wb.getSheet(xlsheet);
        int rowcount= ws.getLastRowNum();
        wb.close();
        fi.close();
        return rowcount;
    }

    public static int getCellCount( String xlsheet,int rownum) throws IOException {
        fi=new FileInputStream(path);
        wb=new XSSFWorkbook(fi);
        ws=wb.getSheet(xlsheet);
        row=ws.getRow(rownum);
        int cellcount= row.getLastCellNum();
        wb.close();
        fi.close();
        return cellcount;
    }

    public static String getCellData( String xlsheet,int rownum,int colnum) throws IOException {
        fi=new FileInputStream(path);
        wb=new XSSFWorkbook(fi);
        ws=wb.getSheet(xlsheet);
        row=ws.getRow(rownum);
        cell= row.getCell(colnum);
        String data;
        try{
            //data=cell.toString();
            DataFormatter formatter=new DataFormatter();
            data=formatter.formatCellValue(cell);//returns the formatted value of a cell as a string regardless of cell type.
        } catch (Exception e) {
            data="";
        }
        wb.close();
        fi.close();
        return data;
    }

    public static void setCellData(String xlsheet,int rownum,int colnum,String data) throws IOException {
        File xlfile = new File(path);
        if(!xlfile.exists())
        {
            wb=new XSSFWorkbook();
            fo=new FileOutputStream(path);
            wb.write(fo);
        }
        fi=new FileInputStream(path);
        wb = new XSSFWorkbook(fi);
        if(wb.getSheetIndex(xlsheet)==-1)
        {
            wb.createSheet(xlsheet);
            ws=wb.getSheet(xlsheet);
        }
        if(ws.getRow(rownum)==null)
        {
            ws.createRow(rownum);
        }

        row = ws.getRow(rownum);
        cell = row.createCell(colnum);
        cell.setCellValue(data);
        fo = new FileOutputStream(path);
        wb.write(fo);
        wb.close();
        fi.close();
        fo.close();
    }

    public void fillRedColor(String xlsheet,int rownum,int colnum) throws IOException {
        fi=new FileInputStream(path);
        wb=new XSSFWorkbook(fi);
        ws=wb.getSheet(xlsheet);
        row=ws.getRow(rownum);
        cell=row.getCell(colnum);
        style=wb.createCellStyle();
        style.setFillForegroundColor(IndexedColors.RED.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cell.setCellStyle(style);
        wb.write(fo);
        wb.close();
        fi.close();
        fo.close();

    }

    public void fillGreenColor(String xlsheet,int rownum,int colnum) throws IOException {
        fi=new FileInputStream(path);
        wb=new XSSFWorkbook(fi);
        ws=wb.getSheet(xlsheet);
        row=ws.getRow(rownum);
        cell=row.getCell(colnum);
        style=wb.createCellStyle();
        style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cell.setCellStyle(style);
        wb.write(fo);
        wb.close();
        fi.close();
        fo.close();

    }


}
