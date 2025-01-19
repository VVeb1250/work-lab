/* Number Guessing Method Games
 * 
 * point for understand OOP
 * 
 * Author : Teethawat Kumying
 * ID : 673040390-0
 * Sec : 1
 * 
 * last update 20:05 25/12/2024
 */

package kumying.teethawat.lab6;

import java.util.Scanner;

public class NumberGuessingOOPGame {

    public static Scanner input = new Scanner(System.in);

    private GuessGame game;

    public void configure() {
    // scan setup progess and setup before start
        // scan min
        System.out.print("Enter the min value: ");
        int min = input.nextInt();
    
        // scan max
        System.out.print("Enter the max value: ");
        int max = input.nextInt();

        // scan maximum tries
        System.out.print("Enter the maximum number of tries: ");
        int maxTries = input.nextInt();

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
                System.out.print("Do you want to play again (y/n): ");
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
                    playAgain = false; // no need ask to type again
                    break;
                    // System.err.println("Please type only y and n."); // ask to type again
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
