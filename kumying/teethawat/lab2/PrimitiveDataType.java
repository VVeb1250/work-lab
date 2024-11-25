/* Variable Declarations and Assignments:
 - Student Information Variables:
 String studentNumber: Assign this variable to your student ID as a string (e.g., "987654321-0").
 String firstName: Assign this variable to your first name (e.g., "Pattarawit").
 - Primitive Data Type Variables:
 byte myByte: Declare a byte variable and assign it the value of the number of letters in your first name.
 short myShort: Declare a short variable and assign it the value of your myByte variable multiplied by 21.
 int myInt: Declare an int variable and assign it the value of the middle six digits of your student ID.
 long myLong: Declare a long variable and assign it the value of your student ID without any dashes or spaces.
 float myFloat: Declare a float variable and assign it the value of 0.xx, where xx is your myByte variable (e.g., 0.10 if myByte is 10).
 double myDouble: Declare a double variable and assign it the value of 0.yyyy, where yyyy are the last four digits of your student ID.
 char myChar: Declare a char variable and assign it the first letter of your first name.
 boolean myBoolean: Declare a boolean variable and assign it true if the last digit of your student ID is odd, and false if it is even.
 * 
 * Author : Teethawat Kumying
 * ID : 673040390-0
 * Sec : 1
 * 
 * last update 21:51 25/11/2024
 */

package kumying.teethawat.lab2;

import java.text.DecimalFormat;

public class PrimitiveDataType {
    public static void main(String[] args) {
        // original
        String studentNumber = "673040390-0"; // studentNumber
        String firstName = "Teethawat"; // firstName

        // modify progess
        byte myByte = (byte) firstName.length(); // byte (length firstName)
        short myShort = (short) (myByte * 21); // short (myByte * 21)
            // delete - in studentnum
        String clear_studentNumber = studentNumber.replaceAll("[-]", "");
        int myInt = Integer.parseInt(clear_studentNumber.substring(clear_studentNumber.length() - 6)); // int (last 6 studentNumber)
        long myLong = Long.parseLong(clear_studentNumber); // long (full studentnumber)
        
        float myFloat = (float) (myByte / 100f); // float (myByte * 100)
            // last 4 studentNumber
        double last4_studentNumber = Double.parseDouble(clear_studentNumber.substring(clear_studentNumber.length() - 4));
        double myDouble = last4_studentNumber / 10000; // double (last 4 studentNumber / 10000)
        
        char myChar = firstName.charAt(0); // char (last studentNumber)
            // last_studentNumber
        int last_studentNumber = studentNumber.charAt(clear_studentNumber.length() - 1);
        boolean myBoolean = (last_studentNumber % 2 != 1); // boolean ()

            // make format
        DecimalFormat df = new DecimalFormat("0.0000");

        // all of output
        System.out.print("Student ID : ");
        System.out.println(studentNumber);
        System.out.print("First Name : ");
        System.out.println(firstName);
        System.out.print("Byte Value: ");
        System.out.println(myByte);
        System.out.print("Short Value: ");
        System.out.println(myShort);
        System.out.print("Int Value: ");
        System.out.println(myInt);
        System.out.print("Long Value: ");
        System.out.println(myLong);
        System.out.print("Float Value: ");
        System.out.println(myFloat);
        System.out.print("Double Value: ");
        System.out.println(df.format(myDouble)); // use format
        System.out.print("Char Value: ");
        System.out.println(myChar);
        System.out.print("Boolean Value: ");
        System.out.println(myBoolean);
    }
}
