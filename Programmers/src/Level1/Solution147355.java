package Level1;

public class Solution147355 {
    public long solution(String t, String p) {
        long answer = 0;

        int[] front = {0,1};

        int p_len = p.length();
        int t_len = t.length();
        long pnum = Long.parseLong(p);
        String str = "";

        for(int L = 0, R = 0; L < t_len; L++){
            int i = 1;

            while(R + 1 <= t_len && R - L < p_len) {
                str += t.charAt(R++);
            }

            long num = Long.parseLong(str);

            if(num <= pnum && R - L == p_len) {
                //System.out.println(num);
                answer++;
            }

            int len = str.length();

            if(i == 2){
                i = 0;
                str = str.substring(front[i++], len);
            } else {
                str = str.substring(front[i++], len);
            }
        }
        return answer;
    }
}
