import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 가장긴문자열 {
    public static void main (String args[]) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String string = bufferedReader.readLine();

        //Suffix Array : index번째에서 시작하는 문자열 string의 접미사
        int[] sa = new int[string.length()];        
        for(int i = 0; i < sa.length; i++){
            sa[i] = i;
        }

        //string 문자열의 모든 접미사 정렬 => 전체 알고리즘에서 가장 오래걸리는 부분
        for(int i = 0; i< sa.length; i++){
            int minIndex = i;
            for (int j = 0; j < sa.length; j++){
                if (string.substring(sa[minIndex]).compareTo(string.substring(sa[j])) > 0){
                    minIndex = j;
                }
            }

            int temp = sa[minIndex];
            sa[minIndex] = sa[i];
            sa[i] = temp;
        }

        int[] LCP = new int[string.length()];
        for(int i = 1; i < LCP.length; i++){
            String s1 = string.substring(sa[i - 1]);
            String s2 = string.substring(sa[i]);
            while( s1.length() > LCP[i] && s2.length() > LCP[i] && s1.charAt(LCP[i]) == s2.charAt(LCP[i])) {
                LCP[i] ++;
            }
        }

        bufferedWriter.write(Arrays.toString(LCP) + " : LCP");

        bufferedWriter.flush();

        bufferedReader.close();
        bufferedWriter.close();
    }
    
}
