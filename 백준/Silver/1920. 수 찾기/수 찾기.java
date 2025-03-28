import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String arg[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer token = new StringTokenizer(br.readLine());
        List<Integer> arr1 = new ArrayList<>();
        for (int i = 0; i < n; i++){
            arr1.add(Integer.parseInt(token.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());
        token = new StringTokenizer(br.readLine());
        List<Integer> arr2 = new ArrayList<>();
        for (int i = 0; i < m; i++){
            arr2.add(Integer.parseInt(token.nextToken()));
        }

        Collections.sort(arr1);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++){
            sb.append(search(arr1, arr2.get(i), 0, n-1)).append("\n");
        }
        System.out.println(sb);
    }

    public static int search(List<Integer> arr, int key, int start, int end){
        if(start > end){
            return 0;
        }
        int mid = (start + end)/2;

        if( key == arr.get(mid)){
            return 1;
        } else if(key > arr.get(mid)){
            return search(arr, key, mid + 1, end);
        } else {
            return search(arr, key, start, mid - 1);
        }
    }
}



