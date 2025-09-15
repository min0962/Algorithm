import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] memo = new int[n + 1][10];

        for (int i = 1; i < 10; i++) {
            memo[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {

                if (j == 0) {
                    memo[i][j] = memo[i - 1][1];
                } else if (j == 9) {
                    memo[i][j] = memo[i - 1][8];
                } else {
                    memo[i][j] = (memo[i - 1][j - 1] + memo[i - 1][j + 1]) % 1_000_000_000;
                }

            }
        }
        int result = 0;
        for (int i = 0; i < 10; i++) {
            result += memo[n][i];
            result %= 1_000_000_000;
        }
        System.out.println(result);

    }

}

