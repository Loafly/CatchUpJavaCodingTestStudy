import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 격자상의경로{

    static int[] dx = {1,0};
    static int[] dy = {0,1};

    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        //방식 0,0 에서 K까지의 경우의 수 * K에서의 n,m 까지의 경우의 수를 구하면된다.

        //N은 행 M은 열

        StringTokenizer stk = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());

        //1부터 검사하기위해 +1 해준 값으로 초기화합니다.
        int[][] visitCount = new int[M + 1][N + 1];

        Point startPoint = new Point(1,1);
        Point targetPoint;

        int targetX;
        int targetY;

        int midCount = 1;
        int answer = 0;

        if(K != 0){
            targetX = K % M;
            targetY = (K / M) + 1;

            if(targetX == 0){
                targetX = M;
                targetY --;
            }            

            targetPoint = new Point(targetX,targetY);

            midCount = DP(startPoint, targetPoint, visitCount);

            startPoint = targetPoint;
        } 


        targetX = M;
        targetY = N;

        targetPoint = new Point(targetX,targetY);
        
        visitCount = new int[M + 1][N + 1];

        answer = DP(startPoint, targetPoint, visitCount) * midCount;

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    public static int DP(Point startPoint, Point targetPoint, int[][] visitCount){

        // 피라미드 형태로 생각해서 구현하였습니다.
        Queue<Point> queue = new LinkedList<>();

        visitCount[startPoint.x][startPoint.y] = 1;

        queue.add(startPoint);

        while(!(queue.isEmpty())){
            Point point = queue.poll();
            if(!(point.x == startPoint.x && point.y == startPoint.y)){
                visitCount[point.x][point.y] = visitCount[point.x - 1][point.y] + visitCount[point.x][point.y - 1];
            }
            
            // 범위 설정 오른쪽 또는 아래로 이동하기 때문에 모든 수가 0보다 크다.
            if(point.x < targetPoint.x){
                Point newPoint = new Point(point.x + 1,point.y);
                queue.add(newPoint);
            } else {
                if(point.y < targetPoint.y){
                    Point newPoint = new Point(startPoint.x,point.y + 1);
                    queue.add(newPoint);
                }                
            }

            // for(int i = 0; i < 2; i++){
            //     int nx = point.x + dx[i];
            //     int ny = point.y + dy[i];
					
            //     // 범위 설정 오른쪽 또는 아래로 이동하기 때문에 모든 수가 0보다 크다.
            //     if(!(nx <= targetPoint.x && ny <= targetPoint.y)){
            //         continue;
            //     }
            //     else{
            //         Point newPoint = new Point(nx,ny);
            //         queue.add(newPoint);
            //     }
            // }
        }

        return visitCount[targetPoint.x][targetPoint.y];
    }

    public static class Point{
        private int x;
        private int y;

        public int getX(){
            return this.x;
        }

        public void setX(int x){
            this.x = x;
        }
        
        public int getY(){
            return this.y;
        }

        public void setY(int y){
            this.y = y;
        }

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}