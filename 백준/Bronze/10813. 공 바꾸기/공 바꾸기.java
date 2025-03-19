import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int count = scan. nextInt();

        int[] b = new int[num];

        for (int i = 0; i < num; i++) {
            b[i] = i + 1;
        }
        for (int i = 0; i < count; i++) {
            int n1 = scan.nextInt();
            int n2 = scan.nextInt();
            int temp = b[n1 - 1];
            b[n1 - 1] = b[n2 - 1];
            b[n2 - 1] = temp;
        }
        for (int i = 0; i < num; i++) {
            System.out.print(b[i] + " ");
        }
    }
}