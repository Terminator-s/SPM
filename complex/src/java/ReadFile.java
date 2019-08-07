import controlStructure.ControlStructure;

import java.io.*;

public class UploadFile implements iUploadFile {
    File uploadFile = null;
    int noOfLines = 0;

    @Override
    public void getFile(File uploadFile) {
        StringBuilder sb = new StringBuilder();

        ControlStructure cs = new ControlStructure();
        try{
            //read the file
            FileReader reader = new FileReader("C:\\Users\\rusnlk\\Desktop\\EmployeeService.java");
            BufferedReader buff = new BufferedReader(reader);
            String line = null;

            //iterate line by line
            while ((line = buff.readLine()) != null) {

                //call for size factor
                cs.getValueForLine();
                //call for inheritance factor


                noOfLines++;
            }

            buff.close();
            reader.close();

        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            System.out.println(e);
        }
    }
}
