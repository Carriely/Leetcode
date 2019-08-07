package com.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

//合并区间
//思路：排序
//首先，我们将列表按上述方式排序。
//然后，我们将第一个区间插入 merged 数组中，然后按顺序考虑之后的每个区间：
//	如果当前区间的左端点在前一个区间的右端点之后，那么他们不会重合，我们可以直接将这个区间插入 merged 中；
//	否则，他们重合，我们用当前区间的右端点和前一个区间的右端点中较大的那个数字更新 merged 最后一个元素的右端点。
public class MergeInterval_56 {
	public static List<Interval> merge(List<Interval> intervals) {
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval a, Interval b) {
				return a.start - b.start;
			}
		});

		LinkedList<Interval> merged = new LinkedList<Interval>();
		for (Interval interval : intervals) {
			if (merged.isEmpty() || merged.getLast().end < interval.start) {
				merged.add(interval);
			} else {
				merged.getLast().end = Math.max(interval.end, merged.getLast().end);
			}
		}
		return merged;
	}

	public static void main(String[] args) {
		List<Interval> list = new ArrayList<>();
		Interval interval = new Interval(1, 3);
		list.add(interval);
		interval = new Interval(2, 6);
		list.add(interval);
		interval = new Interval(15, 18);
		list.add(interval);
		interval = new Interval(8, 10);
		list.add(interval);
		interval = new Interval(5, 10);
		list.add(interval);

		List<Interval> result = merge(list);
		for (int i = 0; i < result.size(); i++) {
			System.out.printf("[" + result.get(i).start + "," + result.get(i).end + "],");
		}
		System.out.println("");
	}

}

class Interval {
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
