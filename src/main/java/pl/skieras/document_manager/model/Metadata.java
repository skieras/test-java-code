package pl.skieras.document_manager.model;

public class Metadata {

    private Long id;
    private String name;

    class MetadataReader {
        String x;
        String y;

        public MetadataReader(String x, String y) {
            this.x = x;
            this.y = y;
        }

        String read() {
            return x + y;
        }
    }
}