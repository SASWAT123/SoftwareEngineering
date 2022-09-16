package com.se.homeworktwo;

import java.util.ArrayList;

public class Row {
    public ArrayList<String> cells;
    public ArrayList<String> cooked;
    Boolean isEvaled;

    public Row(ArrayList<String> cells) {
        this.cells = cells;
        this.cooked = new ArrayList<>(cells);
        this.isEvaled = Boolean.FALSE;
    }
}
