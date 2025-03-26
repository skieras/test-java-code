package pl.skieras.document_manager.repo;

import pl.skieras.document_manager.model.Document;
import pl.skieras.document_manager.model.Header;

import java.util.List;

public abstract class RepositoryApi implements RepositoryInterface {

    abstract List<Document> findAllByName(String name);

    public Document save(Document document, Header header) {
        return null;
    }

    public void delete(Document document) {
    }

}
