/* Number Guessing Method Games (Class for OOP)
 * 
 * Copy from Lab4 (Problem 1) for using in lab6
 * 
 * Author : Teethawat Kumying
 * ID : 673040390-0
 * Sec : 1
 * 
 * last update 22:47 21/12/2024
 */

package kumying.teethawat.lab6;

import java.util.*;

public class GuessGame {

    // make variable for use in class and set default constructor
    private int min = 1;
    private int max = 100;
    private int maxTries = 10;
    private int answer = 0;
    private int attempts = 0;

    // create a Scanner object
    static Scanner scan = new Scanner(System.in);

    // Original : class call main game
    public GuessGame() {
        
        boolean play = true; // for check game that really want to play
        do {
            // call loop games and logs
            configureGame(min, max, maxTries); // setup game before start
            
            boolean win = playSingleGame();
            if (win) {
                System.out.println("You win!");
            } else {
                System.out.println("Better luck next time.");
            }
            boolean check_yn = true;

            // ask after play
            while (check_yn) {
                System.out.print("Want to play again (y/n):");
                String want = scan.next();
                    // check letters
                if (want.equalsIgnoreCase("Y")) {
                    play = true;
                    break;
                } else if (want.equalsIgnoreCase("N")){
                    play = false;
                    break;
                } else {
                    System.out.println("Please type only y and n."); // ask to type again
                }
            }

        } while (play);
        // game end
        System.out.println("Thank you for playing the Number Guessing Game!");
    }

    // class call main game (same with upper)
    public GuessGame(int min, int max, int maxTries) {
        setMin(min);
        setMax(max);
        setMaxTries(maxTries);
        playSingleGame();
        
        // boolean play = true; // for check game that really want to play
        // do {
        //     // call loop games and logs
        //     // configureGame(min, max, maxTries); // no need config (i guessed)
        //     playSingleGame();
        //     boolean check_yn = true;

        //     // ask after play
        //     while (check_yn) {
        //         System.out.print("Want to play again (y/n):");
        //         String want = scan.next();
        //             // check letters
        //         if (want.equalsIgnoreCase("Y")) {
        //             play = true;
        //             break;
        //         } else if (want.equalsIgnoreCase("N")){
        //             play = false;
        //             break;
        //         } else {
        //             System.out.println("Please type only y and n."); // ask to type again
        //         }
        //     }

        // } while (play);
        // // game end
        // System.out.println("Thank you for playing the Number Guessing Game!");
    }

    // Getter
    public int getMin() {
        return min;
    }
    public int getMax() {
        return max;
    }
    public int getMaxTries() {
        return maxTries;
    }

    // Setter
    public void setMin(int min) {
        this.min = min;
    }
    public void setMax(int max) {
        this.max = max;
    }
    public void setMaxTries(int maxTries) {
        this.maxTries = maxTries;
    }

    // function for setup gameplay
    public void configureGame(int min, int max, int maxTries) {
        // scan setup progess and setup before start
            // scan min
        System.out.print("Enter the min value:");
        min = scan.nextInt();

            // scan max
        System.out.print("Enter the max value:");
        max = scan.nextInt();
        while (max <= min) { // while loop for fix error
            System.out.println("The max value must be at least equal to the min value");
            System.out.print("Enter the max value:");
            max = scan.nextInt();
        }
            // scan maximum tries
        System.out.print("Enter the maximum number of tries:");
        maxTries = scan.nextInt();
        while (maxTries <= 0) { // while loop for fix error
            System.out.println("The maximum number of tries must be greater than 0");
            System.out.print("Enter the maximum number of tries:");
            maxTries = scan.nextInt();
        }
        setMin(min);
        setMax(max);
        setMaxTries(maxTries);
    }

    // function for random answer
    public void generateAnswer() {
        answer = min + (int)(Math.random() * ((max - min) + 1)); // random a number
    }

    // function call game
    public boolean playSingleGame() {
        // add setup
        boolean win = false; // suppoes to lose
    
        // other setup
        generateAnswer();

        // output before game start
        System.out.println("Welcome to a number guessing game!");

        // guessing progess
        for (attempts = 1; attempts <= maxTries; attempts++) {
            // output for guessing number
            System.out.print("Enter an integer between " + min + " and " + max + ":");
            int guess_num = scan.nextInt();  // Read user input

            // check error
            while (guess_num > max || guess_num < min) {
                System.out.println("The number must be between " + min + " and "+ max);
                    // ask number again
                System.out.print("Enter an integer between " + min + " and " + max + ":");
                guess_num = scan.nextInt();
            }

            // condition
            if (guess_num == answer) {
                // win condition
                System.out.print("Congratulations! ");
                if (attempts == 1) { // one try
                    System.out.println("You've guessed the number in " + attempts + " attempt");
                } else { // many attempts
                    System.out.println("You've guessed the number in " + attempts + " attempts");
                }
                win = true; // set boolean win
                break;

            } else if (guess_num > answer) {
                System.out.println("Try a lower number!");

            } else if (guess_num < answer) {
                System.out.println("Try a higher number!");
                    
            } else {
                System.err.println("Error : you should enter Integer");
            }
        }
        // lose condition
        if (!win) {
            System.out.print("Sorry, you've used all your attempts.");  //+ maxTries + " times. You ran out of guesses");
            System.out.println("The correct answer was: " + answer);
        }
        // game end
        return win;
    }

    // // main run
    // public void main(String[] args) {
    //     configureGame(min, max, maxTries); // setup game before start
    //     playSingleGame();
    // }
}