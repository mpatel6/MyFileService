/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package writer.strategy;

import file.format.strategy.FileFormatStrategy;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Ankita
 */
public class TextFileWriter implements WriterStrategy {

    private String filePath;
    private FileFormatStrategy fileFormatStrategy;

    public TextFileWriter(String filePath, FileFormatStrategy fileFormatStrategy) {
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
    public String writeAll(List<LinkedHashMap<String, String>> dataList) throws FileNotFoundException, IOException {

        boolean append = false;

        File data = new File(filePath);

        PrintWriter out = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(data, append)));

        out.print(fileFormatStrategy.encodeAll(dataList));
        out.close();
        return "File Written";
    }

    @Override
    public void addNewRecord(List<LinkedHashMap<String, String>> dataList) throws FileNotFoundException, IOException {
        boolean append = true;

        File data = new File(filePath);

        PrintWriter out = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(data, append)));

        out.print(fileFormatStrategy.encodeRecord(dataList));
        out.close();

    }

}
