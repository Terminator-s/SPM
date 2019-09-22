package size;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static size.SizeFactorKeywords.*;

public class SizeFactor {

    private String token="";
    private int points;
    private String accesModifier[] ={"private","public"};
    private List<String>wordToken = new ArrayList<>();



    public int calculateTotalCs(String line) throws IllegalAccessException {

        StringTokenizer stTokenizer = new StringTokenizer(line);
        while (stTokenizer.hasMoreTokens()) {

            wordToken.add(stTokenizer.nextToken());
        }

        check(arithmeticOperators);
        check(logicalOperators);
        check(relationOperators);
        check(bitwiseOperators);
        check(miscellaneousOperators);
        check(assignmentOperators);
        check(keyWords);
        check(manipulators);
        checkSpecial(specialKeywords,line);
        checkMethodName(line);
        checkReference(dataTypes,line);
        checkVariable(dataTypes,line);
        checkException();
        return points;
    }

    public void checkMethodName(String line) {

        if(line.contains("public")){
                for (String s : wordToken) {
                    if (s.contains("(") && s.contains(")")) {

                        String token = s.substring(0,s.indexOf("("));
                        setToken(token);
					    points++;
                    }
                }

            }

        }

    public void checkReference(String arr[],String line) {

        Pattern reference = Pattern.compile("(\\B&[ ]\\B)");
        Matcher m = reference.matcher(line);
        if(m.find()){
            points+=2;
            setToken(m.group());

        }
        for (String s : wordToken) {
            for (String keys : arr) {
                if (wordToken.equals(keys)) {
                     Pattern pointer =Pattern.compile("([*]\\s\\w)");
                    Matcher m1 = pointer.matcher(line);
                    if(m1.find()){
                        points+=2;
                        setToken(m.group());

                    }
                }

            }
        }

    }

    public void check(String arr[]) {
        for (String s : wordToken) {
            for (String keys : arr) {
                if (s.equals(keys)) {
                    points++;
                    setToken(keys);
                }
            }
        }
    }

    public void checkSpecial(String arr[],String line){
        for (String s : wordToken) {
            for (String keys : arr) {
                if (s.equals(keys)) {
                    points+=2;
                    setToken(keys);
                }
            }
        }

        String pattern = "\"(.*?)\"";
        // Create a Pattern object
        Pattern r = Pattern.compile(pattern);

        // Now create matcher object.
        Matcher m = r.matcher(line);
        if(m.find()){
            points++;
            setToken(m.group());
            line.replace(m.group(),"");

        }
    }
    public void checkException(){
        for(String token:wordToken){
            if (token.contains("Exception")) {
                points++;
                setToken(token);
            }
        }
    }

    public void checkVariable(String arr[],String line) {
        for (String keys : arr) {
            String pattern = "\\s+\\w+";
            String varPattern = keys + pattern;
            // Create a Pattern object
            Pattern r = Pattern.compile(varPattern);

            // Now create matcher object.
            Matcher m = r.matcher(line);
            if (m.find()) {
                points++;

                setToken(m.group().replace(keys,""));


            }
        }
    }

    public void setToken(String token){
        if(this.token == ""){
            this.token = token;
        }
        else {
            this.token += " "+","+" " + token+" ";
        }
    }

    public String getToken(){

        return token;

    }


}



