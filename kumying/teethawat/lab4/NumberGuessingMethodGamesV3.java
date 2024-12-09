/* Number Guessing Method Games V3
 * Develop a Java program called NumberGuessingMethodGamesV3, 
 * an advanced version of NumberGuessingMethodGamesV2 with additional functionalities and statistical tracking. 
 * This program will reinforce concepts of loops, conditionals, arrays, and basic statistics in Java.
 * 
 * New Feature: Game log for each game
 * The program outputs the game log: answer, number of guesses, win/loss status with the format
 *  Game log: Answer: <answer>, Guesses: <numTries>, Win: <The result whether the user wins>
 *      Replay Option (Modified from NumberGuessingMethodGamesV2):
 *      The program asks if the user wants to play again.
 *      On 'Y' or 'y', restart with the same min/max range but a new number.
 *  New Feature - Statistical Information:
 *      Upon exit, display statistics: total games, wins, win ratio, average number of guesses per game, high score (the least number of guesses) with the format
 *          ===== All Games Stats =====
 *          Total games played: <number of games>
 *          Total games win: <number of winning games>
 *          Win ratio: <number of winning games/ number of games>*100.00 %
 *          Average number of guesses per game: <total guesses/ number of games>
 *          High score (the lowest number of guesses): <the lowest number of guesses in winning games>
 * 
 * Point for understand function call and do while and class varible
 * 
 * Author : Teethawat Kumying
 * ID : 673040390-0
 * Sec : 1
 * 
 * last update 14:04 09/12/2024
 */


package kumying.teethawat.lab4;

import java.util.*;

public class NumberGuessingMethodGamesV3 {
    
    // make variable for use in class
    static int min_num;
    static int max_num;
    static int max_tries;
    static int answer;
    static int total_plays;
    static int total_wins;
    static int total_guesses;
    static int highscore = 0;
    static boolean win;
    // create a Scanner object
    static Scanner scan = new Scanner(System.in);
    // makeing list for use
    static int[] guesses_list; // guesses_list[0] = how list long , guesses_list[1-n] = member

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

    // log display
    public static void displayGuesses(int mode) {
        switch (mode) {
            case 0:
                // loop log display
                for (int line = 1; line <= guesses_list[0]; line++) {
                    System.out.print("Guess " + (line) + ": ");
                    System.out.println(guesses_list[line]);
                }
                break;
            case 1:
                // select log display
                System.out.print("Enter the guess number:");
                int line = scan.nextInt();
                    // just check if error
                if (line <= guesses_list[0]) {
                    // line output
                    System.out.print("Guess " + (line) + ": ");
                    System.out.println(guesses_list[line]);
                } else {
                    System.err.println("Error: Index out of renge, your order number not found in your list.");
                }
                break;
            default:
                System.out.println("something error cause skill issue");
                break;
        }
    }

    // while ask log
    public static void displayGuessesLoop() {
        
        boolean display = true;

        do {
            // ask for display log
            System.out.print("Enter 'a' to list all guesses, 'g' for a specific guesse, or any other key to quit:");
            String want = scan.next();
                // display check
            if (want.equalsIgnoreCase("A")) {
                display = true;
                displayGuesses(0); // A mode (list of all guesses)
            } else if (want.equalsIgnoreCase("G")) {
                display = true;
                displayGuesses(1); // G mode (allows the player to choose and view a specific)
            } else {
                display = false;
            }
        } while (display);
    }

    // update overall status
    public static void updateLog() {
        // update total_guesses
        total_guesses += guesses_list[0];
        // update highscore
        if (highscore == 0 || highscore > guesses_list[0]) {
            highscore = guesses_list[0];
        }
        // update win total
        if (win) {
            total_wins++;
        }
    }

    // game log
    public static void displayGameLog() {
        // output for game log
        System.out.print("Game log:");
        System.out.print("Answer: ");
        System.out.print(answer);
        System.out.print(", Guesses: ");
        System.out.print(guesses_list[0]);
        System.out.print(", Win: ");
        System.out.println(win);
    }

    // game log after game stop
    public static void displayAllGamesStats() {
        // all output
        System.out.println("===== All Games Stats =====");
        System.out.print("Total games played: ");
        System.out.println(total_plays);
        System.out.print("Total games win: ");
        System.out.println(total_wins);
        System.out.print("Win ratio: ");
        System.out.println( ((float) total_wins/total_plays*100) + "%");
        System.out.print("Average number of guesses per game: ");
        System.out.println((int) total_guesses/total_plays);
        System.out.print("High score (the lowest number of guesses): ");
        System.out.println(highscore);
    }
    
    // function for random answer
    public static void genAnswer() {
        answer = min_num + (int)(Math.random() * ((max_num - min_num) + 1)); // random a number
    }
    
    // just update log
    public static void appendList(int tries, int guesse) {
        guesses_list[0] = tries; // set number of member of log have
        guesses_list[(tries)] = guesse; // members
    }

    // function call game
    public static void playGame() {
        // other setup
        genAnswer();
        win = false; // suppose to lose first
        guesses_list = new int[max_tries + 1]; // reset guesses list
        
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

            // add to log before consider
            appendList(tries, guess_num);

            // condition
            if (guess_num == answer) {
                // win condition
                win = true;
                System.out.println("Congratulations!");
                if (tries == 1) { // one try
                    System.out.println("You have tried " + tries + " time");
                } else { // many tries
                    System.out.println("You have tried " + tries + " times");
                }
                win = true; // set boolean to get win
                break;
                
            } else if (guess_num > answer) {
                System.out.println("Try a lower number!");
                
            } else if (guess_num < answer) {
                System.out.println("Try a higher number!");
                
            } else {
                System.err.println("Error : you should enter Integer");
            }
        }
        // game ended and go to lose condition
        if (!win) {
            System.out.println("You have tried " + max_tries + " times. You ran out of guesses");
            System.out.println("The answer is " + answer);
        }
    }

    // function for while games and call list of answar
    public static void playGames() {

        boolean play = true; // for check game that really want to play

        // reset overall game log
        total_plays = 0;
        total_wins = 0;
        total_guesses = 0;

        do {
            // call loop games and logs
            playGame();
            total_plays++; // add plays after each game end
            displayGuessesLoop();
            displayGameLog();
            updateLog();

            // ask after play
            System.out.print("Want to play again (Y or y):");
            String want = scan.next();
                // check letters
            if (want.equalsIgnoreCase("Y")) {
                play = true;
            } else {
                play = false;
            }
        } while (play);
        // game end
        System.out.println("Thank you for playing our games. Bye!");
            // display all log after game end
        displayAllGamesStats();
        scan.close(); // just close scan
    }
        
    // main run
    public static void main(String[] args) {
        configure(); // setup game before start
        playGames();

    }
}
