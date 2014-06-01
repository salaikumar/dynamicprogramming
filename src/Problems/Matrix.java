/*
 * A simple class used to hold Matrix
 */

package Problems;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Matrix {

	private int rows;
	private int columns;

	private int[][] twoDMatrix;

	/*
	 * Get the matrix size and initialize
	 */
	public Matrix(int rows, int columns) {

		this.rows = rows;
		this.columns = columns;

		twoDMatrix = new int[rows][columns];

	}

	/*
	 * Put the given value in the corresponding Location
	 */
	public void putValue(int row, int column , int value){
		
		twoDMatrix[row][column] = value;
	}
	
	/*
	 * Get an Value from a particular position
	 */
	public int getValue(int rows, int columns){
		
		return twoDMatrix[rows][columns];
	}
	/*
	 * Read input from file and creates an array Each line file corresponds to
	 * the row in matrix
	 */
	public void addElements(File inputfile) {

		// To read the input
		String line;
		String numbers[];
		// Scanner input = new Scanner(new
		// File("C:\\Users\\Salaikumar\\Desktop\\matrix1.txt"));
		try {
			Scanner input = new Scanner(inputfile);
			int i = 0, j;
			while (input.hasNextLine() && i < rows) {

				line = input.nextLine();
				numbers = line.split(",");
				for (j = 0; j < columns; j++) {
					twoDMatrix[i][j] = Integer.parseInt(numbers[j]);
				}
				i++;
			}

		} catch (FileNotFoundException e) {
			System.out.println("No such file exists with that name");
			e.printStackTrace();
		}

	}

	/*
	 * Print the array
	 */
	public void print() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				System.out.print(twoDMatrix[i][j] + ",");
			}
			System.out.println();
		}
	}

	/*
	 * Multiplication Compatibility
	 */
	public boolean isMultipliable(Matrix a2) {

		return (this.columns == a2.rows);
	}
	
	/*
	 * Return the number of rows
	 */
	public int rows(){
		return this.rows;
	}
	
	/*
	 * Return the number of columns
	 */
	public int columns(){
		return this.columns;
	}
	
	/**
	 * @param args
	 *            Unit Test
	 */
	public static void main(String[] args) {
		System.out.println("Matrix Creation");

		Matrix a1 = new Matrix(2, 4);

		File input = new File("C:\\Users\\Salaikumar\\Desktop\\matrix1.txt");
		a1.addElements(input);

		System.out.println("Given Array");
		a1.print();

	}

}
