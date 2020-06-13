package com.ibm.claim.assist.xlsReader;

import com.ibm.claim.assist.xlsReader.Model.EmpContact;

import java.util.List;

public class ReadAccountClaimData extends ReadXls {
    @Override
    public List<EmpContact> getEmpContact() {
        return null;
    }

    @Override
    public List<ReadAccountClaimData> getAccountClaims() {
        return null;
    }
}
