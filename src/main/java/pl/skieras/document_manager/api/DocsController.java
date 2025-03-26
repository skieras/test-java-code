package pl.skieras.document_manager.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.skieras.document_manager.api.rest.DocsControllerApi;
import pl.skieras.document_manager.model.Document;
import pl.skieras.document_manager.model.Header;
import pl.skieras.document_manager.repo.DocumentRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/documents")
@RequiredArgsConstructor
public class DocsController implements DocsControllerApi {

    private final DocumentRepository documentRepository;

    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }

    public ResponseEntity<Document> getDocumentById(@PathVariable Long id) {
        Optional<Document> document = documentRepository.findById(id);
        return document.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public Document createDocument(@RequestBody Document document) {
        return documentRepository.save(document);
    }

    public ResponseEntity<Document> updateDocument(@PathVariable Long id, @RequestBody Document documentDetails) {
        Optional<Document> document = documentRepository.findById(id);
        if (document.isPresent()) {
            Document updatedDocument = document.get();
            updatedDocument.setName(documentDetails.getName());
            updatedDocument.setMetadata(documentDetails.getMetadata());
            return ResponseEntity.ok(documentRepository.save(updatedDocument, new Header()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Void> deleteDocument(@PathVariable Long id) {
        Optional<Document> document = documentRepository.findById(id);
        if (document.isPresent()) {
            documentRepository.delete(document.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}