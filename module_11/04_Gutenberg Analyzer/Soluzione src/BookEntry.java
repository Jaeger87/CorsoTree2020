public class BookEntry implements Comparable<BookEntry>{

    private String fileName;
    private double distance;

    public BookEntry(String fileName, double distance) {
        this.fileName = fileName;
        this.distance = distance;
    }

    public String getFileName() {
        return fileName;
    }

    public double getDistance() {
        return distance;
    }

    @Override
    public int compareTo(BookEntry o) {
        if(o.distance > distance)
            return -1;
        if(o.distance < distance)
            return 1;
        return 0;
    }

    @Override
    public String toString() {
        return fileName + "--" + distance;
    }
}
