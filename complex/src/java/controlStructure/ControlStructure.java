package controlStructure;

import java.util.HashMap;
import java.util.StringTokenizer;

public class ControlStructure implements iControlStructure {
    private int lineValue;
//    private int cnc;
//    private HashMap<Integer, Integer> hm;
    private String[] conditionalKeywords = {"if(", "else(", "if", "else"};
    private String[] iterativeKeywords = {"while", "for", "do", "foreach"};
    private String[] statementKeywords = {"case"};
    private String[] operatorKeywords = {"&&", "||", "&", "|"};


    public ControlStructure() {
    }

    @Override
    public int getCTC(String inputLine, int lineNumber) {
        String word;
        boolean condition = false;
        boolean iterative = false;
        boolean operator = false;
        int count = 0;

        StringTokenizer stTokenizer = new StringTokenizer(inputLine);
        while (stTokenizer.hasMoreTokens()) {
            lineValue = 0;
            //break words in each line
            word = stTokenizer.nextToken();

            //for checking conditional keywords
            for (int i = 0; i < conditionalKeywords.length; i++) {
                if (conditionalKeywords[i].equals(word)) {
                    lineValue += 3;
                    condition = true;
                }

            }

            //for checking iterative keywords
            for (int i = 0; i < iterativeKeywords.length; i++) {
                if (iterativeKeywords[i].equals(word)) {
                    iterative = true;
                }
            }

            for (int i = 0; i < statementKeywords.length; i++) {
                //for conditional keywords
                if (statementKeywords[i].equals(word)) {
                    lineValue += 2;
                }
            }

            for (int i = 0; i < operatorKeywords.length; i++) {
                //for conditional keywords
                if (operatorKeywords[i].equals(word)) {
                    operator = true;
                    count++;
                }
            }
        }


        if (condition && operator) {
            lineValue += count;
        } else if (iterative && operator) {
            lineValue += count;
        }

//        try {
//            hm.put(lineNumber, lineValue);
//        }catch (NullPointerException e){
//            System.out.println("error");
//        }

        return lineValue;
    }

//    public int getCNC(){
//        return cnc;
//    }

//    public void setValueArray(int lineNumber,int lineValue){
//
//        hm.put(lineNumber,lineValue);
//    }
}
