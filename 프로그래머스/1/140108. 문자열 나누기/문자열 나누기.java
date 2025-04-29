import java.util.*;

class Solution {
    public int solution(String s) {
        int count = 0;
        int tCnt = 1;
        int fCnt = 0;
        char x = s.charAt(0);
        boolean tf = false;

        for(int i = 1; i < s.length(); i++){
            if(tf){
                x = s.charAt(i);
                tCnt = 1;
                fCnt = 0;
                tf = false;
                System.out.println("if문 진입 : x = "+ x);
                continue;
            }

            char y = s.charAt(i);

System.out.println("x = " + x + ", y = " + y);

            if(x == y){
                tCnt++;
            } else{
                fCnt++;
            }
            if(tCnt == fCnt){
                tf = true;
                count++;
                System.out.println("count = "+count+"\n");
            }
        }
        if(tCnt != fCnt){
            count ++;
        }

        return count;
    }
}