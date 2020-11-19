import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Main {

    private static ExecutorService pool;
    private static final String PATHFOLDER = "books";
    private static List<String> books;
    private static RankingRegistry rankingRegistry;

    public static void main(String[] args) {


        long startTime = System.currentTimeMillis();
        books = new ArrayList<>();
        pool = Executors.newFixedThreadPool(8);

        File folder = new File(PATHFOLDER);
        File[] listOfFiles = folder.listFiles();
        List<Future<?>> futuresJobs = new ArrayList<>();

        for(File f : listOfFiles)
            books.add(f.getName());

        rankingRegistry = new RankingRegistry();

        String fileName = "";
        for (int i = 0; i < listOfFiles.length; i++)
            if (listOfFiles[i].isFile()) {
                fileName = listOfFiles[i].getName();
                GutenbergJob job = new GutenbergJob(PATHFOLDER, fileName, rankingRegistry);
                futuresJobs.add(pool.submit(job));
            }


        pool.shutdown();
        try {
            pool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
            /*qui puoi assumere che tutti i thread abbiano terminato il proprio lavoro*/
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(rankingRegistry);

        System.out.println(System.currentTimeMillis() - startTime);

    }

}
