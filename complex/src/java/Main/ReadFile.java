package Main;

import controlStructure.ControlStructure;

import java.io.*;

public class ReadFile implements iReadFile {
    private int noOfLines = 0;
    private ControlStructure cs = new ControlStructure();

    @Override
    public void getFile() {
//        StringBuilder sb = new StringBuilder();

        //control structure object


        try {
            //read the file
//            FileReader reader = new FileReader("C:\\Users\\rusnlk\\Desktop\\SPM\\complex\\src\\resources\\uploadFile.txt");
//            FileReader reader = new FileReader("C:\\Users\\rusnlk\\Desktop\\SPM\\complex\\src\\resources\\uploadFile.txt");
            FileReader reader = new FileReader("src/resources/uploadFile.txt");
//            FileReader reader = new FileReader("uploadFile.txt");
            BufferedReader buff = new BufferedReader(reader);
            String line;

            //iterate line by line
            while ((line = buff.readLine()) != null) {
                noOfLines++;

                //call for size factor**************
                cs.cSetValueForLine(line, noOfLines);
                //call for inheritance factor*********************


            }

            buff.close();
            reader.close();

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
