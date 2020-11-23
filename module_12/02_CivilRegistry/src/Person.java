import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Person implements Comparable<Person> {
    private String name, surname, fiscalCode, address;
    private LocalDate birthDate;
    private List<Person> children;

    public Person(String name, String surname, String fiscalCode,
                  String address, LocalDate birthDate, List<Person> children) {
        this.name = name;
        this.surname = surname;
        this.fiscalCode = fiscalCode;
        this.address = address;
        this.birthDate = birthDate;
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getFiscalCode() {
        return fiscalCode;
    }

    public String getAddress() {
        return address;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public List<Person> getChildren() {
        return children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(fiscalCode, person.fiscalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fiscalCode);
    }

    @Override
    public int compareTo(Person o) {
        return Comparator
                .comparing(Person::getFiscalCode)
                .compare(this, o);
    }
}
