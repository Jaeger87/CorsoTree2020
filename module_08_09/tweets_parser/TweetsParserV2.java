package module_08_09.tweets_parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class TweetsParserV2 {

    Map<String, WordObject> words = new HashMap<>();

    public Set<String> getMostFrequentWords(String path, String stopWordsPath, int n) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine(); //skip first
            Set<String> stopWords = getStopWords(stopWordsPath);
            while ((line = br.readLine()) != null)
                processLine(line, stopWords);
        }
        return words.values().stream()
                .sorted(Comparator.reverseOrder())
                .limit(n)
                .map(WordObject::getWord)
                .collect(Collectors.toSet());
    }

    private Set<String> getStopWords(String filePath) throws IOException {
        Set<String> stopWords = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null)
                stopWords.add(line);
        }
        return stopWords;
    }

    private void processLine(String line, Set<String> stopWords) {
        String[] components = line.split(",");
        String content = "";
        for(int i=0; i<components.length; i++)
            if((i >= 2 && i < components.length-3))
                content += components[i];

        for(String word : content.split(" ")){
            String cleanWord = cleanData(word);
            if(cleanWord.isEmpty() || stopWords.contains(cleanWord))
                continue;
            WordObject wordObject = words.getOrDefault(cleanWord, new WordObject(cleanWord, 0));
            wordObject.increaseCount();
            words.put(cleanWord, wordObject);
        }
    }

    private static String cleanData(String tweet) {

        //convert tweet to lower case
        tweet = tweet.toLowerCase();

        //removes all non-letter characters
        tweet = tweet.replaceAll("[^a-zA-Z ]", "");

        return tweet;
    }

    public static void main(String[] args) throws IOException {
        String path = "path to file";
        String stopWordsPath = "path to file";
        TweetsParserV2 tweetsParser = new TweetsParserV2();
        System.out.println(tweetsParser.getMostFrequentWords(path, stopWordsPath, 10));
    }
}
