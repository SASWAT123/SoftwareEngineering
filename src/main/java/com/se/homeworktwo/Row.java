package com.se.homeworktwo;

import java.util.ArrayList;

public class Row {
    public ArrayList<Double> cells;
    public ArrayList<Double> cooked;
    Boolean isEvaled;

    public Row(ArrayList<Double> cells) {
        this.cells = cells;
        this.cooked = new ArrayList<>(cells);
        this.isEvaled = Boolean.FALSE;
    }
}
