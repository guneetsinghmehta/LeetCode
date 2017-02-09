package Array;

//https://leetcode.com/problems/search-a-2d-matrix/
public class search2DMatrix {
	public static void main(String args[]) {
		int x[][] = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };
		System.out.println(new search2DMatrix().searchMatrix(x, 8));
	}

	public boolean searchMatrix(int[][] matrix, int target) {
		boolean ans = false;
		if (matrix == null || matrix.length == 0) {
			return false;
		}
		if (matrix.length == 1) {
			ans = search(matrix[0], target);
		} else {
			int a = 0;
			int b = matrix.length - 1;
			int mid;
			while (b - a > 1) {
				mid = (a + b) / 2;
				if (matrix[mid][0] > target) {
					b = mid;
				} else {
					a = mid;
				}
			}
			ans = search(matrix[a], target) || search(matrix[b], target);
		}
		return ans;
	}

	public boolean search(int x[], int target) {
		boolean ans = false;
		int a = 0;
		int b = x.length - 1;
		int mid;
		if (x != null && x.length > 0 && x[0] == target) {
			ans = true;
		}
		while (a <= b) {
			mid = (a + b) / 2;
			if (x[mid] == target) {
				ans = true;
				break;
			} else if (x[mid] < target) {
				a = mid + 1;
			} else {
				b = mid - 1;
			}
		}
		return ans;
	}
}
