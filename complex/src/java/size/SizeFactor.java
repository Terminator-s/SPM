package size;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SizeFactor {

    private ArrayList<String> list = new ArrayList<String>();
    private int totalCs;



    public ArrayList<String> getList() {
        return list;
    }

    public void setList(ArrayList<String> list) {
        this.list = list;
    }

    public int getTotalCs() {
        return totalCs;
    }

    public void setTotalCs(int totalCs) {
        this.totalCs = totalCs;
    }

    public void checkLineForTokens(String line) throws FileNotFoundException, IOException, ParseException{

        int Cs=0;

        JSONParser parser =new JSONParser();
        Object obj =parser.parse(new FileReader("C:\\Users\\pavrlk\\eclipse-workspace2\\Test\\resources\\sizeFactors.json") );
        JSONObject jsonObject = (JSONObject) obj;
        Set objectkeys = jsonObject.keySet();

        Iterator iterator = objectkeys.iterator();
        while(iterator.hasNext()) {
            if(iterator.equals("ref")) {
                Cs += checkForRef(line,jsonObject.get(iterator.next()));
                break;
            }

            JSONObject operator = (JSONObject) jsonObject.get(iterator.next());
            Set set = operator.keySet();

            Iterator iter = set.iterator();
            while (iter.hasNext()) {
                JSONArray ids = (JSONArray) operator.get(iter.next());

                for (int i = 0; i < ids.size(); i++) {
                    String id = ids.get(i).toString();
                    if(line.contains(id)) {
                        list.add(id);
                        if(iter.equals("special")) {
                            Cs+=2;
                        } else
                            ++Cs;
                    }
                }

            }
        }

        setTotalCs(Cs);

    }

    public int checkForRef(String line,Object object) {

        int Cs = 0;

        JSONObject jsonObject = (JSONObject) object;

        JSONArray ids = (JSONArray) jsonObject.get("other");

        JSONObject operator = (JSONObject) jsonObject.get("keywords");
        JSONArray type = (JSONArray) operator.get("datatype");
        for (int j=0;j<type.size();j++) {

            for (int i = 0; i < ids.size(); i++) {
                String id = ids.get(i).toString();
                String regexp="int&";
                Pattern pattern = Pattern.compile(regexp, Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(line);
                while(matcher.find()) {
                    if(matcher.start() > 0) {
                        Cs+=2;
                    }
                }
            }

        }

        return Cs;
    }

    public int checkForOther(Object object,String line) {
        int Cs=0;





        return Cs;
    }


}



