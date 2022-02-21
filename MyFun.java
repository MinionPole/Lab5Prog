import java.io.*;

public class MyFun {

    static InputStreamReader StandartInReader = new InputStreamReader(System.in);
    static BufferedReader StandartIn = new BufferedReader(StandartInReader);

    public static String SubAndDelSpac(String b, String fs, String sec){
        b = (b.substring(b.indexOf(fs) + 1, b.indexOf(sec)));
        b = b.replaceAll(" ", "");
        return b;
    }

    public static boolean isFloat(String s) throws NumberFormatException {
        try {
            Float.parseFloat(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isINT(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isLong(String s) throws NumberFormatException {
        try {
            Long.parseLong(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static float retCorrectFloat  (String b, String par, int min_gr, String fs, String sec)throws IOException{
        float temp=0;
        
        while(true){
            b = MyFun.SubAndDelSpac(b, fs, sec);

            if(MyFun.isFloat(b) && Float.parseFloat(b) > min_gr){
                temp = Float.parseFloat(b);
                break;
            }
            else {
                System.out.println("В " + par + " введено неверное значение, введите иное в том же формате");
                b = MyFun.StandartIn.readLine();
            }
        }
        return temp;
    }

    public static int   retCorrectINT  (String b, String par, int min_gr, String fs, String sec)throws IOException{
        int temp=0;
        while(true){
            b = MyFun.SubAndDelSpac(b, fs, sec);

            if(MyFun.isINT(b) && Integer.parseInt(b) > min_gr){
                temp = Integer.parseInt(b);
                break;
            }
            else {
                System.out.println("В " + par + " введено неверное значение, введите иное в том же формате");
                b = MyFun.StandartIn.readLine();
            }
        }
        return temp;
    }

    public static Long retCorrectLong  (String b, String par, int min_gr, String fs, String sec)throws IOException{
        long temp=0;
        while(true){
            b = MyFun.SubAndDelSpac(b, fs, sec);

            if(MyFun.isLong(b) && Long.parseLong(b) > min_gr){
                temp = Long.parseLong(b);
                break;
            }
            else {
                System.out.println("В " + par + " введено неверное значение, введите иное в том же формате");
                b = MyFun.StandartIn.readLine();
            }
        }
        return temp;
    }

    public static String retCorrectName  (String b, String fs, String sec)throws IOException{
        while(true){
            b = MyFun.SubAndDelSpac(b, fs, sec);
            if(ISNULL(b)){
                System.out.println("В name введено неверное значение, введите иное в том же формате");
                b = MyFun.StandartIn.readLine();
            }
            else {
                break;
            }
        }
        return b;
    }

    public static boolean ISNULL(String b){
        return b.isEmpty() || b == "NULL" || b == "null";
    }

    public static boolean isCorrectPath(String s) throws IOException {
        try {
            InputStreamReader testin = new InputStreamReader(new FileInputStream(s));
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static void AlwaysReader(BufferedReader reader, OurTree MainTree) throws IOException{
        while(true){
            String b;
            b = reader.readLine();

            if(b.contains("exit")) {
                System.out.flush();
                break;
            }
            else
                MainTree.analize(b);
        }

    }

}
