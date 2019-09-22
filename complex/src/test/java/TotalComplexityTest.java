import file.ComplexityFactors;

import static org.junit.Assert.*;

public class TotalComplexityTest {
    ComplexityFactors cf = new ComplexityFactors();

    //Ctc = 1, Cnc = 1, Ci = 1
    //Expected value of TW = Ctc + Cnc + Ci ==> TW = 3
    @org.junit.Test
    public void calculateTotalweight() {
        assertEquals(3, cf.getTW());
    }

    //Cs = 2, TW = 3
    //Expected value of Cps = Cs * TW ==> Cps = 6
    @org.junit.Test
    public void calculateCps() {
        assertEquals(6,cf.getCps());
    }

    //IsRecursive = true, Cps = 2
    //Expected value of Cr = Cps * 2 ==> cr = 4
    @org.junit.Test
    public void calculateCr() {
        assertEquals(4, cf.getCr());
    }

}