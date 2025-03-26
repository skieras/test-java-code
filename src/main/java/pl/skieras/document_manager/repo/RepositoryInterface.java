package pl.skieras.document_manager.repo;

import pl.skieras.document_manager.model.Document;
import pl.skieras.document_manager.model.Header;

import java.util.List;
import java.util.Optional;

public interface RepositoryInterface {

    List<Document> findAll();

    Optional<Document> findById(Long id);

    Document save(Document document, Header header);

    void delete(Document document);
}
