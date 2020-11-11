package module_08.tweets_parser;

import java.util.Comparator;
import java.util.Objects;

public class WordObject implements Comparable<WordObject>{
    private String word;
    private int count;

    public WordObject(String word, int count) {
        this.word = word;
        this.count = count;
    }

    public String getWord() {
        return word;
    }

    public int getCount() {
        return count;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void increaseCount() {
        this.count += 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordObject that = (WordObject) o;
        return Objects.equals(word, that.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word);
    }

    @Override
    public int compareTo(WordObject o) {
        if(this.equals(o))
            return 0;
        return Comparator.comparing(WordObject::getCount)
                .compare(this, o);
    }
}
