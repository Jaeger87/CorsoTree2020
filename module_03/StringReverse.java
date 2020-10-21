package module_03;

import java.util.Scanner;

public class StringReverse {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter string:");
        String a = sc.nextLine();
        stringReverse(a);
    }

    static void stringReverse(String s) {
        String result = "";
        for(int i=s.length()-1; i>=0; i--)
            result += s.charAt(i);
        System.out.println(result);
    }
}
