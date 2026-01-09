import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        long count = 0;
        for (int i = 0; i < n - 2; i++) {
            int lo = i + 1;
            int hi = n - 1;

            while (lo < hi) {
                long sum = arr[i] + arr[lo] + arr[hi];

                if (sum < 0) {
                    lo++;
                } else if (sum > 0) {
                    hi--;
                } else {
                    if (arr[lo] == arr[hi]) {
                        int t = hi - lo + 1;
                        count += (long) t * (t - 1) / 2;
                        break;
                    }
                    int lv = arr[lo];
                    int lc = 0;
                    while (arr[lo] == lv) {
                        lo++;
                        lc++;
                    }
                    int hv = arr[hi];
                    int hc = 0;
                    while (arr[hi] == hv) {
                        hi--;
                        hc++;
                    }
                    count += (long) lc * hc;
                }
            }
        }
        System.out.println(count);
    }

}
