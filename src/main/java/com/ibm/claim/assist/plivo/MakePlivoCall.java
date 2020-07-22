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
        try {
            Call.creator("+919108821881", Collections.singletonList("+491736375927"), "http://139.59.85.157:8080/getCallResponse?weekending=29")
                    .answerMethod("GET")
                    .create();
        } catch (IOException | PlivoRestException e) {
            e.printStackTrace();
        }
         /*   ReadAccountClaimData accountClaimData = new ReadAccountClaimData();
            ReadEmpContact rEmpContact = new ReadEmpContact();

        accountClaimData.getAccountClaims().forEach(accountClaim ->{
                 rEmpContact.getEmpContact().stream().
                         filter(empContact-> accountClaim.getEmpNo().equals(empContact.getEmpNo())).forEach(emp ->{
                     try {
                     Call.creator("+9108821881", Collections.singletonList(emp.getContactNo()), "https://answer.url")
                             .answerMethod("GET")
                             .create();
                     Message.creator("+9108821881", Collections.singletonList(emp.getContactNo()), PlivoConstants.smsMsg.getData() + "  "+
                             accountClaim.getWeekEnding()).create();
                 } catch (IOException | PlivoRestException e) {
                        e.printStackTrace();
                    }
                 });

            });*/

    }
    }


