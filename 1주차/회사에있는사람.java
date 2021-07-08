import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;


public class 회사에있는사람 {
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(bufferedReader.readLine());

        TreeSet<String> enterList = new TreeSet<>();

        for (int i = 0; i < length; i++){
            String[] string = bufferedReader.readLine().split(" ");

            if (string[1].equals("enter")){
                enterList.add(string[0]);
            }
            else {
                enterList.remove(string[0]);
            }
        }

        for(String enter : enterList.descendingSet())
        {
            System.out.println(enter);
        }

        

    }
    
}
