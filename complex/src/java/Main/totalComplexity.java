package Main;

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
    private int Cnc;
    private int Ci;
    private int TW;
    private int Cs;
    private int Cps;
    private int Cr;
    private int Cp;

    /*

    // call all methods and access the array values for calculation

    // call getTotalCs methode from Sizefactor for Cs calculation
    Sizefactor cs =  new Sizefactor();
    Cs = cs.getTotalCs();

    // Call getCtc methode from controlStructure for Ctc calculation
    controlStructure ctc =  new controlStructure();
    Ctc = ctc.getCTC();

     */




    // Calculate Total weight (TW)
    // TW = Ctc + Cnc + Ci
    public int calculateTotalweight(int Ctc, int Cnc, int Ci){
        TW = Ctc + Cnc + Ci;
        return TW;
    }

    // Calculate complexity of a program statement (Cps)
    // Cps = Cs * TW
    public int calculateCps(int Cs, int TW){
        int TotalCps = 0;
        Cps = Cs * TW;

        TotalCps = TotalCps + Cps;
        return Cps;
    }

    // check Recursive. if recursive is there Cr = Cps*2. if recursive is not there Cr = 0
    public int IsRecursive(boolean IsRecursive, int Cps) {
        if (IsRecursive == true) {
            Cr = Cps * 2;
            return Cr;
        } else {
            Cr = 0;
            return Cr;
        }
    }


    // Calculate complexity of a program (Cp)
    // Cp  = Cps + Cr
    public int calculateCp(int Cps){
        Cp  = Cps + this.Cr;
        return Cp;
    }

    public void printDetails() {
            System.out.println(Cps);
    }
}
