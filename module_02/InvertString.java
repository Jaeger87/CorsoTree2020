package module_02;

import java.util.Scanner;

public class InvertString {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter string:");
        String a=sc.nextLine();
        reverseString(a);
    }

    private static void reverseString(String s) {
        String[] split = s.split(" ");
        System.out.println(split[1] + " " + split[0]);
    }

}
