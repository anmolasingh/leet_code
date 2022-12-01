package com.lintcode.algorithms.easy;

import java.util.*;

/*
 * 920 · Meeting Rooms
 * https://www.lintcode.com/problem/920/
 * Tags: Intervals
 * */

public class Problem920 {

    private static class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval m1, Interval m2) {
                if(m1.start == m2.start){
                    return 0;
                }
                return m1.start - m2.start;
            }
        });
        for(int i=0; i<intervals.size()-1;i++) {
            if(intervals.get(i).end > intervals.get(i+1).start) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(0,8));
        intervals.add( new Interval(8,10));
        System.out.println(new Problem920().canAttendMeetings(intervals));//true
        intervals = new ArrayList<>();
        intervals.add( new Interval(5,10));
        intervals.add(new Interval(0,30));
        intervals.add( new Interval(15,20));
        System.out.println(new Problem920().canAttendMeetings(intervals));//false
    }
}
