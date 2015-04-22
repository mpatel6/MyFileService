/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file.format.strategy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Ankita
 */
public class CsvFileFormatStrategy implements FileFormatStrategy {

    @Override
    public List<LinkedHashMap<String, String>> decodeAll(String str) {

        List<LinkedHashMap<String, String>> dataList = new ArrayList<LinkedHashMap<String, String>>();
        String[] dataLine = str.split("\n");
        for (String s : dataLine) {
            LinkedHashMap<String, String> tempDataMap = new LinkedHashMap<>();
            String[] dataWords = s.split(",");

            for (int i = 0; i < dataWords.length; i++) {

                tempDataMap.put(Integer.toString(i), dataWords[i].substring(1, dataWords[i].length() - 1));
            }
            dataList.add(tempDataMap);

        }
        return dataList;
    }

    @Override
    public String encodeAll(List<LinkedHashMap<String, String>> dataList) {

        //boolean append = false;
        StringBuilder str = new StringBuilder();

        for (LinkedHashMap<String, String> dataMap : dataList) {
            Collection<String> value = dataMap.values();

            for (Iterator<String> itr = value.iterator(); itr.hasNext();) {
                str = str.append("\"").append(itr.next()).append("\"").append(",");

            }
            str = str.deleteCharAt(str.length() - 1);
            str = str.append("\n");
        }

        return str.toString();

    }

    @Override
    public String encodeRecord(List<LinkedHashMap<String, String>> dataList) {

        StringBuilder str = new StringBuilder();
        for (LinkedHashMap<String, String> dataMap : dataList) {
            Collection<String> value = dataMap.values();

            for (Iterator<String> itr = value.iterator(); itr.hasNext();) {
                str = str.append("\"").append(itr.next()).append("\"").append(",");

            }
            str = str.deleteCharAt(str.length() - 1);
            str = str.append("\n");
        }

        return str.toString();
    }
}
