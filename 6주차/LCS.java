import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class LCS {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String firstString = bufferedReader.readLine();
        String secondString = bufferedReader.readLine();

        int[][] LCS = new int[firstString.length() + 1][secondString.length() + 1];

        int answer = 0;

        for(int i = 1; i < firstString.length() + 1; i++){
            for(int j = 1; j < secondString.length() + 1; j++){
                if((firstString.charAt(i - 1) == secondString.charAt(j - 1)) && (LCS[i][j] < j && LCS[i][j] < i)){
                    LCS[i][j] = LCS[i - 1][j - 1] + 1;

                    if(answer < LCS[i][j]){
                        answer = LCS[i][j];
                    }
                } else{
                    if(LCS[i - 1][j] >= LCS[i][j - 1]){
                        LCS[i][j] = LCS[i - 1][j];
                    } else{
                        LCS[i][j] = LCS[i][j - 1];
                    }
                }
            }
        }
        for(int i = 1; i < firstString.length() + 1; i++){
            for(int j = 1; j < secondString.length() + 1; j++){
                System.out.print(LCS[i][j]);
            }
            System.out.println();
        }


        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
    
}
