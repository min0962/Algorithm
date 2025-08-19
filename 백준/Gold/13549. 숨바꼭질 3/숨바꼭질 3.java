import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[100001];
        Arrays.fill(visited, -1);

        queue.add(n);
        visited[n]++;

        while (!queue.isEmpty()) {
            int val = queue.poll();

            if (val == k) {
                System.out.println(visited[k]);
            }

            if (val * 2 <= 100000 && visited[val * 2] == -1) {
                queue.add(val * 2);
                visited[val * 2] = visited[val];
            }

            if (val - 1 >= 0 && visited[val - 1] == -1) {
                queue.add(val - 1);
                visited[val - 1] = visited[val] + 1;
            }

            if (val + 1 <= 100000 && visited[val + 1] == -1) {
                queue.add(val + 1);
                visited[val + 1] = visited[val] + 1;
            }


        }

    }

}
