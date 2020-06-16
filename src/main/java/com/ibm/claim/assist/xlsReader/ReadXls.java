package com.ibm.claim.assist.xlsReader;

import com.ibm.claim.assist.xlsReader.Model.EmpContact;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import javax.xml.crypto.KeySelector;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public abstract class ReadXls  implements IReadXls {

    /***
     * Purpose: Read a Xls file , based on the input path
     */
    public Sheet readXls(String path, int sheetNo) throws IOException, InvalidFormatException {
        File latestFile = getLatestFile(path);
        Sheet sheet = null;
        if(latestFile!= null){
            Workbook workbook = WorkbookFactory.create(latestFile);
            // Get the Sheet based on Sheet number
             sheet = workbook.getSheetAt(sheetNo);
            // Closing the workbook
            workbook.close();
        }
        return sheet;
    }



    /***
     * Purpose: get the latest XLS from the directory
     */
    public static File getLatestFile(String pFilePath) {
        //File directory = new File(pFilePath);
        File latestFile = null;
        Path parentFolder = Paths.get(pFilePath);
        Optional<File> latestFileFromFolder =
                Arrays
                        .stream(parentFolder.toFile().listFiles())
                        .max((f1, f2) -> Long.compare(f1.lastModified(),
                                        f2.lastModified()));

        if ( latestFileFromFolder.isPresent()) {
            latestFile = latestFileFromFolder.get();
            System.out.println("most recent is " + latestFile.getPath());
        } else {
            System.out.println("folder is empty!");
        }
        return latestFile;
    }


}



