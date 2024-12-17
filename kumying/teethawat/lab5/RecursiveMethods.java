/**
 * RecursiveMethods
 * Implement methods in program RecursiveMethods that implements various recursive methods for array and number operations.
 * 
 * Point for understand RecursiveMethods
 * 
 * Author : Teethawat Kumying
 * ID : 673040390-0
 * Sec : 1
 * 
 * last update 14:26 16/12/2024
 */

package kumying.teethawat.lab5;

public class RecursiveMethods {
    /**
 	* Recursively finds the sum of digits in a number.
 	* Example: For the number 123, the answer is 1+2+3 = 6
 	* @param number the input number
 	* @return sum of digits
 	*/
	public static int sumOfDigits(int number) {
		// if number_red out of number
		if (number == 0) {
			return 0;
		}
		// use number and reduce number
    	int number_use = number % 10;
        int number_red = number / 10;

        return number_use + sumOfDigits(number_red);
	}
   
	/**
 	* Recursively reverses an array between start and end indices.
 	* @param arr the array to reverse
 	* @param start starting index
 	* @param end ending index
 	*/
	public static int[] reverseArray(int[] arr, int start, int end) {
		// return if two pointer are same or swich complete
    	if (start >= end) {
			return arr;
		}
		// modify progess
			// two pointer collect
		int num_start = arr[start];
		int num_end = arr[end];
			// switch
		arr[start] = num_end;
		arr[end] = num_start;

		return reverseArray(arr, start+1, end-1); // continue do and move two pointer

	}
   
	/**
 	* Recursively checks if an array is palindrome.
 	* @param arr the array to check
 	* @param start starting index
 	* @param end ending index
 	* @return true if palindrome, false otherwise
 	*/
	public static boolean isPalindrome(int[] arr, int start, int end) {
		// all true (two pointer are same or near)
		if (start >= end ) {
			return true;
		}
		// consider progess	
			// two pointer collect
		int num_start = arr[start];
		int num_end = arr[end];
		// if true
		if (num_start == num_end) {
			return isPalindrome(arr, start+1, end-1); // continue consider
		} else {
			return false;
		}
	}

	// just function for print out
		// just print list
		public static void print_list(int[] arr) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println("");
		}

		public static void print_sumOfDigits(int num) {
			System.out.print("Sum of digit in ");
			System.out.print(num + ":");
			System.out.println(sumOfDigits(num));
		}

		public static void print_reverseArray(int[] arr) {
			System.out.println("Original array:");
			print_list(arr);
			System.out.println("Reversed array:");
			print_list(reverseArray(arr, 0, arr.length-1));
		}
		
		public static void print_isPalindrome(int[] arr) {
			System.out.println("Testing palindrome:");
			print_list(arr);
			System.out.print("Is palindrome: ");
			System.out.println(isPalindrome(arr, 0, arr.length-1));
		}

	public static void main(String[] args) {
    	// Demonstrate each recursive method with example inputs
			// number for example
		int num1 = 45;
		int num2 = 12345;
		print_sumOfDigits(num1);
		print_sumOfDigits(num2);
		System.out.println("");
		int[] listnum1 = {1,2,3,4,5};
		print_reverseArray(listnum1);
		System.out.println("");
		int[] listnum2 = {1,2,3,2,1};
		int[] listnum3 = {1,2,1,2};
		print_isPalindrome(listnum2);
		System.out.println("");
		print_isPalindrome(listnum3);
	}

}
