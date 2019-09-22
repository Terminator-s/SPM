package file;

import controlStructure.ControlStructure;
import controlStructure.Nested;
import inheritance.Inheritance;
import recursion.Recursion;
import size.SizeFactor;

public class ComplexityFactors {
    private int Ctc = 0;
    private int Cnc = 0;
    private int Ci = 0;
    private int TW = 0;
    private int Cs = 0;
    private int Cps = 0;
    private int Cr = 0;
    private int Cp = 0;
    private String fileName;
    private int noOfLines;
    private String line;
    private String tokens = "N/A";
    SizeFactor sizeFactor = new SizeFactor();
    ControlStructure cstruct = new ControlStructure();
    Nested ns = new Nested();
    Recursion recursion = new Recursion();
    Inheritance inheritance=new Inheritance();
    TotalComplexity totalComplexity = new TotalComplexity();

    public ComplexityFactors(int noOfLines, String line) {
        this.noOfLines = noOfLines;
        this.line = line;
    }

    ComplexityFactors(String line, String fileName, int noOfLines){
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
    public void setCs() throws IllegalAccessException {
        this.Cs = sizeFactor.calculateTotalCs(line);
        setTokens();
    }

    public int getCtc() {
        return this.Ctc;
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

    public void setCnc(Stacks s,Stacks cs) {
        this.Cnc = ns.getCNC(line,noOfLines,s , cs);
    }

    public int getCi() {
        return Ci;
    }

    public void setCi() {
        this.Ci = inheritance.CheckInheritance(line);
    }

    public int getTW() {
        return TW;
    }

    public void setTW() {
        TW = totalComplexity.calculateTotalweight(getCtc(),getCnc(),getCi());
    }


    public int getCps() {
        return Cps;
    }

    public void setCps() {
        Cps = totalComplexity.calculateCps(getCs(),getTW());
    }

    public boolean isRecursive() {
//        recursion.checkRecursive(line);
        recursion.readFile(line);
        return recursion.getRecursive();
    }

    public int getCr() {
        return Cr;
    }

    public void setCr() {
        Cr = totalComplexity.calculateCr(isRecursive(),getCps());
    }

    public int getCp() {
        return Cp;
    }

    public void setCp() {
        Cp = totalComplexity.calculateCp();
    }
}
