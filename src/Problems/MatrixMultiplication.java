/*
 * An typical Implementation of Matrix Multiplication 
 * It doesn't use Strassen's Method, a plain old method
 *  Given two classes, it will perform the multiplication
 */
package Problems;

import java.io.File;

public class MatrixMultiplication {

	// Input Matrices
	Matrix A, B;
	// Output Matrix
	Matrix C;

	public MatrixMultiplication(Matrix A, Matrix B) {
		this.A = A;
		this.B = B;
	}

	/*
	 * Required number of Multiplications
	 */
	public double estimatedTime() {
		return (A.rows() * A.columns() * B.columns());
	}

	/*
	 * Multiply the two matrices
	 */
	public Matrix multiply() {

		if (!A.isMultipliable(B)) {
			throw new IllegalArgumentException(
					"Matrices Incompatible , A.columns doesn't match B.rows");
		}

		// Create the output matrix
		C = new Matrix(A.rows(), B.columns());
		int value = 0;
		for (int i = 0; i < A.rows(); i++) {
			for (int j = 0; j < B.columns(); j++) {
				for (int k = 0; k < B.rows(); k++) {

					value += A.getValue(i, k) * B.getValue(k, j);
				}

				// Put final Value into result matrix at its position
				C.putValue(i, j, value);
				//Reinitialize the counter
				value = 0;
			}
		}

		return C;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Matrix a = new Matrix(2, 4);

		File input = new File("C:\\Users\\Salaikumar\\Desktop\\matrix1.txt");
		a.addElements(input);
		
		Matrix b = new Matrix(4, 2);
		b.addElements(input);
		b.print();
		System.out.println("_______________________________");
		Matrix output;
		MatrixMultiplication m = new MatrixMultiplication(a,b);
		
		try{
			output = m.multiply();
			output.print();
		}catch(IllegalArgumentException e){
				
			System.out.println(e.getMessage());
		}
		
		

		

	}

}
