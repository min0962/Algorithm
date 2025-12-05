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

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
        }

        int[] dis = new int[n + 1];
        boolean[] visited = new boolean[n + 1];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, 0});
        visited[x] = true;

        while (!queue.isEmpty()) {
            int[] val = queue.poll();
            int node = val[0];
            int depth = val[1];
            if (depth > k) {
                break;
            }
            dis[node] = depth;
            List<Integer> temp = list.get(node);
            for (int i : temp) {
                if (!visited[i]) {
                    queue.add(new int[]{i, depth + 1});
                    visited[i] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        boolean tf = false;
        for (int i = 1; i <= n; i++) {
            if (dis[i] == k) {
                sb.append(i).append("\n");
                tf = true;
            }
        }

        if (!tf) {
            System.out.println(-1);
        } else {
            System.out.println(sb);
        }

    }

}