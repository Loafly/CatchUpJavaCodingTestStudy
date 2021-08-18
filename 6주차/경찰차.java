import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 경찰차{
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(bufferedReader.readLine());

        // 위치를 10진법으로 관리
        int policeCurrentIndex = 11;
        int police2CurrentIndex = size * 10 + size;
        int totalMove = 0;
        Queue<Integer> resultQueue = new LinkedList<>();
        ArrayList<Integer> eventList = new ArrayList<Integer>();

        int length = Integer.parseInt(bufferedReader.readLine());

        for(int i = 0; i < length; i++){
            StringTokenizer stk = new StringTokenizer(bufferedReader.readLine());

            int y = Integer.parseInt(stk.nextToken());
            int x = Integer.parseInt(stk.nextToken());

            eventList.add(y * 10 + x);
        }

        int[][] dp = new int[eventList.size()][eventList.size()];

        // while(!caseQueue.isEmpty()){
        //     int value = caseQueue.poll();
        //     int x = value / 10;
        //     int y = value % 10;

        //     int distance = (int) getDistance(x, y, policeCurrentIndex / 10, policeCurrentIndex % 10); 
        //     int distance2 = (int) getDistance(x, y, police2CurrentIndex / 10, police2CurrentIndex % 10); 

        //     if(distance > distance2){
        //         police2CurrentIndex = y * 10 + x;
        //         totalMove += distance2;
        //         resultQueue.offer(2);
        //     } else{
        //         policeCurrentIndex = y * 10 + x;
        //         totalMove += distance;
        //         resultQueue.offer(1);
        //     }
        // }

        bufferedWriter.write(totalMove + "\n");

        for(Integer value : resultQueue){
            bufferedWriter.write(String.valueOf(value) + "\n");
        }
        
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    // static int dfs(int[][] dp, int eventIndex, ArrayList<Integer> eventList ) {
	// 	if(eventIndex > eventList.size()) {
    //         return 0;
    //     }

    //     int value = eventList.get(eventIndex);
    //     int x = value / 10;
    //     int y = value % 10;
		
	// 	if(dp[x][y] != 0) {
    //         return dp[x][y];
    //     } 

	// 	int first = dfs(dp, eventIndex + 1, eventList) + distance();
	// 	int second = dfs(dp, eventIndex + 1, eventList) + distance(2, second, event);
		
	// 	dp[first][second] = Math.min(first, second);
		
	// 	return dp[first][second];
	// }

    static double getDistance(int x, int y, int x1, int y1) {
		double d;
		int xd, yd;
        xd = Math.abs(x1 - x);
        yd = Math.abs(y1 - y);

		d = xd + yd;
		return d;
	}
}
