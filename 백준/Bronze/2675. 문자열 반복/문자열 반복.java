import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String n = scan.nextLine();
        
        for ( int k =0; k < Integer.parseInt(n); k++) {
            String input = scan.nextLine();
            String[] str = input.split(" ");
            String result = "";
            for (int i = 0; i < str[1].length(); i++) {
                String c = "";
                for (int j = 0; j < Integer.parseInt(str[0]); j++) {
                    c += str[1].charAt(i);
                }
                result += c;
            }
            System.out.println(result);
        }

    }
}