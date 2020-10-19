package module_03;

import java.util.Scanner;

public class CountOccurrences {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter character a:");
        String a = sc.nextLine();
        System.out.print("Enter string b:");
        String b =sc.nextLine();
        countOccurrences(a.charAt(0), b);
    }

    static void countOccurrences(char a, String b) {
        //SOLUTION 1
        /*int contatore = 0;
        for(char c : b.toCharArray())
            if(c == a)
                contatore++;
        System.out.println(contatore);*/

        //SOLUTION 2
        //System.out.println(b.length() - b.replaceAll(a+"", "").length());

        //SOLUTION 3
        int contatore = 0;
        for(int i=0; i<b.length(); i++)
            if(b.charAt(i) == a)
                contatore++;
        System.out.println(contatore);
    }
}
