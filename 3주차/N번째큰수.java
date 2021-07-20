import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N번째큰수 {
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int length = Integer.parseInt(bufferedReader.readLine());
        int arraySize = 10;

        for(int i = 0; i < length; i++){
            int[] A = new int[arraySize];
            StringTokenizer stk = new StringTokenizer(bufferedReader.readLine());

            for(int j = 0; stk.hasMoreTokens(); j ++){
                A[j] = Integer.parseInt(stk.nextToken());
            }

            Arrays.sort(A);

            bufferedWriter.write(String.valueOf(A[arraySize - 3]) + '\n');
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();

    }
    
}
