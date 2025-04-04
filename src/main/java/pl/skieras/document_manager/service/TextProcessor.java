package pl.skieras.document_manager.service;

import org.springframework.boot.json.JsonWriter;
import org.springframework.boot.json.WritableJson;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;
import java.nio.file.Paths;
import java.util.*;

public class TextProcessor {
    private final WordExtractor extractor;
    private final JsonWriter jsonWriter;

    public TextProcessor() {
        this.extractor = new WordExtractor();
        this.jsonWriter = new JsonWriter() {
            @Override
            public void write(Object instance, Appendable out) throws IOException {

            }

            @Override
            public String writeToString(Object instance) {
                return JsonWriter.super.writeToString(instance);

            @Override
            public JsonWriter withNewLineAtEnd() {
                return JsonWriter.super.withNewLineAtEnd();
            }

            @Override
            public JsonWriter withSuffix(String suffix) {
                return JsonWriter.super.withSuffix(suffix);
            }
        };
    }

    public void process(String inputFilePath, String outputFilePath) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(inputFilePath)));
        List<String> words = extractor.extractWords(content);
        jsonWriter.writeToString(words);
    }
}