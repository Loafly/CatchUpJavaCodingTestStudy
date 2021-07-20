import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 점수계산 {
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int length = 8;

        ArrayList<int[]> arrayList = new ArrayList<int[]>();

        for(int i = 0; i < length; i++){
            int[] arr = new int[2];
            arr[0] = Integer.parseInt(bufferedReader.readLine());
            arr[1] = i;
            arrayList.add(arr);
        }
    }

}

public class Exam implements Comparable<Exam>{
    private int score;
    private int index;

    public Exam(int score, int index){
        this.score = score;
        this.index = index;
    }

    public int getScore(){
        return score;
    }
    public int getIndex(){
        return index;
    }

    @Override
    public int compareTo(Exam exam) {
        // TODO Auto-generated method stub
        if(this.score < exam.score){
            return -1;
        } else if(this.score == exam.score){
            return 0;
        } else{
            return 1;
        }
        
        return this.score;
    }

}
