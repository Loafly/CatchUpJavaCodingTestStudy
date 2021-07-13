import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 상근이의여행 {
    public static void main(String[] args) throws IOException{

    //     BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    //     int T = Integer.parseInt(bufferedReader.readLine());
        
    //     for(int i = 0; i < T; i++){
            
    //         String[] temp_string = bufferedReader.readLine().split(" ");

    //         int N = Integer.parseInt(temp_string[0]);
    //         int M = Integer.parseInt(temp_string[1]);

    //         int[] DP = new int[N];

    //         for(int j = 0; j < DP.length; j++){
    //             DP[j] = 10001;
    //         }
    //         DP[0] = 0;
            
    //         Map<Integer, ArrayList<Integer>> load_map = new HashMap<Integer, ArrayList<Integer>>();

    //         for(int j = 0; j < M; j++){
    //             String[] temp_load = bufferedReader.readLine().split(" ");

    //             ArrayList<Integer> arrayList = new ArrayList<Integer>();

    //             int src = Integer.parseInt(temp_load[0]) - 1;
    //             int dest = Integer.parseInt(temp_load[1]) - 1;

    //             if(load_map.containsKey(src)){
    //                 arrayList = load_map.get(src);
    //                 arrayList.add(dest);
    //             } else{
    //                 arrayList.add(dest);
    //             }

    //             load_map.put(src, arrayList);

    //             arrayList = new ArrayList<Integer>();

    //             // 양방향 그래프이기때문에 추가
    //             if(load_map.containsKey(dest)){
    //                 arrayList = load_map.get(dest);
    //                 arrayList.add(src);
    //             } else{
    //                 arrayList.add(src);
    //             }

    //             load_map.put(dest, arrayList);
    //         }

    //         for(int j = 0; j < DP.length; j++){             
    //             ArrayList<Integer> arrayList = load_map.get(j);
    //             for (int k = 0; k < arrayList.size(); k++){
    //                 if(DP[j] + 1 < DP[arrayList.get(k)]){
    //                     DP[arrayList.get(k)] = DP[j] + 1;
    //                 }
    //             }
    //         }

    //         Arrays.sort(DP);

    //         System.out.println("hello = " + DP[DP.length - 1]);
    //     }

    //     bufferedReader.close();

    // }    

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bufferedReader.readLine());
        
        for(int i = 0; i < T; i++){
            
            String[] temp_string = bufferedReader.readLine().split(" ");

            int N = Integer.parseInt(temp_string[0]);
            int M = Integer.parseInt(temp_string[1]);

            for(int j = 0; j < M; j++){
                bufferedReader.readLine();
            }

            System.out.println(N - 1);
        }

        bufferedReader.close();

    }    
}
