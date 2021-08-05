import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 저울 {
    public static void main(String[] args) throws NumberFormatException, IOException{

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int length = Integer.parseInt(bufferedReader.readLine());
        int[] array = new int[length];

        StringTokenizer stk = new StringTokenizer(bufferedReader.readLine());

        for(int i = 0; stk.hasMoreTokens(); i ++){
            array[i] = Integer.parseInt(stk.nextToken());
        }
    }
    
}
