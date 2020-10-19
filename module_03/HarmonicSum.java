package module_03;

public class HarmonicSum {
    public static void main(String[] args) {
        System.out.println(harmonicSum(1) == (1));
        System.out.println(harmonicSum(2) == (3./2));
        System.out.println(harmonicSum(20) == (55835135./15519504));
    }

    private static double harmonicSum(int n) {
        if(n == 0)
            return 0;
        double sum = 0;
        for(double i=1; i<=n; i++) {
            sum += 1/i;
        }
        return sum;
    }
}
