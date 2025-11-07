import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int lo = 1;
        int hi = 0;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            hi = Math.max(hi, arr[i]);
        }
        hi++;
        int m = Integer.parseInt(br.readLine());

        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;
            if (check(arr, mid, m)) {
                lo = mid;
            } else {
                hi = mid;
            }

        }

        System.out.println(lo);


    }

    private static boolean check(int[] arr, int mid, int m) {
        int sum = 0;

        for (int i : arr) {
            if (mid < i) {
                sum += mid;
            } else {
                sum += i;
            }
        }

        return sum <= m;
    }


}

