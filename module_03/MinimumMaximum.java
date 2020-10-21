package module_03;

import java.util.Scanner;

public class MinimumMaximum {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter numbers (comma-separated):");
        String a = sc.nextLine();
        int[] values = parseNumbers(a);
        computeMinAndMax(values);
    }

    static int[] parseNumbers(String s) {
        String[] values = s.split(",");
        int[] result = new int[values.length];
        for(int i=0; i<values.length; i++)
            result[i] = Integer.parseInt(values[i]);
        return result;
    }

    static void computeMinAndMax(int[] values) {
        int min = 0, max = 0;
        for(int value : values)
            if(value < min)
                min = value;
            else if(value > max)
                max = value;
        System.out.println(min + "," + max);
    }
}
