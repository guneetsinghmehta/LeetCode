package DP;

import java.util.Arrays;
//https://leetcode.com/problems/coin-change/
public class coinChange322 {
	public static void main(String args[]) {
		int coins[] = { 1, 2, 5 };
		int n = 11;
		System.out.println(new coinChange322().coinChange(coins, n));
	}

	public int coinChange(int[] coins, int n) {
		if (n == 0) {
			return 0;
		}
		int x[] = new int[n + 1];
		// fill all with max integer
		Arrays.fill(x, Integer.MAX_VALUE);
		for (int i = 1; i <= n; i++) {
			for (int coin : coins) {
				if (coin == i) {
					x[i] = 1;
				} else if (i > coin && x[i - coin] != Integer.MAX_VALUE) {
					x[i] = Math.min(x[i], x[i - coin] + 1);
				}
			}
		}
		if (x[n] == Integer.MAX_VALUE) {
			return -1;
		}
		return x[n];
	}
}
