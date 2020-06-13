package com.ibm.claim.assist.xlsReader;

import org.apache.poi.ss.usermodel.Sheet;

public abstract class ReadXls  implements IReadXls{

    /***
     * Purpose: Read a Xls file , based on the input path
     */
   public Sheet readXls(String path,String fileName,int sheetNo){
       return null;
    }

}
