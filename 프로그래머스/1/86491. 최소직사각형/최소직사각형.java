class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int left, right;
        int a = sizes[0][0];
        int b = sizes[0][1];
        if(a > b){
            left = a;
            right = b;
        }else{
            left = b;
            right = a;
        }
        
        for(int i = 1; i < sizes.length; i++){
            a = sizes[i][0];
            b = sizes[i][1];
            
            int temp;
            if(a < b){
                temp = a;
                a = b;
                b = temp;
            }
            if(a > left){
                left = a;
            }
            if(b > right){
                right = b;
            }

        }
        
        
        return left*right;
    }
}