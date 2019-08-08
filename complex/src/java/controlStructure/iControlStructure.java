package controlStructure;

import java.util.HashMap;

public interface iControlStructure {
    void cSetValueForLine(String inputLine, int lineNumber);
    HashMap<Integer, Integer> cGetValues();
}
