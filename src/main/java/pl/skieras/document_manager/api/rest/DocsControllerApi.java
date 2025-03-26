package pl.skieras.document_manager.api.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.skieras.document_manager.model.Document;
import pl.skieras.document_manager.model.Metadata;

import java.util.List;

public interface DocsControllerApi {

    @GetMapping
    List<Document> getAllDocuments();

    @GetMapping("/{id}")
    ResponseEntity<Document> getDocumentById(@PathVariable Long id);

    @PostMapping
    Document createDocument(@RequestBody Document document) ;

    @PutMapping("/{id}")
    ResponseEntity<Document> updateDocument(@PathVariable Long id, @RequestBody Document documentDetails);

    @DeleteMapping("/{id}")
    Metadata deleteDocument(@PathVariable Long id);

}
