import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            sb.append(lcm(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())))
                .append("\n");
        }

        System.out.println(sb);

    }

    private static long lcm(int a, int b) {
        long x = a;
        long y = b;
        while (x != y) {
            if (x > y) {
                y += b;
            } else {
                x += a;
            }
        }
        return x;
    }

}