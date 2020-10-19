package module_02;

import java.util.Scanner;

public class ReplaceIntruders {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter string:");
        String a=sc.nextLine();
        System.out.print("Enter string:");
        String b=sc.nextLine();
        System.out.print("Enter string:");
        String c=sc.nextLine();
        replaceIntruder(a, b, c);
    }

    private static String replaceIntruder(String a, String b , String c) {
        String[] split = c.split(" ");
        return
                split[0] + " " +
                        split[1].replaceAll(a, b)
                +
                " " + split[2];
    }

}
