/* Number Guessing Method Games V2 (Class for OOP)
 * 
 * inherite from GuessGame for upgrade game
 * 
 * Author : Teethawat Kumying
 * ID : 673040390-0
 * Sec : 1
 * 
 * last update 20:32 25/12/2024
 */

package kumying.teethawat.lab6;

// inherite from GuessGame
public class GuessGameV2 extends GuessGame {

    // call obj. in class
    public GuessGameV2() {
        super(); // call constructor from parent
    }
    public GuessGameV2(int min, int max, int maxTries) {
        super(min, max, maxTries); // call constructor by setting varible
    }

    // override for update more functional
    @Override
    public void configureGame(int min, int max, int maxTries) {
        
        // fix error min-max
        while (min > max) {
            System.err.println("Invalid input: max must be greater than or equal to min.");
            System.out.print("Enter the min value: ");
            min = scan.nextInt();
            System.out.print("Enter the max value: ");
            max = scan.nextInt();
        }
        // fix error maxTries
        while (maxTries <= 0) {
            System.err.println("Invalid input: maxTries must be greater than 0.");
            System.out.print("Enter the maximum number of tries: ");
            maxTries = scan.nextInt();
        }
        
        // update varible
        setMin(min);
        setMax(max);
        setMaxTries(maxTries);
    }

    // also update game play
    @Override 
    public boolean playSingleGame() {

        // // make own variable cuz parent have private var, It's can't acceces
        int min = getMin();
        int max = getMax();
        int maxTries = getMaxTries();
        int attempts = getAttempts();

        // add setup
        boolean win = false; // suppoes to lose
    
        // other setup
        int answer = getAnswer();

        // output before game start
        System.out.println("Welcome to the Number Guessing Game V2!");

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

    // to string method
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Game Configuration: [Min: " + getMin() + ", Max: " + getMax() + ", Max Tries: " + getMaxTries() + ", Attempts: " + getAttempts() + "]";
    }
}
