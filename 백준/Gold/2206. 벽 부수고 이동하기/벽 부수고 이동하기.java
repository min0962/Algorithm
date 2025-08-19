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

        boolean[][][] visited = new boolean[n][m][2];
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                if (str.charAt(j) - '0' == 1) {
                    arr[i][j] = 1;
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1, 0});
        visited[0][0][0] = true;

        int[] xx = new int[]{1, -1, 0, 0};
        int[] yy = new int[]{0, 0, 1, -1};


        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int i = poll[0];
            int j = poll[1];
            int depth = poll[2];
            int wall = poll[3];

            if (i == n - 1 && j == m - 1) {
                System.out.println(depth);
                return;
            }

            for (int k = 0; k < 4; k++) {
                int x = i + xx[k];
                int y = j + yy[k];

                if (x >= 0 && x < n && y >= 0 && y < m) {

                    if (arr[x][y] == 0) {
                        if (wall == 0 && !visited[x][y][0]) {
                            queue.add(new int[]{x, y, depth + 1, wall});
                            visited[x][y][0] = true;
                        } else if (wall == 1 && !visited[x][y][1]) {
                            queue.add(new int[]{x, y, depth + 1, wall});
                            visited[x][y][1] = true;
                        }

                    } else {
                        if (wall == 0 && !visited[x][y][1]) {
                            queue.add(new int[]{x, y, depth + 1, wall + 1});
                            visited[x][y][1] = true;
                        }
                    }
                }
            }

        }

        System.out.println(-1);

    }

}
