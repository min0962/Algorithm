import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] prefixSum = new long[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + Integer.parseInt(st.nextToken());
        }

        long[] cnt = new long[m];
        long result = 0;
        for (int i = 1; i <= n; i++) {
            cnt[(int) (prefixSum[i] % m)]++;
        }

        for (int i = 0; i < m; i++) {
            if (cnt[i] > 1) {
                result += cnt[i] * (cnt[i] - 1) / 2;
            }
        }
        System.out.println(result + cnt[0]);

    }

}
