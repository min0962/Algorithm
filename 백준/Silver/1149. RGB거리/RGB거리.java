import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] memo = new int[n][3];

        for (int i = 0; i < 3; i++) {
            memo[0][i] = arr[0][i];
        }

        for (int i = 1; i < n; i++) {

            memo[i][0] = arr[i][0] + Math.min(memo[i - 1][1], memo[i - 1][2]);
            memo[i][1] = arr[i][1] + Math.min(memo[i - 1][0], memo[i - 1][2]);
            memo[i][2] = arr[i][2] + Math.min(memo[i - 1][0], memo[i - 1][1]);

        }

        int result = Math.min(Math.min(memo[n - 1][0], memo[n - 1][1]), memo[n - 1][2]);

        System.out.println(result);

    }

}

