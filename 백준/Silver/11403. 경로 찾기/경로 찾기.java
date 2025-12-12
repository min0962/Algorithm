import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int val = Integer.parseInt(st.nextToken());
                if (val == 1) {
                    list.get(i + 1).add(j + 1);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            bfs(i, n, list);
        }


    }

    private static void bfs(int v, int n, List<List<Integer>> list) {

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        queue.offer(v);

        while (!queue.isEmpty()) {
            int i = queue.poll();

            for (int j : list.get(i)) {
                if (!visited[j]) {
                    queue.offer(j);
                    visited[j] = true;
                }
            }

        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                sb.append("1 ");
            } else {
                sb.append("0 ");
            }
        }
        System.out.println(sb);
    }

}