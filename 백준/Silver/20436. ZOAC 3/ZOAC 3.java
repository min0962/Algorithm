import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<int[]> arr = new ArrayList<>();
        arr.add(new int[]{1, 0, 1});
        arr.add(new int[]{2, 4, 2});
        arr.add(new int[]{2, 2, 1});
        arr.add(new int[]{1, 2, 1});
        arr.add(new int[]{0, 2, 1});

        arr.add(new int[]{1, 3, 1}); //f
        arr.add(new int[]{1, 4, 1});
        arr.add(new int[]{1, 5, 2});
        arr.add(new int[]{0, 7, 2});
        arr.add(new int[]{1, 6, 2});

        arr.add(new int[]{1, 7, 2}); // k
        arr.add(new int[]{1, 8, 2});
        arr.add(new int[]{2, 6, 2});
        arr.add(new int[]{2, 5, 2});
        arr.add(new int[]{0, 8, 2});

        arr.add(new int[]{0, 9, 2}); // p
        arr.add(new int[]{0, 0, 1});
        arr.add(new int[]{0, 3, 1});
        arr.add(new int[]{1, 1, 1});
        arr.add(new int[]{0, 4, 1});

        arr.add(new int[]{0, 6, 2}); //u
        arr.add(new int[]{2, 3, 1});
        arr.add(new int[]{0, 1, 1});
        arr.add(new int[]{2, 1, 1});
        arr.add(new int[]{0, 5, 2});

        arr.add(new int[]{2, 0, 1});

        StringTokenizer st = new StringTokenizer(br.readLine());
        String le = st.nextToken();
        String ri = st.nextToken();
        String str = br.readLine();

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            int[] arr2;
            int[] arr3 = arr.get(str.charAt(i) - 'a');

            if (arr3[2] == 1) {
                arr2 = arr.get(le.charAt(0) - 'a');
                le = String.valueOf(str.charAt(i));
            } else {
                arr2 = arr.get(ri.charAt(0) - 'a');
                ri = String.valueOf(str.charAt(i));
            }
            count += Math.abs(arr2[0] - arr3[0]) + Math.abs(arr2[1] - arr3[1]) + 1;
        }

        System.out.println(count);


    }

}