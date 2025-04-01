import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String arg[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());
        int v = Integer.parseInt(st1.nextToken());

        ArrayList<Integer>[] arr = new ArrayList[n+1];
        boolean[] visited = new boolean[n+1];
        ArrayList<Integer> pnt = new ArrayList<>();

        for (int i = 1; i <= n; i++){
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int m1 = Integer.parseInt(st2.nextToken());
            int m2 = Integer.parseInt(st2.nextToken());

            arr[m1].add(m2);
            arr[m2].add(m1);
        }
        for (int i = 1; i <= n; i++){
            arr[i].sort((n1,n2)->n1-n2);
        }

        dfs(arr, visited, pnt, v);
        StringBuilder sb = new StringBuilder();
        for(int i : pnt){
            sb.append(i + " ");
        }
        sb.append("\n");

        Queue<Integer> queue = new LinkedList<>();
        boolean[] tf = new boolean[n+1];
        queue.add(v);
        tf[v] = true;
        while (!queue.isEmpty()){
            int nodeNum = queue.remove();
            sb.append(nodeNum + " ");
            for(int i : arr[nodeNum]){
                if(!tf[i]) {
                    queue.add(i);
                    tf[i] = true;
                }
            }
        }

        System.out.println(sb);

    }
    public static void dfs(ArrayList<Integer>[] arr, boolean[] visited, ArrayList<Integer> pnt,int v){
        visited[v] = true;
        pnt.add(v);

        for (int m : arr[v]) {
            if(!visited[m]){
                dfs(arr, visited, pnt, m);
            }
        }

    }
}



