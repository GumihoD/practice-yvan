package com.yvan.practice.test;

import jxl.read.biff.BiffException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by yvan on 2017/6/28.
 */
public class ReadXml {

//    public static void main(String[] args) throws IOException, BiffException {
//        new ReadXml().readFile();
//    }

    private void readFile() throws IOException {
        File file = new File("/Users/yvan/Documents/HRY/5.xlsx");
        InputStream is = new FileInputStream(file);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
        // 获取每一个工作薄
        for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
            XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
            if (xssfSheet == null) {
                continue;
            }
            // 获取当前工作薄的每一行
            for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                if (xssfRow != null) {
                    XSSFCell one = xssfRow.getCell(0);
                    System.out.println(getValue(one));
                    //读取第一列数据
                    XSSFCell two = xssfRow.getCell(1);
                    //读取第二列数据
                    XSSFCell three = xssfRow.getCell(2);
                    //读取第三列数据

                }
            }
        }
    }


    private String getValue(XSSFCell xssfRow) {
        if (xssfRow.getCellType() == xssfRow.CELL_TYPE_BOOLEAN) {
            return String.valueOf(xssfRow.getBooleanCellValue());
        } else if (xssfRow.getCellType() == xssfRow.CELL_TYPE_NUMERIC) {
            return String.valueOf(xssfRow.getNumericCellValue());
        } else {
            return String.valueOf(xssfRow.getStringCellValue());
        }
    }
}
