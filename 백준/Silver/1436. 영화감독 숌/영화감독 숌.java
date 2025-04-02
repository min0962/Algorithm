import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String arg[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int num = 666;
        int count = 0;
        while (true) {
            if(String.valueOf(num).contains("666")) {
                count++;
                if (n == count) {
                    break;
                }
            }
            num++;
        }
        System.out.println(num);

    }
}


