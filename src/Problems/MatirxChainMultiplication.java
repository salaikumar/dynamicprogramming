/*
 *  Matrix Chain Multiplication
 *  Dynamic programming principle is applied
 */
package Problems;

public class MatirxChainMultiplication {

	// Input Matrices to be multiplied
	private Matrix[] series;

	// Output Matrix
	private Matrix output;

	// Holds the minimum no. of calculations
	double[][] calculations;

	// Holds the best parenthesis points
	int[][] breakPoints;

	// Multiplicative at each point
	int[] p;

	public MatirxChainMultiplication(int N) {
		series = new Matrix[N];
		calculations = new double[series.length][series.length];
		breakPoints = new int[series.length][series.length];
		p = new int[series.length + 1];
	}

	// Get the chain of matrices to be multiplied.
	/**
	 * @param series
	 */
	public void setMatrices(Matrix[] series) {

		// Make a Local Copy
		this.series = series;

		// Find the P values
		/*int j = 0;
		for (int i = 0; i < p.length; i++) {
			p[i] = series[j].rows();

			// Last time , it should not increment
			if (j < series.length - 1)
				j++;
		}*/

		// Initialize the Local Main Diagonal
		for (int i = 0; i < series.length; i++)
			calculations[i][i] = 0;

		calculateCost();

	}

	// Check for Multiplication rule
	public boolean isOrdered() {

		for (int i = 0; i < series.length; i++) {

			if (series[i].isMultipliable(series[i + 1])) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

	private void calculateCost() {

		int j = 0;
		for (int l = 1; l <= series.length; l++) {

			for (int i = 0; i < series.length - l + 1; i++) {
				j = i + l - 1;
				if( i == j)
					calculations[i][j] = 0;
				else
					calculations[i][j] = Double.POSITIVE_INFINITY;
				double tempCalc = 0;
				for (int k = i; k <= j - 1; k++) {
					tempCalc = calculations[i][k] + calculations[k + 1][j]
							+ (series[i].rows() * series[k].columns() * series[j].columns());

					if (tempCalc < calculations[i][j]) {

						calculations[i][j] = tempCalc;
						breakPoints[i][j] = k+1;
					}
				}
			}

		}
	}

	/*
	 * Returns the minimal cost
	 */
	public double getMinimalCost(int i, int j) {

		return calculations[i - 1][j - 1];
	}

	/*
	 * return the exact parenthesis point
	 */
	public int getBreakPoint(int i, int j) {
		return breakPoints[i - 1][j - 1];
	}

	/**
	 * @param args
	 *            Unit test
	 */
	public static void main(String[] args) {

		// Create 5 matrices
		Matrix A = new Matrix(4, 10);
		Matrix B = new Matrix(10, 3);
		Matrix C = new Matrix(3, 12);
		Matrix D = new Matrix(12, 20);
		Matrix E = new Matrix(20, 7);

		Matrix[] series = new Matrix[5];
		series[0] = A;
		series[1] = B;
		series[2] = C;
		series[3] = D;
		series[4] = E;

		MatirxChainMultiplication obj = new MatirxChainMultiplication(
				series.length);

		obj.setMatrices(series);

		System.out.println("Cost :" + obj.getMinimalCost(2, 3));
		System.out.println("Break Point:" + obj.getBreakPoint(2, 3));

	}

}
