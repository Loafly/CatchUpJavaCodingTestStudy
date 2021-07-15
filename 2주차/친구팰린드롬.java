import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class 친구팰린드롬 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] temp_string = bufferedReader.readLine().split(" ");

        int N = Integer.parseInt(temp_string[0]);
        int M = Integer.parseInt(temp_string[1]);
        int answer = 0;

        ArrGraph arrGraph = new ArrGraph(N);

        for(int i = 0; i < M; i++){
            temp_string = bufferedReader.readLine().split(" ");
            
            arrGraph.put(Integer.parseInt(temp_string[0]), Integer.parseInt(temp_string[1]));
        }

        while(true){
            int minFriendsCount = 21;
            int minFriendsIndex = -1;
            for(int i = 0; i < N; i++){
                if(minFriendsCount > arrGraph.getFriendsCount(i) && arrGraph.getFriendsCount(i) != 0){
                    minFriendsCount = arrGraph.getFriendsCount(i);
                    minFriendsIndex = i;
                }
            }

            if(minFriendsIndex == -1){
                break;
            }
    
            List<Integer> tempList = arrGraph.getFriends(minFriendsIndex);
    
            int minFriendsCount2 = 21;
            int minFriendsIndex2 = -1;
            for(int i = 0; i < tempList.size(); i++){
                int friendsCount = arrGraph.getFriendsCount(tempList.get(i));
                if(minFriendsCount2 > friendsCount && friendsCount != 0){
                    minFriendsCount2 = friendsCount;
                    minFriendsIndex2 = tempList.get(i);
                }
            }

            if(minFriendsIndex2 == -1){
                break;
            }
            
            arrGraph.pop(minFriendsIndex, minFriendsIndex2);
            answer += 2;
        }

        if(answer < N){
            if(answer % 2 == 0){
                answer += 1;
            }
        }

        System.out.println(answer);
          
    }
}

// 그래프(행렬) 클래스
class ArrGraph {
    private int[][] arrGraph;
 
    // 그래프 초기화
    public ArrGraph(int initSize) {
        // 그래프 초기화
        // put(int x, int y) 에서 입력되는 정점의 값은 0 이상의 정수이나
        // 배열의 index는 0 부터 시작이므로 
        // ArrayIndexOutOfBoundsException 방지를 위해 
        // 정점을 담는 인접행렬의 행과 열 size는 1을 더하여 초기화해줌
        this.arrGraph = new int[initSize+1][initSize+1];
    }
 
    // 그래프 return
    public int[][] getGraph() {
        return this.arrGraph;
    }
 
    // 그래프 추가 (양방향)
    public void put(int x, int y) {
        arrGraph[x][y] = arrGraph[y][x] = 1;
    }
 
    // 그래프 추가 (단방향)
    public void putSingle(int x, int y) {
        arrGraph[x][y] = 1;
    }

    // 그래프 제거
    public void pop(int x, int y){
        for(int i= 0; i < arrGraph.length; i++){
            arrGraph[x][i] = arrGraph[y][i] = arrGraph[i][x] = arrGraph[i][y] = 0;
        }
    }

    public int getFriendsCount(int x){
        int value = 0;
        for(int i = 0; i < arrGraph[x].length; i++){
            if(arrGraph[x][i] == 1){
                value ++;
            }
        }
        return value;
    }

    public List<Integer> getFriends(int x){
        List<Integer> value = new ArrayList<Integer>();

        for(int i = 0; i < arrGraph[x].length; i++){
            if(arrGraph[x][i] == 1){
                value.add(i);
            }
        }

        return value;
    }
    
    // 그래프 출력 (인접행렬)
    public void printGraphToAdjArr() {
        for(int i=0; i<arrGraph.length; i++) {
            for(int j=0; j<arrGraph[i].length; j++) {
                System.out.print(" " + arrGraph[i][j]);
            }
            System.out.println();
        }
    }
}