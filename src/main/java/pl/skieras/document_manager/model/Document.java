package pl.skieras.document_manager.model;

import pl.skieras.document_manager.api.DocsController;

import java.util.Map;

public class Document {


    private Long id;

    private String name;
    private Map<String, Metadata> metadata;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Metadata> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, Metadata> metadata) {
        this.metadata = metadata;
    }

    public Header readHeader() {
        var x = new Metadata().new MetadataReader("x", "y");
        x.read();
        return new Header();
    }
}