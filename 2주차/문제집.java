import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class 문제집 {
    public static void main(String[] args) throws IOException{

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] temp_string = bufferedReader.readLine().split(" ");
        StringBuilder answer = new StringBuilder();

        int eaxmCount = Integer.parseInt(temp_string[0]);
        int infoCount = Integer.parseInt(temp_string[1]);

        //연결 리스트 생성
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        int[] indegree = new int[eaxmCount + 1];

        for(int i = 0; i < eaxmCount + 1; i++) {
            arrayList.add(new ArrayList<>());
        }

        for(int i = 0; i < infoCount; i++){
            temp_string = bufferedReader.readLine().split(" ");
            int preNode = Integer.parseInt(temp_string[0]);
            int nextNode = Integer.parseInt(temp_string[1]);
           
            indegree[nextNode]++;
            arrayList.get(preNode).add(nextNode);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 1; i <= eaxmCount; i++) {
            if (indegree[i] == 0) {
                pq.offer(i);
            }
        }

        while (!pq.isEmpty()) {
            int now = pq.poll();
            answer.append(now).append(" ");
            ArrayList<Integer> nodes = arrayList.get(now);
            for(int node : nodes) {
                indegree[node] --;

                if(indegree[node] == 0) {
                    pq.offer(node);
                }
            }
        }

        System.out.println(answer.toString());

    }
}