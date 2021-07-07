import java.util.*;
import java.util.Scanner;

public class 전화번호목록 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int length = scanner.nextInt();
        List<String> arrayList = new ArrayList<>();

        for (int i = 0; i < length; i++){
            int phoneCount = scanner.nextInt();
            String answer = "YES";
            for (int j = 0; j < phoneCount; j++){
                arrayList.add(scanner.next());
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

        scanner.close();
        
    }
    
}
