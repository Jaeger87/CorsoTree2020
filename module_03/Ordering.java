package module_03;

import java.util.Arrays;
import java.util.Scanner;

public class Ordering {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter numbers (comma-separated):");
        String a = sc.nextLine();
        int[] values = parseNumbers(a);
        int[] ordered = reorder(values);
        for(int value : ordered)
            System.out.println(value);
    }
    
    static int[] parseNumbers(String s) {
        String[] values = s.split(",");
        int[] result = new int[values.length];
        for(int i=0; i<values.length; i++)
            result[i] = Integer.parseInt(values[i]);
        return result;
    }

    /*SOLUTION 1*/
    /*public static int[] reorder(int[] array) {
        int[] ordered = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            int greaters = howManyAreGreater(array, array[i]);
            ordered[array.length - 1 - greaters] = array[i];
        }
        return ordered;
    }

    private static int howManyAreGreater(int[] array, int n) {
        int cont = 0;
        for(int value : array)
            if(value > n)
                cont++;
        return cont;
    }*/

    /*SOLUTION 2*/
    public static int[] reorder(int[] array) {
        return mergeSortRecursive(array);
    }

    private static int[] mergeSortRecursive(int[] array) {
        if(array.length == 1)
            return array;
        int middle = array.length/2;
        int[] left = mergeSortRecursive(Arrays.copyOfRange(array,0, middle));
        int[] right = mergeSortRecursive(Arrays.copyOfRange(array, middle, array.length));
        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i=0, j=0;
        while(i<left.length && j < right.length) {
            if(left[i] < right[j])
                result[i+j] = left[i++];
            else
                result[i+j] = right[j++];
        }
        //se rimangono elementi in left
        while(i<left.length) {
            result[i+j] = left[i++];
        }
        //se rimangono elementi in right
        while(j < right.length) {
            result[i+j] = right[j++];
        }
        return result;
    }
}
