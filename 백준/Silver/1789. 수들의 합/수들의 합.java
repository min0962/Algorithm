import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long s = Long.parseLong(br.readLine());

        int i = 0;
        long sum = 0;
        while (true) {
            i++;
            sum += i;
            if (sum == s) {
                System.out.println(i);
                break;
            } else if (s < sum) {
                System.out.println(i - 1);
                break;
            }
        }


    }


}

