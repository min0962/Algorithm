import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] sleep = new int[k];
        for (int i = 0; i < k; i++) {
            sleep[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[q];
        for (int i = 0; i < q; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] check = new int[n + 3];

        for (int i = 0; i < q; i++) {
            int j = arr[i];
            if (!tf(j, sleep)) {
                continue;
            }
            while (j <= n + 2) {
                if (tf(j, sleep)) {
                    check[j]++;
                }
                j += arr[i];
            }
        }

        int[] prefix = new int[n + 3];
        for (int i = 3; i <= n + 2; i++) {
            prefix[i] = prefix[i - 1] + (check[i] == 0 ? 1 : 0);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            System.out.println(prefix[end] - prefix[start - 1]);

        }

    }

    private static boolean tf(int q, int[] arr) {
        for (int i : arr) {
            if (i == q) {
                return false;
            }
        }
        return true;
    }

}