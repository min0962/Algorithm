import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n1 = scan.nextInt();
        int n2 = scan.nextInt();

        int m1, m2;

        m1 = n2 % 10;
        m2 = n2 / 10;
        System.out.println(n1 * m1);

        m1 = m2 % 10;
        m2 = m2 / 10;
        System.out.println(n1 * m1);

        System.out.println(n1 * m2);
        System.out.println(n1 * n2);


    }
}
