package com.ibm.claim.assist.plivo;

import com.ibm.claim.assist.plivo.config.ClaimAssitProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class MakePlivoCallController {
    @Autowired
    private ClaimAssitProperty propertyReader;
    @PostMapping ("/claimsReminder")
    public void triggerClaimsReminder (){
        PlivoCall plivocall= new PlivoCall();
        plivocall.makeCall();
        }
}
