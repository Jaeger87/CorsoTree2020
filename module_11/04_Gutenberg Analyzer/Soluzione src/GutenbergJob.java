import java.io.*;
import java.util.Scanner;

public class GutenbergJob implements Runnable {

    private String path;
    private long[] arrayLettere;
    private String fileName;
    private RankingRegistry rankingRegistry;

    public GutenbergJob(String folder, String fileName, RankingRegistry rankingRegistry) {
        this.path = folder + '\\' + fileName ;
        this.fileName = fileName;
        arrayLettere = new long[26];
        this.rankingRegistry = rankingRegistry;
    }

    @Override
    public void run() {
        try (
                InputStream istream = new FileInputStream(path); // Or Reader or something
                Scanner scanner = new Scanner(istream)
        ) {
            while(scanner.hasNext()) {
                String line = scanner.nextLine();
                line.toLowerCase();
                for (char c : line.toCharArray()) {
                    if (c < 123 && c > 96) {
                        arrayLettere[c - 97]++;
                    }
                }
            }

        } catch (IOException e) {
            System.out.println(e.toString());
        }

        rankingRegistry.addBook(fileName, arrayLettere);

    }

    public long[] getArrayLettere() {
        return arrayLettere;
    }
}
