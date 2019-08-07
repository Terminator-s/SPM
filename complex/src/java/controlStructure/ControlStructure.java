package controlStructure;

import java.util.ArrayList;

public class ControlStructure implements iControlStructure {
    private ArrayList Ctc;

    public ControlStructure(){
        Ctc = null;
    }

    @Override
    public void cSetValueForLine(String input) {

    }

    @Override
    public ArrayList cGetArray() {
        return Ctc;
    }

}
