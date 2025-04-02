import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int M, N;
    static int[][] cabbage;
    static boolean[][] tf;
    public static void main(String arg[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < t; i++){
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st1.nextToken());
            N = Integer.parseInt(st1.nextToken());
            int k = Integer.parseInt(st1.nextToken());
            cabbage = new int[N][M];
            tf = new boolean[N][M];
            for(int j = 0; j < k; j++){
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st2.nextToken());
                int y = Integer.parseInt(st2.nextToken());
                cabbage[y][x] = 1;
            }
            int cnt = 0;
            for (int n = 0; n < N; n++){
                for (int m = 0; m < M; m++){
                    if(cabbage[n][m] == 1 && !tf[n][m]){
                        dfs(cabbage,n,m);
                        cnt++;
                    }

                }

            }
            sb.append(cnt+"\n");
        }
        System.out.println(sb);

    }
    public static void dfs(int[][] arr, int n, int m){
        tf[n][m] = true;
        if(n+1 < N){
            if(!tf[n+1][m] & arr[n+1][m]==1){
                dfs(arr,n+1,m);
            }
        }
        if(n-1 >= 0){
            if(!tf[n-1][m] & arr[n-1][m]==1){
                dfs(arr,n-1,m);
            }
        }
        if(m+1 < M){
            if(!tf[n][m+1] & arr[n][m+1]==1){
                dfs(arr,n,m+1);
            }
        }
        if(m-1 >= 0){
            if(!tf[n][m-1] & cabbage[n][m-1]==1){
                dfs(arr,n,m-1);
            }
        }


    }
}



