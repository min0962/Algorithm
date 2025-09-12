import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n + 1];
        arr[0] = 0;
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] memo = new int[n + 1];
        Arrays.fill(memo, 0);
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                memo[j] = Math.max(memo[j], memo[j - i] + arr[i]);
            }

        }

        System.out.println(memo[n]);

    }

}

