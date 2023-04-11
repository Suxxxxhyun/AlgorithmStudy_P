package Level2;

//3:40 ~ 4:00
//몸무게가 가장 큰 사람과 가장 작은 사람의 조합으로 진행한다.
//limit이 100이면서 [30, 40, 50, 60]로 주어진 경우, [30,60]/[40,50] 총 구명보트는 2개가 필요.
//순서대로 생각해주면 안됨. 처음 설명처럼, '몸무게가 가장 큰 사람과 가장 작은 사람의 조합'이 중요.

//https://velog.io/@ajufresh/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EA%B5%AC%EB%AA%85%EB%B3%B4%ED%8A%B8-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-Java
//참조.
import java.util.*;
class Solution42885 {

    int answer = 0;

    public int solution(int[] people, int limit) {

        Arrays.sort(people);

        int min = 0;

        for (int max = people.length - 1; min <= max; max--){
            if (people[min] + people[max] <= limit) {
                min++;
            }
            answer++;
        }
        return answer;
    }
}
