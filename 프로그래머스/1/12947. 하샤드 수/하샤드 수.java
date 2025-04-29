class Solution {
    public boolean solution(int x) {
        int xVal = x;
        int sum = 0;

        while(xVal > 0){
            sum += xVal % 10;
            xVal /= 10;
        }
        
        return (x%sum == 0);
    }
}