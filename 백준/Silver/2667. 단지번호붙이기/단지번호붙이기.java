import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    static int[] xx = new int[]{1, -1, 0, 0};
    static int[] yy = new int[]{0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        int count = 0;
        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    list.add(0);
                    dfs(n, i, j, arr, list, count, visited);
                    count++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(count).append("\n");
        Collections.sort(list);
        for (int i : list) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);

    }

    private static void dfs(int n, int i, int j, int[][] arr, ArrayList<Integer> list, int count, boolean[][] visited) {
        visited[i][j] = true;
        list.set(count, list.get(count) + 1);

        for (int k = 0; k < 4; k++) {
            int x = i + xx[k];
            int y = j + yy[k];
            if (x >= 0 && x < n && y >= 0 && y < n) {
                if (arr[x][y] == 1 && !visited[x][y]) {
                    dfs(n, x, y, arr, list, count, visited);
                }
            }
        }
    }


}