/* Simple String Manipulator
 * This program accepts exactly two string arguments and performs simple manipulations without using loops. 
 * The manipulations involve changing the case of specific characters and concatenating parts of the strings based on certain conditions.
 * 
 * Point for understand commond Function call , String Manipulator and condition
 * 
 * Author : Teethawat Kumying
 * ID : 673040390-0
 * Sec : 1
 * 
 * last update 01:18 26/11/2024
 */

package kumying.teethawat.lab2;

public class SimpleStringManipulator {

    // condition to check vowel
    public static boolean checkvowel(char myChar) {
        //  check a, e, i, o, u
        if (myChar == 'a' || myChar == 'e' || myChar == 'i' || myChar == 'o' || myChar == 'u' ||
        myChar == 'A' || myChar == 'E' || myChar == 'I' || myChar == 'O' || myChar == 'U' ) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // ez way to push error and break (args err)
        if (args.length != 2) {
            System.err.print("Error : Invalid number of arguments. Please provide exactly two arguments.");
            return;
        }

        // input args
        String first = args[0];
        String second = args[1];

        // check string empty or not
        if (first.isEmpty() || second.isEmpty()) {
            System.err.print("Error : String is empty. Each argument should be a string with at least one character.");
            return;
        }

        // modify data
        char front_first = first.charAt(0);
        int second_length = (Integer) (second.length() - 1); // make for ez to accese tp last string
        char last_second = second.charAt(second_length);
        
        // make stroage before into condition
        String first_mod;
        String second_mod;
    
            // if vowel convert the first character to uppercase. Else, convert the first character to lowercase.
        if (checkvowel(front_first)) {
            first_mod = first.substring(0, 1).toUpperCase() + first.substring(1);
        } else {
            first_mod = first.substring(0, 1).toLowerCase() + first.substring(1);
        }
        
            // ends with a consonant convert the last character to uppercase. Else, convert the last character to lowercase.
        if (checkvowel(last_second)) {
            second_mod = second.substring(0, second_length) + second.substring(second_length).toLowerCase();
        } else {
            second_mod = second.substring(0, second_length) + second.substring(second_length).toUpperCase();
        }

        // combine two string
        String Resulting = first_mod + second_mod;

        // output
        System.out.println("First String: " + first);
        System.out.println("Second String: " + second);
        System.out.print("Resulting String: " + Resulting);
    }
}
