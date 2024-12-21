import java.util.Scanner;

public class AddTwoMatrices {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter number of rows in matrix: ");
		int rows = input.nextInt();
		System.out.println("Enter number of columns in matrix: ");
		int columns = input.nextInt();
		int[][] matrix1 = new int[rows][columns];
		int[][] matrix2 = new int[rows][columns];
		
		System.out.println("Enter elements in first matrix: ");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				matrix1[i][j] = input.nextInt();
			}
		}
		
		System.out.println("Enter elements in second matrix: ");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				matrix2[i][j] = input.nextInt();
			}
		}
		
		int[][] resultMatrix = new int[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				resultMatrix[i][j] = matrix1[i][j] +matrix2[i][j];
			}
		}
		
		System.out.println("\nFirst matrix: ");
		for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                  System.out.print(matrix1[i][j] + " ");
            }
            System.out.println();
		}
		
		System.out.println("\nSecond matrix: ");
		for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                  System.out.print(matrix2[i][j] + " ");
            }
            System.out.println();
		}
		
		System.out.println("\nThe sum of the two matrices is : ");
		for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                  System.out.print(resultMatrix[i][j] + " ");
            }
            System.out.println();
		}
		
		input.close();
        
	    }
}


