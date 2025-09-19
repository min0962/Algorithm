import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1];
        Arrays.fill(arr, -1);

        int count = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            int lr = Integer.parseInt(st.nextToken());

            if (arr[num] == -1) {
                arr[num] = lr;
            } else {
                if (arr[num] != lr) {
                    count++;
                    arr[num] = lr;
                }
            }
        }

        System.out.println(count);

    }

}

