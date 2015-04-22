/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reader.strategy.service;

import file.format.strategy.FileFormatStrategy;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Ankita
 */
public class TextFileReader implements ReaderStrategy {

    private String filePath;
    private FileFormatStrategy fileFormatStrategy;

    public TextFileReader(String filePath, FileFormatStrategy fileFormatStrategy) {
        this.filePath = filePath;
        this.fileFormatStrategy = fileFormatStrategy;
    }

    @Override
    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public FileFormatStrategy getFileFormatStrategy() {
        return fileFormatStrategy;
    }

    public void setFileFormatStrategy(FileFormatStrategy fileFormatStrategy) {
        this.fileFormatStrategy = fileFormatStrategy;
    }

    @Override
    public List<LinkedHashMap<String, String>> readAll() throws FileNotFoundException, IOException {

        File file = new File(filePath);
        BufferedReader in = new BufferedReader(new FileReader(file));
        StringBuilder inputString = new StringBuilder();

        String line = in.readLine();

        while (line != null) {
            inputString = inputString.append(line).append("\n");
            line = in.readLine();
        }
        // System.out.println(inputString);
       // return inputString.toString();
        return fileFormatStrategy.decodeAll(inputString.toString());
    }

}
