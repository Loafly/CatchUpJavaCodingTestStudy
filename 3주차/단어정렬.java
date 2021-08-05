import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 단어정렬 {
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int length = Integer.parseInt(bufferedReader.readLine());

        Set<String> hashSet = new HashSet<>();

        for(int i = 0; i < length; i++){
            hashSet.add(bufferedReader.readLine());
        }

        List<String> arrayList = new ArrayList<>(hashSet);

        Collections.sort(arrayList, new Ascending());

        for (String string : arrayList) {
            bufferedWriter.write(string + '\n');
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}

class Ascending implements Comparator<String>{

    @Override
    public int compare(String o1, String o2) {
        // TODO Auto-generated method stub
        if(o1.length() > o2.length()){
            return 1;
        } else if(o1.length() == o2.length()){
            return o1.compareTo(o2);
        } else{
            return -1;
        }
    }
}
