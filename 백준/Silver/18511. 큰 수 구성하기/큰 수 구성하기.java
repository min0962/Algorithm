import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int n, k;
    static int[] arr;
    static ArrayList<Integer> list;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[k];

        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        list = new ArrayList<>();
        dfs(0);
        System.out.println(max);
    }

    private static void dfs(int num) {
        if (num > n) {
            return;
        }
        max = Math.max(max, num);

        for (int i = 0; i < k; i++) {
            dfs(num * 10 + arr[i]);
        }

    }
}

