package Main;

//import controlStructure.ControlStructure;

import java.io.*;

 public class ReadFile implements iReadFile {
//    private File uploadFile = null;
    private int noOfLines = 0;

    @Override
    public void getFile(File uploadFile) {
//        StringBuilder sb = new StringBuilder();

        //control structure object
        //ControlStructure cs = new ControlStructure();

        try{
            //read the file
            FileReader reader = new FileReader("C:\\Users\\rusnlk\\Desktop\\EmployeeService.java");
            BufferedReader buff = new BufferedReader(reader);
            String line;

            //iterate line by line
            while ((line = buff.readLine()) != null) {
                noOfLines++;

                //call for size factor**************
                //cs.cSetValueForLine(line,noOfLines);
                //call for inheritance factor*********************

               /* // call getTotalCs methode from Sizefactor for Cs calculation
                Sizefactor cs =  new Sizefactor();
                Cs = cs.getTotalCs();

                // Call getCtc methode from controlStructure for Ctc calculation
                controlStructure ctc =  new controlStructure();
                Ctc = ctc.getCTC();

                // Call getCnc methode from controlStructure for Ctc calculation
                controlStructure cnc =  new controlStructure();
                Cns =  cnc.getCNS();

                // Call getCi methode from inheritanceController for Ctc calculation
                // inheritanceController ci =  new inheritanceController();
                // Ci =  ci.getCNS();

                */





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
