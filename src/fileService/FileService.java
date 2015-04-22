/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileService;

import file.format.strategy.FileFormatStrategy;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import reader.strategy.service.ReaderStrategy;
import writer.strategy.WriterStrategy;

/**
 *
 * @author Ankita
 */
public class FileService {

    private ReaderStrategy reader;
    private FileFormatStrategy readFileFormatStrategy;
    private String readFilePath;

    private WriterStrategy writer;
    private FileFormatStrategy writeFileFormatStrategy;
    private String writeFilePath;

    public FileService(ReaderStrategy reader) {
        this.reader = reader;
        this.readFileFormatStrategy = this.reader.getFileFormatStrategy();
        this.readFilePath = this.reader.getFilePath();
    }

    public FileService(WriterStrategy writer) {
        this.writer = writer;

    }

    public ReaderStrategy getReader() {
        return reader;
    }

    public void setReader(ReaderStrategy reader) {
        this.reader = reader;
    }

    public List<LinkedHashMap<String, String>> readAll() throws FileNotFoundException, IOException {

        return reader.readAll();
    }

    public WriterStrategy getWriter() {
        return writer;
    }

    public void setWriter(WriterStrategy writer) {
        this.writer = writer;
    }

    public String writeAll(List<LinkedHashMap<String, String>> dataList) throws FileNotFoundException, IOException {

        return writer.writeAll(dataList);
    }
    
    public void addNewRecord(List<LinkedHashMap<String, String>> dataList)throws FileNotFoundException, IOException{
         writer.addNewRecord(dataList);
    }
}
