package module_02;

public class  CompareStrings {
    public static void main(String[] args) {
        String a = "ciao come va ?";
        String b = "cIao come vA ?";
        String c = "ciao come va ";
        System.out.println("2".equals(""+compareStrings(a, b, c)));
        a = "ciao come va ?";
        b = "cIaoo come vA ?";
        c = "ciao come va a";
        System.out.println("1".equals(""+compareStrings(a, b, c)));
        a = "ciao come va ?";
        b = "cIao come va ?";
        c = "ciao come vA ?";
        System.out.println("3".equals(""+compareStrings(a, b, c)));
        c = "ciao come va ?";
        a = "cIao come va ?";
        b = "ciao come v ?";
        System.out.println("2".equals(""+compareStrings(a, b, c)));
        c = "z";
        a = "a";
        b = "z";
        System.out.println("2".equals(""+compareStrings(a, b, c)));
        a = "aaa";
        b = "bbb";
        c = "ccc";
        System.out.println("1".equals(""+compareStrings(a, b, c)));
        a = "aaa";
        b = "aaa";
        c = "ccc";
        System.out.println("2".equals(""+compareStrings(a, b, c)));
        a = "aaa";
        b = "ccc";
        c = "ccc";
        System.out.println("2".equals(""+compareStrings(a, b, c)));
        a = "aaa";
        b = "aaa";
        c = "aaa";
        System.out.println("3".equals(""+compareStrings(a, b, c)));
    }

    private static int compareStrings(String a, String b, String c) {
        a = a.toLowerCase();
        b = b.toLowerCase();
        c = c.toLowerCase();
        if(a.equals(b) && b.equals(c))
            return 3;
        if(a.equals(b) || b.equals(c) || a.equals(c))
            return 2;
        return 1;
        /*
        return a.equals(b) && b.equals(c) ? 3
                : a.equals(b) || b.equals(c) || a.equals(c) ? 2
                : 1;
        */
    }
}
