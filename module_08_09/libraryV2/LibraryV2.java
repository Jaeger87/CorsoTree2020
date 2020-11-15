package module_08_09.libraryV2;

import java.util.*;

public class LibraryV2 {

    private Map<Author, Set<Book>> library = new HashMap<>();

    public void insertBook(Author author, Book book) {
       if(author == null || book == null)
           return;
       if(library.containsKey(author))
           library.get(author).add(book);
        else {
            Set<Book> books = new HashSet<>();
            books.add(book);
            library.putIfAbsent(author, books);
        }
    }
    public void removeBook(Book book) {
        if(book == null)
            return;
        for(Author author : library.keySet())
            library.get(author).removeIf(book1 -> book1.equals(book));
    }

    public Set<Book> getBooks(Author author) throws AuthorNotFoundException {
        checkAuthorExistsInLibrary(author);
        return library.get(author);
    }

    public Set<Book> getBooks(String code) {
        Set<Book> found = new HashSet<>();
        for(Map.Entry<Author, Set<Book>> entry : library.entrySet())
            for(Book book : entry.getValue())
                if(book.getCode().equals(code))
                    found.add(book);
        return found;
    }

    public Set<Book> getBooksByTitle(String title) {
        Set<Book> found = new HashSet<>();
        for(Map.Entry<Author, Set<Book>> entry : library.entrySet())
            for(Book book : entry.getValue())
                if(book.getTitle().startsWith(title) || book.getTitle().contains(title)
                        || book.getTitle().endsWith(title) )
                    found.add(book);
        return found;
    }

    @Override
    public String toString() {
        Set<Book> books = new HashSet<>();
        for(Author author : library.keySet())
            books.addAll(library.get(author));
        String text = "";
        List<Book> list = new ArrayList<>(books);
        list.sort(Comparator.comparing(Book::getTitle));
        for(Book book : list)
            text += book.toString() + "\n";
        return text.substring(0,text.length()-1);
    }


    private void checkAuthorExistsInLibrary(Author author) throws AuthorNotFoundException {
        if(!library.containsKey(author)){
            throw new AuthorNotFoundException();
        }
    }



    public static void main(String[] args) {
        LibraryV2 library = new LibraryV2();
        Book b = new Book(
                "123456",
                "Il signore degli anelli",
                "Il Signore degli Anelli (titolo originale in inglese: " +
                        "The Lord of the Rings) è un romanzo high fantasy epico scritto da J. R. R. Tolkien" +
                        " e ambientato alla fine della Terza Era dell'immaginaria Terra di Mezzo"
                );
        Author a = new Author(
                "abcdef",
                "John Ronald Reuel",
                "Tolkien"
        );
        library.insertBook(a, b);
        Book b2 = new Book(
                "111111",
                "Lo Hobbit",
                "Lo Hobbit o la riconquista del tesoro (titolo originale: The Hobbit, sottotitolato" +
                        " There and Back Again, ossia \"Andata e ritorno\")," +
                        " noto anche semplicemente come Lo Hobbit, è un romanzo fantasy scritto da J. R. R. Tolkien."
                );
        library.insertBook(a, b2);
        Set<Book> books = null;
        try {
            books = library.getBooks(a);
        } catch (AuthorNotFoundException e) {
            System.out.println("My bad");
        }
        System.out.println(books != null);
        System.out.println(books.stream().count() == 2);
        Book b3 = new Book(
                "119929",
                "1984",
                "1984 (Nineteen Eighty-Four) è uno dei più celebri romanzi di George Orwell, " +
                        "pubblicato nel 1949 ma iniziato a scrivere nel" +
                        " 1948 (anno da cui deriva il titolo, ottenuto appunto dall'inversione delle ultime due cifre)."
        );
        Author a2 = new Author(
                "aaabbb",
                "George",
                "Orwell"
        );
        library.removeBook(b);
        try {
            books = library.getBooks(a);
        } catch (AuthorNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(books.stream().count() == 1);
        library.insertBook(a2, b3);
        try {
            books = library.getBooks(a2);
        } catch (AuthorNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(books.stream().count() == 1);
        Book b4 = new Book(
                "454545",
                "La fattoria degli animali",
                "La fattoria degli animali è una novella allegorica di George Orwell pubblicata " +
                        "per la prima volta il 17 agosto 1945. Secondo Orwell, il libro riflette sugli " +
                        "eventi che portarono alla Rivoluzione russa e successivamente all'era staliniana " +
                        "dell'Unione sovietica"
        );
        library.insertBook(a2, b4);
        System.out.println(library.toString());
    }

    class AuthorNotFoundException extends Exception {
        private final String errorCode = "1";
    }
}
