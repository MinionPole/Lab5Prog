import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Coordinates {
    private Long x; //Поле не может быть null
    private Float y; //Значение поля должно быть больше -836, Поле не может быть null

    public void print_XML(PrintWriter a){
        a.println("<Coordinates>");
        a.println("<x>" + x.longValue() + "</x>");
        a.println("<y>" +y.doubleValue() + "</y>");
        a.println("</Coordinates>");
        a.flush();
    }

    public static Coordinates readerFiles(BufferedReader reader) throws IOException {
        Coordinates TempC = new Coordinates();

        while(reader.ready()){
            String b = reader.readLine();
            if(b.indexOf("<x>") != -1){
                TempC.x = MyFun.retCorrectLong(b, "x", -(1 << 31), ">", "</");
                continue;
            }
            if(b.indexOf("<y>") != -1){
                TempC.y = Float.valueOf(MyFun.retCorrectFloat(b, "y", -836, ">", "</"));
                break;
            }

        }

        return TempC;
    }

}