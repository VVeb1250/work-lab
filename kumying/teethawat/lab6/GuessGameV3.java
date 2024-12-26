/* Number Guessing Method Games V3 (Class for OOP)
 * 
 * inherite from GuessGameV2 for upgrade game
 * 
 * Author : Teethawat Kumying
 * ID : 673040390-0
 * Sec : 1
 * 
 * last update 11:34 26/12/2024
 */

package kumying.teethawat.lab6;

public class GuessGameV3 extends GuessGameV2 {

    // static var
    private static final int MAX_GAMES = 100;  // fix a max games
    private static GuessGameV3[] gameRecords = new GuessGameV3[MAX_GAMES]; // make list game record extend size for prepare in memory
    private static int recordindex = 0;
    // i forgor
    private int[] guesses;
    private int guessCount;
    private boolean win;

    // call obj. in class
    public GuessGameV3() {
        super(); // call constructor from parent
        // addditional var
        this.guessCount = 0;
        this.win = false;
        this.guesses = new int[getMaxTries()];
    }
    public GuessGameV3(int min, int max, int maxTries) {
        super(min, max, maxTries); // call constructor by setting varible
        // addditional var
        this.guessCount = 0;
        this.win = false;
        this.guesses = new int[getMaxTries()];
    }

    // getter
        // ststic cuz GuessGameV3 is the storage of game list
    public static GuessGameV3[] getGameRecord() { return gameRecords; }
    public static int getRecordCount() { return recordindex; }
        // return game log
    public String getGameLog() {

        StringBuffer str = new StringBuffer();
        str.append("Range: [");
        str.append(getMin());
        str.append("-");
        str.append(getMax());
        str.append("], Max Tries: ");
        str.append(getMaxTries());
        str.append(", Attempts: ");
        str.append(guessCount);
        str.append(", Result: ");
        str.append((win ? "Win" : "Lose"));
        str.append(", Guesses: ");
        str.append(getGuesses_list(guesses, guessCount));
        
        return str.toString();
    }

    // override some old class
    @Override
    public void configureGame(int min, int max, int maxTries) {
        // ask and reset game setting
        super.configureGame(min, max, maxTries); // call old method from parent
        // config attbruite
        this.guesses = new int[getMaxTries()];
        this.guessCount = 0;
        this.win = false;
    }

    // modify some game (update gussesCount and list)
    @Override
    public boolean playSingleGame() {

        // make own variable cuz parent have private var, It's can't acceces
        int min = getMin();
        int max = getMax();
        int maxTries = getMaxTries();
        int attempts = 0;

        // add setup
        this.win = false; // suppoes to lose
    
        // other setup
        int answer = getAnswer();

        // output before game start
        System.out.println("Welcome to the Record-Keeping number Guessing Game!");

        // guessing progess
        for (attempts = 1; attempts <= maxTries; attempts++) {
            // output for guessing number
            System.out.print("Enter an integer between " + min + " and " + max + ": ");
            int guess_num = scan.nextInt();  // Read user input

            // check error
            while (guess_num > max || guess_num < min) {
                System.out.println("The number must be between " + min + " and "+ max);
                    // ask number again
                System.out.print("Enter an integer between " + min + " and " + max + ": ");
                guess_num = scan.nextInt();
            }

            guesses[guessCount] = guess_num;
            guessCount += 1;

            // condition
            if (guess_num == answer) {
                // win condition
                System.out.print("Congratulations! ");
                if (attempts == 1) { // one try
                    System.out.println("You've guessed the number in " + attempts + " attempt");
                } else { // many attempts
                    System.out.println("You've guessed the number in " + attempts + " attempts");
                }
                this.win = true; // set boolean win
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
        if (!this.win) {
            System.out.print("Sorry, you've used all your attempts.");  //+ maxTries + " times. You ran out of guesses");
            System.out.println("The correct answer was: " + answer);
        }
        // game end
        return this.win;
    }

    // my additional function
    static String getGuesses_list(int[] list, int count) {
        String res = "";
        for (int i = 0; i < count; i++) {
            res = res + list[i];
            if (i+1 < count) {
                res = res + ", ";
            }
        }
        return res;
    }

    // add function
        // static cuz keep GuessGameV3(attbruite) in list
    public static void addGameRecord(GuessGameV3 game) {
        if (recordindex < MAX_GAMES) {
            // put attbruite in class put into gameRecords
            gameRecords[recordindex] = game;
            recordindex += 1;
        } else {
            System.err.println("MAX_GAMES reached. cannot play more games.");
        }
    }
}
