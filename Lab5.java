import java.io.*;
import java.util.TreeSet;


public class Lab5 {




    public static void main(String[] args) throws IOException {
        String FL = args[0];

        while(!MyFun.isCorrectPath(FL)){
            System.out.println("не могу открыть файл, введите корректный путь");
            FL = MyFun.StandartIn.readLine();
        }




        OurTree MainTree = new OurTree();

        InputStreamReader testin = new InputStreamReader(new FileInputStream(FL));
        BufferedReader reader = new BufferedReader(testin);

        MainTree.readerFiles(reader);
        reader.close();


        MyFun.AlwaysReader(new BufferedReader(new InputStreamReader(System.in)), MainTree);



        //MainTree.analize("execute_script C:\\Users\\romay\\Desktop\\Лабы\\Программирование\\lab5\\src\\SimpleCom");

        /*
        исполнить скрипт
       String FL2 = "C:\\Users\\romay\\Desktop\\Лабы\\Программирование\\lab5\\src\\SimpleCom";
       MyFun.AlwaysReader(new BufferedReader(new InputStreamReader(new FileInputStream(FL2))), MainTree);
        */


        /*
        //печать коллекции
        PrintWriter testout = new PrintWriter(System.out);
        MainTree.print_all_labs(testout);
        */






    }
}
