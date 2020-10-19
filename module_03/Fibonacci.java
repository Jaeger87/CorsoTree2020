package module_03;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter index:");
        int index =sc.nextInt();
        fibonacci(index);
    }

    static void fibonacci(int index) {
        int[] results = new int[index+1];
        results[0] = 0;
        results[1] = 1;
        for(int i=2; i<=index; i++)
            results[i] = results[i-1] + results[i-2];
        System.out.println(results[index]);
    }
}
