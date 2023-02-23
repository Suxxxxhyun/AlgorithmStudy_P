package Level1;

import java.util.*;

class Solution42748 {

    public int[] solution(int[] array, int[][] commands) {

        int[] answer = new int[commands.length];

        for(int c=0; c<commands.length; c++){
            int i = commands[c][0];
            int j = commands[c][1];
            int k = commands[c][2];
            int num = pro(i-1,j-1,k-1,array);
            answer[c] = num;
        }
        return answer;
    }

    public int pro(int i, int j, int k, int[] array){
        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int a=0; a<array.length; a++){
            if(a >= i && a <= j){
                list.add(array[a]);
            }
        }

        Collections.sort(list);
        System.out.println(list);
        return list.get(k);
    }
}
