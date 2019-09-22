package file;
//
//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.pdf.PdfPTable;
//import com.itextpdf.text.pdf.PdfWriter;
//
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

import static file.FileUploadServlet.factorList;
//
//@WebServlet("/download")
//public class download extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//
//        String data = "";
//        Document document = new Document();
//
//        try {
//            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("report.pdf"));
//            document.open();
//
//            //heading
//            document.add(new Paragraph("Generated  Report"));
//
//
//            //iterate line by line
//            for (ComplexityFactors cf : factorList) {
//                data = cf.getNoOfLines() + cf.getLine()
//                        + " cs: " + cf.getCs()
//                        + "ctc: "+ cf.getCi()
//                +"cnc: "+cf.getCnc()
//                        + " ci:" + cf.getCi()
//                +"tw: "+cf.getTW()
//                +"cps: "+ cf.getCps()
//                +"cr: "+cf.getCr();
//                document.add(new Paragraph(data));
//            }
//            document.close();
//            writer.close();
//        } catch (DocumentException e) {
//            e.printStackTrace();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//}


@WebServlet("/download")
public class download extends HttpServlet{

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{

        String fileName = "report.pdf";
        FileInputStream fileInputStream = null;
        OutputStream responseOutputStream = null;
        try
        {
            String filePath = request.getServletContext().getRealPath("/WEB-INF/resources/")+ fileName;
            File file = new File(filePath);

            String mimeType = request.getServletContext().getMimeType(filePath);
            if (mimeType == null) {
                mimeType = "application/pdf";
            }
            response.setContentType(mimeType);
            response.addHeader("Content-Disposition", "attachment; filename=" + fileName);
            response.setContentLength((int) file.length());

            fileInputStream = new FileInputStream(file);
            responseOutputStream = response.getOutputStream();
            int bytes;
            while ((bytes = fileInputStream.read()) != -1) {
                responseOutputStream.write(bytes);
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            fileInputStream.close();
            responseOutputStream.close();
        }
    }
}