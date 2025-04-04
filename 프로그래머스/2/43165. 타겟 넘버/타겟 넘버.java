import java.util.*;
class Solution {
    public int solution(int[] numbers, int target) {
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        int count = 0;
        while(!q.isEmpty()){
            int[] val = q.poll();
            int sum = val[0];
            int idx = val[1];
            
            if(idx == numbers.length){
                if(sum == target){
                    count++;
                    continue;
                }
            } else {
                q.add(new int[]{sum+numbers[idx],idx+1});
                q.add(new int[]{sum-numbers[idx],idx+1});
            }
            
        }
        
        return count;
        
    }
}
/*
    static int count;
    public int solution(int[] numbers, int target) {
        
        dfs(numbers, target, 0, numbers[0]);
        // System.out.println();

        dfs(numbers, target, 0, -numbers[0]);
        
        return count;
    }
    public void dfs(int[] numbers, int target, int idx, int sum){
        if(numbers.length-1 == idx && target == sum){
            count++;
        } else if(numbers.length-1 > idx){
            // System.out.println("idx = "+idx+" sum: "+sum);
            idx++;
            dfs(numbers, target, idx, sum + numbers[idx]);
            // System.out.println();
            dfs(numbers, target, idx, sum - numbers[idx]);
        }
        
        
    }
}
*/
