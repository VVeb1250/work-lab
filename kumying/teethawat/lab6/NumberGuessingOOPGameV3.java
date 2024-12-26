/* Number Guessing Method Games V3 (Class for OOP)
 * 
 * inherite from GuessGameV2 for upgrade game
 * 
 * Author : Teethawat Kumying
 * ID : 673040390-0
 * Sec : 1
 * 
 * last update 22:38 25/12/2024
 */

package kumying.teethawat.lab6;

import java.util.Scanner;

public class NumberGuessingOOPGameV3 {

    public static Scanner input = new Scanner(System.in);

    private GuessGameV3 gameV3;
    
    // config progess
    public void configure() {
        // scan min
        System.out.print("Enter the min value: ");
        int min = input.nextInt();
        // scan max
        System.out.print("Enter the max value: ");
        int max = input.nextInt();

        this.gameV3 = new GuessGameV3(min, max, 1); // make new obj.
        this.gameV3.configureGame(min, max, 1); // just config

        // scan maximum tries
        System.out.print("Enter the maximum number of tries: ");
        int maxTries = input.nextInt();
        
        this.gameV3.configureGame(min, max, maxTries); // finish config
    }

    public void playGames() {
        boolean playAgain;
        boolean asking;
        do {
            // play game first
            this.gameV3.playSingleGame();
            // update game record
            GuessGameV3.addGameRecord(this.gameV3);
            // ask after play
            do {
                System.out.println("Do you want to:");
                System.out.println("1. Play again");
                System.out.println("2. View game records");
                System.out.println("3. Quit");
                int want = input.nextInt();
                    // check letters
                switch (want) {
                    case 1:
                        configure();
                        playAgain = true;
                        asking = false;
                        break;
                    case 2:
                        viewRecords();
                        asking = true;
                        playAgain = true;
                        break;
                    case 3:
                        playAgain = false;
                        asking = false;
                        break;
                    default:
                        System.err.println("Please type only 1, 2, or 3."); // ask to type again
                        playAgain = true;
                        asking = true;
                }
            } while (asking);
        } while (playAgain);

        // exit game
        System.out.println("Thank you for playing Number Guessing Game V3!");

    }

    // open record menu
    public void viewRecords() {
        System.out.println("View:");
        System.out.println("1. Complete Records");
        System.out.println("2. Specific Game Records");
        int want = input.nextInt();
        switch (want) {
            case 1:
                // all case
                for (int i = 0; i < GuessGameV3.getRecordCount(); i++) {
                    System.out.println("Game " + (i + 1) + ": " + GuessGameV3.getGameRecord()[i].getGameLog());
                }
                break;
            case 2:
                // select log display
                System.out.print("Enter the Game Records: ");
                int line = input.nextInt() - 1;
                    // check if empty
                if (GuessGameV3.getGameRecord()[line] != null) {
                    // line output
                    System.out.println("Game " + (line + 1) + ": " + GuessGameV3.getGameRecord()[line].getGameLog()); 
                } else {
                    System.err.println("Error: Index not found, your order number not found in your list.");
                }
                break;
            default:
                System.err.println("Input Error: please type only number 1 or 2.");
        }
    }

    public static void main(String[] args) {
        NumberGuessingOOPGameV3 program = new NumberGuessingOOPGameV3();
        program.configure();
        program.playGames();
    }
}
