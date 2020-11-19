import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Book {

    private long[] lettersArray;
    private String fileName;
    private TreeSet<BookEntry> ranking;
    private static final int LENRANKING = 5;

    public Book(String fileName, long[] lettersArray) {
        this.lettersArray = lettersArray;
        this.fileName = fileName;
        this.ranking = new TreeSet<>();
    }

    public long[] getLettersArray() {
        return lettersArray;
    }

    public String getFileName() {
        return fileName;
    }

    public List<BookEntry> getRanking() {
        return new ArrayList<>(ranking);
    }

    public void updateRanking(String fileName, double distance) {
        synchronized (ranking) {
            if (ranking.size() < LENRANKING)
                ranking.add(new BookEntry(fileName, distance));

            else if (ranking.last().getDistance() > distance) {
                ranking.remove(ranking.last());
                ranking.add(new BookEntry(fileName, distance));
            }

        }
    }

    @Override
    public String toString() {
        return fileName + ": " + getRanking().toString();
    }
}
