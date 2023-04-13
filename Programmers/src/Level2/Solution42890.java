package Level2;

import java.util.*;
//https://velog.io/@yanghl98/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%ED%9B%84%EB%B3%B4%ED%82%A4-JAVA%EC%9E%90%EB%B0%94-2019-%EC%B9%B4%EC%B9%B4%EC%98%A4-%EA%B8%B0%EC%B6%9C
//블로그참조
/*
자바 깊은복사, 얕은복사 이해하고 넘어가기(13라인)
자바의 얕은복사는 주소만 복사하게 되는것이다.
따라서,
int[] a = {1,2,3,4};
int[] b = a;
b[0] = 0;

-> a배열도 b배열도 모두 출력하면 결과가 [0,2,3,4]로 나옴.
이것이 얕은복사!
 */
public class Solution42890 {

    static String[][] g_relation;	// global variable
    static HashSet<String> set; 	// 후보키가 가능한 튜플의 집합을 저장

    public static int solution(String[][] relation) {
        g_relation = relation;

        set = new HashSet<>();

        // 튜플을 1개 선택하는 방법, 2개 선택하는 방법, ...
        //이때의 파라미터 i가 max를 의미하는데 이게 뭘까?
        for (int i = 1; i <= relation[0].length; i++) {
            boolean[] selected = new boolean[relation[0].length];
            dfs(0, 0, i, selected);
        }

        return set.size(); // 가능한 후보키의 개수 리턴
    }

    public static void dfs(int idx, int cnt, int max, boolean[] selected){
        if(cnt==max){

            // 선택된 colume들을 string으로 만듬
            // 2번째, 4번째 colume들이 선택되었다면 cols="24"
            String cols = "";
            for (int i = 0; i < selected.length; i++) {
                if(selected[i]){
                    cols += i;
                }
            }

            // 선택된 colume들의 집합이 후보키로 사용 가능한지 확인
            if(findIsPossible(cols, selected)){
                set.add(cols);
            }
            return;
        }

        if(idx>=selected.length) return;

        selected[idx] = true;
        dfs(idx + 1, cnt + 1, max, selected);

        selected[idx] = false;
        dfs(idx + 1, cnt, max, selected);
    }

    public static boolean findIsPossible(String cols, boolean[] selected) {

        // 최소성이 만족되는지 확인
        // cols 안에 set에 들어있는 `후보키가 가능한 colume들의 집합의 요소들`이 모두 포함되어있는지 확인
        for (String s : set) {
            boolean flag = true;
            for (int i = 0; i < s.length(); i++) {
                if(!cols.contains(s.charAt(i)+"")){
                    flag = false;
                }
            }

            if(flag){ // 모두 포함되어있으면
                return false;
            }
        }

        // 몇번 colume들을 확인해야하는지 처리
        // 예를 들어, cols가 24라면 (== 2, 4번 colume 집합이 후보키가 되는지 확인해야 한다면)
        // col_name[] = {2,4} 가 된다.
        HashSet<String> values = new HashSet<>();
        int[] col_name = new int[cols.length()];
        int idx = 0;
        for (int i = 0; i < selected.length; i++) {
            if(selected[i]){
                col_name[idx++] = i;
            }
        }

        // 값의 중복이 있는지 확인. 중복된 값이 있다면 후보키로 사용될 수 없음
        String value = "";
        for (int i = 0; i < g_relation.length; i++) {
            value = "";
            for (int j = 0; j < col_name.length; j++) {
                value += g_relation[i][col_name[j]];
            }
            if(values.contains(value)){
                return false; // 중복이 없다면 false 리턴
            }else{
                values.add(value);
            }
        }

        return true;
    }
}
