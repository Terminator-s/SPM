package file;

import file.ComplexityFactors;

import java.util.Stack;

import static file.FileUploadServlet.factorList;


public class Stacks {
    private Stack<String> stringStack = new Stack<>();
    private int LineNo;
    private int caseCount;
    private int updateValue = 0;
    private int count = 0;

    public Stacks() {
    }

    public void push(String item) {
        stringStack.push(item);
    }

    public void pop() {
        stringStack.pop();
    }

    public String peek() {
        if (stringStack.size() == 0) {
            return null;
        } else {
            return stringStack.peek();
        }
    }

    public boolean empty() {
        return stringStack.isEmpty();
    }

    public int getSize() {
        return stringStack.size();
    }

    public int getLineNo() {
        return LineNo;
    }

    public int getCaseCount() {
        return caseCount;
    }

    public void setCaseCount() {
        this.caseCount++;
    }

    public void setLineNo(int lineNo) {
        LineNo = lineNo;
    }

    public void setUpdateValue(){
        for(ComplexityFactors cf : factorList){
            if (LineNo == cf.getNoOfLines()){
                updateValue += caseCount;
                cf.setCtc(updateValue);
            }
        }

    }

    public void nSetUpdateValue() {
        if(this.getSize() == 1){
            updateValue = 0;
        }
        else{
            updateValue += this.getSize();
        }
    }
}
