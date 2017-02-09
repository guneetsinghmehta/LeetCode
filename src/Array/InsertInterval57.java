package Array;
import java.util.*;
//https://leetcode.com/problems/insert-interval/
public class InsertInterval57 {
	class point {
		int index;
		int se;

		point(int index, int se) {
			this.index = index;
			this.se = se;
		}

	}
	
	private class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}
	
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

	}
}
