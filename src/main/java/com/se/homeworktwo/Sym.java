package com.se.homeworktwo;

import java.util.Map;

public class Sym
{
    int n;
    int at;
    String name;
    Map<String, Integer> _has;

    public Sym(int col, String name) {
        this.n = 0;
        this._has.clear();
        this.name = name;
        this.at = col;
    }

    void add(String v) {
        if (_has.containsKey(v)) {
            _has.put(v, _has.get(v) + 1);
        } else {
            _has.put(v, 1);
        }
    }

    String mid(int col, int most, String mode){
        most = -1;
        int v;
        for(String key : _has.keySet()) {
            v = _has.get(key);
            if (v > most) {
                most = v;
                mode = key;
            }
        }
        return mode;
    }
}