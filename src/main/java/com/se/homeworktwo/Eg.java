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

    public void numTest()
    {
        Num num = new Num();
        for(int i =1; i<= 100; i++)
        {
            //Check logic for pos 
            num.add(i,0);
        }
        double mid = num.mid();
        double div = num.div();
        assertTrue(50<= mid && mid<=52);  
        assertTrue(30.5< div && div<32);        
    }
}
