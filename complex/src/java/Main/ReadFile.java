package Main;//import controlStructure.ControlStructure;

import Recursion.Recursion;
import org.json.simple.parser.ParseException;
import size.SizeFactor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile  {
//    private File uploadFile = null;


    public static void main(String[] args) throws IOException, ParseException {
//    @Override
//    public void getFile(File uploadFile) throws IOException, ParseException {
//        StringBuilder sb = new StringBuilder();

        //control structure object
        int noOfLines = 0;
        SizeFactor size = new SizeFactor();
        Recursion recursion = new Recursion();
        TotalComplexity tc=new TotalComplexity();

        //ControlStructure cs = new ControlStructure();
            //read the file
            FileReader reader = new FileReader("C:\\Users\\Vishali\\Documents\\GitHub\\SPM\\complex\\src\\resources\\EmployeeService.java");
            BufferedReader buff = new BufferedReader(reader);
            String line;

            //iterate line by line
            while ((line = buff.readLine()) != null) {
                noOfLines++;

                /* call for size factor************** */
                size.checkLineForTokens(line);
                int Cs = size.getTotalCs();

                int Tw =tc.calculateTotalweight(4,5,6);
                int Cps=tc.calculateCps(Cs,Tw);

                int Cr = recursion.getTotalCr();

                System.out.println(line + "\t\t"+ Cs + "\t\t" + Cr + "\t\t" + Tw + "\t\t" + Cps );



                //cs.cSetValueForLine(line,noOfLines);
                //call for inheritance factor*********************



            }

            buff.close();
            reader.close();

            System.out.println("number of lines are: "+noOfLines);

    }
}
