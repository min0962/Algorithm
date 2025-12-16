import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[][] arr = new int[r][c];
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                if (str.charAt(j) == '.') {
                    arr[i][j] = 0;
                } else {
                    arr[i][j] = 1;
                    list.add(new int[]{i, j});
                }
            }
        }

        int[] xx = {0, 0, 1, -1};
        int[] yy = {1, -1, 0, 0};

        for (int[] point : list) {

            int count = 0;

            for (int i = 0; i < 4; i++) {
                int x = point[0] + xx[i];
                int y = point[1] + yy[i];

                if (x < 0 || y < 0 || x >= r || y >= c) {
                    count++;
                    continue;
                }

                if (arr[x][y] == 0) {
                    count++;
                }

            }
            if (count >= 3) {
                arr[point[0]][point[1]]++;
            }

        }

        int minX = r - 1;
        int minY = c - 1;
        int maxX = 0;
        int maxY = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] == 1) {
                    minX = Math.min(minX, i);
                    maxX = Math.max(maxX, i);
                    minY = Math.min(minY, j);
                    maxY = Math.max(maxY, j);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = minX; i <= maxX; i++) {
            for (int j = minY; j <= maxY; j++) {
                sb.append(arr[i][j] == 1 ? "X" : ".");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

}