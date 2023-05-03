package Level3;

public class Solution64062Test {
    public static void main(String[] args){
        /*Loop1 : for(int i=2; i<=9; i++){
            for(int j=1; j<=9; j++){
                if(j==5){
                    //break Loop1;
                    //break;
                    //continue;
                    continue Loop1;
                }
            }
            System.out.println("break");
        }
        System.out.println("j가 5였을때 빠져나오려나?");*/
        //Solution64062 s = new Solution64062();
        int[] stones = {2,4,5,3,2,1,4,2,5,1};
        //System.out.println(s.solution(stones,3));
        Solution6406202 s2 = new Solution6406202();
        System.out.println(s2.solution(stones,3));
    }
}
