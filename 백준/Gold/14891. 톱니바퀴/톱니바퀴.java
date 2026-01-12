import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] gear = new int[5][8];
        for (int i = 1; i <= 4; i++) {
            String str = br.readLine();
            for (int j = 0; j < 8; j++) {
                gear[i][j] = str.charAt(j) - '0';
            }
        }
        int[] top = new int[5];

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int gearNum = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            checkGear(gear, gearNum, top, d);
        }
        int sum = 0;
        sum += gear[1][top[1]] == 1 ? 1 : 0;
        sum += gear[2][top[2]] == 1 ? 2 : 0;
        sum += gear[3][top[3]] == 1 ? 4 : 0;
        sum += gear[4][top[4]] == 1 ? 8 : 0;

        System.out.println(sum);

    }

    private static void checkGear(int[][] gear, int gearNum, int[] top, int d) {
        int[] dir = new int[5];
        dir[gearNum] = d;
        for (int i = gearNum - 1; i >= 1; i--) {
            if (gear[i + 1][(top[i + 1] + 6) % 8] != gear[i][(top[i] + 2) % 8]) {
                dir[i] = -dir[i + 1];
            } else {
                break;
            }
        }
        for (int i = gearNum + 1; i <= 4; i++) {
            if (gear[i - 1][(top[i - 1] + 2) % 8] != gear[i][(top[i] + 6) % 8]) {
                dir[i] = -dir[i - 1];
            } else {
                break;
            }
        }
        for (int i = 1; i <= 4; i++) {
            top[i] = (top[i] + 8 - dir[i]) % 8;
        }
    }
}
