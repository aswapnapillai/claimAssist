package com.ibm.claim.assist.plivo;


import com.ibm.claim.assist.plivo.config.ClaimAssitProperty;
import com.plivo.api.Plivo;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.call.Call;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.Collections;

@SpringBootApplication
public class MakePlivoCall implements  CommandLineRunner{

    @Autowired
    private ClaimAssitProperty propertyReader;

    public static void main(String[] args) {
        SpringApplication.run(MakePlivoCall.class, args);
    }

    public void run(String... args) throws Exception {
        System.out.println("SWARA   -> "+propertyReader);
    }

    private void makeCall(){
        Plivo.init();
        try {
            Call.creator("the_from_number", Collections.singletonList("the_to_number"), "https://answer.url")
                    .answerMethod("GET")
                    .create();
        } catch (IOException | PlivoRestException e) {
            e.printStackTrace();
        }
    }
    }

}
