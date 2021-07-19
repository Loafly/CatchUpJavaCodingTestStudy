import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 콘테스트 {
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = 10;
        int highScoreNumber = 3;

        int[] wScore = new int[size];
        int[] kScore = new int[size];

        int wSum = 0;
        int kSum = 0;

        for(int i = 0; i < size * 2; i++){
            if(i < size){
                wScore[i] = Integer.parseInt(bufferedReader.readLine());
            }
            else{
                kScore[i - size] = Integer.parseInt(bufferedReader.readLine());
            }
        }
        

        Arrays.sort(wScore);
        Arrays.sort(kScore);

        for(int i = 0; i < highScoreNumber * 2; i++){
            if(i < highScoreNumber){
                wSum += wScore[size - i - 1];
            }
            else{
                kSum += kScore[size - (i - highScoreNumber) - 1];
            }
        }
        
        bufferedWriter.write(String.valueOf(wSum) + " " + String.valueOf(kSum));

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}