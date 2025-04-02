import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] homes;
    static boolean[][] visited;
    static int[] x = {1,-1,0,0};
    static int[] y = {0,0,1,-1};
    static int cnt;


    public static void main(String arg[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        homes = new int[N][N];
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++){
            String[] str = br.readLine().split("");
            for (int j = 0; j < N; j++){
                homes[i][j] = Integer.parseInt(str[j]);
            }
        }
        int result = 0;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if(homes[i][j] == 1 && !visited[i][j]){
                    cnt = 0;
                    dfs(homes,N,i,j);
//                    bfs(homes,N,i,j);
                    result++;
                    list.add(cnt);
                }
            }
        }
        System.out.println(result);
        list.sort((n,m)->n-m);
        for (Integer i : list) {
            System.out.println(i);
        }

    }
    public static void bfs(int[][] homes, int N, int i, int j){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        visited[i][j] = true;
        while(!q.isEmpty()){
            int[] now = q.poll();
            cnt++;
            for(int idx = 0; idx < 4; idx++){
                int a = now[0] + x[idx];
                int b = now[1] + y[idx];
                if(a>=0 && b>=0 && a<N && b<N){
                    if(homes[a][b]==1 && !visited[a][b]){
                        q.add(new int[]{a,b});
                        visited[a][b] = true;

                    }
                }

            }

        }

    }
    public static void dfs(int[][] homes, int N, int i, int j){
        visited[i][j] = true;
        cnt++;

        for(int idx = 0; idx < 4; idx++){
            int a = i + x[idx];
            int b = j + y[idx];
            if(a>=0 && b>=0 && a<N &&b<N){
                if(!visited[a][b] && homes[a][b] == 1){
                    dfs(homes,N,a,b);
                }
            }


        }

    }


}


