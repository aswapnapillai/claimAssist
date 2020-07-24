package com.ibm.claim.assist.plivo;

import com.ibm.claim.assist.plivo.config.ClaimAssitProperty;
import com.ibm.claim.assist.xlsReader.ReadAccountClaimData;
import com.ibm.claim.assist.xlsReader.ReadEmpContact;
import com.plivo.api.Plivo;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.call.Call;
import com.plivo.api.models.message.Message;

import java.io.IOException;
import java.util.Collections;

public class PlivoCall {

    public  void makeCall(){
        ClaimAssitProperty propertyReader = BeanUtil.getBean(ClaimAssitProperty.class);

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
                    if(propertyReader.getPlivoProperty().getSendSms()) {
                        Message.creator(propertyReader.getPlivoProperty().getCallerNo(), Collections.singletonList(emp.getContactNo()), PlivoConstants.smsMsg.getData() + "  " +
                                accountClaim.getWeekEnding()).create();
                    }
                } catch (IOException | PlivoRestException e) {
                    e.printStackTrace();
                }
            });

        });

    }
}
