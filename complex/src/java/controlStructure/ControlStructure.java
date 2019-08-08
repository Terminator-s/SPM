package controlStructure;


import javax.json.*;
import java.util.HashMap;

public class ControlStructure implements iControlStructure {
    private HashMap<Integer, Integer> Ctc;
    private int lineValue;

    public ControlStructure(){
        Ctc = null;
        lineValue = 0;
    }

    @Override
    public void cSetValueForLine(String inputLine, int lineNumber) {

        //if conditions are present check for operator
        //if()

        //accessing the JSON file
        JsonReader jsonReader = Json.createReader(getClass().getClassLoader().getResourceAsStream("controlStructureFactors.json"));
        JsonObject jsonObject = jsonReader.readObject();

        JsonArray conditional = (JsonArray) jsonObject.get("conditional");

        Ctc.put(lineNumber,lineValue);
    }

    @Override
    public HashMap<Integer, Integer> cGetValues() {
        return Ctc;
    }

}
