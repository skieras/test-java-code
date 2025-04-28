package pl.skieras.document_manager.helpers;

import pl.skieras.document_manager.model.Document;

public class PdfHelper implements IHelper {

    private String convertPdfToMarkdown(String docxContent) {
        return "#" + docxContent;
    }

    private String convertMarkdownToPdf(String markdownContent) {
        return markdownContent.strip();
    }

    public String docToString(String documentPath) {
        System.out.println("Converting document: " + documentPath);
        String content = FileSystemHelper.readFile(documentPath);
        String converted = convertPdfToMarkdown(content);
        System.out.println("Converted document: " + converted);
        return converted;
    }

    public void fromString(String doc, String pathToSave) {
        String content = convertMarkdownToPdf(doc);
        Document document = new Document();
        document.setContent(content);
        FileSystemHelper.writeFile(pathToSave, document);
    }
}
