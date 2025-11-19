import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] arr = new int[n + 1][n + 1];

        int[] xx = {-1, 0, 1, 0};
        int[] yy = {0, 1, 0, -1};

        int i = n / 2 + 1;
        int j = n / 2;
        if (n % 2 == 1) {
            j++;
        }
        int xy = 0;     // 방향 변수
        int flag = 1;   // 같은 방향으로 몇번 가야하는지
        int state = 0;  // 현재 같은 방향으로 몇번 갔는지
        int cnt = 0;    // 2번마다 flag 증가 시켜줘야함
        int num = 1;    // 증가하는 수

        while (i <= n && j <= n) {
            arr[i][j] = num;
            num++;

            if (flag == state) {
                xy++;
                cnt++;
                state = 0;
                if (xy > 3) {
                    xy = 0;
                }
                if (cnt == 2) {
                    flag++;
                    cnt = 0;
                }

            }

            i += xx[xy];
            j += yy[xy];
            state++;

        }

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for (int q = 1; q <= n; q++) {
            for (int w = 1; w <= n; w++) {
                sb1.append(arr[q][w]).append(" ");
                if (arr[q][w] == m) {
                    sb2.append(q).append(" ").append(w);
                }
            }
            if (q != n) {
                sb1.append("\n");
            }
        }

        System.out.println(sb1);
        System.out.println(sb2);

    }

}

