import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public enum Difficulty {
    VERY_EASY,
    EASY,
    VERY_HARD,
    INSANE,
    HOPELESS;
    public void print_XML(PrintWriter a){
        a.println("<Difficulty>" + this.toString() + "</Difficulty>");
        a.flush();
    }

    public static Difficulty readerDif(String b) throws IOException {
        Difficulty TempDif = null;

        b = MyFun.SubAndDelSpac(b, ">", "</");

        if(b.isEmpty())
            TempDif = null;
        else
            TempDif = TempDif.valueOf(b);



        return TempDif;
    }

}