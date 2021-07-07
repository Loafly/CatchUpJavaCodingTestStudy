import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 전화번호목록 {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(bufferedReader.readLine());
        List<String> arrayList = new ArrayList<>();

        for (int i = 0; i < length; i++){
            int phoneCount = Integer.parseInt(bufferedReader.readLine());
            String answer = "YES";
            for (int j = 0; j < phoneCount; j++){
                arrayList.add(bufferedReader.readLine());
            }

            Collections.sort(arrayList, Comparator.comparing(String::length));

            for (int j = 0; j < arrayList.size() - 1; j++){
                for (int k = j + 1; k < arrayList.size(); k++){
                    if(arrayList.get(k).startsWith(arrayList.get(j))){
                        answer = "NO";
                    }

                    if (answer.equals("NO")){
                        break;
                    }
                }
                
                if (answer.equals("NO")){
                    break;
                }
            }

            System.out.println(answer);

            arrayList.clear();
        }

        bufferedReader.close();
    }
    
}
