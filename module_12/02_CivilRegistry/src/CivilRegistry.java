
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class CivilRegistry {
    private static List<Person> registry = new ArrayList<>();

    private static CivilRegistry instance;

    public static CivilRegistry getInstance() {
        if(instance == null)
            instance = new CivilRegistry();
        return instance;
    }

    public void insertPerson(Person person) {
        registry.add(person);
    }

    public void removePerson(String fiscalCode) {
        registry = registry.stream()
                .filter(person -> !person.getFiscalCode().equals(fiscalCode))
                .collect(Collectors.toList());
        //ANOTHER SOLUTION
        //registry.removeIf(person -> person.getFiscalCode().equals(fiscalCode));
        //BOTH ARE SLOWER THAN SIMPLE ITERATION + BREAK WHEN FOUND
    }

    public Set<Person> getPeopleByName(String name) {
        return registry.stream()
                .filter(person -> person.getName().equals(name) || person.getName().startsWith(name))
                .collect(Collectors.toSet());
    }

    public Set<Person> getOldestPeople() {
        return registry.stream()
                .sorted(Comparator.comparing(Person::getBirthDate))
                //ANOTHER VERSION
                //.sorted((o1, o2) -> o1.getBirthDate().compareTo(o2.getBirthDate()))
                .limit(3)
                .collect(Collectors.toSet());
    }

    public Set<String> getAddressesByName(String name) {
        return getPeopleByName(name).stream()
                .map(Person::getAddress)
                .collect(Collectors.toSet());
    }

    public Set<Person> getChildren(String name) {
        return getPeopleByName(name).stream()
                .map(Person::getChildren)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }

    public static void main(String[] args) {
        Person p0 = new Person("chiara", "rossi", "0",
                "Via Torino", LocalDate.of(1997, 12, 22), new ArrayList<>());
        Person p3 = new Person("marta", "rossi", "3",
                "Via Torino", LocalDate.of(1985, 12, 22), new ArrayList<>());
        Person p4 = new Person("piero", "rossi", "4",
                "Via Ragusa", LocalDate.of(1995, 12, 22), new ArrayList<>());
        Person p1 = new Person("cristina", "rossi", "1",
                "Via Roma", LocalDate.of(1945, 12, 22), new ArrayList<>());
        Person p2 = new Person("mario", "rossi", "2",
                "Via Milano", LocalDate.of(1935, 12, 22), Arrays.asList(p3));
        Person p5 = new Person("mario alberto", "rossi", "4",
                "Via Palermo", LocalDate.of(1946, 12, 22), Arrays.asList(p4, p0));
        CivilRegistry civilRegistry = CivilRegistry.getInstance();
        civilRegistry.insertPerson(p1);
        civilRegistry.insertPerson(p2);
        civilRegistry.insertPerson(p3);
        civilRegistry.insertPerson(p4);
        civilRegistry.insertPerson(p5);
        Set<Person> oldest = civilRegistry.getOldestPeople();
        System.out.println(oldest.size() == 3);
        System.out.println(oldest.contains(p1) && oldest.contains(p2) && oldest.contains(p5));
        Set<Person> marios = civilRegistry.getPeopleByName("mario");
        System.out.println(marios.size() == 2);
        Set<String> addresses = civilRegistry.getAddressesByName("mario");
        System.out.println(addresses.size() == 2);
        Set<Person> children = civilRegistry.getChildren("mario");
        System.out.println(children.size() == 3);
    }


}

