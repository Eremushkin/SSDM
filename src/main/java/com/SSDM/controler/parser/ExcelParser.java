package com.SSDM.controler.parser;

import com.SSDM.controler.service.StudentGroupSpringDataService;
import com.SSDM.controler.service.StudentSpringDataService;
import com.SSDM.model.entityVO.StudentGroupVO;
import com.SSDM.model.entityVO.StudentVO;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

@Component
public class ExcelParser {

    @Autowired
    private StudentSpringDataService studentService;

    @Autowired
    private StudentGroupSpringDataService studentGroupService;

    public void parse(InputStream in){

        HSSFWorkbook wb = null;

        try {
            wb = new HSSFWorkbook(in);

        } catch (IOException e) {
            e.printStackTrace();
        }

        Sheet sheet = wb.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()){
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.iterator();
            String result = "";
            while (cellIterator.hasNext()){
                Cell cell = cellIterator.next();
                int cellType = cell.getCellType();
                switch (cellType) {
                    case Cell.CELL_TYPE_STRING:
                        result += cell.getStringCellValue() + " ";
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        result += (int)cell.getNumericCellValue() + " ";
                        break;
                    default:
                        break;
                }
            }
            addStudent(result);
        }
    }

    public void addStudent(String result){

        String[] splitResult = result.split(" ");
        StudentVO studentVO = new StudentVO();
        studentVO.setLastName(splitResult[0]);
        studentVO.setFirstName(splitResult[1]);
        StudentGroupVO studentGroupVO = studentGroupService.getByNumber(splitResult[2]);
        studentVO.setStudentGroup(studentGroupVO);
        studentService.addOrUpdate(studentVO);
    }
}
