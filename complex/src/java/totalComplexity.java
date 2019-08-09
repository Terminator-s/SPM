
public class totalComplexity {
    // Ctc = Measuring the complexity of a program statement due to type of control structures
    // Cnc = Measuring the complexity of a program statement due to nesting of control structures
    // Ci = Measuring the complexity of a program statement due to inheritance
    // TW = total weight
    // Cs = Measuring the complexity of a program statement due to size
    // Cps = Measuring total complexity of a program statement
    // Cr = Measuring the complexity introduced due to recursion
    // Cp = Measuring complexity of a program

    // Ctc, Cnc, Ci variables for TW calculation
    // TW, Cs variables for Cps calculation
    // Cps, Cr variables for Cp calculation

    private int Ctc;
    private int Cnc ;
    private int Ci;
    private int TW;
    private int Cs;
    private int Cps;
    private int Cr;
    private int Cp;

    // call all methods and access the array values for calculation

    //Call cGetArray from ControlStructure class for Cs calculation
    ControlStructure cs = new ControlStructure();
    int arr[] = cs.cGetArray();

    // method for sumCs of elements in an array
    static int sumCs()
    {
        int sumCs = 0; // initialize sum
        int i;

        // Iterate through all elements and add them to sum
        for (i = 0; i < arr.length; i++)
            sumCs +=  arr[i];
            Cs = sumCs;

        return Cs;
    }

    // Calculate Total weight (TW)
    // TW = Ctc + Cnc + Ci
    private int calculateTotalweight(int Ctc, int Cnc, int Ci){
        TW = Ctc + Cnc + Ci;
        return TW;
    }

    // Calculate complexity of a program statement (Cps)
    // Cps = Cs * TW
    private int calculateTotalweight(int Cs, int TW){
        Cps = Cs * TW
        return Cps;
    }

    // Calculate complexity of a program (Cp)
    // Cp  = Cps + Cr
    private int calculateTotalweight(int Cps, int Cr){
        Cp  = Cps + Cr
        return Cps;
    }

}
