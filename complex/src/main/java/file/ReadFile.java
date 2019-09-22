package file;

import controlStructure.ValueHolder;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile implements iReadFile {
    int noOfLines = 0;
    public static List<ComplexityFactors> factorList = new ArrayList<>();
    static Stacks stacks = new Stacks();
    static Stacks nStack = new Stacks();
    static Stacks cStack = new Stacks();


    @Override
    public void getFile() throws IOException, ParseException {
        int noOfLines = 0;


        //read the file
        FileReader reader = new FileReader("src/main/resources/EmployeeService.java");
        BufferedReader buff = new BufferedReader(reader);
        String line;

//        String data = "";

//        Document document = new Document();

//        try {
//            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("report.pdf"));
//            document.open();
            //heading
//            document.add(new Paragraph("Generated  Report"));


            //iterate line by line
            while ((line = buff.readLine()) != null) {
                noOfLines++;
                ComplexityFactors factor = new ComplexityFactors(line, noOfLines);
                factor.setCtc(stacks);
                factor.setCnc(nStack,cStack);
//                factor.setCr();
//            factor.setCi();
                factorList.add(factor);


//            System.out.println(line+ ">>"+ factor.getCtc());
//                data = line + ">> cr >>" + factor.getCr();
//                document.add(new Paragraph(data));
//            }


//            document.close();
//            writer.close();
//        } catch (DocumentException e) {
//            e.printStackTrace();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
        }

        buff.close();
        reader.close();

        for (ComplexityFactors cf : factorList){
            System.out.print(cf.getLine());
            System.out.print(cf.getCnc());
            System.out.print("\n");
        }

//        System.out.println("number of lines are: " + noOfLines);

    }


    public List<ComplexityFactors> getFactorList() {
        return factorList;
    }

    public String data(String data) {
        return data;
    }


}
