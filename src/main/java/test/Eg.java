package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.se.homeworktwo.Num;
import com.se.homeworktwo.Sym;
import com.se.homeworktwo.Util;
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

    @Test
    public void theTest()
    {
        String the = "the";
        assertTrue(Util.oo(the), true);
    }

    @Test
    public void numTest()
    {
        Num num = new Num();
        for(int i =1; i<= 100; i++)
        {
            //Check logic for pos 
            num.add(i);
        }
        double mid = num.mid();
        double div = num.div();
        assertTrue(50<= mid && mid<=52);  
        assertTrue(30.5< div && div<32);        
    }

    @Test
    public void bigNumTest()
    {
        Num num = new Num();
        for(int i =1; i<= 1000; i++)
        {
            //Check logic for pos
            num.add(i);
        }

        assertEquals(num.nums().size(), num._has.size());
    }
}
