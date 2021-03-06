import java.util.Scanner;

/**
 * Runs basic commands
 */
public class Main {
    /**
     * A super-spiffy robot
     */
    public static JFenrir fenrir = new JFenrir();

    /**
     * Runs the commands
     * @param args unused parameter
     */
    public static void main(String args[]) {
        initialize();
        while (true) {
            // resets the board to the screen
            Interperet.reset();
            // moves the best move
            Calculate.move(Calculate.bestMove());
        }
    }

    /**
     * Initializes the game
     */
    public static void initialize() {
        Interperet.corner = fenrir.getCorner();
        Interperet.setFirstPick();
        System.out.println(Interperet.corner);
        for (int i = Calculate.lookAhead - 1; i >= 0; i--) {
            if (i < Calculate.lookAhead - 1 ) {
                Calculate.scenarios[i] = new Grid(Calculate.scenarios[i+1]);
            } else {
                Calculate.scenarios[i] = new Grid(null);
            }
        }
    }

    /**
     * Prints a question and gets user input by using a scanner.
     *
     * @param question Prints the question before opening a scanner
     * @return The scanner
     */
    public static boolean input(String question) {
        System.out.println(question);
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        try {
            return Boolean.parseBoolean(text);
        } catch (NumberFormatException e) {
            System.err.println("Enter a valid boolean");
            return input(question);
        }
    }
}