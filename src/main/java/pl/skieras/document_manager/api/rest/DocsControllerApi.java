package pl.skieras.document_manager.api.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.skieras.document_manager.model.Document;

import java.util.List;

public interface DocsControllerApi {

    @GetMapping
    public List<Document> getAllDocuments();

    @GetMapping("/{id}")
    public ResponseEntity<Document> getDocumentById(@PathVariable Long id);

    @PostMapping
    public Document createDocument(@RequestBody Document document) ;

    @PutMapping("/{id}")
    public ResponseEntity<Document> updateDocument(@PathVariable Long id, @RequestBody Document documentDetails);

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDocument(@PathVariable Long id);

}
