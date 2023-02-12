package Level0;

public class Solution120924 {

    static int[] a;
    public int solution(int[] common) {

        int answer = 0;
        int len = common.length;
        int[] a = common;

        if(confirm(a)){
            int gongcha = common[len-1] - common[len-2];
            answer = common[len-1] + gongcha;
        } else {
            int gongbi = common[len-1] / common[len-2];
            answer = common[len-1] * gongbi;
        }

        return answer;
    }

    //등차수열인지 아닌지 판단하는 함수
    public boolean confirm(int[] common){
        if((common[1] * 2) == common[0] + common[2]){
            //System.out.println(0);
            return true;
        } else {
            //System.out.println(1);
            return false;
        }
    }
}
