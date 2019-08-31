package controlStructure;

import java.util.StringTokenizer;

public class ControlStructure implements iControlStructure {
    private int lineValue;
    private String[] conditionalKeywords = {"if(", "else(", "if", "else"};
    private String[] iterativeKeywords = {"while", "while(", "for(", "for", "do-while(", "do-while", "foreach", "foreach("};
    private String[] statementKeywords = {"case:", "case"};
    private String[] operatorKeywords = {"&&", "||", "&", "|"};

    private Nested ns = new Nested();


    public ControlStructure() {
    }

    @Override
    public int getCTC(String inputLine, int lineNumber) {
        String word;
        boolean condition = false;
        boolean iterative = false;
        boolean operator = false;
        int count = 0;
        lineValue = 0;

        StringTokenizer stTokenizer = new StringTokenizer(inputLine);
        while (stTokenizer.hasMoreTokens()) {

            //break words in each line
            word = stTokenizer.nextToken();

            //for checking conditional keywords
            for (int i = 0; i < conditionalKeywords.length; i++) {
                if (conditionalKeywords[i].equals(word)) {
                    lineValue++;
                    ns.add();
                    condition = true;
                }
            }

            //for checking iterative keywords
            for (int i = 0; i < iterativeKeywords.length; i++) {
                if (iterativeKeywords[i].equals(word)) {
                    iterative = true;
                    lineValue++;
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

            if (word.equals("}")){
                ns.remove();
            }
        }


        if (condition && operator) {
            lineValue += count;
        } else if (iterative && operator) {
            lineValue += count;
        }

        return lineValue;
    }
}