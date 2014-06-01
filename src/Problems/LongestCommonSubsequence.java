/*
 * Implementation of Longest common subsequence using Dynamic Programming
 */

package Problems;

import java.util.Queue;
import java.util.Stack;


public class LongestCommonSubsequence {

	// Input String
	private String a = "";
	private String b = "";
	private StringBuilder output;

	// Stack to hold the Longest common Subsequence
//	private Stack<Character> lcs;

	// LCS length
	private int length[][];

	public LongestCommonSubsequence(String a, String b) {

		this.a = a;
		this.b = b;
		length = new int[a.length()][b.length()];
//		lcs = new Stack<Character>();
		//  Create it with shorter length
		output = new StringBuilder(a.length() < b.length()? a.length():b.length());
		/*
		 * Making the i,0 and 0,j pair value as Zero
		 */

		/*
		 * The insidous bug is here. In java, array indices start with Zero. So,
		 * (2,0) Actually has some value. Not 2 and nothing.
		 * 
		 * for (int i = 0; i < a.length(); i++) length[i][0] = 0;
		 * 
		 * for (int i = 0; i < b.length(); i++) length[0][i] = 0;
		 */

		calculateLCS(a.length() - 1, b.length() - 1);
	}

	/*
	 * Calculate the LCS
	 */
	private int calculateLCS(int l1, int l2) {

		if ((l1 < 0) || (l2 < 0)) {
			return 0; // Could be changed to return 0;
		}

		if (a.charAt(l1) == b.charAt(l2)) {
			length[l1][l2] = 1 + calculateLCS(l1 - 1, l2 - 1);
//			output.append(a.charAt(l1));
		}

		else {
			length[l1][l2] = calculateLCS(l1 - 1, l2) > calculateLCS(l1, l2 - 1) ? calculateLCS(
					l1 - 1, l2) : calculateLCS(l1, l2 - 1);
		}

		return length[l1][l2];

	}

	/*
	 * Return the LCS Length
	 */
	public int getLCSLength(int l1, int l2) {

		if (l1 > a.length() || l2 > b.length())
			throw new ArrayIndexOutOfBoundsException(
					"Input out of String Length");

		if (l1 < 0 || l2 < 0)
			throw new ArrayIndexOutOfBoundsException("Index is negative!");

		return length[l1 - 1][l2 - 1];
	}

	/*
	 * Return the LCS String
	 */
	public StringBuilder getLCS() {
		return output;
	}

	/*
	 * How will get the String of LCS within the given boundary?? Lets see that
	 * after testing the correctness
	 */

	/**
	 * @param args
	 *            Unit test
	 */
	public static void main(String[] args) {

		String a = "ACDEFGMNSUXDHERERJVF";
		String b = "DEFGXF";

		System.out.println("A.length = " + a.length());
		System.out.println("b.length = " + b.length());

		LongestCommonSubsequence lcs = new LongestCommonSubsequence(a, b);

		// System.out.println("LCS Length ="+lcs.getLCSLength(a.length(),
		// b.length()));

		System.out.println("LCS Length =" + lcs.getLCSLength(a.length(), b.length()));

	//	System.out.println("String = " + lcs.getLCS());

		// Print the complete Lengths

	}

}
