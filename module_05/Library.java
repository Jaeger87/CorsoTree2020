package module_05;

import module_03.BinarySearch;
import module_03.Ordering;

public class Library {
    public static void main(String[] args) {
        int[] values = new int[7];
        values[0] = 123;
        values[1] = 4;
        values[2] = 98;
        values[3] = 33;
        values[4] = 76;
        values[5] = 2;
        values[6] = 235;
        Library library = new Library(values);
        System.out.println(library.existsBook(76));
        int[] booksIndexes = library.getOrderedBooksIndexes();
        System.out.println(booksIndexes[0] == 2);
        System.out.println(booksIndexes[1] == 4);
        System.out.println(booksIndexes[2] == 33);
        System.out.println(booksIndexes[3] == 76);
        System.out.println(booksIndexes[4] == 98);
        System.out.println(booksIndexes[5] == 123);
        System.out.println(booksIndexes[6] == 235);
    }

    private int[] booksIndexes;

    public Library(int[] booksIndexes) {
        this.booksIndexes = Ordering.reorder(booksIndexes);
    }

    private boolean existsBook(int bookToFind) {
        return BinarySearch.binarySearch(booksIndexes, bookToFind) != -1;
    }

    private int[] getOrderedBooksIndexes() {
        return booksIndexes;
    }

}