import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int n =  scan.nextInt();
        System.out.println(input.charAt(n-1));
    }
}