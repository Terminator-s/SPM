package Main;

import org.json.simple.parser.ParseException;

import java.io.IOException;

public class mainn {
    public static void main(String[] args) throws IOException, ParseException {
        ReadFile rf = new ReadFile();
        rf.getFile();
    }
}
