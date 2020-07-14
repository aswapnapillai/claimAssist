package com.ibm.claim.assist.plivo.config.model;

public class XlsFilesProperty {
    String empContactPath;
    String accountClaimsPath;

    public String getEmpContactPath() {
        return empContactPath;
    }

    public void setEmpContactPath(String empContactPath) {
        this.empContactPath = empContactPath;
    }

    public String getAccountClaimsPath() {
        return accountClaimsPath;
    }

    public void setAccountClaimsPath(String accountClaimsPath) {
        this.accountClaimsPath = accountClaimsPath;
    }

    @Override
    public String toString() {
        return "XlsFilesProperty{" +
                "empContactPath='" + empContactPath + '\'' +
                ", accountClaimsPath='" + accountClaimsPath + '\'' +
                '}';
    }
}
