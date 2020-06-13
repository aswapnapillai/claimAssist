package com.ibm.claim.assist.propertyReader.config;

import com.ibm.claim.assist.propertyReader.model.PlivoProperty;
import com.ibm.claim.assist.propertyReader.model.XlsFilesProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties // no prefix, root level.
public class ClaimAssitProperty {
    private PlivoProperty plivoProperty;
    private XlsFilesProperty xlsFilesProperty;

    public String getAuthId(){
        return plivoProperty.getAuthId();
    }
    public String getAuthToken(){
        return plivoProperty.getAuthToken();
    }

    public String getEmpContactInfoPath(){
        return  xlsFilesProperty.getEmpContactPath();
    }
    public String getAccountCalimPath(){
        return  xlsFilesProperty.getAccountClaimsPath();
    }
}
