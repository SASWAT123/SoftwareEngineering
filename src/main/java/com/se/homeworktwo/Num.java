package com.se.homeworktwo;

import java.util.*;


public class Num extends Cell{

    int n;
    // Fetch value from the.nums of cli function
    int the_nums = 32;
    int at;
    String name;
    public ArrayList<Double> _has;
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

    public ArrayList<Double> nums() {
        if (!isSorted) {
            Collections.sort(_has);
            isSorted = true;
        }
        return _has;
    }

    public void add(Double v) {
        int pos = 0;
        if(v != null){
            this.n = this.n + 1;
            this.lo = Math.min(v, this.lo);
            this.hi = Math.max(v, this.hi);
            if(this._has.size() < the_nums){
                pos = 1 + this._has.size();
            }else if(Math.random() < the_nums / this.n){
                pos = (int) (Math.random() * this._has.size());
            }

            if(pos != -1) {
                this.isSorted = false;
                this._has.add(v);
            }
        }
    }

    public double div() {
        ArrayList<Double> a = nums();
        return (per(a, 0.9) - per(a,0.1))/ 2.56;
    }

    public double mid() {
        ArrayList<Double> a = nums();
        return per(a,0.5);
    }

    public double per(ArrayList<Double> t, double p) {
        int pos;
        if (p!=0)
        pos = (int) Math.floor((p * t.size()) + 0.5);
        else
        pos = (int) Math.floor((0.5 * t.size()) + 0.5);

        return t.get(Math.max(1, Math.min(t.size(), pos)));
    }

    
}
