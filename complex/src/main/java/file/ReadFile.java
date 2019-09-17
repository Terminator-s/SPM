package file;

import controlStructure.ControlStructure;
<<<<<<< HEAD:complex/src/java/Main/ReadFile.java
=======
import controlStructure.Nested;
import controlStructure.iControlStructure;
import inheritance.Inheritance;
//import org.json.simple.parser.ParseException;
>>>>>>> added html files:complex/src/main/java/file/ReadFile.java

import java.io.*;
import java.text.ParseException;

public class ReadFile implements iReadFile {
    private int noOfLines = 0;
    private ControlStructure cs = new ControlStructure();

    @Override
    public void getFile() {
//        StringBuilder sb = new StringBuilder();

        //control structure object
<<<<<<< HEAD:complex/src/java/Main/ReadFile.java
=======
        int noOfLines = 0;
//        SizeFactor size = new SizeFactor();
        TotalComplexity tc=new TotalComplexity();
>>>>>>> added html files:complex/src/main/java/file/ReadFile.java


        try {
            //read the file
//            FileReader reader = new FileReader("C:\\Users\\rusnlk\\Desktop\\SPM\\complex\\src\\resources\\uploadFile.txt");
//            FileReader reader = new FileReader("C:\\Users\\rusnlk\\Desktop\\SPM\\complex\\src\\resources\\uploadFile.txt");
            FileReader reader = new FileReader("src/resources/uploadFile.txt");
//            FileReader reader = new FileReader("uploadFile.txt");
            BufferedReader buff = new BufferedReader(reader);
            String line;

<<<<<<< HEAD:complex/src/java/Main/ReadFile.java
            //iterate line by line
            while ((line = buff.readLine()) != null) {
                noOfLines++;
=======
            /* call for size factor************** */
//            size.checkLineForTokens(line);
//            int Cs = size.getTotalCs();
>>>>>>> added html files:complex/src/main/java/file/ReadFile.java

                //call for size factor**************
                cs.cSetValueForLine(line, noOfLines);
                //call for inheritance factor*********************


<<<<<<< HEAD:complex/src/java/Main/ReadFile.java
            }

            buff.close();
            reader.close();
=======
            Inheritance inheritance = new Inheritance();
            int Ci = inheritance.calculateCi(line);


            int Tw =tc.calculateTotalweight(Ctc,Cnc,Ci);
//            int Cps=tc.calculateCps(Cs,Tw);



//            System.out.println(line + "\t\tCS:"+ Cs + "\t\tTW:" + Tw  +"\t\tCPS:" + Cps+ "\t\tCNC:" +Cnc +"\t\tCTC:"+Ctc +"\t\tCI:"+Ci);
            System.out.println(line + "\t\tTW:" + Tw + "\t\tCNC:" +Cnc +"\t\tCTC:"+Ctc +"\t\tCI:"+Ci);
>>>>>>> added html files:complex/src/main/java/file/ReadFile.java

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printTable() {
        cs.printDetails();
        System.out.println("number of lines are: " + noOfLines);
    }
}
