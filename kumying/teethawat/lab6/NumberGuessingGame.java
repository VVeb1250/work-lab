package kumying.teethawat.lab6;

public class NumberGuessingGame {
    static GuessGame cGame = new GuessGame();
    public static void main(String[] a) {
        int min = cGame.getMin();
        int max = cGame.getMax();
        int MaxTries = cGame.getMaxTries();
        cGame.configureGame(min,max,MaxTries);
        cGame.playSingleGame();
    }
}
