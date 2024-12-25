/* Number Guessing Method Games
 * 
 * point for understand OOP
 * 
 * Author : Teethawat Kumying
 * ID : 673040390-0
 * Sec : 1
 * 
 * last update 20:34 25/12/2024
 */

package kumying.teethawat.lab6;

import java.util.Scanner;

public class NumberGuessingOOPGameV2 {
    
    public static Scanner input = new Scanner(System.in);

    private GuessGameV2 gameV2;

    public void configure() {
        // scan min
        System.out.print("Enter the min value: ");
        int min = input.nextInt();
        // scan max
        System.out.print("Enter the max value: ");
        int max = input.nextInt();

        // make new obj.
        this.gameV2 = new GuessGameV2(min, max, 1);
        this.gameV2.configureGame(min, max, 1);
        
        // scan maximum tries
        System.out.print("Enter the maximum number of tries:");
        int maxTries = input.nextInt();
        
        this.gameV2.configureGame(min, max, maxTries);

        System.out.println( this.gameV2.toString() );
    }
    
    public void playGames() {
        boolean playAgain = true;
        do {
            boolean result = this.gameV2.playSingleGame();

            System.out.println(result ? "You Win!" : "Better luck next time.");
            // ask after play
            boolean check_yn = true;
            while (check_yn) {
                System.out.print("Want to play again (y/n): ");
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
                    System.err.println("Please type only y and n."); // ask to type again
                }
            }
        } while (playAgain);

        // exit game
        System.out.println("Thank you for playing the Number Guessing Game V2!");
    }

    public static void main(String[] args) {

        NumberGuessingOOPGameV2 program = new NumberGuessingOOPGameV2();

        program.configure();
        program.playGames();
    }
}
