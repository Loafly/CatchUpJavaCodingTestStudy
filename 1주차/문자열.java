import java.util.Scanner;

public class 문자열 {
    public static void main(String[] args) {
        // 
        Scanner scanner = new Scanner(System.in);
        
        int length = scanner.nextInt();

        for (int i = 0; i < length ; i++){
            String string = new String();
            string = scanner.next();
            
            char start = string.charAt(0);
            char end = string.charAt(string.length() - 1);

            System.out.println(Character.toString(start) + Character.toString(end));
        }

        scanner.close();

    }
}