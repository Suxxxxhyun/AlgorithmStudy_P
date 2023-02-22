package Level2;

//https://hyojun.tistory.com/entry/Programmers-%ED%83%80%EA%B2%9F-%EB%84%98%EB%B2%84-Java 블로그 참조
public class Solution43165 {

    int answer = 0;
    public int solution(int[] numbers, int target) {

        dfs(numbers,0,target,0);
        return answer;
    }

    //깊이우선탐색
    public void dfs(int[] numbers, int depth, int target, int sum){
        if(depth == numbers.length){
            if(target == sum){
                answer++;
            } else {
                dfs(numbers, depth + 1, target, sum + numbers[depth]); // 해당 노드의 값을 더하고 다음 깊이 탐색
                dfs(numbers, depth + 1, target, sum - numbers[depth]); // 해당 노드의 값을 빼고 다음 깊이 탐색
            }
        }
    }
}
