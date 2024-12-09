/* Number Guessing Method Games
 * Write a Java program called NumberGuessingMethodGames. The program defines at least two subroutines, namely configure(), genAnswer(), and playGame()
 * 
 * The program also contains a static int variable answer which contains the answer number of the game.
 * 
 * Point for understand function call and do while and class varible
 * 
 * Author : Teethawat Kumying
 * ID : 673040390-0
 * Sec : 1
 * 
 * last update 03:54 09/12/2024
 */

package kumying.teethawat.lab4;

import java.util.*;

public class NumberGuessingMethodGames {

    // make variable for use in class
    static int min_num;
    static int max_num;
    static int max_tries;
    static int answer;
    // create a Scanner object
    static Scanner scan = new Scanner(System.in);

    // function for setup gameplay
    public static void configure() {
        // scan setup progess and setup before start
            // scan min
        System.out.print("Enter the min value:");
        min_num = scan.nextInt();

            // scan max
        System.out.print("Enter the max value:");
        max_num = scan.nextInt();
        while (max_num <= min_num) { // while loop for fix error
            System.out.println("The max value must be at least equal to the min value");
            System.out.print("Enter the max value:");
            max_num = scan.nextInt();
        }
            // scan maximum tries
        System.out.print("Enter the maximum number of tries:");
        max_tries = scan.nextInt();
        while (max_tries <= 0) { // while loop for fix error
            System.out.println("The maximum number of tries must be greater than 0");
            System.out.print("Enter the maximum number of tries:");
            max_num = scan.nextInt();
        }
    }

    // function for random answer
    public static void genAnswer() {
        answer = min_num + (int)(Math.random() * ((max_num - min_num) + 1)); // random a number
    }

    // function call game
    public static void playGame() {
        // add while play setup
        boolean play = true;
        
        while (play) {
            // other setup
            genAnswer();
            boolean lose = true; // boolean lose

            // output before game start
            System.out.println("Welcome to a number guessing game!");

            // guessing progess
            for (int tries = 1; tries <= max_tries; tries++) {
                // output for guessing number
                System.out.print("Enter an integer between " + min_num + " and " + max_num + ":");
                int guess_num = scan.nextInt();  // Read user input

                // check error
                while (guess_num > max_num || guess_num < min_num) {
                    System.out.println("The number must be between " + min_num + " and "+ max_num);
                        // ask number again
                    System.out.print("Enter an integer between " + min_num + " and " + max_num + ":");
                    guess_num = scan.nextInt();
                }

                // condition
                if (guess_num == answer) {
                    // win condition
                    System.out.println("Congratulations!");
                    if (tries == 1) { // one try
                        System.out.println("You have tried " + tries + " time");
                    } else { // many tries
                        System.out.println("You have tried " + tries + " times");
                    }
                    lose = false; // set boolean win
                    break;

                } else if (guess_num > answer) {
                    System.out.println("Try a lower number!");

                } else if (guess_num < answer) {
                    System.out.println("Try a higher number!");
                    
                } else {
                    System.err.println("Error : you should enter Integer");
                }
            }
            // game ended
            if (lose) {
                System.out.println("You have tried " + max_tries + " times. You ran out of guesses");
                System.out.println("The answer is " + answer);
            }

            // ask after play
            System.out.print("Want to play again (Y or y):");
            String want = scan.next();
                // check letters
            if (want.equalsIgnoreCase("Y")) {
                play = true;
            } else {
                play = false;
            }
        }

        // game end
        System.out.println("Thank you for playing our games. Bye!");
        scan.close(); // close scan
    }

    // main run
    public static void main(String[] args) {
        configure(); // setup game before start
        playGame();

    }
}


