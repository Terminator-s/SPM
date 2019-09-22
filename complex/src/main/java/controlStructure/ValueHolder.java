package controlStructure;

import file.ComplexityFactors;
import file.ReadFile;


public class ValueHolder {
    private int updateValue;
    private int lineNo;
    private int caseCount;
    private boolean switchFound;

    ReadFile rf = new ReadFile();

    public ValueHolder() {
        lineNo = 0;
        caseCount = 0;
    }

    public void setLineNo(int lineNo, boolean switchFound){
        this.lineNo = lineNo;
        this.switchFound = switchFound;
    }

    public boolean isSwitchFound() {
        return switchFound;
    }

    public void setCaseCount(){
        caseCount++;
    }

    public void setUpdateValue(){
        for(ComplexityFactors cf : rf.getFactorList()){
//            for (ValueHolder valueHolder: this.rf.getValueHolderList()){


            if (lineNo == cf.getNoOfLines()){
                cf.setCtc(updateValue);
            }
//            }
        }

    }
}
