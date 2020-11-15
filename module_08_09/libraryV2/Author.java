package module_08_09.libraryV2;

import java.util.Objects;

public  class Author {
    private String code, name, surname;

    public Author(String code, String name, String surname) {
        this.code = code;
        this.name = name;
        this.surname = surname;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(code, author.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}