/* Number Guessing Games
 * Write a program called ConfigurableNumberGuessingGame which is an improved version of the previous program NumberGuessingGame. 
 * The answer is randomly generated then a user enters a number via the console. 
 * Each time a number is entered, one of the following three possible outputs will be displayed. 
	1. “Congratulations!”	if the number entered is the same as the answer.
    2. “Try a lower number!” 	if the number entered is higher than the answer.
    3. “Try a higher number!” 	if the number entered is smaller than the answer.  
 * 
 * 1) The program asks the user to enter the min value, the max value, and the maximum number of tries.
 * 2) The program also checks and detects configuration settings that the user may enter as following
 *  2.1) The program checks whether the max value is at least equal to the min value. If not, the program will keep asking for the new max value until the max value is not less than the max value. 
 *  2.2) The program checks whether the number of maximum tries is greater than 0. If not, the program will keep asking for the new maximum tries until the maximum tries is greater than 0. 
 * 3) the program also checks whether a number is outside the minimum or maximum values. If it is, the program asks the user to enter a number again and does not increment the number of tries.
 * 
 * we will write a program called NumberGuessingGames which allows the user to play the number guessing game several times until the user indicates that he/she wants to stop playing the game.
 * Moreover, the answer will be random each time the user chooses to play again. 
 * On the other hand, the program will not ask the user to config (min,max,number of tries) again.
 * 
 * Point for understand for loop wan while loop
 * 
 * Author : Teethawat Kumying
 * ID : 673040390-0
 * Sec : 1
 * 
 * last update 16:40 02/12/2024
 */

package kumying.teethawat.lab3;

import java.util.Scanner;

public class NumberGuessingGames {

    // setup class
    public static void main(String[] args) {
        // create a Scanner object
        Scanner scan = new Scanner(System.in);

        // scan setup progess and setup before start
            // scan min
        System.out.print("Enter the min value:");
        int min_num = scan.nextInt();

            // scan max
        System.out.print("Enter the max value:");
        int max_num = scan.nextInt();
        while (max_num <= min_num) { // while loop for fix error
            System.out.println("The max value must be at least equal to the min value");
            System.out.print("Enter the max value:");
            max_num = scan.nextInt();
        }
            // scan maximum tries
        System.out.print("Enter the maximum number of tries:");
        int max_tries = scan.nextInt();
        while (max_tries <= 0) { // while loop for fix error
            System.out.println("The maximum number of tries must be greater than 0");
            System.out.print("Enter the maximum number of tries:");
            max_num = scan.nextInt();
        }
        
        // add while play setup
        boolean play = true;
        
        while (play) {
            // other setup
            int random = min_num + (int)(Math.random() * ((max_num - min_num) + 1)); // random a number
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
                System.out.println("You have tried " + max_tries + " times. You ran out of guesses");
                System.out.println("The answer is " + random);
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
        scan.close();
    }
}
