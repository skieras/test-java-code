package pl.skieras.documśent_manager.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.*;

class JsonWriter {
    private final ObjectMapper mapper = new ObjectMapper();

    public void writeToJson(List<String> words, String outputFilePath) throws IOException {
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(outputFilePath), words);
    }
}
