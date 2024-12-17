/**
 * Class of matrix opreator
 * 
 * point for understand array and function call
 * 
 * @author [teethawat kumying]
 * ID : 673040390-0
 * Sec : 1
 * 
 * @version 1.0
 * 
 * last update 21:43 17/12/2024
 */
package kumying.teethawat.lab5;

import java.util.Scanner;

public class MatrixOperations {
    // original varible
    private static int[][] matrix;
    private static int rows;
    private static int columns;
    private static final Scanner scanner = new Scanner(System.in);
    
    // add for dynamic working
    private static int[][] matrix_temp;
    private static int max_num = Integer.MIN_VALUE; // for fixed bug
    private static int min_num = Integer.MAX_VALUE; // for fixed bug
    private static byte size = 0;

    // add for dynamic and addition working
        // update numbers
        private static void update_min_max(int num) {
            // find longest num in matrix
            if (num > max_num) {
                max_num = num;
            }
            if (num < min_num) {
                min_num = num;
            }
        }
        // update size
        private static void update_size(int max_num, int min_num) {
            // modify data
            String str_max_num = Integer.toString(max_num);
            String str_min_num = Integer.toString(min_num);
            byte size_max = (byte) str_max_num.length();
            byte size_min = (byte) str_min_num.length();
            // update progess
            if (size_max > size_min) {
                size = size_max;
            } else {
                size = size_min;
            }
        }
        // update size
        private static byte update_size(int num) {
            String str_num = Integer.toString(num);
            byte local_size = (byte) str_num.length();
            return local_size;
        }
        //print space
        private static void print_space(int[][] matrix, int i, int j) {
            // update size on each element before print space
            byte my_size = update_size(matrix[i][j]);

            int space_size = size - my_size;
            for (byte space = 0; space < space_size+1; space++) {
                System.out.print(" ");
            }
        }
    
