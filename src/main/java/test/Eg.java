package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.opencsv.exceptions.CsvException;
import com.se.homeworktwo.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

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

    @Test
    public void checkDependentIndependentCols() {
        String[] arr = new String[]{"Clndrs", "Volume", "Hp:", "Lbs-", "Acc+", "Model", "origin", "Mpg+"};
        Map<Integer, String> colNamesMap = new LinkedHashMap<>();
        for(int i=0;i<arr.length;i++){
            colNamesMap.put(i, arr[i]);
        }
        Cols cols = new Cols(colNamesMap);

        List<String> independentCols = Arrays.asList("Clndrs", "Volume", "Model", "origin");
        List<String> dependentCols = Arrays.asList("Lbs-", "Acc+", "Mpg+");
        Assert.assertEquals(cols.x, independentCols);
        Assert.assertEquals(cols.y, dependentCols);
    }

    @Test
    public void csv() throws IOException, CsvException {
        List<String[]> csvData = App.csv("data/testFile.csv");
        for(int i=0;i<=10;i++){
            Util.oo(Arrays.toString(csvData.get(i)));
        }
        Assert.assertTrue(true);
    }

    @Test
    public void data() throws IOException, CsvException {
        Data d = new Data("data/testFile.csv");
        for(String s: d.cols.y){
            Util.oo(s);
        }
        Assert.assertTrue(true);
    }
}
