package Level3;

public class Solution43162Test {
    public static void main(String[] args){
        Solution43162 s = new Solution43162();
        int n = 5;
        int[][] computers = {{1, 1, 1, 0, 0}, {1, 1, 0, 0, 0}, {1, 0, 1, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}};
        System.out.println(s.solution(n, computers));
    }
}
