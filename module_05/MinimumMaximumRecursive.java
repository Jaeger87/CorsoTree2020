package module_05;

public class MinimumMaximumRecursive {

    public static void main(String[] args) {
        int[] arr = { 12, 1234, 45, 67, 1, 0, -2, 9 };
        minMaxRecursive(arr);
    }

    public static void minMaxRecursive(int[] array) {
        System.out.println(getMinRecursive(array, 0));
        System.out.println(getMaxRecursive(array, 0));
    }

    private static int getMinRecursive(int[] array, int actualIndex) {
        if(actualIndex == array.length - 1)
            return array[actualIndex];
        return Math.min(array[actualIndex], getMinRecursive(array, actualIndex+1));
    }

    private static int getMaxRecursive(int[] array, int actualIndex) {
        if(actualIndex == array.length - 1)
            return array[actualIndex];
        return Math.max(array[actualIndex], getMaxRecursive(array, actualIndex+1));
    }
}
