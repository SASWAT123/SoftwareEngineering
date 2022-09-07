package com.se.homeworktwo;

import java.util.*;


public class Num {

    int n;
    // Fetch value from the.nums of cli function
    int the_nums = 32;
    int at;
    String name;
    ArrayList<Double> _has;
    double lo;
    double hi;
    boolean isSorted;
    int w;

    public Num()
    {
        this(0,"");
    }
    public Num (int col, String name) {
        this.n = 0;
        this._has = new ArrayList<>();
        this.name = name;
        this.at = col;
        this.lo=Double.POSITIVE_INFINITY;
        this.hi=Double.NEGATIVE_INFINITY;
        this.isSorted=true;
        this.w = name.contains("-$") ? -1 : 1;
    }

    ArrayList<Double> nums() {
        if (!isSorted) {
            Collections.sort(_has);
            isSorted = true;
        }
        return _has;
    }

    void add(double v, int pos) {
        n=n+1;
        lo = Math.min(v, lo);
        hi = Math.max(v, hi);
        int listSize = _has.size();
        if (listSize < the_nums) {
            pos = 1+listSize;
        }
        else if (Math.random() < the_nums / n){
            pos = (int) (Math.random() * listSize);
        }
        if(pos != -1) {
            isSorted = false;
            _has.set(pos, v);
        }
    }

    double div() {
        ArrayList<Double> a = nums();
        return (per(a, 0.9) - per(a,0.1))/ 2.56;
    }

    double mid() {
        ArrayList<Double> a = nums();
        return per(a,0.5);
    }

    double per(ArrayList<Double> t, double p) {
        int pos;
        if (p!=0)
        pos = (int) Math.floor((p * t.size()) + 0.5);
        else
        pos = (int) Math.floor((0.5 * t.size()) + 0.5);

        return t.get(Math.max(1, Math.min(t.size(), pos))); 
    }

    
}
