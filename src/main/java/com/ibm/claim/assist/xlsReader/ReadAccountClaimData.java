package com.ibm.claim.assist.xlsReader;

import com.ibm.claim.assist.plivo.BeanUtil;
import com.ibm.claim.assist.plivo.config.ClaimAssitProperty;
import com.ibm.claim.assist.xlsReader.Model.AccountClaim;
import com.ibm.claim.assist.xlsReader.Model.EmpContact;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadAccountClaimData extends ReadXls {


    List<AccountClaim> accountClaimList = new ArrayList<>();

    public ReadAccountClaimData() {
        createAccountClaimList();
    }

    @Override
    public List<EmpContact> getEmpContact() {
        return null;
    }

    @Override
    public List<AccountClaim> getAccountClaims() {
        return accountClaimList;
    }


    private void createAccountClaimList() {

        ClaimAssitProperty  propertyReader = BeanUtil.getBean(ClaimAssitProperty.class);
        DataFormatter dataFormatter = new DataFormatter();
        try {
            Sheet sheet = readXls(propertyReader.getXlsFilesProperty().getAccountClaimsPath(), 0);
            for (Row row : sheet) {
                AccountClaim accountClaim = new AccountClaim();
                if (row.getRowNum() > 0) {
                    row.forEach(cell -> {
                        int columnIndex = cell.getColumnIndex();
                        switch (columnIndex) {
                            case 5:
                                accountClaim.setEmpNo(dataFormatter.formatCellValue(cell));
                                break;
                            case 6:
                                accountClaim.setWeekEnding(dataFormatter.formatCellValue(cell));
                                break;
                        }
                    });
                    accountClaimList.add(accountClaim);
                }
            }
        } catch (IOException | InvalidFormatException e) {
            e.printStackTrace();
        }

    }


}
