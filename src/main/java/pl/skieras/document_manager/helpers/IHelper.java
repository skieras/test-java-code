package pl.skieras.document_manager.helpers;

public interface IHelper {
    public String docToString(String documentPath);
    public void fromString(String doc, String pathToSave);
}
