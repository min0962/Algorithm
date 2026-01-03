import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list.get(u).add(v);
            list.get(v).add(u);
        }

        long[][] dp = new long[n + 1][8];
        for (int i = 1; i <= n; i++) {
            dp[i][1] = list.get(i).size();
        }

        for (int i = 2; i <= 7; i++) {
            for (int j = 1; j <= n; j++) {
                long cnt = 0;
                for (int num : list.get(j)) {
                    cnt = (cnt + dp[num][i - 1]) % 1_000_000_007;
                }
                dp[j][i] = cnt;
            }
        }

        long cnt = 0;
        for (int i = 1; i <= n; i++) {
            cnt = (cnt + dp[i][7]) % 1_000_000_007;
        }
        System.out.println(cnt);

    }

}
