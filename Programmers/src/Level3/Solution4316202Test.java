package Level3;

public class Solution4316202Test {
    public static void main(String[] args){
        Solution4316202 s = new Solution4316202();
        int n = 5;
        int[][] computers = {{1, 1, 1, 0, 0}, {1, 1, 0, 0, 0}, {1, 0, 1, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}};
        System.out.println(s.solution(n, computers));
    }
}
