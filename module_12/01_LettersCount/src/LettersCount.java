import java.util.List;

public class LettersCount {

    static int lettersCount(List<String> names) {
        return names.stream()
                .filter(name -> name.startsWith("f"))
                .map(String::length)
                .reduce(0, Integer::sum);
    }

    public static void main(String[] args) {
        List<String> names = List.of("marco", "franco", "federico", "mario");
        System.out.println(lettersCount(names) == 14);
    }
}
