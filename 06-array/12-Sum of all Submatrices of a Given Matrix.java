package temp;

import java.util.ArrayList;
import java.util.List;

public class AppMain {
	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		List<int[][]> listAllSubMatrices = getAllSubMatrices(matrix);
		int sumOfAllSubMatrices = getAllSubMatricesSum(listAllSubMatrices);
		System.out.println("All sub matrices sum is: " + sumOfAllSubMatrices);

		// Optimized approach: Time complexity is O(N ^ 2) and space complexity is O(1).
		// Using the contribution technique.
		int totalRow = matrix.length;
		int totalCol = matrix[0].length;
		sumOfAllSubMatrices = 0;
		for (int row = 0; row < totalRow; row++) {
			for (int col = 0; col < totalCol; col++) {
				int element = matrix[row][col];
				int contributions = (row + 1) * (col + 1) * (totalRow - row) * (totalCol - col); 
				// (row + 1) * (col + 1) = top left elements.
				// (totalRow - row) * (totalCol - col) = bottom right elements.
				// top left elements * bottom right elements = total number of sub matrices in which the current element is included.
				sumOfAllSubMatrices += (contributions * element); 
			}
		}
		System.out.println("All sub matrices sum is: " + sumOfAllSubMatrices);
	}

	// Brute force: Time complexity is O(N ^ 6) and space complexity is O(N ^ 6).
	private static List<int[][]> getAllSubMatrices(int[][] matrix) {
		List<int[][]> listAllSubMatrices = new ArrayList<int[][]>();
		int totalRow = matrix.length;
		int totalCol = matrix[0].length;
		for (int startRow = 0; startRow < totalRow; startRow++) {
			for (int endRow = startRow; endRow < totalRow; endRow++) {
				for (int startCol = 0; startCol < totalCol; startCol++) {
					for (int endCol = startCol; endCol < totalCol; endCol++) {
						int[][] subMatrix = new int[endRow - startRow + 1][endCol - startCol + 1];
						for (int row = startRow; row <= endRow; row++) {
							for (int col = startCol; col <= endCol; col++) {
								subMatrix[row - startRow][col - startCol] = matrix[row][col];
							}
						}
						listAllSubMatrices.add(subMatrix);
					}
				}
			}
		}
		return listAllSubMatrices;
	}

	private static int getAllSubMatricesSum(List<int[][]> listAllSubMatrices) {
		int sum = 0;
		for (int i = 0; i < listAllSubMatrices.size(); i++) {
			int[][] subMatrix = listAllSubMatrices.get(i);
			for (int row = 0; row < subMatrix.length; row++) {
				for (int col = 0; col < subMatrix[row].length; col++) {
					sum += subMatrix[row][col];
				}
			}
		}
		return sum;
	}
}
