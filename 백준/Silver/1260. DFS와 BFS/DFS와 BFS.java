import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

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

        for (int i = 1; i <= n; i++) {
            Collections.sort(list.get(i));
        }


        StringBuilder sb = new StringBuilder();
        boolean[] tf = new boolean[n + 1];
        dfs(v, list, sb, tf);

        sb.append("\n");

        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        tf = new boolean[n + 1];
        tf[v] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            sb.append(node).append(" ");

            for (int i : list.get(node)) {
                if (!tf[i]) {
                    queue.add(i);
                    tf[i] = true;
                }
            }

        }

        System.out.println(sb);

    }

    private static void dfs(int v, List<List<Integer>> list, StringBuilder sb, boolean[] tf) {
        tf[v] = true;
        sb.append(v).append(" ");

        for (int i : list.get(v)) {
            if (!tf[i]) {
                dfs(i, list, sb, tf);
            }
        }

    }
}