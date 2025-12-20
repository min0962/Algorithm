import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        long lo = 0;
        long hi = (long) m * arr[n - 1];

        while (lo + 1 < hi) {
            long mid = (lo + hi) / 2;

            long sum = 0;
            boolean tf = false;
            for (int t : arr) {
                sum += mid / t;
                if (sum >= m) {
                    tf = true;
                    break;
                }
            }
            if (tf) {
                hi = mid;
            } else {
                lo = mid;
            }

        }

        System.out.println(hi);

    }


}
