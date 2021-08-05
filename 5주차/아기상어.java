import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 아기상어 {

    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    static int size;
    static int babySharkSize;

    static class Point{
        int x;
        int y;
        int dist;
    
        Point(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

    }

    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        size = Integer.parseInt(bufferedReader.readLine());

        int[][] table = new int[size][size];

        babySharkSize = 2;

        int currentX = 0;
        int currentY = 0;
        int currentTime = 0;

        for(int i = 0; i < size; i++){
            StringTokenizer stk = new StringTokenizer(bufferedReader.readLine());
            for(int j = 0; j < size; j++){
                table[j][i] = Integer.parseInt(stk.nextToken());
                if(table[j][i] == 9){
                    currentX = j;
                    currentY = i;
                    table[j][i] = 0;
                }
            }
        }
        currentTime = bfs(currentX, currentY, currentTime, table);

        bufferedWriter.write(String.valueOf(currentTime));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    public static int bfs(int currentX, int currentY, int currentTime, int[][] table){
        Queue<Point> queue = new LinkedList<>();
        boolean isVisit[][] = new boolean[size][size];
        int eatCount = 0;

        queue.add(new Point(currentX, currentY, 0));
        isVisit[currentX][currentY] = true;
        
        while(true){
            List<Point> eatAbleList = new ArrayList<Point>();
            while(!queue.isEmpty()) {
				Point point = queue.poll();
				int time = point.dist;

				for (int i = 0; i < 4; i++) {
					int nx = point.x + dx[i];
					int ny = point.y + dy[i];
					
					// 범위 설정
					if(!(0 <= nx && nx < size && 0 <= ny && ny < size) || isVisit[nx][ny]){
                        continue;
                    } 
					
                    // 움직이거나 먹을 수 있는 장소
					if(table[nx][ny] <= babySharkSize) {
						queue.add(new Point(nx, ny, time + 1));
						isVisit[nx][ny] = true;
                        if(table[nx][ny] != babySharkSize && table[nx][ny] != 0){
                            eatAbleList.add(new Point(nx,ny, time + 1));
                        }
					}
				}
			}

            if(!eatAbleList.isEmpty()) {
				Collections.sort(eatAbleList, new Comparator<Point>(){
                    @Override
                    public int compare(Point p1, Point p2){
                        if (p1.dist == p2.dist){
                            if(p1.y == p2.y){
                                return p1.x - p2.x;
                            }
                            else{
                                return p1.y - p2.y;
                            }
                        }
                        else{
                            return p1.dist - p2.dist;
                        }
                    }
                });
				
				isVisit = new boolean[size][size];

				queue.add(eatAbleList.get(0));
                currentTime = eatAbleList.get(0).dist;
				isVisit[eatAbleList.get(0).x][eatAbleList.get(0).y] = true;
                table[eatAbleList.get(0).x][eatAbleList.get(0).y] = 0;

                eatAbleList.clear();
                eatCount++;
                if(eatCount == babySharkSize){
                    eatCount = 0;
                    babySharkSize++;
                }
			}else {
				return currentTime;
			}
        }
    }
    
}