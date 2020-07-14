package com.ibm.claim.assist.xlsReader.Model;

public class AccountClaim {
    private String empNo;
    private String weekNumber;

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getWeekEnding() {
        return weekNumber;
    }

    public void setWeekEnding(String weekNumber) {
        this.weekNumber = weekNumber;
    }
}
