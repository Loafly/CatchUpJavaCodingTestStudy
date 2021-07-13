import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class 숫자판점프 {
    public static void main(String[] args) throws IOException{

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int length = 5;

        String[][] matrix = new String[5][5];
        Set<String> answer_set = new HashSet<String>();
        String answer = new String();
        
        for(int i = 0; i < length; i++){
            matrix[i] = bufferedReader.readLine().split(" ");
        }

        for(int i = 0; i < length; i++){
            for(int j = 0; j < length; j++){
                DFS(i, j, 0, matrix, answer, answer_set);
            }
        }

        System.out.println(answer_set.size());

        bufferedReader.close();
        
    }

    public static void DFS(int row_index, int col_index, int current_count, String[][] matrix, String answer, Set<String> answer_set){

        answer += matrix[row_index][col_index];
        current_count ++;
        
        if(current_count == 6) {
            answer_set.add(answer);
        } else {
            // 위
            if(row_index > 0){
                DFS(row_index - 1, col_index, current_count, matrix, answer, answer_set);
            }

            // 아래
            if(row_index < 4){
                DFS(row_index + 1, col_index, current_count, matrix, answer, answer_set);
            }

            // 왼쪽
            if(col_index > 0){
                DFS(row_index, col_index - 1, current_count, matrix, answer, answer_set);
            }

            // 오른쪽
            if(col_index < 4){
                DFS(row_index, col_index + 1, current_count, matrix, answer, answer_set);
            }

        }


    }
}