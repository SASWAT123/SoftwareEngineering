package com.se.homeworktwo;

import java.util.ArrayList;
import java.util.Collections;

public class Num {
    public static final int MAX_SIZE = 25;
    int n;
    int at;
    String name;
    ArrayList<Integer> _has;
    int lo;
    int hi;
    boolean isSorted;
    int w;

    public Num() {
        this(0,"");
    }

    public Num(int at, String name) {
        this.n = 0;
        this.at = at;
        this.name = name;
        this._has = new ArrayList<>();
        this.isSorted = true;
        this.lo = Integer.MAX_VALUE;
        this.hi = Integer.MIN_VALUE;
        this.w = name.contains("-$") ? -1 : 1;
    }

    void add(int v) {
        n++;
        lo = Math.min(lo, v);
        hi = Math.max(hi, v);
        int pos = -1;
        int currentSize = _has.size();
        if (currentSize < MAX_SIZE) {
            pos = _has.size();
        }
        else if (Math.random() < currentSize / n){
            pos = (int) (Math.random() * currentSize);
        }
        if(pos != -1) {
            isSorted = false;
            _has.set(pos, v);
        }
    }

    ArrayList<Integer> nums() {
        if (!isSorted) {
            Collections.sort(_has);
            isSorted = true;
        }
        return _has;
    }

    double div() {
        ArrayList<Integer> num = nums();
        return (per(0.9, num) - per(0.1, num))/ 2.58;
    }

    int mid() {
        ArrayList<Integer> num = nums();
        return per(0.5, num);
    }

    Integer per(double a, ArrayList<Integer> s) {
        int pos;
        if(a == 0)
            pos = (int) Math.floor(0.5 * s.size() + 0.5);
        else
            pos = (int) Math.floor(a * s.size() + 0.5);

        return s.get(Math.max(1, Math.min(s.size(), pos)));
    }
}
