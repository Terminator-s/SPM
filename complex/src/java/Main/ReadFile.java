package Main;

import controlStructure.ControlStructure;
import controlStructure.Nested;
import controlStructure.iControlStructure;
import inheritance.Inheritance;
import org.json.simple.parser.ParseException;
import size.SizeFactor;

import java.io.*;

public class ReadFile implements iReadFile {
       int noOfLines = 0;
     iControlStructure cs = new ControlStructure();

    @Override
    public void getFile() throws IOException, ParseException {
//        StringBuilder sb = new StringBuilder();

        //control structure object
        int noOfLines = 0;
        SizeFactor size = new SizeFactor();
        TotalComplexity tc=new TotalComplexity();

        //read the file
        FileReader reader = new FileReader("src/resources/EmployeeService.java");
        BufferedReader buff = new BufferedReader(reader);
        String line;

        //iterate line by line
        while ((line = buff.readLine()) != null) {
            noOfLines++;

            /* call for size factor************** */
            size.checkLineForTokens(line);
            int Cs = size.getTotalCs();

            Nested ns = new Nested();
            int Cnc=ns.getCNC();

            ControlStructure controlStructure = new ControlStructure();
            int Ctc = controlStructure.getCTC(line,noOfLines);

            Inheritance inheritance = new Inheritance();
            int Ci = inheritance.calculateCi(line);


            int Tw =tc.calculateTotalweight(Ctc,Cnc,Ci);
            int Cps=tc.calculateCps(Cs,Tw);



            System.out.println(line + "\t\tCS:"+ Cs + "\t\tTW:" + Tw  +"\t\tCPS:" + Cps+ "\t\tCNC:" +Cnc +"\t\tCTC:"+Ctc +"\t\tCI:"+Ci);


        }

        buff.close();
        reader.close();

        System.out.println("number of lines are: "+noOfLines);

    }
}
