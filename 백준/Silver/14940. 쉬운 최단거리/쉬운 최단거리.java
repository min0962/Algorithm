import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[][] visited = new boolean[n][m];
        int[][] dist = new int[n][m];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int val = Integer.parseInt(st.nextToken());
                if (val == 2) {
                    q.offer(new int[]{i, j, 0});
                    visited[i][j] = true;
                } else if (val == 0) {
                    visited[i][j] = true;
                }
            }
        }

        int[] xx = {0, 0, 1, -1};
        int[] yy = {1, -1, 0, 0};

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int a = poll[0];
            int b = poll[1];
            int d = poll[2];

            for (int i = 0; i < 4; i++) {
                int x = a + xx[i];
                int y = b + yy[i];
                if (x >= 0 && y >= 0 && x < n && y < m && !visited[x][y]) {
                    q.offer(new int[]{x, y, d + 1});
                    dist[x][y] = d + 1;
                    visited[x][y] = true;
                }

            }

        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j]) {
                    sb.append(dist[i][j]).append(" ");
                } else {
                    sb.append(-1).append(" "); 
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

}

