import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }
        char[] dna = new char[]{'A', 'C', 'G', 'T'};
        int hd = 0;
        String ans = "";
        for (int i = 0; i < m; i++) {
            int[] countArr = new int[4];
            for (int j = 0; j < n; j++) {
                char c = arr[j].charAt(i);
                if (c == 'A') {
                    countArr[0]++;
                } else if (c == 'C') {
                    countArr[1]++;
                } else if (c == 'G') {
                    countArr[2]++;
                } else if (c == 'T') {
                    countArr[3]++;
                }
            }
            int max = 0;
            char maxChar = 'a';
            for (int j = 0; j < 4; j++) {
                if (countArr[j] > max) {
                    max = countArr[j];
                    maxChar = dna[j];
                }
            }

            hd += (n - max);
            ans += maxChar;

        }
        System.out.println(ans);
        System.out.println(hd);
    }

}

