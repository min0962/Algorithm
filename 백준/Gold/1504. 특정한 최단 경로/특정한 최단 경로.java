import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, e, INF = 200000000;
    static List<List<Node>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.get(a).add(new Node(b, c));
            list.get(b).add(new Node(a, c));
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int result1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, n);
        int result2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, n);

        int result = Math.min(result1, result2);

        if (result >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }


    }

    private static int dijkstra(int start, int end) {
        int[] dist = new int[n + 1];
        boolean[] visited = new boolean[n + 1];

        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        pq.offer(new Node(start, 0));


        while (!pq.isEmpty()) {
            Node node = pq.poll();
            visited[node.end] = true;

            for (Node next : list.get(node.end)) {
                if (!visited[next.end]) {
                    if (dist[next.end] > dist[node.end] + next.dist) {
                        dist[next.end] = dist[node.end] + next.dist;
                        pq.offer(new Node(next.end, dist[next.end]));
                    }
                }
            }

        }

        return dist[end];
    }

}

class Node {
    int end;
    int dist;

    public Node(int end, int dist) {
        this.dist = dist;
        this.end = end;
    }

}