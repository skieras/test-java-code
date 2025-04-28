package pl.skieras.document_manager.helpers;

import pl.skieras.document_manager.model.Document;

public class FileSystemHelper {
    public static  String readFile(String filename) {
        System.out.println("Reading file: " + filename);
        return "Read file: " + filename + ". No content";
    }

    public static void writeFile(String filename, Document document) {
        System.out.println("Writing file: " + filename);
    }
}
