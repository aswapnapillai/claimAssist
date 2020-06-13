package com.ibm.claim.assist.xlsReader;

import com.ibm.claim.assist.xlsReader.Model.EmpContact;

import java.util.List;

public interface IReadXls {

    //Sngat received
    public List<EmpContact> getEmpContact();
    public List<ReadAccountClaimData> getAccountClaims();

}