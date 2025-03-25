import java.util.Stack;
class Solution {
    public int[] solution(long n) {
        int[] answer = {};
        Stack<Integer> st = new Stack<>();
        
        while(n > 0){
            int m = (int)(n % 10);
            n = n / 10;
            st.push(m);

        }
        answer = new int[st.size()];
        for(int i = st.size()-1; i >= 0; i--){
            answer[i] = st.pop();
        }
        return answer;
    }
}