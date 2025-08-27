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

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] sumArr = new int[n];
        sumArr[0] = arr[0];

        for (int i = 1; i < n; i++) {
            sumArr[i] = sumArr[i - 1] + arr[i];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int j = Integer.parseInt(st.nextToken()) - 2;
            int k = Integer.parseInt(st.nextToken()) - 1;

            if (j == -1) {
                sb.append(sumArr[k]).append("\n");
            } else {
                sb.append(sumArr[k] - sumArr[j]).append("\n");
            }

        }

        System.out.println(sb);

    }

}

