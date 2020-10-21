package module_03;

public class BinarySearch {
    public static void main(String[] args) {
        int[] values = new int[7];
        values[0] = 1;
        values[1] = 2;
        values[2] = 4;
        values[3] = 33;
        values[4] = 76;
        values[5] = 98;
        values[6] = 235;
        int index = binarySearch(values, 235);
        System.out.println(index);
        values = new int[6];
        values[0] = 1;
        values[1] = 2;
        values[2] = 4;
        values[3] = 33;
        values[4] = 76;
        values[5] = 98;
        index = binarySearch(values, 98);
        System.out.println(index);
    }

    public static int binarySearch(int[] values, int n) {
        return binarySearchRecursive(values, 0, values.length-1, n);
    }

    private static int binarySearchRecursive(int[] values, int begin, int end, int n) {
        if(values[(begin+end)/2] == n)
            return (begin+end)/2;
        if(begin>=end) //not found
            return -1;
        if(values[(begin+end)/2] > n)
            return binarySearchRecursive(values, begin, (begin+end)/2-1, n);
        return binarySearchRecursive(values, (begin+end)/2+1, end, n);

    }

}
