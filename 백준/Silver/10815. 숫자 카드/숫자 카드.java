import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String arg[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer token = new StringTokenizer(br.readLine());
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < n; i++) {
            hs.add(Integer.parseInt(token.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());
        token = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            if (hs.contains(Integer.parseInt(token.nextToken()))) {
                sb.append("1 ");
            } else {
                sb.append("0 ");
            }

        }

        System.out.println(sb);
    }

}



