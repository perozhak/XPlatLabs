public class Main {

    public static void main(String[] args) {
        Counter counter = new Counter(MyScanner.getN());
        System.out.println(COLORS.ANSI_BLUE + counter.getResult() + COLORS.ANSI_RESET);
    }

}