import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int m = 0; m < t; m++) {
            int k = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> minQ = new PriorityQueue<>();
            PriorityQueue<Integer> maxQ = new PriorityQueue<>(Comparator.reverseOrder());
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char op = st.nextToken().charAt(0);
                int num = Integer.parseInt(st.nextToken());

                if (op == 'I') {
                    minQ.offer(num);
                    maxQ.offer(num);
                    map.put(num, map.getOrDefault(num, 0) + 1);
                } else {
                    if (num == 1) {
                        while (!maxQ.isEmpty()) {
                            int val = maxQ.poll();
                            if (map.get(val) > 0) {
                                map.put(val, map.get(val) - 1);
                                break;
                            }
                        }
                    } else {
                        while (!minQ.isEmpty()) {
                            int val = minQ.poll();
                            if (map.get(val) > 0) {
                                map.put(val, map.get(val) - 1);
                                break;
                            }
                        }
                    }
                }
            }
            while (!maxQ.isEmpty()) {
                int val = maxQ.peek();
                if (map.get(val) > 0) {
                    break;
                }
                maxQ.poll();
            }
            while (!minQ.isEmpty()) {
                int val = minQ.peek();
                if (map.get(val) > 0) {
                    break;
                }
                minQ.poll();
            }
            if (maxQ.isEmpty()) {
                sb.append("EMPTY\n");
            } else {
                int max = maxQ.peek();
                int min = minQ.peek();
                sb.append(max).append(" ");
                sb.append(min).append("\n");
            }

        }
        System.out.println(sb);


    }

}
