import java.util.Scanner;

public class 그릇 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String string = scanner.next();

        int answer = 10;

        for (int i = 1; i < string.length(); i++){
            if (string.charAt(i) == string.charAt(i - 1)){
                answer += 5;
            }
            else{
                answer += 10;
            }
        }

        System.out.println(answer);

        scanner.close();
    }
}
