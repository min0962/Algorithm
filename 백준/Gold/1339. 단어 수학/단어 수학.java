import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[26];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                arr[str.charAt(j) - 'A'] += Math.pow(10, str.length() - j - 1);
            }
        }

        Arrays.sort(arr);

        int result = 0;
        int num = 9;

        for (int i = 25; i >= 0; i--) {
            result += arr[i] * num;
            num--;
        }

        System.out.println(result);

    }
}