import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        double[][] arr = new double[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            arr[i][0] = i + 1;
            arr[i][1] = Math.sqrt((w * w + h * h)) / 77;
        }
        Arrays.sort(arr, (a, b) -> Double.compare(b[1], a[1]));
        for (double[] val : arr) {
            System.out.println((int)val[0]);
        }

    }


}
