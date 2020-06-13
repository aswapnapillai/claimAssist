package com.ibm.claim.assist.xlsReader;

import com.ibm.claim.assist.propertyReader.config.ClaimAssitProperty;
import com.ibm.claim.assist.xlsReader.Model.EmpContact;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ReadEmpContact extends ReadXls  {
    @Autowired
    ClaimAssitProperty propertyReader;

    ReadEmpContact(){
        CreateEmpContactList();
    }

     public List<EmpContact> getEmpContact(){
       return null;
    }

    @Override
    public List<ReadAccountClaimData> getAccountClaims() {
        return null;
    }

    private void CreateEmpContactList(){
        Sheet sheet= readXls(propertyReader.getEmpContactInfoPath(),"SNGAT",0);

    }
}
