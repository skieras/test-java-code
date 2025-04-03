package pl.skieras.document_manager.model;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Metadata {

    private Long id;
    private String name;
    private Map<Long, String> data;

    class MetadataReader {
        String x;
        String y;
        List<String> listData;

        public MetadataReader(String x, String y) {
            this.x = x;
            this.y = y;
        }

        String read() {
            return x + y;
        }
    }
}

class SuperData {
    private String x;
    private String y;
    private Optional<String> opt;

    public Optional<String> getX(String a, Optional<String> b) {
        return Optional.of(b.orElse(x + y + a + b));
    }
}