        // add function for easy work
        private static int[][] copy_Matrix(int[][] matrix) {
            int row = matrix.length;
            int col = matrix[0].length;
            int[][] matrix_temp = new int[row][col];
    
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    matrix_temp[i][j] = matrix[i][j];
                }
            }
            return matrix_temp;
        }

        // function for random answer
        private static int random_num() {
            int min = 0;
            int max = 9;
            int random = min + (int)(Math.random() * ((max - min) + 1)); // random a number
            return random;
        }
    
    // original function
        // display create matrix
    public static void displayCreationMenu() {
        System.out.println("Matrix Creation Menu:");
        System.out.println("1. User Input Matrix");
        System.out.println("2. Random Matrix (0-9)");
        System.out.println("3. All Zeros Matrix");
        System.out.println("4. All Ones Matrix");
        System.out.println("5. Diagonal Matrix");
        System.out.print("Enter your choice: ");
    }

        // create matrix in choice
    public static void createMatrix(int choice) {
        switch (choice) {
            case 1:
                    System.out.println("Enter matrix elements:");
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < columns; j++) {
                            int num = scanner.nextInt(); // just scan
                            matrix[i][j] = num;
                            update_min_max(num); // just update min max
                            update_size(max_num,min_num); // just set size for large number
                        }
                    }
                break;
            case 2:
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < columns; j++) {
                        int num =random_num(); // random a number
                        matrix[i][j] = num;
                        update_min_max(num); // just update min max
                        update_size(max_num,min_num); // just set size for large number
                    }
                }
                break;
            case 3:
                update_min_max(0);
                update_size(max_num,min_num);
                break;
            case 4:
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < columns; j++) {
                        matrix[i][j] = 1;
                    }
                }
                update_min_max(1);
                update_size(max_num,min_num);
                break;
            default:
                System.err.println("Skill tissue bruh");
                break;
            }
        }
        
        // matrix mode 5
    public static void createDiagonalMatrix() {
        System.out.println("Enter size of square matrix:");
        int size = scanner.nextInt(); // just scan
        rows = size;
        columns = size;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (i == j) {
                    matrix[i][j] = 1;
                } else {
                    matrix[i][j] = 0;
                }
                update_min_max(0);
                update_min_max(1);
                update_size(max_num, min_num);
            }
        }
    }
    
        // main displays matrix (warning: always remind rows and columns)
    public static void displayMatrix(int[][] matrix) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                print_space(matrix, i, j);
                System.out.print(matrix[i][j]); // matrix each numbers
            }
            System.out.println();
        }
    }
    
        // display start menu
    public static void displayOperationsMenu() {
        System.out.println("\nMatrix Operations Menu:");
        System.out.println("1. Find Transpose of the Matrix");
        System.out.println("2. Calculate Sum of Rows and Columns");
        System.out.println("3. Find Minimum and Maximum Elements");
        System.out.println("4. Display Diagonal Elements");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void transposeMatrix() {
        // set up by copy matrix and reset the original
        matrix_temp = copy_Matrix(matrix);
        int row_temp = matrix.length;
        int col_temp = matrix[0].length;
        matrix = new int[col_temp][row_temp];

        // switch progess
        for (int i = 0; i < col_temp; i++) {
            for (int j = 0; j < row_temp; j++) {
                matrix[i][j] = matrix_temp[j][i];
            }
        }
        rows = col_temp;
        columns = row_temp;
        displayMatrix(matrix);
    }

    public static void calculateSums() {
        // row showup
        System.out.println("Row sums:");
        for (int i = 0; i < rows; i++) {
            int sum = 0;
            for (int j = 0; j < columns; j++) {
                sum += matrix[i][j];
            }
            System.out.println("Row " + (i+1) + " sum: " + sum);
        }
        
        System.out.println();
        
        // column showup
        System.out.println("Column sums:");
        for (int i = 0; i < columns; i++) {
            int sum = 0;
            for (int j = 0; j < rows; j++) {
                sum += matrix[j][i];
            }
            System.out.println("Column " + (i+1) + " sum: " + sum);
        }
    }

    public static void findMinMax() {
        // just print it
        System.out.println("Minimum Elements: " + min_num);
        System.out.println("Maximum Elements: " + max_num);
    }

    public static void displayDiagonal() {
        // return if not squre
        if (rows != columns) {
            System.out.println("Matrix is not square. Cannot display diagonal elements");
            return;
        }
        System.out.println("Diagonal list:");
        // show up Diagonal list (not sure cuz don't have example bruh)
        for (int i = 0; i < rows; i++) {
            System.out.println("Diagonal " + (i+1) + " : " + matrix[i][i]);
        }
    }

    // main function, everything start here
    public static void main(String[] args) {
        boolean continueProgram = true;
        while (continueProgram) {

            // display start menu
            displayCreationMenu();
            int choice = scanner.nextInt();
 
            // select choice
            if (choice >= 1 && choice <= 4) {
                // For options 1-4, get matrix dimensions
                System.out.print("Enter number of rows: ");
                rows = scanner.nextInt();
                System.out.print("Enter number of columns: ");
                columns = scanner.nextInt();
 
                if (rows <= 0 || columns <= 0) {
                    System.out.println("Error: Dimensions must be greater than 0");
                    continue;
                }
 
                matrix = new int[rows][columns];
                createMatrix(choice);

            } else if (choice == 5) {
                // Diagonal matrix must be square
                System.out.print("Enter size of square matrix: ");
                rows = columns = scanner.nextInt();
 
                if (rows <= 0) {
                    System.out.println("Error: Size must be greater than 0");
                    continue;
                }
 
                matrix = new int[rows][rows];
                createDiagonalMatrix();

            } else {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }
 
            // finish create matrix continue operation
            System.out.println("\nCreated Matrix:");
            displayMatrix(matrix);
 
            // Operations menu loop
            boolean continueOperations = true;
            while (continueOperations) {
                displayOperationsMenu();
                int operation = scanner.nextInt();
 
                switch (operation) {
                    case 1:
                        transposeMatrix();
                        break;
                    case 2:
                        calculateSums();
                        break;
                    case 3:
                        findMinMax();
                        break;
                    case 4:
                        displayDiagonal();
                        break;
                    case 5:
                        continueOperations = false;
                        continueProgram = false;
                        break;
                    default:
                        System.out.println("Invalid operation choice.");
                }
            }
        }
        scanner.close();
    }
}
 
