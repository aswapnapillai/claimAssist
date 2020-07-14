package com.ibm.claim.assist.plivo.config;

import com.ibm.claim.assist.plivo.config.model.PlivoProperty;
import com.ibm.claim.assist.plivo.config.model.XlsFilesProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("claimsassist")
public class ClaimAssitProperty {
PlivoProperty plivoProperty = new PlivoProperty();
XlsFilesProperty xlsFilesProperty = new XlsFilesProperty();

    public XlsFilesProperty getXlsFilesProperty() {
        return xlsFilesProperty;
    }

    public void setXlsFilesProperty(XlsFilesProperty xlsFilesProperty) {
        this.xlsFilesProperty = xlsFilesProperty;
    }

    public PlivoProperty getPlivoProperty() {
        return plivoProperty;
    }

    public void setPlivoProperty(PlivoProperty plivoProperty) {
        this.plivoProperty = plivoProperty;
    }

    @Override
    public String toString() {
        return "ClaimAssitProperty{" +
                "plivoProperty=" + plivoProperty +
                ", xlsFilesProperty=" + xlsFilesProperty +
                '}';
    }
}
