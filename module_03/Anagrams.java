package module_03;

import java.util.Scanner;

public class Anagrams {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter string a:");
        String a = sc.nextLine();
        System.out.print("Enter string b:");
        String b =sc.nextLine();
        anagrams(a, b);
    }

    static void anagrams(String a, String b) {
        if(a.length() != b.length()) {
            System.out.println("non anagrammi");
            return;
        }
        a = a.toLowerCase();
        b = b.toLowerCase();
        for(char ca : a.toCharArray())
            for(int i=0; i<b.toCharArray().length; i++)
                if(ca == b.charAt(i)) {
                    b=b.substring(0, i) + b.substring(i+1);
                    break;
                }
        if(b.length() == 0)
            System.out.println("anagrammi");
        else
            System.out.println("non anagrammi");
    }
}
