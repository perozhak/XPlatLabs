import java.util.Scanner;

public class MyScanner {

    public static int getN() {
        Scanner userInput = new Scanner(System.in);
        int N = 0;
        while (true) {
            System.out.print(COLORS.ANSI_PURPLE +  "Enter the N: " + COLORS.ANSI_RESET);
            if (userInput.hasNextInt()) {
                N = userInput.nextInt();
                if (N > 0) break;
                System.out.println(COLORS.ANSI_YELLOW + "The N that you enter is too low, try N>0 ;)" + COLORS.ANSI_RESET);
            } else {
                userInput.next();
                System.out.println(COLORS.ANSI_RED + "The N that you enter is not Integer :(  , try again" + COLORS.ANSI_RESET);
            }
        }
        userInput.close();
        return N;
    }
}
