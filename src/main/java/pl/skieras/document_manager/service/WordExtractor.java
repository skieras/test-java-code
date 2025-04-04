package pl.skieras.document_manager.service;

import java.util.*;
import java.util.regex.*;


class WordExtractor {
    public List<String> extractWords(String text) {
        List<String> words = new ArrayList<>();
        Matcher matcher = Pattern.compile("\\b\\w+\\b").matcher(text);
        while (matcher.find()) {
            words.add(matcher.group());
        }
        return words;
    }
}