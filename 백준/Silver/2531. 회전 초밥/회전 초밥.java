import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + k - 1];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < k - 1; i++) {
            arr[n + i] = arr[i];
        }

        int[] cnt = new int[d + 1];
        int distinct = 0;

        for (int i = 0; i < k; i++) {
            if (cnt[arr[i]]++ == 0) {
                distinct++;
            }
        }

        int ans = distinct;
        if (cnt[c] == 0) {
            ans++;
        }

        for (int i = 1; i < n; i++) {
            if (--cnt[arr[i - 1]] == 0) {
                distinct--;
            }

            if (cnt[arr[i + k - 1]]++ == 0) {
                distinct++;
            }

            int cur = distinct;
            if (cnt[c] == 0) {
                cur++;
            }
            ans = Math.max(ans, cur);

        }

        System.out.println(ans);

    }

}

