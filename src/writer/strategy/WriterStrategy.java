/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package writer.strategy;

import file.format.strategy.FileFormatStrategy;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Ankita
 */
public interface WriterStrategy {

    public String writeAll(List<LinkedHashMap<String, String>> dataList) throws FileNotFoundException, IOException;
    
     public void addNewRecord(List<LinkedHashMap<String, String>> dataList) throws FileNotFoundException, IOException;

    public String getFilePath();

    public FileFormatStrategy getFileFormatStrategy();

}
