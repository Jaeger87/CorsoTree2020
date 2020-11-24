import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

public class ArcadeRank {

    private Set<VideoGame> availableVideoGames = new HashSet<>();
    private Set<User> users = new HashSet<>();
    private int gamesSize;
    private ArrayList<Game> games = new ArrayList<>();
    //private Map<VideoGame, Set<UserScore>> scores = new HashMap<>();

    private static ArcadeRank instance;

    public ArcadeRank(int maxSize) {
        this.gamesSize = maxSize;
    }

    public static ArcadeRank getInstance(int maxSize) {
        return instance == null ? new ArcadeRank(maxSize) : instance;
    }

    public void insertUser(UUID uuid, String username) {
        users.add(new User(uuid, username));
    }

    public void insertVideoGame(UUID uuid, String name, VideoGameDifficulty difficulty) {
        VideoGame videoGame = new VideoGame(uuid, name, difficulty);
        availableVideoGames.add(videoGame);
        //scores.put(videoGame, new TreeSet<>());
    }

    private Optional<VideoGame> getVideoGameById(String videoGameId) {
        return availableVideoGames.stream()
                .filter(vg -> vg.getUuid().toString().equals(videoGameId))
                .findFirst();
    }

    private Optional<User> getUserById(String userId) {
        return users.stream()
                .filter(us -> us.getUuid().toString().equals(userId))
                .findFirst();
    }

    public void insertGame(String userId, String videoGameId, int score) {
        Optional<VideoGame> videoGameOptional = getVideoGameById(videoGameId);
        if(videoGameOptional.isEmpty())
            return;
        Optional<User> userOptional = getUserById(userId);
        if(userOptional.isEmpty())
            return;
        User user = userOptional.get();
        VideoGame videoGame = videoGameOptional.get();
        Game game = new Game(videoGame, user, score);
        if(games.size() == gamesSize)
            games.remove(0);
        if(availableVideoGames.contains(videoGame))
            games.add(game);
    }

    public List<Game> getLastGames(int n) {
        if(n > gamesSize)
            n = gamesSize;
        return games.subList(games.size()-3, games.size());
    }

    public VideoGameChart getVideoGameChart(String videoGameId) {
        Optional<VideoGame> videoGameOptional = getVideoGameById(videoGameId);
        if(videoGameOptional.isEmpty())
            return null;
        VideoGame videoGame = videoGameOptional.get();

        Map<User, Integer> scoresByUser = games.stream()
                .filter(game -> game.getVideoGame().getUuid().toString().equals(videoGameId))
                .collect(
                        groupingBy(Game::getUser, summingInt(Game::getScore))
                );
        Map<User, Integer> top3 = scoresByUser.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
        return new VideoGameChart(videoGame, top3);
    }

    public GlobalChart getGlobalChart() {
        Map<User, Integer> scoresByUser = games.stream()
                .collect(
                        groupingBy(Game::getUser, summingInt(g->g.getScore() * g.getVideoGame().getDifficulty().getValue()))
                ).entrySet().stream()
                .sorted(Map.Entry.<User, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
        return new GlobalChart(scoresByUser);
    }
    public static void main(String[] args) {
        ArcadeRank arcadeRank = ArcadeRank.getInstance(100);
        UUID user1 = UUID.randomUUID();
        UUID user2 = UUID.randomUUID();
        UUID user3 = UUID.randomUUID();
        UUID user4 = UUID.randomUUID();
        UUID v1 = UUID.randomUUID();
        UUID v2 = UUID.randomUUID();
        UUID v3 = UUID.randomUUID();
        UUID v4 = UUID.randomUUID();
        arcadeRank.insertUser(user1, "marco");
        arcadeRank.insertUser(user2, "mario");
        arcadeRank.insertUser(user3, "giovanni");
        arcadeRank.insertUser(user4, "marta");
        arcadeRank.insertVideoGame(v1, "halo", VideoGameDifficulty.expert);
        arcadeRank.insertVideoGame(v2, "cod", VideoGameDifficulty.medium);
        arcadeRank.insertVideoGame(v3, "battlefield", VideoGameDifficulty.veteran);
        arcadeRank.insertVideoGame(v4, "fifa", VideoGameDifficulty.easy);
        arcadeRank.insertGame(user1.toString(), v2.toString(), 10);
        arcadeRank.insertGame(user2.toString(), v2.toString(), 20);
        arcadeRank.insertGame(user1.toString(), v3.toString(), 30);
        arcadeRank.insertGame(user3.toString(), v4.toString(), 5);
        arcadeRank.insertGame(user4.toString(), v2.toString(), 45);
        arcadeRank.insertGame(user3.toString(), v1.toString(), 100);
        List<Game> lastGames = arcadeRank.getLastGames(3);
        System.out.println(lastGames.size() == 3
                && lastGames.get(0).getScore() == 5
                && lastGames.get(1).getScore() == 45
                && lastGames.get(2).getScore() == 100);

        VideoGameChart chart = arcadeRank.getVideoGameChart(v2.toString());
        System.out.println(chart.toString());

        GlobalChart globalChart = arcadeRank.getGlobalChart();
        System.out.println(globalChart.toString());
        //globalChart.getScores().stream()
        // .forEach(userScore -> System.out.println(userScore.toString()));
        System.out.println();
    }


}
