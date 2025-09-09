import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] memo = new int[n];
        int[] arr = new int[n];

        arr[0] = Integer.parseInt(st.nextToken());
        memo[0] = 1;
        int max = 1;

        for (int i = 1; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            int maxValue = 0;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    maxValue = Math.max(maxValue, memo[j]);
                }
            }
            memo[i] = maxValue + 1;
            max = Math.max(max, memo[i]);
        }

        System.out.println(max);


    }

}

