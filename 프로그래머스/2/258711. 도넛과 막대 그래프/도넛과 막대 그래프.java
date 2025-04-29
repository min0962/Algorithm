import java.util.*;
class Solution {
    ArrayList<Integer>[] list;

    public int[] solution(int[][] edges) {

        int start = 0;

        int max = 0;
        for(int[] edge : edges){
            max = Math.max(max,Math.max(edge[0],edge[1]));
        }
        int[] inDegree = new int[max+1];
        int[] outDegree = new int[max+1];
        list = new ArrayList[max+1];
        for(int i = 0; i < max+1; i++){
            list[i] = new ArrayList<>();
        }
        for(int[] edge : edges){ // [0] -> [1]
            inDegree[edge[1]]++;
            outDegree[edge[0]]++;
            list[edge[0]].add(edge[1]);
        }
        for (int i = 0; i < max+1; i++){
            if(inDegree[i] == 0 && outDegree[i] > 1){
                start = i;
                break;
            }
        }

        int[] answer = new int[4];
        answer[0] = start;

        for(int v:list[start]){
            int n = dfs(v, v);
            answer[n]++;
        }


        return answer;
    }

    public int dfs(int start, int v){
        ArrayList<Integer> arr = list[v];
        if(arr.size() == 0){
            return 2;
        } else if(arr.size() == 2){
            return 3;
        } else if(arr.get(0) == start){
            return 1;
        } else {
            return dfs(start, arr.get(0));
        }

    }

}
