import java.io.*;

import static org.junit.Assert.assertEquals;

import inheritance.Inheritance;
import org.junit.Test;

public class InheritanceTest {

    File file = null;
    String line;
    @Test
    public void test() throws IOException{

        System.out.println("Test method execution started.");
        try{
            BufferedReader reader = new BufferedReader(new FileReader("resource/EmployeeService.java"));
            Inheritance calculation = new Inheritance();
            int actOut;
            int expOut = 1;
            line = reader.readLine();
                actOut = calculation.CheckInheritance(line);
                assertEquals(expOut,actOut);


        }catch(Exception e){
            System.out.println("Error in jTestCalculation.java - " +e);
        }



        System.out.println("End of test method execution.");
    }
}