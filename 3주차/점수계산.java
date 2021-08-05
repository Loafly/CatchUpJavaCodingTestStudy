import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class 점수계산 {
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int length = 8;
        int sumLength = 5;
        int sum = 0;

        ArrayList<Exam> arrayList = new ArrayList<Exam>();
        ArrayList<Exam> arrayListReal = new ArrayList<Exam>();

        for(int i = 0; i < length; i++){
            Exam exam = new Exam(Integer.parseInt(bufferedReader.readLine()), i);
            arrayList.add(exam);
        }

        Collections.sort(arrayList);

        for(int i = arrayList.size() - 1; i > arrayList.size() - sumLength - 1; i--){
            arrayListReal.add(arrayList.get(i));
        }

        for(int i = 0; i < sumLength; i++){
            sum += arrayListReal.get(i).getScore();
        }

        bufferedWriter.write(sum + "\n");
        bufferedWriter.flush();
    }
}

class Exam implements Comparable<Exam>{
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
        if(this.index < exam.index){
            return -1;
        } else if(this.index == exam.index){
            return 0;
        } else{
            return 1;
        }
    }
}
