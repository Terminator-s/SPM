package file;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "FileUploadServlet")
@MultipartConfig
public class FileUploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public static List<ComplexityFactors> factorList = new ArrayList<>();
    static Stacks stacks = new Stacks();
    static Stacks nStack = new Stacks();
    static Stacks cStack = new Stacks();

    public FileUploadServlet(){
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        InputStream inputStream = null;
        String line;
        // obtains the upload file part in this multipart request
        Part filePart = request.getPart("codeFile");
        String name = filePart.getName();
        int noOfLines = 1;
        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());

            // obtains input stream of the file
            inputStream = filePart.getInputStream();
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        boolean found = false;

        while ((line = reader.readLine()) != null) {
            if (line.contains("//")){
                line = line.substring(0,line.indexOf("//"));
            }

            if (line.contains("*/")){
                found = false;
                continue;
            }
            if(found){
                continue;
            }
            if (line.contains("/*")){
                found = true;
                continue;
            }

            ComplexityFactors factor = new ComplexityFactors(line,name,noOfLines);
            //set each complexity factor to the object by calling setter
            if (!(line.contains("/*") || line.contains("*/"))){
                try {
                    factor.setCs();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                factor.setCtc(stacks);
                factor.setCnc(nStack,cStack);
                factor.setCi();
                factor.setTW();
                factor.setCps();
                factor.setCr();
                factor.setCp();
            }

            factorList.add(factor);
            noOfLines++;


        }

        request.setAttribute("factors",factorList);
        RequestDispatcher rd=  request.getRequestDispatcher("ViewTotalComplexity.jsp");
        rd.forward(request,response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
