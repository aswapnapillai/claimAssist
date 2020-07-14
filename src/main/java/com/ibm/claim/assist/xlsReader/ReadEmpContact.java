package com.ibm.claim.assist.xlsReader;

import com.ibm.claim.assist.plivo.config.ClaimAssitProperty;
import com.ibm.claim.assist.xlsReader.Model.EmpContact;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadEmpContact extends ReadXls  {
    @Autowired
    ClaimAssitProperty propertyReader;
    List<EmpContact> empContactList = new ArrayList<>();
    ReadEmpContact(){
        CreateEmpContactList();
    }

     public List<EmpContact> getEmpContact(){
       return empContactList;
    }

    @Override
    public List<ReadAccountClaimData> getAccountClaims() {
        return null;
    }

    private void CreateEmpContactList() {
        // Create a DataFormatter to format and get each cell's value as String
        DataFormatter dataFormatter = new DataFormatter();
        try {
            Sheet sheet = readXls(propertyReader.getXlsFilesProperty().getEmpContactPath(), 0);
            for (Row row : sheet) {
                EmpContact empContact = new EmpContact();
                if (row.getRowNum() > 0) {
                    row.forEach(cell -> {
                        int columnIndex = cell.getColumnIndex();
                        switch (columnIndex) {
                            case 3:
                                empContact.setEmpNo(dataFormatter.formatCellValue(cell));
                                break;
                            case 4:
                                empContact.setContactNo(dataFormatter.formatCellValue(cell));
                                break;
                        }
                    });
                    empContactList.add(empContact);
                }
            }
        } catch (IOException | InvalidFormatException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        ReadEmpContact emp = new ReadEmpContact();
        List<EmpContact> contact = emp.getEmpContact();
    }
}
