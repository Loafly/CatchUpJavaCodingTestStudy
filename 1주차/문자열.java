import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열 {
    public static void main(String[] args) throws IOException {
        // 
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        int length = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < length ; i++){
            String string = new String();
            string = bufferedReader.readLine();
            
            char start = string.charAt(0);
            char end = string.charAt(string.length() - 1);

            System.out.println(Character.toString(start) + Character.toString(end));
        }

        bufferedReader.close();

    }
}