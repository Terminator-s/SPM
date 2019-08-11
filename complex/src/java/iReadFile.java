import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface iReadFile {

    void getFile(File uploadFile) throws IOException, ParseException;
}
