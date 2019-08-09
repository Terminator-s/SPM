package controlStructure;

import java.util.HashMap;
import java.util.StringTokenizer;

public class ControlStructure implements iControlStructure {
    private HashMap<Integer, Integer> Ctc;
    private int lineValue;
    private String[] conditionalKeywords= {"if", "else", "else if"};
    private String[] iterativeKeywords = {"while", "for", "do", "foreach"};
    private String[] statementKeywords = {"case"};
    private String[] operatorKeywords = {"&&", "||", "&", "|"};


    public ControlStructure() {
        Ctc = null;
        lineValue = 0;
    }

    @Override
    public void cSetValueForLine(String inputLine, int lineNumber) {
        String word = "";

        StringTokenizer stTokenizer = new StringTokenizer(inputLine);
        while (stTokenizer.hasMoreTokens()) {

            //break words in each line
            word = stTokenizer.nextToken();

            System.out.println(word);



            //for checking keywords
            for (int i = 0; i <= 4; i++) {
                try {
//                    //for conditional keywords
//                    if (conditionalKeywords[i].equals(word)) {
//                        lineValue++;
//
//                        //check logical and bitwise operator
//                        for (int j = 0; j <= 4; j++) {
//                            if (operatorKeywords[i].equals(word)) {
//                                lineValue++;
//                            }
//                        }
//                    }
//                    //for iterative keywords
//                    else if (iterativeKeywords[i].equals(word)) {
//                        lineValue += 2;
//
//                        //check logical and bitwise operator
//                        for (int j = 0; j <= 4; j++) {
//                            if (operatorKeywords[i].equals(word)) {
//                                lineValue++;
//                            }
//                        }
//                    }

//                    //for statement keywords
//                    else if (statementKeywords[i].equals(word)) {
//                        //assign value for case and the switch
//                        lineValue += 2;
//                    }
                }catch(ArrayIndexOutOfBoundsException e) {
                    e.printStackTrace();
                }
            }
        }

        //insert into hashmap
//        Ctc.put(lineNumber, lineValue);
    }

    @Override
    public HashMap<Integer, Integer> cGetValues() {
        return Ctc;
    }

    public void printDetails() {
        for (Integer values : Ctc.values()) {
            System.out.println(values);
        }
    }

}
