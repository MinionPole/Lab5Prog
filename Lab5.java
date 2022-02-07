import java.io.*;
import java.util.TreeSet;


public class Lab5 {




    public static void main(String[] args) throws IOException {
        String FL = args[0];

        while(!MyFun.isCorrectPath(FL)){
            System.out.println("не могу открыть файл, введите корректный путь");
            FL = MyFun.StandartIn.readLine();
        }




        InputStreamReader testin = new InputStreamReader(new FileInputStream(FL));
        BufferedReader reader = new BufferedReader(testin);

        OurTree MainTree = new OurTree();
        MainTree.Labs = MainTree.readerFiles(reader);

        MyFun.AlwaysReader(new BufferedReader(new InputStreamReader(System.in)), MainTree);

        /*PrintWriter testout = new PrintWriter(System.out);
        MainTree.print_all_labs(testout);
        */







    }
}
