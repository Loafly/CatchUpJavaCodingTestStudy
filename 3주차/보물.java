import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 보물 {
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int length = Integer.parseInt(bufferedReader.readLine());

        int[] A = new int[length];
        int[] B = new int[length];

        int sum = 0;

        StringTokenizer stk = new StringTokenizer(bufferedReader.readLine());

        for(int i = 0; stk.hasMoreTokens(); i ++){
            A[i] = Integer.parseInt(stk.nextToken());
        }

        stk = new StringTokenizer(bufferedReader.readLine());

        for(int i = 0; stk.hasMoreTokens(); i ++){
            B[i] = Integer.parseInt(stk.nextToken());
        }
        
        Arrays.sort(A);
        Arrays.sort(B);

        for(int i = 0; i < length; i++){
            sum += A[i] * B[length - i - 1];
        }

        bufferedWriter.write(String.valueOf(sum));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();

    }
    
}
