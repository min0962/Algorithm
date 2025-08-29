import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static long[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        memo = new long[n + 1];

        if (n == 0) {
            System.out.println(0);
            return;
        }

        System.out.println(fibbo(n - 1) % 1_000_000_007);

    }

    private static long fibbo(int n) {

        if (n <= 1) {
            return memo[n] = 1;
        }

        if (memo[n] != 0) {
            return memo[n];
        }

        return memo[n] = (fibbo(n - 1) + fibbo(n - 2)) % 1_000_000_007;

    }

}

