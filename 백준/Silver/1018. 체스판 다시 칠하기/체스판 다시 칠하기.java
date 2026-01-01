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

        char[][] arr = new char[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                min = Math.min(min, paint(arr, i, j));
            }
        }
        System.out.println(min);
    }

    private static int paint(char[][] arr, int x, int y) {

        int count1 = 0;
        int count2 = 0;

        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        if (arr[i][j] == 'W') {
                            count2++;
                        } else {
                            count1++;
                        }
                    } else {
                        if (arr[i][j] == 'W') {
                            count1++;
                        } else {
                            count2++;
                        }
                    }
                } else {
                    if (j % 2 == 0) {
                        if (arr[i][j] == 'W') {
                            count1++;
                        } else {
                            count2++;
                        }
                    } else {
                        if (arr[i][j] == 'W') {
                            count2++;
                        } else {
                            count1++;
                        }
                    }
                }

            }
        }
        return Math.min(count1, count2);
    }

}
