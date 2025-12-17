import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine().split("\\.")[1];
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }

        List<String> keys = new ArrayList<>(map.keySet());
        keys.sort(Comparator.naturalOrder());

        StringBuilder sb = new StringBuilder();

        for (String str : keys) {
            sb.append(str).append(" ").append(map.get(str)).append("\n");
        }
        System.out.println(sb);
    }

}