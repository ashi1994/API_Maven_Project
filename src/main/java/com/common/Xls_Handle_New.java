package com.common;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Xls_Handle_New {
	public static void main(String...s) {
    XSSFWorkbook workbook = new XSSFWorkbook(); 
    
    // Create a blank sheet 
    XSSFSheet sheet = workbook.createSheet("student Details"); 

    // This data needs to be written (Object[]) 
    Map<String, Object[]> data = new TreeMap<String, Object[]>();
        data.put("11", new Object[]{"ID", "NAME", "LASTNAME"});
        data.put("22", new Object[]{1, "Mithu", "Kumar"});
        data.put("31", new Object[]{2, "Bittu", "Yadav"});
        data.put("42", new Object[]{3, "Ashiwani", "Mondal"});
        data.put("51", new Object[]{4, "Virat", "kohli"});

    // Iterate over data and write to sheet 
    Set<String> keyset = data.keySet();
        int rownum = 1;
    for (String key : keyset) { 
        // this creates a new row in the sheet 
        Row row = sheet.createRow(rownum++); 
        Object[] objArr = data.get(key); 
        int cellnum = 0; 
        for (Object obj : objArr) { 
            // this line creates a cell in the next column of that row 
            Cell cell = row.createCell(cellnum++); 
            if (obj instanceof String) 
                cell.setCellValue((String)obj); 
            else if (obj instanceof Integer) 
                cell.setCellValue((Integer)obj); 
        } 
    } 
    try { 
        // this Writes the workbook gfgcontribute 
        FileOutputStream out = new FileOutputStream(new File("Test.xlsx")); 
        workbook.write(out); 
        out.close(); 
        System.out.println("Test.xlsx written successfully on disk."); 
    } 
    catch (Exception e) { 
        e.printStackTrace();
    }
    }


}
