import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String n = scan.nextLine().trim();

        StringTokenizer st = new StringTokenizer(n, " ");

        System.out.println(st.countTokens());

    }
}