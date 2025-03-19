import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        double []s =  new double[n];
        for (int i = 0; i < n; i++) {
            s[i] = scan.nextInt();
        }
        double max = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            if(s[i] > max){
                max = s[i];
            }
        }
        for (int i = 0; i < n; i++) {
            s[i] = s[i]/max*100;
            sum += s[i];
        }
        System.out.println(sum/n);
    }
}