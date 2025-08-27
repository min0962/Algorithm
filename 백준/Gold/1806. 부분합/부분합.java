import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        arr[0] = 0;

        int ans = n + 1;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken()) + arr[i - 1];
        }

        int le1 = 1;
        int le2 = 1;

        for (int i = 0; i < n * 2 - 1; i++) {

            if (le1 == le2) {
                if (arr[le2] - arr[le1 - 1] >= s) {
                    System.out.println(1);
                    return;
                } else {
                    le2++;
                }
            } else {
                int val = arr[le2] - arr[le1 - 1];
                if (val >= s) {
                    ans = Math.min(ans, le2 - le1 + 1);
                    le1++;
                } else {
                    le2++;
                    if (le2 > n) {
                        break;
                    }
                }
            }

        }

        if (ans == (n + 1)) {
            ans = 0;
        }

        System.out.println(ans);

    }

}

