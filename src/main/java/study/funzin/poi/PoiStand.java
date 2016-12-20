package study.funzin.poi;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.ibatis.reflection.ExceptionUtil;
import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.extractor.XSSFExcelExtractor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by JE on 2016-12-20.
 */
public class PoiStand {

    private String excelName;

    private String sheetName;

    private HSSFWorkbook wb;

    private XSSFWorkbook xb;

    public PoiStand(){

    }

    public PoiStand(String excelName){
        this.excelName = excelName;
    }

    public PoiStand(String excelName, String sheetName){
        this.excelName = excelName;
        this.sheetName = sheetName;
    }

    public void poiNewDefault(File file){
        XSSFWorkbook xb = null;
        try {
            xb = new XSSFWorkbook(new FileInputStream(file));
            XSSFExcelExtractor extractor = new XSSFExcelExtractor(xb);
            extractor.setFormulasNotResults(true);
            extractor.setIncludeSheetNames(false);
        }catch (FileNotFoundException fnfe){
            ExceptionUtils.getStackTrace(fnfe);
        }catch (IOException ioe){
            ExceptionUtils.getStackTrace(ioe);
        }finally {
            this.wb = wb;
        }
    }

    public void poiOldDefault(File file){
        HSSFWorkbook wb = null;
        try {
            wb = new HSSFWorkbook(new FileInputStream(file));
            ExcelExtractor extractor = new ExcelExtractor(wb);
            extractor.setFormulasNotResults(true);
            extractor.setIncludeSheetNames(false);
        }catch (FileNotFoundException fnfe){
            ExceptionUtils.getStackTrace(fnfe);
        }catch (IOException ioe){
            ExceptionUtils.getStackTrace(ioe);
        }finally {
            this.wb = wb;
        }
    }

    public void poiOldRead(){
        for(int i=0; i<wb.getNumberOfSheets(); i++){
            for(Row row : wb.getSheetAt(i)){
                for(Cell cell : row){
                    CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
                    System.out.println(cellRef.formatAsString());
                    poiOldDetailRead(cell);
                }
            }
        }
    }

    public void poiNewRead(){
        for(int i=0; i<xb.getNumberOfSheets(); i++){
            for(Row row : xb.getSheetAt(i)){
                for(Cell cell : row){
                    CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
                    System.out.println(cellRef.formatAsString());
                    poiNewDetailRead(cell);
                }
            }
        }
    }

    public void poiOldDetailRead(Cell cell){
        switch (cell.getCellType()){
            case Cell.CELL_TYPE_STRING:
                System.out.println(cell.getRichStringCellValue().getString());
                break;
            case Cell.CELL_TYPE_NUMERIC:
                if(DateUtil.isCellDateFormatted(cell)){
                    System.out.println(cell.getDateCellValue());
                }else{
                    System.out.println(cell.getNumericCellValue());
                }
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                System.out.println(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_FORMULA:
                System.out.println(cell.getCellFormula());
                break;
        }
    }

    public void poiNewDetailRead(Cell cell){
        switch (cell.getCellType()){
            case Cell.CELL_TYPE_STRING:
                System.out.println(cell.getRichStringCellValue().getString());
                break;
            case Cell.CELL_TYPE_NUMERIC:
                if(DateUtil.isCellDateFormatted(cell)){
                    System.out.println(cell.getDateCellValue());
                }else{
                    System.out.println(cell.getNumericCellValue());
                }
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                System.out.println(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_FORMULA:
                System.out.println(cell.getCellFormula());
                break;
        }
    }

    public void poiMade(){

    }

    public File fileCreate(String fileName){
        File file = new File(fileName);
        return file;
    }

}
