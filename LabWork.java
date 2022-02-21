import com.sun.istack.internal.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.CookieHandler;
import java.time.LocalDateTime;
import java.util.TreeSet;

public class LabWork implements Comparable<LabWork>{
    public static int co_wo = 1; // счётчик работ

    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private float minimalPoint; //Значение поля должно быть больше 0
    private float personalQualitiesMinimum; //Значение поля должно быть больше 0
    private double personalQualitiesMaximum; //Значение поля должно быть больше 0
    private Difficulty difficulty; //Поле может быть null
    private Discipline discipline; //Поле не может быть null

    public LabWork(){
        id = co_wo++;
        creationDate = java.time.LocalDateTime.now();
    }

    public int compareTo(LabWork o){
        if((int)this.name.length() - (int)o.getName().length() != 0)
            return (int)this.name.length() - (int)o.getName().length();
        return id.intValue() - o.getId().intValue();
    }

    public String getName(){
        return name;
    }
    public Integer getId(){
        return id;
    }
    public float getminimalPoint (){return minimalPoint;}
    public Difficulty getDifficulty (){
        return difficulty;
    }
    public void UpdateId (Integer ID){this.id = ID;};


    public static LabWork readerFiles(BufferedReader reader) throws IOException {
        LabWork TempWork = new LabWork();

        while(reader.ready()){
            String b = reader.readLine();


            if(b.contains("<Coordinates>")){
                TempWork.coordinates = Coordinates.readerFiles(reader);
                continue;
            }
            if(b.contains("<Difficulty>")){
                TempWork.difficulty = Difficulty.readerDif(b);
                continue;
            }
            if(b.contains("<Discipline>")){
                TempWork.discipline = Discipline.readerFiles(reader);
                break;
            }

            if(b.contains("<name>")){
                TempWork.name = MyFun.retCorrectName(b, ">", "</");
                continue;
            }

            if(b.contains("<minimalPoint>")){
                TempWork.minimalPoint = MyFun.retCorrectFloat(b, "minimalPoint", 0, ">", "</");
            }

            if(b.contains("<personalQualitiesMinimum>")){
                TempWork.personalQualitiesMinimum = MyFun.retCorrectFloat(b, "personalQualitiesMinimum", 0, ">", "</");
                continue;
            }

            if(b.contains("<personalQualitiesMaximum>")){
                TempWork.personalQualitiesMaximum = MyFun.retCorrectFloat(b, "personalQualitiesMaximum", 0, ">", "</");
                continue;
            }

        }

        return TempWork;
    }

    public void print_XML(PrintWriter a){
        a.println("<LabWork>");
        a.println("<id>" + id.toString() + "</id>");
        a.println("<name>" + name + "</name>");
        coordinates.print_XML(a);
        a.println("<creationDate>" + creationDate + "</creationDate>");
        a.println("<minimalPoint>" + minimalPoint+ "</minimalPoint>");
        a.println("<personalQualitiesMinimum>" + personalQualitiesMinimum+ "</personalQualitiesMinimum>");
        a.println("<personalQualitiesMaximum>" + personalQualitiesMaximum+ "</personalQualitiesMaximum>");
        if(difficulty == null)
            a.println("<Difficulty>  </Difficulty>");
        else
            difficulty.print_XML(a);
        discipline.print_XML(a);
        a.println("</LabWork>");
        a.flush();
    }




}