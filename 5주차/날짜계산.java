import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 날짜계산 {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(bufferedReader.readLine());

        int year = 0;

        int E = Integer.parseInt(stk.nextToken());
        int S = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        int currnetE = 0;
        int currnetS = 0;
        int currnetM = 0;

        while(true){

            year++;

            if(currnetE + 1 < 16){
                currnetE += 1;
            } else{
                currnetE = 1;
            }

            if(currnetS + 1 < 29){
                currnetS += 1;
            } else{
                currnetS = 1;
            }

            if(currnetM + 1 < 20){
                currnetM += 1;
            } else{
                currnetM = 1;
            }

            if(currnetE == E && currnetS == S && currnetM == M){
                bufferedWriter.write(Integer.toString(year));
                break;
            }

        }

        bufferedWriter.flush();
        bufferedWriter.close(); 
        bufferedReader.close();

    }
    
}
