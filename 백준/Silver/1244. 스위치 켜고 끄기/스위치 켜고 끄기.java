import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int stdNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < stdNum; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int sNum = Integer.parseInt(st.nextToken());
            if (gender == 1) {
                man(sNum);
            } else {
                girl(sNum);
            }

        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(arr[i]).append(" ");
            if (i % 20 == 0) {
                sb.append("\n");
            }
        }
        System.out.println(sb);

    }

    private static void man(int sNum) {
        for (int i = sNum; i <= n; i += sNum) {
            arr[i] = 1 - arr[i];
        }
    }

    private static void girl(int sNum) {
        int le = sNum - 1;
        int ri = sNum + 1;
        arr[sNum] = 1 - arr[sNum];
        while (le > 0 && ri <= n) {
            if (arr[le] != arr[ri]) {
                break;
            }
            arr[le] = 1 - arr[le];
            arr[ri] = 1 - arr[ri];
            le--;
            ri++;
        }
    }

}

