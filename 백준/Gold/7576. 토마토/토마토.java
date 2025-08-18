import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] xx = new int[]{1, -1, 0, 0};
    static int[] yy = new int[]{0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    queue.add(new int[]{i, j, 0});
                    visited[i][j] = true;
                } else if (arr[i][j] == -1) {
                    visited[i][j] = true;
                }
            }
        }

        int depth = 0;

        while (!queue.isEmpty()) {
            int[] key = queue.poll();
            int a = key[0];
            int b = key[1];
            depth = key[2];

            for (int k = 0; k < 4; k++) {
                int x = a + xx[k];
                int y = b + yy[k];
                if (x >= 0 && y >= 0 && x < m && y < n) {
                    if (!visited[x][y] && arr[x][y] == 0) {
                        queue.add(new int[]{x, y, depth + 1});
                        visited[x][y] = true;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(depth);
    }

}
