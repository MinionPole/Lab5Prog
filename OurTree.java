import java.io.*;
import java.util.Iterator;
import java.util.TreeSet;


public class OurTree {

    TreeSet<LabWork> Labs;

    public OurTree(){
        Labs = new TreeSet<LabWork>();
    }

    public void print_all_labs(PrintWriter a){
        for(LabWork it : Labs){
            it.print_XML(a);
            a.println("________________________________");
            a.flush();
        }
    }

    public void replace_same_ID(LabWork New){
        for(LabWork it : Labs){
            if(it.getId().equals(New.getId())){
                Labs.remove(it);
                Labs.add(New);
                break;
            }
        }
    }

    public void delete_same_ID(Integer ID){
        for(LabWork it : Labs){
            if(it.getId().equals(ID)){
                this.Labs.remove(it);
                break;
            }
        }
    }

    public void readerFiles(BufferedReader reader) throws IOException{
        if(Labs == null)
            Labs = new TreeSet<LabWork>();
        TreeSet<LabWork> retTree = Labs;

        while(reader.ready()){
            String b = reader.readLine();
            if(b.contains("<LabWork>")){
                LabWork temp = null;
                temp = temp.readerFiles(reader);
                retTree.add(temp);

            }
        }

    }

    public void Clear_all_labs(){
        Labs.clear();
    }

    static public void give_help() throws IOException{
//        InputStreamReader testin = new InputStreamReader(new FileInputStream("C:\\Users\\romay\\Desktop\\Лабы\\Программирование\\lab5\\src\\Help.txt"));
        InputStreamReader testin = new InputStreamReader(new FileInputStream("Help.txt"));
        BufferedReader reader = new BufferedReader(testin);
        PrintWriter testout = new PrintWriter(System.out);
        while(reader.ready()){
            String b = reader.readLine();
            testout.println(b);
            testout.flush();
        }
    }

    public void add_if_max(LabWork LW){
        if(Labs.last().compareTo(LW) > 0){
            Labs.add(LW);
        }
    }

    public void add_if_min(LabWork LW){
        if(Labs.first().compareTo(LW) < 0){
            Labs.add(LW);
        }
    }

    public void removerLow(LabWork LW){
        while(Labs.first().compareTo(LW) < 0){
            Labs.remove(Labs.first());
        }
    }

    public float sum_of_minimal_point(){
        float SUM = 0;
        for(LabWork it: Labs){
            SUM += it.getminimalPoint();
        }
        return SUM;
    }

    public void filter_by_difficulty(Difficulty example){

        for(LabWork it: Labs){
            if(it.getDifficulty().equals(example)) {
                PrintWriter testout = new PrintWriter(System.out);
                it.print_XML(testout);
            }
        }

    }

    public void analize(String b) throws IOException {
        if(b.contains("help")){
            OurTree.give_help();
        }

        if(b.contains("remove_by_id")){
            b = b + "{";
            Integer updated_id = MyFun.retCorrectINT(b, "id", -(1 << 31), "d", "{");
            this.delete_same_ID(updated_id);
        }

        if(b.contains("show") || b.contains("print_ascending")){
            this.print_all_labs(new PrintWriter(System.out));
        }

        if(b.contains("add")){

            String path = MyFun.SubAndDelSpac(b, "{", "}");
            while(!MyFun.isCorrectPath(path)){
                System.out.println("не могу открыть файл, введите корректный путь");
                path = MyFun.StandartIn.readLine();
            }
            this.readerFiles(new BufferedReader(new InputStreamReader(new FileInputStream(path))));
        }

        if(b.contains("update")){
            String path = b.substring(b.indexOf('{') + 1, b.indexOf('}'));
            while(!MyFun.isCorrectPath(path)){
                System.out.println("не могу открыть файл, введите корректный путь");
                path = MyFun.StandartIn.readLine();
            }
            LabWork temp = new LabWork();
            temp = LabWork.readerFiles(new BufferedReader(new InputStreamReader(new FileInputStream(path))));
            Integer updated_id = MyFun.retCorrectINT(b, "id", -(1 << 31), "e", "{");
            temp.UpdateId(updated_id);
            this.replace_same_ID(temp);
        }


        if(b.contains("clear")){
            this.Clear_all_labs();
        }

        if(b.contains("save")){
            //String ForSaveS = "C:\\Users\\romay\\Desktop\\Лабы\\Программирование\\lab5\\src\\ForSave";
            String ForSaveS = "ForSave";
            this.print_all_labs(new PrintWriter(new FileOutputStream("ForSaveS")));
        }

        if(b.contains("execute_script")){
            b = b + '}';
            b = MyFun.SubAndDelSpac(b, " ", "}");
            MyFun.AlwaysReader(new BufferedReader(new InputStreamReader(new FileInputStream(b))), this);
        }

        if(b.contains("add_if_max")){
            String path = b.substring(b.indexOf('{') + 1, b.indexOf('}'));
            while(!MyFun.isCorrectPath(path)){
                System.out.println("не могу открыть файл, введите корректный путь");
                path = MyFun.StandartIn.readLine();
            }
            LabWork temp = new LabWork();
            temp = LabWork.readerFiles(new BufferedReader(new InputStreamReader(new FileInputStream(path))));
            this.add_if_max(temp);
       }
        if(b.contains("add_if_min")){
            String path = b.substring(b.indexOf('{') + 1, b.indexOf('}'));
            while(!MyFun.isCorrectPath(path)){
                System.out.println("не могу открыть файл, введите корректный путь");
                path = MyFun.StandartIn.readLine();
            }
            LabWork temp = new LabWork();
            temp = LabWork.readerFiles(new BufferedReader(new InputStreamReader(new FileInputStream(path))));
            this.add_if_min(temp);
        }
        if(b.contains("remove_lower")){
            String path = b.substring(b.indexOf('{') + 1, b.indexOf('}'));
            while(!MyFun.isCorrectPath(path)){
                System.out.println("не могу открыть файл, введите корректный путь");
                path = MyFun.StandartIn.readLine();
            }
            LabWork temp = new LabWork();
            temp = LabWork.readerFiles(new BufferedReader(new InputStreamReader(new FileInputStream(path))));
            this.removerLow(temp);
        }

        if(b.contains("sum_of_minimal_point")){
            System.out.println(this.sum_of_minimal_point());
        }


    }



}
