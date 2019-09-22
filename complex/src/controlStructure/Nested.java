package controlStructure;


import file.Stacks;

import java.util.EmptyStackException;
import java.util.StringTokenizer;

public class Nested {
    private int lineValue;
    private String[] conditionalKeywords = {"if(", "else{", "if", "else"};
    private String[] iterativeKeywords = {"while", "while(", "for(", "for", "do-while(", "do-while", "foreach", "foreach("};
    private String[] caseKeyword = {"case"};
    private String[] switchKeyword = {"switch", "switch{"};
    private String[] operatorKeywords = {"&&", "||", "&", "|"};


    public Nested() {
        this.lineValue = 0;
    }

    public int getCNC(String inputLine, int lineNumber, Stacks ns, Stacks cs) {
        String word;

        StringTokenizer stTokenizer = new StringTokenizer(inputLine);
        while (stTokenizer.hasMoreTokens()) {
            //break words in each line
            word = stTokenizer.nextToken();

            //for checking conditional keywords
            for (int i = 0; i < conditionalKeywords.length; i++) {
                if (conditionalKeywords[i].equals(word)) {
                    lineValue++;
                    cs.push("c");
                }
            }

            //for checking iterative keywords
            for (int i = 0; i < iterativeKeywords.length; i++) {
                if (iterativeKeywords[i].equals(word)) {
                    lineValue++;
                    cs.push("c");
                }
            }

            if (word.equals("{")) {
                ns.push("{");
            }

            if (word.equals("}")) {
                try {
                    ns.pop();
                    if ("c".equals(cs.peek())) {
                        cs.nSetUpdateValue();
                    }
                    if ("if".equals(cs.peek())) {
                        cs.nSetUpdateValue();
                    }
                }catch (NullPointerException e){
                    e.printStackTrace();
                }catch (EmptyStackException es){
                    es.printStackTrace();
                }
            }
        }
        return lineValue;
    }

}