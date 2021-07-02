import java.util.Scanner;
import java.util.TreeSet;


public class 회사에있는사람 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int length = scanner.nextInt();
        scanner.nextLine();

        TreeSet<String> enterList = new TreeSet<>();

        for (int i = 0; i < length; i++){
            String[] string = scanner.nextLine().split(" ");

            if (string[1].equals("enter")){
                enterList.add(string[0]);
            }
            else {
                enterList.remove(string[0]);
            }
        }

        for(String enter : enterList.descendingSet())
        {
            System.out.println(enter);
        }

        scanner.close();

    }
    
}
