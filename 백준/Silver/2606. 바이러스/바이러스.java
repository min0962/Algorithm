import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        boolean[] visited = new boolean[n + 1];
        System.out.println(dfs(1, list, visited, 0));

    }

    private static int dfs(int v, List<List<Integer>> list, boolean[] visited, int sum) {
        visited[v] = true;

        for (int i : list.get(v)) {
            if (!visited[i]) {
                sum = dfs(i, list, visited, sum) + 1;
            }
        }

        return sum;
    }
}