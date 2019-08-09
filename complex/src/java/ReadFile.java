import controlStructure.ControlStructure;

import java.io.*;

public class ReadFile implements iReadFile {
//    private File uploadFile = null;
    private int noOfLines = 0;

    @Override
    public void getFile(File uploadFile) {
//        StringBuilder sb = new StringBuilder();

        //control structure object
        Size size = new Size;
        ControlStructure cs = new ControlStructure();

        try{
            //read the file
            FileReader reader = new FileReader("C:\\Users\\rusnlk\\Desktop\\EmployeeService.java");
            BufferedReader buff = new BufferedReader(reader);
            String line;

            //iterate line by line
            while ((line = buff.readLine()) != null) {
                noOfLines++;

                //call for size factor**************
                size.checkLineForTokens(line);
                cs.cSetValueForLine(line,noOfLines);
                //call for inheritance factor*********************



            }

            buff.close();
            reader.close();

            System.out.println("number of lines are: "+noOfLines);

        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
