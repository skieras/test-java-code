package pl.skieras.document_manager.helpers;

import pl.skieras.document_manager.model.Document;

public class DocxHelper implements IHelper {

    private String convertDocxToMarkdown(String docxContent) {
        return "#" + docxContent;
    }

    private String convertMarkdownToDocx(String markdownContent) {
        return markdownContent.strip();
    }

    public String docToString(String documentPath) {
        System.out.println("Converting document: " + documentPath);
        String content = FileSystemHelper.readFile(documentPath);
        String converted = convertDocxToMarkdown(content);
        System.out.println("Converted document: " + converted);
        return converted;
    }

    public void fromString(String doc, String pathToSave) {
        String content = convertMarkdownToDocx(doc);
        Document document = new Document();
        document.setContent(content);
        FileSystemHelper.writeFile(pathToSave, document);
    }

}
