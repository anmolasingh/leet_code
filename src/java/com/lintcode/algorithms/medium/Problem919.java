package com.lintcode.algorithms.medium;

import java.util.*;

/*
 * 919 · Meeting Rooms II
 * https://www.lintcode.com/problem/919/
 * Tags: Intervals
 * */

public class Problem919 {

    private static class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int minMeetingRooms(List<Interval> intervals) {
        List<Integer> starts = new ArrayList<>();
        List<Integer> ends = new ArrayList<>();
        for(Interval interval : intervals) {
            starts.add(interval.start);
            ends.add(interval.end);
        }
        Collections.sort(starts);
        Collections.sort(ends);
        int result = 0, count = 0, s = 0, e = 0;
        while(s < intervals.size()) {
            if(starts.get(s) < ends.get(e)) {
                count++;
                s++;
            } else {
                count--;
                e++;
            }
            result = Math.max(result, count);
        }
        return count;
    }

    public int minMeetingRooms1(List<Interval> intervals) {
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval m1, Interval m2) {
                if(m1.start == m2.start){
                    return 0;
                }
                return m1.start - m2.start;
            }
        });

        int maxEnd = 0;
        Set<Integer> starts = new HashSet();
        Set<Integer> ends = new HashSet();
        for(Interval interval : intervals) {
            starts.add(interval.start);
            ends.add(interval.end);
            if(interval.end > maxEnd) {
                maxEnd = interval.end;
            }
        }

        int currCount = 0, maxCount = 0;
        for(int i=0; i<maxEnd; i++) {
            if(starts.contains(i)) {
                currCount++;
            }
            if(ends.contains(i)) {
                currCount--;
            }
            maxCount = Math.max(maxCount, currCount);
        }
        return maxCount;
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(0,30));
        intervals.add( new Interval(5,10));
        intervals.add( new Interval(15,20));
        System.out.println(new Problem919().minMeetingRooms(intervals));//2
        intervals = new ArrayList<>();
        intervals.add(new Interval(0,10));
        intervals.add( new Interval(5,15));
        intervals.add( new Interval(10,30));
        System.out.println(new Problem919().minMeetingRooms(intervals));//2
        intervals = new ArrayList<>();
        intervals.add(new Interval(2,7));
        System.out.println(new Problem919().minMeetingRooms(intervals));//1
    }
}
