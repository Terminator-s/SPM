package controlStructure;

import file.Stacks;

import java.util.EmptyStackException;
import java.util.StringTokenizer;

public class ControlStructure{
    private int lineValue;
    private String[] conditionalKeywords = {"if(", "if", "else"};
    private String[] iterativeKeywords = {"while", "while(", "for(", "for", "do-while(", "do-while", "foreach", "foreach("};
    private String[] caseKeyword = {"case"};
    private String[] switchKeyword = {"switch"};
    private String[] operatorKeywords = {"&&", "||", "&", "|"};

    public ControlStructure() {
        lineValue = 0;
    }

    public int getCTC(String inputLine, int lineNumber, Stacks stack) {
        String word;
        boolean condition = false;
        boolean iterative = false;
        boolean operator = false;
        boolean switchFound = false;
        int count = 0;



        StringTokenizer stTokenizer = new StringTokenizer(inputLine);
        while (stTokenizer.hasMoreTokens()) {

            //break words in each line
            word = stTokenizer.nextToken();

            //for checking conditional keywords
            for (int i = 0; i < conditionalKeywords.length; i++) {
                if (conditionalKeywords[i].equals(word)) {
                    lineValue++;
                    condition = true;
                }
            }

            //for checking iterative keywords
            for (int i = 0; i < iterativeKeywords.length; i++) {
                if (iterativeKeywords[i].equals(word)) {
                    iterative = true;
                    lineValue = lineValue + 2;
                }
            }

            //for checking operator keywords
            for (int i = 0; i < operatorKeywords.length; i++) {
                if (operatorKeywords[i].equals(word)) {
                    operator = true;
                    count++;
                }
            }

            //for checking switch keyword
            for (int i = 0; i < switchKeyword.length; i++) {
                if (switchKeyword[i].equals(word)) {
//                    switchFound = true;
//                    vh.setLineNo(lineNumber, switchFound);
                    stack.setLineNo(lineNumber);
                    stack.push("s");
                }
            }

            //for checking case keyword
            for (int i = 0; i < caseKeyword.length; i++) {
                if (caseKeyword[i].equals(word)) {
                    lineValue += 1;
                    stack.setCaseCount();
                }
            }

            if (word.equals("{")) {
                stack.push("{");
            }

            if (word.equals("}")) {
                try {
                    stack.pop();
                    if ("s".equals(stack.peek())) {
                        stack.setUpdateValue();
                    }
                }catch (NullPointerException e){
                    e.printStackTrace();
                }catch (EmptyStackException es){
                    es.printStackTrace();
                }
            }
        }

        if (condition && operator) {
            lineValue += count;
        } else if (iterative && operator) {
            lineValue += count * 2;
        }

        return lineValue;
    }
}