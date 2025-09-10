import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int[] memo = new int[k + 1];
        Arrays.fill(memo, 100_001);

        memo[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = arr[i]; j <= k; j++) {
                memo[j] = Math.min(memo[j], memo[j - arr[i]] + 1);
            }
        }

        if (memo[k] == 100_001) {
            memo[k] = -1;
        }

        System.out.println(memo[k]);

    }

}

