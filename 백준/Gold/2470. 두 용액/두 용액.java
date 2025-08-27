import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int le = 0;
        int ri = n - 1;
        int val1 = 0;
        int val2 = n - 1;

        while (le < ri) {

            int sum = arr[le] + arr[ri];
            int min = arr[val1] + arr[val2];

            if (Math.abs(sum) < Math.abs(min)) {
                val1 = le;
                val2 = ri;
            }

            if (sum == 0) {
                System.out.println(arr[val1] + " " + arr[val2]);
                return;
            } else if (sum > 0) {
                ri--;
            } else {
                le++;
            }

        }

        System.out.println(arr[val1] + " " + arr[val2]);

    }

}

