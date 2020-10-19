package module_02;

import java.util.Scanner;

public class ArithmeticalOperations {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a:");
        int a=sc.nextInt();
        System.out.print("Enter b:");
        int b=sc.nextInt();
        computeValues(a, b);
    }

    private static void computeValues(int a, int b) {
        int resulta,results,resultm;
        float resultd;
        resulta=a+b;
        results=a-b;
        resultm=a*b;
        resultd=(float)a/b;
        System.out.println("The result of adding is "+resulta);
        System.out.println("The result of subtracting is "+results);
        System.out.println("The result of multiplying is "+resultm);
        System.out.println("The result of dividing is "+resultd);
    }
}
