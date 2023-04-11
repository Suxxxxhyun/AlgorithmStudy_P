package Level3;

public class Solution6406202 {
    static int solution(int[] stones, int k) {
        int answer = 0;
        int min = 1;    int max = 5;
        while(min<=max){
            int mid = (min+max)/2;
            if(isCrossable(stones, k, mid)){
                min = mid+1;
                answer = Math.max(answer, mid);
            }
            else{
                max = mid-1;
            }
        }
        return answer;
    }

    static Boolean isCrossable(int[] stones, int k, int mid){
        int howFarAtOnce = 0;
        for(int num: stones){
            if(num < mid) {
                howFarAtOnce++;
            } else {
                howFarAtOnce = 0;
            }
            if(howFarAtOnce==k) {
                return false;
            }
        }
        return true;
    }
}
