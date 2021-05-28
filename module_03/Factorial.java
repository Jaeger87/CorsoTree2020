package module_03;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(0) == (1));
        System.out.println(factorial(2) == (2));
        System.out.println(factorial(3) == (6));
        System.out.println(factorial(5) == (120));
        System.out.println(factorial(10) == (3628800));
        System.out.println(factorial(20) == 2432902008176640000L);
    }

    private static long factorial(int n) {
        if(n == 0)
            return 1;
        long factorial = 1;
        for(int i=1; i<=n; i++) {
            factorial *= i;
        }
        return factorial;
    }

}
