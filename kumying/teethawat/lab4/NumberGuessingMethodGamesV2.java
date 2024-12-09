package kumying.teethawat.lab4;

import java.util.Scanner;

public class NumberGuessingMethodGamesV2 {
        
    // make variable for use in class
    static int min_num;
    static int max_num;
    static int max_tries;
    static int answer;
    // create a Scanner object
    static Scanner scan = new Scanner(System.in);
    // makeing list for use
    static int[] guesses_list;

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
        boolean lose = true; // boolean lose
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
        }

    // function for while games and call list of answar
    public static void playGames() {

        boolean play = true;

        do {
            // call loop games and logs
            playGame();
            displayGuessesLoop();

            // ask after play
            System.out.print("Want to play again (Y or y):");
            String want = scan.next();
                // check letters
            if (want.equalsIgnoreCase("Y")) {
                play = true;
            } else {
                play = false;
                // game end
                System.out.println("Thank you for playing our games. Bye!");
            }
        } while (play);

        scan.close(); // just close scan
    }
        
    // main run
    public static void main(String[] args) {
        configure(); // setup game before start
        playGames(); // game start

    }

}
