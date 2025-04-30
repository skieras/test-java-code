package pl.skieras.document_manager.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.skieras.document_manager.api.rest.DocsControllerApi;
import pl.skieras.document_manager.helpers.DocxHelper;
import pl.skieras.document_manager.helpers.IHelper;
import pl.skieras.document_manager.helpers.PdfHelper;
import pl.skieras.document_manager.model.Document;
import pl.skieras.document_manager.model.Header;
import pl.skieras.document_manager.model.Metadata;
import pl.skieras.document_manager.repo.RepositoryInterface;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/documents")
@RequiredArgsConstructor
public class DocsController implements DocsControllerApi {

    private final RepositoryInterface documentRepository;

    @GetMapping
    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Document> getDocumentById(@PathVariable Long id) {
        return documentRepository.findById(id)
                .map(document -> {
                    String filePath = document.getMetadata().get("filePath");
                    IHelper helper;
                    if (filePath.endsWith("pdf")) {
                        helper = new PdfHelper();
                    } else {
                        helper = new DocxHelper();
                    }
                    helper.docToString(filePath);
                    return ResponseEntity.ok(document);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Document createDocument(@RequestBody Document document) {
        String filePath = document.getMetadata().get("filePath");
        if (filePath.endsWith("pdf")) { //don't judge :D
            PdfHelper helper = new PdfHelper();
            helper.fromString(document.getContent(), filePath);
        } else {
            DocxHelper helper = new DocxHelper();
            helper.fromString(document.getContent(), filePath);
        }

        return documentRepository.save(document, new Header());
    }

    @PutMapping("/{id}")
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

    @DeleteMapping("/{id}")
    public Metadata deleteDocument(@PathVariable Long id) {
        Optional<Document> document = documentRepository.findById(id);
        if (document.isPresent()) {
            documentRepository.delete(document.get());
            return new Metadata();
        } else {
            return new Metadata();
        }
    }
}