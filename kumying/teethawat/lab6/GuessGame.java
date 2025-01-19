/* Number Guessing Method Games (Class for OOP)
 * 
 * Copy from Lab4 (Problem 1) for using in lab6
 * 
 * Author : Teethawat Kumying
 * ID : 673040390-0
 * Sec : 1
 * 
 * last update 19:58 25/12/2024
 */

package kumying.teethawat.lab6;

import java.util.*;

public class GuessGame {

    // make variable for use in class
    private int min;
    private int max;
    private int maxTries;
    private int answer;
    private int attempts;

    // create a Scanner object
    static Scanner scan = new Scanner(System.in);

    // Constructor : class main game
    public GuessGame() {
        // set default constructor
        this.min = 1;
        this.max = 100;
        this.maxTries = 10;
        this.answer = 0;
        this.attempts = 0;
    }

    // Constructor set min max and maxTries
    public GuessGame(int min, int max, int maxTries) {
        this.min = min;
        this.max = max;
        this.maxTries = maxTries;
        this.answer = 0;
        this.attempts = 0;
    }

    // Getter
    public int getMin() { return min; }
    public int getMax() { return max; }
    public int getMaxTries() { return maxTries; }
    public int getAnswer() { generateAnswer(); return answer; }  // adding for access answer
    public int getAttempts() { return attempts; }  // adding for access answer

    // Setter
    public void setMin(int min) { this.min = min; }
    public void setMax(int max) { this.max = max; }
    public void setMaxTries(int maxTries) { this.maxTries = maxTries; }
    public void setAnswer(int answer) { this.answer = answer; }
    public void setAttempts(int attempts) { this.attempts = attempts; }

    // function for setup gameplay
    public void configureGame(int min, int max, int maxTries) {
        // set varible
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
        System.out.println("Welcome to the Number Guessing Game!");

        // guessing progess
        for (attempts = 1; attempts <= maxTries; attempts++) {
            // output for guessing number
            System.out.print("Enter an integer between " + min + " and " + max + ": ");
            int guess_num = scan.nextInt();  // Read user input

            // check error
            while (guess_num > max || guess_num < min) {
                System.err.println("Invalid input: guess must be between " + min + " and "+ max);
                    // ask number again
                System.out.print("Enter an integer between " + min + " and " + max + ": ");
                guess_num = scan.nextInt();
            }

            // condition
            if (guess_num == answer) {
                // win condition
                System.out.print("Congratulations! ");
                if (attempts == 1) { // one try
                    System.out.println("You've guessed the number in " + attempts + " attempt.");
                } else { // many attempts
                    System.out.println("You've guessed the number in " + attempts + " attempts.");
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
            System.out.print("Sorry, you've used all your attempts. ");  //+ maxTries + " times. You ran out of guesses");
            System.out.println("The correct answer was: " + answer);
        }
        // game end
        return win;
    }
}