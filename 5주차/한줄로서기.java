import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 한줄로서기 {
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int length = Integer.parseInt(bufferedReader.readLine());

        int[] arrayLine = new int[length];
        List<Integer> arrayList = new ArrayList<Integer>();

        for(int i = 0; i < length; i++){
            arrayList.add(i);
        }

        StringTokenizer stk = new StringTokenizer(bufferedReader.readLine());

        for(int i = 0; i < length; i++){
           int leftUp = Integer.parseInt(stk.nextToken());

           int index = arrayList.get(leftUp);
           arrayList.remove(leftUp);

           arrayLine[index] = i;
        }

        for(int value : arrayLine){
            bufferedWriter.write(String.valueOf(value + 1) + " ");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();         
    }
    
}
