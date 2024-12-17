/**
 * A utility class that provides methods for analyzing arrays of numbers.
 * @author [teethawat kumying]
 * @version 1.0
 */

package kumying.teethawat.lab5;

public class NumberAnalyzer {
	/**
 	* Finds both the minimum and maximum values in an array.
 	* @param numbers the array to analyze
 	* @return an array of two elements where index 0 is minimum and index 1 is maximum
 	*/
	public static int[] findMinMax(int[] numbers) {
    	// set up min_max array
        int[] min_max = new int[2];
    	min_max[0] = numbers[0];
    	min_max[1] = numbers[0];
        
        // find min_max
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < min_max[0]) { // consider min index
                min_max[0] = numbers[i];
            } if (numbers[i] > min_max[1]) { // consider max index
                min_max[1] = numbers[i];
            }
        }
        return min_max; // return if end loop
	}
   
	/**
 	* Calculates the running average of numbers up to each position.
 	* For example: input [1,2,3] returns [1.0, 1.5, 2.0]
 	* @param numbers the input array
 	* @return array of running averages
 	*/
	public static double[] calculateRunningAverages(int[] numbers) {
        // set up sum and avg_arr
        int member = numbers.length;
    	double[] avg_numbers = new double[member];
        int sum_num = 0;

        // do each avg
        for (int i = 0; i < member; i++) {
            sum_num += numbers[i];
            avg_numbers[i] = (double) sum_num / (i+1);
        }
        return avg_numbers;
	}
   
	/**
 	* Checks if the array is sorted in ascending order.
 	* @param numbers the array to check
 	* @return true if sorted, false otherwise
 	*/
	public static boolean isSorted(int[] numbers) {
        int members = numbers.length;
        
        // compare each row
        for (int i = 1; i < members; i++) {
            if (numbers[i-1] > numbers[i]) {
                return false;
            }
        }
        return true;
	}

    // print array in ex line
    public static void print_arr(int[] arr) {
        System.out.print("Testing with array: {");
        for (int i = 0; i < arr.length; i++) {
            if (i < arr.length - 1) {
                System.out.print(arr[i] + ", ");
            } else {
                System.out.println(arr[i] + "}");
            }
        }
    }
    
    // print avg
    public static void print_avg(double[] arr) {
        System.out.println("Running averages:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Position " + i + ": " + arr[i]);
        }
        System.out.println();
    }

    // print array in sorted array
    public static void print_arr(int[] arr, int position) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        boolean sort = isSorted(arr);
        System.out.println("number" + position + " is sorted: " + sort);
    }
    
	public static void main(String[] args) {
    	// Create example arrays and test method implementations
        int[] test_arr = {4, 2, 7, 1, 9};
        print_arr(test_arr);
        int[] min_max = findMinMax(test_arr);
        System.out.println("Minimum value: " + min_max[0]);
        System.out.println("Maximum value: " + min_max[1]);
        System.out.println("");
        double[] avg_arr = calculateRunningAverages(test_arr);
        print_avg(avg_arr);
        System.out.println("Testing if arrays are sorted:");
        print_arr(test_arr, 1);
        int[] test_arr2 = {1, 2, 3, 4, 5};
        print_arr(test_arr2, 2);
    }
}