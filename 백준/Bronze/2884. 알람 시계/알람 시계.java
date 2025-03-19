import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int h = scan.nextInt();
        int m = scan.nextInt();

        m = m - 45;
        if ( m < 0){
            m += 60;
            if ( h == 0 ){
                h = 23;
            }else {
                h--;
            }
        }
        System.out.println(h + " " + m);
    }
}
