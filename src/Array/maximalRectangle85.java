package Array;

//https://leetcode.com/problems/maximal-rectangle/
public class maximalRectangle85 {
	public static void main(String args[]) {
		//char x[][]={{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
		char x[][]={{'0','1'},{'1','0'}};
		System.out.println(new maximalRectangle85().maximalRectangle(x));
	}

	public int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return 0;
		}
		int row[] = new int[matrix[0].length];
		for (int j = 0; j < matrix[0].length; j++) {
			row[j] = matrix[0][j]-48;
		}
		int ans = maximalRectangle1D(row, 0, row.length-1);
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == '1') {
					row[j]++;
				} else {
					row[j] = 0;
				}
			}
			ans = Math.max(ans, maximalRectangle1D(row, 0, row.length-1));
		}
		return ans;
	}

	public int maximalRectangle1D(int x[], int start, int end) {
		if (start > end || start < 0 || end >= x.length) {
			return 0;
		}
		int minIndex = start;
		for (int i = start; i <= end; i++) {
			if (x[i] < x[minIndex]) {
				minIndex = i;
			}
		}
		int ans = maximalRectangle1D(x, start, minIndex - 1);
		ans = (int) Math.max(ans, maximalRectangle1D(x, minIndex + 1, end));
		ans = (int) Math.max(ans, x[minIndex] * (end - start + 1));
		return ans;
	}
}
