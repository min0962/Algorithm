import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] cnt = new int[n + 1];
        Arrays.fill(cnt, 50_001);
        int[] val = {2, 5};

        cnt[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j : val) {
                if (i - j < 0) {
                    continue;
                }
                if (cnt[i - j] == 50_001) {
                    continue;
                }
                cnt[i] = Math.min(cnt[i], cnt[i - j] + 1);
            }
        }

        if (cnt[n] == 50_001) {
            System.out.println(-1);
        } else {
            System.out.println(cnt[n]);
        }


    }

}

