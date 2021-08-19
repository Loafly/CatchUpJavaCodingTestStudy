import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayList;

public class 피보나치수4 {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int fn = Integer.parseInt(bufferedReader.readLine());

        if(fn == 0){
            bufferedWriter.write(String.valueOf(0));
        } else if(fn == 1){
            bufferedWriter.write(String.valueOf(1));
        } else{
            ArrayList<BigInteger> dp = new ArrayList<>();

            dp.add(BigInteger.ZERO);
            dp.add(BigInteger.ONE);

            for(int i = 2; i < fn + 1; i++){
                dp.add(dp.get(i - 1).add(dp.get(i - 2)));
            }

            bufferedWriter.write(String.valueOf(dp.get(dp.size() - 1)));
        }
        
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
    
}
