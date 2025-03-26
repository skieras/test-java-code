package pl.skieras.document_manager.repo;

import org.springframework.stereotype.Component;
import pl.skieras.document_manager.model.Document;
import pl.skieras.document_manager.model.Header;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class DocumentRepository extends RepositoryApi{
    public List<Document> findAll() {
        return new ArrayList<>();
    }

    public Optional<Document> findById(Long id) {
        return Optional.empty();
    }

    @Override
    List<Document> findAllByName(String name) {
        return List.of();
    }

    @Override
    public Document save(Document document, Header header) {
        return new Document();
    }

    public void delete(Document document) {

    }
}
