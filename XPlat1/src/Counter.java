import java.math.BigInteger;

public class Counter {

    private int N;

    Counter () {}

    Counter (int n) {
        N = n;
    }

    public int getN() {
        return N;
    }

    public void setN(int n) {
        N = n;
    }

    private static long gcdByEuclidsAlgorithm(long n1, long n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcdByEuclidsAlgorithm(n2, n1 % n2);
    }

    private static String reduce(BigInteger num, BigInteger denom){
        BigInteger gcd = num.gcd(denom);
        BigInteger reducedNum = num.divide(gcd);
        BigInteger reducedDenom = denom.divide(gcd);
        if(reducedNum.compareTo(num) == 0){ return ""; }
        else{ return "\nReduced:" + reducedNum + "/" + reducedDenom; }
    }

    private String reduce(long num, long denom){
        long gcd = gcdByEuclidsAlgorithm(num,denom);
        long reducedNum = num/gcd;
        long reducedDenom = denom/gcd;
        if(reducedNum == num){ return ""; }
        else{ return "\nReduced:" + reducedNum + "/" + reducedDenom; }
    }


    private long[] impreciseSeriesSum(int n){
        long num = 0, denum = 1;
        for(int i=1;i<=n;i++){
            denum *= (Math.pow(i,3)+5);
        }
        for(int i=1;i<=n;i++){
            num += denum/(Math.pow(i,3)+5);
        }

        System.out.println(COLORS.ANSI_GREEN + "Success!" + COLORS.ANSI_RESET);

        return new long[]{num, denum};
    }

    private BigInteger[] preciseSeriesSum(int n){
        BigInteger num = BigInteger.valueOf(0), denum = BigInteger.valueOf(1);
        for(int i=1;i<=n;i++){
            denum = denum.multiply(BigInteger.valueOf(i).pow(3).add(BigInteger.valueOf(5)));
        }
        for(int i=1;i<=n;i++){
            num = num.add(denum.divide(BigInteger.valueOf(i).pow(3).add(BigInteger.valueOf(5))));
        }
        System.out.println(COLORS.ANSI_GREEN + "Success!" + COLORS.ANSI_RESET);
        return new BigInteger[]{num, denum};
    }

    public String getResult() {
        System.out.println(COLORS.ANSI_CYAN + "Please, wait, I'm calculating.. " + COLORS.ANSI_RESET);
        if(N < 10) {
            long[] res = impreciseSeriesSum(N);
            return  res[0] + "/" + res[1] + reduce(res[0], res[1]) ;
        }
        BigInteger[] res = preciseSeriesSum(N);
        return res[0] + "/" + res[1] + reduce(res[0], res[1]);
    }
}
