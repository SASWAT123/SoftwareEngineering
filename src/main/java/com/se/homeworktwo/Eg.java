package com.se.homeworktwo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Eg {

    @Test
    public void symTest()
    {
        Sym sym = new Sym();
        String[] data = new String[]{"a", "a","a","a","b","b","c"};
        for(String x : data)
        {
            sym.add(x);
        }
        String mode = sym.mid();
        double entropy = sym.div();
        assertEquals("a", mode);
        assertTrue(1.37<= entropy && entropy<=1.38);        
    }
}
