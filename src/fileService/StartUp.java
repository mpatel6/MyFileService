/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileService;

import file.format.strategy.CsvFileFormatStrategy;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import reader.strategy.service.TextFileReader;
import writer.strategy.TextFileWriter;

/**
 *
 * @author Ankita
 */
public class StartUp {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        String filePath = "src" + File.separatorChar + "myData.csv";
        String filePath1 = "src" + File.separatorChar + "myData1.csv";

        FileService fileService = new FileService(new TextFileReader(filePath, new CsvFileFormatStrategy()));
        FileService fileService1 = new FileService(new TextFileWriter(filePath1, new CsvFileFormatStrategy()));

//        fileService.readAll();
//        File file = new File(filePath);
//        BufferedReader in = new BufferedReader(new FileReader(file));
//        StringBuilder inputString = new StringBuilder();
//
//        List<HashMap<String, String>> dataList = new ArrayList<HashMap<String, String>>();
//
//        String line = in.readLine();
//
//        while (line != null) {
//            inputString = inputString.append(line).append("\n");
//            line = in.readLine();
//        }
//        //  System.out.println(inputString);
//
//        String[] dataLine = inputString.toString().split("\n");
//        for (String s : dataLine) {
//            HashMap<String, String> tempDataMap = new HashMap<>();
//            String[] dataWords = s.split(",");
//
//            for (int i = 0; i < dataWords.length; i++) {
//                //String str = dataWords[i].substring(1, 10);
//
//                tempDataMap.put(Integer.toString(i), dataWords[i].substring(1, dataWords[i].length() - 1));
//            }
//            dataList.add(tempDataMap);
////            System.out.println(s);
////            String[] data = s.split(s);
//
//        }
        List<LinkedHashMap<String, String>> dataList = fileService.readAll();
        for (LinkedHashMap<String, String> m : dataList) {
            Collection<String> value = m.values();
            for (Object e : value) {
                System.out.println(e);
            }
        }
        fileService1.writeAll(dataList);

        List<LinkedHashMap<String, String>> newData = new ArrayList<LinkedHashMap<String, String>>();

        LinkedHashMap<String, String> mdata = new LinkedHashMap<>();

        mdata.put("0", "Monil");
        mdata.put("1", "Patel");
        mdata.put("2", "32");
        newData.add(mdata);
        
        mdata = new LinkedHashMap<>();
        mdata.put("0", "Ankita");
        mdata.put("1", "Patel");
        mdata.put("2", "30");
        newData.add(mdata);
        
        fileService1.addNewRecord(newData);

//         for (LinkedHashMap<String, String> m : newData) {
//            Collection<String> value = m.values();
//            for (Object e : value) {
//                System.out.println("New Data" + e);
//            }
//        }
//        FileService fileService2 = new FileService(new TextFileWriter(filePath2, new CsvFileFormatStrategy()));
//        fileService2.writeAll(dataList);
//        File file = new File(filePath1);
//        
//        boolean append = false;
//        StringBuilder str = new StringBuilder();
//
//        for (LinkedHashMap<String, String> dataMap : dataList) {
//            Collection<String> value = dataMap.values();
//
//            for (Iterator<String> itr = value.iterator(); itr.hasNext();) {
//                str = str.append("\"").append(itr.next()).append("\"").append(",");
//
//            }
//            str = str.deleteCharAt(str.length() - 1);
//            str = str.append("\n");
//        }
//
//        PrintWriter out = new PrintWriter(
//                new BufferedWriter(
//                        new FileWriter(filePath1, append)));
//
//        System.out.println(str.toString());
//        out.print(str.toString());
//        out.close();
    }

}
