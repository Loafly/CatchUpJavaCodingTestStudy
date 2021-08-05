import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 팰린드롬수{
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));


        while(true){
            String string = bufferedReader.readLine();

            if (string.equals("0")){
                break;
            }

            int length = string.length();
            String answer = "yes\n";

            for(int i = 0; i< length / 2; i++){
                char frontChar = string.charAt(i);
                char backChar = string.charAt(length - i - 1);

                if(frontChar != backChar){
                    answer = "no\n";
                    break;
                }
            }

            bufferedWriter.write(answer);
        }

        bufferedWriter.flush();
        bufferedWriter.close(); 
        bufferedReader.close();
        

        

    }
}
