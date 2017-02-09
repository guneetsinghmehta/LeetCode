package Array;

//https://leetcode.com/problems/merge-intervals/
import java.util.*;

class point {
	int index;
	int se;

	point(int index, int se) {
		this.index = index;
		this.se = se;
	}

}

public class MergeInterval56 {
	public static void main(String args[]) {
		new MergeInterval56().merge();
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

	public List<Interval> merge() {
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1, 4));
		intervals.add(new Interval(4,5));

		List<Interval> ans = new ArrayList<Interval>();
		if (intervals.size() == 0) {
			return ans;
		}
		PriorityQueue<point> pq = new PriorityQueue<point>(
				2 * intervals.size(), new Comparator<point>() {
					public int compare(point a, point b) {
						if (a.index - b.index > 0) {
							return 1;
						} else if (a.index - b.index < 0) {
							return -1;
						} else {
							if (a.se == 1 && b.se == -1) {
								return -1;
							} else if (a.se == -1 && b.se == 1) {
								return 1;
							} else {
								return 0;
							}
						}
					}
				});
		for (Interval interval : intervals) {
			pq.add(new point(interval.start, +1));
			pq.add(new point(interval.end, -1));
		}
		int start = -1, end;
		int sum = 0;
		point x;
		while (!pq.isEmpty()) {
			x = pq.remove();
			sum += x.se;
			if (start == -1) {
				// new start
				start = x.index;
			} else {
				if (sum == 0)// interval complete
				{
					end = x.index;
					ans.add(new Interval(start, end));
					start = -1;
				}
			}
		}
		return ans;
	}
}
