/* Dealer program
 * Description : This program will accept 3 arguments then progess and displays dealer information
 * output should be
 * 
 * Dealer's name: <dealer_name>.
 * Number of clients: <num_clients>
 * Gender: <dealer_gender>
 * 
 * Author : Teethawat Kumying
 * ID : 673040390-0
 * Sec : 1
 * 
 * last update 14:31 25/11/2024
 */

package kumying.teethawat.lab2;

public class Dealer {
    public static void main(String[] args) {
        if (args.length == 3) {
            // Input in arg
            String name = args[0];
            String clients = args[1];
            String gender = args[2];
            
            //output all
            System.out.print("Dealer's name: ");
            System.out.print(name);
            System.out.println(".");

            System.out.print("Number of clients: ");
            System.out.println(clients);

            System.out.print("Gender: ");
            System.out.print(gender);
        } else {
            // error output
            System.err.print("Error : Invalid number of arguments. Please provide exactly three arguments.");
        }
    }
}