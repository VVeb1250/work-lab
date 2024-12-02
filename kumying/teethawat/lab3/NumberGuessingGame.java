/* Number Guessing Game
 * Write a Java program called NumberGuessingGame that simulates a guessing game of which a user guesses a number from 1 to 10. 
 * The answer is randomly generated then a user enters a number via the console. 
 * Each time a number is entered, one of the following three possible outputs will be displayed. 
	1. “Congratulations!”	if the number entered is the same as the answer.
    2. “Try a lower number!” 	if the number entered is higher than the answer.
    3. “Try a higher number!” 	if the number entered is smaller than the answer.  
 * The game ends when the user guesses the answer correctly or the user guesses the number incorrectly five times. 
 * 
 * Point for understand for loop wan while loop
 * 
 * Author : Teethawat Kumying
 * ID : 673040390-0
 * Sec : 1
 * 
 * last update 15:18 02/12/2024
 */

package kumying.teethawat.lab3;

import java.util.*;

class NumberGuessingGame {

    public static void main(String[] args) {
        // setup before start
        int min_num = 1; // set min before start
        int max_num = 10; // set max before start
        int random = min_num + (int)(Math.random() * ((max_num - min_num) + 1)); // random a number
        Scanner scan = new Scanner(System.in); // create a Scanner object
        boolean lose = true; // boolean lose
        // output before game start
        System.out.println("Welcome to a number guessing game!");

        // guessing progess
        for (int tries = 1; tries <= 5; tries++) {
            // output for guessing number
            System.out.print("Enter an integer between " + min_num + " and " + max_num + ":");
            int guess_num = scan.nextInt();  // Read user input
            // condition
            if (guess_num == random) {
                // win condition
                System.out.println("Congratulations!");
                if (tries == 1) { // one try
                    System.out.println("You have tried " + tries + " time");
                } else { // many tries
                    System.out.println("You have tried " + tries + " times");
                }
                lose = false; // set boolean win
                break;

            } else if (guess_num > random) {
                System.out.println("Try a lower number!");

            } else if (guess_num < random) {
                System.out.println("Try a higher number!");

            } else {
                System.err.println("Error : you should enter Integer");
            }
        }
        // end loop game ended
        if (lose) {
            System.out.println("You have tried 5 times. You ran out of guesses");
            System.out.println("The answer is " + random);
        }
    }
}