package file;

import Recursion.Recursion;
import controlStructure.ControlStructure;
import controlStructure.Nested;
import size.SizeFactor;

public class ComplexityFactors {
    private int Ctc;
    private int Cnc;
    private int Ci;
    private int TW;
    private int Cs;
    private int Cps;
    private int Cr;
    private int Cp;
    private String fileName;
    private int noOfLines;
    private String line;
    private String tokens;
    SizeFactor sizeFactor = new SizeFactor();
    ControlStructure cstruct = new ControlStructure();
    Nested nest = new Nested();
    Recursion recursion = new Recursion();
    Stacks stacks = new Stacks();

    public ComplexityFactors() {}

    ComplexityFactors(String line, int noOfLines){
        this.line=line;
        this.fileName = fileName;
        this.noOfLines = noOfLines;
    }

    public String getLine() {
        return line;
    }

    public String getFileName() {
        return fileName;
    }

    public int getNoOfLines() {
        return noOfLines;
    }

    //find token under size factor
    public void setTokens(){
        this.tokens = sizeFactor.getToken();
    }

    public String getTokens() {
        return tokens;
    }

    //get size factor
    public int getCs() {
        return Cs;
    }

    //calculate total Cs by sending each line
    public void setCs() {
        this.Cs = sizeFactor.calculateTotalCs(line);
    }

    public int getCtc() {
        return Ctc;
    }

    public void setCtc(int value) {
        this.Ctc = Ctc + value;
    }

    public void setCtc(Stacks s) {
        //call your function to calculate the factor
        this.Ctc = cstruct.getCTC(line,noOfLines ,s);
    }

    public int getCnc() {
        return Cnc;
    }

    public void setCnc(Stacks ns, Stacks cs) {
        //call your function to calculate the factor
        this.Cnc = nest.getCNC(line,noOfLines,ns , cs);
    }

    public int getCi() {
        return Ci;
    }

    public void setCi() {
        //call your function to calculate the factor
        Ci = 1;
    }

    public int getTW() {
        return TW;
    }

    public void setTW() {
        //call your function to calculate the factor
        TW = getCtc() + getCtc() + getCi();
    }


    public int getCps() {
        return Cps;
    }

    public void setCps() {
        //call your function to calculate the factor
        Cps = getCs() * getTW();
    }

    public int getCr() {
        return Cr;
    }

    public void setCr(boolean IsRecursive) {
        //call your function to calculate the factor
        int TotalCr = 0;
        this.Cr = recursion.getTotalCr();
        if (IsRecursive == true) {
            Cr = getCps() * 2;
        } else {
            Cr = 0;
        }
    }

    public int getCp() {
        return Cp;
    }

    public void setCp() {
        //call your function to calculate the factor
        Cp = getCps()+ getCr();
    }
}
