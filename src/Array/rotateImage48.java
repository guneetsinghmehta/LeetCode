package Array;

import java.util.*;
//48
//https://leetcode.com/problems/rotate-image/

public class rotateImage48 {
	public static void main(String args[]) {
		int x[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		new rotateImage48().rotate(x);
		System.out.println(1);
	}

	public void rotate(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i <= n / 2; i++) {
			sub(matrix, i, i, n - 2 * i);
		}
	}

	public void sub(int matrix[][], int x, int y, int side) {
		int temp, x1, y1, x2, y2, x3, y3, x4, y4;
		for (int i = 0; i < side - 1; i++) {
			x1 = x;
			y1 = y + i;

			x2 = x + i;
			y2 = y + side - 1;

			x3 = x + side - 1;
			y3 = y + side - 1 - i;

			x4 = x + side - 1 - i;
			y4 = y;

			temp = matrix[x4][y4];
			matrix[x4][y4] = matrix[x3][y3];
			matrix[x3][y3] = matrix[x2][y2];
			matrix[x2][y2] = matrix[x1][y1];
			matrix[x1][y1] = temp;
		}
	}
}
