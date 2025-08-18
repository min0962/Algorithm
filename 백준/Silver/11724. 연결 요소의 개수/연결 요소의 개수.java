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
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        boolean[] visited = new boolean[n + 1];
        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i, list, visited);
                count++;
            }
        }

        System.out.println(count);

    }

    private static void dfs(int v, List<List<Integer>> list, boolean[] visited) {
        visited[v] = true;

        for (int i : list.get(v)) {
            if (!visited[i]) {
                dfs(i, list, visited);
            }
        }

    }


}