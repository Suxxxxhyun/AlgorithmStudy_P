package Level1;

import java.util.*;

class Solution142086 {

    ArrayList<Integer> answer = new ArrayList<Integer>();
    //location의 []idx는 알파벳, ArrayList로 넣어주는 것은 a처럼 중복되는 값이 있을때
    ArrayList<Integer>[] location;
    boolean[] visited;

    public ArrayList<Integer> solution(String s) {

        location = new ArrayList[26];
        visited = new boolean[26];
        for(int i=0; i<location.length; i++){
            location[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<s.length(); i++){
            if(!visited[s.charAt(i) - 'a']){
                visited[s.charAt(i) - 'a'] = true;
                location[s.charAt(i) - 'a'].add(i);
                answer.add(-1);
            } else {
                int size = location[s.charAt(i) - 'a'].size();
                int x = location[s.charAt(i) - 'a'].get(size - 1);
                //System.out.println(s.charAt(i) - 'a' + "," + x + "," + size);
                location[s.charAt(i) - 'a'].add(i);
                answer.add(i - x);
            }
        }
        return answer;
    }
}
