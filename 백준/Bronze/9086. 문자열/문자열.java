import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        for (int i = 0; i < Integer.parseInt(input); i++){
            String str = scan.nextLine();
            char c1 = str.charAt(0);
            char c2 = str.charAt(str.length()-1);
            System.out.println(String.valueOf(c1) + String.valueOf(c2));
        }


    }
}