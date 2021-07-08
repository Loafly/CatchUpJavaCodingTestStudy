import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class 전화번호목록 {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int length = Integer.parseInt(bufferedReader.readLine());
        List<String> arrayList = new ArrayList<>();

        for (int i = 0; i < length; i++){
            int phoneCount = Integer.parseInt(bufferedReader.readLine());
            String answer = "YES";
            for (int j = 0; j < phoneCount; j++){
                arrayList.add(bufferedReader.readLine());
            }

            Collections.sort(arrayList);

            for (int j = 1; j < arrayList.size(); j++){
                String currentString = arrayList.get(j);
                String preString = arrayList.get(j - 1);
                if(currentString.length() > preString.length() && currentString.startsWith(preString)){
                    answer = "NO";
                    break;
                }
            }

            bufferedWriter.write(answer + "\n");

            arrayList.clear();
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
    
}
