import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] arr;
    static ArrayList<int[]> list;
    static int min = 3001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        list = new ArrayList<>();

        dfs(0);

        System.out.println(min);

    }

    private static void dfs(int sum) {
        if (list.size() == 3) {
            min = Math.min(min, sum);
            return;
        }

        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (tf(i, j)) {
                    list.add(new int[]{i, j});
                    dfs(sum + arr[i][j] + arr[i + 1][j] + arr[i - 1][j] + arr[i][j + 1] + arr[i][j
                        - 1]);
                    list.remove(list.size() - 1);
                }
            }
        }

    }

    private static boolean tf(int i, int j) {
        if (list.isEmpty()) {
            return true;
        }

        for (int[] a : list) {
            int result = Math.abs(a[0] - i) + Math.abs(a[1] - j);
            if (result <= 2) {
                return false;
            }
        }
        return true;
    }

}

