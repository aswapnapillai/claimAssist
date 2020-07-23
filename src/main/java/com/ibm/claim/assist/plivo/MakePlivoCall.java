package com.ibm.claim.assist.plivo;


import com.ibm.claim.assist.plivo.config.ClaimAssitProperty;
import com.ibm.claim.assist.xlsReader.Model.AccountClaim;
import com.ibm.claim.assist.xlsReader.Model.EmpContact;
import com.ibm.claim.assist.xlsReader.ReadAccountClaimData;
import com.ibm.claim.assist.xlsReader.ReadEmpContact;
import com.plivo.api.Plivo;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.call.Call;
import com.plivo.api.models.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class MakePlivoCall implements  CommandLineRunner{

    @Autowired
    private ClaimAssitProperty propertyReader;

    public static void main(String[] args) {
        SpringApplication.run(MakePlivoCall.class, args);
    }

    public void run(String... args) throws Exception {
        System.out.println("SWARA   -> "+propertyReader);
        makeCall();
    }

    private void makeCall(){
        Plivo.init(propertyReader.getPlivoProperty().getAuthId(),propertyReader.getPlivoProperty().getAuthToken());

          ReadAccountClaimData accountClaimData = new ReadAccountClaimData();
            ReadEmpContact rEmpContact = new ReadEmpContact();
        accountClaimData.getAccountClaims().forEach(accountClaim ->{
                 rEmpContact.getEmpContact().stream().
                         filter(empContact-> accountClaim.getEmpNo().equals(empContact.getEmpNo())).forEach(emp ->{
                     try {
                     Call.creator(propertyReader.getPlivoProperty().getCallerNo(), Collections.singletonList(emp.getContactNo()),
                             propertyReader.getPlivoProperty().getAnswerUrl()+"?weekending="+accountClaim.getWeekEnding()
                             )
                              .answerMethod("GET")
                             .create();
                     Message.creator(propertyReader.getPlivoProperty().getCallerNo(), Collections.singletonList(emp.getContactNo()), PlivoConstants.smsMsg.getData() + "  "+
                             accountClaim.getWeekEnding()).create();
                 } catch (IOException | PlivoRestException e) {
                        e.printStackTrace();
                    }
                 });

            });

    }
    }


