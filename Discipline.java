import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Discipline {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private int labsCount;

    public void print_XML(PrintWriter a){
        a.println("<Discipline>");
        a.println("<name>" + name + "</name>");
        a.println("<labsCount>" + labsCount + "</labsCount>");
        a.println("</Discipline>");
        a.flush();
    }
    public static Discipline readerFiles(BufferedReader reader) throws IOException {
        Discipline TempDis = new Discipline();

        while(reader.ready()){
            String b = reader.readLine();

            if(b.indexOf("<name>") != -1){
                TempDis.name = MyFun.retCorrectName(b, ">", "</");
                continue;
            }

            if(b.indexOf("<labsCount>") != -1){
                TempDis.labsCount = MyFun.retCorrectINT(b, "labsCount", -(1<<31), ">", "</");
                break;
            }

        }

        return TempDis;
    }



}

