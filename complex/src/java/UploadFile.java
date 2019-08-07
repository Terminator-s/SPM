import java.io.*;

public class UploadFile implements iUploadFile {

    @Override
    public void getFile(File uploadFile) {
        StringBuilder sb = new StringBuilder();
        try

        {
            FileReader reader = new FileReader("C:\\Users\\rusnlk\\Desktop\\EmployeeService.java");
            BufferedReader buff = new BufferedReader(reader);
            String line = null;
            while ((line = buff.readLine()) != null) {
                sb.append(line);
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
