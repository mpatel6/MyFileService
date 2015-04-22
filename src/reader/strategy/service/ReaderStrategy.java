/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reader.strategy.service;

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
public interface ReaderStrategy {
    
    public List<LinkedHashMap<String, String>> readAll()throws FileNotFoundException, IOException;
    
    public String getFilePath();
    public FileFormatStrategy getFileFormatStrategy();
    
}
