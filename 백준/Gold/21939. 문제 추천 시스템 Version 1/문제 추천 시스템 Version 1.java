import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> pqAsc = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) {
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        });
        PriorityQueue<int[]> pqDesc = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) {
                return b[1] - a[1];
            } else {
                return b[0] - a[0];
            }
        });

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int[] val = new int[]{p, l};
            map.put(p, l);
            pqAsc.offer(val);
            pqDesc.offer(val);
        }

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "recommend": {
                    int x = Integer.parseInt(st.nextToken());
                    if (x == 1) {
                        while (!pqDesc.isEmpty()) {
                            int key = pqDesc.peek()[0];
                            int l = pqDesc.peek()[1];
                            if (map.get(key) == l) {
                                sb.append(key);
                                break;
                            }
                            pqDesc.poll();
                        }
                    } else {
                        while (!pqAsc.isEmpty()) {
                            int key = pqAsc.peek()[0];
                            int l = pqAsc.peek()[1];
                            if (map.get(key) == l) {
                                sb.append(key);
                                break;
                            }
                            pqAsc.poll();
                        }
                    }
                    sb.append("\n");
                    break;
                }
                case "add": {
                    int p = Integer.parseInt(st.nextToken());
                    int l = Integer.parseInt(st.nextToken());
                    int[] val = new int[]{p, l};
                    map.put(p, l);
                    pqAsc.offer(val);
                    pqDesc.offer(val);
                    break;
                }
                case "solved": {
                    int p = Integer.parseInt(st.nextToken());
                    map.put(p, 0);
                    break;
                }
            }
        }
        System.out.println(sb);
    }

}
