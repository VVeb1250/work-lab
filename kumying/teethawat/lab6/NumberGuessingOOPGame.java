package kumying.teethawat.lab6;

import java.util.Scanner;

public class NumberGuessingOOPGame {

    public static Scanner input = new Scanner(System.in);

    private GuessGame game;

    public void configure() {
    // scan setup progess and setup before start
        // scan min
        System.out.print("Enter the min value:");
        int min = input.nextInt();
    
            // scan max
        System.out.print("Enter the max value:");
        int max = input.nextInt();
        while (max <= min) { // while loop for fix error
            System.out.println("The max value must be at least equal to the min value");
            System.out.print("Enter the max value:");
            max = input.nextInt();
        }
            // scan maximum tries
        System.out.print("Enter the maximum number of tries:");
        int maxTries = input.nextInt();
        while (maxTries <= 0) { // while loop for fix error
            System.out.println("The maximum number of tries must be greater than 0");
            System.out.print("Enter the maximum number of tries:");
            maxTries = input.nextInt();
        }

        this.game = new GuessGame(min, max, maxTries);
    }

    public void playGames() {
        boolean playAgain = true;
        do {
            boolean result = this.game.playSingleGame();
            System.out.println(result ? "You Win!" : "Better luck next time.");
            // ask after play
            boolean check_yn = true;
            while (check_yn) {
                System.out.print("Want to play again (y/n):");
                String want = input.next();
                    // check letters
                if (want.equalsIgnoreCase("Y")) {
                    playAgain = true;
                    configure();
                    break;
                } else if (want.equalsIgnoreCase("N")){
                    playAgain = false;
                    break;
                } else {
                    System.out.println("Please type only y and n."); // ask to type again
                }
            }
        } while (playAgain);
        // exit game
        System.out.println("Thank you for playing the Number Guessing Game!");
    }

    public static void main(String[] args) {
        NumberGuessingOOPGame program = new NumberGuessingOOPGame();
        program.configure();
        program.playGames();
    }
}
