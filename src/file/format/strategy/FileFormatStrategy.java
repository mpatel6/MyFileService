/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file.format.strategy;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Ankita
 */
public interface FileFormatStrategy {
    
    public List<LinkedHashMap<String, String>> decodeAll(String str);
    
    public  String encodeAll(List<LinkedHashMap<String, String>> dataList);
    
    public  String encodeRecord(List<LinkedHashMap<String, String>> dataList);
    
}
