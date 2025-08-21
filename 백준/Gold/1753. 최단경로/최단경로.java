import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());

        List<List<int[]>> list = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            list.get(x).add(new int[]{y, z});
        }

        boolean[] visited = new boolean[v + 1];
        int[] dist = new int[v + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a[0], b[0])
        );

        pq.offer(new int[]{0, k});

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            visited[poll[1]] = true;

            for (int[] next : list.get(poll[1])) {
                if (!visited[next[0]]) {
                    int sum = poll[0] + next[1];
                    if (dist[next[0]] > sum) {
                        dist[next[0]] = sum;
                        pq.offer(new int[]{sum, next[0]});
                    }
                }
            }

        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= v; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                sb.append("INF\n");
            } else {
                sb.append(dist[i]).append("\n");
            }
        }

        System.out.println(sb);

    }

}
