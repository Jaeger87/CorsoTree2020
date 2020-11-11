package module_08.tweets_parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class TweetsParser {

    Map<String, Integer> countMap = new HashMap<>();

    public Set<String> getMostFrequentWords(String path, int n) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine(); //skip first
            while ((line = br.readLine()) != null) {
                processLine(line);
            }
        }

        List<WordObject> mostFrequentWords = new ArrayList<>();
        for(String word : countMap.keySet()) {
            if (mostFrequentWords.size() < n) {
                mostFrequentWords.add(new WordObject(word, countMap.get(word)));
            }
            else {
                WordObject minMostFrequentWord = Collections.min(mostFrequentWords);
                if (minMostFrequentWord.getCount() < countMap.get(word)) { //update
                    mostFrequentWords.remove(minMostFrequentWord);
                    mostFrequentWords.add(new WordObject(word, countMap.get(word)));
                }
            }

        }
        Set<String> result = new HashSet<>();
        for(WordObject wordObject : mostFrequentWords)
            result.add(wordObject.getWord());
        return result;

        //WITH STREAMS
        /*
        return mostFrequentWords.stream()
                .map(WordObject::getWord)
                .collect(Collectors.toSet());*/
    }

    private void processLine(String line) {
        String[] components = line.split(",");
        String content = "";
        for(int i=0; i<components.length; i++)
            if((i >= 2 && i < components.length-3))
                content += components[i];

        for(String word : content.split(" ")){
            String cleanWord = cleanData(word);
            if(cleanWord.isEmpty())
                continue;
            int count = countMap.getOrDefault(cleanWord, 1);
            countMap.put(cleanWord, count+1);
        }
    }

    private static String cleanData(String tweet) {
            //convert tweet to lower case
            tweet = tweet.toLowerCase();

            //remove # from hash tag
            tweet = tweet.replaceAll("#", "");

            //remove punctuation
            tweet = tweet.replaceAll("[-+.^:,()&%$\"\'!;=<=/#@?^_]", "");

            //remove only numbers text
            tweet = tweet.replaceAll("[0-9]", "");

        return tweet;
    }

    public static void main(String[] args) throws IOException {
        String path = "path to file";
        TweetsParser tweetsParser = new TweetsParser();
        System.out.println(tweetsParser.getMostFrequentWords(path, 10));
    }
}
