/* Rock Paper Scissor
 * This program simulates a simple Rock-Paper-Scissors game between two players. 
 * The program should accept two arguments, each representing the choice of a player. 
 * The valid choices are 'rock', 'paper', and 'scissors'.
 * 
 * Point for understand commond Function call and condition
 * 
 * Author : Teethawat Kumying
 * ID : 673040390-0
 * Sec : 1
 * 
 * last update 22:59 25/11/2024
 */

package kumying.teethawat.lab2;

public class RockPaperScissors {

    // Use enum follow assignment
    public enum Choice {
        ROCK, PAPER, SCISSORS;
    }

    // make condition for winner
    public static String findwinner(Choice player1Choice, Choice player2Choice) {
        // tie condition
        if (player1Choice == player2Choice) {
            return "It's a tie!";
        }
        
        // rock -> scissor , paper -> rock , scissor -> paper
        switch (player1Choice) {
            case ROCK:
                if (player2Choice == Choice.SCISSORS) {
                    return "Player 1 wins!";
                } else {
                    return "Player 2 wins!";
                }
            case PAPER:
                if (player2Choice == Choice.ROCK) {
                    return "Player 1 wins!";
                } else {
                    return "Player 2 wins!";
                }
            case SCISSORS:
                if (player2Choice == Choice.PAPER) {
                    return "Player 1 wins!";
                } else {
                    return "Player 2 wins!";
                }        
            default:
                return "Why Error!!!?? Should Not Have Error 100% Bro";
        }
    }

    public static void main(String[] args) {
        // check args
        if (args.length == 2) {
            // input
            String player1 = args[0].toLowerCase();
            String player2 = args[1].toLowerCase();

            // make enum variable
            Choice player1Choice;
            Choice player2Choice;

            // set and check choices
            try {
                player1Choice = Choice.valueOf(player1.toUpperCase());
                player2Choice = Choice.valueOf(player2.toUpperCase());
            } catch (IllegalArgumentException e) {
                // error choice output
                System.err.print("Error : Invalid choice(s). Valid choices are 'rock', 'paper', or 'scissors'");
                return; // break if Invalid choice(s)
            }

            // output choice
            System.out.print("Player 1 chooses: ");
            System.out.println(player1);
            System.out.print("Player 2 chooses: ");
            System.out.println(player2);

            //call function and output winner
            String winner = findwinner(player1Choice, player2Choice);
            System.out.println(winner);
            
        } else {
            // error arguments output
            System.err.print("Error : Invalid number of arguments. Please provide exactly two arguments.");
        }
    }
}
