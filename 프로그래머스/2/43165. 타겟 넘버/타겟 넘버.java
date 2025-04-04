class Solution {
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