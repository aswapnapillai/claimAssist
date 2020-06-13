package com.ibm.claim.assist.plivo;


import com.ibm.claim.assist.propertyReader.config.ClaimAssitProperty;
import com.plivo.api.Plivo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

import javax.imageio.stream.ImageInputStreamImpl;
import java.util.logging.Logger;

@SpringBootApplication

public class MakePlivoCall {

    @Autowired
    private ClaimAssitProperty propertyReader;
    static Logger log = Logger.getLogger(MakePlivoCall.class.getName());
     MakePlivoCall(){
        Plivo.init(propertyReader.getAuthId(), propertyReader.getAuthToken());
        log.info(propertyReader.getAuthId());
    }

    public static void main(String[] args) {
        SpringApplication.run(MakePlivoCall.class, args);

    }
}
