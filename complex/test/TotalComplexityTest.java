import file.TotalComplexity;

import static org.junit.Assert.*;

public class TotalComplexityTest {
    TotalComplexity totalComplexity = new TotalComplexity();

    //Ctc = 1, Cnc = 1, Ci = 1
    //Expected value of TW = Ctc + Cnc + Ci ==> TW = 3
    @org.junit.Test
    public void calculateTotalweight() {
        assertEquals(3, totalComplexity.calculateTotalweight(1,1,1));
    }

    //Cs = 2, TW = 3
    //Expected value of Cps = Cs * TW ==> Cps = 6
    @org.junit.Test
    public void calculateCps() {
        assertEquals(6,totalComplexity.calculateCps(2,3));
    }

    //IsRecursive = true, Cps = 2
    //Expected value of Cr = Cps * 2 ==> cr = 4
    @org.junit.Test
    public void calculateCr() {
        assertEquals(4, totalComplexity.calculateCr(true, 2));
    }

}