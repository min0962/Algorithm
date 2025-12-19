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

        int[] arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int le = 1;
        int count = 0;
        int evenCount = 0;
        int oddCount = 0;

        for (int i = 1; i <= n; i++) {
            if (arr[i] % 2 == 0) {
                count++;
                evenCount = Math.max(evenCount, count);
            } else {
                oddCount++;
                if (oddCount > k) {
                    while (arr[le] % 2 == 0) {
                        count--;
                        le++;
                    }
                    le++;
                    oddCount--;
                }
            }
        }

        System.out.println(evenCount);

    }

}