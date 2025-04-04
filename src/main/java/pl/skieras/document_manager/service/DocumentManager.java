package pl.skieras.document_manager.service;
import java.io.IOException;
import java.util.*;
import java.util.regex.*;

public class DocumentManager {
    private final TextProcessor processor;

    public DocumentManager() {
        this.processor = new TextProcessor();
    }

    public void execute(String inputPath, String outputPath) {
        try {
            processor.process(inputPath, outputPath);
            System.out.println("Words extracted and written to JSON.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}