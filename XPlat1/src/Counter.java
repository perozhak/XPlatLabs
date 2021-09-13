import java.math.BigDecimal;

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

    private double impreciseSeriesSum(int n){
        double seriesSum = 0;
        for(int i = 0; i <= n; i++){
            seriesSum += 1/(Math.pow(2,i-4));
        }
        System.out.println(COLORS.ANSI_GREEN + "Success!" + COLORS.ANSI_RESET);
        return seriesSum;
    }

    private BigDecimal preciseSeriesSum(int n){
        BigDecimal seriesSum = new BigDecimal("0.0");
        for(int i = 0; i <= n; i++){
            seriesSum = seriesSum.add(
                    BigDecimal.valueOf(
                            1/(Math.pow(2,i-4))
                    )
            );
        }
        System.out.println(COLORS.ANSI_GREEN + "Success!" + COLORS.ANSI_RESET);
        return seriesSum;
    }

    public double getResult() {
        System.out.println(COLORS.ANSI_CYAN + "Please, wait, I'm calculating.. " + COLORS.ANSI_RESET);
        if(N < 15) return impreciseSeriesSum(N);
        return preciseSeriesSum(N).doubleValue();
    }
}
